<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<script src="/resources/js/uploadfn.js" type="text/javascript"></script>
	
	<title>Insert title here</title>
	<style type="text/css">
		.fileDrop {
			width: 80%;
			height: 200px;
			border: 1px solid red;
			margin: auto; /* 가운데정렬 */
		}
		
		.uploadedList {
			margin-top: 50px;
		}
		
		.uploadedList li { /*  리스트에 불릿을 없애줬다 ! */
			list-style: none;  
		}
		
		.orifilename {
			overflow: hidden;
			white-space: nowrap;
			text-overflow: ellipsis;
		}
	</style>
</head>
<body>

	<div class="container">
		<div class="row text-center">
			<h1>글쓰기</h1>
		</div>
		<div class="row">
			<form action="/board/insert" method="post">
				<div class="form-group">
					<label for="title">제목</label>
					<input name="title" id="title" class="form-control">
				</div>
				<div class="form-group">
					<label for="writer">작성자</label>
					<input name="writer" id="writer" class="form-control">
				</div>
				<div class="form-group">
					<label for="content">내용</label>
					<textarea rows="5" name="content" id="content" class="form-control"></textarea>
				</div>
			</form>
			<div class="form-group">
				<label>업로드할 파일을 드랍시키세요</label>
				<div class="fileDrop"></div>
				<ul class="uploadedList clearfix"></ul> <!-- 사진 위로 침범방지 -->
			</div>
			<div class="form-group">
				<button class="btn btn-primary" id="insertbtn">등록</button>
				<button class="btn btn-primary" id="listbtn">목록</button>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#insertbtn").click(function(event){			
				event.preventDefault();

				var str = '';

				$(".deletefile").each(function(index){ <!-- 클래스로 들어간애들은 여러개가 있으면 배열로 받는다 each는 반복문 -->
					str += "<input name='files[" + index + "]' value='" + $(this).attr("href") + "' type='hidden'>";  <!-- 여기서 this는  받아온 클래스 정보가 된다! -->
					
				});
				


				$("form").append(str);
				$("form").submit();
			});
			
			$("#listbtn").click(function(){
				location.assign("/board/list");
			});

			$(".fileDrop").on("dragenter dragover", function(event){<!-- 이벤트여러개!  -->
				event.preventDefault();
			});

			$(".fileDrop").on("drop", function(event){ <!-- 파일드랍했을때 아무 동작도 안하게!  -->
				event.preventDefault();
	
				var files = event.originalEvent.dataTransfer.files;
	
				var file = files[0];
	
				var formData = new FormData();
				formData.append("file", file); <!-- for문을 돌려서 여러개 할수있음! 방법은 모름! 생각하셈! -->
	
				$.ajax({
					type : 'post',
					url : '/uploadajax',
					dataType : 'text',
					data : formData,
					processData : false,
					contentType: false,
					success : function(result) {
	
						var str = '<li class="col-xs-4">';
						str += '<a href="/displayfile?filename=' + getImageLink(result) + '">';
						if(checkImage(result)) {
							str += '<img src="/displayfile?filename=' + result + '"/>';
						} else {
							str += '<img src="/resources/show.png"/>';
						}						
						str += '</a>';
						str += '<p class="orifilename">';
						str += '<a class="deletefile" href="' + result + '"><span class="glyphicon glyphicon-trash"></span></a>';
						str += getOriginalName(result);
						str += '</p>';
						str += '</li>';
					
						
						$(".uploadedList").append(str);
	
						
					}
				});
				
			});	

			$(".uploadedList").on("click", ".deletefile", function(event){
				event.preventDefault();
				var that = $(this);
	
				$.ajax({
					type : 'post',
					url : '/deletefile',
					dataType : 'text',
					data : {
						filename : $(this).attr("href")
					},
					success : function(result){
						that.parent("p").parent("li").remove();
					}
				});
			});

		});
	</script>
	

</body>
</html>
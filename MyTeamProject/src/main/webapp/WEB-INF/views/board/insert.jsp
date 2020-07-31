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
	<c:if test="${empty login}">
		<script>alert('로그인이 필요한 화면입니다. 로그인 페이지로 이동합니다.'); location.href='/member/login'; </script>
	</c:if>
	<style type="text/css">
		.fileDrop {
		width: 80%;
		height: 200px;
		border: 1px solid red;
		margin: auto;
		}
		.uploadedList {
			margin-top: 50px;
		}
		.uploadedList li {
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
			<form action="/board/insert" method="post" class="insertForm">
				<div class="form-group">
					<label for="title">제목</label>
					<input name="title" id="title" class="form-control">
				</div>
				<select id="select1" onchange="javascript:itemChange(this);" name="cno">
					<option value="none">카테고리</option>
					<c:forEach items="${categoryList}" var="categoryDTO">
						<option value="${categoryDTO.cno}">${categoryDTO.cname}</option>
					</c:forEach>
				</select>
				<select id="select2" name="gno">
					<option value="none">종류</option>
				</select>
			</form>
			<div class="form-group">
				<label>첨부파일</label>
				<div class="fileDrop"></div>
				<ul class="uploadedList clearfix"></ul>
			</div>
			<div class="form-group">
				<button class="btn btn-primary" id="insertbtn">등록</button>
				<button class="btn btn-primary" id="mainPagebtn">등록</button>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		function itemChange(obj) {
			var cno = obj.value;
			if (cno == 'none') {
				return false;
			}
			$.ajax({
				type : 'post',
				url : '/board/selectGoods',
				dataType : 'text',
				data : {
					cno : cno
				},
				success : function(result){
					
					var obj = JSON.parse(result);

					$('#select2').empty();
					var str = "";
					
					
						str += "<option value='none'>종류</option>";
					for (var i = 0; i < obj.length; i++) {
						str += '<option value="' + obj[i]["gno"] + '">' + obj[i]["gname"] +'</option>';
					}
					$("#select2").append(str);
				}
			})
		}
		
		$(document).ready(function(){
			$("#insertbtn").click(function(event){
				event.preventDefault();
				
				if($("#title").val()==""){
					alert("제목을 입력해주세요.");
					$("#title").focus();
					return false;
				}
				if($("#select1").val()=="none"){
					alert("카테고리를 선택해주세요.");
					$("#select1").focus();
					return false;
				}
				if($("#select2").val()=="none"){
					alert("종류를 선택해주세요.");
					$("#select2").focus();
					return false;
				}
				
				var str = '';
	
				$(".deletefile").each(function(index){
					str += "<input name='files[" + index + "]' value='" + $(this).attr("href") + "' type='hidden'>";
				});
	
				$("form").append(str);
				$("form").submit();
			});

			$("#mainPagebtn").click(function(){
				location.assign("/board/mainPage");
			});

			$(".fileDrop").on("dragenter dragover", function(event){
				event.preventDefault();
			});

			$(".fileDrop").on("drop", function(event){
				event.preventDefault();

				var files = event.originalEvent.dataTransfer.files;

				var file = files[0];

				var formData = new FormData();
				formData.append("file", file);

				$.ajax({
					type : 'post',
					url : '/uploadajax',
					dataType : 'text',
					data : formData,
					processData : false,
					contentType : false,
					success : function(result) { // result = savefilename

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
						str += '</p';
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
					success : function(result) {
						that.parent("p").parent("li").remove();
					}
				})
			});


			
		});
	</script>

</body>
</html>
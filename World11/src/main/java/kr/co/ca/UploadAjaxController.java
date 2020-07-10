package kr.co.ca;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.utils.Utils;

@Controller
public class UploadAjaxController {
	
	private String uploadPath = "C:" + File.separator + "upload";
	
	@RequestMapping(value = "/uploadajax", method = RequestMethod.GET)
	public void uploadajax () {

	}
	
	@ResponseBody
	@RequestMapping(value = "/uploadajax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String uploadajax (MultipartHttpServletRequest request) throws Exception {
		
		MultipartFile file = request.getFile("file");
		String originalName = file.getOriginalFilename();
		
		String saveFileName = Utils.saveFile(originalName, file, uploadPath);
		System.out.println(saveFileName);
		
		return saveFileName;
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/displayfile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayfile(String filename) {// 이미지파일 데이터를 바이트 배열로 보내준다!
		ResponseEntity<byte[]> entity = null;
		
		InputStream in = null;
		
		try {
			int idx = filename.lastIndexOf(".");
			String format = filename.substring(idx + 1);
			
			MediaType mType = Utils.getmediaType(format); //이미지파일 여부확인
			
			in = new FileInputStream(uploadPath + filename); // 파일객체넣어도되고 문자열넣어도됨 자바클래스와 업로드폴더에 있는 썸네일하고 스트림연결해주는코드
			
			HttpHeaders headers = new HttpHeaders();
			
			if (mType != null) {
				headers.setContentType(mType); // 헤더에서 mType 지정
			} else {
				idx = filename.indexOf("_");
				String originalName = filename.substring(idx + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment;filename=\"" + new String(originalName.getBytes("UTF-8"), "ISO-8859-1") + "\""); // getbytes 브라우저가 사용하고 있는 인코딩 방식으로 바꿔주는거임 
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK); // IOUtils.toByteArray(in) 이미지 태그 소스에다가 데이터 넣어주는코드 2번째는 헤더스 3번쨰는 통신상태코드 
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST); // 통신상태 코드만 넘겨주고 끝냄 
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deletefile", method = RequestMethod.POST) 
	public String deletefile(String filename) {
		
		filename.replace('/', File.separatorChar);
		
		int idx = filename.lastIndexOf(".");
		String format = filename.substring(idx + 1);
		MediaType mType = Utils.getmediaType(format);
		
		if (mType != null) {
			String pre = filename.substring(0, 12);
			String suf = filename.substring(14);
			
			String oriname = pre + suf;
			File oriFile = new File(uploadPath + oriname);
			oriFile.delete();
		} 
			File f1 = new File(uploadPath + filename);
			f1.delete();			
		
		
		
		
		
		

		
		
		return "success";
	}
}

package kr.co.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class Utils {
	public static String toKor(String msg) {
		if (msg != null) {
			try {
				return new String(msg.getBytes("8859_1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return null;
			}
		
		}
		return null;
			
	}
	
	public static String makeNewName(String originalName) {
		UUID uid = UUID.randomUUID();
		String newName = uid.toString() + "_" + originalName;
		
		
		
		return newName;
	}
	
	public static String saveFile(String originalName, MultipartFile file, String uploadPath) throws Exception {
		String newName = Utils.makeNewName(originalName); // 랜덤한 이름을 가지게 했음! 중복안되게!
		String datePath = Utils.makeDir(uploadPath);

		File target = new File(uploadPath + datePath, newName);
		
		FileCopyUtils.copy(file.getBytes(), target); // target에 file을 넣는다!
		
		boolean isImgFile = isImg(originalName);
		
		if(isImgFile) {
			return makeThumbnail(uploadPath, datePath, newName);
		} else { // 이미지파일이 아닐떄 
			String beforChangeName = datePath + File.separator + newName;
			return beforChangeName.replace(File.separatorChar, '/');
		}
		
	}
	
	public static int[] getDateInfo() {
		Calendar cal = Calendar.getInstance();  //캘린더 객체 생성
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		int[] arr = {year, month, date};
		return arr;
	}
	
	public static String[] makeDirName() {
		int[] arr = Utils.getDateInfo();
		
		String yearPath = File.separator + arr[0];
		String monthPath = yearPath + File.separator + String.format("%02d", arr[1]); //%2d 두자리 정수 비어있는공간에 0으로 채워넣겠다! 
		String dataPath = monthPath + File.separator + String.format("%02d", arr[2]);
		
		String[] paths = {yearPath, monthPath, dataPath};
		return paths;
	}
	
	public static String makeDir(String uploadPath) {
		String[] paths = Utils.makeDirName();
		
		File f = new File(uploadPath + paths[2]);
		if (f.exists()) { // 폴더가 있냐?! 있으면 리턴해!
			return paths[2];
		}
		
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			if (!dirPath.exists()) { // 폴더가 있냐? 어 없어 그럼 만들어줘!
				dirPath.mkdir();
			}
		}
		return paths[2];
	}
	
	public static boolean isImg(String filename) {
		
		int idx = filename.lastIndexOf("."); // 확장자없애주려고
		String format = filename.substring(idx + 1);
		
		MediaType mType = getmediaType(format);
		
		if (mType != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String makeThumbnail(String uploadPath, String datePath, String newName) throws Exception {
		
		File f1 = new File(uploadPath + datePath, newName);
		BufferedImage sourceImg = ImageIO.read(f1); // f1을 읽어온다! 원본 파일을 읽어온다! 램에다가 저장하고있는거임 지금
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_EXACT, 100); // 원본 이미지를 100크기로 맞춰달라는거임! 오토매틱은 알아서 맞춰라!
		
		String thumbnailName = uploadPath + datePath + File.separator + "s_" + newName;
		File newFile = new File(thumbnailName);
		
		int idx = newName.lastIndexOf(".");
		String format = newName.substring(idx + 1).toUpperCase();
		
		ImageIO.write(destImg, format, newFile); // destImg를 이 format형태로 newFile에 이런이런 이름으로 저장하시오
		
		
	
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/'); // 문자열의 최대인덱스 = 문자열의 길이 -1 File.separatorChar는 문자열로나옴
	}

	public static MediaType getmediaType(String format) {
		Map<String, MediaType> map = new HashMap<String, MediaType>();
		map.put("JPG", MediaType.IMAGE_JPEG);
		map.put("JPEG", MediaType.IMAGE_JPEG);
		map.put("PNG", MediaType.IMAGE_PNG);
		map.put("GIF", MediaType.IMAGE_GIF);
		
		MediaType mType = map.get(format.toUpperCase());
		return mType;
	}
}

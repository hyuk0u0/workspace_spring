package kr.co.ca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.domain.MemberDTO;

@Controller
public class AjaxTestController {
	
	
	
	@RequestMapping(value = "at1", method = RequestMethod.GET)
	public void at1() {
		
	}
	
	@ResponseBody // ajax 통신을 하는 애구나!
	@RequestMapping(value = "at1", method = RequestMethod.POST)
	public String at1(String msg) {
		
		return msg + "!!!";
	}
	
	@RequestMapping(value = "at2", method = RequestMethod.GET)
	public void at2() {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "at2", method = RequestMethod.POST)
	public String[] at2(String[] arr) {
		for(String x : arr) {
			System.out.println(x);
		}
		return 	arr;
	}
	
	@RequestMapping(value = "at3", method = RequestMethod.GET)
	public void at3() {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "at3", method = RequestMethod.POST)
	public MemberDTO at3(MemberDTO  dto) {
		
		return dto;
	}
	
	@RequestMapping(value = "at4", method = RequestMethod.GET)
	public void at4() {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "at4", method = RequestMethod.POST)
	public List<Map<String, Object>> at4(@RequestParam Map<String, Object> map) throws Exception {
		String jsonStr = map.get("listStr").toString();
		
		ObjectMapper mapper = new ObjectMapper();
		 List<Map<String, Object>> list = mapper.readValue(jsonStr, new TypeReference<ArrayList<Map<String, Object>>>() { 
		 });
		 
		 for(Map<String, Object> m : list) {
			 System.out.println(":::::::::::::::::::::::");
			 System.out.println(m.get("id"));
			 System.out.println(m.get("name"));
			 System.out.println(m.get("age"));
			 System.out.println(":::::::::::::::::::::::");
		 }
		 
		 return list;
	}
	
	
}

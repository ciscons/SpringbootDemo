package com.simple.basic.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@Value("${project.upload.path}")
	private String uploadPath;
	
	//폴더 생성함수
	public String makeFolder() {
		//java simple date format를 사용해도 된다.
		String path = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMM"));
		File file = new File(uploadPath + "\\" + path);
		if(file.exists() == false) {
			//폴더 생성
			//mkdirs는 위에 있는 애들까지 다 만들어주는 옵션이다.
			file.mkdirs();
		}
		return path;
	}
	
	//upload 화면
	@GetMapping("/upload")
	public void upload() {
		
	}
	
	//일반 업로드
	@PostMapping("/upload_ok")
	public String upload_ok(@RequestParam("file") MultipartFile file) {
		//실제 파일명 (브라우저 별로 조금씩 다를 수 있음)
		String origin = file.getOriginalFilename();
		//저장할 파일명 (경로가 \\가 들어오는 경우 잘라서 처리한다.)	
		String filename = origin.substring(origin.lastIndexOf("\\") + 1);
		//파일 사이즈
		long size = file.getSize() / 1024;
		//랜덤이름
		String uuid = UUID.randomUUID().toString();
		//윈도우는 한 폴더에 65,500개 정도까지만 저장할 수 있다, 위에서 폴더 만드는 메소드 만든 뒤 호출
		//날짜 경로
		String path = makeFolder();
		
		//업로드 경로
		String savePath = uploadPath + "\\" + path + "\\" + uuid + "_" + filename;
		
		System.out.println(filename);
		System.out.println(size + "KB");
		System.out.println(uuid);
		System.out.println(savePath);
		
		try {
			File saveFile = new File(savePath);
			file.transferTo(saveFile);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("업로드 중 에러 발생");
		}
		
		return "upload/upload_ok";
	}
	
	//multiple 옵션
	@PostMapping("/upload_ok2")
	public String upload_ok2(MultipartRequest files) {
		List<MultipartFile> list = files.getFiles("file"); //화면에서 넘어오는 name 속성의 값, VO 형태로 들어감

		for(MultipartFile file : list) {
			//실제 파일명 (브라우저 별로 조금씩 다를 수 있음)
			String origin = file.getOriginalFilename();
			//저장할 파일명 (경로가 \\가 들어오는 경우 잘라서 처리한다.)	
			String filename = origin.substring(origin.lastIndexOf("\\") + 1);
			//파일 사이즈
			long size = file.getSize() / 1024;
			//랜덤이름
			String uuid = UUID.randomUUID().toString();
			//윈도우는 한 폴더에 65,500개 정도까지만 저장할 수 있다, 위에서 폴더 만드는 메소드 만든 뒤 호출
			//날짜 경로
			String path = makeFolder();
			
			//업로드 경로
			String savePath = uploadPath + "\\" + path + "\\" + uuid + "_" + filename;
			
			System.out.println(filename);
			System.out.println(size + "KB");
			System.out.println(uuid);
			System.out.println(savePath);
			
			try {
				File saveFile = new File(savePath);
				file.transferTo(saveFile);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("업로드 중 에러 발생");
			}
		}
		
		return "upload/upload_ok";
	}
	
	//복수 태그를 이용한 여러 파일 업로드
	@PostMapping("/upload_ok3")
	public String upload_ok3(@RequestParam("file") List<MultipartFile> list) {
		
		//람다식 필더, 초보자는 하기 힘들다.
		//null인 파일은 올라가지 않는다.
		list = list.stream().filter( (f) -> !f.isEmpty() ).collect( Collectors.toList() );
		
		for(MultipartFile file : list) {
			//실제 파일명 (브라우저 별로 조금씩 다를 수 있음)
			String origin = file.getOriginalFilename();
			//저장할 파일명 (경로가 \\가 들어오는 경우 잘라서 처리한다.)	
			String filename = origin.substring(origin.lastIndexOf("\\") + 1);
			//파일 사이즈
			long size = file.getSize() / 1024;
			//랜덤이름
			String uuid = UUID.randomUUID().toString();
			//윈도우는 한 폴더에 65,500개 정도까지만 저장할 수 있다, 위에서 폴더 만드는 메소드 만든 뒤 호출
			//날짜 경로
			String path = makeFolder();
			
			//업로드 경로
			String savePath = uploadPath + "\\" + path + "\\" + uuid + "_" + filename;
			
			try {
				File saveFile = new File(savePath);
				file.transferTo(saveFile);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("업로드 중 에러 발생");
			}
		}
		
		return "upload/upload_ok";
	}
	
	//비동기 업로드
	//여기는 RESTController가 아니라 일반 Controller 어노테이션이기 때문에 ResponseBody 어노테이션을 별도로 설정해줘야 한다.
	//화면으로부터 JSON 형식의 데이터가 넘어오는 경우 RequestBody가 항상 있어야 한다. 지금은 Form 데이터 형식으로 넘어오기 때문에 상관없음
	@ResponseBody
	@PostMapping("/upload_ok4")
	public String uplolad_ok4(@RequestParam("writer") String writer,
							  @RequestParam("file") MultipartFile file) {
	
		//실제 파일명 (브라우저 별로 조금씩 다를 수 있음)
		String origin = file.getOriginalFilename();
		//저장할 파일명 (경로가 \\가 들어오는 경우 잘라서 처리한다.)	
		String filename = origin.substring(origin.lastIndexOf("\\") + 1);
		//파일 사이즈
		long size = file.getSize() / 1024;
		//랜덤이름
		String uuid = UUID.randomUUID().toString();
		//윈도우는 한 폴더에 65,500개 정도까지만 저장할 수 있다, 위에서 폴더 만드는 메소드 만든 뒤 호출
		//날짜 경로
		String path = makeFolder();
		
		//업로드 경로
		String savePath = uploadPath + "\\" + path + "\\" + uuid + "_" + filename;
		
		try {
			File saveFile = new File(savePath);
			file.transferTo(saveFile);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("업로드 중 에러 발생");
		}
		
		return "success";
	}
	
}

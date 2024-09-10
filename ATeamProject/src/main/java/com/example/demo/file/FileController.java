package com.example.demo.file;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.course.Course;
import com.example.demo.course.CourseService;
import com.example.demo.lecture.Lecture;
import com.example.demo.member.Member;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FileController {
	
	@Autowired
	FilesService filesService;
	CourseService cs;
	
	public void thumbfileInsert(HttpServletRequest request, MultipartFile files, Course r) throws Exception{
		Files file = new Files();

		String sourceFileName = files.getOriginalFilename();
		String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
		File destinationFile;
		String destinationFileName;
		String fileUrl = "C:\\Users\\504호\\git\\FINAL_Ateam\\ATeamProject\\src\\main\\resources\\static\\image\\Thumbnail\\";
		do {
			destinationFileName = RandomStringUtils.randomAlphabetic(32) + "." + sourceFileNameExtension;
			destinationFile = new File(fileUrl + destinationFileName);
		} while (destinationFile.exists());
			
		destinationFile.getParentFile().mkdirs();
		files.transferTo(destinationFile);
			
		file.setFilename(destinationFileName);
		file.setFileOriName(sourceFileName);
		file.setFileurl(fileUrl);
		file.setCourse(r);
		filesService.save(file,r);
	}
	
	public void bannerfileInsert(HttpServletRequest request, MultipartFile files, Course r) throws Exception{
		Files file = new Files();

		String sourceFileName = files.getOriginalFilename();
		String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
		File destinationFile;
		String destinationFileName;
		String fileUrl = "C:\\Users\\504호\\git\\FINAL_Ateam\\ATeamProject\\src\\main\\resources\\static\\image\\banner\\";
		do {
			destinationFileName = RandomStringUtils.randomAlphabetic(32) + "." + sourceFileNameExtension;
			destinationFile = new File(fileUrl + destinationFileName);
		} while (destinationFile.exists());
			
		destinationFile.getParentFile().mkdirs();
		files.transferTo(destinationFile);
			
		file.setFilename(destinationFileName);
		file.setFileOriName(sourceFileName);
		file.setFileurl(fileUrl);
		file.setCourse(r);
		filesService.save(file,r);
	}
	
	public void videofileInsert(HttpServletRequest request, MultipartFile files, Lecture l) throws Exception{
		Files file = new Files();

		String sourceFileName = files.getOriginalFilename();
		String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
		File destinationFile;
		String destinationFileName;
		String fileUrl = "C:\\Users\\504호\\git\\FINAL_Ateam\\ATeamProject\\src\\main\\resources\\static\\video\\";
		do {
			destinationFileName = RandomStringUtils.randomAlphabetic(32) + "." + sourceFileNameExtension;
			destinationFile = new File(fileUrl + destinationFileName);
		} while (destinationFile.exists());
			
		destinationFile.getParentFile().mkdirs();
		files.transferTo(destinationFile);
			
		file.setFilename(destinationFileName);
		file.setFileOriName(sourceFileName);
		file.setFileurl(fileUrl);
		file.setLecture(l);
		filesService.save(file,l);
	}
	
}

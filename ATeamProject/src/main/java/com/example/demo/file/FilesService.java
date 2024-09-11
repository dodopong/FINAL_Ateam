package com.example.demo.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.course.Course;
import com.example.demo.lecture.Lecture;
import com.example.demo.member.Member;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class FilesService {
	@Autowired
	FilesRepository filesRepository;
	
	public void save(Files files, Course c) {
		Files f = new Files();
		f.setFilename(files.getFilename());
		f.setFileOriName(files.getFileOriName());
		f.setCourse(c);
		f.setFileurl(files.getFileurl());
		
		filesRepository.save(f);
	}
	public void save(Files files, Lecture l) {
		Files f = new Files();
		f.setFilename(files.getFilename());
		f.setFileOriName(files.getFileOriName());
		f.setLecture(l);
		f.setFileurl(files.getFileurl());
		
		filesRepository.save(f);
	}
	public void save(HttpServletRequest request, MultipartFile files, Member m) throws Exception {
		Files file = new Files();

		String sourceFileName = files.getOriginalFilename();
		String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
		File destinationFile;
		String destinationFileName;
		String fileUrl = "C:\\Users\\504호\\git\\FINAL_Ateam\\ATeamProject\\src\\main\\resources\\static\\image\\profileImg\\";
		do {
			destinationFileName = RandomStringUtils.randomAlphabetic(32) + "." + sourceFileNameExtension;
			destinationFile = new File(fileUrl + destinationFileName);
		} while (destinationFile.exists());
			
		destinationFile.getParentFile().mkdirs();
		files.transferTo(destinationFile);
			
		file.setFilename(destinationFileName);
		file.setFileOriName(sourceFileName);
		file.setFileurl(fileUrl);
		file.setMember(m);
		filesRepository.save(file);
	}
	
	public void modifyProfileImg(Files f, HttpServletRequest request, MultipartFile files) throws Exception {
		Member m = f.getMember();
		String sourceFileName = files.getOriginalFilename();
		String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
		File destinationFile;
		String destinationFileName;
		String fileUrl = "C:\\Users\\504호\\git\\FINAL_Ateam\\ATeamProject\\src\\main\\resources\\static\\image\\profileImg\\";
		do {
			destinationFileName = RandomStringUtils.randomAlphabetic(32) + "." + sourceFileNameExtension;
			destinationFile = new File(fileUrl + destinationFileName);
		} while (destinationFile.exists());
			
		destinationFile.getParentFile().mkdirs();
		files.transferTo(destinationFile);
			
		f.setFilename(destinationFileName);
		f.setFileOriName(sourceFileName);
		f.setFileurl(fileUrl);
		f.setMember(m);
		filesRepository.save(f);
	}


}

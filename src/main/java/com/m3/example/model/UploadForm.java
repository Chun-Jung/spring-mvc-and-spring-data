package com.m3.example.model;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UploadForm {
	private String username;
	private Date date;
	private List<MultipartFile> file;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
}

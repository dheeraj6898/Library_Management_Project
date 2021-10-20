package com.app.spring.dto;

import org.springframework.http.MediaType;

public class StuFileDataDto {
	private String contentType;
	private String fileName;
	private byte[] fileDate;
	
	
		public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileDate() {
		return fileDate;
	}
	public void setFileDate(byte[] fileDate) {
		this.fileDate = fileDate;
	}
	public MediaType getMediaType() {
		String []s=contentType.split("/");
		return new MediaType(s[0],s[1]);
	}
	
	
}

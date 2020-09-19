package com.ajay.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ajay.entity.Image;
import com.ajay.utils.Fileupload;

public class ImageDTO {
	private long id;
	private String title;
	private String uploadedBy;
	private LocalDate uploadedDate;
	private String fileName;
	private String fileUrl;
	private String url;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	public LocalDate getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(LocalDate uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	Fileupload fileupload = new Fileupload();
	//String path = fileupload.getFilePath()+image.getFileUrl()+"/"+image.getFileName();
	
	public Object ObjectToSingleImage(Image image) {
		ImageDTO imageDTO = new ImageDTO();
		imageDTO.setId(image.getId());
		imageDTO.setTitle(image.getTitle());
		imageDTO.setUploadedBy(image.getUploadedBy());
		imageDTO.setUploadedDate(image.getUploadedDate());
		imageDTO.setFileName(image.getFileName());
		imageDTO.setFileUrl(image.getFileUrl());
		imageDTO.setUrl(fileupload.getFilePath()+image.getFileUrl()+"/"+image.getFileName());
		
		return imageDTO;
	}
	
	
	private ImageDTO ObjetcToImage(Image image) {
		this.id = image.getId();
	     this.title=image.getTitle();
         this.uploadedBy=image.getUploadedBy();
         this.uploadedDate=image.getUploadedDate();
		return this;
	}
	
	public List<ImageDTO> ObjetcToImage(List<Image> images){
		List<ImageDTO> imageDTOs = new ArrayList<ImageDTO>();
		for(Image image : images) {
			ImageDTO imageDTO = new ImageDTO();
			imageDTO.ObjetcToImage(image);
			imageDTOs.add(imageDTO);
		}
		return imageDTOs;
	}
	
}

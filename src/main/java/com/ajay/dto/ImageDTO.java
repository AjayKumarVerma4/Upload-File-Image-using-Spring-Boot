package com.ajay.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ajay.entity.Image;
import com.ajay.entity.ImageFile;

public class ImageDTO {
	private long id;
	private String title;
	private Set<ImageFile> imageFile;
	private String uploadedBy;
	private LocalDate uploadedDate;
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
	public Set<ImageFile> getImageFile() {
		return imageFile;
	}
	public void setImageFile(Set<ImageFile> imageFile) {
		this.imageFile = imageFile;
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
	
	public Object ObjectToSingleImage(Image image) {
		ImageDTO imageDTO = new ImageDTO();
		imageDTO.setId(image.getId());
		imageDTO.setTitle(image.getTitle());
		imageDTO.setUploadedBy(image.getUploadedBy());
		imageDTO.setUploadedDate(image.getUploadedDate());
		imageDTO.setImageFile(image.getImageFile());
		
		return imageDTO;
	}
	
	
	private ImageDTO ObjetcToImage(Image image) {
		this.id = image.getId();
	     this.title=image.getTitle();
         this.uploadedBy=image.getUploadedBy();
         this.uploadedDate=image.getUploadedDate();
	     this.imageFile=image.getImageFile();
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

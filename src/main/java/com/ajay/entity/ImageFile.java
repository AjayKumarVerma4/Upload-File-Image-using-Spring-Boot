package com.ajay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="IMAGE_FILE")
public class ImageFile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="FILE_NAME", length=100)
	private String fileName;
	
	@Column(name="DIRECTORY", length=50)
	private String fileUrl;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "IMAGE")
	private Image image;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Image getImage() {
		return image;
	}

	@JsonProperty(access = Access.WRITE_ONLY)
	public void setImage(Image image) {
		this.image = image;
	}
}

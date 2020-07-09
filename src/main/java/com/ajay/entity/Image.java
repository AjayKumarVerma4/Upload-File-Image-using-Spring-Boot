package com.ajay.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="IMAGE")
public class Image {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;

	@OneToMany(mappedBy = "image", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	private Set<ImageFile> imageFile;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="UPLOADED_BY")
	private String uploadedBy;
	
	@Column(name = "UPLOADED_DATE")
	private LocalDate uploadedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<ImageFile> getImageFile() {
		return imageFile;
	}

	public void setImageFile(Set<ImageFile> imageFile) {
		this.imageFile = imageFile;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(LocalDate uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	
}

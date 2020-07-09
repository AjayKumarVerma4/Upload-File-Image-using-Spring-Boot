package com.ajay.controller;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ajay.constant.Appconstants;
import com.ajay.dto.ImageDTO;
import com.ajay.entity.Image;
import com.ajay.entity.ImageFile;
import com.ajay.service.ImageFileService;
import com.ajay.service.ImageService;
import com.ajay.utils.FileHelper;
import com.ajay.utils.Fileupload;

@Controller
@RequestMapping(Appconstants.IMAGE_BASEURL)
public class ImageController {
	
	@Autowired
	ImageService imageService;
	
	@Autowired
	ImageFileService imageFileService;
	
	private final Logger log=LoggerFactory.getLogger(ImageController.class);
	
//	Upload single or multiple Image
	@RequestMapping(value = "/uploadImage", headers = "Content-Type=multipart/form-data", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> uploadImage(
			@RequestParam(value = "imageFiles", required = true) MultipartFile[] imageFiles,
			@RequestParam(value = "uploadedDate", required = false) String uploadedDate,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "uploadedBy", required = false) String uploadedBy
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		log.info("start of method");
		
		LocalDate today = LocalDate.now();
		Fileupload fileupload = new Fileupload();
		
		try {
			if(imageFiles !=null && imageFiles.length > 0) {
			Image image=new Image();
			image.setUploadedDate(today);
			image.setTitle(title);
			image.setUploadedBy(uploadedBy);
			imageService.saveOrUpdate(image);
			
			for (MultipartFile multipartFile : imageFiles) {
				log.info("Hello");
				String path = "Image/"+image.getId();
				String fileName = multipartFile.getOriginalFilename();
				String filePath = fileupload.getFilePath(path);
				fileupload.uploadImage(multipartFile, filePath + "/" + fileName);
				ImageFile imageFile=new ImageFile();
				imageFile.setFileName(fileName);
				imageFile.setFileUrl(path); 
				imageFile.setImage(image);
				imageFileService.saveOrUpdate(imageFile);
			}
		}
			map.put("message", "Images Uploaded successfully");
			map.put("status_code", "200");
			map.put("status", "success");
		} catch (Exception ex) {
			map.put("status", ex.getMessage());
		}
		log.info("End of method");
		return map;
	}
	
// Get Image By Id
	@RequestMapping(value = "/getImageById", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getImageById(@RequestBody Image image, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		ImageDTO imageDTO = new ImageDTO();
		Image imageDetail = imageService.getObject(image.getId());
		map.put("status", "success");
		map.put("imageDetail",imageDTO.ObjectToSingleImage(imageDetail));
		map.put("message", "success");
		map.put("status_code", "200");
		return map;
	}
	
// List of images
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> listOfImage(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Image> imageList=new ArrayList<Image>();
		ImageDTO imageDTO = new ImageDTO();
		imageList=imageService.list();
	
		map.put("image_list",imageDTO.ObjetcToImage(imageList));
		map.put("status", "success");
		map.put("status_code", "200");
		
		return map;
	}
	
// delete image
 	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> deleteImage(@RequestBody ImageDTO imagedto, HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		log.info("Start of method delete image");
		
		long imageId=imagedto.getId();

		imageFileService.deleteByImageId(imageId);
		Fileupload fileupload = new Fileupload();
		log.info("full path"+fileupload);
		FileHelper file = new FileHelper();
		String path = fileupload.getFilePath() +"Image/"+imageId;
		File dir = new File(path);
		file.deleteDirectory(dir);
		
		imageService.deleteImage(imageId);

		map.put("status", "success");
		map.put("message", "image deleted successfully");
		log.info("End of method delete image");
		return map;
		
	}

}

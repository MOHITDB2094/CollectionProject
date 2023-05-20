package com.nt.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nt.entity.FileDB;
import com.nt.message.ResponseFile;
import com.nt.message.ResponseMessage;
import com.nt.service.FileStorageService;

@RestController
@CrossOrigin
public class FileController {
	@Autowired
	private FileStorageService storageService;
	@Autowired
	private ServletContext sc;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			storageService.store(file);

			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@GetMapping("/files")
	public ResponseEntity<List<ResponseFile>> getListFiles() {
		List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/")
					.path(dbFile.getId()).toUriString();

			return new ResponseFile(dbFile.getName(), fileDownloadUri, dbFile.getType(), dbFile.getData().length);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

	/*
	 * @GetMapping("/files/{id}") public ResponseEntity<OutputStream>
	 * getFile(@PathVariable String id, HttpServletResponse res) { FileDB fileDB =
	 * storageService.getFile(id);
	 * 
	 * OutputStream outputStream = new ByteArrayOutputStream(); try {
	 * outputStream.write(fileDB.getData()); outputStream.close(); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * OutputStream os= null; try { File file=new File(fileDB.getName()); //get the
	 * length of the file and make it as response content length
	 * res.setContentLengthLong((file.length())); //get MIME of the file make it
	 * response content type String mimeType=sc.getMimeType(fileDB.getName());
	 * res.setContentType(mimeType!=null?mimeType:"application/octet-stream"); //
	 * give instruction to browser to make the recieved content as the downloadable
	 * file
	 * res.addHeader("Content-Disposition","attachment;fileName="+file.getName());
	 * //create InputStream pointing to file InputStream is=new
	 * FileInputStream(file); //create OutputStream pointing to response obj
	 * os=res.getOutputStream(); //complete file copy process
	 * 
	 * IOUtils.copy(is,os); } catch (IOException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * 
	 * return ResponseEntity.ok() .header(HttpHeaders.CONTENT_DISPOSITION,
	 * "attachment; filename=\"" + fileDB.getName() + "\"") .body(os); }
	 */

	@GetMapping("/download")
	public String downloadFile(@RequestParam("fname") String fileName, HttpServletResponse res) throws Exception {
		// Locate the file usin java.io.File object
		File file = new File(fileName);
		// get the length of the file and make it as response content length
		res.setContentLengthLong((file.length()));
		// get MIME of the file make it response content type
		String mimeType = sc.getMimeType(fileName);
		res.setContentType(mimeType != null ? mimeType : "application/octet-stream");
		// give instruction to browser to make the recieved content as the downloadable
		// file
		res.addHeader("Content-Disposition", "attachment;fileName=" + file.getName());
		// create InputStream pointing to file
		InputStream is = new FileInputStream(file);
		// create OutputStream pointing to response obj
		OutputStream os = res.getOutputStream();
		// complete file copy process
		IOUtils.copy(is, os);
		// since response going to browser directly from handler method itself.. So
		// return null (do not take void)
		return null;
	}
}

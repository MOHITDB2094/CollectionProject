package com.nt.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nt.model.MyData;
import com.opencsv.CSVWriter;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ServiceClassMethod2 {

	public String downloadCSV(String filepath){
		log.info(" Program to download data in csv");
		
			
			List<MyData> datas = new ArrayList<MyData>(); // data to be stored 
			datas.add(new MyData("Mohit", 27, "Software Engineer", 60000l, 9923910843l));
			datas.add(new MyData("Praful", 27,"Software Engineer" , 40000, 6048953761l));
			datas.add(new MyData("Govinda", 27, "QA Engineer", 9004l, 6485328641l));
			
			CSVWriter csvWriter =  null;
			try {
			File file = new File(filepath);
			FileWriter fileWriter = new FileWriter(file);
			csvWriter = new CSVWriter(fileWriter);
			
				csvWriter.writeNext(createHeaderRow().toArray(new String[0]));// add header data 
				
				for (MyData myData : datas) {
					String [] rowData =  putReportDatainRow(myData).stream().toArray(String[]::new);
					csvWriter.writeNext(rowData);
				}
			} catch (Exception e) {
				log.error("error occured in csv", e);
			}finally {
				try {
					csvWriter.close();
				} catch (Exception e2) {
					throw new RuntimeException();
				}
			}
			return "CSV file Download : "+filepath;
	}
	
	private List<String>  createHeaderRow() {
		List<String> headers = new ArrayList();
		
		headers.add("NAME");
		headers.add("AGE");
		headers.add("JOB_PROFILE");
		headers.add("CURRENT_BALANCE");
		headers.add("FUTURE_BALANCE");
		
		return headers;
	}
	
	private List<String> putReportDatainRow(MyData data) {
		List<String> reportValues = new ArrayList<String>();
		// put data in report take care number of row created and these data added should be same for good
		
		reportValues.add(data.getName());
		reportValues.add(String.valueOf(data.getAge()));  // convert non string value to string 
		reportValues.add(data.getJobProfile());
		reportValues.add(String.valueOf(data.getCurentBalance()));
		reportValues.add(String.valueOf(data.getFutureBalance()));
		
	return reportValues;
	}
}

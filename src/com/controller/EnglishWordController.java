package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pojo.EnglishWords;
import com.service.EnglishWordService;
import com.util.Util;

@Controller
@RequestMapping("/word")
public class EnglishWordController {

	@Autowired
	private EnglishWordService englishWordService;
	
	@RequestMapping(value="/english",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addEnglishWords(EnglishWords words){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishWordService.addEnglishWord(words);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="/english",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryAllEnglishWord(int pageNum,int pageCount){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishWordService.queryAllEnglishWord(pageNum, pageCount);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/english/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteEnglishWord(@PathVariable("id") String id){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishWordService.deleteEnglishWord(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="/english/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryEnglishWordById(@PathVariable("id") String id){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishWordService.queryEnglishWordById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="/englishUpdate",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> putEnglishWords(EnglishWords words){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishWordService.putEnglishWord(words);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/english/study",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> studyEnglishWords(String startTime,String endTime){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishWordService.studyEnglishWords(startTime,endTime);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	
	@RequestMapping(value="/english/excel/{pageNum}/{pageCount}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> englishExcel(@PathVariable("pageNum")int pageNum,@PathVariable("pageCount")int pageCount,HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();
		response.setContentType("octets/stream");
		String title="英语单词";
		try{
			response.addHeader("Content-Disposition",
					"attachment;filename=" + new String(title.getBytes("gb2312"), "ISO8859-1") + ".xls");
			OutputStream out = response.getOutputStream();
			map = englishWordService.englishExcel(pageNum,pageCount,title,out);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value = "/getExcel", method = RequestMethod.POST)
	public Map<String,Object> getExcel(MultipartFile excelFile, HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			HSSFWorkbook workbook = new HSSFWorkbook(excelFile.getInputStream());
			HSSFSheet sheet = null;
			sheet = workbook.getSheetAt(0);
			for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {// 获取每行
				HSSFRow row = sheet.getRow(j);
				EnglishWords englishWords = new EnglishWords();
//				for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {// 获取每个单元格
//					System.out.print(row.getCell(k) + "\t");
//				}
				englishWords.setEnglishWords(row.getCell(0).toString());
				englishWords.setEnglishMean(row.getCell(1).toString());
				englishWords.setEnglishPhrases(row.getCell(2).toString());
				englishWords.setPhrasesMean(row.getCell(3).toString());
				map = englishWordService.addEnglishWord(englishWords);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
}

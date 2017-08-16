package com.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.EnglishWordMapper;
import com.pojo.EnglishWords;
import com.pojo.Paging;
import com.service.EnglishWordService;
import com.util.Util;

@Service
public class EnglishWordServiceImpl implements EnglishWordService {

	@Autowired
	private EnglishWordMapper englishWordMapper;

	@Override
	public Map<String, Object> addEnglishWord(EnglishWords englishWords) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			englishWords.setId(Util.uuid());
			englishWords.setAddTime(Util.date());
			englishWordMapper.addEnglishWord(englishWords);
			map.put("status", "200");
			map.put("message", "添加英语单词成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "201");
			map.put("message", "添加英语单词失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> queryAllEnglishWord(int pageNum, int pageCount) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int count = englishWordMapper.countEnglish();
			Paging page = Util.paging(count, pageNum, pageCount);
			List<Object> objList = englishWordMapper.queryAllEnglishWord(page.getStartCount(), pageCount);
			map.put("page", page);
			map.put("list", objList);
			map.put("status", "200");
			map.put("message", "查询英语成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "查询英语失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteEnglishWord(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String[] id = ids.split(",");
			for (int i = 0; i < id.length; i++) {
				englishWordMapper.deleteEnglish(id[i]);
			}
			map.put("status", "200");
			map.put("message", "删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "删除失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> queryEnglishWordById(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("list", englishWordMapper.queryEnglishById(id));
			map.put("status", "200");
			map.put("message", "根据id查询成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "201");
			map.put("message", "根据id查询失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> putEnglishWord(EnglishWords englishWords) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			englishWordMapper.putEnglishWord(englishWords);
			map.put("status", "200");
			map.put("message", "修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "201");
			map.put("message", "修改失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> queryByWord(String word) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("word", englishWordMapper.queryByWord(word));
			map.put("status", "200");
			map.put("message", "查询英语成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "查询英语失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> studyEnglishWords(String startTime, String endTime) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Object> objList = englishWordMapper.studyEnglishWords(startTime, endTime);
			if (objList.size() < 10) {
				map.put("status", "400");
				map.put("message", "抱歉,此功能至少需要您存储10个单词！");
				return map;
			}
			Set<Object> obj = new HashSet<Object>();
			do {
				int num = (int) (Math.random() * (objList.size()));
				obj.add(num);
				// obj.size()等于10的时候跳出循环
			} while (obj.size() != 10);
			Iterator<Object> it = obj.iterator();
			List<Object> list = new ArrayList<Object>();
			while (it.hasNext()) {
				list.add(objList.get(Integer.parseInt(it.next().toString())));
			}
			Set<Object> obj1 = new HashSet<Object>();
			do {
				int num = (int) (Math.random() * 10);
				obj1.add(list.get(num));
				// obj.size()等于10的时候跳出循环
			} while (obj1.size() != 10);
			Iterator<Object> it1 = obj1.iterator();
			List<Object> list1 = new ArrayList<Object>();
			while (it1.hasNext()) {
				list1.add(it1.next());
			}
			map.put("list1", list1);
			map.put("list", list);
			map.put("status", "200");
			map.put("message", "查询英语成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "查询英语失败！");
		}
		return map;
	}

	/**
	 * 导出excel
	 */
	@Override
	public Map<String, Object> englishExcel(int pageNum, int pageCount, String title, OutputStream out) {
		String[] header = { "英文单词", "英文汉译", "英文句子", "句子汉译" };
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int count = englishWordMapper.countEnglish();
			Paging page = Util.paging(count, pageNum, pageCount);
			List<Object> objList = englishWordMapper.queryAllEnglishWord(page.getStartCount(), pageCount);
			// 第一步声明一个工作簿

			HSSFWorkbook workBook = new HSSFWorkbook();
			// 第二步生成一个表格
			HSSFSheet sheet = workBook.createSheet(title);
			// 设置表格默认列宽度为15个字符
			sheet.setDefaultColumnWidth(15);
			// 第三步生成一个样式,用来设置标题样式
			HSSFCellStyle style = workBook.createCellStyle();
			style.setAlignment(CellStyle.ALIGN_CENTER);
			// 第四步设置字体
			HSSFFont font = workBook.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			// 把字体应用到当前的样式
			style.setFont(font);
			HSSFRow row = sheet.createRow(0);
			for (int i = 0; i < header.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style);
				HSSFRichTextString text = new HSSFRichTextString(header[i]);
				cell.setCellValue(text);
			}
			for (int i = 0; i < objList.size(); i++) {
				Map<String, Object> objMap = (Map<String, Object>) objList.get(i);
				// 这段代码为换行
				/*int j = 0;
				row = sheet.createRow(i+1);
				HSSFCell cell = row.createCell(j++);
				style.setWrapText(true);
				cell.setCellStyle(style);
				cell.setCellValue(objMap.get("english_words").toString() + "\n" + i);

				HSSFCell cell1 = row.createCell(j++);
				cell1.setCellStyle(style);
				cell1.setCellValue(objMap.get("english_mean").toString() + "\n" + i);

				HSSFCell cell2 = row.createCell(j++);
				
				cell2.setCellStyle(style);
				cell2.setCellValue(objMap.get("english_phrases").toString() + "\n" + i);

				HSSFCell cell3 = row.createCell(j++);
				cell3.setCellStyle(style);
				cell3.setCellValue(objMap.get("phrases_mean").toString() + "\n" + i);*/
				// 这段代码为不换行
				 row = sheet.createRow(i+1);
				 int j = 0;
				 row.createCell(j++).setCellValue(objMap.get("english_words").toString());
				 row.createCell(j++).setCellValue(objMap.get("english_mean").toString());
				 row.createCell(j++).setCellValue(objMap.get("english_phrases").toString());
				 row.createCell(j++).setCellValue(objMap.get("phrases_mean").toString());
			}
			workBook.write(out);
			map.put("status", "200");
			map.put("message", "导出excel成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "导出excel失败！");
		}

		return map;
	}

}

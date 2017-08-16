package com;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.pojo.EnglishWords;

public class Test {
	public static void main(String[] args) {
		try {
			showExcel("D:\\11.xls");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void showExcel(String path) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(path)));
		HSSFSheet sheet = null;
//		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {// 获取每个Sheet表
			sheet = workbook.getSheetAt(0);
			for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {// 获取每行
				HSSFRow row = sheet.getRow(j);
				for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {// 获取每个单元格
					System.out.print(row.getCell(k) + "\t");
				}
				System.out.println();
			}
//		}
	}
}

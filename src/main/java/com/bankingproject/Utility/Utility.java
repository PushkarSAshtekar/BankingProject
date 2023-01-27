package com.bankingproject.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bankingproject.base.BaseClass;

public class Utility extends BaseClass{
	FileInputStream fis;
	public Utility() throws FileNotFoundException {
		this.fis=new FileInputStream(projectpath+"\\src\\test\\resources\\Excel\\Book1.xlsx");
	}
	
	public void getalldata(String Sheetname) throws EncryptedDocumentException, IOException {
		Sheet sh=	WorkbookFactory.create(fis).getSheet(Sheetname);
		//HashMap<String, Object> map=new HashMap<>();
		for(int i=0;i<=sh.getLastRowNum();i++) {
		int collcount=sh.getRow(i).getLastCellNum();
		for(int j=0;j<=collcount;j++) {
			if(sh.getRow(i).getCell(j).getCellType().toString().equalsIgnoreCase("string")) {
				sh.getRow(i).getCell(j).getStringCellValue();
			} else if(sh.getRow(i).getCell(j).getCellType().toString().equalsIgnoreCase("numeric"))
				 sh.getRow(i).getCell(j).getNumericCellValue();
				
			}
		}
		}
		
	
	public Object getsingleData(int row,int cell,String Sheetname) throws EncryptedDocumentException, IOException ,FileNotFoundException{
		
		Sheet sh=	WorkbookFactory.create(fis).getSheet(Sheetname);
		
		Object data = "";
		if(sh.getRow(row).getCell(cell).getCellType().toString().equalsIgnoreCase("string"))
		 data =sh.getRow(row).getCell(cell).getStringCellValue();
		
		else if(sh.getRow(row).getCell(cell).getCellType().toString().equalsIgnoreCase("numeric"))
			data =sh.getRow(row).getCell(cell).getNumericCellValue();
		return data;
		/*XSSFWorkbook workbook =new XSSFWorkbook();
		XSSFSheet Sheet= workbook.createSheet("Login informataion");
		Sheet.createRow(0).createCell(0).setCellValue(email);
		FileOutputStream fos=new FileOutputStream(projectpath+"\\src\\test\\resources\\Excel\\Book1.xlsx");
		workbook.write(fos);*/
		
	}
	}	



package com.bankingproject.pom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankingproject.base.BaseClass;

public class CredentialsPom extends BaseClass {

	public CredentialsPom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//table[@border='1']//tr[4]/td[2]")
	WebElement UserId;
	
	@FindBy(xpath = "//table[@border='1']//tr[5]/td[2]")
	WebElement Password;
	
	public void UserID(String email) {
		UserId.sendKeys(email);
	}
	
	public void SavenewCredentials() throws IOException {
		String st=UserId.getText();
		String str=Password.getText();
		System.out.println("UserID................"+    st   );
		System.out.println("Password.............."  +   str);
		SaveinExcel(0, 0, st, 1,0 , str);
		
	}
	public void SaveinExcel(int row,int cell, String UserID,int row1,int cell1,String password) throws IOException {
		XSSFWorkbook workbook =new XSSFWorkbook();
		XSSFSheet Sheet= workbook.createSheet("Login informataion");
		Sheet.createRow(row).createCell(cell).setCellValue(UserID);
		Sheet.createRow(row1).createCell(cell1).setCellValue(password);
		FileOutputStream fos=new FileOutputStream(projectpath+"\\src\\test\\resources\\Excel\\Book1.xlsx");
		workbook.write(fos);
	}
}

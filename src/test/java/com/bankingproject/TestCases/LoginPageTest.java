package com.bankingproject.TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bankingproject.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@BeforeClass
	public void setup() {
		LaunchWebsite();
	}
	@AfterClass
	public void Close() {
		driver.close();
	}
	
	@Test
	public void Testtile() {
	String title=	driver.getTitle();
//	System.out.println(title);
	if(title.equalsIgnoreCase("GTPL Bank Home Page")) {
		System.out.println("we are on correct page");
	}else {
		System.out.println("we are on wrong page");
	}
	}
	@Test
	public void TestUrl () {
		String UrlTitle = driver.getCurrentUrl();
		if(UrlTitle.equalsIgnoreCase("https://demo.guru99.com/V1/index.php")) {
			System.out.println("we are on correct url");
		}
		else {
			
			System.out.println("we are no worng path");
		}
	}
	}
	

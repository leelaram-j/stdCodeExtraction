package com.test.pincode;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		String ipFileName = "C:\\Users\\leelaram.j\\Downloads\\testingin.txt";
		String opFileName = "C:\\Users\\leelaram.j\\Downloads\\testingout.txt";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		String gString="ADAMPUR mapsofindia std code";
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys(gString);
		driver.findElement(By.name("btnK")).click();
		String source = driver.getPageSource();
		Txt_write.write2Txt(opFileName,source);
		driver.close();

	}

}

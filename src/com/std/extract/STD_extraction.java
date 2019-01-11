package com.std.extract;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.txt.read.Txt_Read;
import com.txt.write.Txt_write_fail;
import com.txt.write.Txt_write_pass;

public class STD_extraction
{
	public static void main(String [] args) throws IOException
	{
		String inFilename = "C:\\Users\\leelaram.j\\Downloads\\stdIn1.txt";
		String opFileNamePass = "C:\\Users\\leelaram.j\\Downloads\\stdOutPass.txt";
		String opFileNameFail = "C:\\Users\\leelaram.j\\Downloads\\stdOutFail.txt";
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String city;
		String state;
		String stdCode;
		String[] lines = Txt_Read.txtRead(inFilename);
		String header ="City \t State \t StdCode";
		Txt_write_pass.write2Txt(opFileNamePass,header);
		driver.get("https://www.indiacom.com/yellowpage/codeforcity.asp");
		try
		{
			for(String line:lines)
			{
				driver.findElement(By.xpath("//input[@id='keyword']")).clear();
				driver.findElement(By.xpath("//input[@id='keyword']")).sendKeys(line);
				driver.findElement(By.xpath("//input[@value='Find']")).click();
				String nullCheck= driver.findElement(By.xpath("//div[@class='stddtl']/div[1]")).getText();
				//System.out.println(nullCheck);
				int counter = driver.findElements(By.xpath("//div[@class='stddtl']")).size();
				//System.out.println(counter);
				if(nullCheck.length()==0)
				{
					Txt_write_fail.write2Txt(opFileNameFail, line);
					continue;
				}
				for(int i=1;i<=counter;i++)
				{
					System.out.println(i);
					city = driver.findElement(By.xpath("//div[@class='stddtl']["+i+"]/div[1]")).getText();
					state = driver.findElement(By.xpath("//div[@class='stddtl']["+i+"]/div[2]")).getText();
					stdCode = driver.findElement(By.xpath("//div[@class='stddtl']["+i+"]/div[3]")).getText();
					//System.out.println("City:"+city+" State:"+state+" StdCode:"+stdCode);
					String opData= city+"\t"+state+"\t"+stdCode;
					Txt_write_pass.write2Txt(opFileNamePass,opData);
				}
				
			}
		}
		
		catch(ElementNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		driver.close();
	}

}

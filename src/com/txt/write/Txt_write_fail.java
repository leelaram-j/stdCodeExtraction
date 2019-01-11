package com.txt.write;

import java.io.FileOutputStream;
import java.io.IOException;

public class Txt_write_fail
{
	public static void write2Txt(String opFileName, String city) throws IOException
	    {
	        String str = city+" not found. Please search in google. \n";
			FileOutputStream fos = new FileOutputStream(opFileName,true);
	        byte[] strToBytes = str.getBytes();
	        fos.write(strToBytes);
	        fos.close();
	    }
}

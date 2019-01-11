package com.test.pincode;

import java.io.FileOutputStream;
import java.io.IOException;

public class Txt_write
{
	public static void write2Txt(String opFileName, String source) throws IOException
	    {
	        FileOutputStream fos = new FileOutputStream(opFileName,true);
	        byte[] strToBytes = source.getBytes();
	        fos.write(strToBytes);
	        fos.close();
	    }
}

package com.txt.write;

import java.io.FileOutputStream;
import java.io.IOException;

public class Txt_write_pass
{
	public static void write2Txt(String opFileName, String source) throws IOException
	    {
	        String str = source+"\n";
			FileOutputStream fos = new FileOutputStream(opFileName,true);
	        byte[] strToBytes = str.getBytes();
	        fos.write(strToBytes);
	        fos.close();
	    }
}

package com.dal.ioExample;

import java.io.*;                                                                           
public class pipedstream 
{  
  public static void main(String args[]) throws IOException
  {  
	byte aByteData1=123, aByteData2=111;
   	PipedInputStream pis=new PipedInputStream();
   	PipedOutputStream pos=new PipedOutputStream(pis);
   	System.out.println("PipedInputStream");
	try{ 
   	   pos.write(aByteData1);
	   pos.write(aByteData2);
	   System.out.println((byte)pis.read());
	   System.out.println((byte)pis.read());
	} finally{ 
          pis.close();	
          pos.close();}
    }
}

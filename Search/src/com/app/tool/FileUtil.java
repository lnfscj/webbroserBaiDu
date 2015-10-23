package com.app.tool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import android.content.Context;

public class FileUtil {
	final String WEBSHOT_BITMAP = "pageShot.dat";
	Context context;
	
	public FileUtil(Context context) {
		super();
		this.context = context;
	}

	public void writeBitmap(byte[] bitmap){
		try {
			FileOutputStream fos = context.openFileOutput(WEBSHOT_BITMAP,Context.MODE_PRIVATE);
			try {
				fos.write(bitmap);
				fos.flush();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			PrintStream ps = new PrintStream(fos);
//			ps.println();
//			ps.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public byte[] readBitmap(int position,double byteCount){
//		try {
//			FileInputStream fis = context.openFileInput(WEBSHOT_BITMAP);
//			byte[] buffer = new byte[1024];
//			buffer = fis.read(buffer, position, byteCount);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 
//	}
	private String generateFileName() {
		// ��õ�ǰʱ��
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		// ת��Ϊ�ַ���
		String formatDate = format.format(new Date());
		// ��������ļ����
		
		return new StringBuffer().append(formatDate).toString();
		}

}

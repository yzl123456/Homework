package lab8.Q2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Date;

public class MyFileObject {
	public static void main(String[] args) {
		File file=null;
		OutputStream outputStream=null;
		ObjectOutputStream out = null;
		try {
			file=new File("exercise3.dat");//文件对象
			outputStream=new FileOutputStream(file);//输出流
			//写基本数据类型的引用类型用 ObjectOutputStream 写对象
			out=new ObjectOutputStream(outputStream);
			
			//要写的数据
			int[] numbers=new int[]{1,2,3,4,5};
			Date date=new Date();
			Double myDouble=5.5;
			
			//将对象写入到文件
			out.writeObject(numbers);
			out.writeObject(date);
			out.writeObject(myDouble);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();//关闭流资源
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	
	}
	
	
}

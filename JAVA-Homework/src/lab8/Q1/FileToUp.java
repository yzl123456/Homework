package lab8.Q1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileToUp {
	public static void main(String[] args) throws Exception {
		File file=new File("test.txt");//要读取的文件
		InputStream in=new FileInputStream(file);//输入流
		
		File outFile=new File("UpTest.txt");//要输出的文件
		OutputStream out=new FileOutputStream(outFile);//输出流
		
		byte[] buffer=new byte[1024];//一次读1024byte
		int len=0;
		while((len=in.read(buffer))!=-1){//len表示实际读取到的长度，最大为1024，！=-1表示没有读到文件的末尾
			for(int i=0;i<len;i++){//对于已经读到的数据进行操作
				if(buffer[i]>='a'&&buffer[i]<='z')//小写变大写
					buffer[i]-='a'-'A';
			}
			out.write(buffer, 0, len);//利用输出流将数据输出到输出文件
		}
		
		//关闭流资源
		in.close();
		out.close();

	}
}

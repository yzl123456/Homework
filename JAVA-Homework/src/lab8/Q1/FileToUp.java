package lab8.Q1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileToUp {
	public static void main(String[] args) throws Exception {
		File file=new File("test.txt");//Ҫ��ȡ���ļ�
		InputStream in=new FileInputStream(file);//������
		
		File outFile=new File("UpTest.txt");//Ҫ������ļ�
		OutputStream out=new FileOutputStream(outFile);//�����
		
		byte[] buffer=new byte[1024];//һ�ζ�1024byte
		int len=0;
		while((len=in.read(buffer))!=-1){//len��ʾʵ�ʶ�ȡ���ĳ��ȣ����Ϊ1024����=-1��ʾû�ж����ļ���ĩβ
			for(int i=0;i<len;i++){//�����Ѿ����������ݽ��в���
				if(buffer[i]>='a'&&buffer[i]<='z')//Сд���д
					buffer[i]-='a'-'A';
			}
			out.write(buffer, 0, len);//������������������������ļ�
		}
		
		//�ر�����Դ
		in.close();
		out.close();

	}
}

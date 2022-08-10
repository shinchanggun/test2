package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException{
	
			Socket socket = new Socket("127.0.0.1", 9998);
			System.out.println("클라이언트 ");
			
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);

			ClassInfo ci = new ClassInfo();
			ci.setId("301010");
			ci.setName("홍길동");
			ci.setKor(100);
			ci.setEng(90);
			ci.setMath(80);

			oos.writeObject(ci);
			
			oos.flush();
			oos.close();
			os.close();
			socket.close();
		
	}

}

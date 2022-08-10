package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//서버, 클라이언트, 클라이언트가 서버에 접속, 
//서버는 소켓을 생성하고 내보내는 스트림(outputstream)으로 클라이언트에게 데이터 바로 전송

public class Server {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
			ServerSocket server=new ServerSocket(9998);
			System.out.println("서버 접속대기중...... ");
			Socket client=server.accept();
			System.out.println("클라이언트 접속 ");

			InputStream is = client.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);

			ClassInfo ci = (ClassInfo) ois.readObject();
			String id = ci.getId();
			String password = ci.getName();
			int kor=ci.getKor();
			int eng=ci.getEng();
			int math=ci.getMath();
			
			//System.out.println("id : " + id + "\npwd : " + password);
			System.out.println(ci.toString());
			//MemberDAO.getInstance().insert(member);
			
			ois.close();
			is.close();
			client.close();
			server.close();
		
		
	}

}

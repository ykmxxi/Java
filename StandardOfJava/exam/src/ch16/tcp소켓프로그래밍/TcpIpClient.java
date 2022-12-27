package ch16.tcp소켓프로그래밍;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

public class TcpIpClient {
    public static void main(String[] args) {
        try {
            String serverIP = "127.0.0.3";
            System.out.println("서버에 연결중... 서버 IP: " + serverIP);

            // 소켓 생성 후 연결 요청
            Socket socket = new Socket(serverIP, 7777);

            // 소켓의 입력스트림을 얻음
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            // 소켓으로 부터 받은 데이터 출력
            System.out.println("서버로부터 받은 메시지: " + dis.readUTF());
            System.out.println("연결 종료...");

            // 스트림과 소켓을 닫음
            dis.close();
            socket.close();
            System.out.println("서버와의 연결이 종료되었습니다.");
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

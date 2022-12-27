package ch16.tcp소켓프로그래밍;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(7777); // 서버소켓을 생성해 7777번 포트와 결합(bind)
            System.out.println(getTime() + "서버가 준비되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                System.out.println(getTime() + "연결요청을 기다립니다.");

                // 서버소켓은 연결요청이 올 때까지 기다림, 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + "로부터 연결요청이 들어옴.");

                // 소켓의 출력스트림을 얻음
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                // 원격 소켓(remote socket)에 데이터를 보냄
                dos.writeUTF("[NOTICE] Test Message1 from Server.");
                System.out.println(getTime() + "데이터 전송 완료.");

                // 스트림과 소켓을 닫아줌
                dos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static String getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("[hh:mm:ss]");
        return dateFormat.format(new Date());
    }
}

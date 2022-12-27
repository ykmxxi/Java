package ch16.inetaddress클래스;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) {
        InetAddress ip = null;
        InetAddress[] ipArr = null;

        try {
            ip = InetAddress.getByName("www.google.com"); // google
            System.out.println("HostName: " + ip.getHostName()); // google의 호스트
            System.out.println("HostAddress: " + ip.getHostAddress()); // google의 호스트주소
            System.out.println(ip.toString());

            String result = "";
            byte[] ipAddress = ip.getAddress();
            for (byte address : ipAddress) {
                result += (address < 0) ? address + 256 : address;
                result += ".";
            }

            System.out.println("Address + 256: " + result);
            System.out.println();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ipArr = InetAddress.getAllByName("www.google.com");

            for (int i = 0; i < ipArr.length; i++) {
                System.out.println("ipArr[" + i + "]: " + ipArr[i]);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

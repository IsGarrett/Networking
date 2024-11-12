import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class PortScanner {

    
    public static void scanPorts(String ip, int startPort, int endPort) {
        
        
        System.out.println("Scanning ports from " + startPort + " to " + endPort + " on " + ip + "...");
        
        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket()) {
                // attemps to connect to the IP address and port with a timeout of 200ms
                socket.connect(new InetSocketAddress(ip, port), 200);
                System.out.println("Port " + port + " is open.");
            } catch (IOException e) {
                // Connection failed (port is closed or filtered), do nothing skips to the next
            }
        }
        
        System.out.println("Port scan complete.");
    }

    public static void main(String[] args) {
        // IP address and port range to scan
        Scanner scnr = new Scanner (System.in);
        

        System.out.println("Enter IP Address to scan");
        String ipAddress = scnr.nextLine();  // localhost (for testing)
        int startPort = 1;
        int endPort = 5555; // Scan up to port 1024
        
        scanPorts(ipAddress, startPort, endPort);
    }
}

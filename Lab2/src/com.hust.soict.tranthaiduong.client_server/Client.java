import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[]args){
        Socket socket=new Socket("127.0.0.1",9696);
        BufferedReader in=new BufferedReader(new
                InputStreamReader(socket.getInputStream()));
        PrintWriter out=new
                PrintWriter(socket.getOutputStream(),true);
        System.out.println(in.readLine());
        Scanner scanner=new Scanner(System.in);
        String message=scanner.nextLine();
        socket.close();
        scanner.close();
    }
}

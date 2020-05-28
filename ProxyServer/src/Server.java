import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		try (ServerSocket socket = new ServerSocket(1668)){
			
			while (!socket.isClosed())
			{
				Socket connect = socket.accept();
				System.out.println("New connection");
				new ServerThread(connect).start();
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("Error");
		}
	}
}

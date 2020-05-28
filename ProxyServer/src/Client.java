import java.io.*;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		String url;
		String IP = "127.0.0.1";
		int Port;
		String page;

		if (args.length < 2) {
			System.out.println("Not arguments");
		}
		else {
			url = args[0];
			Port = Integer.parseInt(args[1]);

			try(Socket socket = new Socket(IP, Port);  
					BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				    PrintWriter out = new PrintWriter(socket.getOutputStream(), true))
			    {
				System.out.println("Client connect");

				out.println(url);
				out.flush();
                
				while(!socket.isOutputShutdown())
				{
					page = in.readLine();
					if (page == null)
					{
						in.close();
						out.close();
						socket.close();
						break;
					}
					System.out.println(page);
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				System.out.println("Error");
			}
		}
	}
}


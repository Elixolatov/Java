import java.io.*;
import java.net.*;

public class ServerThread extends Thread implements Runnable {

	private static Socket connect;

	ServerThread(Socket client) {
		ServerThread.connect = client; 
	}

	@Override
	public void run() {

		try (BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			 PrintWriter out =  new PrintWriter(connect.getOutputStream(), true))
			{
			
			String url;
			url = in.readLine();
			
	        System.out.println("url"+url);

			URLConnection urlConnect = new URL(url).openConnection();

			BufferedReader pageReader = new BufferedReader( new InputStreamReader(urlConnect.getInputStream()));
			String page;

			while ((page = pageReader.readLine()) != null)
			{
				out.println(page);
				out.flush();
			}


			in.close();
			out.close();
			connect.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}


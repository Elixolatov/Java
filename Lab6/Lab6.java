import java.io.*;


public class Lab6 {
      public static void main(String[] args) {
    	  double [] mass = new double[361];
    	  double [] mass2 = new double[361];
    	  
          Writer();
          Reader(mass);

        try {
            File f = new File("E:\\example.dat");
            
            if (f.createNewFile())
                System.out.println("Файл создан");
            else
                System.out.println("Файл уже есть");
        }
  	  catch (Exception e) {
            System.err.println(e);
        }

		try {
			PrintWriter pw = new PrintWriter("E:\\example.dat");
	    	  for (int i = 0; i < 361; i++) {
	    		  pw.println(mass[i]);
	    	  }
			pw.close();
		} 
		catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} 
		
		try(FileReader reader = new FileReader("E:\\example.dat")) {
            int i=0;
            String tmp = new String();
            int c;
            while((c = reader.read())!=-1) {
                if((char)c!='\n') 
                tmp+=((char)c);
                else {
                	mass2[i] = Double.parseDouble(tmp);
                	System.out.println(mass[i]+" "+mass2[i]);
                	tmp = "";
                	i++;
                	if(i == 361)
                		break;
                	}
            } 
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }   
      }
      
      static void Writer() {
    	  
    	  try {
              File f = new File("E:\\example.txt");
              
              if (f.createNewFile())
                  System.out.println("Файл создан");
              else
                  System.out.println("Файл уже есть");
          }
    	  catch (Exception e) {
              System.err.println(e);
          }

		try {
			PrintWriter pw = new PrintWriter("E:\\example.txt");
	    	  for (int i=0; i<361; i++) {
	    		  pw.println(Math.sin(i));
	    	  }
			pw.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
      }
      
      
      static void Reader(double [] mass) {
    	  
    	  try(FileReader reader = new FileReader("E:\\example.txt")) {
              int i = 0;
              String tmp = new String();
              int c;
              while((c = reader.read())!=-1) {
                  if((char)c!='\n') 
                  tmp+=((char)c);
                  else {
                  	mass[i] = Double.parseDouble(tmp);
                  	System.out.println(mass[i]);
                  	tmp = "";
                  	i++;
                  	if(i == 361)
                  		break;
                  	}
              } 
          }
          catch(IOException ex) {
               
              System.out.println(ex.getMessage());
          }   
          
          try(FileReader reader = new FileReader("E:\\input.txt")) {
          	int c;
          	String tmp = new String();
          	
          	while((c=reader.read())!=-1)
          	{
          		if((c>47)&&(c<58)) {
          			
                  tmp += ((char)c);
                  
                  c = Integer.parseInt(tmp);
                  if ((c<0)||c>360)
                  	System.out.println("Неверный ввод");

                  else {
                  	double sin=Math.sin(c);
                     for (int i = 0; i < 361; i++) {
        	    		  if(mass[i] == sin){
        	    			  System.out.println("\nsin "+i+"="+mass[i]);
        	    		  }
        	    	  }
                  }
          		} 
          		else {
          			System.out.println("Введено не число");
          			break;
          		}
          	}  	
          }
          catch(IOException ex) {
              System.out.println(ex.getMessage());
          }   
      }
}

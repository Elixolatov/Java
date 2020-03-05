import java.util.Calendar; 
import java.util.GregorianCalendar;


public class Lab2 {
	
	public static void main(String[] args) {
	int start_day;
	
	if(args.length!=0 && Integer.parseInt(args[0])<8)
	   start_day=Integer.parseInt(args[0]);
	else
	   start_day=1;	
	
    Calendar calendar = new GregorianCalendar(2020, 0, 1);
    System.out.println("Ãîä: " + calendar.get(Calendar.YEAR));
    System.out.println("Ìåñÿö: " + (calendar.get(Calendar.MONTH)+1));
    
    String [] day_of_week = new String[7];
    day_of_week[0]="Ïí";
    day_of_week[1]="Âò";
    day_of_week[2]="Ñð";
    day_of_week[3]="×ò";
    day_of_week[4]="Ïò";
    day_of_week[5]="Ñá";
    day_of_week[6]="Âñ";
    
    for(int i=0,j=(start_day-1);i<7;i++,j++)
    {
    	 System.out.print(day_of_week[j]+"\t");
    	 if(j==6)
    	   j=-1;
    }
    System.out.print("\n");
    
    int day=3-start_day;
    if(day<0)
    	day=7+day;
    for(int k=0;k<day;k++)
    {
    	System.out.print("\t");
    }
    
    for(int i = 1; i <= 6; i++) {
        for (int j = day+1; j <= 7; j++,day++) {
    	
            if(calendar.get(Calendar.YEAR)!=2020)
            	break;
        	
            System.out.print(calendar.get(calendar.DAY_OF_MONTH)+"\t");
            int month=calendar.get(Calendar.MONTH);
            calendar.add(Calendar.DATE, 1);
            if(month<calendar.get(Calendar.MONTH))
            {
                System.out.println("\n\nÌåñÿö: " + (month+2));

                for(int k=0,l=(start_day-1);k<7;k++,l++)
                {
                	 System.out.print(day_of_week[l]+"\t");
                	 if(l==6)
                	   l=-1;
                }
                System.out.print("\n");
                
                day=j;
                i=0;
                for(int k=0;k<day;k++)
                {
                	System.out.print("\t");
                }
            }
        }
        System.out.print("\n");
        day=0;
    }
	}
}

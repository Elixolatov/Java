public class Lab3 {
    public static void main(String[] args) {
    	
    	Movable[] mass =new Movable[4];
    	mass[0]= new Circle();
    	mass[0].moveTo(120, 130);
    	mass[1]=new Point();
    	mass[1].moveTo(20, 12);
    	mass[2]=new MyWindow();
    	mass[2].moveTo(1, 20);
    	mass[3]=new Rectangle();
    	mass[3].moveTo(4, 1245);
    	
    	mass[2]=null;
    	
    	
    	for(int i=0;i<4;i++) {
    		try{
    			swapXY(mass[i]);
    			}
    		catch (NullPointerException ex)
    		{
    				System.out.println ("Error swapping coordinates");
    				ex.printStackTrace();
    		};

    	}
    	
    }
    
    static void swapXY(Movable object) throws NullPointerException {
    	if (object==null) {
    		throw new NullPointerException ("Object is not created");
    	}
    	else {
    	System.out.println("Старые координаты Х=" + object.getX() + " Y=" + object.getY());
    	object.moveTo(object.getY(),object.getX());
    	System.out.println("Новые координаты Х=" + object.getX()+" Y=" + object.getY());
    	}
    }
}
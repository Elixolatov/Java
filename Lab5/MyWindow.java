
public class MyWindow implements Movable {
    protected int x,y;
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void moveTo(int x, int y) {
		this.x=x;
		this.y=y;
		System.out.println("���������� �������� �="+ this.x +" Y="+this.y);
	}

}

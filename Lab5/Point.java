public class Point implements  Graph,Movable {
    protected int x, y;
    @Override 
    public void draw() {
        System.out.println("point°: x = " + x +  ", y = " + y);
    }
    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

	@Override
	public int getX() {
		return x;
	}
	@Override
	public int getY() {
		return y;
	}
}
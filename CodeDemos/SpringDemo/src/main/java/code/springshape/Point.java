package code.springshape;

public class Point {
	private int x;
	private int y;
	
	{
		System.out.println("Point created");
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}

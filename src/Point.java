public class Point {
	private int x;
	private int y;
	
	//membuat titik dengan koordinasi (0,0)
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	//membuat titik dengan koordinasi yang diberikan (x,y)
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//setter
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	//getter
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void move (int x, int y) {
		this.x=this.x+x;
		this.y=this.y+y;
	}
	
	public int distanceTo(Point p) {
		int dx = this.x - p.getX();
		int dy = this.y - p.getY();
		return (int)Math.sqrt(dx*dx + dy*dy);
	}
        
        public void printPoint(){
            System.out.print("(" + getX() + "," + getY() + ")");
        }
	
}

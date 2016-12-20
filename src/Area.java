public class Area{
    
	private int x,y,w,h;
	private char c;
	public Area(){
		this(0,0,0,0,'~');
	}
	public Area(int x, int y, int w, int h, char c){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.c=c;
	}
	public boolean isInArea(int a,int b){
		return a>=x && a<=x+w-1 && b>=y && b<=y+h-1;
	}
	public char getChar(int a, int b){
		return isInArea(a,b)?c:null;
	}
}
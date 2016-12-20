public class Bangunan {
    private int lebar;
    private int panjang;
    private Point pintu;
    private Point posisi;
    
    //konstruktor
    public Bangunan(int panjang, int lebar, int doorx, int doory, int x, int y){
        this.panjang = panjang;
        this.lebar = lebar;
        this.pintu = new Point(doorx,doory);
        this.posisi = new Point(x,y);
    }
    
    //setter getter
    public int getLebar(){
        return this.lebar;
    }
    
    public int getPanjang(){
        return this.panjang;
    }
    
    public Point getPintu(){
        return this.pintu;
    }
    
    public void setLebar(int l){
        this.lebar=l;
    }
    
    public void setPanjang(int p){
        this.panjang=p;
    }
    
    public void setPintu(Point p){
        this.pintu=p;
    }
    
    public Point getPosisi(){
        return this.posisi;
    }
    
    public void setPosisi(Point p){
        this.posisi=p;
    }
    
    //method
    public void printLocation(){
	int x1 = getPanjang() - (getPanjang()/2);
	int x2 = getPanjang() + (getPanjang()/2);
        int y1 = getLebar() - (getLebar()/2);
	int y2 = getLebar() + (getLebar()/2);
	System.out.println("Titik kiri bawah = " + x1 + "," + y1);
	System.out.println("Titik kanan bawah = " + x2 + "," + y1);
	System.out.println("Titik kiri atas = " + x1 + "," + y2);
	System.out.println("Titik kanan atas = " + x2 + "," + y2);
    }
    
    public boolean isPlayerInside(Point p){
        int x1 = getPosisi().getX() - (getPanjang()/2);
	int x2 = getPosisi().getX()+ (getPanjang()/2);
        int y1 = getPosisi().getY() - (getLebar()/2);
	int y2 = getPosisi().getY() + (getLebar()/2);
        return ((p.getX()>=x1)&&(p.getX()<=x2)&&(p.getY()>=y1)&&(p.getY()<=y2));
    }
    
    public boolean isCloseToDoor(Player p){
        return (((p.getLokasi().getY() == getPintu().getY()+1)||(p.getLokasi().getY() == getPintu().getY()-1)||(p.getLokasi().getY() == getPintu().getY()))&&(p.getLokasi().getX() == getPintu().getX()));
    }
    
    
}

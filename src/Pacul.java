public class Pacul extends Tools {
 
    //konstruktor
    public Pacul() {
        super("Pacul", 50);
    }
    
    //method
    public boolean isPlayerBerdekatan(Player p, int x, int y){
        return (((p.getLokasi().getY() == y+1)||(p.getLokasi().getY() == y-1)||(p.getLokasi().getY() == y))&&((p.getLokasi().getX() == x-1)||(p.getLokasi().getX() == x+1)||(p.getLokasi().getX() == x)));
    }
    
    
    public void paculTanaman(Field tanah, int x, int y) {
    
        if (super.getStatus()==true) {
            if (tanah.mtxPlant[x][y]!=null) {
               System.out.println("Tanaman tidak bisa dipacul!");
            }
            else {
                System.out.println("Tanah berhasil dipacul!");
            }
        }
        else {
            System.out.println("Aktifkan tools pacul terlebih dahulu!");
        }
    }  
    
}

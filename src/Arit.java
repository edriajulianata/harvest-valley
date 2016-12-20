public class Arit extends Tools {
    
    //konstruktor
    public Arit() {
        super("Arit", 50);
    }
    
    public void aritTanaman(Plant tanaman) {
        if (super.getStatus()==true) {
            tanaman=null;
            System.out.println("Tanaman berhasil diarit!");
        }
        else {
            System.out.println("Aktifkan tools arit terlebih dahulu!");
        }
    }  
}

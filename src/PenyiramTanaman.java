public class PenyiramTanaman extends Tools {
    
    //konstruktor
    public PenyiramTanaman() {
        super("Penyiram Tanaman", 50);
    }
    
    	
    //method
    public void siramTanaman(Plant tanaman, Jam jam) {
        if (super.getStatus()==true) {
            tanaman.siram(jam);
        }
        else {
            System.out.println("Tanaman gagal disiram! Aktifkan tools penyiram tanaman terlebih dahulu!");
        }
    }
    
}

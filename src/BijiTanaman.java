public class BijiTanaman extends Tools {
    private static int jumlahBiji;
    private int cost;
    private String jenis;
    
    public BijiTanaman(int jumlahBiji, int cost, String nama) {
        super(nama,5);
        BijiTanaman.jumlahBiji=jumlahBiji;
        this.cost=cost;
        this.jenis="";
    }
    
    public BijiTanaman(int jumlahBiji, String nama) {
        super(nama,5);
        BijiTanaman.jumlahBiji=jumlahBiji;
        this.cost=0;
    }
    
    //setter
    public static void setJumlahBiji (int jumlahBiji) {
            BijiTanaman.jumlahBiji=jumlahBiji;
    }
    
    public void setJenis(String jenis){
        this.jenis=jenis;
    }
    
    //getter
    public int getJumlahBiji() {
       return BijiTanaman.jumlahBiji;
    }
    
    public int getCost() {
        return this.cost;
    }
    
    public String getJenis(){
        return this.jenis;
    }
    
    @Override
    public void printDesc() {
        System.out.println("TOOLS >> nama : " + super.getNama() + " >> cost : " + getCost());
    }
    
    //method
    public boolean tanam() {
        if (BijiTanaman.jumlahBiji>0) {
            BijiTanaman.jumlahBiji--;
            return true;
        }
        else {
            return false;
        }
    }
}

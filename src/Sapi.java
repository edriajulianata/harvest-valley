public class Sapi extends HewanTernak {
    public static int xs=(int)(Math.random() * (18));
    public static int ys=(int)(Math.random() * (20));
    public int x;
    public int y;
    
    int cost = 70;
    
    //Konstruktor
    public Sapi(String nama) {
        super(nama,xs,ys,"Sapi");
        this.x=xs;
        this.y=ys;
        xs=(int)(Math.random() * (18));
        ys=(int)(Math.random() * (20));
    }
    
//method
    public void ambilHasil(Player p) {
        if (isAdaHasil()==true) {
            Inventory x = new Items("Susu",10,15,super.getJumlahHasil()); 
            if(p.addInventory(x)){
                System.out.println("Susu berhasil disimpan di inventory!");
                setJumlahHasil(0);
                setStatHasil(false);
            }
            
        }
        else {
            System.out.println("Belum ada susu yang dihasilkan!");
        }
    } 
    
    public int getCost(){
        return cost;
    } 
    
    @Override
    public void printDesc() {
        super.printDesc();
        System.out.println(super.getNama()+" menghasilkan "+super.getJumlahHasil()+ " susu");
    }
    
    public void makan(Jam j, Player p){
            if (getStatus()==false){
                setJumlahMakan(getJumlahMakan()+1);
                setJumlahHasil(getJumlahHasil()+1);
                setStatus(true);
                setStatHasil(true);
                setTrkhrMakan(j.getHari());
                p.delInventory("Rumput");
            } else{
                System.out.println("Sudah diberi makan hari ini.");
            }
    }
}

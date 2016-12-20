public class Domba extends HewanTernak {
    public static int xd=(int)(Math.random() * (18));
    public static int yd=(int)(Math.random() * (20));
    public int x;
    public int y;
    int cost = 60;
    
        //Konstruktor
    public Domba(String nama) {
        super(nama,xd,yd,"Domba");
        this.x=xd;
        this.y=yd;
        xd=(int)(Math.random() * (18));
        yd=(int)(Math.random() * (20));
    }
    
//method
    public void ambilHasil(Player p) {
        if (isAdaHasil()==true) {
            Inventory x = new Items("Bulu",20,20,super.getJumlahHasil()); 
            if(p.addInventory(x)){
                System.out.println("Bulu berhasil disimpan di inventory!");
                setJumlahHasil(0);
                setStatHasil(false);
            }
        }
        else {
            System.out.println("Belum ada bulu yang dihasilkan!");
        }
    }   
    
    public int getCost(){
        return cost;
    } 
    
    @Override
    public void printDesc() {
        super.printDesc();
        System.out.println(super.getNama()+" menghasilkan "+super.getJumlahHasil()+ " bulu");
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

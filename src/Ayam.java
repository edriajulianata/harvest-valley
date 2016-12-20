public class Ayam extends HewanTernak {
    public static int xa=(int)(Math.random() * (10));
    public static int ya=(int)(Math.random() * (10));
    public int x;
    public int y;
    int cost = 40;
       
//Konstruktor
    public Ayam(int x, int y){
        super("ayam",x,y,"ayam");
    }
    
    public Ayam(String nama) {
        super(nama,xa,ya,"Ayam");
        this.x=xa;
        this.y=ya;
        xa=(int)(Math.random() * (10));
        ya=(int)(Math.random() * (10));
    }
    
//method
    public void ambilHasil(Player p) {
        if (isAdaHasil()==true) {
            Inventory x = new Items("Telur",10,15,super.getJumlahHasil()); 
            if(p.addInventory(x)){
                System.out.println("Telur berhasil disimpan di inventory!");
                setJumlahHasil(0);
                setStatHasil(false);
            }
        }
        else {
            System.out.println("Belum ada telur yang dihasilkan!");
        }
    }  
   
    public void printDesc() {
        super.printDesc();
        System.out.println(super.getNama()+" menghasilkan "+super.getJumlahHasil()+ " telur");
    }
    
    public int getCost(){
        return cost;
    }    
    public void makan(Jam j, Player p){
            if (getStatus()==false){
                setJumlahMakan(getJumlahMakan()+1);
                setJumlahHasil(getJumlahHasil()+1);
                setStatus(true);
                setStatHasil(true);
                setTrkhrMakan(j.getHari());
                p.delInventory("Cacing");
            } else{
                System.out.println("Sudah diberi makan hari ini.");
            }
    }
}

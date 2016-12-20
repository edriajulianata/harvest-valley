import java.util.Scanner;

public class Rumah extends Bangunan {
    Scanner input= new Scanner(System.in);
    private Inventory[] sell;
    private static int idxS;
    private KandangAyam kayam;
    private KandangSapi ksapi;
    //private static int idxB;
    
    public Rumah(int p, int l, int doorx, int doory, int x, int y){
        super(p,l,doorx,doory,x,y);
        sell= new Inventory[10];
        
        idxS=0;
        //idxB=0;
    }
    
    //setter getter
    
    
    //setter getter turunan
    public Inventory getBuy(int i){
        switch(i){
            case 2 : return (new Items("Cacing",6,9,1));
            case 3 : return (new Items("Rumput",9,12,1));
            default : return null;
        }
    }
    
    public BijiTanaman getBiji(int i){
        switch(i){
            case 1 : return (new BijiLobak(1,3,"BijiLobak"));//Lobak
            case 2 : return (new BijiKol(1,2,"BijiKol"));//Kol
            case 3 : return (new BijiJagung(1,5,"BijiJagung"));//Jagung
            default : return null;
            
        }
    }
    
    public HewanTernak getBinatang(int i){
        switch(i){
            case 4: return (new Ayam(""+(kayam.getIdx()+1)+""));
            case 5: return (new Sapi(""+(ksapi.getIdx()+1)+""));
            case 6: return (new Domba(""+(ksapi.getIdx()+1)+""));
            default: return null;
        }
        
    }
    //method
    
    public void printBuyList(){//menampilkan list barang yang bisa dibeli beserta harga
        System.out.println("Welcome to inventory store!");
        System.out.print("1. Biji Tanaman \n2. Cacing (9)\n3. Rumput (12)\n4. Ayam (40) \n5. Sapi (70) \n6. Domba (60) \nPilihan Anda : ");
    }
    
    public void printBiji(){//menampilkan list barang yang bisa dibeli beserta harga
        System.out.println("Pilihan biji:");
        System.out.print("1. Lobak (3)\n2. Kol (2)\n3. Jagung (5):\nPilihan Anda : ");
    }
  
    public void setKandang(KandangAyam kayam, KandangSapi ksapi){
        this.kayam=kayam;
        this.ksapi=ksapi;
    }
    public int idxSell(Player p, String x){//mengeluarkan index barang yang ingin dijual pada inventory player
        boolean cari=false;
        int i=0;
        while(i<10 && cari==false) {
                if (sell[i] != null && sell[i].getNama()==x) {
                    cari=true;
                }
                else {
                    i++;
                }
            }
    return i;
    }
    
    public void addSell(Inventory i){//menambahkan barang yang ingin dijual pada array sell
        this.sell[this.idxS]=i;
        this.idxS++;
    }

    public void menuRumah(Player p, Jam j, Field f, KandangAyam kandangAyam, KandangSapi kandangSapi, int hari){//menampilkan menu jika pemain berada di dalam rumah
        int pil=0;
        while(pil!=5){
            System.out.print("Option:\n1.Save\n2.Sleep\n3.Sell\n4.Buy\n5.Keluar rumah\nYour Option:");
            pil = input.nextInt();
            switch (pil){
                case 1 : p.savePlayerInv("Pemain.txt");
                         f.saveField("Field.txt");
                         kandangAyam.saveAyam("Ayam.txt");
                         kandangSapi.saveSapi("Sapi.txt");
                         j.saveJam("Jam.txt");
                         System.out.println("Berhasil save game!");
                         break;
                case 2 : j.setSleep();
                         f.gantiHari();
                         kandangAyam.gantiHari();
                         kandangSapi.gantiHari();
                         hari=j.getHari();
                         break;
                case 3 : System.out.println("Daftar barang yang akan dijual:");
                         p.printInventory();
                         System.out.print("Pilihan anda : ");
                         int sellitem = input.nextInt();
                         if(sellitem>4) { 
                            if(p.getInventory(sellitem-1)!=null){
                                Inventory sold = p.removeInventory(sellitem-1);
                                System.out.println("Index jual : " + sellitem + "Sell Item : " + sold.getNama());
                                System.out.println(sold.getNama() + " dimasukkan ke dalam kotak penjualan dan dijual seharga " + sold.getSellingPrice());
                                addSell(sold);
                                p.setGold(p.getGold()+sold.getSellingPrice());
                            }
                            else { System.out.println("Barang tidak ada, tidak bisa menjual barang.");}
                         }
                         else {
                             System.out.println("Tools wajib tidak dapat dijual.");
                         }
                         break;
                case 4 : printBuyList();
                         int buyidx = input.nextInt();
                         
                         if(buyidx>6){
                             System.out.println("Barang tidak ada, tidak bisa membeli barang.");
                         }
                         else if (buyidx==1) {
                             printBiji();
                             int bijiidx = input.nextInt();
                             if (bijiidx>3){
                                 System.out.println("Masukan salah");
                             } else{
                             BijiTanaman biji = (BijiTanaman)getBiji(bijiidx);
                             int remainGold= p.getGold()-biji.getCost();
                                if (remainGold>=0){
                                p.addInventory(biji);
                                System.out.print(biji.getNama() + " dimasukkan ke dalam inventory dan dibeli seharga " + biji.getCost());
                                //addBuy(brought);
                                p.setGold(remainGold);
                                for(int i=0; i<10; i++){
                                    if(sell[i]!=null)
                                       System.out.println(sell[i].getNama());
                                }
                                 
                                }
                             }
                         }
                         else if (buyidx==2||buyidx==3) {
                                Items brought = (Items)getBuy(buyidx);
                                int remainGold1= p.getGold()-brought.getCost();
                                if (remainGold1>=0){
                                   p.addInventory(brought);
                                   System.out.print(brought.getNama() + " dimasukkan ke dalam inventory dan dibeli seharga " + brought.getCost());
                                   //addBuy(brought);
                                   p.setGold(remainGold1);
                                   for(int i=0; i<10; i++){
                                       if(sell[i]!=null)
                                          System.out.println(sell[i].getNama());
                                   }
                                }
                                }
                         
                         else if (buyidx==4) {
                                Ayam brought = (Ayam)getBinatang(buyidx);
                                int remainGold1= p.getGold()-brought.getCost();
                                if (remainGold1>=0){
                                   kayam.addHewan(brought);
                                   System.out.print("Ayam "+brought.getNama() + " dimasukkan ke dalam inventory dan dibeli seharga " + brought.getCost());
                                   //addBuy(brought);
                                   p.setGold(remainGold1);
                                   for(int i=0; i<10; i++){
                                       if(sell[i]!=null)
                                          System.out.println(sell[i].getNama());
                                   }
                                }
                                }
                         
                         else if (buyidx==5) {
                                Sapi brought = (Sapi)getBinatang(buyidx);
                                int remainGold1= p.getGold()-brought.getCost();
                                if (remainGold1>=0){
                                   ksapi.addHewan(brought);
                                   System.out.print("Sapi "+brought.getNama() + " dimasukkan ke dalam inventory dan dibeli seharga " + brought.getCost());
                                   //addBuy(brought);
                                   p.setGold(remainGold1);
                                   for(int i=0; i<10; i++){
                                       if(sell[i]!=null)
                                          System.out.println(sell[i].getNama());
                                   }
                                }
                                }
                         
                         else if (buyidx==6) {
                                Domba brought = (Domba)getBinatang(buyidx);
                                int remainGold1= p.getGold()-brought.getCost();
                                if (remainGold1>=0){
                                   ksapi.addHewan(brought);
                                   System.out.print("Domba "+brought.getNama() + " dimasukkan ke dalam inventory dan dibeli seharga " + brought.getCost());
                                   //addBuy(brought);
                                   p.setGold(remainGold1);
                                   for(int i=0; i<10; i++){
                                       if(sell[i]!=null)
                                          System.out.println(sell[i].getNama());
                                   }
                                }
                                }
                             
                         else {
                                 System.out.print("Gold tidak cukup untuk membeli barang!");
                             }
                         
                         break;
                case 5 : p.moveAmount(0,-2);
                         System.out.print("Player keluar rumah.");
                         break;
               default : System.out.print("Masukkan salah, ulangi lagi:");
                         break;
            }
        }
    }
            
    
}

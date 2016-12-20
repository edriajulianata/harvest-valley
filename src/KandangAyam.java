import java.io.*;
import java.util.Scanner;

  

public class KandangAyam extends Kandang {

 int idx;    
    public KandangAyam(int p, int l, int doorx, int doory, int x, int y, String jenis){
        super(p,l,doorx,doory,x,y,jenis);
        idx = 0;
        /*for (int i=0;i<8;i++){
            idx++;// mulai dr 1
            String namaAyam = "" + idx + "";
            HewanTernak ayam = new Ayam(namaAyam);
            this.arrHewan[i]=ayam;
//            super.addHewan(ayam);
        }*/
    }
    
    //method
    public void addMakanan(Items x, int i,Jam j){
        super.addMakanan(x,i);
        super.arrHewan[i-1].makan(j);
        super.removeMakanan(i);
    }
    
    public int getIdx(){
        return idx; 
    }
    
    public void setIdx(int a) {
        idx=a;
    } 
    
 
    public boolean addHewan(){
        if (idx+1<20){
            if (this.arrHewan[idx]==null){
                //this.arrHewan[idxH]=h;
                
                return true;
            }
        }
        return false;
    }
    
     public void addAyam(Ayam a){
        
        if (idx+1<20){
            if (this.arrHewan[idx]==null){
                this.arrHewan[idx]=a;
                idx++;
            }
            idxH++;
        } else{
		System.out.println("Array sudah penuh, tidak bisa ditambah lagi");
        }
     }
    
    public boolean removeHewan(Jam j){
        boolean found = false;
        for (int i=0;i<idx;i++){
            if (arrHewan[i]!=null && arrHewan[i].isDead(j)){
                removeHewan(i+1);
                found = true;
            }
        }
        return found;
    }
    
    public void gantiHari() {
        for (int i=0; i<20; i++){
            if (super.arrHewan[i]!=null) {
                super.arrHewan[i].setStatus(false);
            }
        }
    }
    
    public void saveAyam(String fname) {
        try{
            PrintWriter fout;
            
            fout = new PrintWriter(fname);
            int i;
            fout.println(idx);
            for (i=0;i<idx;i++){
                if (arrHewan[i]!=null){
                fout.println(getIdx());
                fout.println(arrHewan[i].getNama());
                fout.println(arrHewan[i].getLokasi().getX());
                fout.println(arrHewan[i].getLokasi().getY());
                fout.println(arrHewan[i].getStatus());
                fout.println(arrHewan[i].getJenis());
                fout.println(arrHewan[i].getJumlahHasil());
                fout.println(arrHewan[i].getJumlahMakan());
                } else{
                System.out.println((i+1) + " gagal save");
                }
            }
            fout.close();
            
            
        } catch (Exception e){
            System.out.println(e.toString()+ "\n Save error.");
            
        }
    }
    public void loadAyam(String fname) {
            try{
                File file = new File(fname);
                Scanner in = new Scanner (file);
                int row = in.nextInt();
                int d;
                boolean b;
                int a;
                String s;
                for (int i=0;i<row;i++){
                    setIdx(in.nextInt());
                    arrHewan[i] = new Ayam("test");
                    s=in.next();
                    arrHewan[i].setNama(s);
                    d=in.nextInt();
                    arrHewan[i].setX(d);
                    d=in.nextInt();
                    arrHewan[i].setY(d);
                    b=in.nextBoolean();
                    arrHewan[i].setStatus(b);
                    s=in.next();
                    arrHewan[i].setJenis(s);
                    a=in.nextInt();
                    arrHewan[i].setJumlahHasil(a);
                    a=in.nextInt();
                    arrHewan[i].setJumlahMakan(a);
                    
                }
                in.close();
            } catch(Exception e){
                System.out.println(e.toString()+ "\nFailed to load game state.");
            }
    }
    
    
    public void printKandangAyam() {
        for (int i=0; i<20; i++){
            if (super.arrHewan[i]!=null) {
                super.arrHewan[i].printDesc();
            }
        }
    }
    
    
    public void menuKandangAyam(Player p, Items x, Jam j) {
        int pi=0;
        while(pi!=3) {
        System.out.println("Option\n1. Kasih makan ayam\n2. Ambil telur\n3. Keluar kandang ayam");
        pi = input.nextInt();
        switch(pi) {
            case 1 : 
              if (p.findItem("Cacing")) {
                int indeks = p.idxFindItem("Cacing"); 
                x = (Items) p.getInventory(indeks); 
                
                System.out.print("Masukan nomor ayam yang mau dikasih makan : ");
                     int no = input.nextInt();
                     if (super.arrHewan[no-1].getStatus()==false) {
                        addMakanan(x,no,j);
                        p.removeInventory(indeks);
                        System.out.println("Ayam " + arrHewan[no-1].getNama() + " berhasil diberi makan!");
                     }
                     else {
                         System.out.println("Ayam "+ arrHewan[no-1].getNama() +" sudah kenyang. Tidak dapat diberi makan.!");
                     }
              }
              else {
                  System.out.println("Makanan ayam tidak ada di inventory! Tidak bisa memberi makan!");
              }
                break;
                     
            case 2 : System.out.print("Masukkan nomor ayam yang ingin diambil telurnya : ");
                    int np = input.nextInt();
                        arrHewan[np-1].ambilHasil(p);
 
                    break;
            case 3 : p.moveTo(-5,-11);
                     System.out.print("Player keluar kandang ayam.");
                     break;
            default :System.out.print("Masukkan salah, ulangi lagi:");
                     break;  
        }
        }
        
    }
    
    public void printLokasiAyam(){
        boolean arr[][] = new boolean[10][10];
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                arr[i][j]=false;
            }
        }
        for (int i=0;i<8;i++){
            if(arrHewan[i]!=null){
                //System.out.println((int)arrHewan[i].getX() + " " + (int)arrHewan[i].getY());
                arr[(int)arrHewan[i].getX()][(int)arrHewan[i].getY()]=true;
            }           
        }
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                if (arr[i][j]) 
                    System.out.print("|_A_|");
                else
                    System.out.print("|___|");
            }
            System.out.println("");
        }
    }
    
}

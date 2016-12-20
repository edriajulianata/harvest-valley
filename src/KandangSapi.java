import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class KandangSapi extends Kandang {
    
    int idx;
    
    //Konstruktor
    public KandangSapi(int p, int l, int doorx, int doory, int x, int y, String jenis){
        super(p,l,doorx,doory,x,y,jenis);
        idx=0;
        /*for (int i=0;i<12;i++){
            idx++; //mulai dari 1
            if (i<6){
                String namaSapi=("" + idx + "");
                HewanTernak sapi = new Sapi(namaSapi);
                this.arrHewan[i]=sapi;
            } else{
                String namaDomba=("" + idx + "");
                HewanTernak domba = new Domba(namaDomba);
                this.arrHewan[i]=domba;
            }
        }*/
    }
    
    //Method
    public void addMakanan(Items x, int i, Jam j){
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
    
    public void removeHewan(Jam j){
        for (int i=0;i<idxH;i++){
            if (super.arrHewan[i]!=null && super.arrHewan[i].isDead(j)){
                super.removeHewan(i+1);
            }
        }
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
    
    public void addSapi (HewanTernak s){
        
        if (idx+1<20){
            if (this.arrHewan[idx]==null){
                this.arrHewan[idx]=s;
                idx++;
            }
            idxH++;
        } else{
		System.out.println("Array sudah penuh, tidak bisa ditambah lagi");
        }
     }
    
    public void addDomba (Domba d){
        
        if (idx+1<20){
            if (this.arrHewan[idx]==null){
                this.arrHewan[idx]=d;
                idx++;
            }
            idxH++;
        } else{
		System.out.println("Array sudah penuh, tidak bisa ditambah lagi");
        }
     }
    
    public void gantiHari() {
        for (int i=0; i<20; i++){
            if (super.arrHewan[i]!=null) {
                super.arrHewan[i].setStatus(false);
            }
        }
    }
    
    public void printKandangSapi() {
        for (int i=0; i<20; i++){
            if (super.arrHewan[i]!=null) {
                super.arrHewan[i].printDesc();
            }
        }
    }
   
    public void menuKandangSapi(Player p, Items x, Jam j) {
        int pi=0;
        while(pi!=3) {
        System.out.println("Option\n1. Kasih makan hewan\n2. Ambil hasil hewan\n3. Keluar kandang");
        pi = input.nextInt();
        switch(pi) {
            case 1 : 
              if (p.findItem("Rumput")) {
                int indeks = p.idxFindItem("Rumput"); 
                x = (Items) p.getInventory(indeks); 
                
                System.out.print("Masukan nomor hewan yang mau dikasih makan : ");
                     int no = input.nextInt();
                     if (super.arrHewan[no-1].getStatus()==false) {
                        addMakanan(x,no,j);
                        p.removeInventory(indeks);
                        System.out.println(super.arrHewan[no-1].getNama() +" berhasil diberi makan!");
                     }
                     else {
                         System.out.println(super.arrHewan[no-1].getNama() + " sudah kenyang. Tidak dapat diberi makan.!");
                     }
              }
              else {
                  System.out.println("Rumput tidak ada di inventory! Tidak bisa memberi makan!");
              }
                break;
                     
            case 2 : System.out.print("Masukkan nomor hewan yang ingin diambil hasilnya : ");
                    int np = input.nextInt();
                        arrHewan[np-1].ambilHasil(p);
                    break;
            case 3 : p.moveTo(3, -1);
                     System.out.print("Player keluar kandang .");
                     break;
            default :System.out.print("Masukkan salah, ulangi lagi:");
                     break;  
        }
    }
        
    }
    
    public void printLokasiSapi(){
        boolean arrS[][] = new boolean[18][20];
        boolean arrD[][] = new boolean[18][20];
        for (int i=0;i<18;i++){
            for (int j=0;j<20;j++){
                arrS[i][j]=false;
                arrD[i][j]=false;
            }
        }
        for (int i=0;i<12;i++){
            if((arrHewan[i]!=null)&&(arrHewan[i] instanceof Domba)){
                arrD[(int)arrHewan[i].getX()][(int)arrHewan[i].getY()]=true;
            } else {
                if((arrHewan[i]!=null)&&(arrHewan[i] instanceof Sapi)){
                    arrS[(int)arrHewan[i].getX()][(int)arrHewan[i].getY()]=true;
                }
            }
        }
        for (int i=0;i<18;i++){
            for (int j=0;j<20;j++){
                if (arrD[i][j]) {
                    System.out.print("|_D_|");}
                else{
                    if (arrS[i][j]) {
                        System.out.print("|_S_|");}
                    else{
                        System.out.print("|___|");}
                }
            }
            System.out.println("");
        }
    }
       
    public void saveSapi(String fname) {
        try{
            PrintWriter fout;
            
            fout = new PrintWriter(fname);
            int i;
            fout.println(idx);
            for (i=0;i<idx;i++){
                fout.println(arrHewan[i].getNama());
                fout.println(arrHewan[i].getLokasi().getX());
                fout.println(arrHewan[i].getLokasi().getY());
                fout.println(arrHewan[i].getStatus());
                if (arrHewan[i].getJenis()=="Sapi"){
                    //fout.println(arrHewan[i].getJenis());
                    fout.println(0);
                }else{
                    fout.println(1);
                }                    
                fout.println(arrHewan[i].getJumlahHasil());
                fout.println(arrHewan[i].getJumlahMakan());
            }
            fout.close();
            
            
        } catch (Exception e){
            System.out.println(e.toString()+ "\n Save error.");
            
        }
    }
    public void loadSapi(String fname) {
            try{
                File file = new File(fname);
                Scanner in = new Scanner (file);
                
                int row = in.nextInt();
                setIdx(row);
                int d1,d2;
                boolean b;
                int a1,a2,s;
                String sa;
                for (int i=0;i<row;i++){
                    sa=in.next();
                    d1=in.nextInt();
                    d2=in.nextInt();
                    b=in.nextBoolean();
                    s=in.nextInt();
                    a1=in.nextInt();
                    a2=in.nextInt();
                    if (s==0){
                        Sapi sp= new Sapi("test");
                        sp.setNama(sa);
                        sp.setX(d1);
                        sp.setY(d2);
                        sp.setStatus(b);
                        sp.setJenis("Sapi");
                        sp.setJumlahHasil(a1);
                        sp.setJumlahMakan(a2);
                        arrHewan[i]=sp;
                         //arrHewan[i] = new Sapi("test");
                    } else if (s==1){
                        Domba db=new Domba("test");
                        db.setNama(sa);
                        db.setX(d1);
                        db.setY(d2);
                        db.setStatus(b);
                        db.setJenis("Domba");
                        db.setJumlahHasil(a1);
                        db.setJumlahMakan(a2);
                        arrHewan[i]=db;
                        //arrHewan[i] = new Domba("test");
                    }else{
                        System.out.println("why");
                    }
                    
                    
                    System.out.println("sapi loaded");
                }
                in.close();
            } catch(Exception e){
                System.out.println("Sapi failed");
                System.out.println(e.toString()+ "\nFailed to load game state.");
            }
    }
}

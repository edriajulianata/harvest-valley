import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class Field {
    private static int panjang = 20;
    private static int lebar = 20;
    protected boolean[][] statpacul ;
    protected boolean[][] statready ;
    protected Plant[][] mtxPlant ;
    
    public Field(){
        mtxPlant = new Plant[20][20];
        statpacul = new boolean[20][20];
        statready = new boolean[20][20];
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                this.statpacul[i][j]=false;
                this.statready[i][j]=false;
            }
        }
    }
    
    public boolean getStat(int x, int y){
        return this.statpacul[x][y];
    }
    
    public boolean getStatR(int x, int y){
        return this.statready[x][y];
    }
    
    public void setStat(int x, int y,boolean stat){
        this.statpacul[x][y]=stat;
    }
    
    public void setStatR(int x, int y,boolean stat){
        this.statready[x][y]=stat;
    }
    
    public Plant getPlant(int x, int y){
        return this.mtxPlant[x][y];
    }
    
    public void tanam (BijiTanaman biji, String nama, String jenis, int x, int y){
        int xx = (int) x;
        int yy = (int) y;
        if((mtxPlant[xx][yy]==null)){
            if (biji instanceof BijiJagung){
                mtxPlant[xx][yy] = new Jagung(nama,jenis,x,y);
                System.out.println("Berhasil menanam " + nama);
            } else if (biji instanceof BijiKol){
                mtxPlant[xx][yy] = new Kol(nama,jenis,x,y);
                System.out.println("Berhasil menanam " + nama);
            } else if (biji instanceof BijiLobak){
                mtxPlant[xx][yy] = new Lobak(nama,jenis,x,y);
                System.out.println("Berhasil menanam " + nama);
            } else{
                System.out.println("Gagal menanam.");
            }
                
        }
        else {
            System.out.println("Sudah ada tanaman pada titik (" + xx + "," + yy + "). Tidak bisa menanam tanaman.");
        }
    }
    
    public Inventory panen(Player p, int x, int y){
        if((mtxPlant[x][y]!=null)){
            Plant t = mtxPlant[x][y];
            if(t.getFase() == "Panen"){
  
                if (t instanceof Lobak){
                    t.setFase("Ilalang");
                    //System.out.println("Lobak telah panen, silahkan membeli biji kembali");
                    Inventory i = new Items("Lobak",10,12,1);
                    System.out.println("Tanaman berhasil dipanen!");
                    return i;
                } else if (t instanceof Kol){
                    t.setFase("Ilalang");
                    //System.out.println("Kol sudah panen, silahkan membeli biji kembali");
                    Inventory i = new Items("Kol",12,14,1);
                    System.out.println("Tanaman berhasil dipanen!");
                    return i;
                } else if (t instanceof Jagung){
                    //System.out.println("Jagung sudah panen, bisa dipanen kembali");
                    if(((Jagung) t).getPanen()<=2){
                        t.setFase("Tumbuh");
                        t.setPenyiraman(0);
                        t.setStatus(false);
                    } else{
                        t.setFase("Ilalang");
                    }
                    Inventory i = new Items("Jagung",16,18,1);
                    System.out.println("Tanaman berhasil dipanen!");
                    return i;
                } else {
                    System.out.println("Gagal panen.");
                    return null;
                }
            } else {
                System.out.print("Player tidak berinteraksi dengan tanaman");
                return null;
            }
        } else {
                System.out.print("Tidak ada tanaman pada lokasi");
                return null;
        }
    }
    
    public void hapus(Arit a,int x, int y){ 
        
            if((mtxPlant[x][y]!=null)){
                //if(mtxPlant[x][y].isPlayerBerinteraksi(p)){
                    mtxPlant[x][y]=null;
                    if(mtxPlant[x][y]==null){
                    System.out.println("Tanaman berhasil diarit!");}
                //} else {
                //    System.out.print("Player tidak berinteraksi dengan tanaman");
                //}
            }
            else {
                System.out.print("Tidak ada tanaman pada lokasi");
            }
    }
    
    public void removeTanaman(Jam jam) {
        for (int i=0;i<panjang;i++){
            for (int j=0;j<lebar;j++){
                if (mtxPlant[i][j]!=null && mtxPlant[i][j].isDead(jam)){
                    mtxPlant[i][j]=null;
                }
            }
        }
    }
    
    public void siram(PenyiramTanaman s,int x, int y, Jam j){ 
        
            if((mtxPlant[x][y]!=null)){
                //if(mtxPlant[x][y].isPlayerBerinteraksi(p)){
                    s.siramTanaman(mtxPlant[x][y],j);
            }else if (mtxPlant[x][y]==null){
                if(getStat(x,y)){
                    setStatR(x,y,true);
                    setStat(x,y,false);
                }
            }
    }
    
    public void pacul(int x, int y) {
            if ((mtxPlant[x][y]==null)&&(!statpacul[x][y])) {
               this.statpacul[x][y]=true;
            }
    }  
    
    public void gantiHari(){
        for (int i=0;i<panjang;i++){
            for (int j=0;j<lebar;j++){
                if (mtxPlant[i][j] != null) 
                    mtxPlant[i][j].setStatus(false);
            }
        }
    }
    
    public void printDescTanaman(){
        for (int i=0;i<panjang;i++){
            for (int j=0;j<lebar;j++){
                if (mtxPlant[i][j] != null) { 
                    mtxPlant[i][j].printDesc();
                }
            }
        }
    }
    
   /* public void panen(Player p, int x, int y){
        if((mtxPlant[x][y]!=null)){
            Inventory i = getPlant(x,y).panen();
            if (i!=null)
                p.addInventory(i);
            else
                System.out.print("Tanaman tidak bisa dipanen");
        } else System.out.print("Tidak ada tanaman pada lokasi");
    }*/
    
    public void printLokasi(){
        for (int i=0;i<panjang;i++){
            for (int j=0;j<lebar;j++){
                if (mtxPlant[i][j] != null) 
                    System.out.print("|_T_|");
                else
                    System.out.print("|___|");
            }
            System.out.println("");
        }
    }
    
    public void saveField(String fname) {
        try{
            PrintWriter fout;
            
            fout = new PrintWriter(fname);
            int i; int j;
            int idx=0;
            int idxP=0;
            int idxR=0;
            
            for (i=0;i<20;i++){
                for (j=0;j<20;j++){
                    if (mtxPlant[i][j]!=null){
                        idx++;
                    }else{
                    if (getStat(i,j)){
                        idxP++;
                    }
                    if (getStatR(i,j)){
                        idxR++;
                    }
                    
                    }
                    
                }
            }
            fout.println(idxP);
            for (i=0;i<20;i++){
                for (j=0;j<20;j++){
                    if (getStat(i,j)){
                        fout.println(i);
                        fout.println(j);
                    }
                }
            }
            
            fout.println(idxR);
            for (i=0;i<20;i++){
                for (j=0;j<20;j++){
                    if (getStatR(i,j)){
                        fout.println(i);
                        fout.println(j);
                    }
                }
            }
            
            
            fout.println(idx);
            for (i=0;i<20;i++){
                for (j=0;j<20;j++){
                    if (mtxPlant[i][j]!=null){
                        fout.println(i);
                        fout.println(j);
                        fout.println(mtxPlant[i][j].getJenis());
                        fout.println(mtxPlant[i][j].getNama());
                        fout.println(mtxPlant[i][j].getFase());
                        fout.println(mtxPlant[i][j].getPenyiraman());
                        fout.println(mtxPlant[i][j].getLokasi().getX());
                        fout.println(mtxPlant[i][j].getLokasi().getY());
                        fout.println(mtxPlant[i][j].getStatus());
                        fout.println(mtxPlant[i][j].getHari());
                    }
                }
            }
            fout.close();
            
            
        } catch (Exception e){
            System.out.println(e.toString()+ "\n Save error.");
            
        }
    }
    
    public void loadField(String fname) {
            try{
                File file = new File(fname);
                Scanner in = new Scanner (file);
                int i;int j;
                int x; 
                String s;
                int a;
                int q;
                boolean b;
                
                int idxP = in.nextInt();
                for (x=0;x<idxP;x++){
                    i = in.nextInt();
                    j = in.nextInt();
                    setStat(i,j,true);
                }
                
                int idxR = in.nextInt();
                for (x=0;x<idxR;x++){
                    i = in.nextInt();
                    j = in.nextInt();
                    setStatR(i,j,true);
                }
                
                int idx = in.nextInt();
                for (x=0;x<idx;x++){
                    i = in.nextInt();
                    j = in.nextInt();
                    s = in.next();
                    switch (s){
                        case "Kol":
                            mtxPlant[i][j]=new Kol ("test","test",1,1);
                            break;
                        case "Lobak":
                            mtxPlant[i][j]=new Lobak ("test","test",1,1);
                            break;
                        case "Jagung":
                            mtxPlant[i][j]=new Jagung ("test","test",1,1);
                            break;
                        default:
                            mtxPlant[i][j]=null;
                    }
                    mtxPlant[i][j].setJenis(s);
                    s = in.next();
                    mtxPlant[i][j].setNama(s);
                    s = in.next();
                    mtxPlant[i][j].setFase(s);
                    q = in.nextInt();
                    mtxPlant[i][j].setPenyiraman(q);
                    a = in.nextInt();
                    mtxPlant[i][j].getLokasi().setX(a);
                    a = in.nextInt();
                    mtxPlant[i][j].getLokasi().setY(a);
                    b = in.nextBoolean();
                    mtxPlant[i][j].setStatus(b);
                    q = in.nextInt();
                    mtxPlant[i][j].setHari(q);
                }
                
                //System.out.println("berhasil");
                in.close();
            } catch(Exception e){
                System.out.println(e.toString()+ "\nFailed to load game state.");
            }
    }
    
    
}

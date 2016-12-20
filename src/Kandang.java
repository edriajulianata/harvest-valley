import java.util.Scanner;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

public class Kandang extends Bangunan {
    Scanner input = new Scanner(System.in);
    private String jenis;
    private int jumlah = 20;
    protected HewanTernak[] arrHewan;
    protected Items[] arrMakanan;
    protected int idxH;
    protected int idxM;
    
    public Kandang(int p, int l, int doorx, int doory, int x, int y, String jenis){
        super(p,l,doorx,doory,x,y);
        this.jenis=jenis;
        this.jumlah=jumlah;
        arrHewan = new HewanTernak[this.jumlah];
        for (int i=0; i<this.jumlah; i++) {
            arrHewan[i]=null;
        }
        arrMakanan = new Items[this.jumlah];
        this.idxH=0;
        this.idxM=0;
    }
    
    //setter getter
    public String getJenis(){
        return this.jenis;
    }
    
    public int getJumlah(){
        return this.jumlah;
    }
   
    public void setJenis(String p){
        this.jenis=p;
    }
    
    

    
    //method
    public boolean addHewan(HewanTernak h){
        if (idxH<this.jumlah){
            if (this.arrHewan[idxH]==null){
                this.arrHewan[idxH]=h;
                idxH++;
                idxM++;
                return true;
            }
        }
        return false;
    }
    
    public HewanTernak removeHewan(int i){
        if ((i-1)>=this.idxH){
		return null;
        } else{
            if ((i<=idxH)&&(i>=0)){
                HewanTernak x = this.arrHewan[i-1];
		this.arrHewan[i-1]=null;
                if(i==idxH){
                    this.idxH--;
                    this.idxM--;
                }
		return x;
            } else return null;
	}
    }
    
    public void addMakanan(Items i, int idx){
        this.arrMakanan[idx-1]=i;
    }
    
    public void removeMakanan(int i){
        this.arrMakanan[i-1]=null;
    }

    public void saveHewan(String fname) {
        try{
            PrintWriter fout;
            
            fout = new PrintWriter(fname);
            int i;
            int j= 20;
            fout.println(j);
            for (i=0;i<j;i++){
                fout.println(arrHewan[i].getNama());
                fout.println(arrHewan[i].getLokasi().getX());
                fout.println(arrHewan[i].getLokasi().getY());
                fout.println(arrHewan[i].getStatus());
                fout.println(arrHewan[i].getJenis());
                fout.println(arrHewan[i].getJumlahHasil());
                fout.println(arrHewan[i].getJumlahMakan());
            }
            fout.close();
            
            
        } catch (Exception e){
            System.out.println(e.toString()+ "\n Save error.");
            
        }
    }
}

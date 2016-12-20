public class Plant {
    private String nama;
    private String fase;
    private String jenis;
    private boolean status;
    private Point lokasi;
    private int penyiraman;
    private int hariterakhirsiram;
    private int hariini;
    
    //kontruktor
    public Plant(String nama, String jenis, int x, int y){
        this.nama = nama;
        this.fase = "Biji";
        this.jenis = jenis;
        this.status = false;
        this.lokasi = new Point(x,y);
        this.penyiraman=0;
    }
    
    //setter
    public void setNama (String nama){
        this.nama = nama;
    }
    
    public void setFase(String fase){
        this.fase = fase;
    }
    
    public void setJenis(String jenis){
        this.jenis = jenis;
    }
    
    public void setStatus(boolean stat){
        this.status=stat;
    }
    
   /* public void setStatus(Jam j){
        while(status==true){
            if (j.getHari()-hariini==1){
                this.status = false;
            }
        }
    }*/
    
    public void setHari(int hariterakhirsiram){
        this.hariterakhirsiram=hariterakhirsiram;
    }
    
    public void setPenyiraman(int x){
        this.penyiraman=x;
    }
    
    //getter
    public String getNama(){
        return this.nama;
    }
    
    public String getFase (){
        return this.fase;
    }
    
    public String getJenis(){
        return this.jenis;
    }
    
    public boolean getStatus(){
        return this.status;
    }
    
    public Point getLokasi(){
        return this.lokasi;
    }
    
    public int getHari(){
        return this.hariterakhirsiram;
    }
    
    public int getPenyiraman(){
        return this.penyiraman;
    }
    
    //method
    public void siram (Jam j){
        if ((selisihHari(j)>0)&&(status==false)){
            this.penyiraman++;
            this.setStatus(true);
            this.hariterakhirsiram=j.getHari();
            if(this.fase == "Biji"){
                this.fase = "Tumbuh";
            } else if (this.fase == "Tumbuh"){
                this.fase = "Panen";
            }
            System.out.println("Tanaman berhasil disiram!"+status);
        } else System.out.println("Tanaman sudah disiram. Tidak boleh disiram lagi.");
    }
    
    public boolean sudahSiram(Jam j) {
        if ((selisihHari(j)>0)&&(status==false)){
            return true;
        }
        else return false;
    }
    
    
    
    public int selisihHari(Jam j){
        return j.getHari()-hariterakhirsiram;
    }
    
    public boolean isDead(Jam j){
        if (selisihHari(j)>3){
            return true;
        } else return false;
    }
    
    public Inventory panen(){
        if (this.fase == "Panen"){
            if (this.jenis == "Lobak"){
                this.fase = "Ilalang";
                //System.out.println("Lobak telah panen, silahkan membeli biji kembali");
                Inventory i = new Items("Lobak",10,12,1); return i;
            } else if (this.jenis == "Kol"){
                this.fase = "Ilalang";
                //System.out.println("Kol sudah panen, silahkan membeli biji kembali");
                Inventory i = new Items("Kol",12,14,1);return i;
            } else if (this.jenis == "Jagung"){
                //System.out.println("Jagung sudah panen, bisa dipanen kembali");
                this.fase = "Tumbuh";
                Inventory i = new Items("Jagung",16,18,1);return i;
            } else return null;
        }
        else return null;
    }
    
    public boolean isPanen() {
        if (this.fase=="Panen") {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isPlayerBerinteraksi(Player p){
        return (((p.getLokasi().getY() == lokasi.getY()+1)||(p.getLokasi().getY() == lokasi.getY()-1)||(p.getLokasi().getY() == lokasi.getY()))&&((p.getLokasi().getX() == lokasi.getX()-1)||(p.getLokasi().getX() == lokasi.getX()+1)||(p.getLokasi().getX() == lokasi.getX())));
    }
    
    public void printDesc(){
        System.out.println("Nama Tanaman : " + nama + ", Fase : " + fase + ", Jenis : " + jenis + ", Status : " + status + ", Lokasi : (" + lokasi.getX() + "," + lokasi.getY() +")" );
    }
    
}

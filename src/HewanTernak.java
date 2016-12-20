public class HewanTernak implements Movable{

	private String nama;
	private Point lokasi;
	private boolean status;//return true jika kenyang
	private String jenis;
        private  int jumlahHasil=0;
        private  int jumlahMakan=0;
        private int hariterakhirmakan;
        private int hariini;
        private boolean stathasil=false; //return true jika ada
	
	
        
	//konstruktor
	public HewanTernak(String nama, int x, int y, String jenis) {
		this.nama = nama;
		this.lokasi = new Point(x,y);
		this.jenis = jenis;
		this.status = false;
                hariterakhirmakan = 0;
	}
        
        // setter
        public void setNama (String nama){
            this.nama = nama;
        }
        public void setJenis(String j){
            this.jenis=j;
        }
        public void setX (int x){
            this.lokasi.setX(x);
        }
        public void setY(int y){
            this.lokasi.setY(y);
        }
        public void setLokasi (int x, int y){
            this.lokasi.setX(x);
            this.lokasi.setY(y);
        }
        
        public void setJumlahHasil(int jmlHsl) {
            this.jumlahHasil=jmlHsl;
        }
        
        public void setJumlahMakan(int jmlMkn) {
            this.jumlahMakan=jmlMkn;
        }
        
        // getter
        public void setHari(Jam j){
            this.hariterakhirmakan = j.getHari();
        }
        
        public void setStatHasil(boolean b){
            stathasil=b;
        }
        
        public boolean getStatHasil(){
            return stathasil;
        }
        
        
        public String getNama (){
            return this.nama;
        }
	public int getX(){
            return this.lokasi.getX();
        }
        public int getY(){
            return this.lokasi.getY();
        }
        
        public Point getLokasi(){
            return this.lokasi;
        }
        
        public String getJenis(){
            return this.jenis;
        }
                
        public int getJumlahHasil() {
            return this.jumlahHasil;
        }
        
        public int getJumlahMakan() {
            return this.jumlahMakan;
        }
        
        // method
        public boolean getStatus(){
            return this.status;
        }
        
        public void setTrkhrMakan(int i){
            hariterakhirmakan=i;
        }
        
        public void setStatus(boolean stat){
            this.status = stat;
        }
        
        public void setStatus(Jam j){
        while(status==true){
            if (j.getHari()-hariini==1){
                this.status = false;
            }
        }
    }
        
        // method
        public void ambilHasil (Player p){
        }
        
        public boolean isAdaHasil(){
            return (this.stathasil);
        }
        
        
        public int selisihHari(Jam j){
        return j.getHari()-hariterakhirmakan;
        }

        public boolean isDead(Jam j){
            if (selisihHari(j)>4){
                return true;
            } else return false;
        }
               
        public void makan(Jam j){
            if (status==false){
                this.jumlahMakan++;
                this.jumlahHasil++;
                this.status=true;
                this.stathasil=true;
                this.hariterakhirmakan=j.getHari();
                
            } else{
                System.out.println("Sudah diberi makan hari ini.");
            }
        }
        
        public void printDesc(){
            if (this.getStatus()){
                System.out.println(getNama()+" kenyang");
            } else System.out.println(getNama() + " lapar");
        }
        
        @Override
        public void moveAmount(int dX, int dY){
        this.lokasi.setX(lokasi.getX()+dX);
        this.lokasi.setY(lokasi.getY()+dY);
        }
    
        public void moveTo(int dx, int dy){
            this.lokasi.setX(dx);
            this.lokasi.setY(dy);
        }

        public void resetPosition(){
            this.lokasi.setX(0);
            this.lokasi.setY(0);
        }
        
        //baru
        public boolean isPlayerBerinteraksi(Player p){
            return (((p.getLokasi().getY() == getY()+1)||(p.getLokasi().getY() == getY()-1))&&((p.getLokasi().getX() == getX()-1)||(p.getLokasi().getX() == getX()+1)));
        }
	
}

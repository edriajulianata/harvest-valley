public class Inventory {

	private String nama;
        private int sellingPrice;
	
	//konstruktor
	public Inventory(String nama, int sellingPrice) {
		this.nama = nama;
                this.sellingPrice=sellingPrice;
	}
	
	//method getter
	public String getNama() {
		return this.nama;
	}
	
	//method setter
	public void setNama(String nama) {
		this.nama=nama;
	}
	
        public int getSellingPrice() {
            return this.sellingPrice;
        } 
        
        public void setSellingPrice(int sellingPrice) {
            this.sellingPrice=sellingPrice;
        }
        
	//method printDesc
	public void printDesc() {
		System.out.println("INVENTORY >> name : " + this.nama);
	}
}

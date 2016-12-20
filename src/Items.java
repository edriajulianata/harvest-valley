public class Items extends Inventory {

	private int cost;
        private int jumlah;
	
	//konstruktor
	public Items(String nama, int sellingPrice, int cost, int jumlah) {
		super(nama,sellingPrice);
		this.cost=cost;
                this.jumlah = jumlah;
	}
	
	//getter
	public int getCost() {
		return this.cost;
	}
		
	//setter
	public void setCost(int cost) {
		this.cost=cost;
	}
	
	//method printDesc

        @Override
	public void printDesc() {
		//super.printDesc();
		System.out.println("ITEMS >> " +super.getNama() + " cost : " + this.cost + ", selling price : " + super.getSellingPrice());
	}
	
}

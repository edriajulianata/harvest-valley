public class Tools extends Inventory {

	
	private boolean status; //untuk mengeset tools aktif atau tidak
	
	
	//konstruktor
	public Tools(String nama, int sellingPrice) { 
		super(nama,sellingPrice);
		this.status = false;
	}
	
	//set keaktifan
	public void setStatus(boolean aktif) {
            this.status=aktif;
        }
        
        public boolean getStatus() {
            return this.status;
        }
  
	//method printTools

        @Override
	public void printDesc() {
		System.out.println("TOOLS >> nama : " + super.getNama() + " >> status : " + this.status);
	}

}

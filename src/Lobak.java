/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class Lobak extends Plant{
   /* private String nama;
    private String fase;
    final String jenis;
    private boolean status;
    private Point lokasi;
    private int penyiraman;
    private int hariterakhirsiram;
    private int hariini;*/

    public Lobak(String nama, String jenis, int x, int y) {
        super(nama, jenis, x, y);
        this.setJenis("Lobak");
    }
    
    @Override
    public void siram (Jam j){
        if ((selisihHari(j)>0)&&(getStatus()==false)){ 
            this.setStatus(true);
            this.setPenyiraman(getPenyiraman()+1);
            this.setHari(j.getHari());
            if("Biji".equals(this.getFase())){
                this.setFase("Tumbuh");
            } else if ("Tumbuh".equals(this.getFase()) && this.getPenyiraman()>=3){
                this.setFase("Panen");
            }
            System.out.println("Tanaman berhasil disiram! ");
        } else System.out.println("Tanaman sudah disiram. Tidak boleh disiram lagi.");
    }
    
    
}

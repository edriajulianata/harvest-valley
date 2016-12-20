/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class BijiJagung extends BijiTanaman {
    private static int jumlahBiji;
    private int cost=5;
    private String jenis;

    public BijiJagung(int jumlahBiji, int cost, String nama) {
        super(jumlahBiji, cost, nama);
        this.jenis="Jagung";
        this.setNama("BijiJagung");
    }
    
    @Override
    public boolean tanam() {
        if (this.jumlahBiji>0) {
            this.jumlahBiji--;
            return true;
        }
        else {
            return false;
        }
    }
    
    
}

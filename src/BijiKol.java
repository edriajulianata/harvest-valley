/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class BijiKol extends BijiTanaman {
    private static int jumlahBiji;
    private int cost=2;
    private String jenis;

    public BijiKol(int jumlahBiji, int cost, String nama) {
        super(jumlahBiji, cost, nama);
        this.jenis="Kol";
        this.setNama("BijiKol");
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

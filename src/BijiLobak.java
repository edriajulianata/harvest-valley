/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class BijiLobak extends BijiTanaman{
    private static int jumlahBiji;
    private int cost=3;
    private String jenis="Lobak";

    public BijiLobak(int jumlahBiji, int cost, String nama) {
        super(jumlahBiji, cost, nama);
        this.jenis="Lobak";
        this.setNama("BijiLobak");
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

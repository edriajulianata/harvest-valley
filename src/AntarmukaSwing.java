/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edria Julianata
 */


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AntarmukaSwing extends JPanel implements ActionListener {
 
    private static AntarmukaSwing antarmukaSwing;
    private final Image pacul;
    private final Image rumput;
    private final Image siram;
    private final Image arit;
    private final Image cacing;
    private final Image telur;
    private final Image bulu;
    private final Image susu;
    private final Image kol;
    private final Image jagung;
    private final Image lobak;
    private final Image ayam;
    private final Image sapi;
    private final Image domba;
    private final Image bijiJagung;
    private final Image bijiLobak;
    private final Image bijiKol;
    private final Image map;
    
    private Player p;
    private KandangAyam kayam;
    private KandangSapi kasap;
    
    
    
    private AntarmukaSwing(Player orang, KandangAyam aa, KandangSapi pp) {
    //dx = Pencipta.getPencipta();
    pacul = new ImageIcon("pic\\Pacul.png").getImage();
    rumput = new ImageIcon("pic\\Rumput.png").getImage();
    siram = new ImageIcon("pic\\WaterCan.png").getImage();
    arit = new ImageIcon("pic\\Arit.png").getImage();
    cacing = new ImageIcon("pic\\Cacing.png").getImage();
    telur = new ImageIcon("pic\\Telur.png").getImage();
    bulu = new ImageIcon("pic\\Feather.png").getImage();
    susu = new ImageIcon("pic\\Susu.png").getImage();
    kol = new ImageIcon("pic\\Kol.png").getImage();
    jagung = new ImageIcon("pic\\Corn.png").getImage();
    lobak = new ImageIcon("pic\\Lobak.png").getImage();
    ayam = new ImageIcon("pic\\CHCD.png").getImage();
    sapi = new ImageIcon("pic\\COD.png").getImage();
    domba = new ImageIcon("pic\\SHPD.png").getImage();
    bijiJagung = new ImageIcon("pic\\bijiJagung.png").getImage();
    bijiLobak = new ImageIcon("pic\\bijiLobak.png").getImage();
    bijiKol = new ImageIcon("pic\\bijiKol.png").getImage();
    map = new ImageIcon("pic\\Inventory.png").getImage();
    
    this.p = orang;
    kayam=aa;
    kasap=pp;
    }
    
    
 public static AntarmukaSwing getAntarmukaSwing(Player orang,KandangAyam aa, KandangSapi pp) {
    if (antarmukaSwing == null) {
      antarmukaSwing = new AntarmukaSwing(orang,aa,pp);
    }
    return antarmukaSwing;
  }
 
 
 public void render(final Graphics2D g2) {
     
     g2.drawImage(map,0,0,null);
        for (int i=0; i<20; i++){
            if (p.arrayInv[i]!=null) {             
            String in = p.getNama(i);
            switch(in) {
                case "Pacul" :
                    g2.drawImage(pacul,200,100, this);break;
                case "Arit" :
                    g2.drawImage(arit,400,100, this);break;
                case "Penyiram Tanaman" :
                    g2.drawImage(siram,300,90, this);break;
                case "Rumput" :
                    g2.drawImage(rumput,300,200, this);break;
                    //g2.drawString((String.valueOf(p.rumput)),350,200);break;
                case "Cacing" :
                    g2.drawImage(cacing,200,200,this);break;
                   // g2.drawString((String.valueOf(p.cacing)),250,200); break;
                    
                case "Telur" :
                    g2.drawImage(telur,200,300,this);break;
                    //g2.drawString((String.valueOf(p.telur)),250,300);break;
                case "Bulu" :
                    g2.drawImage(bulu,300,300,this);break;
                    //g2.drawString((String.valueOf(p.telur)),350,300);break;
                case "Susu" :
                    g2.drawImage(susu,400,300,this);break;
                    //g2.drawString((String.valueOf(p.telur)),450,300);break;  
                case "Kol" :
                    g2.drawImage(kol,200,400,this);break;
                case "Jagung" :
                    g2.drawImage(jagung,300,400,this);break;
                case "Lobak" :
                    g2.drawImage(lobak,400,400,this);break;       
                case "BijiJagung" :
                    g2.drawImage(bijiJagung,200,500,this);break;                     
                case "BijiLobak" :
                    g2.drawImage(bijiLobak,300,500,this);break; 
                case "BijiKol" :
                    g2.drawImage(bijiKol,400,500,this);break; 
                default :
                    break;
            }
            g2.drawString("TOOLS", 100, 120);
            g2.drawString("MAKANAN", 100, 220);
            g2.drawString("HASIL TERNAK", 100, 320);
            g2.drawString("HASIL PANEN", 100, 420);
            g2.drawString("BENIH", 100, 520);
            g2.drawImage(ayam,100,590,this);
            g2.drawString(String.valueOf(kayam.getIdx()), 150, 620);
            g2.drawImage(sapi,200,590,this);
            g2.drawImage(domba,220,590,this);
            g2.drawString(String.valueOf(kasap.getIdx()), 270, 620);
            
            
            }
        }

     
 }
 
   public void paint(final Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

    g2.setRenderingHints(rh);

    render(g2);
  }
   
   
public void actionPerformed(final ActionEvent e) {
    repaint();
  }
    
}

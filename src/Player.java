import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;
import java.util.*;

public class Player extends Objek implements Movable {
   protected String nama;
    protected static int Gold;
    protected Inventory [] arrayInv;
    protected Point lokasi;
    protected static int lastIdx;
 
    public char arah;
    public int uang=10000;
    private java.util.List<Object> listObjek=new ArrayList<Object>();
    
    //buat quantity tapi ribet ah mlz
    //INI ABAIKAN SAJA.
    protected int cacing=0;
    protected int rumput=0;
    protected int bijiJagung=0;
    protected int bijiLobak=0;
    protected int bijiKol=0;
    
    protected int telur=0;
    protected int bulu=0;
    protected int susu=0;
    
    //konstruktor
    public Player(){
        this.arah ='D';
        this.x    =8;
        this.y    =5;
        setPic();
        this.nama = "Je";
        this.Gold = 10000;
        this.arrayInv = new Inventory [20];
        this.lastIdx=4;
        this.lokasi = new Point(-1,0);
        this.arrayInv[0] = new Pacul();
        this.arrayInv[1] = new PenyiramTanaman();
        this.arrayInv[2] = new Arit();
        this.arrayInv[3] = new BijiTanaman(0,0,"Tools Biji Tanaman");
     }
    
    public Player(String n){
        this.arah ='D';
        this.x    =8;
        this.y    =5;
        this.nama =n;
        setPic();
        this.Gold = 10000;
        this.arrayInv = new Inventory [20];
        this.lastIdx=4;
        this.lokasi = new Point(-1,0);
        this.arrayInv[0] = new Pacul();
        this.arrayInv[1] = new PenyiramTanaman();
        this.arrayInv[2] = new Arit();
        this.arrayInv[3] = new BijiTanaman(0,0,"Tools Biji Tanaman");
	}
    
    //getter setter
    public String getNama(){
        return this.nama;
    }
    
    public void setNama(String nama){
        this.nama=nama;
    }
    
    public int getGold(){
        return this.Gold;
    }
    
    public void setGold(int gold){
        this.Gold=gold;
    }
    
   public Inventory[] getInventory(){
       return this.arrayInv;
   }
   
   public Inventory getInventory(int i) {
       return this.arrayInv[i];
   }
   
   public void setInventory(Inventory[] i){
       this.arrayInv=i;
   }
   
   public int getLastIdx(){
       return this.lastIdx;
   }
   
   public void setLastIdx(int i){
       this.lastIdx=i;
    }
   public Point getLokasi(){
       return this.lokasi;
   }
   
   public void setLokasi(Point lok){
       this.lokasi=lok;
   }
    
    //interface
   @Override
    public void moveAmount(int dX, int dY){
        this.lokasi.setX(lokasi.getX()+dX);
        this.lokasi.setY(lokasi.getY()+dY);
    }
    
    @Override
    public void moveTo(int dx, int dy){
        this.lokasi.setX(dx);
        this.lokasi.setY(dy);
    }
    
    @Override
    public void resetPosition(){
        this.lokasi.setX(0);
        this.lokasi.setY(0);
    }
    
    public Inventory removeInventory(int i){
        Inventory result = arrayInv[i];
        for(int x=i;x<19;x++){
            this.arrayInv[x]=arrayInv[x+1];
        }
        this.arrayInv[19]=null;
        this.lastIdx--;
        return result;
    }

    
    public boolean addInventory(Inventory x){
        if (lastIdx<12){
		this.arrayInv[lastIdx]=x;
		this.lastIdx++;
                return true;
        } else{
		System.out.println("Array sudah penuh, tidak bisa ditambah lagi");
                return false;
        }
    }
    
    public String getNama(int i) {
        return arrayInv[i].getNama();
    }
    
    /*public int findBiji() {
        boolean cari=false;
        int i=0;
        while(i<20 && cari==false && arrayInv[i]!=null) {
                if ((arrayInv[i].getNama()== "BijiKol")||(arrayInv[i].getNama()== "BijiLobak")||(arrayInv[i].getNama()== "BijiJagung")) {
                    cari=true;
                }
        }
        return i;
    }*/
    
    
    
    public void printInventory(){
        for (int i=0; i<20; i++){
            if(arrayInv[i]!=null){
                //this.arrayInv[i].printDesc();
                if (arrayInv[i] instanceof Tools){
                    arrayInv[i].printDesc();
                } else {
                    if (arrayInv[i] instanceof Items){
                        arrayInv[i].printDesc();
                    }
                }
            }
        }
    }
    
    public void setPic(){
		switch(this.arah){
			case 'R':this.pic=new JLabel( new ImageIcon(Img.P_KANAN1.url) );break;
			case 'L':this.pic=new JLabel( new ImageIcon(Img.P_KIRI1.url) );break;
			case 'U':this.pic=new JLabel( new ImageIcon(Img.P_ATAS1.url) );break;
			case 'D':this.pic=new JLabel( new ImageIcon(Img.P_BAWAH1.url) );break;
		}
	}
    
    public boolean findItem(String nama) {
        boolean cari=false;
        int i=0;
        while(i<20 && cari==false && arrayInv[i]!=null) {
                if ((arrayInv[i].getNama()== nama)) {
                    cari=true;
                }
                else {
                    i++;
                }
            }
        
    return cari;
    }
    
    public int idxFindItem(String nama) {
        boolean cari=false;
        int i=0;
        while(i<20 && cari==false) {
                if (arrayInv[i] != null && arrayInv[i].getNama().equals(nama)) {
                    cari=true;
                }
                else {
                    i++;
                }
            }
    return i;
    }
    
    public void delInventory(String s){
        if (findItem(s)){
            int o=idxFindItem(s);
            arrayInv[o]=null;
            for (int i=o;i<lastIdx;i++){
                arrayInv[i]=arrayInv[i+1];
            }
            lastIdx--;
        }
    }
    
    public void printDesc(){
       Point p = getLokasi();
       System.out.println("Nama Player: " + getNama());
       System.out.println("Jumlah Gold: "+ getGold());
       System.out.print("Lokasi Pemain: ");
       p.printPoint();   
    }   

  
    public void savePlayerInv(String fname){
        try{
            PrintWriter fout;
            
            fout = new PrintWriter(fname);
           
            fout.println(nama);
            fout.println(Gold);
            fout.println(lokasi.getX());
            fout.println(lokasi.getY());
            
            int i;
            fout.println(lastIdx);
            for (i=4;i<lastIdx;i++){
                fout.println(arrayInv[i].getNama());
                fout.println(arrayInv[i].getSellingPrice());
            }
          
            fout.close();
            
            
        } catch (Exception e){
            System.out.println(e.toString()+ "\n Save error.");
            
        }
    }
    
    public void loadPlayerInv(String fname){
        try{
                File file = new File(fname);
                Scanner in = new Scanner (file);
                
                setNama(in.next());
                setGold(in.nextInt());
                getLokasi().setX(in.nextInt());
                getLokasi().setY(in.nextInt());
                
                
                int i=4;
                lastIdx=in.nextInt();
                String s;
                int a;
                for (i=4;i<lastIdx;i++){
                    s = in.next();
                    a = in.nextInt();
                    Inventory n;
                    switch(s){
                        case "Cacing" : 
                            n=new Items(s,a,9,1);break;
                        case "Rumput" : 
                            n= new Items(s,a,12,1);break;
                        case "BijiKol" : 
                            n= new BijiKol(1,2,s);break;
                        case "BijiLobak" : 
                            n= new BijiLobak(1,3,s);break;
                        case "BijiJagung" : 
                            n= new BijiJagung(1,5,s);break;
                        default :
                            n=null;
                    }
                    this.arrayInv[i]=n;
                }
                
                /*int x= in.nextInt();
                String s;
                int a;
                
                s = in.next();
                while(s!=null){
                    a = in.nextInt();
                    Inventory n;
                    switch(s){
                        case "Cacing" : 
                            n=new Items(s,a,9,1);break;
                        case "Rumput" : 
                            n= new Items(s,a,12,1);break;
                        case "Biji Kol" : 
                            n= new BijiKol(1,2,s);break;
                        case "Biji Lobak" : 
                            n= new BijiLobak(1,3,s);break;
                        case "Biji Jagung" : 
                            n= new BijiJagung(1,5,s);break;
                        default :
                            n=null;
                    }
                    this.arrayInv[i]=n;
                    i++;
                    s=in.next();
                } */
                in.close();
            } catch(Exception e){
               // System.out.println(e.toString()+ "\nFailed to load game state.");
            }
    }


}



 


import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Jam extends Thread {
    //private Thread th;
    private boolean running;
    protected boolean sleep;
    private boolean stop;
    private int hari;
    private static int menit;
    private static int jam;
    

    //Konstruktor
    public Jam() {
            running=true;
            sleep=false;
            stop=false;
            this.hari=1;
            menit=0;
            jam=6;
    }

    //method run
    public void run() {
        while(running){
            try{
                Thread.sleep(1000);
                if(menit==60){
                    jam=jam+1;
                    menit=1;
                }
                if(jam==24){
                    hari=hari+1;
                    jam=1;
                }
                menit++;
                if(stop){
                    this.interrupt();
                }
                if(sleep){
                    throw new Exception("sleep");
                }
                
            }catch(InterruptedException ex){
                running=false;
                menit=0;
                jam=0;
                hari=0;
            }catch(Exception e){
                this.sleeping();
                sleep=false;
                System.out.println(printJam());
            }
            
                
            

        }
    }
    
    public int getHari(){
        return this.hari;
    }
    
    public int getJam(){
        return this.jam;
    }
    
    public int getMenit(){
        return this.menit;
    }
    
    public void setHari(int h){
        this.hari=h;
    }
    
    public void setJam(int j){
        this.jam=j;
    }
    
    public void setMenit(int m){
        this.menit=m;
    }
    
    public void stopRun(){
        this.stop=true;
    }
    
    public void play(){
        this.running=true;
        this.sleep=false;
    }
    
    public void setSleep(){
        this.sleep=true;
    }
    
    public void sleeping(){
        this.hari=this.hari+1;
        this.jam=6;
        this.menit=0;
    }
    
    //Method print jam
    public String printJam(){
            return "Hari ke-"+hari +" : Pukul "+ jam + ":" + menit ;
    }
    
    public void saveJam(String fname) {
        try{
            PrintWriter fout;
            
            fout = new PrintWriter(fname);
            fout.println(hari);
            fout.println(jam);
            fout.println(menit);
            fout.close();
            
            
        } catch (Exception e){
            System.out.println(e.toString()+ "\n Save error.");
            
        }
    }
    public void loadJam(String fname) { 
            try{
                File file = new File(fname);
                Scanner in = new Scanner (file);
                
                setHari(in.nextInt());
                setJam(in.nextInt());
                setMenit(in.nextInt());
                in.close();
            } catch(Exception e){
                System.out.println(e.toString()+ "\nFailed to load game state.");
            }
    }
}	


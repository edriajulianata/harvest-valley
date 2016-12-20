import java.util.Scanner;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.net.URL;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Stage extends Thread  {
	private StageMap stagemap;
	private Integer w=0,h=0;
	private JFrame frame=new JFrame("HARVEST VALLEY");
	private JPanel world=new JPanel();
	private JPanel area=new JPanel();
        private JFrame frame1=new JFrame("menu");
	private final int px=16;
	private final int q=40;	
        boolean gantiHari = false;

	private Player orang;
	private Jam jam = new Jam();
	private JLabel curTime=new JLabel(jam.printJam(),JLabel.RIGHT);
        private JLabel gold= new JLabel();
        private JLabel name= new JLabel();
	private char state='1';
	
        //instansiasi
        KandangAyam kandangAyam = new KandangAyam(10,10,-5,-10,-5,-15,"Ayam");
        KandangSapi kandangSapi = new KandangSapi(20,18,3,-2,10,-12,"Sapi dan Domba");
        Rumah   rumah   = new Rumah(18,18,-5,2,-12,12);
        Field field = new Field();
        int hari = jam.getHari();
        
        private AntarmukaSwing gui;
        
        
	{
            JFrame.setDefaultLookAndFeelDecorated(true);
            frame.setIconImage(new ImageIcon("pic/icon.jpg").getImage());
            world.setLayout(null);
            area.setLayout(null);
            frame.setSize(q*px,q*px);

            frame.setLayout(null);
            frame.setLocation(400,25);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.setVisible(false);
            //curTime.setBackground(new Color(200,200,0));
            curTime.setIcon(new ImageIcon("src/sign1.png"));
            curTime.setIconTextGap(-170);
            curTime.setOpaque(true);
            curTime.setLayout(null);
            
            gold.setIcon(new ImageIcon("src/sign2.png"));
            gold.setIconTextGap(-70);
            gold.setOpaque(true);
            gold.setLayout(null);
            
            name.setIcon(new ImageIcon("src/sign2.png"));
            name.setIconTextGap(-70);
            name.setOpaque(true);
            name.setLayout(null);
	}

	public Stage(String n){
           
                if(n=="mulai"){
                this.mainMenu();
		//this.newGame(n);

		frame1.setVisible(true);
                frame.setVisible(false);
            } else if(n=="load"){
                this.load();
		//frame1.setVisible(true);
                frame.setVisible(true);
            }
	}

	public void mainMenu(){

		newGame("peta");

	}
        

	public void newGame(String n){
		orang=new Player(n);
		//*
                /*
                KandangAyam kandangAyam = new KandangAyam(10,10,-5,-10,-5,-15,"Ayam");
                KandangSapi kandangSapi = new KandangSapi(20,18,3,-2,10,-12,"Sapi dan Domba");
                Rumah   rumah   = new Rumah(18,18,-5,2,-12,12);
                Field field = new Field();*/
               // Jam jam = new Jam();
                //jam.start();
               
                //JPanel gamePanel = new JPanel();
                //Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
                //gamePanel.drawImage(background, 0, 0, null);
                try{
                    //frame.setVisible(false);
                BufferedImage img1 = ImageIO.read(new File("D:\\Tubes OOP\\HarvestValley\\src\\HarvestValley.jpg"));
                
		
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setContentPane(new JLabel(new ImageIcon(img1)));
                frame1.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                JTextField t=new JTextField(20);
                frame1.add(t, gbc);
                //JLabel l=;
                frame1.add(new JLabel("Player name :"), gbc);
                JButton b = new JButton("OK");
                frame1.add(b, gbc);
                
                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
		//panel.setBackground(new Color(205,183,158));
                //JTextField t=new JTextField(20);
		//JLabel l=new JLabel("Player name :");
		//JButton b=new JButton("OK");
		//panel.setSize(q*px,q*px);
		//panel.add(l);
		//panel.add(t);
		//panel.add(b);
		//frame.add(panel);
                
                b.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(t.getText().length()>0){
						orang.setNama(t.getText());
                                                name.setText(t.getText());
						frame1.setVisible(false);
                                                
						state='2';
						frame.requestFocus();
                                                frame.setVisible(true);
						refresh();
                                                
						jam.start();
						start();
                                                
					}
				}
			}
		);/**/
                } catch (IOException e){
                    System.out.println("no image");
                }
		
                //if(state=='2'){
                JPanel paneljam=new JPanel();
                //paneljam.add(new JLabel(new ImageIcon(Img.Sign.url))); // NOI18N
                paneljam.setBackground(new Color(0,0,0,0));
                //paneljam.add(top);
		paneljam.add(curTime);
                //paneljam.add(gold);
                paneljam.setBounds(400,10,200,35);
		frame.add(paneljam);
                
                JPanel panelgold=new JPanel();
                //paneljam.add(new JLabel(new ImageIcon(Img.Sign.url))); // NOI18N
                panelgold.setBackground(new Color(0,0,0,0));
                //paneljam.add(top);
		panelgold.add(gold);
                //paneljam.add(gold);
                panelgold.setBounds(50,10,100,35);
		frame.add(panelgold);
		
                name.setFont(new java.awt.Font("Trebuchet MS", Font.BOLD, 14));
                JPanel panelname=new JPanel();
                //paneljam.add(new JLabel(new ImageIcon(Img.Sign.url))); // NOI18N
                panelname.setBackground(new Color(0,0,0,0));
                //paneljam.add(top);
		panelname.add(name);
                //paneljam.add(gold);
                panelname.setBounds(250,10,100,35);
		frame.add(panelname);

		JPanel mm=new JPanel();
		mm.add(orang.pic);
		mm.setBounds(( (int) this.px/2 )*this.q,( (int) this.px/2 -1 )*this.q,q,q*2);
		mm.setBackground(new Color(00,20,20,0));
		this.frame.add(mm);
		stagemap=new StageMap(n);
		this.gambar();//}
         
	}

        
        public void load(){
                orang = new Player();
                orang.loadPlayerInv("Pemain.txt");
                field.loadField("Field.txt");
                
                kandangAyam.loadAyam("Ayam.txt");
                kandangSapi.loadSapi("Sapi.txt");
                jam.loadJam("Jam.txt");
                this.hari=jam.getHari();
                state='2';
                frame.requestFocus();
                frame.setVisible(true);
                refresh();

                jam.start();
                start();
                JPanel paneljam=new JPanel();
                //paneljam.add(new JLabel(new ImageIcon(Img.Sign.url))); // NOI18N
                paneljam.setBackground(new Color(0,0,0,0));
                //paneljam.add(top);
		paneljam.add(curTime);
                //paneljam.add(gold);
                paneljam.setBounds(400,10,200,35);
		frame.add(paneljam);
                
                JPanel panelgold=new JPanel();
                //paneljam.add(new JLabel(new ImageIcon(Img.Sign.url))); // NOI18N
                panelgold.setBackground(new Color(0,0,0,0));
                //paneljam.add(top);
		panelgold.add(gold);
                //paneljam.add(gold);
                panelgold.setBounds(50,10,100,35);
		frame.add(panelgold);
		
                name.setText(orang.getNama());
                name.setFont(new java.awt.Font("Trebuchet MS", Font.BOLD, 14));
                JPanel panelname=new JPanel();
                //paneljam.add(new JLabel(new ImageIcon(Img.Sign.url))); // NOI18N
                panelname.setBackground(new Color(0,0,0,0));
                //paneljam.add(top);
		panelname.add(name);
                //paneljam.add(gold);
                panelname.setBounds(250,10,100,35);
		frame.add(panelname);

		JPanel mm=new JPanel();
		mm.add(orang.pic);
		mm.setBounds(( (int) this.px/2 )*this.q,( (int) this.px/2 -1 )*this.q,q,q*2);
		mm.setBackground(new Color(00,20,20,0));
		this.frame.add(mm);
		stagemap=new StageMap("peta");
		this.gambar();//}
                for(int i=0;i<20;i++){
                    for(int j=0;j<20;j++){
                        if(field.getStat(i,j)){
                            int xx=i+25;
                            int yy=j+3;
                            JPanel xYz=new JPanel();
                            xYz.add(new JLabel(new ImageIcon(Img.FLD2.url)));
                            xYz.setBackground(new Color(0,0,0,0));
                            xYz.setBounds((xx+px)*q,(yy+1+px)*q,q,q+5);
                            world.add(xYz);
                            world.setComponentZOrder(xYz,0);
                            System.out.println("Field loaded");
                        }
                        if(field.getStatR(i,j)){
                            int xx=i+25;
                            int yy=j+3;
                            JPanel xYz=new JPanel();
                            xYz.add(new JLabel(new ImageIcon(Img.FLD3.url)));
                            xYz.setBackground(new Color(0,0,0,0));
                            xYz.setBounds((xx+px)*q,(yy+1+px)*q,q,q+5);
                            world.add(xYz);
                            world.setComponentZOrder(xYz,0);
                            System.out.println("Field loaded");
                        }
                        if(field.mtxPlant[i][j]!=null){
                            int xx=i+25;
                            int yy=j+3;
                            if(field.mtxPlant[i][j].getJenis()=="Kol"){
                                if(field.mtxPlant[i][j].getFase()=="Biji"){
                                    JPanel xYz=new JPanel();
                                    xYz.add(new JLabel(new ImageIcon(Img.FLD4.url)));
                                    xYz.setBackground(new Color(0,0,0,0));
                                    xYz.setBounds((xx+px)*q,(yy+1+px)*q,q,q+5);
                                    world.add(xYz);
                                    world.setComponentZOrder(xYz,0);
                                    System.out.println("Field loaded");
                                }
                        //LANJUTIN YA INI PER FASENYA SAMA PER TANEMANNYA//
                            }
                           /* if(field.mtxPlant[i][j].getJenis()=="Kol"){
                                if(field.mtxPlant[i][j].getFase()=="Tumbuh"){
                                    JPanel xYz=new JPanel();
                                    xYz.add(new JLabel(new ImageIcon(Img.CBG1.url)));
                                    xYz.setBackground(new Color(0,0,0,0));
                                    xYz.setBounds((xx+px)*q,(yy+1+px)*q,q,q+5);
                                    world.add(xYz);
                                    world.setComponentZOrder(xYz,0);
                                    System.out.println("Field loaded");
                                }
                            }
                            if(field.mtxPlant[i][j].getJenis()=="Kol"){
                                if(field.mtxPlant[i][j].getFase()=="Panen"){
                                    JPanel xYz=new JPanel();
                                    xYz.add(new JLabel(new ImageIcon(Img.CBG2.url)));
                                    xYz.setBackground(new Color(0,0,0,0));
                                    xYz.setBounds((xx+px)*q,(yy+1+px)*q,q,q+5);
                                    world.add(xYz);
                                    world.setComponentZOrder(xYz,0);
                                    System.out.println("Field loaded");
                                }
                            }*/
         
                        }
                
                    }
                }
                
                for(int i=0;i<20;i++){
                    if(kandangAyam.arrHewan[i]!=null){
                        int xx=kandangAyam.arrHewan[i].getX()+13;
                        int yy=kandangAyam.arrHewan[i].getY()+34;
                        if(kandangAyam.arrHewan[i].getStatus()){
                        JPanel xYz=new JPanel();
                        xYz.add(new JLabel(new ImageIcon(Img.CHCR.url)));
                        xYz.setBackground(new Color(0,0,0,0));
                        xYz.setBounds((xx+px)*q,(yy+1+px)*q,q,q+5);
                        world.add(xYz);
                        world.setComponentZOrder(xYz,0);
                        System.out.println("Ayam loaded");
                        } else {
                        JPanel xYz=new JPanel();
                        xYz.add(new JLabel(new ImageIcon(Img.CHCH.url)));
                        xYz.setBackground(new Color(0,0,0,0));
                        xYz.setBounds((xx+px)*q,(yy+1+px)*q,q,q+5);
                        world.add(xYz);
                        world.setComponentZOrder(xYz,0);
                        System.out.println("Ayam loaded");
                        }
                    }
                }
                
                for(int i=0;i<20;i++){
                    if(kandangSapi.arrHewan[i]!=null){
                        int xx=kandangSapi.arrHewan[i].getX()+25;
                        int yy=kandangSapi.arrHewan[i].getY()+26;
                        System.out.println("loaded");
                        if(kandangSapi.arrHewan[i].getJenis()=="Sapi"){
                            if(kandangSapi.arrHewan[i].getStatus()){
                            JPanel xYz=new JPanel();
                            xYz.add(new JLabel(new ImageIcon(Img.COR.url)));
                            xYz.setBackground(new Color(0,0,0,0));
                            xYz.setBounds((xx+px)*q,(yy+1+px)*q,q,q+5);
                            world.add(xYz);
                            world.setComponentZOrder(xYz,0);
                            System.out.println("Sapi loaded");
                            } else {
                            JPanel xYz=new JPanel();
                            xYz.add(new JLabel(new ImageIcon(Img.COH.url)));
                            xYz.setBackground(new Color(0,0,0,0));
                            xYz.setBounds((xx+px)*q,(yy+1+px)*q,q,q+5);
                            world.add(xYz);
                            world.setComponentZOrder(xYz,0);
                            System.out.println("Sapi loaded");
                            }
                        } else {
                            if(kandangSapi.arrHewan[i].getStatus()){
                            JPanel xYz=new JPanel();
                            xYz.add(new JLabel(new ImageIcon(Img.SHPR.url)));
                            xYz.setBackground(new Color(0,0,0,0));
                            xYz.setBounds((xx+px)*q,(yy+1+px)*q,q,q+5);
                            world.add(xYz);
                            world.setComponentZOrder(xYz,0);
                            System.out.println("Domba loaded");
                            } else {
                            JPanel xYz=new JPanel();
                            xYz.add(new JLabel(new ImageIcon(Img.SHPH.url)));
                            xYz.setBackground(new Color(0,0,0,0));
                            xYz.setBounds((xx+px)*q,(yy+1+px)*q,q,q+5);
                            world.add(xYz);
                            world.setComponentZOrder(xYz,0);
                            System.out.println("Domba loaded");
                            }
                        }
                    }
                }
        }        
        
        
        
        

	public void run(){
		try{
			while(1<2){
                            
				curTime.setText(jam.printJam());
                                curTime.setFont(new java.awt.Font("Trebuchet MS", Font.BOLD, 14));
                                gold.setText("$"+orang.getGold());
                                gold.setFont(new java.awt.Font("Trebuchet MS", Font.BOLD, 14));
                                Thread.sleep(1000);
                                if(jam.getHari()>this.hari){
                                    field.gantiHari();
                                    kandangAyam.gantiHari();
                                    kandangSapi.gantiHari();
                                    hari=jam.getHari();
                                    if(stagemap.canRemoveTanaman(field,jam)){
                                        for (int i=0;i<20;i++){
                                            for (int j=0;j<20;j++){
                                                if (field.mtxPlant[i][j]!=null && field.mtxPlant[i][j].isDead(jam)){
                                                    field.mtxPlant[i][j].setFase("Ilalang");
                                                    JPanel xYz=new JPanel();
                                                    xYz.add(new JLabel(new ImageIcon(Img.CBG3.url)));
                                                    xYz.setBackground(new Color(0,0,0,0));
                                                    xYz.setBounds((i+25+px)*q,(j+4+px)*q,q,q+5);
                                                    world.add(xYz);
                                                    world.setComponentZOrder(xYz,0);
                                                    System.out.println("RIP TANAMAN");
                                                }
                                            }
                                        }
                                    }
                                    
                                    if(stagemap.canRemoveAyam(kandangAyam,jam)) {
                                        for (int i=0;i<20;i++){
                                                if (kandangAyam.arrHewan[i]!=null && kandangAyam.arrHewan[i].isDead(jam)){
                                                    //f.mtxPlant[i][j]=null;
                                                    Ayam a = (Ayam) kandangAyam.arrHewan[i];
                                                    kandangAyam.arrHewan[i]=null;
                                                    kandangAyam.idx--;
                                                    JPanel xYz=new JPanel();
                                                    xYz.add(new JLabel(new ImageIcon(Img.FLOOR1.url)));
                                                    xYz.setBackground(new Color(0,0,0,0));
                                                    xYz.setBounds((a.x+13+px)*q,(a.y+35+px)*q,q,q+5);
                                                    world.add(xYz);
                                                    world.setComponentZOrder(xYz,0);
                                                    System.out.println("Deleted!!");
                                                }
                                           
                                        }
                                    }
                                    
                                    if(stagemap.canRemoveSapi(kandangSapi,jam)) {
                                        for (int i=0;i<20;i++){
                                                if (kandangSapi.arrHewan[i]!=null && kandangSapi.arrHewan[i].isDead(jam)){
                                                    //f.mtxPlant[i][j]=null;
                                                    if(kandangSapi.arrHewan[i].getJenis()== "Sapi"){
                                                        Sapi a = (Sapi) kandangSapi.arrHewan[i];
                                                        JPanel xYz=new JPanel();
                                                        xYz.add(new JLabel(new ImageIcon(Img.FLOOR1.url)));
                                                        xYz.setBackground(new Color(0,0,0,0));
                                                        xYz.setBounds((a.x+25+px)*q,(a.y+27+px)*q,q,q+5);
                                                        world.add(xYz);
                                                        world.setComponentZOrder(xYz,0);
                                                        System.out.println("Deleted!!");
                                                    }else if (kandangSapi.arrHewan[i].getJenis()== "Domba"){
                                                        Domba a = (Domba) kandangSapi.arrHewan[i];
                                                        JPanel xYz=new JPanel();
                                                        xYz.add(new JLabel(new ImageIcon(Img.FLOOR1.url)));
                                                        xYz.setBackground(new Color(0,0,0,0));
                                                        xYz.setBounds((a.x+25+px)*q,(a.y+27+px)*q,q,q+5);
                                                        world.add(xYz);
                                                        world.setComponentZOrder(xYz,0);
                                                        System.out.println("Deleted!!");
                                                    }
                                                    kandangSapi.arrHewan[i]=null;
                                                    kandangSapi.idx--;
                                                }
                                        }
                                    }
                                    for (int i=0;i<20;i++){
                                        if (kandangAyam.arrHewan[i]!=null){
                                            //f.mtxPlant[i][j]=null;
                                            Ayam a = (Ayam) kandangAyam.arrHewan[i];
                                            JPanel xYz=new JPanel();
                                            xYz.add(new JLabel(new ImageIcon(Img.FLOOR1.url)));
                                            xYz.setBackground(new Color(0,0,0,0));
                                            xYz.setBounds((a.x+13+px)*q,(a.y+35+px)*q,q,q+5);
                                            world.add(xYz);
                                            world.setComponentZOrder(xYz,0);
                                            JPanel abc = new JPanel();
                                            abc.add(new JLabel(new ImageIcon(Img.CHCH.url)));
                                            abc.setBackground(new Color(0,0,0,0));
                                            abc.setBounds((a.x+13+px)*q,(a.y+35+px)*q,q,q+5);
                                            world.add(abc);
                                            world.setComponentZOrder(abc,0);
                                            System.out.println("Ayam Hungryy!!");
                                        }
                                        if (kandangSapi.arrHewan[i]!=null){
                                            //f.mtxPlant[i][j]=null;
                                            if(kandangSapi.arrHewan[i].getJenis()== "Sapi"){
                                                Sapi a = (Sapi) kandangSapi.arrHewan[i];
                                                JPanel xYz=new JPanel();
                                                xYz.add(new JLabel(new ImageIcon(Img.FLOOR1.url)));
                                                xYz.setBackground(new Color(0,0,0,0));
                                                xYz.setBounds((a.x+25+px)*q,(a.y+27+px)*q,q,q+5);
                                                world.add(xYz);
                                                world.setComponentZOrder(xYz,0);
                                                JPanel abc = new JPanel();
                                                abc.add(new JLabel(new ImageIcon(Img.COH.url)));
                                                abc.setBackground(new Color(0,0,0,0));
                                                abc.setBounds((a.x+25+px)*q,(a.y+27+px)*q,q,q+5);
                                                world.add(abc);
                                                world.setComponentZOrder(abc,0);
                                                System.out.println("Hungryy!!");
                                            }else if (kandangSapi.arrHewan[i].getJenis()== "Domba"){
                                                Domba a = (Domba) kandangSapi.arrHewan[i];
                                                JPanel xYz=new JPanel();
                                                xYz.add(new JLabel(new ImageIcon(Img.FLOOR1.url)));
                                                xYz.setBackground(new Color(0,0,0,0));
                                                xYz.setBounds((a.x+25+px)*q,(a.y+27+px)*q,q,q+5);
                                                world.add(xYz);
                                                world.setComponentZOrder(xYz,0);
                                                JPanel abc = new JPanel();
                                                abc.add(new JLabel(new ImageIcon(Img.SHPH.url)));
                                                abc.setBackground(new Color(0,0,0,0));
                                                abc.setBounds((a.x+25+px)*q,(a.y+27+px)*q,q,q+5);
                                                world.add(abc);
                                                world.setComponentZOrder(abc,0);
                                                System.out.println("Hungryy!!");
                                            }
                                        }
                                    }
                                    
                                }
                        }
		}catch(Exception e){

		}
	}

	public void gambar(){
        //frame.setSize(q*px,q*px);
		world.setBounds(0,0,this.stagemap.w()*q+2*px*q, this.stagemap.h()*q+2*px*q);
		area.setBounds(0,0,this.stagemap.w()*q+2*px*q, this.stagemap.h()*q+2*px*q);
		for(int i=-10;i<this.stagemap.w()+10;i++){
			for(int j=-10;j<this.stagemap.h()+10;j++){

				char c=this.stagemap.mapObjAt(i,j);
				ImageIcon pic=new ImageIcon(Img.UNDEF.url);
				for(Img k : Img.values())if(k.c==c)pic=new ImageIcon(k.url);
								
				JPanel m=new JPanel();
				m.add(new JLabel(pic));
				m.setBackground(new Color(0,0,0,0));
				m.setBounds((i+px)*q,(j+px)*q,q,q+5);
				world.add(m);

//*
				char cc=this.stagemap.mapAreaAt(i,j);
				pic=new ImageIcon(Img.ImgBg.LATAR.url);
				for(Img.ImgBg k : Img.ImgBg.values()){
					if(k.c==cc){
						pic=new ImageIcon(k.url);
					}
				}
								
				m=new JPanel();
				m.add(new JLabel(pic));
				m.setBackground(new Color(0,0,0,0));
				m.setBounds((i+px)*q,(j+px)*q,q,q+5);
				area.add(m);/**/

			}
		}

		area.setBackground(new Color(0,0,0,0));
		world.setBackground(new Color(0,0,0,0));
		this.frame.add(world);
		this.frame.add(area);
		frame.setVisible(true);

		int dx=orang.x-(int) this.px/2;
		int dy=orang.y-(int) this.px/2;
		this.goTo(dx,dy);

		//frame.setComponentZOrder(world,1);
	}

	public boolean isPassable(char x){
		for(Img i : Img.values())if(i.c==x)return i.passable;
		return false;
	}
	public void goTo(int x, int y){
		this.world.setLocation((-x-px)*q,(-y-px)*q);
		this.area.setLocation((-x-px)*q,(-y-px)*q);
		this.frame.setVisible(true);
	}


	public int getWidth(){return this.stagemap.w();}
	public int getHeight(){return this.stagemap.h();}

	public void refresh(){
		world.setLocation(world.getX()-2,world.getY());
		world.setLocation(world.getX()+2,world.getY());
		//area.setLocation(area.getX()+2,area.getY());
		//area.setLocation(area.getX()-2,area.getY());
	}

	public void mulai(){
		this.frame.addKeyListener(new Stage.BacaKey());
                this.frame.addMouseListener(new Stage.BacaMouse());
                //this.frame.addMouseMotionListener(new Stage.BacaKey());
	}


	class BacaKey/* extends Thread*/ implements KeyListener{


		public void keyTyped(KeyEvent e){}
		public void keyPressed(KeyEvent e) {
			if(state=='2'){
				if(e.getKeyCode() == KeyEvent.VK_RIGHT && _moveCode==' '){
					System.out.println("ke kanan "+orang.x+" "+orang.y);
					_moveCode='R';move.start();
				}else
				if(e.getKeyCode() == KeyEvent.VK_LEFT && _moveCode==' '){
					System.out.println("ke kiri "+orang.x+" "+orang.y);
					_moveCode='L';move.start();
				}else
				if(e.getKeyCode() == KeyEvent.VK_UP && _moveCode==' '){
					System.out.println("ke atas "+orang.x+" "+orang.y);
					_moveCode='U';move.start();
				}else
				if(e.getKeyCode() == KeyEvent.VK_DOWN && _moveCode==' '){
					System.out.println("ke bawah "+orang.x+" "+orang.y);
					_moveCode='D';move.start();
				}else
				if(e.getKeyCode() == KeyEvent.VK_Z){
					System.out.println("aksi 1");
					_actCode='Z';act.start();
				}else
				if(e.getKeyCode() == KeyEvent.VK_X){
					System.out.println("aksi 2");
					_actCode='X';act.start();
				}else
                                if(e.getKeyCode() == KeyEvent.VK_C){
					System.out.println("aksi 3");
					_actCode='C';act.start();
				}
                                if(e.getKeyCode() == KeyEvent.VK_V){
					System.out.println("Tanam Kol");
					_actCode='V';act.start();
				}
                                if(e.getKeyCode() == KeyEvent.VK_B){
					System.out.println("aksi arit");
					_actCode='B';act.start();
				}
                                if(e.getKeyCode() == KeyEvent.VK_S){
					System.out.println("sleep");
					_actCode='S';act.start();
				}
                                if(e.getKeyCode() == KeyEvent.VK_N){
					System.out.println("Panen");
					_actCode='N';act.start();
                                }
                                if(e.getKeyCode() == KeyEvent.VK_Q){
					System.out.println("Save");
					_actCode='Q';act.start();
                                }
                                if(e.getKeyCode() == KeyEvent.VK_A){
					System.out.println("Tanam Jagung");
					_actCode='A';act.start();
                                }
                                if(e.getKeyCode() == KeyEvent.VK_P){
					System.out.println("Tanam Lobak");
					_actCode='P';act.start();
                                }
                                if(e.getKeyCode() == KeyEvent.VK_F){
					System.out.println("Feed");
					_actCode='F';act.start();
                                }
                                if(e.getKeyCode() == KeyEvent.VK_L){
					System.out.println("Collect");
					_actCode='L';act.start();
                                }
                                if(e.getKeyCode() == KeyEvent.VK_I){
					System.out.println("Inventory");
					_actCode='I';act.start();
                                }
                                if(e.getKeyCode() == KeyEvent.VK_J){
					System.out.println("Belanja");
					_actCode='J';act.start();
                                }
                                if(e.getKeyCode() == KeyEvent.VK_K){
					System.out.println("Jual item");
					_actCode='K';act.start();
                                }
                                if(e.getKeyCode() == KeyEvent.VK_M){
					System.out.println("Jual item");
					_actCode='M';act.start();
                                }
				else System.out.println("..");
			}
		}
		public void keyReleased(KeyEvent e){}
	}
        
        
        public class BacaMouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (state=='2') {
                System.out.println(e.getX()+" , "+e.getY());
                
                
                if ((e.getX()<573&&e.getX()>473) && (e.getY()<400&&e.getY()>300)) {
                    System.out.println(e.getX()+" , "+e.getY());
                    int remainGold1= orang.getGold()-9;
                    if (remainGold1>=0) {
                        orang.addInventory(new Items("Cacing",6,9,1));
                        orang.setGold((orang.getGold()-9));
                        System.out.println("Berhasil beli cacing");
                        orang.cacing++;
                    }
                }
                else if ((e.getX()<167&&e.getX()>54) && (e.getY()<576&&e.getY()>446)) {
                    System.out.println(e.getX()+" , "+e.getY());
                    int remain = orang.getGold()-12;
                    if(remain>=0) {
                        orang.addInventory(new Items("Rumput",9,12,1));
                        orang.setGold(orang.getGold()-12);
                        System.out.println("Berhasil beli rumput");
                        orang.rumput++;
                    }
                }
                else if ((e.getX()<419&&e.getX()>346) && (e.getY()<576&&e.getY()>446)){
                    System.out.println(e.getX()+" , "+e.getY());
                    int remain = orang.getGold()-3;
                    if(remain>=0) {
                        orang.addInventory(new BijiLobak(1,3,"BijiLobak"));
                        orang.setGold(orang.getGold()-3);
                        System.out.println("Berhasil beli biji lobak");
                        orang.bijiLobak++;
                    }
                }
                else if ((e.getX()<573&&e.getX()>473) && (e.getY()<576&&e.getY()>446)) {
                    System.out.println(e.getX()+" , "+e.getY());
                    int remain = orang.getGold()-2;
                    if(remain>=0) {
                        orang.addInventory(new BijiKol(1,2,"BijiKol"));
                        orang.setGold(orang.getGold()-2);
                        System.out.println("Berhasil beli biji kol");
                        orang.bijiKol++;
                    }
                }
                else if ((e.getX()<338&&e.getX()>212) && (e.getY()<576&&e.getY()>446)) {
                    System.out.println(e.getX()+" , "+e.getY());
                    int remain = orang.getGold()-5;
                    if(remain>=0) {
                        orang.addInventory(new BijiJagung(1,5,"BijiJagung"));
                        orang.setGold(orang.getGold()-5);
                        System.out.println("Berhasil beli biji jagung");
                        orang.bijiJagung++;
                    }
                }
                else if ((e.getX()<338&&e.getX()>212) && (e.getY()<400&&e.getY()>300)) { //AYAM
                    System.out.println(e.getX()+" , "+e.getY());
                    int remain = orang.getGold()-40;
                    if(remain>=0) {
                        int idxaym=kandangAyam.idx;
                        Ayam a = new Ayam(""+idxaym+"");
                        int xA = a.x+13;
                        int yA = a.y+35;
                        
                        //Kandang k = (Kandang) kandangAyam;
                        if(stagemap.addAyam(xA, yA)){
                            if(kandangAyam.addHewan()){
                                kandangAyam.addAyam(a);
                                orang.setGold(orang.getGold()-40);
                                a.setHari(jam);
                                JPanel xYz=new JPanel();
                                xYz.add(new JLabel(new ImageIcon(Img.CHCH.url)));
                                xYz.setBackground(new Color(0,0,0,0));
                                xYz.setBounds((xA+px)*q,(yA+px)*q,q,q+5);
                                world.add(xYz);
                                world.setComponentZOrder(xYz,0);
                                System.out.println("added! ayam");
                                System.out.println(kandangAyam.idx);                                                    
                                _actTimes=4;
                            }
                            else _actTimes=1;
                        }
                    }
                }
                else if ((e.getX()<167&&e.getX()>54) && (e.getY()<400&&e.getY()>300)) { //SAPI
                    System.out.println(e.getX()+" , "+e.getY());
                    int remain = orang.getGold()-60;
                    if(remain>=0) {
                    int idxsp=kandangSapi.idx;
                    Sapi a = new Sapi(""+idxsp+"");
                    int xA = a.x+25;
                    int yA = a.y+27;
                    
                    //Kandang k = (Kandang) kandangSapi;
                    if(stagemap.addSapi(xA, yA)){
                        if(kandangSapi.addHewan()){
                            kandangSapi.addSapi(a);
                            orang.setGold(orang.getGold()-60);
                            a.setHari(jam);
                            JPanel xYz=new JPanel();
                            xYz.add(new JLabel(new ImageIcon(Img.COH.url)));
                            xYz.setBackground(new Color(0,0,0,0));
                            xYz.setBounds((xA+px)*q,(yA+px)*q,q,q+5);
                            world.add(xYz);
                            world.setComponentZOrder(xYz,0);
                            System.out.println("added! sapi");
                            _actTimes=4;
                        }
                    }else _actTimes=1;
                    }
                }
                else if ((e.getX()<419&&e.getX()>346) && (e.getY()<400&&e.getY()>300)) { //DOMBA
                    System.out.println(e.getX()+" , "+e.getY());
                    int remain = orang.getGold()-70;
                    if(remain>=0) {
                        int idxsp=kandangSapi.idx;
                        Domba a = new Domba(""+idxsp+"");
                        int xA = a.x+25;
                        int yA = a.y+27;
                        
                        //Kandang k = (Kandang) kandangSapi;
                        if(stagemap.addSapi(xA, yA)){
                            if(kandangSapi.addHewan()){
                                kandangSapi.addSapi(a);
                                orang.setGold(orang.getGold()-70);
                                a.setHari(jam);
                                JPanel xYz=new JPanel();
                                xYz.add(new JLabel(new ImageIcon(Img.SHPH.url)));
                                xYz.setBackground(new Color(0,0,0,0));
                                xYz.setBounds((xA+px)*q,(yA+px)*q,q,q+5);
                                world.add(xYz);
                                world.setComponentZOrder(xYz,0);
                                System.out.println("added! domba");
                                _actTimes=4;
                            }
                        }else _actTimes=1;
                    }
                }
                else if ((e.getX()<171&&e.getX()>65) && (e.getY()<133&&e.getY()>46)) {
                    if (orang.findItem("Susu")) {
                        orang.delInventory("Susu");
                        orang.setGold(orang.getGold()+550);
                        System.out.println("berhasil dijual +550");
                    }
                    else {
                        System.out.println("tidak ada susu");
                    }
                }
                else if ((e.getX()<349&&e.getX()>261) && (e.getY()<133&&e.getY()>46)) {
                    if (orang.findItem("Telur")) {
                        orang.delInventory("Telur");
                        orang.setGold(orang.getGold()+400);
                        System.out.println("berhasil dijual +400");
                    }
                    else {
                        System.out.println("tidak ada telur");
                    }
                }
                else if ((e.getX()<536&&e.getX()>434) && (e.getY()<133&&e.getY()>46)) {
                    if (orang.findItem("Bulu")) {
                        orang.delInventory("Bulu");
                        orang.setGold(orang.getGold()+700);
                        System.out.println("berhasil dijual +700");
                    }
                    else {
                        System.out.println("tidak ada bulu");
                    }
                }
                else if ((e.getX()<171&&e.getX()>65) && (e.getY()<287&&e.getY()>173)) {
                    if (orang.findItem("Kol")) {
                        orang.delInventory("Kol");
                        orang.setGold(orang.getGold()+150);
                        System.out.println("berhasil dijual +150");
                    }
                    else {
                        System.out.println("tidak ada kol");
                    }
                }
                else if ((e.getX()<349&&e.getX()>261) && (e.getY()<287&&e.getY()>173)) {
                    if (orang.findItem("Jagung")) {
                        orang.delInventory("Jagung");
                        orang.setGold(orang.getGold()+250);
                        System.out.println("berhasil dijual +250");
                    }
                    else {
                        System.out.println("tidak ada jagung");
                    }
                }
                else if ((e.getX()<536&&e.getX()>434) && (e.getY()<287&&e.getY()>173)) {
                    if (orang.findItem("Lobak")) {
                        orang.delInventory("Lobak");
                        orang.setGold(orang.getGold()+200);
                        System.out.println("berhasil dijual +200");
                    }
                    else {
                        System.out.println("tidak ada lobak");
                    }
                }
                
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
            
        }


	////// PLAYER //////////////////////////////////////////////////////////////////

	int _moveTimes=0;
	char _moveCode=' ';
	javax.swing.Timer move = new javax.swing.Timer(80,
		new ActionListener(){
			public void actionPerformed(ActionEvent e){

				if(_moveCode=='R'){
					if(orang.arah!=_moveCode){
						orang.pic.setIcon( new ImageIcon(Img.P_KANAN1.url));
						_moveTimes=2;
					}else
					if(isPassable(stagemap.mapAt(orang.x+1,orang.y))){
						if(_moveTimes==0)orang.pic.setIcon( new ImageIcon(Img.P_KANAN2.url));
						else{
							orang.pic.setIcon( new ImageIcon(Img.P_KANAN1.url));
							orang.x++;
						}
						world.setLocation(world.getX()-(int)q/2,world.getY());
						area.setLocation(area.getX()-(int)q/2,area.getY());
					}else{
						orang.pic.setIcon( new ImageIcon(Img.P_KANAN1.url));
						_moveTimes=2;
					}
				}else
				if(_moveCode=='L'){
					if(orang.arah!=_moveCode){
						orang.pic.setIcon( new ImageIcon(Img.P_KIRI1.url));
						_moveTimes=2;
					}else
					if(isPassable(stagemap.mapAt(orang.x-1,orang.y))){
						if(_moveTimes==0)orang.pic.setIcon( new ImageIcon(Img.P_KIRI2.url));
						else{
							orang.pic.setIcon( new ImageIcon(Img.P_KIRI1.url));
							orang.x--;
						}
						world.setLocation(world.getX()+(int)q/2,world.getY());
						area.setLocation(area.getX()+(int)q/2,area.getY());
					}else{
						orang.pic.setIcon( new ImageIcon(Img.P_KIRI1.url));
						_moveTimes=2;
					}
				}else
				if(_moveCode=='U'){
					if(orang.arah!=_moveCode){
						orang.pic.setIcon( new ImageIcon(Img.P_ATAS1.url));
						_moveTimes=2;
					}else
					if(isPassable(stagemap.mapAt(orang.x,orang.y-1))){
						if(_moveTimes==0)orang.pic.setIcon( new ImageIcon(Img.P_ATAS2.url));
						else{
							orang.pic.setIcon( new ImageIcon(Img.P_ATAS1.url));
							orang.y--;
						}
						world.setLocation(world.getX(),world.getY()+(int)q/2);
						area.setLocation(area.getX(),area.getY()+(int)q/2);
					}else{
						orang.pic.setIcon( new ImageIcon(Img.P_ATAS1.url));
						_moveTimes=2;
					}
				}else
				if(_moveCode=='D'){
					if(orang.arah!=_moveCode){
						orang.pic.setIcon( new ImageIcon(Img.P_BAWAH1.url));
						_moveTimes=2;
					}else
					if(isPassable(stagemap.mapAt(orang.x,orang.y+1))){
						if(_moveTimes==0)orang.pic.setIcon( new ImageIcon(Img.P_BAWAH2.url));
						else{
							orang.pic.setIcon( new ImageIcon(Img.P_BAWAH1.url));
							orang.y++;
						}
						world.setLocation(world.getX(),world.getY()-(int)q/2);
						area.setLocation(area.getX(),area.getY()-(int)q/2);
					}else{
						orang.pic.setIcon( new ImageIcon(Img.P_BAWAH1.url));
						_moveTimes=2;
					}
				}
				if(_moveCode=='R' || _moveCode=='L' || _moveCode=='U' || _moveCode=='D')
					refresh();

				if(++ _moveTimes>=2){
					orang.arah=_moveCode;
					move.stop();
					_moveTimes=0;
					_moveCode=' ';
				}

			}
		}
	);



	int _actTimes=0;
	char _actCode=' ';
	javax.swing.Timer act = new javax.swing.Timer(90,
		new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//_moveCode='X';
                                
				if(_actCode=='Z'){

					if(orang.arah=='D' && stagemap.mapAt(orang.x,orang.y+1)=='D' && isPassable(stagemap.mapAt(orang.x,orang.y+2) )){
                                            try{
                                                URL url1=Stage.class.getResource("z.wav");
                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url1);
                                                Clip sfxz=AudioSystem.getClip();
                                                sfxz.open(audio);
                                                sfxz.start();
                                            } catch (Exception ex){
                                                System.out.println(ex.getMessage());
                                            }
                                            
						orang.y+=2;
						goTo(orang.x-(int)px/2, orang.y-(int)px/2 );
						_actTimes=4;
					}else
					if(orang.arah=='U' && stagemap.mapAt(orang.x,orang.y-1)=='D' && isPassable(stagemap.mapAt(orang.x,orang.y-2) )){
                                            try{
                                                URL url1=Stage.class.getResource("z.wav");
                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url1);
                                                Clip sfxz=AudioSystem.getClip();
                                                sfxz.open(audio);
                                                sfxz.start();
                                            } catch (Exception ex){
                                                System.out.println(ex.getMessage());
                                            }
                                            
						orang.y-=2;
						goTo(orang.x-(int)px/2, orang.y-(int)px/2 );
						_actTimes=4;
					}else
					if(orang.arah=='L' && stagemap.mapAt(orang.x-1,orang.y)=='D' && isPassable(stagemap.mapAt(orang.x-2,orang.y) )){
                                            try{
                                                URL url1=Stage.class.getResource("z.wav");
                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url1);
                                                Clip sfxz=AudioSystem.getClip();
                                                sfxz.open(audio);
                                                sfxz.start();
                                            } catch (Exception ex){
                                                System.out.println(ex.getMessage());
                                            }
                                            
						orang.x-=2;
						goTo(orang.x-(int)px/2, orang.y-(int)px/2 );
						_actTimes=4;
					}else
					if(orang.arah=='R' && stagemap.mapAt(orang.x+1,orang.y)=='D' && isPassable(stagemap.mapAt(orang.x+2,orang.y) )){
                                            try{
                                                URL url1=Stage.class.getResource("z.wav");
                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url1);
                                                Clip sfxz=AudioSystem.getClip();
                                                sfxz.open(audio);
                                                sfxz.start();
                                            } catch (Exception ex){
                                                System.out.println(ex.getMessage());
                                            }
                                            
						orang.x+=2;
						goTo(orang.x-(int)px/2, orang.y-(int)px/2 );
						_actTimes=4;
					}else
					_actTimes=4;
				}else
				if(_actCode=='X'){
					if(orang.arah=='D' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/DP.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
                                                    
							if(stagemap.macul(orang.x,orang.y+1)){
                                                            
                                                            try{
                                                                URL url2=Stage.class.getResource("x.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url2);
                                                                Clip sfxx=AudioSystem.getClip();
                                                                sfxx.open(audio);
                                                                sfxx.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }
                                                    
                                                                int pcld = orang.y+1;
                                                                field.pacul(orang.x-25,pcld-4);
                                                                System.out.println("lokasi tanaman yang dipacul "+orang.x+","+pcld);
								orang.pic.setIcon( new ImageIcon("pic/DP.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD2.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y+1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
								System.out.println("Macul");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_BAWAH1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='U' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/UP.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.macul(orang.x,orang.y-1)){
                                                            
                                                            try{
                                                                URL url2=Stage.class.getResource("x.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url2);
                                                                Clip sfxx=AudioSystem.getClip();
                                                                sfxx.open(audio);
                                                                sfxx.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }        
                                                            
                                                                int pcld = orang.y-1;
                                                                field.pacul(orang.x-25,pcld-4);
                                                                System.out.println("lokasi tanaman yang dipacul "+orang.x+","+pcld);
								orang.pic.setIcon( new ImageIcon("pic/UP.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD2.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y-1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
								System.out.println("Macul");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_ATAS1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='R' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/RP.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.macul(orang.x+1,orang.y)){
                                                            
                                                            try{
                                                                URL url2=Stage.class.getResource("x.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url2);
                                                                Clip sfxx=AudioSystem.getClip();
                                                                sfxx.open(audio);
                                                                sfxx.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }        
                                                            
                                                                int pcld = orang.x+1;
                                                                field.pacul(pcld-25,orang.y-4);
                                                                System.out.println("lokasi tanaman yang dipacul "+pcld+","+orang.y);
								orang.pic.setIcon( new ImageIcon("pic/RP.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD2.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
								System.out.println("Macul");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_KANAN1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='L' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/LP.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.macul(orang.x-1,orang.y)){   
                                                            
                                                            try{
                                                                URL url2=Stage.class.getResource("x.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url2);
                                                                Clip sfxx=AudioSystem.getClip();
                                                                sfxx.open(audio);
                                                                sfxx.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }        
                                                            
                                                                int pcld = orang.x-1;
                                                                field.pacul(pcld-25,orang.y-4);
                                                                System.out.println("lokasi tanaman yang dipacul "+pcld+","+orang.y);
								orang.pic.setIcon( new ImageIcon("pic/LP.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD2.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x-1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
								System.out.println("Macul");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_KIRI1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}
                                    }else
                                    if(_actCode=='C'){
                                        PenyiramTanaman srm = new PenyiramTanaman();
                                        srm.setStatus(true);
                                        
					if(orang.arah=='D' ){
						if(_actTimes==0){
                                                    orang.pic.setIcon( new ImageIcon("pic/DW.png"));
                                                    refresh();
                                                    _actTimes++;
						}else if(_actTimes==1){
                                                    //System.out.println(stagemap.cekFase(orang.x,orang.y+1));
                                                    if(stagemap.Fase(orang.x,orang.y+1)=='y'){ //tanah dibasahin
                                                        
                                                        try{
                                                                URL url3=Stage.class.getResource("c.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url3);
                                                                Clip sfxc=AudioSystem.getClip();
                                                                sfxc.open(audio);
                                                                sfxc.start();
                                                        } catch (Exception ex){
                                                            System.out.println(ex.getMessage());
                                                        }        
                                                        
                                                        stagemap.siram(orang.x,orang.y+1);
                                                        int srmd= orang.y+1;
                                                        field.siram(srm,orang.x-25,srmd-4,jam);
                                                        System.out.println("lokasi tanaman yang disiram "+orang.x+","+srmd);
                                                        orang.pic.setIcon( new ImageIcon("pic/DW.png"));
                                                        JPanel xYz=new JPanel();
                                                        xYz.add(new JLabel(new ImageIcon(Img.FLD3.url)));
                                                        xYz.setBackground(new Color(0,0,0,0));
                                                        xYz.setBounds((orang.x+px)*q,(orang.y+1+px)*q,q,q+5);
                                                        world.add(xYz);
                                                        world.setComponentZOrder(xYz,0);
                                                        System.out.println("siram");
                                                        //System.out.println(stagemap.cekFase(orang.x,orang.y+1));
                                                        //System.out.println("");
                                                        

                                                    } else if(stagemap.Fase(orang.x,orang.y+1)=='Z'){ //biji >> tumbuh
                                                        
                                                        try{
                                                                URL url3=Stage.class.getResource("c.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url3);
                                                                Clip sfxc=AudioSystem.getClip();
                                                                sfxc.open(audio);
                                                                sfxc.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }        
                                                        
                                                        int srmd= orang.y+1;
                                                        field.siram(srm,orang.x-25,srmd-4,jam);
                                                        
                                                        stagemap.tumbuh(orang.x,orang.y+1);
                                                        
                                                        System.out.println("lokasi tanaman yang disiram "+orang.x+","+srmd);
                                                        orang.pic.setIcon( new ImageIcon("pic/DW.png"));
                                                        JPanel xYz=new JPanel();
                                                        if (field.mtxPlant[orang.x-25][srmd-4] instanceof Kol){
                                                            xYz.add(new JLabel(new ImageIcon(Img.CBG1.url)));
                                                        } else if(field.mtxPlant[orang.x-25][orang.y-3] instanceof Lobak){
                                                            xYz.add(new JLabel(new ImageIcon(Img.RDSH1.url)));
                                                        } else if(field.mtxPlant[orang.x-25][orang.y-3] instanceof Jagung){
                                                            xYz.add(new JLabel(new ImageIcon(Img.CORN2.url)));
                                                        }
                                                        xYz.setBackground(new Color(0,0,0,0));
                                                        xYz.setBounds((orang.x+px)*q,(orang.y+1+px)*q,q,q+5);
                                                        world.add(xYz);
                                                        world.setComponentZOrder(xYz,0);
                                                        System.out.println("siram");
                                                        //System.out.println(stagemap.cekFase(orang.x,orang.y+1));
                                                        //System.out.println("");
                                                        System.out.println(field.mtxPlant[orang.x-25][srmd-4].getFase());
                                                        
                                                    } else if (stagemap.Fase(orang.x,orang.y+1)=='Y') { //tumbuh >> panen
                                                        
                                                        int srmd= orang.y+1;
                                                        boolean stat = field.mtxPlant[orang.x-25][srmd-4].getStatus();
                                                        System.out.println(stat);
                                                        if (stat==false) {
                                                    
                                                            try{
                                                                URL url3=Stage.class.getResource("c.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url3);
                                                                Clip sfxc=AudioSystem.getClip();
                                                                sfxc.open(audio);
                                                                sfxc.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }
                                                            field.siram(srm,orang.x-25,srmd-4,jam);
                                                            
                                                            JPanel xYz=new JPanel();
                                                            if (field.mtxPlant[orang.x-25][srmd-4] instanceof Kol){
                                                                if(field.mtxPlant[orang.x-25][srmd-4].getFase()=="Panen"){
                                                                    stagemap.fasePanen(orang.x,orang.y+1);
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CBG2.url)));
                                                                } else{
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CBG1.url)));
                                                                }
                                                            } else if(field.mtxPlant[orang.x-25][orang.y-3] instanceof Lobak){
                                                                if(field.mtxPlant[orang.x-25][srmd-4].getFase()=="Panen"){
                                                                    stagemap.fasePanen(orang.x,orang.y+1);
                                                                    xYz.add(new JLabel(new ImageIcon(Img.RDSH3.url)));
                                                                } else{
                                                                    xYz.add(new JLabel(new ImageIcon(Img.RDSH1.url)));
                                                                }
                                                            } else if(field.mtxPlant[orang.x-25][orang.y-3] instanceof Jagung){
                                                                if(field.mtxPlant[orang.x-25][srmd-4].getFase()=="Panen"){
                                                                    stagemap.fasePanen(orang.x,orang.y+1);
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CORN3.url)));
                                                                } else{
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CORN2.url)));
                                                                }
                                                            }
                                                        
                                                            //stagemap.fasePanen(orang.x,orang.y+1);
                                                            //field.siram(srm,orang.x-25,srmd-4,jam);
                                                             //if (field.mtxPlant[orang.x-25][srmd-4].sudahSiram(jam)) {
                                                             System.out.println("lokasi tanaman yang disiram "+orang.x+","+srmd);
                                                             orang.pic.setIcon( new ImageIcon("pic/DW.png"));
                                                             xYz.setBackground(new Color(0,0,0,0));
                                                             xYz.setBounds((orang.x+px)*q,(orang.y+1+px)*q,q,q+5);
                                                             world.add(xYz);
                                                             world.setComponentZOrder(xYz,0);
                                                             System.out.println("siram");
                                                            }
                                                           // }
                                                           //System.out.println(stagemap.cekFase(orang.x,orang.y+1));
                                                           //System.out.println("");
                                                           System.out.println(field.mtxPlant[orang.x-25][srmd-4].getFase());

                                                    }
							orang.pic.setIcon( new ImageIcon(Img.P_BAWAH1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='U' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/UW.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.Fase(orang.x,orang.y-1)=='y'){
                                                            
                                                            try{
                                                                URL url3=Stage.class.getResource("c.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url3);
                                                                Clip sfxc=AudioSystem.getClip();
                                                                sfxc.open(audio);
                                                                sfxc.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }        
                                                            
                                                            stagemap.siram(orang.x,orang.y-1);
                                                                int srmd= orang.y-1;
                                                                field.siram(srm,orang.x-25,srmd-4,jam);
                                                                System.out.println("lokasi tanaman yang disiram "+orang.x+","+srmd);
								orang.pic.setIcon( new ImageIcon("pic/UW.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD3.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y-1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
								System.out.println("siram");
							} else if(stagemap.Fase(orang.x,orang.y-1)=='Z'){
                                                            
                                                            try{
                                                                URL url3=Stage.class.getResource("c.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url3);
                                                                Clip sfxc=AudioSystem.getClip();
                                                                sfxc.open(audio);
                                                                sfxc.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }        
                                                            
                                                            int srmd= orang.y-1;
                                                            field.siram(srm,orang.x-25,srmd-4,jam);
                                                                
                                                            stagemap.tumbuh(orang.x,orang.y-1);
                                                            
                                                            
                                                                System.out.println("lokasi tanaman yang disiram "+orang.x+","+srmd);
								orang.pic.setIcon( new ImageIcon("pic/UW.png"));
								JPanel xYz=new JPanel();
                                                                if (field.mtxPlant[orang.x-25][srmd-4] instanceof Kol){
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CBG1.url)));
                                                                } else if(field.mtxPlant[orang.x-25][srmd-4] instanceof Lobak){
                                                                    xYz.add(new JLabel(new ImageIcon(Img.RDSH1.url)));
                                                                } else if(field.mtxPlant[orang.x-25][srmd-4] instanceof Jagung){
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CORN2.url)));
                                                                }
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y-1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
								System.out.println("siram");
							} else if (stagemap.Fase(orang.x,orang.y-1)=='Y') {
                                                            int srmd= orang.y-1;
                                                            
                                                            boolean stat = field.mtxPlant[orang.x-25][srmd-4].getStatus();
                                                            System.out.println(stat);
                                                            if (stat==false) {
                                                                
                                                            try{
                                                                URL url3=Stage.class.getResource("c.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url3);
                                                                Clip sfxc=AudioSystem.getClip();
                                                                sfxc.open(audio);
                                                                sfxc.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            } 
                                                            
                                                            field.siram(srm,orang.x-25,srmd-4,jam);   
                                                            JPanel xYz=new JPanel();
                                                            if (field.mtxPlant[orang.x-25][srmd-4] instanceof Kol){
                                                                if(field.mtxPlant[orang.x-25][srmd-4].getFase()=="Panen"){
                                                                    stagemap.fasePanen(orang.x,orang.y-1);
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CBG2.url)));
                                                                } else{
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CBG1.url)));
                                                                }
                                                            } else if(field.mtxPlant[orang.x-25][srmd-4] instanceof Lobak){
                                                                if(field.mtxPlant[orang.x-25][srmd-4].getFase()=="Panen"){
                                                                    stagemap.fasePanen(orang.x,orang.y-1);
                                                                    xYz.add(new JLabel(new ImageIcon(Img.RDSH3.url)));
                                                                } else{
                                                                    xYz.add(new JLabel(new ImageIcon(Img.RDSH1.url)));
                                                                }
                                                            } else if(field.mtxPlant[orang.x-25][srmd-4] instanceof Jagung){
                                                                if(field.mtxPlant[orang.x-25][srmd-4].getFase()=="Panen"){
                                                                    stagemap.fasePanen(orang.x,orang.y-1);
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CORN3.url)));
                                                                } else{
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CORN2.url)));
                                                                }
                                                            }
                                                                
                                                                    
                                                                    
                                                                    System.out.println("lokasi tanaman yang disiram "+orang.x+","+srmd);
                                                                    orang.pic.setIcon( new ImageIcon("pic/UW.png"));
                                                                    
                                                                    
                                                                    xYz.setBackground(new Color(0,0,0,0));
                                                                    xYz.setBounds((orang.x+px)*q,(orang.y-1+px)*q,q,q+5);
                                                                    world.add(xYz);
                                                                    world.setComponentZOrder(xYz,0);
                                                            }
                                                        }
							orang.pic.setIcon( new ImageIcon(Img.P_ATAS1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='R' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/RW.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.Fase(orang.x+1,orang.y)=='y'){
                                                            
                                                            try{
                                                                URL url3=Stage.class.getResource("c.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url3);
                                                                Clip sfxc=AudioSystem.getClip();
                                                                sfxc.open(audio);
                                                                sfxc.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }        
                                                            
                                                            stagemap.siram(orang.x+1,orang.y);
                                                                int srmd= orang.x+1;
                                                                field.siram(srm,srmd-25,orang.y-4,jam);
                                                                System.out.println("lokasi tanaman yang disiram "+srmd+","+orang.y);
								orang.pic.setIcon( new ImageIcon("pic/RW.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD3.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
								System.out.println("siram");
							} else if(stagemap.Fase(orang.x+1,orang.y)=='Z'){
                                                            
                                                            try{
                                                                URL url3=Stage.class.getResource("c.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url3);
                                                                Clip sfxc=AudioSystem.getClip();
                                                                sfxc.open(audio);
                                                                sfxc.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }        
                                                            
                                                            int srmd= orang.x+1;
                                                                field.siram(srm,srmd-25,orang.y-4,jam);
                                                             
                                                            
                                                            //if(field.mtxPlant[srmd-25][orang.y-4].getFase()=="Panen"){
                                                                stagemap.tumbuh(orang.x+1,orang.y);
                                                            //}
                                                            System.out.println("lokasi tanaman yang disiram "+srmd+","+orang.y);
								orang.pic.setIcon( new ImageIcon("pic/RW.png"));
								JPanel xYz=new JPanel();
                                                                if (field.mtxPlant[srmd-25][orang.y-4] instanceof Kol){
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CBG1.url)));
                                                                } else if(field.mtxPlant[srmd-25][orang.y-4] instanceof Lobak){
                                                                    xYz.add(new JLabel(new ImageIcon(Img.RDSH1.url)));
                                                                } else if(field.mtxPlant[srmd-25][orang.y-4] instanceof Jagung){
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CORN2.url)));
                                                                }
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
								System.out.println("siram");
                                                        } else if(stagemap.Fase(orang.x+1,orang.y)=='Y') {
                                                                int srmd= orang.x+1;
                                                                
                                                                boolean stat = field.mtxPlant[srmd-25][orang.y-4].getStatus();
                                                                System.out.println(stat);
                                                                if (stat==false) {
                                                                    
                                                                    try{
                                                                        URL url3=Stage.class.getResource("c.wav");
                                                                        AudioInputStream audio = AudioSystem.getAudioInputStream(url3);
                                                                        Clip sfxc=AudioSystem.getClip();
                                                                        sfxc.open(audio);
                                                                        sfxc.start();
                                                                    } catch (Exception ex){
                                                                        System.out.println(ex.getMessage());
                                                                    }             
                                                                    
                                                                    field.siram(srm,srmd-25,orang.y-4,jam);  
                                                                    JPanel xYz=new JPanel();
                                                                    if (field.mtxPlant[srmd-25][orang.y-4] instanceof Kol){
                                                                        if(field.mtxPlant[srmd-25][orang.y-4].getFase()=="Panen"){
                                                                            stagemap.fasePanen(orang.x+1,orang.y);
                                                                            xYz.add(new JLabel(new ImageIcon(Img.CBG2.url)));
                                                                        } else{
                                                                            xYz.add(new JLabel(new ImageIcon(Img.CBG1.url)));
                                                                        }
                                                                    } else if(field.mtxPlant[srmd-25][orang.y-4] instanceof Lobak){
                                                                        if(field.mtxPlant[srmd-25][orang.y-4].getFase()=="Panen"){
                                                                            stagemap.fasePanen(orang.x+1,orang.y);
                                                                            xYz.add(new JLabel(new ImageIcon(Img.RDSH3.url)));
                                                                        } else{
                                                                            xYz.add(new JLabel(new ImageIcon(Img.RDSH1.url)));
                                                                        }
                                                                    } else if(field.mtxPlant[srmd-25][orang.y-4] instanceof Jagung){
                                                                        if(field.mtxPlant[srmd-25][orang.y-4].getFase()=="Panen"){
                                                                            stagemap.fasePanen(orang.x+1,orang.y);
                                                                            xYz.add(new JLabel(new ImageIcon(Img.CORN3.url)));
                                                                        } else{
                                                                            xYz.add(new JLabel(new ImageIcon(Img.CORN2.url)));
                                                                        }
                                                                    }
                                                                    
                                                                    
                                                                    
                                                                    System.out.println("lokasi tanaman yang disiram "+srmd+","+orang.y);
                                                                    orang.pic.setIcon( new ImageIcon("pic/RW.png"));
                                                                    
                                                                    xYz.setBackground(new Color(0,0,0,0));
                                                                    xYz.setBounds((orang.x+1+px)*q,(orang.y+px)*q,q,q+5);
                                                                    world.add(xYz);
                                                                    world.setComponentZOrder(xYz,0);
                                                                    System.out.println("siram");
                                                                }
                                                        }
							orang.pic.setIcon( new ImageIcon(Img.P_KANAN1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='L' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/LW.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.Fase(orang.x-1,orang.y)=='y'){ //tanah basah
                                                            
                                                            try{
                                                                URL url3=Stage.class.getResource("c.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url3);
                                                                Clip sfxc=AudioSystem.getClip();
                                                                sfxc.open(audio);
                                                                sfxc.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }       
                                                            
                                                            stagemap.siram(orang.x-1,orang.y);
								int srmd= orang.x-1;
                                                                field.siram(srm,srmd-25,orang.y-4,jam);
                                                                System.out.println("lokasi tanaman yang disiram "+srmd+","+orang.y);
                                                                orang.pic.setIcon( new ImageIcon("pic/LW.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD3.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x-1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
								System.out.println("siram");
							} else if(stagemap.Fase(orang.x-1,orang.y)=='Z'){ //kalau biji jadi tumbuh
                                                            
                                                            try{
                                                                URL url3=Stage.class.getResource("c.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url3);
                                                                Clip sfxc=AudioSystem.getClip();
                                                                sfxc.open(audio);
                                                                sfxc.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }        
                                                            
                                                           int srmd= orang.x-1;
                                                                field.siram(srm,srmd-25,orang.y-4,jam);
                                                                
                                                            
                                                            //if(field.mtxPlant[srmd-25][orang.y-4].getFase()=="Panen"){
                                                                stagemap.tumbuh(orang.x-1,orang.y);
                                                            //} 
                                                           
                                                            System.out.println("lokasi tanaman yang disiram "+srmd+","+orang.y);
                                                                orang.pic.setIcon( new ImageIcon("pic/LW.png"));
								JPanel xYz=new JPanel();
								if (field.mtxPlant[srmd-25][orang.y-4] instanceof Kol){
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CBG1.url)));
                                                                } else if(field.mtxPlant[srmd-25][orang.y-4] instanceof Lobak){
                                                                    xYz.add(new JLabel(new ImageIcon(Img.RDSH1.url)));
                                                                } else if(field.mtxPlant[srmd-25][orang.y-4] instanceof Jagung){
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CORN2.url)));
                                                                }
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x-1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
								System.out.println("siram");
							} else if(stagemap.Fase(orang.x-1, orang.y)=='Y') { //kalau tumbuh jadi panen
                                                                int srmd= orang.x-1;
                                                                
                                                                boolean stat = field.mtxPlant[srmd-25][orang.y-4].getStatus();
                                                                System.out.println(stat);
                                                                if (stat==false) {
                                                                    
                                                                    try{
                                                                        URL url3=Stage.class.getResource("c.wav");
                                                                        AudioInputStream audio = AudioSystem.getAudioInputStream(url3);
                                                                        Clip sfxc=AudioSystem.getClip();
                                                                        sfxc.open(audio);
                                                                        sfxc.start();
                                                                    } catch (Exception ex){
                                                                        System.out.println(ex.getMessage());
                                                                    }              
                                                                    
                                                                    field.siram(srm,srmd-25,orang.y-4,jam);  
                                                                    JPanel xYz=new JPanel();
                                                                    if (field.mtxPlant[srmd-25][orang.y-4] instanceof Kol){
                                                                        if(field.mtxPlant[srmd-25][orang.y-4].getFase()=="Panen"){
                                                                            stagemap.fasePanen(orang.x-1, orang.y);
                                                                            xYz.add(new JLabel(new ImageIcon(Img.CBG2.url)));
                                                                        } else{
                                                                            xYz.add(new JLabel(new ImageIcon(Img.CBG1.url)));
                                                                        }
                                                                    } else if(field.mtxPlant[srmd-25][orang.y-4] instanceof Lobak){
                                                                        if(field.mtxPlant[srmd-25][orang.y-4].getFase()=="Panen"){
                                                                            stagemap.fasePanen(orang.x-1,orang.y);
                                                                            xYz.add(new JLabel(new ImageIcon(Img.RDSH3.url)));
                                                                        } else{
                                                                            xYz.add(new JLabel(new ImageIcon(Img.RDSH1.url)));
                                                                        }
                                                                    } else if(field.mtxPlant[srmd-25][orang.y-4] instanceof Jagung){
                                                                        if(field.mtxPlant[srmd-25][orang.y-4].getFase()=="Panen"){
                                                                            stagemap.fasePanen(orang.x-1,orang.y);
                                                                            xYz.add(new JLabel(new ImageIcon(Img.CORN3.url)));
                                                                        } else{
                                                                            xYz.add(new JLabel(new ImageIcon(Img.CORN2.url)));
                                                                        }
                                                                    }
                                                                    
                                                                    
                                                                    System.out.println("lokasi tanaman yang disiram "+srmd+","+orang.y);
                                                                    orang.pic.setIcon( new ImageIcon("pic/LW.png"));
                                                                    
                                                                    xYz.setBackground(new Color(0,0,0,0));
                                                                    xYz.setBounds((orang.x-1+px)*q,(orang.y+px)*q,q,q+5);
                                                                    world.add(xYz);
                                                                    world.setComponentZOrder(xYz,0);
                                                                    System.out.println("siram");
                                                                }
                                                        }
							orang.pic.setIcon( new ImageIcon(Img.P_KIRI1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
                                        }
                                    } else
                                    if(_actCode=='V'){ //Nanem
                                        if (orang.findItem("BijiKol")){
                                        BijiTanaman lol=new BijiKol(1,5,"lol");
					if(orang.arah=='D' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/DS.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.biji(orang.x,orang.y+1)){
                                                            
                                                            try{
                                                                URL url4=Stage.class.getResource("v.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url4);
                                                                Clip sfxv=AudioSystem.getClip();
                                                                sfxv.open(audio);
                                                                sfxv.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }        
                                                            
                                                                field.tanam(lol,"lol","Kol",orang.x-25,orang.y+1-4);
                                                                orang.delInventory("BijiKol");
								orang.pic.setIcon( new ImageIcon("pic/DS.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD4.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y+1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int dx=orang.x;
                                                                int dy=orang.y+1;
								System.out.println("tanem");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_BAWAH1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='U' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/US.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.biji(orang.x,orang.y-1)){
                                                            
                                                            try{
                                                                URL url4=Stage.class.getResource("v.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url4);
                                                                Clip sfxv=AudioSystem.getClip();
                                                                sfxv.open(audio);
                                                                sfxv.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }   
                                                            
                                                                field.tanam(lol,"lol","Kol",orang.x-25,orang.y-1-4);
                                                                orang.delInventory("BijiKol");
								orang.pic.setIcon( new ImageIcon("pic/US.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD4.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y-1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int ux=orang.x;
                                                                int uy=orang.y-1;
								System.out.println("tanem");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_ATAS1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='R' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/RS.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.biji(orang.x+1,orang.y)){
                                                            
                                                            try{
                                                                URL url4=Stage.class.getResource("v.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url4);
                                                                Clip sfxv=AudioSystem.getClip();
                                                                sfxv.open(audio);
                                                                sfxv.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }   
                                                            
                                                                field.tanam(lol,"lol","Kol",orang.x+1-25,orang.y-4);
                                                                orang.delInventory("BijiKol");
								orang.pic.setIcon( new ImageIcon("pic/RS.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD4.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int rx=orang.x+1;
                                                                int ry=orang.y;
								System.out.println("biji");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_KANAN1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='L' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/LS.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.biji(orang.x-1,orang.y)){
                                                            
                                                            try{
                                                                URL url4=Stage.class.getResource("v.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url4);
                                                                Clip sfxv=AudioSystem.getClip();
                                                                sfxv.open(audio);
                                                                sfxv.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }   
                                                            
                                                                field.tanam(lol,"lol","Kol",orang.x-1-25,orang.y-4);
                                                                orang.delInventory("BijiKol");
								orang.pic.setIcon( new ImageIcon("pic/LS.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD4.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x-1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int lx=orang.x-1;
                                                                int ly=orang.y;
								System.out.println("biji");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_KIRI1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}
                                        }else{
                                            System.out.println("Tidak ada biji kol.");
                                        }
                                    }
                                if(_actCode=='B'){
                                    Arit a = new Arit();
                                    a.setStatus(true);
					if(orang.arah=='D' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/DA.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.arit(orang.x,orang.y+1)){
                                                            
                                                            try{
                                                                URL url5=Stage.class.getResource("b.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url5);
                                                                Clip sfxb=AudioSystem.getClip();
                                                                sfxb.open(audio);
                                                                sfxb.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            } 
                                                            
                                                                field.hapus(a,orang.x-25,orang.y+1-4);
								orang.pic.setIcon( new ImageIcon("pic/DA.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD1.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y+1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int dx=orang.x;
                                                                int dy=orang.y+1;
								System.out.println("arit");
							}
                                                        
							orang.pic.setIcon( new ImageIcon(Img.P_BAWAH1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='U' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/UA.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.arit(orang.x,orang.y-1)){
                                                            
                                                            try{
                                                                URL url5=Stage.class.getResource("b.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url5);
                                                                Clip sfxb=AudioSystem.getClip();
                                                                sfxb.open(audio);
                                                                sfxb.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            } 
                                                            
                                                            field.hapus(a,orang.x-25,orang.y-1-4);
								orang.pic.setIcon( new ImageIcon("pic/UA.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD1.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y-1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int ux=orang.x;
                                                                int uy=orang.y-1;
								System.out.println("tanem");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_ATAS1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='R' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/RA.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.arit(orang.x+1,orang.y)){
                                                            
                                                            try{
                                                                URL url5=Stage.class.getResource("b.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url5);
                                                                Clip sfxb=AudioSystem.getClip();
                                                                sfxb.open(audio);
                                                                sfxb.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            } 
                                                            
                                                            field.hapus(a,orang.x+1-25,orang.y-4);
								orang.pic.setIcon( new ImageIcon("pic/RA.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD1.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int rx=orang.x+1;
                                                                int ry=orang.y;
								System.out.println("biji");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_KANAN1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='L' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/LA.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.arit(orang.x-1,orang.y)){
                                                            
                                                            try{
                                                                URL url5=Stage.class.getResource("b.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url5);
                                                                Clip sfxb=AudioSystem.getClip();
                                                                sfxb.open(audio);
                                                                sfxb.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            } 
                                                            
                                                            field.hapus(a,orang.x-1-25,orang.y-4);
								orang.pic.setIcon( new ImageIcon("pic/LA.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD1.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x-1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int lx=orang.x-1;
                                                                int ly=orang.y;
								System.out.println("biji");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_KIRI1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}
                                    }
                                if(_actCode=='S'){
                                    if((stagemap.sleep(orang.x+1,orang.y))||(stagemap.sleep(orang.x-1,orang.y))||(stagemap.sleep(orang.x,orang.y+1))||(stagemap.sleep(orang.x,orang.y-1)))
					//if(orang.arah=='D' ){
						if(_actTimes==0){
							
							_actTimes++;
						}else if(_actTimes==1){
							/*if(stagemap.arit(orang.x,orang.y+1)){
                                                                field.hapus(a,orang.x-25,orang.y+1-4);
								orang.pic.setIcon( new ImageIcon("pic/dmsds2.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD1.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y+1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int dx=orang.x;
                                                                int dy=orang.y+1;
								System.out.println("tanem");*/
                                                        jam.setSleep();
                                                        field.gantiHari();
                                                        kandangAyam.gantiHari();
                                                        kandangSapi.gantiHari();
                                                        hari=jam.getHari();
                                                        gantiHari = true;
                                                if(orang.arah=='D'){
							orang.pic.setIcon( new ImageIcon(Img.P_BAWAH1.url));
							refresh();
							_actTimes=4;
						}else if(orang.arah=='U'){
							orang.pic.setIcon( new ImageIcon(Img.P_ATAS1.url));
							refresh();
							_actTimes=4;
                                                }else if(orang.arah=='R'){
							orang.pic.setIcon( new ImageIcon(Img.P_KANAN1.url));
							refresh();
							_actTimes=4;
                                                }else if(orang.arah=='L'){
							orang.pic.setIcon( new ImageIcon(Img.P_KIRI1.url));
							refresh();
							_actTimes=4;
                                                }else
							_actTimes=4;
                                                }
                                }
                                
                                if(_actCode=='N'){
                                    
					if(orang.arah=='D' ){
						if(_actTimes==0){                                                    
							orang.pic.setIcon( new ImageIcon("pic/DS.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.diPanen(orang.x,orang.y+1)){
                                                            try{
                                                                URL url6=Stage.class.getResource("n.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url6);
                                                                Clip sfxn=AudioSystem.getClip();
                                                                sfxn.open(audio);
                                                                sfxn.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }
                                                                orang.addInventory(field.panen(orang,orang.x-25,orang.y+1-4));
								orang.pic.setIcon( new ImageIcon("pic/DS.png"));
								JPanel xYz=new JPanel();
                                                                if (field.mtxPlant[orang.x-25][orang.y+1-4].getFase()=="Ilalang"){
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CBG3.url)));
                                                                    stagemap.toIlalang(orang.x,orang.y+1);
                                                                }else{
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CORN2.url)));
                                                                    stagemap.toTumbuh(orang.x,orang.y+1);
                                                                }
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y+1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int dx=orang.x;
                                                                int dy=orang.y+1;
								System.out.println("PANEN");
							}
                                                        
							orang.pic.setIcon( new ImageIcon(Img.P_BAWAH1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='U' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/US.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.diPanen(orang.x,orang.y-1)){
                                                            try{
                                                                URL url6=Stage.class.getResource("n.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url6);
                                                                Clip sfxn=AudioSystem.getClip();
                                                                sfxn.open(audio);
                                                                sfxn.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }
                                                            orang.addInventory(field.panen(orang,orang.x-25,orang.y-1-4));
								orang.pic.setIcon( new ImageIcon("pic/US.png"));
								JPanel xYz=new JPanel();
								if (field.mtxPlant[orang.x-25][orang.y-1-4].getFase()=="Ilalang"){
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CBG3.url)));
                                                                    stagemap.toIlalang(orang.x,orang.y-1);
                                                                }else{
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CORN2.url)));
                                                                    stagemap.toTumbuh(orang.x,orang.y-1);
                                                                }
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y-1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int ux=orang.x;
                                                                int uy=orang.y-1;
								System.out.println("PANEN");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_ATAS1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='R' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/RS.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.diPanen(orang.x+1,orang.y)){
                                                            try{
                                                                URL url6=Stage.class.getResource("n.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url6);
                                                                Clip sfxn=AudioSystem.getClip();
                                                                sfxn.open(audio);
                                                                sfxn.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }
                                                            orang.addInventory(field.panen(orang,orang.x+1-25,orang.y-4));
								orang.pic.setIcon( new ImageIcon("pic/RS.png"));
								JPanel xYz=new JPanel();
                                                                if (field.mtxPlant[orang.x+1-25][orang.y-4].getFase()=="Ilalang"){
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CBG3.url)));
                                                                    stagemap.toIlalang(orang.x+1,orang.y);
                                                                }else{
                                                                    xYz.add(new JLabel(new ImageIcon(Img.CORN2.url)));
                                                                    stagemap.toTumbuh(orang.x+1,orang.y);
                                                                }
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int rx=orang.x+1;
                                                                int ry=orang.y;
								System.out.println("PANEN");
							}
                                                     
							orang.pic.setIcon( new ImageIcon(Img.P_KANAN1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='L' ){
						if(_actTimes==0){
                                                    System.out.println("why");
							orang.pic.setIcon( new ImageIcon("pic/LS.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
                                                    System.out.println(field.mtxPlant[orang.x-1-25][orang.y-4].getFase());
							if(stagemap.diPanen(orang.x-1,orang.y)){
                                                            try{
                                                                URL url6=Stage.class.getResource("n.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url6);
                                                                Clip sfxn=AudioSystem.getClip();
                                                                sfxn.open(audio);
                                                                sfxn.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }
                                                            orang.addInventory(field.panen(orang,orang.x-1-25,orang.y-4));
                                                            orang.pic.setIcon( new ImageIcon("pic/LS.png"));
                                                            JPanel xYz=new JPanel();
                                                            if (field.mtxPlant[orang.x-1-25][orang.y-4].getFase()=="Ilalang"){
                                                                xYz.add(new JLabel(new ImageIcon(Img.CBG3.url)));
                                                                stagemap.toIlalang(orang.x-1,orang.y);
                                                            }else{
                                                                System.out.println("berhasil");
                                                                xYz.add(new JLabel(new ImageIcon(Img.CORN2.url)));
                                                                stagemap.toTumbuh(orang.x-1,orang.y);
                                                            }
                                                            xYz.setBackground(new Color(0,0,0,0));
                                                            xYz.setBounds((orang.x-1+px)*q,(orang.y+px)*q,q,q+5);
                                                            world.add(xYz);
                                                            world.setComponentZOrder(xYz,0);
                                                            int lx=orang.x-1;
                                                            int ly=orang.y;
                                                            System.out.println("biji");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_KIRI1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}
                                    
                                    } 
                                    if (_actCode=='P'){
                                        if (orang.findItem("BijiLobak")){
                                        BijiTanaman lol=new BijiLobak(1,5,"lol");
					if(orang.arah=='D' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/DS.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.biji(orang.x,orang.y+1)){
                                                            
                                                            try{
                                                                URL url4=Stage.class.getResource("v.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url4);
                                                                Clip sfxv=AudioSystem.getClip();
                                                                sfxv.open(audio);
                                                                sfxv.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }        
                                                            
                                                                field.tanam(lol,"lol","Lobak",orang.x-25,orang.y+1-4);
                                                                orang.delInventory("BijiLobak");
								orang.pic.setIcon( new ImageIcon("pic/DS.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD4.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y+1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int dx=orang.x;
                                                                int dy=orang.y+1;
								System.out.println("tanem");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_BAWAH1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='U' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/US.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.biji(orang.x,orang.y-1)){
                                                            
                                                            try{
                                                                URL url4=Stage.class.getResource("v.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url4);
                                                                Clip sfxv=AudioSystem.getClip();
                                                                sfxv.open(audio);
                                                                sfxv.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }   
                                                            
                                                                field.tanam(lol,"lol","Lobak",orang.x-25,orang.y-1-4);
                                                                orang.delInventory("BijiLobak");
								orang.pic.setIcon( new ImageIcon("pic/US.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD4.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y-1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int ux=orang.x;
                                                                int uy=orang.y-1;
								System.out.println("tanem");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_ATAS1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='R' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/RS.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.biji(orang.x+1,orang.y)){
                                                            
                                                            try{
                                                                URL url4=Stage.class.getResource("v.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url4);
                                                                Clip sfxv=AudioSystem.getClip();
                                                                sfxv.open(audio);
                                                                sfxv.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }   
                                                            
                                                                field.tanam(lol,"lol","Lobak",orang.x+1-25,orang.y-4);
                                                                orang.delInventory("BijiLobak");
								orang.pic.setIcon( new ImageIcon("pic/RS.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD4.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int rx=orang.x+1;
                                                                int ry=orang.y;
								System.out.println("biji");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_KANAN1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='L' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/LS.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.biji(orang.x-1,orang.y)){
                                                            
                                                            try{
                                                                URL url4=Stage.class.getResource("v.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url4);
                                                                Clip sfxv=AudioSystem.getClip();
                                                                sfxv.open(audio);
                                                                sfxv.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }   
                                                            
                                                                field.tanam(lol,"lol","Lobak",orang.x-1-25,orang.y-4);
                                                                orang.delInventory("BijiLobak");
								orang.pic.setIcon( new ImageIcon("pic/LS.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD4.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x-1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int lx=orang.x-1;
                                                                int ly=orang.y;
								System.out.println("biji");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_KIRI1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}
                                        }else{
                                            System.out.println("Tidak ada biji lobak.");
                                        }                                        
                                    }
                                    if(_actCode=='A'){
                                        if (orang.findItem("BijiJagung")){
                                        BijiTanaman lol=new BijiJagung(1,5,"lol");
					if(orang.arah=='D' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/DS.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.biji(orang.x,orang.y+1)){
                                                            
                                                            try{
                                                                URL url4=Stage.class.getResource("v.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url4);
                                                                Clip sfxv=AudioSystem.getClip();
                                                                sfxv.open(audio);
                                                                sfxv.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }        
                                                            
                                                                field.tanam(lol,"lol","Jagung",orang.x-25,orang.y+1-4);
                                                                orang.delInventory("BijiJagung");
								orang.pic.setIcon( new ImageIcon("pic/DS.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD4.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y+1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int dx=orang.x;
                                                                int dy=orang.y+1;
								System.out.println("tanem");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_BAWAH1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='U' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/US.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.biji(orang.x,orang.y-1)){
                                                            
                                                            try{
                                                                URL url4=Stage.class.getResource("v.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url4);
                                                                Clip sfxv=AudioSystem.getClip();
                                                                sfxv.open(audio);
                                                                sfxv.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }   
                                                            
                                                                field.tanam(lol,"lol","Jagung",orang.x-25,orang.y-1-4);
                                                                orang.delInventory("BijiJagung");
								orang.pic.setIcon( new ImageIcon("pic/US.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD4.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y-1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int ux=orang.x;
                                                                int uy=orang.y-1;
								System.out.println("tanem");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_ATAS1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='R' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/RS.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.biji(orang.x+1,orang.y)){
                                                            
                                                            try{
                                                                URL url4=Stage.class.getResource("v.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url4);
                                                                Clip sfxv=AudioSystem.getClip();
                                                                sfxv.open(audio);
                                                                sfxv.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }   
                                                            
                                                                field.tanam(lol,"lol","Jagung",orang.x+1-25,orang.y-4);
                                                                orang.delInventory("BijiJagung");
								orang.pic.setIcon( new ImageIcon("pic/RS.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD4.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int rx=orang.x+1;
                                                                int ry=orang.y;
								System.out.println("biji");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_KANAN1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='L' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/LS.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
							if(stagemap.biji(orang.x-1,orang.y)){
                                                            
                                                            try{
                                                                URL url4=Stage.class.getResource("v.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url4);
                                                                Clip sfxv=AudioSystem.getClip();
                                                                sfxv.open(audio);
                                                                sfxv.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }   
                                                            
                                                                field.tanam(lol,"lol","Jagung",orang.x-1-25,orang.y-4);
                                                                orang.delInventory("BijiJagung");
								orang.pic.setIcon( new ImageIcon("pic/LS.png"));
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLD4.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x-1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                int lx=orang.x-1;
                                                                int ly=orang.y;
								System.out.println("biji");
							}
							orang.pic.setIcon( new ImageIcon(Img.P_KIRI1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}
                                        }else{
                                            System.out.println("Tidak ada biji jagung.");
                                        }
                                    }
                                    
                                    if(_actCode=='F'){
					if(orang.arah=='D' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/DS.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
                                                    int xx = stagemap.feedAyam(kandangAyam,orang.x,orang.y+1,jam);
							if(xx!=99&&orang.findItem("Cacing")){
                                                            
                                                            try{
                                                                URL url2=Stage.class.getResource("x.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url2);
                                                                Clip sfxx=AudioSystem.getClip();
                                                                sfxx.open(audio);
                                                                sfxx.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }  
                                                            
                                                            stagemap.ayamMakan(kandangAyam,orang.x,orang.y+1,jam,orang);
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLOOR1.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y+1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                JPanel abc=new JPanel();
								abc.add(new JLabel(new ImageIcon(Img.CHCR.url)));
								abc.setBackground(new Color(0,0,0,0));
								abc.setBounds((orang.x+px)*q,(orang.y+1+px)*q,q,q+5);
								world.add(abc);
								world.setComponentZOrder(abc,0);
                                                                orang.cacing--;
								System.out.println("Ayam kenyang");
							}else{
                                                            System.out.println("gapunya cacing");
                                                        }
                                                        int xy = stagemap.feedSapi(kandangSapi,orang.x,orang.y+1,jam);
							if(xy!=99&&orang.findItem("Rumput")){ 
                                                            
                                                            try{
                                                                URL url2=Stage.class.getResource("x.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url2);
                                                                Clip sfxx=AudioSystem.getClip();
                                                                sfxx.open(audio);
                                                                sfxx.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }  
                                                            
                                                            stagemap.sapiMakan(kandangSapi,orang.x,orang.y+1,jam,orang);
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLOOR1.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y+1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                if(kandangSapi.arrHewan[xy].getJenis()=="Sapi"){
                                                                    JPanel abc=new JPanel();
                                                                    abc.add(new JLabel(new ImageIcon(Img.COR.url)));
                                                                    abc.setBackground(new Color(0,0,0,0));
                                                                    abc.setBounds((orang.x+px)*q,(orang.y+1+px)*q,q,q+5);
                                                                    world.add(abc);
                                                                    world.setComponentZOrder(abc,0);
                                                                    orang.rumput--;
                                                                    System.out.println("Sapi kenyang");
                                                                } else if(kandangSapi.arrHewan[xy].getJenis()=="Domba"){
                                                                    JPanel abc=new JPanel();
                                                                    abc.add(new JLabel(new ImageIcon(Img.SHPR.url)));
                                                                    abc.setBackground(new Color(0,0,0,0));
                                                                    abc.setBounds((orang.x+px)*q,(orang.y+1+px)*q,q,q+5);
                                                                    world.add(abc);
                                                                    world.setComponentZOrder(abc,0);
                                                                    orang.rumput--;
                                                                    System.out.println("Domba kenyang");
                                                                }
							}
							orang.pic.setIcon( new ImageIcon(Img.P_BAWAH1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='U' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/US.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
                                                    int xx = stagemap.feedAyam(kandangAyam,orang.x,orang.y-1,jam);
							if(xx!=99&&orang.findItem("Cacing")){
                                                            
                                                            try{
                                                                URL url2=Stage.class.getResource("x.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url2);
                                                                Clip sfxx=AudioSystem.getClip();
                                                                sfxx.open(audio);
                                                                sfxx.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }      
                                                            
                                                                stagemap.ayamMakan(kandangAyam,orang.x,orang.y-1,jam,orang);
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLOOR1.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+px)*q,(orang.y-1+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                JPanel abc=new JPanel();
								abc.add(new JLabel(new ImageIcon(Img.CHCR.url)));
								abc.setBackground(new Color(0,0,0,0));
								abc.setBounds((orang.x+px)*q,(orang.y-1+px)*q,q,q+5);
								world.add(abc);
								world.setComponentZOrder(abc,0);
                                                                orang.cacing--;
								System.out.println("Ayam kenyang");
							}
                                                    int xy = stagemap.feedSapi(kandangSapi,orang.x,orang.y-1,jam);
							if(xy!=99&&orang.findItem("Rumput")){ 
                                                            
                                                            try{
                                                                URL url2=Stage.class.getResource("x.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url2);
                                                                Clip sfxx=AudioSystem.getClip();
                                                                sfxx.open(audio);
                                                                sfxx.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }      
                                                            
                                                            stagemap.sapiMakan(kandangSapi,orang.x,orang.y-1,jam,orang);
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLOOR1.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x-1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                if(kandangSapi.arrHewan[xy].getJenis()=="Sapi"){
                                                                    JPanel abc=new JPanel();
                                                                    abc.add(new JLabel(new ImageIcon(Img.COR.url)));
                                                                    abc.setBackground(new Color(0,0,0,0));
                                                                    abc.setBounds((orang.x+px)*q,(orang.y-1+px)*q,q,q+5);
                                                                    world.add(abc);
                                                                    world.setComponentZOrder(abc,0);
                                                                    orang.rumput--;
                                                                    System.out.println("Sapi kenyang");
                                                                } else if(kandangSapi.arrHewan[xy].getJenis()=="Domba"){
                                                                    JPanel abc=new JPanel();
                                                                    abc.add(new JLabel(new ImageIcon(Img.SHPR.url)));
                                                                    abc.setBackground(new Color(0,0,0,0));
                                                                    abc.setBounds((orang.x+px)*q,(orang.y-1+px)*q,q,q+5);
                                                                    world.add(abc);
                                                                    world.setComponentZOrder(abc,0);
                                                                    orang.rumput--;
                                                                    System.out.println("Domba kenyang");
                                                                }
							}
							orang.pic.setIcon( new ImageIcon(Img.P_ATAS1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='R' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/RS.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
                                                    int xx = stagemap.feedAyam(kandangAyam,orang.x+1,orang.y,jam);
							if(xx!=99&&orang.findItem("Cacing")){
                                                            stagemap.ayamMakan(kandangAyam,orang.x+1,orang.y,jam,orang);
                                                            try{
                                                                URL url2=Stage.class.getResource("x.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url2);
                                                                Clip sfxx=AudioSystem.getClip();
                                                                sfxx.open(audio);
                                                                sfxx.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }        
                                                            
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLOOR1.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                JPanel abc=new JPanel();
								abc.add(new JLabel(new ImageIcon(Img.CHCR.url)));
								abc.setBackground(new Color(0,0,0,0));
								abc.setBounds((orang.x+1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(abc);
								world.setComponentZOrder(abc,0);
                                                                orang.cacing--;
								System.out.println("Ayam kenyang");
							}
                                                    int xy = stagemap.feedSapi(kandangSapi,orang.x+1,orang.y,jam);
							if(xy!=99&&orang.findItem("Rumput")){ 
                                                            
                                                            stagemap.sapiMakan(kandangSapi,orang.x+1,orang.y,jam,orang);
                                                            
                                                            try{
                                                                URL url2=Stage.class.getResource("x.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url2);
                                                                Clip sfxx=AudioSystem.getClip();
                                                                sfxx.open(audio);
                                                                sfxx.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }        
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLOOR1.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x+1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                if(kandangSapi.arrHewan[xy].getJenis()=="Sapi"){
                                                                    JPanel abc=new JPanel();
                                                                    abc.add(new JLabel(new ImageIcon(Img.COR.url)));
                                                                    abc.setBackground(new Color(0,0,0,0));
                                                                    abc.setBounds((orang.x+1+px)*q,(orang.y+px)*q,q,q+5);
                                                                    world.add(abc);
                                                                    world.setComponentZOrder(abc,0);
                                                                    orang.rumput--;
                                                                    System.out.println("Sapi kenyang");
                                                                } else if(kandangSapi.arrHewan[xy].getJenis()=="Domba"){
                                                                    JPanel abc=new JPanel();
                                                                    abc.add(new JLabel(new ImageIcon(Img.SHPR.url)));
                                                                    abc.setBackground(new Color(0,0,0,0));
                                                                    abc.setBounds((orang.x+1+px)*q,(orang.y+px)*q,q,q+5);
                                                                    world.add(abc);
                                                                    world.setComponentZOrder(abc,0);
                                                                    orang.rumput--;
                                                                    System.out.println("Domba kenyang");
                                                                }
							}
							orang.pic.setIcon( new ImageIcon(Img.P_KANAN1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='L' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/LS.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
                                                    int xx = stagemap.feedAyam(kandangAyam,orang.x-1,orang.y,jam);
							if(xx!=99&&orang.findItem("Cacing")){
                                                            stagemap.ayamMakan(kandangAyam,orang.x-1,orang.y,jam,orang);
                                                            try{
                                                                URL url2=Stage.class.getResource("x.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url2);
                                                                Clip sfxx=AudioSystem.getClip();
                                                                sfxx.open(audio);
                                                                sfxx.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }        
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLOOR1.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x-1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                JPanel abc=new JPanel();
								abc.add(new JLabel(new ImageIcon(Img.CHCR.url)));
								abc.setBackground(new Color(0,0,0,0));
								abc.setBounds((orang.x-1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(abc);
								world.setComponentZOrder(abc,0);
                                                                orang.cacing--;
								System.out.println("Ayam kenyang");
							}
                                                        int xy = stagemap.feedSapi(kandangSapi,orang.x-1,orang.y,jam);
							if(xy!=99&&orang.findItem("Rumput")){ 
                                                            stagemap.sapiMakan(kandangSapi,orang.x-1,orang.y,jam,orang);
                                                            try{
                                                                URL url2=Stage.class.getResource("x.wav");
                                                                AudioInputStream audio = AudioSystem.getAudioInputStream(url2);
                                                                Clip sfxx=AudioSystem.getClip();
                                                                sfxx.open(audio);
                                                                sfxx.start();
                                                            } catch (Exception ex){
                                                                System.out.println(ex.getMessage());
                                                            }       
								JPanel xYz=new JPanel();
								xYz.add(new JLabel(new ImageIcon(Img.FLOOR1.url)));
								xYz.setBackground(new Color(0,0,0,0));
								xYz.setBounds((orang.x-1+px)*q,(orang.y+px)*q,q,q+5);
								world.add(xYz);
								world.setComponentZOrder(xYz,0);
                                                                if(kandangSapi.arrHewan[xy].getJenis()=="Sapi"){
                                                                    JPanel abc=new JPanel();
                                                                    abc.add(new JLabel(new ImageIcon(Img.COR.url)));
                                                                    abc.setBackground(new Color(0,0,0,0));
                                                                    abc.setBounds((orang.x-1+px)*q,(orang.y+px)*q,q,q+5);
                                                                    world.add(abc);
                                                                    world.setComponentZOrder(abc,0);
                                                                    orang.rumput--;
                                                                    System.out.println("Sapi kenyang");
                                                                } else if(kandangSapi.arrHewan[xy].getJenis()=="Domba"){
                                                                    JPanel abc=new JPanel();
                                                                    abc.add(new JLabel(new ImageIcon(Img.SHPR.url)));
                                                                    abc.setBackground(new Color(0,0,0,0));
                                                                    abc.setBounds((orang.x-1+px)*q,(orang.y+px)*q,q,q+5);
                                                                    world.add(abc);
                                                                    world.setComponentZOrder(abc,0);
                                                                    orang.rumput--;
                                                                    System.out.println("Domba kenyang");
                                                                }
							}
							orang.pic.setIcon( new ImageIcon(Img.P_KIRI1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}
                                    }
                                    if(_actCode=='L'){ //PENCET L
					if(orang.arah=='D' ){
                                                if(_actTimes!=4){
                                                    int xx = stagemap.ambilHasilAyam(kandangAyam,orang.x,orang.y+1,orang);
							if((xx!=99)&&(stagemap.ambilAyam(kandangAyam, orang.x, orang.y+1))){
								orang.pic.setIcon( new ImageIcon("pic/DE.png"));
                                                                orang.telur++;
                                                                refresh();
							}
                                                    int xy = stagemap.ambilHasilSapi(kandangSapi,orang.x,orang.y+1,orang);
							if(xy!=99){ 
                                                                if(kandangSapi.arrHewan[xy].getJenis()=="Sapi"){
                                                                    orang.pic.setIcon( new ImageIcon("pic/DM.png"));
                                                                    orang.susu++;
                                                                    refresh();
                                                                } else if(kandangSapi.arrHewan[xy].getJenis()=="Domba"){
                                                                    orang.pic.setIcon( new ImageIcon("pic/DB.png"));
                                                                    orang.bulu++;
                                                                    refresh();
                                                                }
							}
							orang.pic.setIcon( new ImageIcon(Img.P_BAWAH1.url));
							refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					}else
					if(orang.arah=='U' ){
                                            if(_actTimes!=4){
                                                    int xx = stagemap.ambilHasilAyam(kandangAyam,orang.x,orang.y-1,orang);
							if(xx!=99&&(stagemap.ambilAyam(kandangAyam, orang.x, orang.y-1))){
								orang.pic.setIcon( new ImageIcon("pic/DEU.png"));
                                                                orang.telur++;
                                                                refresh();
                                                               
							}
                                                    int xy = stagemap.ambilHasilSapi(kandangSapi,orang.x,orang.y-1,orang);
							if(xy!=99&&(stagemap.ambilAyam(kandangAyam, orang.x, orang.y-1))){ 
                                                                if(kandangSapi.arrHewan[xy].getJenis()=="Sapi"){
                                                                    orang.pic.setIcon( new ImageIcon("pic/DMU.png"));
                                                                    orang.susu++;
                                                                    refresh();
                                                                } else if(kandangSapi.arrHewan[xy].getJenis()=="Domba"){
                                                                    orang.pic.setIcon( new ImageIcon("pic/DBU.png"));
                                                                    orang.bulu++;
                                                                    refresh();
                                                                }
							}
                                                        orang.pic.setIcon( new ImageIcon(Img.P_ATAS1.url));
                                                        refresh();
							_actTimes=4;
						}else
							_actTimes=4;
						
					}else
					if(orang.arah=='R' ){
                                            if(_actTimes!=4){
                                                    int xx = stagemap.ambilHasilAyam(kandangAyam,orang.x+1,orang.y,orang);
							if(xx!=99&&(stagemap.ambilAyam(kandangAyam, orang.x+1, orang.y))){
								orang.pic.setIcon( new ImageIcon("pic/DER.png"));
                                                                orang.telur++;
                                                                refresh();
							}
                                                    int xy = stagemap.ambilHasilSapi(kandangSapi,orang.x+1,orang.y,orang);
							if(xy!=99&&(stagemap.ambilAyam(kandangAyam, orang.x+1, orang.y))){ 
                                                                if(kandangSapi.arrHewan[xy].getJenis()=="Sapi"){
                                                                    orang.pic.setIcon( new ImageIcon("pic/DMR.png"));
                                                                    orang.susu++;
                                                                    refresh();
                                                                } else if(kandangSapi.arrHewan[xy].getJenis()=="Domba"){
                                                                    orang.pic.setIcon( new ImageIcon("pic/DBR.png"));
                                                                    orang.bulu++;
                                                                    refresh();
                                                                }
							}
							orang.pic.setIcon( new ImageIcon(Img.P_KANAN1.url));
                                                        refresh();
							_actTimes=4;
						}else
							_actTimes=4;
						
					}else
					if(orang.arah=='L' ){
						int xx = stagemap.ambilHasilAyam(kandangAyam,orang.x-1,orang.y,orang);
							if(xx!=99&&(stagemap.ambilAyam(kandangAyam, orang.x-1, orang.y))){
								orang.pic.setIcon( new ImageIcon("pic/DEL.png"));
                                                                orang.telur++;
                                                                refresh();
							}
                                                    int xy = stagemap.ambilHasilSapi(kandangSapi,orang.x-1,orang.y,orang);
							if(xy!=99&&(stagemap.ambilAyam(kandangAyam, orang.x-1, orang.y))){ 
                                                                if(kandangSapi.arrHewan[xy].getJenis()=="Sapi"){
                                                                    orang.pic.setIcon( new ImageIcon("pic/DML.png"));
                                                                    orang.susu++;
                                                                    refresh();
                                                                } else if(kandangSapi.arrHewan[xy].getJenis()=="Domba"){
                                                                    orang.pic.setIcon( new ImageIcon("pic/DBL.png"));
                                                                    orang.bulu++;
                                                                    refresh();
                                                                }
							}
							orang.pic.setIcon( new ImageIcon(Img.P_KIRI1.url));
                                                        refresh();
							_actTimes=4;
						}else
							_actTimes=4;
					
                                    }
                                    else if (_actCode=='Q'){
                                        try{
                                            jam.saveJam("Jam.txt");
                                            orang.savePlayerInv("Pemain.txt");
                                            field.saveField("Field.txt");
                                            kandangAyam.saveAyam("Ayam.txt");
                                            kandangSapi.saveSapi("Sapi.txt");
                                            System.out.println("Game Saved");
                                        } catch (Exception exc){
                                            System.out.println(exc.toString()+ "\n Save error.");
                                        }
                                        _actTimes=4;
                                    }   
                                    else if (_actCode=='I'){
                                        try{
                                            //frame.setVisible(false);
                                        BufferedImage img1 = ImageIO.read(new File("D:\\Tubes OOP\\HarvestValley\\src\\HarvestValley.jpg"));

                                        JFrame frame1 = new JFrame("Inventory");
                                        
                                        frame1.setLocation(400, 200);
                                        //frame.setSize(600,600);
                                        //frame1.setLayout(null);
                                        frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                                        //frame1.setContentPane(new JLabel(new ImageIcon(img1)));
                                        //gui = AntarmukaSwing.getAntarmukaSwing();
                                        //frame1.add(gui);
                                        //JLabel background = new JLabel(new ImageIcon(img1));
                                        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                                        //frame1.addMouseListener(new Stage.BacaMouse());
                                        gui = AntarmukaSwing.getAntarmukaSwing(orang,kandangAyam,kandangSapi);
                                        frame1.add(gui);
                                        frame1.setSize(800,800);
                                        frame1.setLocationRelativeTo(null);
                                        frame1.setVisible(true); 
                                        
                                        //frame1.setLayout(new GridBagLayout());
                                       /* GridBagConstraints gbc = new GridBagConstraints();
                                        gbc.gridwidth = GridBagConstraints.REMAINDER;
                                        JTextField t=new JTextField(20);
                                        frame1.add(t, gbc);
                                        //JLabel l=;
                                        frame1.add(new JLabel("Player name :"), gbc);
                                        JButton b = new JButton("OK");
                                        frame1.add(b, gbc);
                                        */
                                        //frame1.pack();
                                        //frame1.setLocationRelativeTo(null);
                                        //frame1.setVisible(true);
                                        //panel.setBackground(new Color(205,183,158));
                                        //JTextField t=new JTextField(20);
                                        //JLabel l=new JLabel("Player name :");
                                        //JButton b=new JButton("OK");
                                        //panel.setSize(q*px,q*px);
                                        //panel.add(l);
                                        //panel.add(t);
                                        //panel.add(b);
                                        //frame.add(panel);
                                        
                                        /*

                                        b.addActionListener(
                                                new ActionListener(){
                                                        public void actionPerformed(ActionEvent e){
                                                                        frame1.setVisible(false);
                                                                        refresh();

                                                                }
                                                        
                                                }
                                        );/**/
                                        } catch (IOException exe){
                                            System.out.println("no image");
                                        }
                                        _actTimes=4;
                                    }
                                    
                                else if (_actCode=='J') {
                                    state='2';
                                    if((stagemap.store(orang.x+1,orang.y))||(stagemap.store(orang.x-1,orang.y))||(stagemap.store(orang.x,orang.y+1))||(stagemap.store(orang.x,orang.y-1)))
					//if(orang.arah=='D' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/floor.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
                                                    try{
                                            //frame.setVisible(false);
                                                     
                                                        BufferedImage img1 = ImageIO.read(new File("D:\\Tubes OOP\\HarvestValley\\src\\Store.png"));

                                                        JFrame frame1 = new JFrame("Welcome!");

                                                        frame1.setLocation(400, 200);
                                                        //frame.setSize(600,600);
                                                        //frame1.setLayout(null);
                                                        frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                                                        frame1.setContentPane(new JLabel(new ImageIcon(img1)));
                                                        //gui = AntarmukaSwing.getAntarmukaSwing();
                                                        //frame1.add(gui);
                                                        //JLabel background = new JLabel(new ImageIcon(img1));
                                                        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                                                        frame1.addMouseListener(new Stage.BacaMouse());
                                                        //gui = AntarmukaSwing.getAntarmukaSwing();
                                                        //frame1.add(gui);
                                                        frame1.setSize(600,600);
                                                        frame1.setLocationRelativeTo(null);
                                                        frame1.setVisible(true);
                                                        
                                            } catch (IOException exe){
                                            System.out.println("no image");
                                            }
                                     
                                        _actTimes=4;
                                                            
                                                if(orang.arah=='D'){
							orang.pic.setIcon( new ImageIcon(Img.P_BAWAH1.url));
							refresh();
							_actTimes=4;
						}else if(orang.arah=='U'){
							orang.pic.setIcon( new ImageIcon(Img.P_ATAS1.url));
							refresh();
							_actTimes=4;
                                                }else if(orang.arah=='R'){
							orang.pic.setIcon( new ImageIcon(Img.P_KANAN1.url));
							refresh();
							_actTimes=4;
                                                }else if(orang.arah=='L'){
							orang.pic.setIcon( new ImageIcon(Img.P_KIRI1.url));
							refresh();
							_actTimes=4;
                                                }else
							_actTimes=4;
                                        }                                        
                                    }
                                else if (_actCode=='K') {
                                    state='2';
                                    if((stagemap.jual(orang.x+1,orang.y))||(stagemap.jual(orang.x-1,orang.y))||(stagemap.jual(orang.x,orang.y+1))||(stagemap.jual(orang.x,orang.y-1)))
					//if(orang.arah=='D' ){
						if(_actTimes==0){
							orang.pic.setIcon( new ImageIcon("pic/floor.png"));
							refresh();
							_actTimes++;
						}else if(_actTimes==1){
                                                    try{
                                            //frame.setVisible(false);
                                                     
                                                        BufferedImage img1 = ImageIO.read(new File("D:\\Tubes OOP\\HarvestValley\\src\\Jual.png"));

                                                        JFrame frame2 = new JFrame("Welcome!");

                                                        frame2.setLocation(400, 200);
                                                        //frame.setSize(600,600);
                                                        //frame1.setLayout(null);
                                                        frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                                                        frame2.setContentPane(new JLabel(new ImageIcon(img1)));
                                                        //gui = AntarmukaSwing.getAntarmukaSwing();
                                                        //frame1.add(gui);
                                                        //JLabel background = new JLabel(new ImageIcon(img1));
                                                        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                                                        frame2.addMouseListener(new Stage.BacaMouse());
                                                      
                                                        //gui = AntarmukaSwing.getAntarmukaSwing();
                                                        //frame1.add(gui);
                                                        frame2.setSize(600,600);
                                                        frame2.setLocationRelativeTo(null);
                                                        frame2.setVisible(true);
                                                        
                                            } catch (IOException exe){
                                            System.out.println("no image");
                                            }
                                     
                                        _actTimes=4;
                                                            
                                                if(orang.arah=='D'){
							orang.pic.setIcon( new ImageIcon(Img.P_BAWAH1.url));
							refresh();
							_actTimes=4;
						}else if(orang.arah=='U'){
							orang.pic.setIcon( new ImageIcon(Img.P_ATAS1.url));
							refresh();
							_actTimes=4;
                                                }else if(orang.arah=='R'){
							orang.pic.setIcon( new ImageIcon(Img.P_KANAN1.url));
							refresh();
							_actTimes=4;
                                                }else if(orang.arah=='L'){
							orang.pic.setIcon( new ImageIcon(Img.P_KIRI1.url));
							refresh();
							_actTimes=4;
                                                }else
							_actTimes=4;
                                        }  
                                }
                                if (_actCode=='M') {
                                    try{
                                            //frame.setVisible(false);
                                       BufferedImage img1 = ImageIO.read(new File("D:\\Tubes OOP\\HarvestValley\\src\\Map.png"));

                                        JFrame frame3 = new JFrame("PETA");

                                        frame3.setLocation(400, 200);
                                        //frame.setSize(600,600);
                                        //frame1.setLayout(null);
                                        frame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                                        frame3.setContentPane(new JLabel(new ImageIcon(img1)));
                                        //gui = AntarmukaSwing.getAntarmukaSwing();
                                        //frame1.add(gui);
                                        //JLabel background = new JLabel(new ImageIcon(img1));
                                        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                                        //frame3.addMouseListener(new Stage.BacaMouse());

                                        //gui = AntarmukaSwing.getAntarmukaSwing();
                                        //frame1.add(gui);
                                        frame3.setSize(600,600);
                                        frame3.setLocationRelativeTo(null);
                                        frame3.setVisible(true);
                                        } catch (IOException exe){
                                            System.out.println("no image");
                                        }
                                        _actTimes=4;
                                }

				if(_actTimes>3){
					_actTimes=0;
					_actCode=' ';
					//_moveCode=' ';
					act.stop();
				}
			}
		}
	);
        
  
	/* public static void main(String[] args) {
		
		Stage a=new Stage("peta");
		a.mulai();
	}*/

}
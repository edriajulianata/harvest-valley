import java.io.*;
import java.util.*;

public class StageMap{
    //
	private String map,mapArea;
	protected StringBuffer mapObj;
	private int w,h;
	private List<Area> listArea=new ArrayList<>();
	private List<Objek> listObj=new ArrayList<>();
	
	public StageMap(String n){
		map 	=new String(load(n));
		mapArea =new String(getMapArea());
		mapObj  =new StringBuffer(getMapObj());
	}
	public char mapAt(int x, int y){
		return x>=0 & y>=0 & x<w & y<h?map.charAt(y*w+x):'`';
	}
	public char mapAreaAt(int x, int y){
		return x>=0 & y>=0 & x<w & y<h?mapArea.charAt(y*w+x):'.';
	}
	public char mapObjAt(int x, int y){
		return x>=0 & y>=0 & x<w & y<h?mapObj.charAt(y*w+x):'`';
	}

	/// FIELD //
	public boolean macul(int x, int y){
		if(mapObjAt(x,y)=='x'){
			mapObj.setCharAt(y*w+x,'y');
			return true;
		}
		return false;
	}
        
        //sleep
        
        public boolean sleep(int x, int y){
		if(mapObjAt(x,y)=='B'){
			return true;
		}
		return false;
	}
        
        //STORE
        public boolean store(int x, int y){
		if(mapObjAt(x,y)=='^'){
			return true;
		}
		return false;
	}
        
        public boolean jual(int x, int y){
		if(mapObjAt(x,y)=='*'){
			return true;
		}
		return false;
	}
        
        
        //mati
        public boolean canRemoveTanaman(Field f,Jam jam) {
            boolean found=false;
            for (int i=0;i<20;i++){
                for (int j=0;j<20;j++){
                    if (f.mtxPlant[i][j]!=null && f.mtxPlant[i][j].isDead(jam)){
                        //f.mtxPlant[i][j]=null;
                        mapObj.setCharAt((j+4)*w+(i+25),'U');
                        found= true;
                    }
                }
            }
            return found;
        }
        
        public boolean canRemoveAyam(KandangAyam k,Jam jam) {
            boolean found=false;
            for (int i=0;i<20;i++){
                    if (k.arrHewan[i]!=null && k.arrHewan[i].isDead(jam)){
                        //f.mtxPlant[i][j]=null;
                        Ayam a = (Ayam) k.arrHewan[i];
                        mapObj.setCharAt((a.y+35)*w+(a.x+13),'x');
                        found= true;
                    }
                }
            return found;
        }
        
        public boolean canRemoveSapi(KandangSapi k,Jam jam) {
            boolean found=false;
            for (int i=0;i<20;i++){
                    if (k.arrHewan[i]!=null && k.arrHewan[i].isDead(jam)){
                        //f.mtxPlant[i][j]=null;
                        if(k.arrHewan[i].getJenis()== "Sapi"){
                            Sapi a = (Sapi) k.arrHewan[i];
                            mapObj.setCharAt((a.y+27)*w+(a.x+25),'x');
                            found= true;
                        } else if (k.arrHewan[i].getJenis()== "Domba"){
                            Domba a = (Domba) k.arrHewan[i];
                            mapObj.setCharAt((a.y+27)*w+(a.x+25),'x');
                            found= true;
                        }
                    }
                }
            return found;
        }
        
	//SIRAM 
        public boolean siram(int x, int y) {
		if(mapObjAt(x,y)=='y'){
			mapObj.setCharAt(y*w+x,'z');
			return true;
                }
		return false;
        }
        
        //NANEM
        public boolean biji(int x, int y) {
		if(mapObjAt(x,y)=='z'){
			mapObj.setCharAt(y*w+x,'Z');
			return true;
		}
		return false;
        }
        
        public boolean arit(int x, int y) {
		if((mapObjAt(x,y)=='Y')||(mapObjAt(x,y)=='u')||(mapObjAt(x,y)=='U')){
			mapObj.setCharAt(y*w+x,'x');
			return true;
		}
		return false;
        }
        
        
        public boolean tumbuh(int x, int y) {
		if(mapObjAt(x,y)=='Z'){ //fase trakhir ada biji
			mapObj.setCharAt(y*w+x,'Y'); //Y itu baru tumbuh kol
			return true;
		}
		return false;
        }
        
        
        public boolean fasePanen(int x, int y){
            if(mapObjAt(x,y)=='Y'){ //fase trakhir tumbuh
			mapObj.setCharAt(y*w+x,'u'); //u panen KOL
			return true;
		}
            return false;
        }
           
        public boolean diPanen(int x, int y) {
            if(mapObjAt(x,y)=='u'){ //fase trakhir tumbuh
		//	mapObj.setCharAt(y*w+x,'U'); //ilalang
			return true;
		}
            return false;
        }
        
        public void toTumbuh(int x, int y){
            mapObj.setCharAt(y*w+x,'Y');
        }
        
        public void toIlalang(int x, int y) {
            mapObj.setCharAt(y*w+x,'U'); //ilalang
        }
        
        //HEWAN
        
        public int feedAyam(KandangAyam k, int x, int y,Jam jam){
            int found=99;
            for (int i=0;i<20;i++){
                    if (k.arrHewan[i]!=null){
                        Ayam a = (Ayam) k.arrHewan[i];
                        if ((a.x==x-13)&&(a.y==y-35)){
                            //a.makan(jam);
                            //mapObj.setCharAt((a.y+35)*w+(a.x+13),'x');
                            //System.out.println("feeeeeeed");
                            found= i;
                        }
                    }
                }
            return found;
        }
        
        public void ayamMakan(KandangAyam k, int x, int y, Jam jam, Player p){
            for (int i=0;i<20;i++){
                    if (k.arrHewan[i]!=null){
                        Ayam a = (Ayam) k.arrHewan[i];
                        if ((a.x==x-13)&&(a.y==y-35)){
                            a.makan(jam,p);
                            mapObj.setCharAt((a.y+35)*w+(a.x+13),'x');
                            System.out.println("feeeeeeed");
                        }
                    }
                }
        }
        
        public boolean ambilAyam(KandangAyam k, int x, int y){
             if(mapObjAt(x,y)=='x'){
                 return true;
             }
             return false;
        }
        
        public int ambilHasilAyam(KandangAyam k, int x, int y,Player p){
            int found=99;
            for (int i=0;i<20;i++){
                    if (k.arrHewan[i]!=null){
                         //if(mapObjAt(x,y)=='x')
                            Ayam a = (Ayam) k.arrHewan[i];
                            if ((a.x==x-13)&&(a.y==y-35)&&a.isAdaHasil()){
                                a.ambilHasil(p);
                                mapObj.setCharAt((a.y+35)*w+(a.x+13),'P');
                                System.out.println("telur terambil");
                                found= i;
                            }
                        }
                    }
                
            return found;
        }
        
        public int ambilHasilSapi(KandangSapi k, int x, int y,Player p){
            int found=99;
            for (int i=0;i<20;i++){
                    if (k.arrHewan[i]!=null){
                            if(k.arrHewan[i].getJenis()== "Sapi"){
                                Sapi a = (Sapi) k.arrHewan[i];
                                if ((a.x==x-25)&&(a.y==y-27)&&a.isAdaHasil()){
                                    a.ambilHasil(p);
                                    mapObj.setCharAt((a.y+27)*w+(a.x+25),'P');
                                    System.out.println("susu terambil");
                                    found= i;
                                }
                            } else if (k.arrHewan[i].getJenis()== "Domba"){
                                Domba a = (Domba) k.arrHewan[i];
                                if ((a.x==x-25)&&(a.y==y-27)&&a.isAdaHasil()){
                                    a.ambilHasil(p);
                                    mapObj.setCharAt((a.y+27)*w+(a.x+25),'P');
                                    System.out.println("bulu terambil");
                                    found= i;
                                }
                            }
                        }
            }
            return found;
        }
        
        public int feedSapi(KandangSapi k, int x, int y,Jam jam){
            int found=99;
            for (int i=0;i<20;i++){
                    if (k.arrHewan[i]!=null){
                        if(k.arrHewan[i].getJenis()== "Sapi"){
                            Sapi a = (Sapi) k.arrHewan[i];
                            if ((a.x==x-25)&&(a.y==y-27)){
//                                a.makan(jam);
//                                mapObj.setCharAt((a.y+27)*w+(a.x+25),'x');
//                                System.out.println("feeeeeeed");
                                found= i;
                            }
                        } else if (k.arrHewan[i].getJenis()== "Domba"){
                            Domba a = (Domba) k.arrHewan[i];
                            if ((a.x==x-25)&&(a.y==y-27)){
//                                a.makan(jam);
//                                mapObj.setCharAt((a.y+27)*w+(a.x+25),'x');
//                                System.out.println("feeeeeeed");
                                found= i;
                            }
                        }
                    }
                }
            return found;
        }
        
        public void sapiMakan(KandangSapi k, int x, int y,Jam jam,Player p){
            for (int i=0;i<20;i++){
                    if (k.arrHewan[i]!=null){
                        if(k.arrHewan[i].getJenis()== "Sapi"){
                            Sapi a = (Sapi) k.arrHewan[i];
                            if ((a.x==x-25)&&(a.y==y-27)){
                                a.makan(jam,p);
                                mapObj.setCharAt((a.y+27)*w+(a.x+25),'x');
                                System.out.println("feeeeeeed");
                            }
                        } else if (k.arrHewan[i].getJenis()== "Domba"){
                            Domba a = (Domba) k.arrHewan[i];
                            if ((a.x==x-25)&&(a.y==y-27)){
                                a.makan(jam,p);
                                mapObj.setCharAt((a.y+27)*w+(a.x+25),'x');
                                System.out.println("feeeeeeed");
                            }
                        }
                    }
                }
        }
        
        public boolean addAyam(int x, int y){
            if(mapObjAt(x,y)=='.'){
                    //if(a.addHewan(ay)){
                                mapObj.setCharAt(y*w+x,'A');
                                return true;
                    //    }
            }
            return false;
        }
        
        public boolean addSapi(int x, int y){
            if(mapObjAt(x,y)=='.'){
                    //if(a.addHewan(ay)){
                                mapObj.setCharAt(y*w+x,'S');
                                return true;
                    //    }
            }
            return false;
        }
        
        
        public boolean gantiHari() {
            //hmm bingung lol, ganti hari dia bakal numbuh
            return true;
        }
        

	public String changeCharAt(String m, int x,char c){
		StringBuffer b=new StringBuffer(m);
		if(x<map.length()){
			b.setCharAt(x,c);
		}
		return new String(b);
	}
	public int w(){return w(this.w);}
	public int w(int x){
		this.w=x;
		return x;
	}
	public int h(){return h(this.h);}
	public int h(int x){
		this.h=x;
		return x;
	}

	public void addObj(){
		for(int i=0;i<w;i++){
			for(int j=0;j<h;j++){
				if(mapObjAt(i,j)!='.'){
					//
				}
			}
		}
	}

	public String getMapArea(){
		StringBuffer s=new StringBuffer("");
		for(int i=0;i<w;i++)
			for(int j=0;j<h;j++)
				s.append('.');
			
		for(int i=0;i<w;i++)
			for(int j=0;j<h;j++){
				Iterator it=listArea.iterator();
				while(it.hasNext()){
					Area ar=(Area) it.next();
					if(ar.isInArea(i,j))
						s.setCharAt(j*w+i,ar.getChar(i,j));
				}
			}
		return new String(s);
	}

	public String getMapObj(){
		StringBuffer s=new StringBuffer("");
		for(int i=0;i<map.length();i++)
			if(map.charAt(i)!='.')
				s.append(map.charAt(i));
			else
				s.append('.');
		return new String(s);
	}
        
        
        
        public String cekFase(int x, int y){
            if(mapObjAt(x,y)=='y'){
                return "tanah basah";
            } else if(mapObjAt(x,y)=='Z'){ //fase trakhir ada biji
			return "biji>>tumbuh";
            } else if(mapObjAt(x,y)=='Y'){ //fase trakhir tumbuh
			return "tumbuh>>panen";
            } else {
                return (Character.toString(mapObjAt(x,y)));
            }
        }
        
        public char Fase(int x, int y){
            return mapObjAt(x,y);
        }

	public String load(String n){
		try{
			this.h=0;
			File file=new File(n);
			Scanner sc=new Scanner(file);
			StringBuffer s=new StringBuffer("");
			while(sc.hasNextInt()){
				listArea.add(new Area(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next().charAt(0)));
				sc.nextLine();
			}

			while(sc.hasNextLine()){
				String m=sc.nextLine();
				//if(this.w!=0 && m.length()!=this.w)
                                //throw new FileNotFoundException();
				this.w=m.length();
				this.h++;
				s=new StringBuffer(s+m);
			}
			return new String(s);
		}catch(Exception e){
			System.out.println("Terjadi kesalahan saat memuat stage.");
			//System.exit(1);*/
			return "";
		}
	}

	public String printMap(){
		String s="";
		int i=0;
		while(i<h){
			s+=(new String(mapObj)).substring(i*w,++i*w)+"\n";
			//s+=(new String(mapArea)).substring(i*w,++i*w)+"\n";
			//s+=(new String(map)).substring(i*w,++i*w)+"\n";
		}

		return s;
	}

	/*
        public static void main(String[] args) {
		StageMap s=new StageMap("peta");
		System.out.println(s.printMap());
		System.out.println(s.mapAreaAt(20,20));
		System.out.println(s.mapObjAt(20,20));
		System.out.println(s.hoe(20,20));
		System.out.println(s.mapObjAt(20,20));
		System.out.println(s.hoe(20,20));
		System.out.println(s.mapObjAt(20,20));
		//System.out.println(s.printMap());
	} */
}

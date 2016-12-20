public enum Img{

        //hiasan
        Patung1     ('M',"pic/Patung1.png",false),
        Patung2     ('N',"pic/Patung2.png",false),
        Patung3     ('@',"pic/Patung3.png",false),
        Patung4     ('#',"pic/Patung4.png",false),
        
        //Rumah
        Batas          ('f',"pic/Batas.png",false),
        Jendela        ('g',"pic/Jendela.png",false),
        Batas1         ('h',"pic/Batas1.png",false),
        DF             ('i',"pic/DF.png",false),
        DF1            ('j',"pic/DF1.png",false),
        DF2            ('k',"pic/DF2.png",false), 
        Perapian       ('l',"pic/Perapian.png",false),
        Piano          ('m',"pic/Piano.png",false),
        Piano1         ('n',"pic/Piano1.png",false),
        KursiPiano     ('o',"pic/KursiPiano.png",false),
        Ayam1          ('p',"pic/Ayam1.png",false),
        Buah     ('q',"pic/Buah.png",false),
        Roti     ('r',"pic/Roti.png",false),
        Sauce     ('s',"pic/Sauce.png",false),
        Teh     ('T',"pic/Teh.png",false),
        Wine     ('P',"pic/Wine.png",false),
        MejaKasur   ('Q',"pic/MejaKasur.png",false),
        LK              ('K',"pic/LemariKiri.png", false),
        LK1             ('L',"pic/LemariKiri1.png", false),
        LA              ('A',"pic/LemariAtas.png",false),
        RO             ('R',"pic/Roti.png", false),
        M1             ('a',"pic/Meja1.png",false),
        M2             ('b',"pic/Meja2.png",false),
        M3             ('c',"pic/Meja3.png",false),
        M4             ('d',"pic/Meja4.png",false),
        M5             ('e',"pic/Meja5.png",false),
        
        //BUY and SELL
        Buy1    ('$',"pic/Buy.png", false),
        Buy2    ('%',"pic/Buy1.png",false),
        Buy3    ('^',"pic/Buy2.png", false),
        Sell1   ('&',"pic/Sell.png",false),
        Sell2   ('*',"pic/Sell1.png",false),
        Sell3   ('(',"pic/Sell2.png",false),
        
        //player
        P_KANAN1        ("pic/RS.png"),
	P_KANAN2	("pic/R.png"),
	P_KIRI1         ("pic/LS.png"),
	P_KIRI2         ("pic/L.png"),
	P_ATAS1		("pic/US.png"),
	P_ATAS2         ("pic/UR.png"),
	P_BAWAH1	("pic/DS.png"),
	P_BAWAH2        ("pic/DR.png"),
        
        //lain lain
	NULL		('.',"pic/null.png",	true), // BELUM ADA 
	BATU 		('`',"pic/Pohon1.png",	false),
	BLOCK 		("pic/block.png",	false), 
	UNDEF 		("pic/undef.png",	true),
	FLD1		('x',"pic/Lahan1.png",	true),
	FLD2		('y',"pic/Lahan2.png",	true),
	FLD3		('z',"pic/Lahan3.png",	true),
        FLD4		('Z',"pic/LahanBiji.png",true),
        FLD5		('Y',"pic/CBG1.png",	false),
	WATER		('-',"pic/water.gif",	false),
	WD		('X',"pic/w.png",	false),
	WL              ('آ',"pic/wl.png",	false),
	WU		('÷',"pic/wu.png",	false),
	WR		('أ',"pic/wr.png",	false),
        Semak           ('v',"pic/SemakH.png",  false),
        Semak1          ('w',"pic/SemakV.png",  false),
        DOR             ('D',"pic/DOOR.png",	false),
	BED             ('B',"pic/Bed.png",	false),
	T		('t',"pic/tebing.png",	false),
        
        
        //KAKAS TANAMAN (Arit)
        DA          ("pic/DA.png"),
        LIA         ("pic/LA.png"),
        RA          ("pic/RA.png"),
        UA          ("pic/UA.png"),
        
        //KAKAS TANAMAN (Pacul)
        DP          ("pic/DP.png"),
        LP          ("pic/LP.png"),
        RP          ("pic/RP.png"),
        UP          ("pic/UP.png"),
        
        //KAKAS TANAMAN (WaterCan)
        DW          ("pic/DW.png"),
        LW          ("pic/LW.png"),
        RW          ("pic/RW.png"),
        UW          ("pic/UW.png"),
        
        //KandangAyam
        MAyam       ('C',"pic/MakananAyam.png",false),
        MAyam1      ('E',"pic/MakananAyam1.png",false),
        JendelaKandang  ('O',"pic/JendelaKandang.png",false),
        
        //KandangSapi
        MSapi       ('G',"pic/MakananSapi.png",false),
        MSapi1      ('H',"pic/MakananSapi1.png",false),
        
        //HEWAN
        CHCU            ("pic/CHCU.png", false),
        CHCD            ("pic/CHCD.png", false),
        CHCL            ("pic/CHCL.png", false),
        CHCR            ("pic/CHCR.png", false),
        CHCWD           ("pic/CHCWD.png", false),  
        CHCWL           ("pic/CHCWL.png",   false),
        CHCWR           ("pic/CHCWR.png", false),    
        CHCWU           ("pic/CHCWU.png", false),
        CHCH           ("pic/CHCkecil.png", false),
        SHPU            ("pic/SHPU.png", false),
        SHPD            ("pic/SHPD.png", false),
        SHPL            ("pic/SHPL.png", false),
        SHPR            ("pic/SHPR.png", false),
        SHPH            ("pic/SHPKecil.png", false),
        SHPWD           ("pic/SHPWD.png", false),  
        SHPWL           ("pic/SHPWL.png", false),
        SHPWR           ("pic/SHPWR.png", false),    
        SHPWU           ("pic/SHPWU.png", false),
        COU            ("pic/COU.png", false),
        COD            ("pic/COD.png", false),
        COL            ("pic/COL.png", false),
        COR            ("pic/COR.png", false),
        COH            ("pic/COKecil.png", false),
        COWD           ("pic/COWD.png", false),  
        COWL           ("pic/COWL.png", false),
        COWR           ("pic/COWR.png", false),    
        COWU           ("pic/COWU.png", false),
        
        //TANAMAN
        RDSH1            ("pic/RDSH1.png", false),
        RDSH2            ("pic/RDSH2.png", false),
        RDSH3           ("pic/RDSH3.png", false),
        CORN1            ("pic/CORN1.png", false),
        CORN2           ("pic/CORN2.png", false),
        CORN3           ("pic/CORN3.png", false),
        CBG1           ("pic/CBG1.png", false),
        CBG2            ('u', "pic/CBG2.png", false),
        CBG3            ('U',"pic/CBG3.png", false), //anggap saja ilalang
        Daun            ('I',"pic/Daun.png",true),
        Bunga           ('J',"pic/Bunga.png",false),
        
        
        
	//TOOLS
	ARIT            ("pic/Arit.png"),
	PACUL		("pic/Pacul.png"),
	WATCAN		("pic/WaterCan.png"),
	SPOUCH		("pic/WaterCan.png"),
        FLOOR1		("pic/floor.png");

	public enum ImgBg{
		LATAR		('.',"pic/t.png"),
		FLOOR		('H',"pic/floor.png");

		public String url;
		public char c;
		ImgBg(char c, String url){
			this.url=url;
			this.c=c;
		}
	}

	public String url;
	public char c;
	public boolean passable;
	Img(String url){
		this(url,true);
	}
	Img(String url, boolean t){
		this('~', url,t);
	}
	Img(char c, String url, boolean t){
		this.url=url;
		this.passable=t;
		this.c=c;
	}
}
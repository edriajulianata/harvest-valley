/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edria Julianata
 */    
import java.io.*;
import java.util.*;


public class TulisFile {	
    // Method tulis file
    public static void tulisFile(String teks, String namaFile) {
			try {
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new FileWriter(namaFile, true)));
            out.println(teks);
            out.close();
			} catch (IOException e) {
				System.out.println("Gagal menulis ke file " + namaFile);
				//e.printStackTrace();
				}
    }
    
    
}

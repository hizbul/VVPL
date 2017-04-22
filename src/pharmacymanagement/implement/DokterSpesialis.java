/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.implement;

/**
 *
 * @author drag me to hell
 */
public class DokterSpesialis {
    static String namaDokter;
    static String spesialis;
    static String kodeDokter;
    static String kodeResep;
    
    public static  void setDokterSpesialis(String kd, String nd, String s){
        kodeDokter = kd;
        namaDokter = nd;
        spesialis = s;
    }
    
    public static void setKodeResep(String kr){
        kodeResep = kr;
    }
    public static String getDokter(){
        return namaDokter;
    }
    
    public static String getSpesialis(){
        return spesialis;
    }
    
    public static String getKodeDokter(){
        return kodeDokter;
    }
    
    public static String getKodeResep(){
        return kodeResep;
    }
}

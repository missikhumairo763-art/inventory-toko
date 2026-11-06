/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.toko.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class BarangMasuk {
        private int idMasuk;
        private int idBarang;
        private int idUser;
        private Date tanggalMasuk;
        private int jumlah;
        private String keterangan;
        
        public BarangMasuk() {  
        }
        
        public BarangMasuk(int idMasuk, int idBarang,int idUser,Date tanggalMasuk,int jumlah,String keterang) {
            
            this.idMasuk = idMasuk;
            this.idBarang =idBarang;
            this.idUser = idUser;
            this.tanggalMasuk = tanggalMasuk;
            this.jumlah = jumlah;
            this.keterangan = keterangan;
        }
        
        public int getIdMasuk(){
            return idMasuk;
        }
        
        public void setIdMasuk(int idMasuk){
            this.idMasuk = idMasuk;
            
        }
        
        public int getIdBarang(){
            return idBarang;
        }
        
        public void setIdBarang(int idBarang) {
            this.idBarang =idBarang;
        }
    
        public int getIdUser(){
            return idUser;
        }
        
        public void setIdUser(int idUser){
            this.idUser =idUser;
        }
        
        public Date getTanggalMasuk(){
            return tanggalMasuk;
            
        }
        
        public int getJumlah() {
            return jumlah;
        }
        
        public void setJumlah(int jumlah){
            this.jumlah = jumlah;
        }
        
        public String getKeterangan(){
            this.keterangan = keterangan;
            return null;
        }
        
        public String setKeterangan(){
            return keterangan ;
        }
        
        public void setKeterangan(String keterangan) {
            this.keterangan = keterangan;
        }

}

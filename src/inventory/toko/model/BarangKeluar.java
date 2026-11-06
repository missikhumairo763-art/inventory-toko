/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.toko.model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class BarangKeluar {
    private int idKeluar;
    private int idBarang;   
    private int idUser;
     private Date tanggalKeluar;
     private int jumlah;
      private String keterangan;
      
      // Constructor kosong
      public BarangKeluar() {
    }

        //Constructor dengan parameter
      public BarangKeluar(int idkeluar, int idBarang,
              int idUser, Date tanggalKeluar,
              int jumlah, String Keterangan) {
          
          this.idKeluar = idKeluar;
          this.idBarang = idBarang;
          this.idUser = idUser;
          this.tanggalKeluar =tanggalKeluar;
          this.jumlah =jumlah;
          this.keterangan = keterangan;
          
      }
      
      //Getter dan Setter ID Keluar
      public int getIdKeluar(){
          return idKeluar;
      }
      
      public void setIdKeluar(int idKeluar){
          this.idKeluar = idKeluar;
      }
      
      //Getter dan Setter ID Barang
      public int getIdBarang(){
          return idBarang;
         }
      
         public void setIdBarang(int idBarang){
             this.idBarang = idBarang;
         }
         
         //Getter dan Setter Id User
         public int getIdUser(){
             return idUser;
         }
         
         public void setIdUser(int idUser){
             this.idUser = idUser;
         }
         
         //Getter dan Setter tanggal keluar
         public Date getTanggalKeluar(){
             return tanggalKeluar;
         }
         
         public void setTanggalKeluar(Date tanggalKeluar){
             this.tanggalKeluar = tanggalKeluar;
         }
         
         //Getter dan Setter jumlah
         public int getJumlah(){
             return jumlah;
         }
         
         public void setJumlah(int Jumlah){
             this.jumlah =jumlah;
             
         }
         
         
}       




    

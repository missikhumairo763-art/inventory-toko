/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.toko.model;

public class Supplier{
    private int idSupplier;
    private String namaSupplier;
    private String alamat;
    private String noTelepon;
    
    
    //Constructor kosong
   
    public Supplier(){
        
    }
    
    
    //Constructor dengan parameter
    public Supplier(int idSupplier, String namaSupplier,
            String alamat, String noTelepon){
        
        this.idSupplier =idSupplier;
        this.namaSupplier =namaSupplier;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
    }
    
    
    
    //Getter dan Setter ID Supplier
    public int getIdSupplier(){
        return idSupplier;
    }
    
    public void setIdSupplier(int idSupplier){
        this.idSupplier =idSupplier;
        
    }
    
    //Getter Setter Nama Supppiler
    public String getNamaSupplier(){
        return namaSupplier;
    }
    
    public void setNamaSupplier(String namaSupplier) {
        this.namaSupplier =namaSupplier;
    }
    
    //Getter dan Setter Alamat
    public String getAlamat(){
        return alamat;
    
}
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    //Getter dan Setter noTelepon
    public String getNoTelepon(){
        return noTelepon;
    }
    
    public void setNoTelepon(String noTelepon){
        this.noTelepon = noTelepon;
    }
/**
 *
 * @author Admin
 */

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.toko.model;

/**
 *
 * @author Admin
 */
public class Jumlah {
 // Deklarasi atribut
    private int idJumlah;
    private int idBarang;
    private int jumlahStok;
    private String keterangan;

    // Constructor kosong
    public Jumlah() {

    }

    // Constructor dengan parameter
    public Jumlah(int idJumlah, int idBarang,
            int jumlahStok, String keterangan) {

        this.idJumlah = idJumlah;
        this.idBarang = idBarang;
        this.jumlahStok = jumlahStok;
        this.keterangan = keterangan;
    }

    // Getter dan Setter ID Jumlah
    public int getIdJumlah() {
        return idJumlah;
    }

    public void setIdJumlah(int idJumlah) {
        this.idJumlah = idJumlah;
    }

    // Getter dan Setter ID Barang
    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    // Getter dan Setter Jumlah Stok
    public int getJumlahStok() {
        return jumlahStok;
    }

    public void setJumlahStok(int jumlahStok) {
        this.jumlahStok = jumlahStok;
    }

    // Getter dan Setter Keterangan
    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

}   
    
    


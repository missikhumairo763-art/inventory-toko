/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.toko.model;

/**
 *
 * @author Admin
 */
public class Kategori {
    
   // Atribut
    private int idKategori;
    private String namaKategori;
    private String keterangan;

    // Constructor kosong
    public Kategori() {
    }

    // Constructor dengan parameter
    public Kategori(int idKategori, String namaKategori, String keterangan) {
        this.idKategori = idKategori;
        this.namaKategori = namaKategori;
        this.keterangan = keterangan;
    }

    // Getter dan Setter ID Kategori
    public int getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(int idKategori) {
        this.idKategori = idKategori;
    }

    // Getter dan Setter Nama Kategori
    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    // Getter dan Setter Keterangan
    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
  
}

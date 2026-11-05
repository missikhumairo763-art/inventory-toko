/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.toko.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Barang {

    private final Koneksi koneksi = new Koneksi();
    private int idBarang;
    private String kodeBarang;
    private String namaBarang;
    private int idKategori;
    private int idSupplier;
    private Double hargaBeli;
    private Double hargaJual;
    private int stok;
    private String satuan;

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }
    

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(int idKategori) {
        this.idKategori = idKategori;
    }

   

    public Double getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(Double hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public Double getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(Double hargaJual) {
        this.hargaJual = hargaJual;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public void create() throws SQLException {
        String sql = "INSERT INTO barang (kode_barang, nama_barang, id_kategori, id_supplier, harga_beli, harga_jual, stok, satuan) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = Koneksi.getKoneksi();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, kodeBarang);
        pst.setString(2, namaBarang);
        pst.setInt(3, idKategori);
        pst.setInt(4, idSupplier);
        pst.setDouble(5, hargaJual);
        pst.setDouble(6, hargaJual);
        pst.setInt(7, stok);
        pst.setString(8, satuan);
        pst.executeUpdate();
    }

}

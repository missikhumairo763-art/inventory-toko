/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.toko.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Barang {

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
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, kodeBarang);
            pst.setString(2, namaBarang);
            pst.setInt(3, idKategori);
            pst.setInt(4, idSupplier);
            pst.setDouble(5, hargaBeli);
            pst.setDouble(6, hargaJual);
            pst.setInt(7, stok);
            pst.setString(8, satuan);
            pst.executeUpdate();
        }
    }

    public void update() throws SQLException {
        String sql = "UPDATE barang SET kode_barang = ?, nama_barang = ?, id_kategori = ?, id_supplier = ?, harga_beli = ?, harga_jual = ?, stok = ?, satuan = ? WHERE id_barang = ?";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, kodeBarang);
            pst.setString(2, namaBarang);
            pst.setInt(3, idKategori);
            pst.setInt(4, idSupplier);
            pst.setDouble(5, hargaBeli);
            pst.setDouble(6, hargaJual);
            pst.setInt(7, stok);
            pst.setString(8, satuan);
            pst.setInt(9, idBarang);
            pst.executeUpdate();
        }
    }

    public void delete() throws SQLException {
        String sql = "DELETE FROM barang WHERE id_barang = ?";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idBarang);
            pst.executeUpdate();
        }
    }

    public static List<Barang> list() throws SQLException {
        String sql = "SELECT id_barang, kode_barang, nama_barang, id_kategori, id_supplier, harga_beli, harga_jual, stok, satuan FROM barang ORDER BY id_barang DESC";
        List<Barang> daftarBarang = new ArrayList<>();
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Barang barang = new Barang();
                barang.setIdBarang(rs.getInt("id_barang"));
                barang.setKodeBarang(rs.getString("kode_barang"));
                barang.setNamaBarang(rs.getString("nama_barang"));
                barang.setIdKategori(rs.getInt("id_kategori"));
                barang.setIdSupplier(rs.getInt("id_supplier"));
                barang.setHargaBeli(rs.getDouble("harga_beli"));
                barang.setHargaJual(rs.getDouble("harga_jual"));
                barang.setStok(rs.getInt("stok"));
                barang.setSatuan(rs.getString("satuan"));
                daftarBarang.add(barang);
            }
        }
        return daftarBarang;
    }

}

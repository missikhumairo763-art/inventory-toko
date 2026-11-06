/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.toko.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

    public BarangMasuk(int idMasuk, int idBarang, int idUser, Date tanggalMasuk, int jumlah, String keterangan) {

        this.idMasuk = idMasuk;
        this.idBarang = idBarang;
        this.idUser = idUser;
        this.tanggalMasuk = tanggalMasuk;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
    }

    public int getIdMasuk() {
        return idMasuk;
    }

    public void setIdMasuk(int idMasuk) {
        this.idMasuk = idMasuk;

    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getTanggalMasuk() {
        return tanggalMasuk;

    }

    public void setTanggalMasuk(Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void create() throws SQLException {
        String sql = "INSERT INTO barang_masuk (id_barang, id_user, tanggal_masuk, jumlah, keterangan) VALUES (?, ?, ?, ?, ?)";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idBarang);
            pst.setInt(2, idUser);
            pst.setDate(3, tanggalMasuk);
            pst.setInt(4, jumlah);
            pst.setString(5, keterangan);
            pst.executeUpdate();
        }
    }

    public void update() throws SQLException {
        String sql = "UPDATE barang_masuk SET id_barang = ?, id_user = ?, tanggal_masuk = ?, jumlah = ?, keterangan = ? WHERE id_masuk = ?";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idBarang);
            pst.setInt(2, idUser);
            pst.setDate(3, tanggalMasuk);
            pst.setInt(4, jumlah);
            pst.setString(5, keterangan);
            pst.setInt(6, idMasuk);
            pst.executeUpdate();
        }
    }

    public void delete() throws SQLException {
        String sql = "DELETE FROM barang_masuk WHERE id_masuk = ?";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idMasuk);
            pst.executeUpdate();
        }
    }

    public static List<BarangMasuk> list() throws SQLException {
        String sql = "SELECT id_masuk, id_barang, id_user, tanggal_masuk, jumlah, keterangan FROM barang_masuk ORDER BY id_masuk DESC";
        List<BarangMasuk> daftarBarangMasuk = new ArrayList<>();
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                BarangMasuk barangMasuk = new BarangMasuk();
                barangMasuk.setIdMasuk(rs.getInt("id_masuk"));
                barangMasuk.setIdBarang(rs.getInt("id_barang"));
                barangMasuk.setIdUser(rs.getInt("id_user"));
                barangMasuk.setTanggalMasuk(rs.getDate("tanggal_masuk"));
                barangMasuk.setJumlah(rs.getInt("jumlah"));
                barangMasuk.setKeterangan(rs.getString("keterangan"));
                daftarBarangMasuk.add(barangMasuk);
            }
        }
        return daftarBarangMasuk;
    }

}

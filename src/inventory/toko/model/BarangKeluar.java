/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.toko.model;

import java.sql.Date;
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
    public BarangKeluar(int idKeluar, int idBarang,
                        int idUser, Date tanggalKeluar,
                        int jumlah, String keterangan) {

        this.idKeluar = idKeluar;
        this.idBarang = idBarang;
        this.idUser = idUser;
        this.tanggalKeluar = tanggalKeluar;
        this.jumlah = jumlah;
        this.keterangan = keterangan;

    }

    //Getter dan Setter ID Keluar
    public int getIdKeluar() {
        return idKeluar;
    }

    public void setIdKeluar(int idKeluar) {
        this.idKeluar = idKeluar;
    }

    //Getter dan Setter ID Barang
    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    //Getter dan Setter Id User
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    //Getter dan Setter tanggal keluar
    public Date getTanggalKeluar() {
        return tanggalKeluar;
    }

    public void setTanggalKeluar(Date tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }

    //Getter dan Setter jumlah
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
        String sql = "INSERT INTO barang_keluar (id_barang, id_user, tanggal_keluar, jumlah, keterangan) VALUES (?, ?, ?, ?, ?)";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idBarang);
            pst.setInt(2, idUser);
            pst.setDate(3, tanggalKeluar);
            pst.setInt(4, jumlah);
            pst.setString(5, keterangan);
            pst.executeUpdate();
        }
    }

    public void update() throws SQLException {
        String sql = "UPDATE barang_keluar SET id_barang = ?, id_user = ?, tanggal_keluar = ?, jumlah = ?, keterangan = ? WHERE id_keluar = ?";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idBarang);
            pst.setInt(2, idUser);
            pst.setDate(3, tanggalKeluar);
            pst.setInt(4, jumlah);
            pst.setString(5, keterangan);
            pst.setInt(6, idKeluar);
            pst.executeUpdate();
        }
    }

    public void delete() throws SQLException {
        String sql = "DELETE FROM barang_keluar WHERE id_keluar = ?";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idKeluar);
            pst.executeUpdate();
        }
    }

    public static List<BarangKeluar> list() throws SQLException {
        String sql = "SELECT id_keluar, id_barang, id_user, tanggal_keluar, jumlah, keterangan FROM barang_keluar ORDER BY id_keluar DESC";
        List<BarangKeluar> daftarBarangKeluar = new ArrayList<>();
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                BarangKeluar barangKeluar = new BarangKeluar();
                barangKeluar.setIdKeluar(rs.getInt("id_keluar"));
                barangKeluar.setIdBarang(rs.getInt("id_barang"));
                barangKeluar.setIdUser(rs.getInt("id_user"));
                barangKeluar.setTanggalKeluar(rs.getDate("tanggal_keluar"));
                barangKeluar.setJumlah(rs.getInt("jumlah"));
                barangKeluar.setKeterangan(rs.getString("keterangan"));
                daftarBarangKeluar.add(barangKeluar);
            }
        }
        return daftarBarangKeluar;
    }


}       




    

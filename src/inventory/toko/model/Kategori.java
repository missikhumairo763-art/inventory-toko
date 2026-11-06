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

    public void create() throws SQLException {
        String sql = "INSERT INTO kategori (nama_kategori, keterangan) VALUES (?, ?)";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, namaKategori);
            pst.setString(2, keterangan);
            pst.executeUpdate();
        }
    }

    public void update() throws SQLException {
        String sql = "UPDATE kategori SET nama_kategori = ?, keterangan = ? WHERE id_kategori = ?";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, namaKategori);
            pst.setString(2, keterangan);
            pst.setInt(3, idKategori);
            pst.executeUpdate();
        }
    }

    public void delete() throws SQLException {
        String sql = "DELETE FROM kategori WHERE id_kategori = ?";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idKategori);
            pst.executeUpdate();
        }
    }

    public static List<Kategori> list() throws SQLException {
        String sql = "SELECT id_kategori, nama_kategori, keterangan FROM kategori ORDER BY id_kategori DESC";
        List<Kategori> daftarKategori = new ArrayList<>();
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Kategori kategori = new Kategori();
                kategori.setIdKategori(rs.getInt("id_kategori"));
                kategori.setNamaKategori(rs.getString("nama_kategori"));
                kategori.setKeterangan(rs.getString("keterangan"));
                daftarKategori.add(kategori);
            }
        }
        return daftarKategori;
    }

}

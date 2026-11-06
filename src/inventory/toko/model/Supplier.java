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

public class Supplier {
    private int idSupplier;
    private String namaSupplier;
    private String alamat;
    private String noTelepon;


    //Constructor kosong

    public Supplier() {

    }


    //Constructor dengan parameter
    public Supplier(int idSupplier, String namaSupplier,
                    String alamat, String noTelepon) {

        this.idSupplier = idSupplier;
        this.namaSupplier = namaSupplier;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
    }


    //Getter dan Setter ID Supplier
    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;

    }

    //Getter Setter Nama Supppiler
    public String getNamaSupplier() {
        return namaSupplier;
    }

    public void setNamaSupplier(String namaSupplier) {
        this.namaSupplier = namaSupplier;
    }

    //Getter dan Setter Alamat
    public String getAlamat() {
        return alamat;

    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    //Getter dan Setter noTelepon
    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public void create() throws SQLException {
        String sql = "INSERT INTO supplier (nama_supplier, alamat, no_telepon) VALUES (?, ?, ?)";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, namaSupplier);
            pst.setString(2, alamat);
            pst.setString(3, noTelepon);
            pst.executeUpdate();
        }
    }

    public void update() throws SQLException {
        String sql = "UPDATE supplier SET nama_supplier = ?, alamat = ?, no_telepon = ? WHERE id_supplier = ?";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, namaSupplier);
            pst.setString(2, alamat);
            pst.setString(3, noTelepon);
            pst.setInt(4, idSupplier);
            pst.executeUpdate();
        }
    }

    public void delete() throws SQLException {
        String sql = "DELETE FROM supplier WHERE id_supplier = ?";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idSupplier);
            pst.executeUpdate();
        }
    }

    public static List<Supplier> list() throws SQLException {
        String sql = "SELECT id_supplier, nama_supplier, alamat, no_telepon FROM supplier ORDER BY id_supplier DESC";
        List<Supplier> daftarSupplier = new ArrayList<>();
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Supplier supplier = new Supplier();
                supplier.setIdSupplier(rs.getInt("id_supplier"));
                supplier.setNamaSupplier(rs.getString("nama_supplier"));
                supplier.setAlamat(rs.getString("alamat"));
                supplier.setNoTelepon(rs.getString("no_telepon"));
                daftarSupplier.add(supplier);
            }
        }
        return daftarSupplier;
    }


}

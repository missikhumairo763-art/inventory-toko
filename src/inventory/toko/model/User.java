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
public class User {
    // Atribut
    private int idUser;
    private String username;
    private String password;
    private String namaLengkap;
    private String level;

    // Constructor kosong
    public User() {
    }

    // Constructor dengan parameter
    public User(int idUser, String username, String password,
                String namaLengkap, String level) {

        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.namaLengkap = namaLengkap;
        this.level = level;
    }

    // Getter dan Setter ID User
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    // Getter dan Setter Username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter dan Setter Password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter dan Setter Nama Lengkap
    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    // Getter dan Setter Level
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void create() throws SQLException {
        String sql = "INSERT INTO users (username, password, nama_lengkap, level) VALUES (?, ?, ?, ?)";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, namaLengkap);
            pst.setString(4, level);
            pst.executeUpdate();
        }
    }

    public void update() throws SQLException {
        String sql = "UPDATE users SET username = ?, password = ?, nama_lengkap = ?, level = ? WHERE id_user = ?";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, namaLengkap);
            pst.setString(4, level);
            pst.setInt(5, idUser);
            pst.executeUpdate();
        }
    }

    public void delete() throws SQLException {
        String sql = "DELETE FROM users WHERE id_user = ?";
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idUser);
            pst.executeUpdate();
        }
    }

    public static List<User> list() throws SQLException {
        String sql = "SELECT id_user, username, password, nama_lengkap, level FROM users ORDER BY id_user DESC";
        List<User> daftarUser = new ArrayList<>();
        Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setNamaLengkap(rs.getString("nama_lengkap"));
                user.setLevel(rs.getString("level"));
                daftarUser.add(user);
            }
        }
        return daftarUser;
    }


}

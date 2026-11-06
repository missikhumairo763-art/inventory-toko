/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.toko.model;
import java.sql.Date;

public class Retur {

    private int idRetur;
    private int idBarang;
    private int idUser;
    private Date tanggalRetur;
    private int jumlah;
    private String jenisRetur;
    private String alasan;

    // Constructor kosong
    public Retur() {

    }

    // Constructor dengan parameter
    public Retur(int idRetur, int idBarang, int idUser,
            Date tanggalRetur, int jumlah,
            String jenisRetur, String alasan) {

        this.idRetur = idRetur;
        this.idBarang = idBarang;
        this.idUser = idUser;
        this.tanggalRetur = tanggalRetur;
        this.jumlah = jumlah;
        this.jenisRetur = jenisRetur;
        this.alasan = alasan;
    }

    // Getter dan Setter ID Retur
    public int getIdRetur() {
        return idRetur;
    }

    public void setIdRetur(int idRetur) {
        this.idRetur = idRetur;
    }

    // Getter dan Setter ID Barang
    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    // Getter dan Setter ID User
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    // Getter dan Setter Tanggal Retur
    public Date getTanggalRetur() {
        return tanggalRetur;
    }

    public void setTanggalRetur(Date tanggalRetur) {
        this.tanggalRetur = tanggalRetur;
    }

    // Getter dan Setter Jumlah
    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    // Getter dan Setter Jenis Retur
    public String getJenisRetur() {
        return jenisRetur;
    }

    public void setJenisRetur(String jenisRetur) {
        this.jenisRetur = jenisRetur;
    }

    // Getter dan Setter Alasan
    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

}



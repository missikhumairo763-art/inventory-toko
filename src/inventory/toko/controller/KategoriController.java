package inventory.toko.controller;

import inventory.toko.model.Kategori;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class KategoriController {

    private final JTable table;
    private final JTextField txtIdKategori;
    private final JTextField txtNamaKategori;
    private final JTextField txtKeterangan;

    public KategoriController(
            JTable table,
            JTextField txtIdKategori,
            JTextField txtNamaKategori,
            JTextField txtKeterangan) {
        this.table = table;
        this.txtIdKategori = txtIdKategori;
        this.txtNamaKategori = txtNamaKategori;
        this.txtKeterangan = txtKeterangan;
    }

    public void loadTable() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{
            "ID Kategori", "Nama Kategori", "Keterangan"
        }, 0);

        try {
            List<Kategori> daftar = Kategori.list();
            for (Kategori kategori : daftar) {
                model.addRow(new Object[]{
                    kategori.getIdKategori(),
                    kategori.getNamaKategori(),
                    kategori.getKeterangan()
                });
            }
            table.setModel(model);
        } catch (SQLException e) {
            showError("Gagal memuat data kategori", e);
        }
    }

    public void save() {
        try {
            Kategori kategori = new Kategori();
            kategori.setNamaKategori(txtNamaKategori.getText().trim());
            kategori.setKeterangan(txtKeterangan.getText().trim());
            kategori.create();
            loadTable();
            resetForm();
            JOptionPane.showMessageDialog(table, "Data kategori berhasil disimpan.");
        } catch (Exception e) {
            showError("Gagal menyimpan data kategori", e);
        }
    }

    public void update() {
        try {
            Kategori kategori = new Kategori();
            kategori.setIdKategori(parseInt(txtIdKategori, "ID Kategori"));
            kategori.setNamaKategori(txtNamaKategori.getText().trim());
            kategori.setKeterangan(txtKeterangan.getText().trim());
            kategori.update();
            loadTable();
            resetForm();
            JOptionPane.showMessageDialog(table, "Data kategori berhasil diubah.");
        } catch (Exception e) {
            showError("Gagal mengubah data kategori", e);
        }
    }

    public void delete() {
        try {
            Kategori kategori = new Kategori();
            kategori.setIdKategori(parseInt(txtIdKategori, "ID Kategori"));
            kategori.delete();
            loadTable();
            resetForm();
            JOptionPane.showMessageDialog(table, "Data kategori berhasil dihapus.");
        } catch (Exception e) {
            showError("Gagal menghapus data kategori", e);
        }
    }

    public void fillFormFromTable(int selectedRow) {
        if (selectedRow < 0) {
            return;
        }

        txtIdKategori.setText(String.valueOf(table.getValueAt(selectedRow, 0)));
        txtNamaKategori.setText(String.valueOf(table.getValueAt(selectedRow, 1)));
        txtKeterangan.setText(String.valueOf(table.getValueAt(selectedRow, 2)));
    }

    public void resetForm() {
        txtIdKategori.setText("");
        txtNamaKategori.setText("");
        txtKeterangan.setText("");
    }

    private int parseInt(JTextField field, String name) {
        String value = field.getText().trim();
        if (value.isEmpty()) {
            throw new IllegalArgumentException(name + " tidak boleh kosong.");
        }
        return Integer.parseInt(value);
    }

    private void showError(String title, Exception e) {
        JOptionPane.showMessageDialog(table, title + ": " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


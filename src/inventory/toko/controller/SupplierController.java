package inventory.toko.controller;

import inventory.toko.model.Supplier;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SupplierController {

    private final JTable table;
    private final JTextField txtIdSupplier;
    private final JTextField txtNamaSupplier;
    private final JTextField txtAlamat;
    private final JTextField txtNoTelepon;

    public SupplierController(
            JTable table,
            JTextField txtIdSupplier,
            JTextField txtNamaSupplier,
            JTextField txtAlamat,
            JTextField txtNoTelepon) {
        this.table = table;
        this.txtIdSupplier = txtIdSupplier;
        this.txtNamaSupplier = txtNamaSupplier;
        this.txtAlamat = txtAlamat;
        this.txtNoTelepon = txtNoTelepon;
    }

    public void loadTable() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{
            "ID Supplier", "Nama Supplier", "Alamat", "No Telepon"
        }, 0);

        try {
            List<Supplier> daftar = Supplier.list();
            for (Supplier supplier : daftar) {
                model.addRow(new Object[]{
                    supplier.getIdSupplier(),
                    supplier.getNamaSupplier(),
                    supplier.getAlamat(),
                    supplier.getNoTelepon()
                });
            }
            table.setModel(model);
        } catch (SQLException e) {
            showError("Gagal memuat data supplier", e);
        }
    }

    public void save() {
        try {
            Supplier supplier = new Supplier();
            supplier.setNamaSupplier(txtNamaSupplier.getText().trim());
            supplier.setAlamat(txtAlamat.getText().trim());
            supplier.setNoTelepon(txtNoTelepon.getText().trim());
            supplier.create();
            loadTable();
            resetForm();
            JOptionPane.showMessageDialog(table, "Data supplier berhasil disimpan.");
        } catch (Exception e) {
            showError("Gagal menyimpan data supplier", e);
        }
    }

    public void update() {
        try {
            Supplier supplier = new Supplier();
            supplier.setIdSupplier(parseInt(txtIdSupplier, "ID Supplier"));
            supplier.setNamaSupplier(txtNamaSupplier.getText().trim());
            supplier.setAlamat(txtAlamat.getText().trim());
            supplier.setNoTelepon(txtNoTelepon.getText().trim());
            supplier.update();
            loadTable();
            resetForm();
            JOptionPane.showMessageDialog(table, "Data supplier berhasil diubah.");
        } catch (Exception e) {
            showError("Gagal mengubah data supplier", e);
        }
    }

    public void delete() {
        try {
            Supplier supplier = new Supplier();
            supplier.setIdSupplier(parseInt(txtIdSupplier, "ID Supplier"));
            supplier.delete();
            loadTable();
            resetForm();
            JOptionPane.showMessageDialog(table, "Data supplier berhasil dihapus.");
        } catch (Exception e) {
            showError("Gagal menghapus data supplier", e);
        }
    }

    public void fillFormFromTable(int selectedRow) {
        if (selectedRow < 0) {
            return;
        }

        txtIdSupplier.setText(String.valueOf(table.getValueAt(selectedRow, 0)));
        txtNamaSupplier.setText(String.valueOf(table.getValueAt(selectedRow, 1)));
        txtAlamat.setText(String.valueOf(table.getValueAt(selectedRow, 2)));
        txtNoTelepon.setText(String.valueOf(table.getValueAt(selectedRow, 3)));
    }

    public void resetForm() {
        txtIdSupplier.setText("");
        txtNamaSupplier.setText("");
        txtAlamat.setText("");
        txtNoTelepon.setText("");
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


package inventory.toko.controller;

import inventory.toko.model.User;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UserController {

    private final JTable table;
    private final JTextField txtIdUser;
    private final JTextField txtUsername;
    private final JTextField txtPassword;
    private final JTextField txtNamaLengkap;
    private final JTextField txtLevel;

    public UserController(
            JTable table,
            JTextField txtIdUser,
            JTextField txtUsername,
            JTextField txtPassword,
            JTextField txtNamaLengkap,
            JTextField txtLevel) {
        this.table = table;
        this.txtIdUser = txtIdUser;
        this.txtUsername = txtUsername;
        this.txtPassword = txtPassword;
        this.txtNamaLengkap = txtNamaLengkap;
        this.txtLevel = txtLevel;
    }

    public void loadTable() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{
            "ID User", "Username", "Password", "Nama Lengkap", "Level"
        }, 0);

        try {
            List<User> daftar = User.list();
            for (User user : daftar) {
                model.addRow(new Object[]{
                    user.getIdUser(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getNamaLengkap(),
                    user.getLevel()
                });
            }
            table.setModel(model);
        } catch (SQLException e) {
            showError("Gagal memuat data user", e);
        }
    }

    public void save() {
        try {
            User user = new User();
            user.setUsername(txtUsername.getText().trim());
            user.setPassword(txtPassword.getText().trim());
            user.setNamaLengkap(txtNamaLengkap.getText().trim());
            user.setLevel(txtLevel.getText().trim());
            user.create();
            loadTable();
            resetForm();
            JOptionPane.showMessageDialog(table, "Data user berhasil disimpan.");
        } catch (Exception e) {
            showError("Gagal menyimpan data user", e);
        }
    }

    public void update() {
        try {
            User user = new User();
            user.setIdUser(parseInt(txtIdUser, "ID User"));
            user.setUsername(txtUsername.getText().trim());
            user.setPassword(txtPassword.getText().trim());
            user.setNamaLengkap(txtNamaLengkap.getText().trim());
            user.setLevel(txtLevel.getText().trim());
            user.update();
            loadTable();
            resetForm();
            JOptionPane.showMessageDialog(table, "Data user berhasil diubah.");
        } catch (Exception e) {
            showError("Gagal mengubah data user", e);
        }
    }

    public void delete() {
        try {
            User user = new User();
            user.setIdUser(parseInt(txtIdUser, "ID User"));
            user.delete();
            loadTable();
            resetForm();
            JOptionPane.showMessageDialog(table, "Data user berhasil dihapus.");
        } catch (Exception e) {
            showError("Gagal menghapus data user", e);
        }
    }

    public void fillFormFromTable(int selectedRow) {
        if (selectedRow < 0) {
            return;
        }

        txtIdUser.setText(String.valueOf(table.getValueAt(selectedRow, 0)));
        txtUsername.setText(String.valueOf(table.getValueAt(selectedRow, 1)));
        txtPassword.setText(String.valueOf(table.getValueAt(selectedRow, 2)));
        txtNamaLengkap.setText(String.valueOf(table.getValueAt(selectedRow, 3)));
        txtLevel.setText(String.valueOf(table.getValueAt(selectedRow, 4)));
    }

    public void resetForm() {
        txtIdUser.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txtNamaLengkap.setText("");
        txtLevel.setText("");
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


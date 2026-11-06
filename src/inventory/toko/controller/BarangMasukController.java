package inventory.toko.controller;

import inventory.toko.model.BarangMasuk;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BarangMasukController {

	private final JTable table;
	private final JTextField txtIdMasuk;
	private final JTextField txtIdBarang;
	private final JTextField txtIdUser;
	private final JTextField txtTanggalMasuk;
	private final JTextField txtJumlah;
	private final JTextField txtKeterangan;

	public BarangMasukController(
			JTable table,
			JTextField txtIdMasuk,
			JTextField txtIdBarang,
			JTextField txtIdUser,
			JTextField txtTanggalMasuk,
			JTextField txtJumlah,
			JTextField txtKeterangan) {
		this.table = table;
		this.txtIdMasuk = txtIdMasuk;
		this.txtIdBarang = txtIdBarang;
		this.txtIdUser = txtIdUser;
		this.txtTanggalMasuk = txtTanggalMasuk;
		this.txtJumlah = txtJumlah;
		this.txtKeterangan = txtKeterangan;
	}

	public void loadTable() {
		DefaultTableModel model = new DefaultTableModel(new Object[]{
			"ID Masuk", "ID Barang", "ID User", "Tanggal Masuk", "Jumlah", "Keterangan"
		}, 0);

		try {
			List<BarangMasuk> daftar = BarangMasuk.list();
			for (BarangMasuk data : daftar) {
				model.addRow(new Object[]{
					data.getIdMasuk(),
					data.getIdBarang(),
					data.getIdUser(),
					data.getTanggalMasuk(),
					data.getJumlah(),
					data.getKeterangan()
				});
			}
			table.setModel(model);
		} catch (SQLException e) {
			showError("Gagal memuat data barang masuk", e);
		}
	}

	public void save() {
		try {
			BarangMasuk data = readForm();
			data.create();
			loadTable();
			resetForm();
			JOptionPane.showMessageDialog(table, "Data barang masuk berhasil disimpan.");
		} catch (Exception e) {
			showError("Gagal menyimpan data barang masuk", e);
		}
	}

	public void update() {
		try {
			BarangMasuk data = readForm();
			data.setIdMasuk(parseInt(txtIdMasuk, "ID Masuk"));
			data.update();
			loadTable();
			resetForm();
			JOptionPane.showMessageDialog(table, "Data barang masuk berhasil diubah.");
		} catch (Exception e) {
			showError("Gagal mengubah data barang masuk", e);
		}
	}

	public void delete() {
		try {
			BarangMasuk data = new BarangMasuk();
			data.setIdMasuk(parseInt(txtIdMasuk, "ID Masuk"));
			data.delete();
			loadTable();
			resetForm();
			JOptionPane.showMessageDialog(table, "Data barang masuk berhasil dihapus.");
		} catch (Exception e) {
			showError("Gagal menghapus data barang masuk", e);
		}
	}

	public void fillFormFromTable(int selectedRow) {
		if (selectedRow < 0) {
			return;
		}

		txtIdMasuk.setText(String.valueOf(table.getValueAt(selectedRow, 0)));
		txtIdBarang.setText(String.valueOf(table.getValueAt(selectedRow, 1)));
		txtIdUser.setText(String.valueOf(table.getValueAt(selectedRow, 2)));
		txtTanggalMasuk.setText(String.valueOf(table.getValueAt(selectedRow, 3)));
		txtJumlah.setText(String.valueOf(table.getValueAt(selectedRow, 4)));
		txtKeterangan.setText(String.valueOf(table.getValueAt(selectedRow, 5)));
	}

	public void resetForm() {
		txtIdMasuk.setText("");
		txtIdBarang.setText("");
		txtIdUser.setText("");
		txtTanggalMasuk.setText("");
		txtJumlah.setText("");
		txtKeterangan.setText("");
	}

	private BarangMasuk readForm() {
		BarangMasuk data = new BarangMasuk();
		data.setIdBarang(parseInt(txtIdBarang, "ID Barang"));
		data.setIdUser(parseInt(txtIdUser, "ID User"));
		data.setTanggalMasuk(parseDate(txtTanggalMasuk, "Tanggal Masuk (yyyy-mm-dd)"));
		data.setJumlah(parseInt(txtJumlah, "Jumlah"));
		data.setKeterangan(txtKeterangan.getText().trim());
		return data;
	}

	private int parseInt(JTextField field, String name) {
		String value = field.getText().trim();
		if (value.isEmpty()) {
			throw new IllegalArgumentException(name + " tidak boleh kosong.");
		}
		return Integer.parseInt(value);
	}

	private Date parseDate(JTextField field, String name) {
		String value = field.getText().trim();
		if (value.isEmpty()) {
			throw new IllegalArgumentException(name + " tidak boleh kosong.");
		}
		return Date.valueOf(value);
	}

	private void showError(String title, Exception e) {
		JOptionPane.showMessageDialog(table, title + ": " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}
}

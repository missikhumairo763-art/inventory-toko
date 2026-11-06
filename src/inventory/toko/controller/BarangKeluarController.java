package inventory.toko.controller;

import inventory.toko.model.BarangKeluar;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BarangKeluarController {

	private final JTable table;
	private final JTextField txtIdKeluar;
	private final JTextField txtIdBarang;
	private final JTextField txtIdUser;
	private final JTextField txtTanggalKeluar;
	private final JTextField txtJumlah;
	private final JTextField txtKeterangan;

	public BarangKeluarController(
			JTable table,
			JTextField txtIdKeluar,
			JTextField txtIdBarang,
			JTextField txtIdUser,
			JTextField txtTanggalKeluar,
			JTextField txtJumlah,
			JTextField txtKeterangan) {
		this.table = table;
		this.txtIdKeluar = txtIdKeluar;
		this.txtIdBarang = txtIdBarang;
		this.txtIdUser = txtIdUser;
		this.txtTanggalKeluar = txtTanggalKeluar;
		this.txtJumlah = txtJumlah;
		this.txtKeterangan = txtKeterangan;
	}

	public void loadTable() {
		DefaultTableModel model = new DefaultTableModel(new Object[]{
			"ID Keluar", "ID Barang", "ID User", "Tanggal Keluar", "Jumlah", "Keterangan"
		}, 0);

		try {
			List<BarangKeluar> daftar = BarangKeluar.list();
			for (BarangKeluar data : daftar) {
				model.addRow(new Object[]{
					data.getIdKeluar(),
					data.getIdBarang(),
					data.getIdUser(),
					data.getTanggalKeluar(),
					data.getJumlah(),
					data.getKeterangan()
				});
			}
			table.setModel(model);
		} catch (SQLException e) {
			showError("Gagal memuat data barang keluar", e);
		}
	}

	public void save() {
		try {
			BarangKeluar data = readForm();
			data.create();
			loadTable();
			resetForm();
			JOptionPane.showMessageDialog(table, "Data barang keluar berhasil disimpan.");
		} catch (Exception e) {
			showError("Gagal menyimpan data barang keluar", e);
		}
	}

	public void update() {
		try {
			BarangKeluar data = readForm();
			data.setIdKeluar(parseInt(txtIdKeluar, "ID Keluar"));
			data.update();
			loadTable();
			resetForm();
			JOptionPane.showMessageDialog(table, "Data barang keluar berhasil diubah.");
		} catch (Exception e) {
			showError("Gagal mengubah data barang keluar", e);
		}
	}

	public void delete() {
		try {
			BarangKeluar data = new BarangKeluar();
			data.setIdKeluar(parseInt(txtIdKeluar, "ID Keluar"));
			data.delete();
			loadTable();
			resetForm();
			JOptionPane.showMessageDialog(table, "Data barang keluar berhasil dihapus.");
		} catch (Exception e) {
			showError("Gagal menghapus data barang keluar", e);
		}
	}

	public void fillFormFromTable(int selectedRow) {
		if (selectedRow < 0) {
			return;
		}

		txtIdKeluar.setText(String.valueOf(table.getValueAt(selectedRow, 0)));
		txtIdBarang.setText(String.valueOf(table.getValueAt(selectedRow, 1)));
		txtIdUser.setText(String.valueOf(table.getValueAt(selectedRow, 2)));
		txtTanggalKeluar.setText(String.valueOf(table.getValueAt(selectedRow, 3)));
		txtJumlah.setText(String.valueOf(table.getValueAt(selectedRow, 4)));
		txtKeterangan.setText(String.valueOf(table.getValueAt(selectedRow, 5)));
	}

	public void resetForm() {
		txtIdKeluar.setText("");
		txtIdBarang.setText("");
		txtIdUser.setText("");
		txtTanggalKeluar.setText("");
		txtJumlah.setText("");
		txtKeterangan.setText("");
	}

	private BarangKeluar readForm() {
		BarangKeluar data = new BarangKeluar();
		data.setIdBarang(parseInt(txtIdBarang, "ID Barang"));
		data.setIdUser(parseInt(txtIdUser, "ID User"));
		data.setTanggalKeluar(parseDate(txtTanggalKeluar, "Tanggal Keluar (yyyy-mm-dd)"));
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

package inventory.toko.controller;

import inventory.toko.model.Barang;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BarangController {

	private final JTable table;
	private final JTextField txtIdBarang;
	private final JTextField txtKodeBarang;
	private final JTextField txtNamaBarang;
	private final JTextField txtIdKategori;
	private final JTextField txtIdSupplier;
	private final JTextField txtHargaBeli;
	private final JTextField txtHargaJual;
	private final JTextField txtStok;
	private final JTextField txtSatuan;

	public BarangController(
			JTable table,
			JTextField txtIdBarang,
			JTextField txtKodeBarang,
			JTextField txtNamaBarang,
			JTextField txtIdKategori,
			JTextField txtIdSupplier,
			JTextField txtHargaBeli,
			JTextField txtHargaJual,
			JTextField txtStok,
			JTextField txtSatuan) {
		this.table = table;
		this.txtIdBarang = txtIdBarang;
		this.txtKodeBarang = txtKodeBarang;
		this.txtNamaBarang = txtNamaBarang;
		this.txtIdKategori = txtIdKategori;
		this.txtIdSupplier = txtIdSupplier;
		this.txtHargaBeli = txtHargaBeli;
		this.txtHargaJual = txtHargaJual;
		this.txtStok = txtStok;
		this.txtSatuan = txtSatuan;
	}

	public void loadTable() {
		DefaultTableModel model = new DefaultTableModel(new Object[]{
			"ID", "Kode", "Nama", "ID Kategori", "ID Supplier", "Harga Beli", "Harga Jual", "Stok", "Satuan"
		}, 0);

		try {
			List<Barang> daftar = Barang.list();
			for (Barang barang : daftar) {
				model.addRow(new Object[]{
					barang.getIdBarang(),
					barang.getKodeBarang(),
					barang.getNamaBarang(),
					barang.getIdKategori(),
					barang.getIdSupplier(),
					barang.getHargaBeli(),
					barang.getHargaJual(),
					barang.getStok(),
					barang.getSatuan()
				});
			}
			table.setModel(model);
		} catch (SQLException e) {
			showError("Gagal memuat data barang", e);
		}
	}

	public void save() {
		try {
			Barang barang = readForm();
			barang.create();
			loadTable();
			resetForm();
			JOptionPane.showMessageDialog(table, "Data barang berhasil disimpan.");
		} catch (Exception e) {
			showError("Gagal menyimpan data barang", e);
		}
	}

	public void update() {
		try {
			Barang barang = readForm();
			barang.setIdBarang(parseInt(txtIdBarang, "ID Barang"));
			barang.update();
			loadTable();
			resetForm();
			JOptionPane.showMessageDialog(table, "Data barang berhasil diubah.");
		} catch (Exception e) {
			showError("Gagal mengubah data barang", e);
		}
	}

	public void delete() {
		try {
			Barang barang = new Barang();
			barang.setIdBarang(parseInt(txtIdBarang, "ID Barang"));
			barang.delete();
			loadTable();
			resetForm();
			JOptionPane.showMessageDialog(table, "Data barang berhasil dihapus.");
		} catch (Exception e) {
			showError("Gagal menghapus data barang", e);
		}
	}

	public void fillFormFromTable(int selectedRow) {
		if (selectedRow < 0) {
			return;
		}

		txtIdBarang.setText(String.valueOf(table.getValueAt(selectedRow, 0)));
		txtKodeBarang.setText(String.valueOf(table.getValueAt(selectedRow, 1)));
		txtNamaBarang.setText(String.valueOf(table.getValueAt(selectedRow, 2)));
		txtIdKategori.setText(String.valueOf(table.getValueAt(selectedRow, 3)));
		txtIdSupplier.setText(String.valueOf(table.getValueAt(selectedRow, 4)));
		txtHargaBeli.setText(String.valueOf(table.getValueAt(selectedRow, 5)));
		txtHargaJual.setText(String.valueOf(table.getValueAt(selectedRow, 6)));
		txtStok.setText(String.valueOf(table.getValueAt(selectedRow, 7)));
		txtSatuan.setText(String.valueOf(table.getValueAt(selectedRow, 8)));
	}

	public void resetForm() {
		txtIdBarang.setText("");
		txtKodeBarang.setText("");
		txtNamaBarang.setText("");
		txtIdKategori.setText("");
		txtIdSupplier.setText("");
		txtHargaBeli.setText("");
		txtHargaJual.setText("");
		txtStok.setText("");
		txtSatuan.setText("");
	}

	private Barang readForm() {
		Barang barang = new Barang();
		barang.setKodeBarang(txtKodeBarang.getText().trim());
		barang.setNamaBarang(txtNamaBarang.getText().trim());
		barang.setIdKategori(parseInt(txtIdKategori, "ID Kategori"));
		barang.setIdSupplier(parseInt(txtIdSupplier, "ID Supplier"));
		barang.setHargaBeli(parseDouble(txtHargaBeli, "Harga Beli"));
		barang.setHargaJual(parseDouble(txtHargaJual, "Harga Jual"));
		barang.setStok(parseInt(txtStok, "Stok"));
		barang.setSatuan(txtSatuan.getText().trim());
		return barang;
	}

	private int parseInt(JTextField field, String name) {
		String value = field.getText().trim();
		if (value.isEmpty()) {
			throw new IllegalArgumentException(name + " tidak boleh kosong.");
		}
		return Integer.parseInt(value);
	}

	private double parseDouble(JTextField field, String name) {
		String value = field.getText().trim();
		if (value.isEmpty()) {
			throw new IllegalArgumentException(name + " tidak boleh kosong.");
		}
		return Double.parseDouble(value);
	}

	private void showError(String title, Exception e) {
		JOptionPane.showMessageDialog(table, title + ": " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}
}

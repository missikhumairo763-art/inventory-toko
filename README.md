# Inventory Toko

Panduan ini fokus untuk kebutuhan development aplikasi Java Swing `inventory-toko`.

## Berkas yang disertakan

- SQL database: `mysql/inventary-toko.sql`
- JDBC driver MySQL (JAR): `mysql/mysql-connector-j-26.7.0.jar`

## Teknologi

- Java desktop: `javax.swing`
- Database: MySQL / MariaDB
- Build tool: Ant (project style NetBeans)

## Prasyarat

- JDK terpasang (sesuai konfigurasi project saat ini)
- MySQL atau MariaDB aktif
- NetBeans (disarankan, karena project sudah format NetBeans)

## 1) Setup database dari SQL

1. Buat database baru (disarankan nama: `inventory-toko` agar cocok dengan kode Java).
2. Import file SQL `mysql/inventary-toko.sql`.

Contoh via terminal:

```powershell
mysql -u root -p -e "CREATE DATABASE IF NOT EXISTS `inventory-toko`;"
mysql -u root -p "inventory-toko" < "mysql/inventary-toko.sql"
```

Catatan penting:

- Di dump SQL tertulis nama database `inventary-toko`.
- Di kode koneksi (`src/inventory/toko/model/Koneksi.java`) URL yang dipakai adalah:
  `jdbc:mysql://localhost:3306/inventory-toko`
- Kalau mau pakai nama `inventary-toko`, ubah URL di `Koneksi.java` agar sama.

## 2) Setup JDBC JAR MySQL

JAR sudah tersedia di repo: `mysql/mysql-connector-j-26.7.0.jar`.

### Opsi A (disarankan) - lewat NetBeans

1. Klik kanan project -> **Properties**.
2. Masuk ke **Libraries**.
3. **Add JAR/Folder**.
4. Pilih `mysql/mysql-connector-j-26.7.0.jar`.

### Opsi B - edit `nbproject/project.properties`

Project saat ini masih mengarah ke path lokal lama:

- `file.reference.mysql-connector-j-8.0.31.jar=D:\\JAR\\mysql-connector-j-8.0.31.jar`

Ubah agar menunjuk ke JAR di repo, misalnya:

```properties
file.reference.mysql-connector-j-8.0.31.jar=mysql/mysql-connector-j-26.7.0.jar
```

## 3) Konfigurasi koneksi database

Cek file `src/inventory/toko/model/Koneksi.java`:

- URL: `jdbc:mysql://localhost:3306/inventory-toko`
- Username: `root`
- Password: `` (kosong)

Sesuaikan username/password jika environment local berbeda.

## 4) Menjalankan project

### Lewat NetBeans

1. Buka folder project.
2. Pastikan library JAR sudah terpasang.
3. Run project.

Main class project: `inventory.toko.InventoryToko`.

### Lewat Ant (jika terpasang)

```powershell
ant clean
ant run
```

## Struktur folder penting

- `src/inventory/toko/model` -> model + akses DB (CRUD)
- `src/inventory/toko/controller` -> controller Swing
- `mysql/inventary-toko.sql` -> schema dan struktur tabel
- `mysql/mysql-connector-j-26.7.0.jar` -> JDBC driver MySQL
- `nbproject/` -> konfigurasi project NetBeans/Ant

## Troubleshooting singkat

- Error `Communications link failure`:
  - pastikan MySQL hidup
  - host/port di `Koneksi.java` benar
- Error `Unknown database`:
  - database belum dibuat, atau nama database tidak sama
- Error `No suitable driver` / `com.mysql.cj.jdbc.Driver`:
  - JAR JDBC belum masuk classpath
- Error foreign key saat insert:
  - data master (`kategori`, `supplier`, `users`, `barang`) harus ada lebih dulu

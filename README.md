# Minpro-3-PBO-LostnFound

「-------------------------
| Nama : Harits           |
| NIM  : 2509116048       |
-------------------------」

## Deskripsi Singkat Program

**LostnFound** merupakan aplikasi berbasis **CLI (Command Line Interface)** yang dibuat menggunakan bahasa pemrograman Java untuk membantu mengelola data barang hilang dan barang yang ditemukan.

Program ini merupakan pengembangan dari Mini Project sebelumnya dengan menerapkan konsep **Pemrograman Berorientasi Objek (PBO)** yang lebih lengkap. Program memiliki beberapa fitur utama, yaitu pengelolaan data barang, pelapor, laporan kehilangan, dan temuan.

Program juga menerapkan beberapa konsep PBO seperti **encapsulation, inheritance, polymorphism, abstraction**, serta **interface** sebagai nilai tambah. Selain itu, program menggunakan struktur **MVC (Model-View-Controller)** agar kode lebih terorganisir dan setiap bagian program memiliki tanggung jawab yang berbeda.

Data selama program berjalan disimpan menggunakan `ArrayList`.

---

## Struktur Package

Struktur package pada program adalah sebagai berikut:

```text
src/main/java
│
├── main
│   └── Main.java
│
├── model
│   ├── Barang.java
│   ├── DataStore.java
│   ├── Pelapor.java
│   ├── PelaporKehilangan.java
│   ├── PelaporPenemu.java
│   ├── Laporan.java
│   └── Temuan.java
│
├── controller
│   └── LnfController.java
│
├── view
│   └── LostFoundView.java
│
└── interfaces
    └── Identifiable.java
```

### Package `main`

Package `main` berisi class `Main.java` yang menjadi titik awal program.

`Main.java` bertugas untuk:

* Membuat objek `DataStore`.
* Membuat objek `LnfController`.
* Memasukkan dummy data.
* Membuat objek `LostFoundView`.
* Menjalankan program melalui method `mulaiProgram()`.

### Package `model`

Package `model` berisi class yang merepresentasikan data atau objek yang digunakan dalam sistem.

Class yang terdapat pada package ini adalah:

* `Barang`
* `Pelapor`
* `PelaporKehilangan`
* `PelaporPenemu`
* `Laporan`
* `Temuan`
* `DataStore`

`DataStore` digunakan sebagai tempat penyimpanan seluruh `ArrayList` yang digunakan oleh program.

### Package `controller`

Package `controller` berisi `LnfController.java`.

Controller ini merupakan satu-satunya controller dalam program dan bertugas menangani proses pengolahan data, seperti:

* Menambah data.
* Mencari data.
* Menghapus data.
* Mengubah status laporan.
* Mengubah status temuan.
* Membuat ID otomatis.
* Mengakses data yang terdapat pada `DataStore`.

Penggunaan satu controller membuat pengelolaan data lebih terpusat.

### Package `view`

Package `view` berisi `LostFoundView.java`.

View bertanggung jawab terhadap interaksi dengan pengguna melalui terminal, seperti:

* Menampilkan menu.
* Menerima input pengguna.
* Menampilkan data.
* Menampilkan pesan berhasil atau gagal.
* Memanggil method yang tersedia pada controller.

### Package `interfaces`

Package `interfaces` berisi interface `Identifiable`.

Interface tersebut memiliki method:

```java
String getId();
```

Interface digunakan untuk memberikan aturan bahwa class yang mengimplementasikannya harus memiliki method `getId()`.

---

## Penjelasan Alur Program

Program dimulai dari class `Main`.

### 1. Inisialisasi Program

Pertama, `Main.java` membuat objek `DataStore` sebagai tempat penyimpanan data.

```java
DataStore data = new DataStore();
```

Kemudian dibuat objek `LnfController` dengan menggunakan `DataStore` tersebut.

```java
LnfController controller =
        new LnfController(data);
```

Setelah controller dibuat, program memasukkan dummy data menggunakan method `isiDummyData()`.

Terakhir, program membuat objek `LostFoundView` dan menjalankan program.

```java
LostFoundView view =
        new LostFoundView(controller);

view.mulaiProgram();
```

---

### 2. Menu Utama

Setelah program dijalankan, pengguna akan mendapatkan menu utama:

```text
======================================
       SISTEM LOST AND FOUND
======================================
1. Kelola Barang
2. Kelola Pelapor
3. Kelola Laporan Kehilangan
4. Kelola Temuan
0. Keluar
======================================
```

Pengguna dapat memilih menu sesuai dengan data yang ingin dikelola.

Program menggunakan perulangan sehingga menu utama akan terus ditampilkan sampai pengguna memilih `0`.

---

### 3. Pengelolaan Barang

Menu Barang digunakan untuk mengelola data barang.

Fitur yang tersedia:

1. Tambah Barang
2. Lihat Barang
3. Cari Barang
4. Hapus Barang

Data barang terdiri dari:

* ID Barang
* Nama Barang
* Kategori
* Warna
* Lokasi

ID barang dibuat secara otomatis oleh controller menggunakan method:

```java
generateIdBarang()
```

Contoh ID yang dihasilkan:

```text
B001
B002
B003
```

Ketika pengguna menambahkan barang, program akan meminta data yang diperlukan kemudian membuat objek `Barang` dan menyimpannya melalui controller.

---

### 4. Pengelolaan Pelapor

Menu Pelapor digunakan untuk mengelola data orang yang melaporkan kehilangan atau menemukan barang.

Fitur yang tersedia:

1. Tambah Pelapor
2. Lihat Pelapor
3. Cari Pelapor
4. Hapus Pelapor

Ketika menambahkan pelapor, pengguna dapat memilih jenis pelapor:

```text
1. Pelapor Kehilangan
2. Pelapor Penemu
```

Jika memilih `Pelapor Kehilangan`, pengguna memasukkan data tambahan berupa NIK.

Jika memilih `Pelapor Penemu`, pengguna memasukkan data tambahan berupa lokasi temuan.

Kedua class tersebut merupakan turunan dari class `Pelapor`.

---

### 5. Pengelolaan Laporan Kehilangan

Menu Laporan digunakan untuk mencatat barang yang hilang.

Fitur yang tersedia:

1. Tambah Laporan
2. Lihat Laporan
3. Cari Laporan
4. Ubah Status Laporan
5. Hapus Laporan

Saat membuat laporan, program akan meminta:

* ID pelapor.
* ID barang.
* Tanggal kehilangan.
* Lokasi kehilangan.
* Keterangan.

Program kemudian membuat objek `Laporan`.

Status laporan dapat dipilih melalui menu:

```text
1. Belum ditemukan
2. Ditemukan
3. Sudah dikembalikan
```

Status tidak dimasukkan secara bebas sehingga pilihan status hanya berasal dari pilihan yang tersedia.

---

### 6. Pengelolaan Temuan

Menu Temuan digunakan untuk mencatat barang yang ditemukan.

Fitur yang tersedia:

1. Tambah Temuan
2. Lihat Temuan
3. Cari Temuan
4. Ubah Status Temuan
5. Hapus Temuan

Saat membuat data temuan, program membutuhkan:

* ID barang.
* Pelapor penemu.
* Lokasi temuan.
* Tanggal temuan.

Pelapor yang digunakan harus merupakan objek `PelaporPenemu`.

Status temuan dapat dipilih melalui menu:

```text
1. Belum diklaim
2. Sudah diklaim
3. Diserahkan
```

---

### 7. Dummy Data

Program menyediakan dummy data yang dimasukkan sebelum menu utama dijalankan.

Dummy data terdiri dari:

#### Data Barang

| ID   | Nama         | Kategori | Warna | Lokasi       |
| ---- | ------------ | -------- | ----- | ------------ |
| B001 | Dompet Kulit | Dompet   | Hitam | Area Parkir  |
| B002 | Kunci Motor  | Kunci    | Hitam | Teras Gedung |

#### Data Pelapor

| ID   | Nama | No. HP       | Jenis              |
| ---- | ---- | ------------ | ------------------ |
| P001 | Andi | 081234567890 | Pelapor Kehilangan |
| P002 | Budi | 081298765432 | Pelapor Penemu     |

#### Data Laporan

| ID   | Pelapor | Barang       | Tanggal    | Lokasi      | Status          |
| ---- | ------- | ------------ | ---------- | ----------- | --------------- |
| L001 | Andi    | Dompet Kulit | 20-09-2026 | Area Parkir | Belum ditemukan |

#### Data Temuan

| ID   | Barang      | Penemu | Lokasi       | Tanggal    | Status        |
| ---- | ----------- | ------ | ------------ | ---------- | ------------- |
| T001 | Kunci Motor | Budi   | Teras Gedung | 21-09-2026 | Belum diklaim |

Dengan adanya dummy data, pengguna dapat langsung mencoba fitur lihat, cari, dan pengelolaan data ketika program pertama kali dijalankan.

---

## Penjelasan Penerapan Encapsulation dan Inheritance

### 1. Encapsulation

Encapsulation diterapkan dengan membatasi akses langsung terhadap atribut objek menggunakan access modifier `private`.

Contohnya pada class `Barang`:

```java
private String idBarang;
private String namaBarang;
private String kategori;
private String warna;
private String lokasi;
```

Atribut tersebut tidak dapat diakses secara langsung dari class lain.

Untuk mengakses dan mengubah data, disediakan getter dan setter.

Contohnya:

```java
public String getNamaBarang() {
    return namaBarang;
}

public void setNamaBarang(String namaBarang) {
    this.namaBarang = namaBarang;
}
```

Dengan demikian, data di dalam objek dapat dikontrol melalui method yang telah disediakan.

**Letak penerapan encapsulation:**

* `Barang.java`
* `Pelapor.java`
* `PelaporKehilangan.java`
* `PelaporPenemu.java`
* `Laporan.java`
* `Temuan.java`
* `DataStore.java`

---

### 2. Inheritance

Inheritance atau pewarisan diterapkan pada class `Pelapor`.

`Pelapor` menjadi superclass yang memiliki dua subclass:

```text
Pelapor
├── PelaporKehilangan
└── PelaporPenemu
```

Class `PelaporKehilangan` menggunakan:

```java
public class PelaporKehilangan extends Pelapor
```

Sedangkan `PelaporPenemu` menggunakan:

```java
public class PelaporPenemu extends Pelapor
```

Dengan inheritance tersebut, kedua subclass dapat menggunakan atribut dan method yang berasal dari `Pelapor`.

Selain data umum seperti ID, nama, dan nomor HP, masing-masing subclass memiliki data khusus.

`PelaporKehilangan` memiliki:

```java
private String nik;
```

Sedangkan `PelaporPenemu` memiliki:

```java
private String lokasiTemuan;
```

**Letak penerapan inheritance:**

* `Pelapor.java` sebagai superclass.
* `PelaporKehilangan.java` sebagai subclass.
* `PelaporPenemu.java` sebagai subclass.

---

## Penjelasan Penerapan Polymorphism dan Abstraction

### 1. Polymorphism

Polymorphism diterapkan melalui **method overriding** pada class `Pelapor`.

Pada class `Pelapor` terdapat abstract method:

```java
public abstract String getJenisPelapor();
```

Method tersebut kemudian diimplementasikan dengan perilaku berbeda pada masing-masing subclass.

Pada `PelaporKehilangan`:

```java
@Override
public String getJenisPelapor() {
    return "Pelapor Kehilangan";
}
```

Pada `PelaporPenemu`:

```java
@Override
public String getJenisPelapor() {
    return "Pelapor Penemu";
}
```

Walaupun method yang digunakan memiliki nama yang sama, hasilnya berbeda berdasarkan objek yang digunakan.

Polymorphism juga terlihat pada:

```java
ArrayList<Pelapor>
```

Karena `ArrayList` tersebut dapat menyimpan objek:

```java
PelaporKehilangan
```

dan:

```java
PelaporPenemu
```

dalam satu tipe referensi `Pelapor`.

**Letak penerapan polymorphism:**

* `Pelapor.java`
* `PelaporKehilangan.java`
* `PelaporPenemu.java`
* `LostFoundView.java`

---

### 2. Abstraction

Abstraction diterapkan dengan menjadikan class `Pelapor` sebagai **abstract class**.

Deklarasinya:

```java
public abstract class Pelapor implements Identifiable
```

Class `Pelapor` digunakan untuk mendefinisikan data dan perilaku umum yang dimiliki oleh semua jenis pelapor.

Selain itu, `Pelapor` memiliki abstract method:

```java
public abstract String getJenisPelapor();
```

Method tersebut tidak memiliki implementasi pada superclass sehingga implementasinya harus diberikan oleh subclass.

Dengan abstraction, class `Pelapor` dapat menjadi dasar bagi beberapa jenis pelapor tanpa harus membuat objek `Pelapor` secara langsung.

**Letak penerapan abstraction:**

```text
model/Pelapor.java
```

Pada class tersebut terdapat:

* `abstract class Pelapor`
* `abstract method getJenisPelapor()`

---

## Penjelasan Letak Penerapan Nilai Tambah

Program menerapkan beberapa nilai tambah yang membuat struktur program lebih terorganisir dan memenuhi konsep PBO yang lebih lengkap.

### 1. Interface

Interface `Identifiable` dibuat pada package `interfaces`.

Isi interface:

```java
public interface Identifiable {

    String getId();
}
```

Interface tersebut digunakan oleh beberapa class:

```text
Identifiable
├── Barang
├── Pelapor
├── Laporan
└── Temuan
```

Contohnya pada class `Barang`:

```java
public class Barang implements Identifiable
```

Dengan adanya interface tersebut, class yang mengimplementasikan `Identifiable` diwajibkan menyediakan method `getId()`.

**Letak penerapan:**

```text
interfaces/Identifiable.java
```

dan implementasinya terdapat pada:

* `Barang.java`
* `Pelapor.java`
* `Laporan.java`
* `Temuan.java`

---

### 2. MVC (Model-View-Controller)

Program juga menerapkan struktur **MVC** sebagai nilai tambah.

Strukturnya adalah:

```text
Model
   ↓
Controller
   ↓
View
```

#### Model

Package `model` bertugas menyimpan representasi data.

```text
model/
├── Barang.java
├── DataStore.java
├── Pelapor.java
├── PelaporKehilangan.java
├── PelaporPenemu.java
├── Laporan.java
└── Temuan.java
```

#### Controller

`LnfController.java` menangani proses pengolahan data.

```text
controller/
└── LnfController.java
```

Controller menangani proses:

* tambah data,
* pencarian data,
* penghapusan data,
* pembuatan ID,
* perubahan status,
* pengambilan data dari `DataStore`.

#### View

`LostFoundView.java` menangani interaksi dengan pengguna.

```text
view/
└── LostFoundView.java
```

View bertugas menampilkan menu dan menerima input dari pengguna.

#### Main

`Main.java` berfungsi sebagai penghubung awal antara Model, Controller, dan View.

```text
main/
└── Main.java
```

Dengan struktur MVC, proses pengelolaan data dan tampilan pengguna tidak semuanya berada di dalam satu class sehingga program menjadi lebih terorganisir.

**Letak penerapan MVC:**

```text
main/Main.java
model/
controller/LnfController.java
view/LostFoundView.java
```

---

### 3. Constructor Overloading

Nilai tambah lainnya adalah penggunaan **constructor overloading**.

Contohnya pada class `Barang` terdapat dua constructor:

```java
public Barang(String idBarang, String namaBarang, String kategori,
              String warna, String lokasi)
```

dan:

```java
public Barang(String idBarang, String namaBarang, String kategori)
```

Constructor kedua menggunakan constructor pertama dengan memberikan nilai default.

Konsep yang sama juga diterapkan pada:

* `PelaporKehilangan`
* `PelaporPenemu`
* `Laporan`
* `Temuan`

**Letak penerapan:**

```text
model/Barang.java
model/PelaporKehilangan.java
model/PelaporPenemu.java
model/Laporan.java
model/Temuan.java
```

---

### 4. Method Overloading

Method overloading juga diterapkan pada `LnfController`.

Terdapat dua method `cariBarang()` dengan parameter yang berbeda.

Pencarian berdasarkan ID:

```java
public Barang cariBarang(String id)
```

dan pencarian berdasarkan nama dan kategori:

```java
public Barang cariBarang(String nama, String kategori)
```

Walaupun memiliki nama method yang sama, parameter yang digunakan berbeda sehingga Java dapat membedakan kedua method tersebut.

**Letak penerapan:**

```text
controller/LnfController.java
```

---

## Kesimpulan

Program **LostnFound** merupakan aplikasi CLI yang menerapkan konsep Pemrograman Berorientasi Objek untuk mengelola data barang hilang dan barang temuan.

Konsep PBO yang diterapkan meliputi:

* Encapsulation
* Inheritance
* Polymorphism
* Abstraction
* Interface
* Constructor Overloading
* Method Overloading
* Relasi antar objek

Selain konsep PBO, program juga menerapkan struktur **MVC (Model-View-Controller)** untuk memisahkan pengelolaan data, proses program, dan interaksi pengguna.

Dengan penerapan tersebut, struktur program menjadi lebih terorganisir, mudah dipahami, dan lebih mudah dikembangkan.

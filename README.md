# Kotlin Model Data, Filter/Sort, dan Validasi Input

## Tujuan Program

Program ini dibuat untuk latihan dasar Kotlin dengan menggunakan data mahasiswa.
Data yang dibuat kemudian divalidasi, difilter, diurutkan, dan ditampilkan ke console.

## Model Data

Saya menggunakan `data class Student` dengan 4 data:

- `name` untuk nama mahasiswa
- `score` untuk nilai
- `active` untuk status aktif mahasiswa
- `email` untuk email mahasiswa, yang dibuat nullable karena tidak semua mahasiswa memiliki email

## Logika Program

Pertama, saya membuat 8 data mahasiswa menggunakan `listOf()`. Setelah itu data dicek terlebih dahulu supaya nama tidak kosong dan nilai masih berada di antara 0 sampai 100.

Data yang sudah valid kemudian difilter untuk mengambil mahasiswa yang masih aktif dan memiliki nilai minimal 70. Hasilnya diurutkan dari nilai paling tinggi menggunakan `sortedByDescending()`, lalu diubah menjadi teks menggunakan `map()`.

Untuk menentukan kategori nilai, saya menggunakan function `category()` dengan `when`. Email yang kosong/null ditangani menggunakan Elvis operator `?:` dan akan menampilkan "email belum tersedia".

## Hasil Tampilan Aplikasi

![Hasil Tampilan Aplikasi](Screenshot%20hasil.png)

## Konsep Kotlin yang Digunakan

- `val` dan `var`
- `data class`
- Function
- `when`
- Nullable dan null safety
- `List`
- `filter`
- `sortedByDescending`
- `map`
- `forEach`
- Lambda

## Catatan

Bagian yang paling bikin saya bingung adalah penggunaan `filter`, `map`, dan `sortedByDescending` karena ketiganya punya fungsi yang berbeda. Saya juga perlu memahami cara menangani email yang nilainya `null`. Setelah dicoba satu-satu, saya jadi lebih paham urutan pengolahan datanya dan cara menggunakan null safety di Kotlin.

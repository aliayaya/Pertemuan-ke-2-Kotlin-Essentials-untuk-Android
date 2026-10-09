package com.example.pb02_kotlinessentials

// Model data mahasiswa menggunakan data class
data class Student(
    val name: String,
    val score: Int,
    val active: Boolean,
    val email: String?
)

// Function untuk menentukan kategori nilai berdasarkan skor menggunakan when
fun category(score: Int): String {
    return when {
        score >= 81 -> "A"
        score >= 70 -> "B"
        score >= 60 -> "C"
        else -> "Perlu perbaikan"
    }
}

// Function validasi sederhana untuk memeriksa apakah data mahasiswa valid
fun isValid(student: Student): Boolean {
    // Validasi: nama tidak boleh kosong dan nilai berada pada rentang 0 - 100
    return student.name.isNotBlank() && (student.score in 0..100)
}

// Function untuk memproses data dan mengembalikan teks terformat
fun getFormattedStudentData(): String {
    // 1. DATA MAHASISWA
    val students: List<Student> = listOf(
        Student("Budi Santoso", 92, true, null),            // active, score >= 70, email null
        Student("Eka Putri", 88, true, "eka@gmail.com"),     // active, score >= 70, email ada
        Student("Andi Pratama", 85, true, "andi@gmail.com"), // active, score >= 70, email ada
        Student("Doni Wijaya", 78, false, "doni@gmail.com"),  // active == false
        Student("Gita Gutawa", 75, true, "gita@gmail.com"),  // active, score >= 70, email ada
        Student("Indra Kusuma", 70, true, null),            // active, score >= 70, email null
        Student("Cici Amalia", 65, true, "cici@yahoo.com"),   // score < 70
        Student("Fajar Nugraha", 50, true, null),           // score < 70, email null
        Student("Hani Fahri", 95, false, "hani@gmail.com"),   // active == false
        Student("Joko Susilo", -10, true, "joko@gmail.com")   // score < 0 (data tidak valid)
    )

    // 2. VALIDASI INPUT/DATA
    val validStudents = students.filter { student ->
        isValid(student)
    }

    // 3. FILTER
    val filteredStudents = validStudents.filter { student ->
        student.active && student.score >= 70
    }

    // 4. SORT
    val sortedStudents = filteredStudents.sortedByDescending { student ->
        student.score
    }

    // 5, 6, 7. TRANSFORM / MAP & NULL SAFETY
    val outputList = sortedStudents.map { student ->
        val kat = category(student.score)
        val displayEmail = student.email ?: "email belum tersedia" // Null Safety & Elvis Operator
        """
        |Nama      : ${student.name}
        |Nilai     : ${student.score}
        |Kategori  : $kat
        |Email     : $displayEmail
        |----------------------------------------
        """.trimMargin()
    }

    val header = """
        |========================================
        |DATA MAHASISWA TERPILIH
        |========================================
        |
    """.trimMargin()

    return header + outputList.joinToString("\n")
}

fun main() {
    println(getFormattedStudentData())
}

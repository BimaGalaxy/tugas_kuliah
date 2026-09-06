public class Mahasiswa {
    String nama;
    String nim;
    String jurusan;
    private double ipk;

    // Constructor untuk membuat object ketika diinisiasi.
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Getter NIM untuk mendapatkan data NIM.
    public String getNim() {
        return nim;
    }

    // Getter setter IPK
    // ===================== 
    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipKBaru) {
        this.ipk = ipKBaru;
    }
    // =====================

    // Method untuk menampilkan informasi mahasiswa.
    public void tampilkanInfo() {
        System.out.println("Nama.     : " + this.nama);
        System.out.println("NIM       : " + this.nim);
        System.out.println("Jurusan   : " + this.jurusan);
        System.out.println("IPK.      : " + this.ipk);
        System.out.println("Status    : " + cekKelulusan());
        System.out.println("Predikat  : " + hitungPredikat());
    }

    // Method untuk mengecek kelulusan mahasiswa berdasarkan IPK.
    public String cekKelulusan() {
        if (this.ipk >= 3.00) {
            return  "Lulus";
        } else if (this.ipk < 3.00) {
            return "Belum lulus";
        } else {
            return  "IPK tidak valid";
        }
    }

    // Method untuk menghitung predikat mahasiswa berdasarkan IPK.
    public String hitungPredikat() {
        if (this.ipk >= 3.75) {
            return "Dengan Pujian";
        } else if (this.ipk >= 3.50 && this.ipk < 3.75) {
            return "Sangat Memuaskan";
        } else if (this.ipk >= 3.00 && this.ipk < 3.50) {
            return "Memuaskan";
        } else if (this.ipk < 3.00) {
            return "Perlu Perbaikan";
        } else {
            return "IPK Tidak Valid";
        }
    }
}
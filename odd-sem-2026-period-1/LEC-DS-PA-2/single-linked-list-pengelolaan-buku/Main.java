import java.util.Scanner;

public class Main {
    static void tambahBuku(Scanner scanner, LinkedList daftarBuku) {
        scanner.nextLine(); // Membersihkan buffer input

        String kodeBuku;
        // Validasi: kodeBuku maksimal 5 karakter
        while (true) {
            System.out.print("Masukkan Kode Buku: ");
            kodeBuku = scanner.nextLine().trim();
            if (kodeBuku.isEmpty()) {
                System.out.println("Kode buku tidak boleh kosong.");
            } else if (kodeBuku.length() > 5) {
                System.out.println("Validasi gagal: Kode buku maksimal 5 karakter!");
            } else {
                break;
            }
        }

        System.out.print("Masukkan Judul: ");
        String judul = scanner.nextLine().trim();

        System.out.print("Masukkan Penulis: ");
        String penulis = scanner.nextLine().trim();

        daftarBuku.tambahBuku(kodeBuku, judul, penulis);
    }

    static void cariBuku(Scanner scanner, LinkedList daftarBuku) {
        scanner.nextLine(); // Membersihkan buffer input

        System.out.print("Masukkan Kode Buku yang dicari: ");
        String kode = scanner.nextLine().trim();

        daftarBuku.cariBuku(kode);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        LinkedList daftarBuku = new LinkedList();

        boolean lanjut = true;

        while (lanjut) {
            System.out.println("\n======== Menu Sistem Data Buku ========");
            System.out.println("1. Tambah Buku"); 
            System.out.println("2. Hapus Buku"); 
            System.out.println("3. Cari Buku"); 
            System.out.println("4. Lihat Semua Buku"); 
            System.out.println("5. Keluar"); 
            System.out.println("==========================================");
            System.out.println("\nMenu yang ingin diakses: ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    tambahBuku(scanner, daftarBuku);
                    break;
                case 2:
                    daftarBuku.hapusBukuTerakhir();
                    break;
                case 3:
                    cariBuku(scanner, daftarBuku);
                    break;
                case 4:
                    daftarBuku.tampilkanSemuaBuku();
                    break;
                case 5:
                    if (daftarBuku.getSize() < 5) {
                        System.out.println("Peringatan: Jumlah buku saat ini (" + daftarBuku.getSize() + ") belum memenuhi syarat pengujian minimal 5 data.");
                        break;
                    }
                    lanjut = false;
                    System.out.println("Terima kasih telah menggunakan sistem ini!");
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang tersedia.");
                    break;
            }
        }

        scanner.close();
    }
}

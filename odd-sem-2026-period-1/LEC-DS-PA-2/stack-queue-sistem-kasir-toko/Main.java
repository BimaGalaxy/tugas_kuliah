import java.util.Scanner;

public class Main {
    static void tambahAntrian(Scanner scanner, Queue antrianToko) {
        scanner.nextLine(); // Membersihkan buffer input

        String nomorAntrian;
        while (true) {
            System.out.print("Masukkan Nomor Antrian: ");
            nomorAntrian = scanner.nextLine().trim();

            if (nomorAntrian.isEmpty()) {
                System.out.println("Nomor antrian tidak boleh kosong.");
            } else if (nomorAntrian.length() > 5) {
                System.out.println("Nomor antrian tidak boleh lebih dari 5 karakter.");
            } else {
                break;
            }
        }

        String namaPelanggan;
        while (true) {
            System.out.print("Masukkan Nama Pelanggan: ");
            namaPelanggan = scanner.nextLine().trim();
            if (namaPelanggan.isEmpty()) {
                System.out.println("Nama pelanggan tidak boleh kosong.");
            } else if (namaPelanggan.length() < 3) {
                System.out.println("Nama pelanggan tidak boleh kurang dari 3 karakter.");
            } else {
                break;
            }
        }

        double totalBelanja = 0;
        while (true) {
            try {
                System.out.print("Masukkan Total Belanja: ");
                totalBelanja = Double.parseDouble(scanner.nextLine().trim());
                if (totalBelanja < 0) {
                    System.out.println("Total belanja tidak boleh negatif.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input total belanja harus berupa angka.");
            }
        }

        antrianToko.enqueue(nomorAntrian, namaPelanggan, totalBelanja);
    }

    static void layaniPelanggan(Queue antrianToko, Stack riwayatTransaksi) {
        Node dilayani = antrianToko.dequeue();
        if (dilayani == null) {
            System.out.println("Tidak ada pelanggan dalam antrian untuk dilayani.");
        } else {
            System.out.println("Melayani pelanggan " + dilayani.nomorAntrian + " (" + dilayani.namaPelanggan + ")");
            riwayatTransaksi.push(dilayani.nomorAntrian, dilayani.namaPelanggan, dilayani.totalBelanja);
            System.out.println("Transaksi disimpan ke riwayat.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue antrianToko = new Queue();
        Stack riwayatTransaksi = new Stack();

        boolean lanjut = true;

        while (lanjut) {
            System.out.println("\n======== Menu Sistem Kasir Toko ========");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.println("==========================================");
            System.out.println("\nMenu yang ingin diakses: ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    tambahAntrian(scanner, antrianToko);
                    break;
                case 2:
                    layaniPelanggan(antrianToko, riwayatTransaksi);
                    break;
                case 3:
                    antrianToko.tampilkanAntrian();
                    break;
                case 4:
                    riwayatTransaksi.tampilkanRiwayat();
                    break;
                case 5:
                    if (antrianToko.getSize() < 5) {
                        System.out.println("Antrian terdapat " + antrianToko.getSize() + " pelanggan (minimal 5 antrian tersisa sebelum keluar).");
                        break;
                    }

                    System.out.println("Terima kasih telah menggunakan sistem kasir toko!");
                    lanjut = false;
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang tersedia.");
                    break;
            }
        }

        scanner.close();
    }
}

import java.util.Scanner;

public class Main {
    // Method untuk melakukan update atribut IPK mahasiswa.
    static void updateIpk(Scanner scanner, Mahasiswa[] daftarMahasiswa) {
        scanner.nextLine();

        Mahasiswa mhsDitemukan = null;
        while (mhsDitemukan == null) {
            System.out.println("\nMasukkan NIM yang ingin diupdate: ");
            String nim = scanner.nextLine();

            for (Mahasiswa mhs : daftarMahasiswa) {
                if (mhs.getNim().equals(nim)) {
                    mhsDitemukan = mhs;
                    break;
                }
            }

            if (mhsDitemukan == null) {
                System.out.println("Mahasiswa tidak ditemukan!");
            }
        }
        
        double ipk = 0;
        boolean validIpkInput = false;
        while (!validIpkInput) {
             System.out.println("\nMasukkan nilai IPK: ");
            /* hasNextDouble() digunakan untuk mengecek apakah input yang dimasukkan adalah nilai double yang valid.
                Karena ketika input yang diberikan bukan double maka program akan error.
            */
            if (scanner.hasNextDouble()) {
                ipk = scanner.nextDouble();

                if (ipk >= 0.00 && ipk <= 4.00) {
                    validIpkInput = true;
                } else {
                    System.out.println("IPK tidak valid! Harus diantara 0.00 hingga 4.00");
                }
            } else {
                System.out.println("Input tidak valid! Masukkan angka (contoh: 3.50)");
                scanner.next();
            }   
        }

        mhsDitemukan.setIpk(ipk);
        System.out.println("Data berhasil diperbarui!");
        System.out.println("\n=== Data Mahasiswa ===");
        mhsDitemukan.tampilkanInfo();
    }

    /* 
        Method untuk menampilkan menu.
        Saya buat terpisah agar menu dapat di loop hingga user memilih untuk keluar dari program,
        dan user dapat memilih menu.
    */
    static void menu(Scanner scanner, Mahasiswa[] daftarMahasiswa) {
        boolean lanjut = true;

        while (lanjut) {
            System.out.println("\n======== Menu ========");
            System.out.println("1. Tampilkan Data Mahasiswa.");
            System.out.println("2. Update IPK Mahasiswa");
            System.out.println("3. Keluar");
            System.out.println("======================");
            System.out.println("\nMenu yang ingin diakses: ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("\n=== Data Mahasiswa ===");
                    for (Mahasiswa mhs : daftarMahasiswa) {
                        mhs.tampilkanInfo();
                        System.out.println(" ");
                    }
                    break;
                case 2:
                    updateIpk(scanner, daftarMahasiswa);
                    break;
                case 3:
                    lanjut = false;
                    System.out.println("Terimakasih!");
                    break;
                default:
                    System.out.println("Invalid Menu!");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        // Inisialisasi scanner untuk menerima input user.
        Scanner scanner = new Scanner(System.in);

        // Pembuatan object mahasiswa bertipe array.
        Mahasiswa[] daftarMahasiswa = new Mahasiswa[5];
        
        daftarMahasiswa[0] = new Mahasiswa("Bima Galaxy", "2902819464", "Computer Science", 3.75);
        daftarMahasiswa[1] = new Mahasiswa("Eka Setiyanto", "29028912829", "Computer Science", 3.90);
        daftarMahasiswa[2] = new Mahasiswa("Adya Sena", "2902832887", "Computer Science", 4.00);
        daftarMahasiswa[3] = new Mahasiswa("Rizki Budi", "290870651", "Computer Science", 3.87);
        daftarMahasiswa[4] = new Mahasiswa("Syarofi Yahya", "290278391", "Computer Science", 3.80);

        menu(scanner, daftarMahasiswa);
        
        scanner.close();
    }
}

    
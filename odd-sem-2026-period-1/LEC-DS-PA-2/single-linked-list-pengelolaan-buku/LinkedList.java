public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Mengembalikan jumlah buku saat ini
    public int getSize() {
        return size;
    }

    // Memeriksa apakah daftar kosong
    public boolean isEmpty() {
        return head == null;
    }

    // Tambah Buku di akhir daftar (Push ke tail)
    public void tambahBuku(String kodeBuku, String judul, String penulis) {
        Node newNode = new Node(kodeBuku, judul, penulis);

        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("\nData berhasil ditambahkan!");
    }

    // Hapus Buku terakhir (Pop dari tail)
    public void hapusBukuTerakhir() {
        if (isEmpty()) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }

        // Jika hanya ada satu node di dalam linked list
        if (head.next == null) {
            System.out.println("Buku dengan kode " + head.kodeBuku + " berhasil dihapus.");
            head = null;
        } else {
            // Traversal ke node sebelum node terakhir
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            System.out.println("Buku dengan kode " + current.next.kodeBuku + " berhasil dihapus.");
            current.next = null;
        }
        size--;
    }

    //Cari buku berdasarkan kodeBuku
    public void cariBuku(String kodeBuku) {
        if (isEmpty()) {
            System.out.println("Buku tidak ditemukan.");
            return;
        }

        Node current = head;
        boolean ditemukan = false;

        while (current != null) {
            if (current.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                System.out.println("\nDetail Buku Ditemukan:");
                System.out.println("Kode   : " + current.kodeBuku);
                System.out.println("Judul  : " + current.judul);
                System.out.println("Penulis: " + current.penulis);
                ditemukan = true;
                break;
            }
            current = current.next;
        }

        if (!ditemukan) {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    // Tampilkan semua buku berurutan dan totalnya
    public void tampilkanSemuaBuku() {
        if (isEmpty()) {
            System.out.println("\nDaftar Buku Kosong.");
            System.out.println("Total Buku: 0");
            return;
        }

        System.out.println("\nDaftar Buku:\n");
        Node current = head;
        while (current != null) {
            System.out.println("Kode   : " + current.kodeBuku);
            System.out.println("Judul  : " + current.judul);
            System.out.println("Penulis: " + current.penulis);
            System.out.println("-------------------------");
            current = current.next;
        }
        System.out.println("\nTotal Buku: " + size);
    }
}

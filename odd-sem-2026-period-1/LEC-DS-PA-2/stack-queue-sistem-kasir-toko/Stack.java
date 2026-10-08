public class Stack {
    private Node top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Menambahkan transaksi baru ke posisi teratas stack
    public void push(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        Node newNode = new Node(nomorAntrian, namaPelanggan, totalBelanja);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Menampilkan riwayat transaksi dari yang paling baru ke paling lama
    public void tampilkanRiwayat() {
        if (isEmpty()) {
            System.out.println("\nBelum ada riwayat transaksi.");
            return;
        }

        System.out.println("\n=== RIWAYAT TRANSAKSI (TERBARU KE LAMA) ===");
        Node current = top;
        while (current != null) {
            System.out.println("Nomor Antrian : " + current.nomorAntrian);
            System.out.println("Nama Pelanggan: " + current.namaPelanggan);
            System.out.println("Total         : Rp" + String.format("%,.2f", current.totalBelanja));
            System.out.println("----------------------------------------");
            current = current.next;
        }

        System.out.println("\nTotal Transaksi Selesai: " + size);
    }
}

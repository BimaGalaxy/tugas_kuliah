public class Node {
    String nomorAntrian;
    String namaPelanggan;
    double totalBelanja;
    Node next;

    // Konstruktor inisialisasi data pelanggan
    public Node(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        this.nomorAntrian = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja = totalBelanja;
        this.next = null;
    }
}
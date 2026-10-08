// Class Node untuk merepresentasikan elemen data buku dalam Single Linked List
public class Node {
    String kodeBuku;
    String judul;
    String penulis;
    Node next;

    // Konstruktor untuk inisialisasi node buku baru
    public Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}

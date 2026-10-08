public class Queue {
    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    // Menambahkan pelanggan ke ujung belakang antrian
    public void enqueue(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        Node newNode = new Node(nomorAntrian, namaPelanggan, totalBelanja);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
        System.out.println("Data pelanggan ditambahkan ke antrian!");
    }

    // Mengeluarkan pelanggan dari ujung depan antrian
    public Node dequeue() {
        if (isEmpty()) {
            return null;
        }

        Node temp = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        
        size--;
        return temp;
    }

    // Menampilkan seluruh antrian pelanggan yang sedang menunggu
    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("\nAntrian kosong.");
            return;
        }

        System.out.println("\n=== DAFTAR ANTRIAN SAAT INI ===");
        Node current = front;
        while (current != null) {
            System.out.println("[" + current.nomorAntrian + "] " + current.namaPelanggan + " - Total: Rp" + String.format("%,.2f", current.totalBelanja));
            current = current.next;
        }

        System.out.println("\nTotal Pelanggan dalam Antrian: " + size);
    }
}

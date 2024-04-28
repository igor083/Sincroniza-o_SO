package problema_Produtor_Consumidor;

public class Buffer {
    private final int[] buffer;
    private int size;
    private int in;
    private int out;
    private int count; // contador do buffer

    public Buffer(int size) {
        this.size = size;
        buffer = new int[size];
        in = 0;//proxima posicao disponivel no buffer
        out = 0;//posicao a ser consumida 
        count = 0; // Estado inicial do buffer
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (count == size) {
            wait(); // Buffer cheio, aguarda espaço disponível
        }
        buffer[in] = item;
        in = (in + 1) % size;
        count++; // ++ contador do buffer
        System.out.println("Produced item: " + item + ", Buffer size: " + count);
        notifyAll(); // informa consumidores que o o buffer não está vazio
    }

    public synchronized void consume() throws InterruptedException  {
        while (count == 0) {
            wait(); // consumidor espera buffer deixar de estar vazio
        }
        int item = buffer[out];
        out = (out + 1) % size;
        count--; // -- contador do buffer (item consumido)
        System.out.println("Consumed item: " + item + ", Buffer size: " + count);
        notifyAll(); // informa produtores que um item foi consumido
    }
}

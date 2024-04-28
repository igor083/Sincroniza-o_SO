package problema_Produtor_Consumidor;

public class Consumer implements Runnable {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        
    	try {
           while(true) {
                buffer.consume();
                Thread.sleep((int) (Math.random() * 100));// thread dos consumidores dorme por até 99ms
              
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
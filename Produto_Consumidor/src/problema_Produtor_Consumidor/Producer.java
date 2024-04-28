package problema_Produtor_Consumidor;

public class Producer implements Runnable {
	private final Buffer buffer;

	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		int i=0;
		try {
			while(i<50) {//quantidade de produções
				buffer.produce(i);
				Thread.sleep((int) (Math.random() * 100));// thread dos produtores dorme por até 99ms
				i++;
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
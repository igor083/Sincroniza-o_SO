package problema_Produtor_Consumidor;

public class App {

	public static void main(String[] args) {
		Buffer buffer = new Buffer(5);
		Thread producerThread = new Thread(new Producer(buffer));
		Thread consumerThread = new Thread(new Consumer(buffer));

		producerThread.start();
		consumerThread.start();
	}
}

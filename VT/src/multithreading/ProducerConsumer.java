package multithreading;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

public class ProducerConsumer {
	private static Vector<Product> products = new Vector();
	
	public static void main(String[] args) throws InterruptedException {
		//get number of producers, number of products each are producing, number of consumers
		Scanner scanner = new Scanner(System.in);
		System.out.print("Producers: ");
		int numProducers = scanner.nextInt();
		System.out.print("Number to produce: ");
		int toProduce = scanner.nextInt();
		System.out.print("Consumers: ");
		int numConsumers = scanner.nextInt();
		
		//calculate closest to even number to consume
		int average = (toProduce * numProducers) / numConsumers;
		int remainder = (toProduce * numProducers) % numConsumers;
		
		System.out.println("Average: " + average + " Remainder: " + remainder);
		
		Consumer[] consumers = new Consumer[numConsumers];
		Producer[] producers = new Producer[numProducers];
		
		//create consumers
		for (int i = 0; i < numConsumers - remainder; i++) {
			consumers[i] = new Consumer(i + 1, products, average);
		}
		for (int i = numConsumers - remainder; i < numConsumers; i++) {
			consumers[i] = new Consumer(i + 1, products, average + 1);
		}
		//create producers
		for (int i = 0; i < numProducers; i++) {
			producers[i] = new Producer(i + 1, products, toProduce);
		}
		
		/*
		Producer p1 = new Producer(1, products, 4);
		Producer p2 = new Producer(2, products, 4);
		Producer p3 = new Producer(3, products, 4);
		Producer p4 = new Producer(4, products, 4);
		
		Consumer c1 = new Consumer(1, products, 5);
		Consumer c2 = new Consumer(2, products, 5);
		Consumer c3 = new Consumer(3, products, 6);
		*/
		
		//create thread array of consumers and producers
		Thread[] thrConsumers = new Thread[numConsumers];
		Thread[] thrProducers = new Thread[numProducers];
		
		for (int i = 0; i < numProducers; i++) {
			thrProducers[i] = new Thread(producers[i]);
		}
		
		for (int i = 0; i < numConsumers; i++) {
			thrConsumers[i] = new Thread(consumers[i]);
		}
		
		//start and join
		for (int i = 0; i < numProducers; i++) {
			thrProducers[i].start();
		}
		
		for (int i = 0; i < numConsumers; i++) {
			thrConsumers[i].start();
		}
		
		for (int i = 0; i < numProducers; i++) {
			thrProducers[i].join();
		}
		
		for (int i = 0; i < numConsumers; i++) {
			thrConsumers[i].join();
		}
		
		System.out.println("\n" + products.size() + " products left");
	}
}

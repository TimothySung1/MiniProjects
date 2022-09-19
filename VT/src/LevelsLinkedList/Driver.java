package LevelsLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	
	private static int[] getTrain(Scanner scanner) throws FileNotFoundException{
		int length = Integer.parseInt(scanner.nextLine());
		int[] train = new int[length];
		String[] locations = scanner.nextLine().split(" ");
		int[] locations2 = new int[locations.length];
		for (int i = 0; i < locations.length; i++) {
			locations2[i] = Integer.parseInt(locations[i]);
		}
		for (int i = 0; i < train.length; i++) {
			train[i] = locations2[i];
		}
		return train;
	}
	
	private static int[] getBus(Scanner scanner) throws FileNotFoundException{
		
		int length = Integer.parseInt(scanner.nextLine());
		int[] bus = new int[length];
		String[] locations = scanner.nextLine().split(" ");
		int[] locations2 = new int[locations.length];
		for (int i = 0; i < locations.length; i++) {
			locations2[i] = Integer.parseInt(locations[i]);
		}
		for (int i = 0; i < bus.length; i++) {
			bus[i] = locations2[i];
		}
		return bus;
	}
	
	private static int[] getWalk(Scanner scanner) throws FileNotFoundException{
		
		int length = Integer.parseInt(scanner.nextLine());
		int[] walk = new int[length];
		String[] locations = scanner.nextLine().split(" ");
		int[] locations2 = new int[locations.length];
		for (int i = 0; i < locations.length; i++) {
			locations2[i] = Integer.parseInt(locations[i]);
		}
		for (int i = 0; i < walk.length; i++) {
			walk[i] = locations2[i];
		}
		return walk;
	}
	
	private static int[] getScooter(Scanner scanner) throws FileNotFoundException{
		int length = Integer.parseInt(scanner.nextLine());
		int[] scooter = new int[length];
		String[] locations = scanner.nextLine().split(" ");
		int[] locations2 = new int[locations.length];
		for (int i = 0; i < locations.length; i++) {
			locations2[i] = Integer.parseInt(locations[i]);
		}
		for (int i = 0; i < scooter.length; i++) {
			scooter[i] = locations2[i];
		}
		return scooter;
	}
	
	public static void printPath(ArrayList<TNode> path) {
		String list = "0";
		TNode cur = path.get(1);
		TNode prev = path.get(0);
		int index = 1;
		while (true) {
			if (prev.getNext() == cur) {
				
				int distance = (cur.getLocation() - prev.getLocation()) * 2 + (cur.getLocation() - prev.getLocation() - 1);
				if (cur.getLocation() >= 10 && prev.getLocation() >= 10) {
					distance += cur.getLocation() - prev.getLocation() - 1;
				}
				else if (cur.getLocation() >= 10 || prev.getLocation() >= 10) {
					distance += cur.getLocation() - 10;
				}
				for (int i = 0; i < distance - 1; i++) {
					list += "-";
				}
				list += ">" + cur.getLocation();
			}
			
			else {
				list += "\n ";
				int distance = (cur.getLocation()) * 2 + (cur.getLocation() - 1);
				
				if (cur.getLocation() >= 10 && prev.getLocation() >= 10) {
					distance += cur.getLocation() - 10;
				}
				
				for (int i = 0; i < distance; i++) {
					list += " ";
				}
				list += "|\n ";
				for (int i = 0; i < distance; i++) {
					list += " ";
				}
				list += cur.getLocation();
			}
			index++;
			if (index >= path.size()) {
				break;
			}
			cur = path.get(index);
			prev = path.get(index - 1);
		}
		
		
		System.out.println(list);
	}
	
	public static void printTransit(TNode trainHead) {
		String list = "0";
		TNode prev = trainHead;
		TNode cur = trainHead.getNext();
		TNode busHead;
		TNode scooterHead;
		TNode walkHead;
		//if scooter
		if (trainHead.getDown().getDown().getDown() != null) {
			busHead = trainHead.getDown();
			scooterHead = busHead.getDown();
			walkHead = scooterHead.getDown();
		}
		else {
			busHead = trainHead.getDown();
			walkHead = busHead.getDown();
			scooterHead = null;
		}
		
		
		int location = 0;
		//arrows
		//System.out.println("printing...");
		while (cur != null) {
			int distance = (cur.getLocation() - prev.getLocation()) * 2 + (cur.getLocation() - prev.getLocation() - 1);
			if (cur.getLocation() >= 10 && prev.getLocation() >= 10) {
				distance += cur.getLocation() - prev.getLocation() - 1;
			}
			else if (cur.getLocation() >= 10 || prev.getLocation() >= 10) {
				distance += cur.getLocation() - 10;
			}
			for (int i = 0; i < distance - 1; i++) {
				list += "-";
				/*
				if (location > 10) {
					list+= "-";
				}
				*/
				location++;
			}
			list += ">" + cur.getLocation();
			cur = cur.getNext();
			prev = prev.getNext();
		}
		//System.out.println("arrows done...");
		list += "\n";
		//link down
		cur = trainHead;
		TNode lowCur = busHead;
		TNode lowPrev = busHead;
		location = 0;
		while (cur != null) {
			if (cur.getLocation() > lowCur.getLocation()) {
				lowCur = lowCur.getNext();
			}
			else if (cur.getLocation() == lowCur.getLocation()) {
				int distance = (lowCur.getLocation() - lowPrev.getLocation()) * 2 + (lowCur.getLocation() - lowPrev.getLocation() - 1);
				if (lowCur.getLocation() >= 10 && lowPrev.getLocation() >= 10) {
					distance += lowCur.getLocation() - lowPrev.getLocation();
				}
				else if (lowCur.getLocation() >= 10 || lowPrev.getLocation() >= 10) {
					distance += lowCur.getLocation() - 10;
				}
				for (int i = 0; i < distance; i++) {
					list += " ";
					/*
					if (location > 10) {
						list+= " ";
					}
					*/
					location++;
				}
				list += "|";
				//list += cur.getLocation();
				lowPrev = lowCur;
				cur = cur.getNext();
			}
			else {
				break;
			}
		}
		list += "\n0";
		
		//bus stops
		location = 0;
		prev = busHead;
		cur = busHead.getNext();
		while (cur != null) {
			int distance = (cur.getLocation() - prev.getLocation()) * 2 + (cur.getLocation() - prev.getLocation() - 1);
			if (cur.getLocation() >= 10 && prev.getLocation() >= 10) {
				distance += cur.getLocation() - prev.getLocation() - 1;
			}
			else if (cur.getLocation() >= 10 || prev.getLocation() >= 10) {
				distance += cur.getLocation() - 10;
			}
			for (int i = 0; i < distance - 1; i++) {
				list += "-";
				/*
				if (location > 10) {
					list+= "-";
				}
				*/
				location++;
			}
			list += ">" + cur.getLocation();
			cur = cur.getNext();
			prev = prev.getNext();
		}
		//System.out.println("arrows done...");
		list += "\n";
		
		//scooter
		if (scooterHead != null) {
			//link down from bus to scooter
			list += "|";
			cur = busHead.getNext();
			prev = busHead;
			location = 0;
			lowPrev = scooterHead;
			lowCur = scooterHead.getNext();
			while (cur != null) {
				if (cur.getLocation() > lowCur.getLocation()) {
					lowCur = lowCur.getNext();
				}
				else if (cur.getLocation() == lowCur.getLocation()) {
					int distance = (lowCur.getLocation() - lowPrev.getLocation()) * 2 + (lowCur.getLocation() - lowPrev.getLocation() - 1);
					if (lowCur.getLocation() >= 10 && lowPrev.getLocation() >= 10) {
						distance += lowCur.getLocation() - lowPrev.getLocation();
					}
					else if (lowCur.getLocation() >= 10 || lowPrev.getLocation() >= 10) {
						distance += lowCur.getLocation() - 10;
					}
					for (int i = 0; i < distance; i++) {
						list += " ";
						/*
						if (location > 10) {
							list+= " ";
						}
						*/
						location++;
						
					}
					list += "|";
					//list += cur.getLocation();
					lowPrev = lowCur;
					cur = cur.getNext();
				}
				else {
					break;
				}
			}
			
			list += "\n0";
			
			//scooter stops
			location = 0;
			prev = scooterHead;
			cur = scooterHead.getNext();
			while (cur != null) {
				int distance = (cur.getLocation() - prev.getLocation()) * 2 + (cur.getLocation() - prev.getLocation() - 1);
				if (cur.getLocation() >= 10 && prev.getLocation() >= 10) {
					distance += cur.getLocation() - prev.getLocation() - 1;
				}
				else if (cur.getLocation() >= 10 || prev.getLocation() >= 10) {
					distance += cur.getLocation() - 10;
				}
				for (int i = 0; i < distance - 1; i++) {
					list += "-";
					/*
					if (location > 10) {
						list+= "-";
					}
					*/
					location++;
				}
				list += ">" + cur.getLocation();
				cur = cur.getNext();
				prev = prev.getNext();
			}
			//System.out.println("arrows done...");
			list += "\n";
			
			//link down from scooter to walking
			list += "|";
			prev = scooterHead;
			cur = scooterHead.getNext();
			location = 0;
			lowPrev = walkHead;
			lowCur = walkHead.getNext();
			while (cur != null) {
				if (cur.getLocation() > lowCur.getLocation()) {
					lowCur = lowCur.getNext();
				}
				else if (cur.getLocation() == lowCur.getLocation()) {
					int distance = (lowCur.getLocation() - lowPrev.getLocation()) * 2 + (lowCur.getLocation() - lowPrev.getLocation() - 1);
					if (lowCur.getLocation() >= 10 && lowPrev.getLocation() >= 10) {
						distance += lowCur.getLocation() - lowPrev.getLocation();
					}
					else if (lowCur.getLocation() >= 10 || lowPrev.getLocation() >= 10) {
						distance += lowCur.getLocation() - 10;
					}
					for (int i = 0; i < distance; i++) {
						list += " ";
						/*
						if (location > 10) {
							list+= " ";
						}
						*/
						location++;
						
					}
					list += "|";
					//list += cur.getLocation();
					lowPrev = lowCur;
					cur = cur.getNext();
				}
				else {
					break;
				}
			}
			
			list += "\n0";
			
		}
		
		else {
			//link down from bus to walking
			cur = busHead;
			lowCur = walkHead;
			lowPrev = walkHead;
			location = 0;
			while (cur != null) {
				if (cur.getLocation() > lowCur.getLocation()) {
					lowCur = lowCur.getNext();
				}
				else if (cur.getLocation() == lowCur.getLocation()) {
					int distance = (lowCur.getLocation() - lowPrev.getLocation()) * 2 + (lowCur.getLocation() - lowPrev.getLocation() - 1);
					if (lowCur.getLocation() >= 10 && lowPrev.getLocation() >= 10) {
						distance += lowCur.getLocation() - lowPrev.getLocation();
					}
					else if (lowCur.getLocation() >= 10 || lowPrev.getLocation() >= 10) {
						distance += lowCur.getLocation() - 10;
					}
					for (int i = 0; i < distance; i++) {
						list += " ";
						/*
						if (location > 10) {
							list+= " ";
						}
						*/
						location++;
						
					}
					list += "|";
					//list += cur.getLocation();
					lowPrev = lowCur;
					cur = cur.getNext();
				}
				else {
					break;
				}
			}
			list += "\n0";
			
			
			
			
		}
		
		//walking
		location = 0;
		prev = walkHead;
		cur = walkHead.getNext();
		while (cur != null) {
			int distance = (cur.getLocation() - prev.getLocation()) * 2 + (cur.getLocation() - prev.getLocation() - 1);
			for (int i = 0; i < distance - 1; i++) {
				list += "-";
				/*
				if (location > 10) {
					list+= "-";
				}
				*/
				location++;
			}
			list += ">" + cur.getLocation();
			cur = cur.getNext();
			prev = prev.getNext();
		}
		//System.out.println("arrows done...");
		list += "\n";
		
		System.out.println(list);
	}
	
	//test
	public static void main(String[] args) throws FileNotFoundException{
		File file = new File("Layered.txt");
		Scanner scanner = new Scanner(file);
		int[] train = getTrain(scanner);
		int[] bus = getBus(scanner);
		int[] walk = getWalk(scanner);
		File file2 = new File("New Text Document.txt");
		Transit transit = new Transit();
		
		TNode head = transit.makeList(train, bus, walk);
		System.out.println("Original: ");
		System.out.println(transit);
		//System.out.println("\nRemove train station 13");
		//transit.removeTrainStation(head, 13);
		//System.out.println(transit);
		//System.out.println("\nAdd bus stop at 15");
		//transit.addBusStop(head, 15);
		//System.out.println(transit);
		System.out.println("\nBest path to destination 11");
		printPath(transit.bestPath(head, 11));
		System.out.println("\nDuplicate: ");
		printTransit(transit.duplicate(head));
		
		Scanner scooterScanner = new Scanner(file2);
		int[] scooter = getScooter(scooterScanner);
		transit.addScooter(head, scooter);
		System.out.println("Add scooter");
		System.out.println(transit);
		System.out.println("Best path to 22");
		printPath(transit.bestPath(head, 22));
		System.out.println("Duplicate: ");
		printTransit(transit.duplicate(head));
		System.out.println("Add bus stop 21");
		transit.addBusStop(head, 21);
		System.out.println(transit);
		System.out.println("Remove train station");
		transit.removeTrainStation(head, 13);
		System.out.println(transit);
	}
}

package LevelsLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Transit {
	TNode trainHead;
	public TNode makeList(int[] train, int[] bus, int[]walk) {
		//train list
		TNode trainHead = new TNode(train[0]);
		TNode prev = trainHead;
		for (int i = 1; i < train.length; i++) {
			TNode node = new TNode(train[i]);
			prev.setNext(node);
			prev = node;
		}
		/*
		for (int i = 0; i < train.length; i++) {
			System.out.println(train[i]);
		}
		*/
		//bus list
		TNode busHead = new TNode(bus[0]);
		//System.out.println(bus[0]);
		prev = busHead;
		trainHead.setDown(busHead);
		for (int i = 1; i < bus.length; i++) {
			TNode node = new TNode(bus[i]);
			prev.setNext(node);
			prev = node;
		}
		//walk list
		TNode walkHead = new TNode(walk[0]);
		prev = walkHead;
		busHead.setDown(walkHead);
		for (int i = 1; i < walk.length; i++) {
			TNode node = new TNode(walk[i]);
			prev.setNext(node);
			prev = node;
		}
		//set down
		TNode cur = trainHead;
		TNode lowCur = busHead;
		for (int i = 1; i < train.length; i++) {
			for (int j = 1; j < bus.length; j++) {
				if (train[i] == bus[j]) {
					//System.out.println("Train: " + train[i]);
					for (int k = 0; k < i; k++) {
						cur = cur.getNext();
						//System.out.println("Cur: " + cur.getLocation());
					}
					for (int l = 0; l < j; l++) {
						lowCur = lowCur.getNext();
						//System.out.println("Low cur: " + lowCur.getLocation());
					}
					cur.setDown(lowCur);
					cur = trainHead;
					lowCur = busHead;
				}
			}
		}
		
		cur = busHead;
		lowCur = walkHead;
		for (int i = 1; i < bus.length; i++) {
			for (int j = 1; j < walk.length; j++) {
				if (bus[i] == walk[j]) {
					for (int k = 0; k < i; k++) {
						cur = cur.getNext();
					}
					for (int l = 0; l < j; l++) {
						lowCur = lowCur.getNext();
					}
					cur.setDown(lowCur);
					cur = busHead;
					lowCur = walkHead;
				}
			}
		}
		this.trainHead = trainHead;
		return trainHead;
	}
	
	public static void removeTrainStation(TNode trainHead, int location) {
		TNode cur = trainHead;
		TNode prev = trainHead;
		//get train node at the location
		while (cur.getLocation() < location) {
			prev = cur;
			cur = cur.getNext();
		}
		//if the train node is not the location, do nothing
		if (cur.getLocation() != location) {
			return;
		}
		
		//remove train station
		prev.setNext(cur.getNext());
	}
	
	public static void addBusStop(TNode trainHead, int location) {
		TNode busHead = trainHead.getDown();
		TNode cur = busHead;
		//get bus stop location
		while (cur.getNext().getLocation() < location) {
			cur = cur.getNext();
		}
		//check if bus stop exists
		if (cur.getNext().getLocation() == location) {
			return;
		}
		
		//add
		TNode newNode = new TNode(location, cur.getNext());
		cur.setNext(newNode);
		//set node down
		TNode walkCur = cur.getDown();
		while (walkCur.getNext().getLocation() < location) {
			walkCur = walkCur.getNext();
		}
		
		if (walkCur.getNext().getLocation() == location) {
			newNode.setDown(walkCur.getNext());
		}
		
		//if scooter
		if (trainHead.getDown().getDown().getDown() != null) {
			TNode lowCur = cur.getDown();
			while (lowCur.getNext().getLocation() < location) {
				lowCur = lowCur.getNext();
			}
			
			if (lowCur.getNext().getLocation() == location) {
				newNode.setDown(lowCur.getNext());
			}
		}
		//connect train with bus
		TNode trainCur = trainHead;
		while (trainCur.getNext() != null && trainCur.getNext().getLocation() < location) {
			trainCur = trainCur.getNext();
		}
		if (trainCur.getNext() != null &&trainCur.getNext().getLocation() == location) {
			trainCur.getNext().setDown(newNode);
		}
	}
	
	public ArrayList<TNode> bestPath(TNode trainHead, int location) {
		ArrayList<TNode> path = new ArrayList<TNode>();
		TNode cur = trainHead;
		path.add(cur);
		//traverse train stations
		while (cur.getNext() != null && cur.getNext().getLocation() < location) {
			cur = cur.getNext();
			path.add(cur);
		}
		//traverse down to walk
		if (cur.getNext() != null && cur.getNext().getLocation() == location) {
			cur = cur.getNext();
			path.add(cur);
			while (cur.getDown() != null) {
				cur = cur.getDown();
				path.add(cur);
			}
			return path;
		}
		
		else {
			//traverse bus
			cur = cur.getDown();
			path.add(cur);
			while (cur.getNext() != null && cur.getNext().getLocation() < location) {
				cur = cur.getNext();
				path.add(cur);
			}
			//traverse down to walk
			if (cur.getNext() != null && cur.getNext().getLocation() == location) {
				cur = cur.getNext();
				path.add(cur);
				while (cur.getDown() != null) {
					cur = cur.getDown();
					path.add(cur);
				}
				return path;
			}
			
			else {
				//traverse walk or scooter
				cur = cur.getDown();
				path.add(cur);
				while (cur.getNext() != null && cur.getNext().getLocation() < location) {
					cur = cur.getNext();
					path.add(cur);
				}
				if (cur.getNext() != null && cur.getNext().getLocation() == location) {
					cur = cur.getNext();
					path.add(cur);
					while (cur.getDown() != null) {
						cur = cur.getDown();
						path.add(cur);
					}
					return path;
				}
				//this should never run
				else {
					cur = cur.getDown();
					path.add(cur);
					while (cur.getNext() != null && cur.getNext().getLocation() < location) {
						cur = cur.getNext();
						path.add(cur);
					}
					cur = cur.getNext();
					path.add(cur);
					//System.out.println("Scooter");
				}
			}
		}
		
		return path;
	}
	
	public static TNode duplicate(TNode trainHead) {
		TNode cur = trainHead;
		TNode newHead = new TNode(trainHead.getLocation());
		TNode newCur = newHead;
		//recreate train stations
		while (cur.getNext() != null) {
			cur = cur.getNext();
			newCur.setNext(new TNode(cur.getLocation()));
			newCur = newCur.getNext();
		}
		
		//recreate bus stops
		cur = trainHead.getDown();
		newHead.setDown(new TNode(cur.getLocation()));
		newCur = newHead.getDown();
		while (cur.getNext() != null) {
			cur = cur.getNext();
			newCur.setNext(new TNode(cur.getLocation()));
			newCur = newCur.getNext();
		}
		
		//recreate walking or scooter
		cur = trainHead.getDown().getDown();
		newHead.getDown().setDown(new TNode(cur.getLocation()));
		newCur = newHead.getDown().getDown();
		while (cur.getNext() != null) {
			cur = cur.getNext();
			newCur.setNext(new TNode(cur.getLocation()));
			newCur = newCur.getNext();
		}
		//if there is scooter layer
		if (trainHead.getDown().getDown().getDown() != null) {
			cur = trainHead.getDown().getDown().getDown();
			newHead.getDown().getDown().setDown(new TNode(cur.getLocation()));
			newCur = newHead.getDown().getDown().getDown();
			while (cur.getNext() != null) {
				cur = cur.getNext();
				newCur.setNext(new TNode(cur.getLocation()));
				newCur = newCur.getNext();
			}
		}
		//create links between train and bus
		newCur = newHead.getNext();
		TNode newLowCur = newHead.getDown();
		while (newLowCur.getNext() != null && newCur != null) {
			newLowCur = newLowCur.getNext();
			if (newLowCur.getLocation() == newCur.getLocation()) {
				newCur.setDown(newLowCur);
				newCur = newCur.getNext();
			}
		}
		//create links between bus and walk or scooter
		newCur = newHead.getDown().getNext();
		newLowCur = newHead.getDown().getDown();
		while (newLowCur.getNext() != null && newCur != null) {
			newLowCur = newLowCur.getNext();
			if (newLowCur.getLocation() == newCur.getLocation()) {
				newCur.setDown(newLowCur);
				newCur = newCur.getNext();
			}
		}
		
		//if scooter layer
		if (trainHead.getDown().getDown().getDown() != null) {
			newCur = newHead.getDown().getDown().getNext();
			newLowCur = newHead.getDown().getDown().getDown();
			while (newLowCur.getNext() != null && newCur != null) {
				newLowCur = newLowCur.getNext();
				if (newLowCur.getLocation() == newCur.getLocation()) {
					newCur.setDown(newLowCur);
					newCur = newCur.getNext();
				}
			}
		}
		
		return newHead;
	}
	
	public void addScooter(TNode head, int[] scooter) {
		TNode busHead = head.getDown();
		TNode walkHead = head.getDown().getDown();
		//create scooter linked list
		TNode scooterHead = new TNode(scooter[0]);
		TNode cur = scooterHead;
		for (int i = 1; i < scooter.length; i++) {
			TNode newScooter = new TNode(scooter[i]);
			cur.setNext(newScooter);
			cur = cur.getNext();
		}
		
		//link bus to scooter
		busHead.setDown(scooterHead);
		cur = busHead;
		TNode lowCur = scooterHead;
		while (cur.getNext() != null) {
			while (cur.getLocation() > lowCur.getLocation()) {
				lowCur = lowCur.getNext();
			}
			cur.setDown(lowCur);
			cur = cur.getNext();
		}
		
		//link scooter to bus;
		scooterHead.setDown(walkHead);
		cur = scooterHead;
		lowCur = walkHead;
		while (cur.getNext() != null) {
			while (cur.getLocation() > lowCur.getLocation()) {
				lowCur = lowCur.getNext();
			}
			cur.setDown(lowCur);
			cur = cur.getNext();
		}
	}
	
	public String toString() {
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
		
		return list;
	}
}

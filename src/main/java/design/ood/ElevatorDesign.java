package design.ood;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Description : Design an elevator Source : Created_By : zhaoxm (xmpy) Date :
 * Aug 27, 2015 Time : 10:29:18 PM
 */

class Client {
	public long reachTime;
	public int startFloor;
	public int targetFloor;

	public void sendOutsideRequest(ElevatorController ec, int direction) {
		ec.addRequest(new OutsideElevatorRequest(direction, this));
	}

}

class Request {
	public int type;
	public int target;

}

class RequestComparator implements Comparator<Request> {

	@Override
	public int compare(Request a, Request b) {
		return a.target - b.target;
	}

}

class OutsideElevatorRequest extends Request {
	public int direction; // Client want to go up floor or go down?
	public Client client;

	public OutsideElevatorRequest(int direction, Client client) {
		this.type = 0;
		target = client.startFloor;
		this.direction = direction;
		this.client = client;
	}
}

class InsideElevatorRequest extends Request {
	public Client client;

	public InsideElevatorRequest(Client client) {
		this.type = 1;
		target = client.targetFloor;
		this.client = client;
	}
}

class ElevatorController {
	public LinkedList<Request> reqList;

	public ElevatorController() {
		reqList = new LinkedList<Request>();
	}

	public synchronized void addRequest(Request req) {
		reqList.add(req);
		Collections.sort(reqList, new RequestComparator());
	}

	public synchronized Request getNextRequest(Elevator elevator) {
		// Based on the state of this elevator, send the peeked request to this
		// elevator.
		if (reqList.size() == 0) {
			return null;
		}

		if (elevator.isIdle()) {
			// Find the nearest target floor, go here.
			
		}
		return null;
	}
}

class Elevator implements Runnable {
	public int currFloor;
	public int direction; // +1 means up; - 1 means down.

	public boolean isIdle() {
		return this.direction == 0;
	}

	public void getNextCommand() {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}

public class ElevatorDesign {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
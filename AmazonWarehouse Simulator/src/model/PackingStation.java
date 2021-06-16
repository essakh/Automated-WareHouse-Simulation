package model;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PackingStation extends Actor {
	
	private final static boolean OBSTRUCTIVE = false; //Can robot move through it?
	private static LinkedList<Order> orders;
	private List<Actor> robots;

	public PackingStation(int x, int y, List<Actor> robots) {

		this(x, y, robots, null);

	}
	
	public PackingStation(int x, int y, List<Actor> robots,String uid) {
		super(x, y, uid);
		orders = new LinkedList<Order>();
		this.robots = robots;
	}

	@Override
	public void act() {
		Order order = getOrders().pollFirst();
		
		if (order != null) {
			//Take a shelf from the order's HashSet
			for (Shelf shelf : order.getShelfs()) {
				
//				ask the robots to bring items from certain storage shelves.
				
				for (Actor robot : robots) {
					Robot robot1 = (Robot) robot;
					
					Integer stepsToTake = robot1.analyseAssignment(shelf, this);
					
					
				}
				
				
				
			}
			
			

			
		}
		
	}
	

	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean getOBSTRUCTIVE() {
	
		return this.OBSTRUCTIVE;
	}

	public static LinkedList<Order> getOrders() {
		return orders;
	}

	public static void enterOrder(Order order) {
		orders.add(order);
	}

}

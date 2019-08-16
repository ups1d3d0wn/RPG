/**
 *@author Matt Haefele
 @version 1.0
 */


public class NPC{
    private boolean hasInventory;
    private boolean isHostile;
    private String name;
    private String location;
    private int health;

    public NPC(boolean inventory, String name, String location, int health){
    	this.hasInventory = inventory;
	this.name = name;
	this.location = location;
	this.health = health;
    }





}//end NPC class

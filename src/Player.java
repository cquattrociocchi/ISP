import java.util.ArrayList;
import java.util.List;

public class Player {
    private String currentRoomId;
    private String previousRoomId;
    private List<Item> inventory;
    private String name;
    private String gender;
    private int points;
    private int health;
    private boolean alive;
    private boolean wearingBoot = false;
    private boolean lanternOn = false;
    private int lanternTurns = 20; 

    public Player(String startingRoomId) {
        this.currentRoomId = startingRoomId;
        this.previousRoomId = null;
        this.inventory = new ArrayList<>();
        this.points = 0;
        this.health = 20;
        this.alive = true;
    }

    public void setName(String name) {
        if (!name.isBlank())
            this.name = name;
        else
            System.out.println("I don't understand that command.");
    }

    public String getName() {
        return name;
    }

    public void setGender(String gender) {
        if (gender.equals("m") || gender.equals("f"))
            this.gender = gender;
        else
            System.out.println("I don't understand that command.");
    }

    public String getGender() {
        return gender;
    }

    public String getCurrentRoomId() {
        return currentRoomId;
    }

    public void setCurrentRoomId(String roomId) {
        previousRoomId = currentRoomId;
        currentRoomId = roomId;
    }

    public void addItem(Item item) {
        inventory.add(item);
        if (item.isFirstPickUp()) {
            item.markAsPickedUp();
            addPoints(item.getPointValue());
            System.out.println("Congrats, you earned " + item.getPointValue() + " points! " + " Total: " + points + " points.");
        }
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addPoints(int amount) {
        points += amount;
    }

    public void deductPoints(int amount) {
        points -= amount;
    }
    public int getPoints() {
        return points;
    }

    public int getHealth() {
        return health;
    }

    public void addHealth(int amount) {
        health += amount;
    }

    public void deductHealth(int amount) {
        health -= amount;
        
        if (health <= 0)
            alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public String getStats() {
        StringBuilder sb = new StringBuilder();
        sb.append("You have ").append(points).append(" points.\n");
        sb.append("You have ").append(health).append(" health.\n");
        return sb.toString();
    }

    public boolean isWearingBoot(){
        return wearingBoot; 
    }

    public void enableBoot(){
        wearingBoot = true; 
    }

    public void turnLanternOn() {
        if (lanternTurns <= 0){
            System.out.println("Your mage light has run out of fuel");
            return;
        }

        lanternOn = true;
        System.out.println("You light the lantern.");
    }

    public void turnLanternOff() {
        lanternOn = false;
        System.out.println("You extinguish the lantern.");
    }

    public void lanternTimer(){
        if (lanternOn && lanternTurns > 0){
            lanternTurns--;
        }

        if (lanternTurns == 0){
            lanternOn = false;
            System.out.println("Your lantern has burned out.");
        }
    }

    public boolean getLanternStatus(){
        return (lanternTurns <=0); 
    }
    
}

import java.util.Scanner;
public class Item {
    private String id;
    private String name;
    private String description;
    private String type; 
    private boolean isPickedUpForFirstTime;
    public int pointValue;

    public Item(String id, String name, String description, String type, int pointValue) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type; 
        this.isPickedUpForFirstTime = false;
        this.pointValue = pointValue;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public void useAttackItem() {
        //poison dagger, sword, etc.
    }

    public void riddle(Room room, Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\\n\\n\\\"I am built, not born. \\n I connect two as one. \\n Break me and all is lost. \\n What am I?\\\"");
        System.out.println("What is the answer to this riddle? ");
        String answer = scanner.nextLine(); 

        if (answer.equalsIgnoreCase("a bond") || answer.equalsIgnoreCase("bond") || answer.equalsIgnoreCase("a dragon bond") || answer.equalsIgnoreCase("dragon bond")) {
            
            Dragon dragon = room.getDragon(); 

            if (dragon != null && player.getPoints() > 200){ //not sure how many points
                dragon.bondWithPlayer(player);
            } else {
                System.out.println("There is no dragon here to bond with.");
            }

        } else {
            System.out.println("Incorrect. Try again.");
        }


    }

    public boolean isFirstPickUp() {
        return !isPickedUpForFirstTime;
    }

    public void markAsPickedUp() {
        isPickedUpForFirstTime = true;
    }
    public int getPointValue() {
        return pointValue;
    }
    public void useHealingItem() {
        //potion, bandage, etc. 
    }


}

// left Rider Boot: 10
// small lantern: 10
// pair of riding gloves: 15
// map: 15 
// leigheas serum: 20
// combat dagger: 25
// book of riders: 25
// poison dagger: 35
// tattered scroll: 45



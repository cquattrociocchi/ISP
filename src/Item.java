import java.util.Scanner;
public class Item {
    private String id;
    private String name;
    private String description;
    private String type;
    private int attackValue;
    public int pointValue;
    private boolean isPickedUpForFirstTime;
    private Scanner scanner = new Scanner(System.in);

    public Item(String id, String name, String description, String type, int pointValue, int attackValue) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type; 
        this.attackValue = attackValue;
        this.pointValue = pointValue;
        this.isPickedUpForFirstTime = false;
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
        System.out.println("\n\n I am built, not born. \n I connect two as one. \n Break me and all is lost. \n What am I? ");
        String answer = scanner.nextLine();
        boolean hint = true;

        if (answer.indexOf("bond") != -1){
            Dragon dragon = room.getDragon(); 

            if (dragon != null && player.getPoints() > 200){ //not sure how many points
                dragon.bondWithPlayer(player);
            } else {
                System.out.println("There is no dragon here to bond with.");
            }

        } else {
            if (hint) {
                System.out.println("Would you like a hint? (yes/no)");
                String hintResponse = scanner.nextLine();
                if (hintResponse.equalsIgnoreCase("yes")) {
                    System.out.println("Hint: It is something that can be formed between a dragon and a rider.");
                    hint = false;
            }
            
            else {
                System.out.println("Incorrect. Try again.");
            }
            
        }
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

    public void useUtilityItem() {
        //torch, rope, book, etc.
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



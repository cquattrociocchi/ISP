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
    private String [] nicknames;

    public Item(String id, String name, String description, String type, int pointValue, int attackValue, String [] nicknames) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type; 
        this.attackValue = attackValue;
        this.pointValue = pointValue;
        this.isPickedUpForFirstTime = false;
        this.nicknames = nicknames;
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

    public String [] getNicknames() {
        return nicknames;
    }

    public void riddle(Room room, Player player) {
        System.out.println("\n\n I am built, not born. \n I connect two as one. \n Break me and all is lost. \n What am I? ");
        String answer = scanner.nextLine();
        boolean hint = true;

        if (answer.indexOf("bond") != -1){
            Dragon dragon = room.getDragon(); 

            if (dragon != null && player.getPoints() > 0){ //not sure how many points 
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
    public void useHealingItem(Player player, Item item) {
        player.addHealth(10); 

        System.out.println("You used" + item.getName() + "and restored 10 health points! Current health: " + player.getHealth());

        //potion, bandage, etc. 
    }

    public void useUtilityItem(Player player, Item item) {
            if (item.getId().equals("boot")) {
                System.out.println("You put on the Left Rider Boot. You can now step onto the parapet, the grip improved.");
                player.enableBoot(); 

            } else if (item.getId().equals("lantern")) {
                player.turnLanternOn();
                System.out.println(" To turn on and off your lantern, type: lantern on or latern off.");
                

            } else if (item.getId().equals("gloves")) {
                System.out.println("You put on the Pair of Riding Gloves. Your hands are protected and your grip is enhanced, allowing you to climb and hold onto surfaces more securely.");
            } else if (item.getId().equals("map")) {

                if (player.getPoints() > 100){
                    System.out.println("You unfold the Map. It reveals the layout of the threshing grounds.");

                    System.out.println(
                "====================================\n" +
                "      THRESHING GROUNDS MAP\n" +
                "====================================\n" +
                "\n" +
                "                [1]\n" +
                "                  |\n" +
                "                  |\n" +
                "        [2]---------------[3]\n" +
                "         |               / |\n" +
                "         |              / |\n" +
                "         |            /    |\n" +
                "       [11]        [4]     |\n" +
                "          \\                |\n" +
                "           \\               |\n" +
                "           [9]            [6]\n" +
                "             \\           /   \\\n" +
                "              \\         /     \\\n" +
                "              [10]    [5]----[7]\n" +
                "                 \\          /\n" +
                "                   \\      /\n" +
                "                      [8]  DRAGONS\n" ); 
                } else {
                    System.out.println("You don't have enough points to view the threshing grounds map. Explore more and earn points to unlock it.");
                }
   
                
            } 

            else if (item.getId().equals("book of riders")){
                System.out.println("Book of Riders: \n\n" +
                    "Violet Sorrengail - Tairn and Adarna \n" + 
                    "Xaden Riorson - Sgaeyl \n" +
                    "Dain Aetos - Cath \n" +
                    "Rhiannon Matthias - Feirge \n" +
                    "Liam Mairi - Deigh \n" +
                    "Mira Sorrengail - Teine \n" +
                    "Jack Barlowe - Baide");
                
            }

            else if (item.getId().equals("dragon guide")){
                System.out.println(
                    "\"Dragons respect courage, not fear.\n" +
                    "Stand your ground and speak carefully.\""
                    );
            }
            
            
            else {
                System.out.println("You can't use the " + item.getName() + " right now.");
            }
        
    }

    public void useAttackItem(Player player, Item item, Person person, Room room){
        
  
        person.deductHealth(attackValue); 
        System.out.println("You used " + item.getName() + " and dealt " + attackValue + " damage to " + person.getName() + "!");

        player.deductHealth(person.getAttackValue()); 
        System.out.println(person.getName() + " attacked you back. You lost" +  person.getAttackValue() + " health points! \nCurrent health: " + player.getHealth());
        

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



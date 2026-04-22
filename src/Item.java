import java.util.Scanner;
public class Item {
    private String id;
    private String name;
    private String description;
    private String type; 

    public Item(String id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type; 
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

    public void riddle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\\n\\n\\\"I am built, not born. \\n I connect two as one. \\n Break me and all is lost. \\n What am I?\\\"");
        System.out.println("What is the answer to this riddle? ");
        String answer = scanner.nextLine(); 

        if (answer.equalsIgnoreCase("a bond") || answer.equalsIgnoreCase("bond") || answer.equalsIgnoreCase("a dragon bond") || answer.equalsIgnoreCase("dragon bond")) {
            //Correct answer, bond with dragon
            // Implement the effect of solving the riddle, e.g., unlocking a door or revealing a hidden item.
        } else {
            System.out.println("Incorrect. Try again.");
        }


    }

    public void useHealingItem() {
        //potion, bandage, etc. 
    }


}



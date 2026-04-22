public class Person {
    private String id;
    private String name;
    private String description;
    private String type;
    private int health;
    private String signet;
    private int attackValue;
    private String greeting;
    private String deathMessage;
    private boolean alive;

    public Person(String id, String name, String description, String type, int health, String signet, int attackValue, 
                    String greeting, String deathMessage) {
        this.id = id;
        this.name= name;
        this.description = description;
        this.type = type;
        this.health = health;
        this.signet = signet;
        this.attackValue = attackValue;
        this.greeting = greeting;
        this.deathMessage = deathMessage;
        this.alive = true;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public void addHealth(int amount) {
        health += amount;
    }

    public void deductHealth(int amount) {
        health -= amount;
        
        if (health <= 0) {
            alive = false;
            System.out.println(deathMessage);
        }
    }

    public void greet() {
        System.out.println(greeting);
    }
}

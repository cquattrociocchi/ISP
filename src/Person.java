public class Person {
    private String name;
    private int health;
    private String signet;
    private int attackValue;
    private String type;
    private boolean alive;

    public Person(String name, int health, String signet, int attackValue, String type) {
        this.name = name;
        this.health = health;
        this.signet = signet;
        this.attackValue = attackValue;
        this.type = type;
        this.alive = true;
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
}

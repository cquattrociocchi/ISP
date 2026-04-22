public class Student {
    private String name;
    private int health;
    private String signet;
    private int attackValue;

    public Student(String name, int health, String signet, int attackValue) {
        this.name = name;
        this.health = health;
        this.signet = signet;
        this.attackValue = attackValue;
    }

    public int getHealth() {
        return health;
    }
}

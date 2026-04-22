public class Signet {
    // 5 % get inntinsic
    // 45% ice
    // 25% shadows
    // 25% lightning

    private String name;
    private int attackValue;

    public Signet() {
        double prob = Math.random();

        if (prob < 0.05) {
            name = "Inntinnsic";
            attackValue = 0;
        }

        else if (prob < 0.5) {
            name = "Ice";
            attackValue = 3;
        }

        else if (prob < 0.75) {
            name = "Shadows";
            attackValue = 5;
        }

        else {
            name = "Lightning";
            attackValue = 5;
        }
    }

    public void attack(Person person) {
        person.deductHealth(attackValue);
    }
}

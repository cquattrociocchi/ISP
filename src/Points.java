public class Points {
    private static int score;

    public Points() {
        score = 0;
    }

    public void addPoints(int amount) {
        score += amount;
    }

    public void deductPoints(int amount) {
        score -= amount;
    }
    public static int getScore() {
        return score;
    }
    public void displayScore() {
        System.out.println("Current score: " + score);
    }

    // map: 20 points
    // book of Riders: 35 points
    // combat dagger: 25 points
    // left rider boot: 15 points
    // riding gloves: 15 points
    // poison dagger: 40 points
}

public class Dragon {
    private String name; 
    private String colour; 
    private String tail; 

    public Dragon() {
        double probColour = Math.random(); 
        if (probColour < 0.05) {
            colour = "black";
        } else if (probColour < 0.2) {
            colour = "blue";
        } else if (probColour < 0.4) {
            colour = "green";
        } else if (probColour < 0.6) {
            colour = "red";
        } else if (probColour < 0.8) {
            colour = "orange";
        } else {
            colour = "brown";
        }

        double probTail = Math.random();
        if (probTail < 0.05) {
            tail = "morningstartail";
        } else if (probTail < 0.25) {
            tail = "daggertail";
        } else if (probTail < 0.5) {
            tail = "swordtail";
        } else if (probTail < 0.75) {
            tail = "scorpiontail";
        } else {
            tail = "clubtail";
        }

        double nameProb = Math.random(); 
        if (nameProb < 0.05) {
            name = "Smaug";
        } else if (nameProb < 0.2) {
            name = "Fafnir";
        } else if (nameProb < 0.4) {
            name = "Glaurung";
        } else if (nameProb < 0.6) {
            name = "Ancalagon";
        } else if (nameProb < 0.8) {
            name = "Tiamat";
        } else {
            name = "Nidhogg";
        }
        


        
    }

    public String getName() {
        return name;
    }   

    public void bondWithPlayer() {
        // Implement the logic for bonding with the player, e.g., increasing player's stats or unlocking new abilities.
    }
}

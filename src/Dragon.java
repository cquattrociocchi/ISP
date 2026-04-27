
public class Dragon {
    private String name; 
    private String colour; 
    private String tail; 
    private boolean bonded = false;
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
        if (nameProb < 0.1) {
            name = "Vyrenthax";
        } else if (nameProb < 0.2) {
            name = "Kaelithor";
        } else if (nameProb < 0.3) {
            name = "Zaryndra";
        } else if (nameProb < 0.4) {
            name = "Thraxxion";
        } else if (nameProb < 0.5) {
            name = "Nyserath";
        } else if (nameProb < 0.6) {
            name = "Vaelgorin";
        } else if (nameProb < 0.7) {
            name = "Xandryth";
        } else if (nameProb < 0.8) {
            name = "Pyravex";
        } else if (nameProb < 0.9) {
            name = "Drakthira";
        } else {
            name = "Morvanyx";
        }
    
        
    }
    public String getName() {
        return name;
    }   
    public String getTail(){
        return tail;
    }
    public String getColour() {
        return colour;
    }

    
    public void bondWithPlayer(Player player) {
        if (bonded){

            if (colour.substring(0,1).indexOf("aeiou") >= 0) {
                System.out.println("Your dragon, " + name + ", an " + colour + " " + tail + " is already bonded with you.");
            } else {
                System.out.println("Your dragon, " + name + ", a " + colour + " " + tail + " is already bonded with you.");
            }
            return;
        }

        bonded = true;


        
        System.out.println("The " + colour + " " + tail + " lowers its head. " + name + " has bonded with you!");

        
        player.addPoints(100); 
        
    }
}

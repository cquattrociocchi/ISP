import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Room {
    private String id;
    private String name;
    private String description;
    private Map<String, String> exits; // direction → roomId
    private List<Item> items;
    private List<Person> people;
    private Dragon dragon;
    private boolean dragonAnnounced = false;
    private boolean dragonSpawned = false;
    private Player player;

    public Room(String id, String name, String description, Map<String, String> exits, List<Item> items, List<Person> people, Player player) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.exits = exits;
        this.items = items;
        this.people = people;
        this.player = player;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return description;
    }

    public Map<String, String> getExits() {
        return exits;
    }

    public List<Item> getItems() {
        return items;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getLongDescription(Map<String, Room> rooms) {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(".\n");
        System.out.println();

        String finalDescription = description; 
            if (this.id.equals("threshing_grounds8") && !dragonSpawned && dragon==null) {
                dragon = new Dragon();
                dragonSpawned = true;
            }
            if (dragon != null && this.id.equals("threshing_grounds8") && !dragonAnnounced) {
                String dragonDescription = " A " + dragon.getColour() + " " + dragon.getTail() + " flies toward you."; 
                 if (dragon.getColour().substring(0,1).indexOf("aeiou") >= 0) {
                     dragonDescription = " An " + dragon.getColour() + " " + dragon.getTail() + " flies toward you."; 
            }


                finalDescription += finalDescription.replace("{{DRAGON}}", dragonDescription);
                dragonAnnounced = true;
            }

            if (this.id.equals("flight_field") && player.getPoints() < 200){
                //id = previousRoomId; 
                finalDescription = "You need 200 points to enter the flight field.";
            }

            sb.append(finalDescription).append("\n");



        if (!items.isEmpty()) {
            sb.append("You see ");
            String vowels = "aeiou";
            for (int i = 0; i < items.size(); i++) {
                if (i > 0 && i == items.size() - 1)
                    sb.append("and ");

                if (vowels.indexOf(items.get(i).getName().substring(0, 1)) >= 0)
                    sb.append("an ");
                else
                    sb.append("a ");
                
                sb.append(items.get(i).getName()).append(", ");
            }
            // Remove trailing comma and space
            sb.setLength(sb.length() - 2);
            sb.append(".\n");

            

            
        }

        if (!people.isEmpty()) {
            for (int i = 0; i < people.size(); i++) {
                sb.append(people.get(i).getDescription()).append("\n");
            }
        }

        if (!exits.isEmpty()) {
            sb.append("You can go ");
            List<String> keys = new ArrayList<>(exits.keySet());
            for (int i = 0; i < keys.size(); i++) {
                String direction = keys.get(i);

                if (i > 0 && i == keys.size() - 1)
                    sb.append("or ");

                sb.append(direction);
                sb.append(" to the ");
                    Room neighbor = rooms.get(exits.get(direction));  // new
                if (neighbor != null) {                           // new
                    sb.append(neighbor.getName());                // new
                } else {                                          // new
                    sb.append(exits.get(direction));              // new
                }                                                 // new
                sb.append(", ");
            }
            sb.setLength(sb.length() - 2);

            
        }
        return sb.toString();
    }

    // public void spawnDragon(){
    //     if (this.id.equals("threshing_grounds8") && dragon == null){
    //         dragon = new Dragon();
    //         dragonSpawned = true;
    //     }
    // }

    public Dragon getDragon() {
        return dragon;
        }
    }
    


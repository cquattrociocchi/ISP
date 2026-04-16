import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Room {
    private String id;
    private String name;
    private String description;
    private Map<String, String> exits; // direction → roomId
    private List<Item> items;

    public Room(String id, String name, String description, Map<String, String> exits, List<Item> items) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.exits = exits;
        this.items = items;
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

    public String getLongDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        System.out.println();
        sb.append(description).append("\n");

        if (!items.isEmpty()) {
            sb.append("You see ");
            String vowels = "aeiou";
            for (int i = 0; i < items.size(); i++) {
                if (i == items.size() - 1)
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

        if (!exits.isEmpty()) {
            sb.append("You can go ");
            List<String> keys = new ArrayList<>(exits.keySet());
            for (int i = 0; i < keys.size(); i++) {
                String direction = keys.get(i);

                if (i == keys.size() - 1)
                    sb.append("and ");

                sb.append(direction);
                sb.append(" to the ");
                sb.append(exits.get(direction));
                sb.append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append(".\n");
        }

        return sb.toString();
    }
}

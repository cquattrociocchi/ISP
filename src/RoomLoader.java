import java.io.FileReader;
import java.util.*;
import com.google.gson.*;

public class RoomLoader {
    private Player player;

    public Map<String, Room> loadRooms(String filePath) {
        Map<String, Room> rooms = new HashMap<>();
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(new FileReader(filePath), JsonObject.class);

            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                String roomId = entry.getKey();
                JsonObject roomData = entry.getValue().getAsJsonObject();

                String name = roomData.get("name").getAsString();
                String description = roomData.get("description").getAsString();

                Map<String, String> exits = new HashMap<>();
                JsonObject exitsJson = roomData.getAsJsonObject("exits");
                for (Map.Entry<String, JsonElement> exit : exitsJson.entrySet()) {
                    exits.put(exit.getKey(), exit.getValue().getAsString());
                }

                List<Item> items = new ArrayList<>();
                JsonArray itemsJson = roomData.getAsJsonArray("items");
                for (JsonElement itemElement : itemsJson) {
                    JsonObject itemObj = itemElement.getAsJsonObject();
                    String itemId = itemObj.get("id").getAsString();
                    String itemName = itemObj.get("name").getAsString();
                    String itemDescription = itemObj.get("description").getAsString();
                    String itemType;
                if (itemObj.has("type")) {
                    itemType = itemObj.get("type").getAsString();
                } else {
                    itemType = "";
                }

                int itemPointValue;
                if (itemObj.has("pointValue")) {
                itemPointValue = itemObj.get("pointValue").getAsInt();
                } else {
                    itemPointValue = 0;
                }

                items.add(new Item(itemId, itemName, itemDescription, itemType, itemPointValue, 0));
                }

                List<Person> people = new ArrayList<>();
                JsonArray peopleJson = roomData.getAsJsonArray("people");
                if (peopleJson != null) {
                for (JsonElement personElement : peopleJson) {
                    JsonObject personObj = personElement.getAsJsonObject();
                    String personId = personObj.get("id").getAsString();
                    String personName = personObj.get("name").getAsString();
                    String personDescription = personObj.get("description").getAsString();
                    String personType = personObj.get("type").getAsString();
                    int personHealth = personObj.get("health").getAsInt();
                    String personSignet = personObj.get("signet").getAsString();
                    int personAttackValue = personObj.get("attackValue").getAsInt();
                    String personGreeting = personObj.get("greeting").getAsString();
                    String personDeathMessage = personObj.get("deathMessage").getAsString();

                    people.add(new Person(personId, personName, personDescription, personType, personHealth, 
                                            personSignet, personAttackValue, personGreeting, personDeathMessage));
                        
                }

                


            }

                Room room = new Room(roomId, name, description, exits, items, people);
                rooms.put(roomId, room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }
}

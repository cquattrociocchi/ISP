import java.util.List;
import java.util.Map;

public class CommandParser {
    

    public void parse(String input, Player player, Map<String, Room> rooms) {
        String[] words = input.trim().toLowerCase().split("\\s+");
        if (words[0].isEmpty()) {
            System.out.println("Please enter a command.");
            return;
        }

        

        String command = words[0];

        switch (command) {

            case "go":
                if (words.length < 2) {
                    System.out.println("Go where?");
                } else {
                    String direction = words[1];
                    Room currentRoom = rooms.get(player.getCurrentRoomId());
                    String nextRoomId = currentRoom.getExits().get(direction);
                    if (nextRoomId != null) {
                        player.setCurrentRoomId(nextRoomId);
                        System.out.println("You move " + direction + ".");
                        currentRoom = rooms.get(player.getCurrentRoomId());
                        System.out.println(currentRoom.getLongDescription(rooms));

                    } else {
                        System.out.println("You can't go that way.");
                    }
                }
                break;
            case "look":
                Room currentRoom = rooms.get(player.getCurrentRoomId());
                System.out.println(currentRoom.getLongDescription(rooms));
                break;
            case "inventory":
                if (player.getInventory().isEmpty()) {
                    System.out.println("Your inventory is empty.");
                } else {
                    System.out.println("You are carrying:");
                    for (Item item : player.getInventory()) {
                        System.out.println("- " + item.getName());
                    }
                }
                break;
            case "take":
                if (words.length < 2) {
                    System.out.println("Take what?");
                } else {
                    String itemName = input.substring(input.indexOf(" ") + 1);
                    Room room = rooms.get(player.getCurrentRoomId());
                    Item itemToTake = null;
                    for (Item item : room.getItems()) {
                        if (item.getName().equalsIgnoreCase(itemName)) {
                            itemToTake = item;
                            break;
                        }
                        for (String nickname : item.getNicknames()) {
                            if (nickname.equalsIgnoreCase(itemName)) {
                                itemToTake = item;
                                break;
                            }
                        }
                        if (itemToTake != null) break;
                    }
                    if (itemToTake != null) {
                        room.removeItem(itemToTake);
                        player.addItem(itemToTake);
                        System.out.println("You take the " + itemToTake.getName() + ".");
                    } else {
                        System.out.println("There is no " + itemName + " here.");
                    }
                }
                break;
            case "drop":
                if (words.length < 2) {
                    System.out.println("Drop what?");
                } else {
                    String itemName = words[1];
                    Item itemToDrop = null;
                    for (Item item : player.getInventory()) {
                        if (item.getName().equalsIgnoreCase(itemName)) {
                            itemToDrop = item;
                            break;
                        }
                        for (String nickname : item.getNicknames()) {
                            if (nickname.equalsIgnoreCase(itemName)) {
                                itemToDrop = item;
                                break;
                            }
                        }
                        if (itemToDrop != null) break;
                    }
                    if (itemToDrop != null) {
                        player.removeItem(itemToDrop);
                        Room room = rooms.get(player.getCurrentRoomId());
                        room.addItem(itemToDrop);
                        System.out.println("You drop the " + itemToDrop.getName() + ".");
                    } else {
                        System.out.println("You don't have a " + itemName + ".");
                    }
                }
                break;
            case "help":
                System.out.println("Available commands: go [direction], look, take [item], drop [item], inventory, help");
                break;
            default:
                System.out.println("I don't understand that command.");
                break;

            case "map":
                if (player.getInventory().contains("map")) {
                    //finish later (map supposed to help(?))
                    // add, update and display map points (refer to Points class)
                    // System.out.println("signet in ___ points")
                } else {
                    System.out.println("You don't have a map.");
                }
            break;

            case "north":
                currentRoom = rooms.get(player.getCurrentRoomId());
                String nextRoomId = currentRoom.getExits().get("north");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move north.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }
            break;

            case "south":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("south");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move south.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }
            break;
            

            case "east":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("east");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move east.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }

            break;

            case "west":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("west");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move west.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }

            break; 


            case "down":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("down");
                if (nextRoomId != null && (nextRoomId.indexOf("stair") != -1 || currentRoom.getId().indexOf("trees") != -1)) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You walk down the stairs.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }

            break; 

            case "up":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("up");
                if (nextRoomId != null && (nextRoomId.indexOf("stair") != -1 || nextRoomId.indexOf("trees") != -1)) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You walk up the stairs.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }

            break; 
            
            case " go down":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("down");
                if (nextRoomId != null && (nextRoomId.indexOf("stair") != -1 || currentRoom.getId().indexOf("trees") != -1)) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You walk down the stairs.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }


            break; 

            case " go up":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("up");
                if (nextRoomId != null && (nextRoomId.indexOf("stair") != -1 || nextRoomId.indexOf("trees") != -1)) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You walk up the stairs.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }

            break; 
            
            case "northeast":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("northeast");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move northeast.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }

            break; 

            case "northwest":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("northwest");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move northwest.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }

            break; 

            case "southeast":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("southeast");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move southeast.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }

            break;

            case "southwest":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("southwest");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move southwest.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }

            break;

             case "n":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("north");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move north.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }
            break;

            case "s":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("south");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move south.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }
            break;
            

            case "e":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("east");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move east.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }

            break;

            case "w":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("west");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move west.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }

            break; 

            case "ne":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("northeast");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move northeast.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }

            break; 

            case "nw":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("northwest");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move northwest.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }

            break; 

            case "se":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("southeast");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move southeast.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }

            break;

            case "sw":
                currentRoom = rooms.get(player.getCurrentRoomId());
                nextRoomId = currentRoom.getExits().get("southwest");
                if (nextRoomId != null) {
                    player.setCurrentRoomId(nextRoomId);
                    System.out.println("You move southwest.");
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    System.out.println(currentRoom.getLongDescription(rooms));
                } else {
                    System.out.println("You can't go that way.");
                }

            break;

            case "shortcuts":
                System.out.println("Shortcuts: ");
                System.out.println("- n, s, e, w for north, south, east, west");
                System.out.println("- ne, nw, se, sw for diagonal directions");
                System.out.println("- up/down for stairs");
                break;

            case "exits":
                System.out.println("Exits:");
                currentRoom = rooms.get(player.getCurrentRoomId());
                for (String direction : currentRoom.getExits().keySet()) {
                    System.out.println("- " + direction);
                }
            break;
            
            case "climb":
                if (words.length < 2) {
                    System.out.println("Climb what?");
                } else {
                    String climbDirection = words[1];
                    currentRoom = rooms.get(player.getCurrentRoomId());
                    nextRoomId = currentRoom.getExits().get(climbDirection);
                    if (nextRoomId != null) {
                        player.setCurrentRoomId(nextRoomId);
                        System.out.println("You climb " + climbDirection + ".");
                        currentRoom = rooms.get(player.getCurrentRoomId());
                        System.out.println(currentRoom.getLongDescription(rooms));
                    } else {
                        System.out.println("You can't climb that way.");
                    }
                }
           break;

           case "run": 
           case  "run away": {
            String roomId = player.getCurrentRoomId(); 

            if (roomId.indexOf("threshing") != -1) {
                player.setCurrentRoomId("threshing_grounds1");
                System.out.println("You run back to the threshing entrance, away from the danger.");
            } else{
                player.setCurrentRoomId("ravinne_tunnel2");
                System.out.println("You run as far away as possible, stopping above the ravinne, the river roaring in sync with your racing heartbeat.");
            }

             currentRoom = rooms.get(player.getCurrentRoomId()); 
             System.out.println(currentRoom.getLongDescription(rooms));
             break;
        }

        case "stand":
        case "stay":    
        case "stand ground": {
            System.out.println("You stand your ground, trying to remain calm and composed in the face of danger.");
            break;
        }
            
            case "approach":
                System.out.println("You cautiously approach, trying to appear non-threatening.");
            break;
            
            case "hide":
                String roomId = player.getCurrentRoomId();
                if (roomId.indexOf("threshing") != -1) {
                    player.setCurrentRoomId("threshing_grounds6");
                    System.out.println("You quickly hide behind the pile of wood, trying to stay out of sight.");
                } else {
                    player.setCurrentRoomId("dorm_stairwell");
                    System.out.println("You quickly slip into the dorm stairwell, hidden by the dark shadows that cling to the walls.");
                }

                currentRoom = rooms.get(player.getCurrentRoomId()); 
                System.out.println(currentRoom.getLongDescription(rooms));
                break;

            
            case "use": 
                if (words.length < 2){
                    System.out.println("Use what?");
                    break;
                }

                else {
                    String itemName = input.substring(input.indexOf(" ") + 1);
                    Room room = rooms.get(player.getCurrentRoomId());
                    Item itemToUse = null;
                    for (Item item : player.getInventory()) {
                        if (item.getName().equalsIgnoreCase(itemName)) {
                            itemToUse = item;
                            break;
                        }
                        for (String nickname : item.getNicknames()) {
                            if (nickname.equalsIgnoreCase(itemName)) {
                                itemToUse = item;
                                break;
                            }
                        }
                        if (itemToUse != null) break;
                    }
                    
                    if (itemToUse != null) {
                        for (Item item : player.getInventory()) {
                            if (item.getName().equalsIgnoreCase(itemName)) {
                                itemToUse = item;
                                break;
                            }
                        }
                    }

                    if (itemToUse == null){
                        System.out.println("There is no " + itemName + " here or in your inventory.");
                        break;
                    }
                    if (itemToUse.getType().equals("attack")) {
                        System.out.println("Attack who with " + itemToUse.getName());
                        break;

                
                    } else if (itemToUse.getType().equals("healing")) {
                        itemToUse.useHealingItem(player, itemToUse);
                        break;
                    } else if (itemToUse.getType().equals("riddle")) {
                        itemToUse.riddle(room, player); 
                        break;
                    } else if (itemToUse.getType().equals("utility")) {
                        itemToUse.useUtilityItem(player, itemToUse);
                        break;
                    }

                    else {
                        System.out.println("You can't use the " + itemToUse.getName() + ".");
                    }
                    }
                    
            

        

        case "attack":
            if (words.length < 3) {
                    System.out.println("Attack who? Type: attack [person] [item]");
                    break;
            }

            Room room = rooms.get(player.getCurrentRoomId()); 

            String inputWithoutAttack = input.substring(7).trim(); 

            Item itemToUse = null; 
            String itemName = ""; 

            for (Item item : player.getInventory()) {
                if (inputWithoutAttack.toLowerCase().endsWith(item.getName().toLowerCase())){
                    itemToUse = item;
                    itemName = item.getName(); 
                    break; 
                }
            }

            if (itemToUse == null){
                System.out.println("You don't have that item.");
                break;
            }

            String targetName = inputWithoutAttack.substring(0, inputWithoutAttack.length() - itemName.length()).trim(); 

            if (targetName.isEmpty()){
                System.out.println("Attack who?");
                break;
            }

            Person target = null;
            for (Person p : room.getPeople()){
                if (p.getName().equalsIgnoreCase(targetName)){
                    target = p; 
                    break;
                }
            }


            if (target == null){
                System.out.println(targetName + " is not in the room.");
                break;
            }

            
           

            itemToUse.useAttackItem(player, itemToUse, target, room); 
            break; 

            
            
            case "lantern": {
                if (words.length < 2){
                    System.out.println("Use: lantern on/off");
                    break;
                }

                if (words[1].equalsIgnoreCase("on")) {
            player.turnLanternOn();
                }
                else if (words[1].equalsIgnoreCase("off")) {
                    player.turnLanternOff();
                }
                else {
                    System.out.println("Use: lantern on/off");
                }

                break;
            }
         }
           

        player.lanternTimer();

        }

    }
    

    


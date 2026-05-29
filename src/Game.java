import java.util.Map;
import java.util.Scanner;

public class Game {
    private Map<String, Room> rooms;
    private Player player;
    private CommandParser commandParser;

    public Game() {
        RoomLoader roomLoader = new RoomLoader();
        rooms = roomLoader.loadRooms("rooms.json");
        player = new Player("parapet_entrance");
        commandParser = new CommandParser();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println(
                "You stand at the edge of the parapet of Basgiath War College, the wind rising from the canyon below like a warning.\n"
                        + //
                        "They told you this place would break you, that only the strongest survive the Riders Quadrant. Looking ahead, at the narrow parapet stretching over open air, you begin to understand why.\n"
                        + //
                        "Behind you lies the life you knew. Ahead, dragons, death, and a chance at something greater.\n"
                        + //
                        "A bell tolls in the distance.\n" + //
                        "It's time to begin.");
        System.out.println();

        System.out.println("Available commands: look, directions [n/s/e/w], take [item], drop [item], use [item], inventory, stats, help");
        System.out.println();

        System.out.println("What's your name?");
        while (player.getName() == null)
            player.setName(scanner.nextLine());
        System.out.println();

        System.out.println("What's your gender? (m/f/other)");
        while (player.getGender() == null)
            player.setGender(scanner.nextLine());

        Room currentRoom = rooms.get(player.getCurrentRoomId());
        if (currentRoom == null) {
            currentRoom = rooms.get("parapet_entrance");
        }

        System.out.println(currentRoom.getLongDescription(rooms));
        System.out.println(player.getStats());

        while (player.isAlive()) {
            System.out.print("> ");
            String input = scanner.nextLine();
            commandParser.parse(input, player, rooms);

            currentRoom = rooms.get(player.getCurrentRoomId());

            if (player.getPoints() >= 560 && player.isPlayerBonded() && player.getHealth() > 0 && player.getSignetCreated()) {
                System.out.println("Congratulations " + player.getName() + "! You have oficially become an accomlished rider of Basgiath War College.");
                System.out.println("============ FINAL RESULTS ============"); 
                System.out.println("Total points: " + player.getPoints());
                System.out.println("Total health: " + player.getHealth());
                System.out.println("Against impossible odds, you have navigated the complex map, completed all quests, and you have bonded with your dragon and survived the Riders Quadrant. \nYour courage, wits, and determination have earned you a place among Navarre's elite riders. \nThank you for playing!");
                break;
            }
        }

        System.out.println("Game over.");
    }

    public Player getPlayer() {
        return this.player;
    }
    

}

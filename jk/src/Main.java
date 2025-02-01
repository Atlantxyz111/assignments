import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add a sport");
            System.out.println("2. Show all sports");
            System.out.println("3. Update a sport");
            System.out.println("4. Delete a sport");
            System.out.println("5. Add a player");
            System.out.println("6. Update a player's sport");
            System.out.println("7. Delete a player");
            System.out.println("8. Show all players");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the sport: ");
                    String sportName = scanner.nextLine();
                    System.out.print("Enter the description of the sport: ");
                    String sportDescription = scanner.nextLine();
                    SportDAO.addSport(sportName, sportDescription);
                    break;

                case 2:
                    System.out.println("List of all sports:");
                    SportDAO.getAllSports();
                    break;

                case 3:
                    System.out.print("Enter the ID of the sport to update: ");
                    int sportIdToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Clear the buffer
                    System.out.print("Enter the new name of the sport: ");
                    String newSportName = scanner.nextLine();
                    System.out.print("Enter the new description of the sport: ");
                    String newSportDescription = scanner.nextLine();
                    SportDAO.updateSport(sportIdToUpdate, newSportName, newSportDescription);
                    break;

                case 4:
                    System.out.print("Enter the ID of the sport to delete: ");
                    int sportIdToDelete = scanner.nextInt();
                    SportDAO.deleteSport(sportIdToDelete);
                    break;

                case 5:
                    System.out.print("Enter the player's name: ");
                    String playerName = scanner.nextLine();
                    System.out.print("Enter the player's age: ");
                    int playerAge = scanner.nextInt();
                    System.out.print("Enter the sport ID for the player: ");
                    int playerSportId = scanner.nextInt();
                    PlayerDAO.addPlayer(playerName, playerAge, playerSportId);
                    break;

                case 6:
                    System.out.print("Enter the player's ID to update: ");
                    int playerIdToUpdate = scanner.nextInt();
                    System.out.print("Enter the new sport ID for the player: ");
                    int newSportId = scanner.nextInt();
                    PlayerDAO.updatePlayerSport(playerIdToUpdate, newSportId);
                    break;

                case 7:
                    System.out.print("Enter the player's ID to delete: ");
                    int playerIdToDelete = scanner.nextInt();
                    PlayerDAO.deletePlayer(playerIdToDelete);
                    break;
                case 8:
                    System.out.println("List of all players:");
                    PlayerDAO.getAllPlayers();
                    break;

                case 0:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}

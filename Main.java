import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Player player = new Player();

        boolean running = true;

        System.out.println("=================================");
        System.out.println("     TEXT ADVENTURE GAME");
        System.out.println("=================================");
        System.out.println("You wake up in a dark forest.");
        System.out.println("Your goal is to survive and escape.");
        System.out.println();

        while (running && player.isAlive()) {

            System.out.println("---------------------------------");
            System.out.println("Player Health: " + player.health);
            System.out.println("---------------------------------");

            // Display choices
            System.out.println("Choose an action:");
            System.out.println("1. Go Left");
            System.out.println("2. Go Right");
            System.out.println("3. Enter the Cave");
            System.out.println("4. Show Inventory");
            System.out.println("5. Quit");

            System.out.print("Enter choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                input.next();
                System.out.print("Enter choice: ");
            }

            int choice = input.nextInt();

            switch (choice) 
            {

                case 1:
                    System.out.println();
                    System.out.println("You walk down the left path...");
                    System.out.println("A wild enemy attacks!");

                    player.health -= 20;

                    System.out.println("You survived the attack.");
                    System.out.println("Health remaining: " + player.health);
                    System.out.println();
                    break;

                case 2:
                    System.out.println();
                    System.out.println("You walk down the right path...");
                    System.out.println("You found a healing potion!");

                    player.health += 10;

                    System.out.println("Your health increased.");
                    System.out.println("Health: " + player.health);
                    System.out.println();
                    break;

                case 3:
                    System.out.println();
                    System.out.println("You enter the cave...");

                    if (player.health >= 80) {
                        System.out.println("You defeat the cave monster!");
                        System.out.println("YOU WIN!");
                        running = false;
                    } else {
                        System.out.println("The cave monster was too strong.");
                        player.health = 0;
                    }

                    System.out.println();
                    break;

                case 4:
                    System.out.println();
                    player.showInventory();
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Thanks for playing!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Pick 1-5.");
                    System.out.println();
            }
        }

        if (!player.isAlive()) {
            System.out.println("GAME OVER");
        }

        input.close();
    }
}
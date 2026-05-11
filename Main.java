import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Story story = new Story();
        Player player = new Player();
        int rightPathCount = 0;
        boolean running = true;

        System.out.println("=================================");
        System.out.println("     TEXT ADVENTURE GAME");
        System.out.println("=================================");
        System.out.println("You wake up in a dark forest.");
        System.out.println("Your goal is to survive and escape.");
        System.out.println();

        while (running && player.isAlive()) {

            System.out.println("---------------------------------");
            System.out.println("Player Health: " + player.getTotalHealth());
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
                    story.leftPath(player);
                    break;

                case 2:
                    rightPathCount++;
                    story.rightPath(player, rightPathCount, input);
                    break;

                case 3:
                    story.cavePath(player);
                    if (player.health <= 0) {
                        running = false;
                    }else {
                        running = false;
                    }
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
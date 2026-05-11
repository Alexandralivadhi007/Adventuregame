import java.util.Scanner;

public class Story {
    public void leftPath(Player player) {
        System.out.println();
        System.out.println("You take the left path, where the trees twist unnaturally.");
        System.out.println("A dire wolf leaps from the bushes!");

        player.takeDamage(20);

        System.out.println("You slash at the wolf and it retreats into the darkness.");
        System.out.println("You survived, but you're wounded.");
        System.out.println("Health remaining: " + player.health);
        System.out.println();
    }

    public void rightPath(Player player, int rightPathCount, Scanner input) {
        if (rightPathCount == 1) {
             System.out.println();
             System.out.println("You take the right path, where soft blue light glows between the trees.");
             System.out.println("You find a small shrine with a glowing crystal.");

             System.out.println("The crystal pulses and heals your wounds.");
            player.health += 10;

             System.out.println("Health restored! Current health: " + player.health);
            System.out.println();
        }
        else if (rightPathCount == 2) {
            System.out.println("You return to the right path...");
            System.out.println("Behind a fallen tree, you discover a hidden chest!");

            Armor forestArmor = new Armor("Forest Guardian Armor", 25);

            System.out.println("Inside is: " + forestArmor.name);
            System.out.println("It grants +" + forestArmor.bonusHealth + " bonus health.");
            System.out.println("Equip it? (1 = Yes, 2 = No)");

            int choice = input.nextInt();

            if (choice == 1) {
                player.equipArmor(forestArmor);
            } else {
                System.out.println("You leave the armor behind.");
            }

            System.out.println("Total Health: " + player.getTotalHealth());
            System.out.println();
        }else{
            System.out.println("You've already explored this path. Nothing new here.");
            System.out.println();
        }
    }

    public void cavePath(Player player) {
        System.out.println();
        System.out.println("You step into the cave. The air is cold and still.");
        System.out.println("A massive stone guardian awakens, its eyes burning with blue fire.");

        if (player.getTotalHealth() >= 80) {
            System.out.println("You charge forward with all your strength!");
            System.out.println("Your blow cracks the guardian's core.");
            System.out.println("The creature collapses into dust.");
            System.out.println("A warm light fills the cave...");
            System.out.println("YOU HAVE ESCAPED THE FOREST. YOU WIN!");
        } else {
            System.out.println("You try to fight, but the guardian is too strong.");
            System.out.println("Its stone fist slams into you...");
            player.health = 0;
        }

        System.out.println();
    }
}

public class Player extends Character {

    String[] inventory = {Potions, Weapons, Armor};

    public Player(){
        health = 100;
    }
    

    public void showInventory() {
        System.out.println("Inventory:");
        for (int i = 0; i < inventory.length; i++) {
            System.out.println("- " + inventory[i]);
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}
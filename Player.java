public class Player extends Character {

    String[] inventory = {"Potions", "Weapons", "Armor"};
    Armor equippedArmor;
    public Player(){
        health = 100;
    }
    public void equipArmor(Armor armor) {
        equippedArmor = armor;
        System.out.println("You equipped " + armor.name + ". Defense/Health increased by " + armor.bonusHealth);
    }
    public int getTotalHealth() {
        if (equippedArmor != null) {
            return health + equippedArmor.bonusHealth;
        }
        return health;
    }

    public void showInventory() {
        System.out.println("Inventory:");
        for (int i = 0; i < inventory.length; i++) {
            System.out.println("- " + inventory[i]);
        }
    
        if (equippedArmor != null) {
            System.out.println("Equipped Armor: " + equippedArmor.name + " (+" + equippedArmor.bonusHealth + " Health)");
        }
    }

    public boolean isAlive() {
        return getTotalHealth() > 0;
    }
}
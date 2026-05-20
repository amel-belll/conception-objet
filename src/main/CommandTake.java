package main;

// Ajout de "implements ICommand"
public class CommandTake implements ICommand {
    @Override
    public String getVerb() { return "take"; }

    @Override
    public String getDescription() { return "Prend un objet sur le sol (ex: take clé)"; }

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 0) {
            System.out.println("Que voulez-vous prendre ?"); // si pas les arguments complets 
            return;
        }

        String itemName = args[0]; // on stocke le premier mot 
        Item pickedUpItem = player.getPosition().takeItem(itemName); // on prend l'objet et on le remove de la zone

        if (pickedUpItem != null) {
            player.getInventory().addItem(pickedUpItem); // on ajoute l'item à l'inventaire
            System.out.println("Vous avez ramassé : " + pickedUpItem.getName());
        } else {
            System.out.println("Il n'y a pas de '" + itemName + "' ici.");
        }
    }
}
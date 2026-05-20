package main;
import java.util.List;


public class CommandInventory implements ICommand {
    @Override
    public String getVerb() { return "inventory"; }

    @Override
    public String getDescription() { return "Affiche le contenu de votre sac à dos"; }

    @Override
    public void execute(Player player, String[] args) {
        List<Item> items = player.getInventory().getItems();

        if (items.isEmpty()) {
            System.out.println("Votre inventaire est vide.");
        } else {
            System.out.println("\n=== VOTRE INVENTAIRE ===");
            for (Item item : items) {
                // On affiche le nom et la description
                System.out.println("• " + item.getName().toUpperCase() + " : " + item.getDescription());
            }
            System.out.println("========================\n");
        }
    }
}
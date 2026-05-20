package main;
import java.util.List;

public class CommandLook implements ICommand {
    
    @Override
    public String getVerb() { return "look"; }

    @Override
    public String getDescription() { return "Observe les environs et les objets au sol"; }

    @Override
    public void execute(Player player, String[] args) {
        Zone current = player.getPosition(); // stocke la position actuelle
        System.out.println("=== " + current.getName() + " ===");
        System.out.println(current.getDescription());
        
        // Affichage des objets
        List<Item> items = current.getItems();
        if (items != null && !items.isEmpty()) { // liste des items présents dans la zone
            System.out.println("\nObjets présents sur le sol :");
            for (Item i : items) {
                System.out.println("- " + i.getName() + " : " + i.getDescription());
            }
        }

        // Affichage des PNJ
        List<PNJ> pnjs = current.getPNJs();
        if (pnjs != null && !pnjs.isEmpty()) {
            System.out.println("\nPersonnages présents :");
            for (PNJ p : pnjs) {
                System.out.println("- " + p.getName());
            }
        }
    }
}
package main;

public class CommandUse implements ICommand {
    @Override
    public String getVerb() { return "use"; }

    @Override
    public String getDescription() { 
        return "Utilise un objet dans une direction précise (ex: use clé_rouge east)"; 
    }

    @Override
    public void execute(Player player, String[] args) {
        // On vérifie qu'il y a bien deux arguments : l'objet ET la direction
        if (args.length < 2) {
            System.out.println("Usage : use <objet> <direction> (ex: use clé_rouge east)");
            return;
        }

        String itemName = args[0];
        String direction = args[1].toLowerCase();
        Item itemToUse = null;

        // On cherche l'objet dans l'inventaire
        for (Item i : player.getInventory().getItems()) {
            if (i.getName().equalsIgnoreCase(itemName)) {
                itemToUse = i;
                break;
            }
        }

        if (itemToUse == null) {
            System.out.println("Vous n'avez pas de '" + itemName + "' dans votre inventaire.");
            return;
        }

        // On regarde les coordonnées de la zone ciblée selon la direction
        int targetX = player.getX();
        int targetY = player.getY();

        switch (direction) {
            case "north":
            case "n":
                targetY--;
                break;
            case "south":
            case "s":
                targetY++;
                break;
            case "east":
            case "e":
                targetX++;
                break;
            case "west":
            case "w":
                targetX--;
                break;
            default:
                System.out.println("Direction inconnue ('" + direction + "'). Utilisez : north, south, east ou west.");
                return; // on vérifie la direction qui existe
        }

        //On récupère la zone spécifique et on tente de l'ouvrir
        WorldMap map = player.getMap();
        Zone targetZone = map.getZone(targetX, targetY);

        if (targetZone == null) {
            System.out.println("Il n'y a rien dans cette direction.");
            return;
        }

        if (targetZone.isOpen()) {
            System.out.println("La zone vers le/la " + direction + " est déjà ouverte !");
            return;
        }

        // Tentative de déverrouillage sur la zone choisie
        String resultat = targetZone.tryUnlock(itemToUse.getCode());

        if (resultat.contains("Succès")) {
            System.out.println(resultat);
            
            // On déplace le joueur automatiquement
            player.setPosition(targetX, targetY);
            System.out.println("\nVous avancez automatiquement à l'intérieur...");
            
            // On retire la clé de l'inventaire
            player.getInventory().removeItem(itemToUse);
            System.out.println("(- Vous n'avez plus  " + itemToUse.getName() + " dans votre inventaire.)");

            System.out.println("=== " + targetZone.getName() + " ===");
            System.out.println(targetZone.getDescription());
            
        } else {
            System.out.println("Ça ne fonctionne pas. Ce n'est peut-être pas la bonne clé...");
        }
    }
}
    
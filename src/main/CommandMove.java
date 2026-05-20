package main;

public class CommandMove implements ICommand {
    @Override
    public String getVerb() { return "move"; }

    @Override
    public String getDescription() { return "Se déplacer (ex: move north, south, east, west)"; }

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 0) {
            System.out.println("Aller où ? (north, south, east, west)");
            return;
        }

        int targetX = player.getX(); // on prend les infos du joueur piur tester le déplacement
        int targetY = player.getY();

        switch (args[0].toLowerCase()) {
            case "north": targetY--; break; // on monte 
            case "south": targetY++; break; // on descend 
            case "east":  targetX++; break; // à droite 
            case "west":  targetX--; break; // à gauche
            default: System.out.println("Direction inconnue."); return;
        }

        Zone targetZone = player.getMap().getZone(targetX, targetY); // prédire la zone du joueur après déplacement

        if (targetZone == null) {
            System.out.println("Il n'y a rien dans cette direction.");
        } else if (!targetZone.isOpen()) {
            System.out.println("La porte est verrouillée.");
        } else {
            player.setPosition(targetX, targetY); // on met à jour les coordonnées du joueur
            System.out.println("Vous vous déplacez vers : " + targetZone.getName());
            System.out.println(targetZone.getDescription());
        }
    }
}
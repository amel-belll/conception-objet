package main;

public class CommandGive implements ICommand {
    @Override
    public String getVerb() { return "give"; }

    @Override
    public String getDescription() { return "Donne un objet à un personnage (ex: give pomme garde)"; }

    @Override
    public void execute(Player player, String[] args) {
        if (args.length < 2) {
            System.out.println("Précisez l'objet et le personnage (ex: give poisson vieux)");
            return;
        }

        String itemName = args[0];// on stocke l'item que l'utilisateur montre
        String pnjName = args[1];

        Item itemToGive = null;
        for (Item i : player.getInventory().getItems()) { // on regarde dans l'inventaire 
            if (i.getName().equalsIgnoreCase(itemName)) {
                itemToGive = i; // si l'item est trouvé dans l'inventaire on le stocke dans celui à montrer 
                break;
            }
        }

        if (itemToGive == null) {
            System.out.println("Vous n'avez pas de '" + itemName + "' dans votre inventaire.");
            return;
        }

        PNJ pnj = player.getPosition().getPNJ(pnjName);
        if (pnj == null) {
            System.out.println("Il n'y a pas de '" + pnjName + "' ici.");
            return; // si give à un autre personnage pas ici 
        }


        System.out.println("Vous montrez " + itemToGive.getName() + " à " + pnj.getName() + ".");
        Item reward = pnj.receiveItemReaction(itemToGive); // la réaction du PNJ à l'objet

        if (reward != null) {
            System.out.println(pnj.getName() + " dit : \"C'est exactement ce que je voulais !\"");
            System.out.println("🎁 " + pnj.getName() + " vous donne : " + reward.getName());
            
            // On ajoute la récompense
            player.getInventory().addItem(reward);
            
            // On retire l'objet qu'on vient de donner
            player.getInventory().removeItem(itemToGive);
            System.out.println("(- Vous avez perdu : " + itemToGive.getName() + ")");
        } else {
            System.out.println(pnj.getName() + " regarde l'objet sans grand intérêt.");
        }
    }
}
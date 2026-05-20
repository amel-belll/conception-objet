package main;

public class CommandTalk implements ICommand {
    
    @Override
    public String getVerb() { return "talk"; }

    @Override
    public String getDescription() { return "Parle à un personnage (ex: talk vieux)"; }

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 0) {
            System.out.println("À qui voulez-vous parler ? (ex: talk vieux)"); // on prend 2 paramètres en compte
            return;
        }

        String pnjName = args[0];
        PNJ pnj = player.getPosition().getPNJ(pnjName); // on compare la zone du joueur et si on peut parler au PNJ

        if (pnj != null) {
            // Il dit son dialogue
            System.out.println(pnj.getName() + " dit : \"" + pnj.getDialogue() + "\"");
            
            // sinon y'a pas 
        } else {
            System.out.println("Il n'y a pas de '" + pnjName + "' ici.");
        }
    }
}
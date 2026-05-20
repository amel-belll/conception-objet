package main;

public interface ICommand {
    String getVerb(); // retourner le verbe de la commande et quel mot clé à écrire dans le terminal
    String getDescription(); // description associée à la commande dans "help"
    void execute(Player player, String[] args); // on prend player en parametre pour donner l'accès à la commande
}
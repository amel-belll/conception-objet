package main;

public class CommandHelp implements ICommand {
    private CommandRegistry registry;

    public CommandHelp(CommandRegistry registry) {
        this.registry = registry;
    }

    @Override
    public String getVerb() { return "help"; }

    @Override
    public String getDescription() { return "Affiche la liste des commandes disponibles"; }

    @Override
    public void execute(Player player, String[] args) {
        System.out.println("\n=== COMMANDES DISPONIBLES ===");
        for (ICommand cmd : registry.getAllCommands()) { // tableau pour faire le tour des commandes et les afficher
            System.out.println("- " + cmd.getVerb() + " : " + cmd.getDescription());
        }
    }
}
package main;
import java.util.HashMap;
import java.util.Collection;

public class CommandRegistry {
    private HashMap<String, ICommand> commands = new HashMap<>(); // on associe le verbe à la commande

    public void register(ICommand command) {
        commands.put(command.getVerb(), command);
    }

    public ICommand getCommand(String verb) { // lance la commande a partir du verbe donné
        return commands.get(verb);
    }

    public Collection<ICommand> getAllCommands() {
        return commands.values(); // on liste les commandes
    }
}
package main;
import utils.Array2Dprinter;

public class CommandMap implements ICommand {
    @Override
    public String getVerb() { return "map"; } 

    @Override
    public String getDescription() { return "Affiche la carte du monde"; } // 

    @Override
    public void execute(Player player, String[] args) {
        System.out.println("\nCarte du monde :");
        System.out.println(Array2Dprinter.print2DArray(player.getMap().getGrid(), player.getY(), player.getX()));
    }
}
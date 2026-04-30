
package main;
import utils.IPrintable;
import utils.Array2Dprinter;

public abstract class Zones implements IPrintable {
    private String name; 
    private String description;
    private boolean isOpen;
    public Zones (String name, String description, boolean isOpen, boolean isValid){
        this.name = name;
        this.description = description;
        this.isOpen = isOpen;

    }

    public String getName () {
        return name;
    }
     public String getDescription () {
        return description;
    }
     public boolean getisOpen () {
        return isOpen;
    }

    public void ZoneInfo() {
        if (isOpen) {
            System.out.println(description);
        } else {
            System.out.println("Zone locked");
        }

}
}

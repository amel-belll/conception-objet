package main;
import utils.IPrintable;
import java.util.ArrayList;
import java.util.List;

public class Zone implements IPrintable {
    private String name; 
    private String description;
    private boolean isOpen;
    private String requiredCode;
    private List<Item> items;
    private List<PNJ> pnjs; 

    public Zone(String name, String description, boolean isOpen, String requiredCode) {
        this.name = name;
        this.description = description;
        this.isOpen = isOpen;
        this.requiredCode = requiredCode;
        this.items = new ArrayList<>();
        this.pnjs = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isOpen() { return isOpen; }
    public List<Item> getItems() { return items; }

    public List<PNJ> getPNJs() { return pnjs; }
    
    public void addPNJ(PNJ pnj) { 
        this.pnjs.add(pnj); 
    }
    
    public PNJ getPNJ(String name) {
        for (PNJ pnj : pnjs) {
            if (pnj.getName().equalsIgnoreCase(name)) {
                return pnj;
            }
        }
        return null;
    }

    public void addItem(Item item) { this.items.add(item); }

    public Item takeItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }

    public String tryUnlock(String code) {
        if (this.isOpen) return "La zone est déjà ouverte.";
        if (this.requiredCode != null && this.requiredCode.equals(code)) {
            this.isOpen = true; 
            this.description = this.description.replace("verrouillée", "ouverte");

            
            return "Succès ! Vous avez déverrouillé : " + this.name;
        } else {
            return "Ça ne fonctionne pas... Ce n'est pas la bonne clé.";
        }
    }

    @Override
    public String getPrintableString() { return "[ " + this.name.charAt(0) + " ]"; }

    @Override
    public boolean isGrayedOut() { return !isOpen; }
}
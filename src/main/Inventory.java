package main;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) { // ajouter item dans la liste
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public List<Item> getItems() {
        return this.items; // donne la liste des items dans l'inventaire
    }

    public Item getItem(String itemName) {
        for (Item item : this.items) { 
            if (item.getName().equalsIgnoreCase(itemName)) { // prend le nom de l'item, cherche dans l'inventaire et renvoie l'item associé
                return item;
            }
        }
        return null;
    }
}
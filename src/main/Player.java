package main;

public class Player {
    private String name;
    private WorldMap map; // pour intéragir avec la map
    private int x;
    private int y;
    private Inventory inventory;
    

    public String getName() { 
        return name; 
    }

    public void setName(String newName) { 
        this.name = newName; 
    }

    public Player(String name, WorldMap map, int startX, int startY) {
        this.name = name;
        this.map = map;
        this.x = startX;
        this.y = startY;
        this.inventory = new Inventory(); // on fabrique un inventaire vide en même temps que le joueur
    }

    public Zone getPosition() { return map.getZone(x, y); } // ressort la position avec la zone
    public Inventory getInventory() { return inventory; } 

    public void setPosition(int newX, int newY) { // pour changer la position (déplacement)
        this.x = newX;
        this.y = newY;
    }

    // 
    public int getX() { return x; }
    public int getY() { return y; }
    public WorldMap getMap() { return map; }
}
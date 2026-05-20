package main;

public class Item {
    private String name;
    private String description;
    private String unlockCode;

    public Item(String name, String description, String unlockCode) {
        this.name = name;
        this.description = description;
        this.unlockCode = unlockCode;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getUnlockCode() { return unlockCode; }
    public String getCode() {
        return unlockCode; 
    }
}
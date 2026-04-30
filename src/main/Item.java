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
    public String getName(){
        return this.name;
    }
    public void setname (String name){
        this.name = name;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription (String description){
        this.description = description;
    }
     public String getUnlockCode() { return unlockCode; }
    public void setUnlockCode (String unlockCode){
        this.unlockCode = unlockCode;
    }
}
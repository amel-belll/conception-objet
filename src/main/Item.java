package main;
public abstract class Item {
    protected String name;
    protected String description;
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
}
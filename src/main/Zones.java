
package main;
import utils.IPrintable;
import utils.Array2Dprinter;
import java.util.List; 
import java.util.ArrayList;

public class Zones implements IPrintable {
    private String name; 
    private String description;
    private boolean isOpen;
    private String requiredCode;

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

    public String getRequiredCode (){
        return requiredCode;
    }
    public void ZoneInfo() {
        if (isOpen) {
            System.out.println(description);
        } else {
            System.out.println("Zone locked");
        }

    private List <Item> items = new ArrayList<>();


}
// Dans Zones.java
public String tryUnlock(String code) {
    if (this.requiredCode.equals(code)) {
        this.isOpen = true;
        return "You can enter.";
    } else {
        return "This is not the right item.";
    }
}

    @Override
    public String getPrintableString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPrintableString'");
    }

    @Override
    public boolean isGrayedOut() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isGrayedOut'");
    } 
}

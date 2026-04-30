package main;

public class CommandUse {
    public void execute() {
    Item item = player.getInventory().getItem(itemName);
    Zones currentZone = player.getPosition();


    Item item = player.getInventory().getItem(itemName);
    if (item == null) {
        System.out.println("You don't have that item.");
        return;
    }
    String result = player.getPosition().tryUnlock(item.getUnlockCode());
    System.out.println(result);
}
}


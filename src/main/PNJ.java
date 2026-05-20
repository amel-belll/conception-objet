package main;

public class PNJ {
    private String name;
    private String dialogue;
    private Item heldItem;
    private boolean hasGivenItem;
    
    // Le PNJ attend un code secret spécifique (ex: "QUEST_FISH")
    private String expectedCode; 

    public PNJ(String name, String dialogue, Item heldItem, String expectedCode) {
        this.name = name;
        this.dialogue = dialogue;
        this.heldItem = heldItem;
        this.expectedCode = expectedCode;
        this.hasGivenItem = false;
    }

    public String getName() { return name; }
    public String getDialogue() { return dialogue; }

    public Item receiveItemReaction(Item itemShown) {
        if (heldItem != null && !hasGivenItem) {
            // On compare le code de l'objet avec le code attendu par le PNJ
            if (expectedCode != null && expectedCode.equals(itemShown.getCode())) {
                hasGivenItem = true;
                return heldItem;
            }
        }
        return null;
    }
}
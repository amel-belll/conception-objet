package main;

import java.util.Scanner;

public class Game {
    private Player player;
    private CommandRegistry registry;
    private boolean isRunning;

    public Game() {
        this.registry = new CommandRegistry();
        this.isRunning = true;
        initCommands(); // méthodes de préparation 
        initMap();
    }

    private void initCommands() { 
        // Enregistre toutes les commandes, on crée toutes les commandes à chaque fois qu'on run le jeu
        registry.register(new CommandHelp(registry)); 
        registry.register(new CommandMove());
        registry.register(new CommandTake());
        registry.register(new CommandLook());
        registry.register(new CommandInventory());
        registry.register(new CommandUse());
        registry.register(new CommandMap());
        registry.register(new CommandTalk());
        registry.register(new CommandGive());
    }

    private void initMap() {
        //Création de la carte de 4x4 (9 cases)
        WorldMap map = new WorldMap(4, 4);
        //Création des zones
        Zone village = new Zone("Place du Village", "Le centre du village. Vous êtes en sécurité ici.", true, null);
        Zone riviere = new Zone("Rivière", "Une rivière bleue et paisible", true, null);
        Zone foret = new Zone("Forêt sauvage", "Faites attention à vos pieds", true, null);
        Zone chateau = new Zone("Château terrifiant", "Le château est abrité de fantômes", false, "KEY_BLUE");
        Zone grotte = new Zone("Grotte qui pue", "Ici, c'est sombre et humide", true, null);
        Zone desert = new Zone("Désert sec et vide", "On s'ennuie à mourrir dans le désert", true, null);
        Zone volcan = new Zone("Volcan en pétard", "The floor is lava", true, null);
        Zone jungle = new Zone("Jungle intrépide", "Welcome to the Jungle", true, null);
        Zone temple = new Zone("Temple vénimeux", "Évitez les pièges", false, "KEY_GREEN");
        Zone labyrinthe = new Zone("Labyrinthe infernal", "Ne vous perdez pas 😜", false, "KEY_ORANGE");
        Zone ile = new Zone("Île perdue", "Vous êtes loin de tout", true, null);
        Zone marais = new Zone("Marais dégoutant", "Vous avez de la chance, Shrek est parti en vacances", true, null);

        //on commence d'en haut à gauche par convention (0;0)
        map.setZone(2, 1, village);
        map.setZone(3, 1, foret);   // Nord
        map.setZone(2, 0, riviere); // Sud
        map.setZone(3, 2, chateau);
        map.setZone(2, 2, grotte);
        map.setZone(2, 3, desert);
        map.setZone(1, 1, volcan);
        map.setZone(1, 2, jungle);
        map.setZone(1, 3, temple);
        map.setZone(0, 0, labyrinthe);
        map.setZone(0, 1, ile);
        map.setZone(0, 2, marais);


        // Ajout des objets sur le sol
        labyrinthe.addItem(new Item("Toyota_Aygo", "Pour vos road trips", null));
        ile.addItem(new Item("clé_bleue", "Une clé rouillée", "KEY_BLUE"));
        marais.addItem(new Item("ciao_kombucha", "Une boisson rafraîchissante", "CIAO01"));
        jungle.addItem(new Item("fourchette", "Bon appétit", "FOURCHETTE01"));
        riviere.addItem(new Item("poisson", "Un poisson appétissant", null));
        village.addItem(new Item("pomme", "Une belle pomme rouge", null));
        chateau.addItem(new Item("épée", "Une épée saillante", "EPEE01"));


        // Ajout des PNJ avec leurs quêtes
        PNJ dragon = new PNJ("dragon", "J'ai tellement soif... Si seulement quelqu'un m'apportait une bonne boisson...", 
                            new Item("lunettes", "Une paire de lunettes de soleil", null), 
                            "CIAO01");
        volcan.addPNJ(dragon);

        PNJ aventuriere = new PNJ("aventuriere", "Je n'ai plus d'arme pour finir mon aventure.", 
                            new Item("clé_orange", "Une clé en fer", "KEY_ORANGE"), 
                            "EPEE01");
        temple.addPNJ(aventuriere);

        PNJ neandertal = new PNJ("neandertal", "RWAHHHHHHH...", null, null);
        grotte.addPNJ(neandertal);

        PNJ fou = new PNJ("fou", "Je cherche quelque chose pour me gratter les pieds", 
                            new Item("clé_verte", "Une clé mouillée", "KEY_GREEN"), 
                            "FOURCHETTE01");
        foret.addPNJ(fou);
        
        PNJ fee = new PNJ("fée clochette", "J'adore Peter Pan", null, null);
        riviere.addPNJ(fee);

        //On place le joueur au centre
        player = new Player("Aventurier", map, 2, 1);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in); // lire ce que le joueur fait
        System.out.println("Initialisation du monde...");
        System.out.println("\n========== BIENVENUE DANS L'AVENTURE ==========");

        System.out.print("Quel est votre prénom, vaillant(e) héros / héroïne ?\n> ");
        String playerName = scanner.nextLine().trim(); // On lit ce que le joueur tape
        
        if (!playerName.isEmpty()) {
            player.setName(playerName);
        }
        
        System.out.println("\nTrès bien, " + player.getName() + " ! Votre quête commence...");


        System.out.println("Vous êtes à : " + player.getPosition().getName());
        System.out.println("Tapez 'help' pour voir ce que vous pouvez faire.\n");

        while (isRunning) {
            System.out.print("> ");
            String input = scanner.nextLine().trim(); // supprime les espaces (trim)
            
            if (input.equalsIgnoreCase("quit")) {
                isRunning = false;
                System.out.println("Merci d'avoir joué !");
                break;
            }
            
            if (!input.isEmpty()) {
                String[] parts = input.split(" "); // transforme les mots du joueur en tableau
                String verb = parts[0];
                String[] args = new String[parts.length - 1];
                System.arraycopy(parts, 1, args, 0, parts.length - 1);

                ICommand command = registry.getCommand(verb); // on trouve la commande associée au verbe et on l'execute
                if (command != null) {
                    command.execute(player, args);
                } else {
                    System.out.println("Commande inconnue. Tapez 'help' pour la liste des commandes.");
                }
            }
        }
        scanner.close();
    }
}
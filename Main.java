//LIRE LE README.md S'il vous plait.
//J'y ai détaillé de nombreux choix de conceptions

public class Main {

    public static void main(String[] args) {

        //Création de l'armée des gentils avec une sous-armée pour vérifier que le pattern composite fonctionne 
        Army armyGood = new Army();
        Army subArmyGood = new Army();
        ProxyFantassin Achille = new ProxyFantassin(700);
        ProxyFantassin Patroclus = new ProxyFantassin(100);

        subArmyGood.add(Achille);
        subArmyGood.add(Patroclus);

        for (int i =0; i< 10;i++){
            armyGood.add(new ProxyCavalier(10));
        }
        //Ajout d'armes aux membres de l'armée des gentils
        subArmyGood.addLance();
        //On ajoute la sous armée à l'armée principale
        armyGood.add(subArmyGood);
        //Enfin on ajoute un bouclier à toute l'armée, même Achille et Patroclus
        armyGood.addShield();
        
        //Création de l'armée des méchants
        Army armyEvil = new Army();
        Army subArmyEvil = new Army();
        
        for (int i =0; i< 8;i++){
            armyEvil.add(new ProxyCavalier(10));
            subArmyEvil.add(new ProxyFantassin(10));
        }
        ProxyCavalier Hector = new ProxyCavalier(150);
        armyEvil.add(Hector);
        //Ajout d'armes aux membres de l'armée des méchants
        subArmyEvil.addLance();
        armyEvil.addLance();
        //On ajoute la sous armée à l'armée principale
        armyEvil.add(subArmyEvil);

        //Création des deux visiteurs
        Visitor visitorPrint = new VisitorPrint();
        Visitor visitorCount = new VisitorCount();

        //Affichage des membres des deux armées
        armyGood.accept(visitorPrint);
        armyEvil.accept(visitorPrint);

        //Comptage des deux armées
        armyGood.accept(visitorCount);
        visitorCount.report();
        visitorCount.reset();
        
        armyEvil.accept(visitorCount);
        visitorCount.report();
        visitorCount.reset();

        int ncoups = 0;
        boolean vc = true;
        boolean vf = true;
        
        
        // LA BASTON 

        while(vf && vc){
            vc = armyEvil.parer(armyGood.force());
            vf = armyGood.parer(armyEvil.force());
            ncoups++;
        }
        System.out.println((vf ? "Les gentils ont gagné" : "Les gentils ont perdu") + " en " + ncoups + " coups.");

        //Si on recompte les deux armées après le combat on constate bien que l'une est vide car exterminée par l'autre
        armyGood.accept(visitorCount);
        visitorCount.report();
        visitorCount.reset();
        
        armyEvil.accept(visitorCount);
        visitorCount.report();
        visitorCount.reset();
        //Patroclus est mort (probablement tué par Hector) et Achille est très triste
    }
}
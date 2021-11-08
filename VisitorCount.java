class VisitorCount implements Visitor{

    int fanCount = 0;
    int cavCount = 0;
    //On appelle la méthode récursivement pour tout noeud de l'arbre cette méthode;
    public void visitArmy(Army army){
        for (SoldatWithWeapon soldier :army.troops){
            soldier.accept(this);
        }
    }
    public void visitSoldier(SoldatWithWeapon soldier){
        
    }
    //On traite ici les feuilles de l'arborescence;
    public void visitCavalier(ProxyCavalier cavalier){
        cavCount++;
    }
    public void visitFantassin(ProxyFantassin fantassin){
        fanCount++;

    }
    //Méthode pour obtenir le résultat dans la console;
    public void report(){
        System.out.print("Il y à " + fanCount + " Fantassins et " + cavCount + " Cavaliers dans cette armée \n");
    }
    //Méthode pour remettre les compteurs à 0, si l'on veux compter une nouvelle armée avec le même visiteur;
    public void reset(){
        fanCount = 0;
        cavCount = 0;
    }

}
class VisitorPrint implements Visitor{

    //On appelle récursivement la méthode sur tout les noeuds de l'arbre;
    public void visitArmy(Army army){
        for (SoldatWithWeapon soldier :army.troops){
            soldier.accept(this);
        }
    }
    public void visitSoldier(SoldatWithWeapon soldier){
        System.out.println(soldier);
    }
    //On traite ici le cas des feuilles qui renvoient leurs méthodes toString(), modifiées pour renvoyer "Fantassin" ou "Cavalier"
    public void visitCavalier(ProxyCavalier cavalier){
        System.out.println(cavalier);
    }
    public void visitFantassin(ProxyFantassin fantassin){
        System.out.println(fantassin);
    }
    //Les prints parlent d'eux même je pense...
    public void report(){
        System.out.println("T'es complètement maboul ma parole, ya rien à report ici");
    }

    public void reset(){
        System.out.println("T'es complètement maboul ma parole, ya rien à reset ici");
    }
}
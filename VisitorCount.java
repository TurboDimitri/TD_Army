class VisitorCount implements Visitor{

    int fanCount = 0;
    int cavCount = 0;

    public void visitArmy(Army army){
        for (SoldatWithWeapon soldier :army.troops){
            soldier.accept(this);
        }
    }
    public void visitSoldier(SoldatWithWeapon soldier){
        
    }

    public void visitCavalier(ProxyCavalier cavalier){
        cavCount++;
    }
    public void visitFantassin(ProxyFantassin fantassin){
        fanCount++;

    }
    public void report(){
        System.out.print("Il y à " + fanCount + " Fantassins et " + cavCount + " Cavaliers dans cette armée \n");
    }
    public void reset(){
        fanCount = 0;
        cavCount = 0;
    }

}
class VisitorPrint implements Visitor{

    int count = 0;

    public void visitArmy(Army army){
        for (SoldatWithWeapon soldier :army.troops){
            soldier.accept(this);
        }
    }
    public void visitSoldier(SoldatWithWeapon soldier){
        System.out.println(soldier);
    }

    public void visitCavalier(ProxyCavalier cavalier){
        System.out.println( " " + cavalier);
        count++;
    }
    public void visitFantassin(ProxyFantassin fantassin){
        System.out.println( " " + fantassin);
        count++;
    }
    
    public void report(){
        System.out.println("déso pas de comptage");
    }

    public void reset(){
        count = 0;
    }
}
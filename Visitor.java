interface Visitor {
    public void visitArmy(Army army);
    public void visitSoldier(SoldatWithWeapon soldier);

    public void visitCavalier(ProxyCavalier cavalier);
    public void visitFantassin(ProxyFantassin fantassin);

    //utile seulement pour VisitorCount (cf README.md)
    public void report();
    public void reset();

}
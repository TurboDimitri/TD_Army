interface Visitor {
    public void visitArmy(Army army);
    public void visitSoldier(SoldatWithWeapon soldier);

    public void visitCavalier(ProxyCavalier cavalier);
    public void visitFantassin(ProxyFantassin fantassin);
    public void report();
    public void reset();

}
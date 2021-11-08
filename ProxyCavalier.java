public class ProxyCavalier implements SoldatWithWeapon {
    Soldat soldat;
    boolean bouclier = false;
    boolean epee = false;
    boolean lance = false;

    public ProxyCavalier(int vie) {
        this.soldat = new Cavalier(vie);
    }

    public int force() {
        return this.soldat.force();
    }

    public boolean parer(int force) {
        return this.soldat.parer(force);

    }

    public boolean addShield() {
        if (!bouclier) {
            this.soldat = new Bouclier(soldat);
            bouclier = true;
            return true;
        }
        return false;
    }

    public boolean addSword() {
        if (!epee) {
            this.soldat = new Epee(soldat);
            epee = true;
            return true;
        }
        return false;
    }

    public boolean addLance() {
        if (!epee) {
            this.soldat = new Lance(soldat);
            epee = true;
            return true;
        }
        return false;
    }

    public void accept(Visitor v){
        v.visitCavalier(this);
    }
    @Override
    public String toString(){
        return "Cavalier";
    }
}
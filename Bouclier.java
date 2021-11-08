public class Bouclier extends DecorateurArme {

    int force = 1;
    int defense = 3;

    public Bouclier(Soldat soldat) {
        this.durabilité = 100;
        this.soldat = soldat;
    }

    public int force() {
        if(getDurability() == 0){
            return this.soldat.force();
        }
        this.durabilité--;
        //System.out.println("un " + this.soldat.toString() + " frappe avec une Bouclier");
        return this.soldat.force() + this.force;
    }

    public boolean parer(int force) {
        if(getDurability() == 0){
            return this.soldat.parer(force);
        }
        //System.out.println("un " + this.soldat.toString() + " bloque avec une Bouclier");
        if (force > defense) return this.soldat.parer(force - this.defense);
        return true;
    }

    public int getDurability() {
        return this.durabilité;
    }

}
public class Lance extends DecorateurArme {

    int force = 6;
    int defense = -1;

    public Lance(Soldat soldat) {
        this.durabilité = 100;
        this.soldat = soldat;
    }

    public int force() {
        if(getDurability() <= 0){
            System.out.println("L'arme est cassée, je ne peux pas attaquer avec.");
            return this.soldat.force();
        }
        this.durabilité--;
        //System.out.println("un " + this.soldat.toString() + " frappe avec une Lance");
        return this.soldat.force() + this.force;
    }

    public boolean parer(int force) {
        if(getDurability() == 0){
            return this.soldat.parer(force);
        }
        //System.out.println("un " + this.soldat.toString() + " bloque avec une Lance");
        return this.soldat.parer(force - this.defense);
    }

    public boolean isWeaponBroken() {
        if (durabilité == 0)
            return true;
        return false;
    }

    public int getDurability() {
        return this.durabilité;
    }

}
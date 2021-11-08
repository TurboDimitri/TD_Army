public class Epee extends DecorateurArme {

    int force = 3;
    int defense = 1;

    public Epee(Soldat soldat) {
        this.durabilité = 100;
        this.soldat = soldat;
    }

    public int force() {
        if(getDurability() == 0){
            return this.soldat.force();
        }
        this.durabilité--;
        //System.out.println("un " + this.soldat.toString() + " frappe avec une épee");
        return this.soldat.force() + this.force;
    }

    public boolean parer(int force) {
        if(getDurability() == 0){
            return this.soldat.parer(force);
        }
        this.durabilité--;
        //System.out.println("un " + this.soldat.toString() + " bloque avec une épee");
        if (force > defense) return this.soldat.parer(force - this.defense);;
        return true;
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

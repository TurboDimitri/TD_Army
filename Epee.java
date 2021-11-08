public class Epee extends DecorateurArme {

    int force = 3;
    int defense = 1;

    public Epee(Soldat soldat) {
        this.durabilité = 100;
        this.soldat = soldat;
    }
    //Les prints sont mis en commentaires pour éviter de flood la console mais on peut les ráctiver pour suivre le combat;
    //Si l'arme est détruite alors on renvoie la force du soldat sans modificateur;
    public int force() {
        if(isWeaponBroken()){
            return this.soldat.force();
        }
        this.durabilité--;
        //System.out.println("un " + this.soldat.toString() + " frappe avec une épee");
        return this.soldat.force() + this.force;
    }

    public boolean parer(int force) {
        if(isWeaponBroken()){
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

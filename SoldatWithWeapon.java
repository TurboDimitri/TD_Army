public interface SoldatWithWeapon extends Soldat{

    boolean addLance();
    boolean addSword();
    boolean addShield();
    void accept(Visitor v);
}
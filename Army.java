import java.util.ArrayList;
import java.util.Iterator;

public class Army implements SoldatWithWeapon{
    int force;
    ArrayList<SoldatWithWeapon> troops ;

    public Army(){
        troops = new ArrayList<>();
    }

    //La force d'une armée est égale à la somme des forces de ses fils; 
    //Si l'armée comporte une autre armée alors l'appel à la méthode est récursive et ajoute la force des fils au total retourné;
    public int force(){
        int s =0;
        for(SoldatWithWeapon soldier: troops){
            s+= soldier.force();
        }
        force =s;
        return s;
    }
    //Parer renvoie faux si et seulement si l'armée qui part est décimée;
    //On utilise on itérateur pour pouvoir supprimer des éléments de la liste tout en la parcourant;
    //Chaque membre de l'armée subit une part égale de dégats, ainsi au plus une sous-armée est profonde dans l'arborescence au moins elle subira de dégats
    public boolean parer(int force){
        int size = troops.size();
        
        Iterator<SoldatWithWeapon> iter = troops.iterator();
        while(iter.hasNext()){
            int forceToParry = force/size;
            if(!iter.next().parer(forceToParry)){
                iter.remove();
            }
        }
        return !troops.isEmpty();
    }

    void add (SoldatWithWeapon soldier){
        troops.add(soldier);
    }
    void remove(SoldatWithWeapon soldier){
        troops.remove(soldier);
    }
    //renvoie faux si au moins un soldat ne peux pas etre equipé
    public boolean addLance(){
        boolean res = true;
        for(SoldatWithWeapon soldier: troops){
            if(!soldier.addLance()){
                res=false;
            }
        }
        return res;
    }
    public boolean addSword(){
        boolean res = true;
        for(SoldatWithWeapon soldier: troops){
            if(!soldier.addSword()){
                res = false;
            }
        }
        return res;
    }
    public boolean addShield(){
        boolean res = true;
        for(SoldatWithWeapon soldier: troops){
            if(!soldier.addShield()){
                res = false;
            }
        }
        return res;
    }
    public void accept(Visitor v){
        v.visitArmy(this);
    }
    @Override
    public String toString(){
        return "Army";
    }
}

import java.util.ArrayList;
import java.util.Iterator;

public class Army implements SoldatWithWeapon{
    int force;
    ArrayList<SoldatWithWeapon> troops ;

    public Army(){
        troops = new ArrayList<>();
    }


    public int force(){
        int s =0;
        for(SoldatWithWeapon soldier: troops){
            s+= soldier.force();
        }
        force =s;
        return s;
    }
 
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

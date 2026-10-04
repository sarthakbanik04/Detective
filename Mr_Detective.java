package Class_assignment;

import java.util.Arrays;

class Suspect{
     int ID;
    String name;
    String Location;
    String Alibi;
    String clue;
    boolean collected;
    Suspect(int id,String Name,String Location,String Alibi){
        this.ID=id;
        this.name=Name;
        this.Location=Location;
        this.Alibi=Alibi;
    }
    Suspect(String clue){
        this.clue=clue;
        this.collected=false;
    }

    public static void displaySuspect(Suspect[] arr){
        System.out.println("-----DISPLAYING SUSPECT-----");
        for(Suspect item : arr){
            if(item!=null) {
//                System.out.println("ID:"+item.ID+" Name:"+item.name+" Location:"+item.Location+" Alibi:"+item.Alibi);
                item.dispaly();
            }
        }
    }
    public void dispaly() {
        System.out.println("ID:"+ID+" Name:"+name+" Location:"+Location+" Alibi:"+Alibi);
    }
    public static void DisplayClue(Suspect[] clues){
        System.out.println("---Displaying all Clues-----");
        for(int i=0;i<clues.length;i++){
            String status=clues[i].collected?"COLLECTED":"NOT COLLECTED";
            System.out.println(i+1+"["+status+"]"+ clues[i].clue);
        }
    }
    public static void CollecteClue(Suspect[] clues,int idx){
        if(idx<0 || idx> clues.length){
            System.out.println("Invalid clue number" + idx);
        }
        else if (clues[idx].collected) {
            System.out.println("Already collected"+ clues[idx].clue);
        }else {
            clues[idx].collected = true;
            System.out.println("collected clues"+clues[idx].clue);
        }
    }
    public static void DisplayCollectedClue(Suspect[] clues,int idx){
        System.out.println("COLLECTED CLUES");
        int count=0;
        for (Suspect c: clues){
            if(c.collected) System.out.println(" "+c.clue);
            count++;
        }
        if(count==0) System.out.println("Clues is not collected");
    }
}
public class Mr_Detective {
    static void main(String[] args) {
        Suspect one=new Suspect(1,"Alex","Computer Lab", "Working on a project");
        Suspect two=new Suspect(2,"Maya","Library","Studying");
        Suspect three=new Suspect(3,"Rahul","Staff Room","Meeting a faculty member");
        Suspect four=new Suspect(4,"Sara","Canteen","Having lunch");
        Suspect five=new Suspect(5,"Arjun","Department Office","Collecting documents");

        Suspect[] arr={one,two,three,four,five};
        //created a obj for clue
        Suspect clue1=new Suspect("The office door was opened at 2:15 PM.");
        Suspect clue2=new Suspect("CCTV shows someone entering the office.");
        Suspect clue3=new Suspect("A torn piece of paper was found near the printer.");
        Suspect clue4=new Suspect("A suspect's ID card was found inside the office.");
        Suspect clue5=new Suspect("The printer was used shortly before the question paper disappeared.");
        //created a arr for storing clue
        Suspect[] clue={clue1,clue2,clue3,clue4,clue5};
//        one.dispaly();
//        Suspect.displaySuspect(arr);
        Suspect.DisplayClue(clue);
        Suspect.CollecteClue(clue,2);
        Suspect.DisplayClue(clue);
    }
}

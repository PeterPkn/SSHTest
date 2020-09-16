package WHP;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Bundesland.getInfo();
    }

    public static Pair getBiggestDiffernz(int[] data){
        if(data.length < 2){throw new IllegalArgumentException();}
        for(int i = 0;i<data.length;i++){
            for(int j = i+1;j<data.length;j++){

                Pair.numSet.add((new Pair(data[i], data[j])));

            }
        }
        //System.out.println(Pair.numSet);
        if(Pair.numSet.get(0) == null){throw new IllegalArgumentException();}
        return Pair.numSet.get(0);
    }
}

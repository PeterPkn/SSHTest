package WHP;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Bundesland.getInfo();
        System.out.println(getEmailName("a+b.c@my-example.com"));
    }

    public static Pair getBiggestDiffernz(int[] data){
        //[A-Za-z][A-Za-z\.\-\+\_\d]*[@]{1}[A-Za-z\-]*[\.]{1}[A-Za-z\-]*[\.]?[A-Za-z\-]*
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

    public static String getEmailName(String addr){
        Pattern emailPattern = Pattern.compile("([A-Za-z][A-Za-z\\.\\-\\+\\_\\d]*)[@]{1}[A-Za-z\\-]*[\\.]{1}[A-Za-z\\-]*[\\.]?[A-Za-z\\-]*");
        Matcher m;
        if((m = emailPattern.matcher(addr)).find()) return m.group(1);
        else throw new IllegalArgumentException();
    }
}

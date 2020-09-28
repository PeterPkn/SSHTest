package u01_firsttry;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(count(" eins<img alt=\"<bild \\\" keinwort> keinwort\" keinwort>zwei"));
    }

    public static int count(String text){
        //<(.*[^\]"(.*)[^\]".*)>4
        //<(.*[^\\]"(.*)[^\\]?".*)*>
        if(text.trim().isBlank())return 0;
        text = text.replaceAll("[^A-Za-z<>\\s\"]"," ");

        //text = text.replaceAll("<(\".*\")>", "");

        text = text.replaceAll("<([^>]*(\".*\")[^>]*)>?"," ");

        System.out.println(text.trim());

        text = text.replaceAll(" +", " ");

        System.out.println(Arrays.toString(text.trim().split(" ")));

        return text.trim().split(" ").length;
    }
}

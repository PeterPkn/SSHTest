//Peter Bezak 4BN
package u01_firsttry;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println(count(" eins<img alt=\"<bild \\\" keinwort> keinwort\" keinwort>zwei"));
    }

    public static int count(String text){
        //<(.*[^\]"(.*)[^\]".*)>4
        //<(.*[^\\]"(.*)[^\\]?".*)*>
        //<([^>]*([^\\]".*[^\\]")[^>]*)>?
        if(text.trim().isBlank())return 0;
        text = text.replaceAll("[^A-Za-z<>\\s\"\\\\]"," ");

        System.out.println(text);
        Pattern p1 = Pattern.compile("<[^>]*(\\\\\")[^>]*>?");//.matcher(text).group(1).replaceAll(".*", " ");

        Matcher m = p1.matcher(text);

        if(m.find()) {
            System.out.println(m.group(1));
            //System.out.println(m.end(1));
            String text1 = text.trim().substring(0, m.start(1));
            String text2 = text.trim().substring(m.end(1), text.length()-1);

            text = text1+text2;
        }

        System.out.println(text);

        text = text.replaceAll("<([^>]*(\".*\")[^>]*)>?"," ");

        System.out.println(text.trim());

        text = text.replaceAll(" +", " ");

        System.out.println(Arrays.toString(text.trim().split(" ")));

        return text.trim().split(" ").length;
    }
}

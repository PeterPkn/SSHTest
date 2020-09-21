package u01_firsttry;

public class Main {
    public static void main(String[] args) {
        System.out.println(count(" eins<img alt=\"<bild \\\" keinwort> keinwort\" keinwort>zwei"));
    }

    public static int count(String text){
        text = text.replaceAll("[^A-Za-z<>\\s]"," ");

        text = text.replaceAll("<(.*?)>"," ");

        System.out.println(text.trim());

        return text.trim().split(" ").length;
    }
}

package u01_firsttry;

public class Main {
    public static void main(String[] args) {
        System.out.println(count("ein erster <12z*12)(>/%&(\"=Text"));
    }

    public static int count(String text){
        text = text.replaceAll("[^A-Za-z<>\\s]","");

        

        //System.out.println(text);

        return text.trim().split(" ").length;
    }
}

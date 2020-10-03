package u01_enum1;

public class Main {
    public static void main(String[] args) {

    }

    public static int count(String text){
        int counter = 0;
        States current = States.OUT_WORD;
        for(int i = 0; i <= text.length();i++){


            switch(text.charAt(i)){


            }
        }

        return counter;
    }

    public enum States{
        IN_WORD,
        OUT_WORD,
        IN_QUOTES,
        IN_TAG,
        ESCAPE,
    }
}

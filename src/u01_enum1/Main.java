package u01_enum1;

public class Main {
    public static void main(String[] args) {

        System.out.println(count(" eins<img alt=\"<bild \\\" keinwort keinwort\" keinwort>zwei"));
    }

    public static int count(String text){
        int counter = 0;
        States current = States.OUT_WORD;
        for(int i = 0; i < text.length();i++){
            char letter = text.charAt(i);

            switch(current){
                case IN_WORD:
                    if(!Character.isLetterOrDigit(letter)){
                        current = States.OUT_WORD;
                    }
                    if(Character.toString(letter).equals("<")){
                        current = States.IN_TAG;
                    }
                    break;
                case OUT_WORD:
                    if(Character.isLetterOrDigit(letter)){
                        counter++;
                        current = States.IN_WORD;
                    }
                    if(Character.toString(letter).equals("<")){
                        current = States.IN_TAG;
                    }

                    break;
                case IN_QUOTES:
                    if(Character.toString(letter).equals("\"")){
                        current = States.IN_TAG;
                    }
                    if(Character.toString(letter).equals("\\")){
                        current = States.ESCAPE;
                    }
                    break;
                case IN_TAG:
                    if(Character.toString(letter).equals("\"")){
                        current = States.IN_QUOTES;
                    }
                    if(Character.toString(letter).equals(">")){
                        current = States.OUT_WORD;
                    }
                    break;
                case ESCAPE:
                    current = States.IN_QUOTES;
                    break;

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

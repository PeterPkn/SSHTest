package u02_enum2;

public enum States {
    /**
     * Enum das alle States enthält
     */
    IN_WORD{
        public States handleChar(IncrementWord context, char ch) {
            States retState = this;
            if(!Character.isLetterOrDigit(ch)){
                 retState = States.OUT_WORD;
            }
            if(Character.toString(ch).equals("<")){
                retState = States.IN_TAG;
            }
            return retState;
        }
    },
    OUT_WORD{
        public States handleChar(IncrementWord context, char ch) {
            States retState = this;
            if(Character.isLetterOrDigit(ch)){
                context.incCount();
                retState = States.IN_WORD;
            }
            if(Character.toString(ch).equals("<")){
                retState = States.IN_TAG;
            }

            return retState;
        }
    },
    IN_QUOTES{
        public States handleChar(IncrementWord context, char ch) {
            States retState = this;
            if(Character.toString(ch).equals("\"")){
                retState = States.IN_TAG;
            }
            if(Character.toString(ch).equals("\\")){
                retState = States.ESCAPE;
            }
            return retState;
        }
    },
    IN_TAG{
        public States handleChar(IncrementWord context, char ch) {
            States retState = this;
            if(Character.toString(ch).equals("\"")){
                retState = States.IN_QUOTES;
            }
            if(Character.toString(ch).equals(">")){
                retState = States.OUT_WORD;
            }
            return retState;
        }
    },
    ESCAPE{
        public States handleChar(IncrementWord context, char ch) {
            return States.IN_QUOTES;
        }
    };

    /**
     *
     * @param context Interface mit nötigen Methoden für das bearbeiten der Character
     * @param ch Der zu bearbeitende Charachter
     * @return Gibt den State zurück zu dem die Statemachine nach diesem Character wechseln soll.
     */
    public abstract States handleChar(IncrementWord context, char ch);
}

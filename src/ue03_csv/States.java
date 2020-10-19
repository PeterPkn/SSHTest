package ue03_csv;

import u02_enum2.IncrementWord;

public enum States {
    inCell{
        @Override
        public States handleChar(AddWord context, char ch) {
            //System.out.println(ch);
            if(context.isdelimiter(ch)){
                context.endCell();
                return delimiter;
            }
            context.addChar(ch);
            return this;
        }
    },
    delimiter{
        @Override
        public States handleChar(AddWord context, char ch) {
            if(ch == "\"".charAt(0)){
                return inQuotes;
            }
            if(context.isdelimiter(ch)){
                context.endCell();
                return delimiter;
            }
            context.addChar(ch);
            return inCell;
        }
    },
    inQuotes{
        @Override
        public States handleChar(AddWord context, char ch) {
            if(ch == "\"".charAt(0)){
                return escapeQuotes;
            }
            context.addChar(ch);
            return this;
        }
    },
    escapeQuotes{
        @Override
        public States handleChar(AddWord context, char ch) {
            if(context.isdelimiter(ch)){
                context.endCell();
                return delimiter;
            }
            context.addChar(ch);
            return inQuotes;
        }
    };
    /**
     *
     * @param context Interface mit nötigen Methoden für das bearbeiten der Character
     * @param ch Der zu bearbeitende Charachter
     * @return Gibt den State zurück zu dem die Statemachine nach diesem Character wechseln soll.
     */
    public abstract States handleChar(AddWord context, char ch);
}

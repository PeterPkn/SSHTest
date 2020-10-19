package u02_enum2;

public class WordCount implements IncrementWord {
    /**
     * Klasse für Wörter zählen.
     * @param counter Zählt die Wörter.
     */
    private int counter = 0;
    States currentState = States.OUT_WORD;

    /**
     * Zählmethode
     * @param text Der input Tesct zum zählen.
     * @return Gibt die wortanzahl zurück.
     */
    public static int count(String text){
        WordCount wc = new WordCount();
        for (int i = 0; i < text.length(); i++) {
            wc.currentState = wc.currentState.handleChar(wc,text.charAt(i));
        }

        return wc.counter;
    }




    @Override
    public void incCount() {
        this.counter++;
    }
}

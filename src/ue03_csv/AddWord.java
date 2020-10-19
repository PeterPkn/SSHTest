package ue03_csv;

import javax.xml.stream.events.Characters;

public interface AddWord {
    /**
     * Schaut ob Zeichen Delimiter ist.
     * @param ch Das zu kontrollierende Zeichen
     * @return True falls Delimiter, sonst False
     */
    boolean isdelimiter(char ch);

    /**
     * Schreibt CSV Zelle in die Liste und startet neue.
     */
    void endCell();

    /**
     * Fuegt Character zur momentanen Zelle hinzu.
     * @param ch Der Character zum hinzufügen.
     */
    void addChar(char ch);
}

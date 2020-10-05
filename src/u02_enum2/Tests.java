//Peter Bezak 4BN
package u02_enum2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static u02_enum2.WordCount.count;

import org.junit.jupiter.api.Test;


public class Tests {
    /**
     * Test Klasse mit Test Methoden
     */
    @Test
    public void easytests(){
        assertSame(0, count(""));
        assertSame(0, count(" "));
        assertSame(0, count("  "));
    }
    @Test
    public void normaltest(){
        assertSame(1, count("eins"));
        assertSame(1, count(" eins"));
        assertSame(1, count(" eins "));
        assertSame(1, count("  eins    "));
        assertEquals(1, count("eins"));
        assertEquals(1, count(" eins"));
        assertEquals(1, count("eins "));
        assertEquals(1, count(" eins "));
        assertEquals(1, count("  eins "));
        assertEquals(1, count("  eins  "));

        assertEquals(1, count("eins:"));
        assertEquals(1, count(":eins"));
        assertEquals(1, count(":eins:"));
        assertEquals(1, count(" eins  "));
        assertEquals(1, count("  eins : "));
        assertEquals(1, count(": eins :"));
        assertEquals(3, count("ein erster Text"));
        assertEquals(3, count(" ein erster Text      "));
        assertEquals(3, count("ein:erster.Text"));

        //vielleicht falsch (Bei mir richtig)
        assertEquals(1, count("a"));
        assertEquals(1, count(" a"));
        assertEquals(1, count("a "));
        assertEquals(1, count(" a "));
    }

    @Test
    public void htmltagstest(){
        //mit html
        assertEquals(1, count(" eins   <html> "));
        assertEquals(1, count(" eins   < html> "));
        assertEquals(1, count(" eins   <html > "));
        assertEquals(1, count(" eins   < html > "));
        assertEquals(4, count(" eins  <html> zwei<html>drei <html> vier"));
        assertEquals(2, count(" eins  <html> zwei "));
        assertEquals(2, count(" eins  <html>zwei "));
        assertEquals(2, count(" eins<html> zwei "));
        assertEquals(2, count(" eins<html>zwei "));
        assertEquals(2, count(" eins<img alt=\"xxx\" > zwei"));
        assertEquals(2, count(" eins<img alt=\"xxx yyy\" > zwei"));

        assertEquals(2, count(" eins \"zwei\" "));
        assertEquals(2, count(" eins\"zwei\" "));
        assertEquals(2, count(" eins \"zwei\""));
        assertEquals(3, count(" eins \"zwei\"drei"));
        assertEquals(3, count(" eins \"zwei\" drei"));
    }

    @Test
    public void htmlTricksTest(){
        // html - trickreich
        // Achtung: das ist teilweise nicht ganz legales HTML
        assertEquals(1, count(" eins<html"));
        assertEquals(2, count(" eins<img alt=\"<bild>\" > zwei"));
        assertEquals(2, count(" eins<img alt=\"bild>\" > zwei"));
        assertEquals(2, count(" eins<img alt=\"<bild>\" keinwort> zwei"));
        assertEquals(2, count(" eins<img alt=\"<bild>\" src=\"bild.png\">zwei"));
        assertEquals(2, count(" eins<img alt=\"<bild\" keinwort>zwei"));

        assertEquals(1, count(" eins<img alt=\"<bild\" keinwort"));
        assertEquals(2, count(" eins<img alt=\"<bild\" keinwort> zwei"));
        assertEquals(1, count(" eins<img alt=\"<bild keinwort> keinwort"));
        assertEquals(2, count(" eins<img alt=\"<bild keinwort keinwort\">zwei"));
        assertEquals(2, count(" eins<img alt=\"<bild keinwort< keinwort\">zwei"));

        // ganz ganz fies -- \ entwertet das nächste Zeichen
        assertEquals(2, count(" eins<img alt=\"<bild \\\" keinwort> keinwort\" keinwort>zwei"));
        assertEquals(2, count(" eins<img alt=\"<bild \\\" keinwort<keinwort\" keinwort>zwei"));
        assertEquals(2, count(" eins<img alt=\"<bild \\\" keinwort keinwort\" keinwort>zwei"));

        assertEquals(4, count(" \\\"null\\\" eins<img alt=\"<bild \\\" keinwort keinwort\"keinwort>zwei \"drei\""));
    }

}


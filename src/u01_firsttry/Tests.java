package u01_firsttry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class Tests {
    @Test
    public void easytests(){
        assertSame(0,Main.count(""));
        assertSame(0,Main.count(" "));
        assertSame(0,Main.count("  "));
    }
    @Test
    public void normaltest(){
        assertSame(1,Main.count("eins"));
        assertSame(1,Main.count(" eins"));
        assertSame(1,Main.count(" eins "));
        assertSame(1,Main.count("  eins    "));
        assertSame(1,Main.count("eins:"));
        assertSame(1,Main.count(":eins"));
        assertSame(1,Main.count(":eins:"));
        assertSame(1,Main.count(" eins "));
        assertSame(1,Main.count(" eins : "));
        assertSame(1,Main.count(": eins :"));
        assertSame(3,Main.count("ein erster Text"));
        assertSame(3,Main.count(" ein erster Text "));
        assertSame(3,Main.count("ein:erster.Text"));
        assertSame(1,Main.count("a "));
        assertSame(1,Main.count(" a "));
    }
    
}

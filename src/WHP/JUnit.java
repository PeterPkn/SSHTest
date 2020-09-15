package WHP;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class JUnit {

    @Test
    public void gibtRichtigeAntwort(){
        int[] input = { 1, 2, 5, 3, 4 };
        assertEquals(Main.getBiggestDiffernz(input), new Pair(1,5));

    }
    @Test
    public void leeresArrayLiefertIllegalArgumentException(){
        int[] input = {};
        Assertions.assertThrows(IllegalArgumentException.class, ()->{Main.getBiggestDiffernz(input);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{Main.getBiggestDiffernz(new int[]{1});});
    }
    @Test
    public void richtigeFunktionmitMinuszahlen(){
        int[] input = { 1, 2, 5, 3, 4,-7 };
        assertEquals(Main.getBiggestDiffernz(input), new Pair(5,-7));
    }
    @Test
    public void ergebnisMitNull(){
        int[] input = { 0,0,0,0,0 };
        assertEquals(Main.getBiggestDiffernz(input), new Pair(0,0));
    }

}

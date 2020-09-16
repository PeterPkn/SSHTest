package WHP;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class JUnit {

    @Test
    public void gibtRichtigeAntwort(){
        int[] input = { 1, 2, 5, 3, 4 };
        assertEquals(new Pair(1,5), Main.getBiggestDiffernz(input));

    }
    @Test
    public void leeresArrayLiefertIllegalArgumentException(){
        int[] input = {};
        Assertions.assertThrows(IllegalArgumentException.class, ()->{Main.getBiggestDiffernz(input);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{Main.getBiggestDiffernz(new int[]{1});});
    }
    @Test
    public void ergebnisMitNull(){
        Pair.clearList();
        int[] input1 = {0,0,0,0,0};
        assertEquals(new Pair(0,0), Main.getBiggestDiffernz(input1));
    }

    @Test
    public void richtigeFunktionmitMinuszahlen(){
        Pair.clearList();
        int[] input = { 1, 2, 5, 3, 4,-7 };
        assertEquals(new Pair(5,-7), Main.getBiggestDiffernz(input));
    }
}

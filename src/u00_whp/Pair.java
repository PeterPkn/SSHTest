//Peter Bezak 4BN
package u00_whp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pair implements Comparable<Pair>{


    private int num1, num2, difference;

    public static List<Pair> numSet = new ArrayList<Pair>();

    /**
     * Pair Klasse fasst zwei Integer in ein Pair zusammen
     * @param num1 Eine Nummer im Pair
     * @param num2 Eine Nummer im Pair
     */
    public Pair(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.difference = Math.abs(num1-num2);
        numSet.sort(Pair::compareTo);
    }

    /**
     * Gibt Differenz zwischen den zwei Zahlen.
     * @return int
     */
    public int getDifference() {
        return difference;
    }

    /**
     * Löscht alle Pairs in der Liste.
     */
    public static void clearList(){
        Pair.numSet.clear();
    }

    /**
     * Überschreibt die equals Methode damit zwei Pairs mit gleichen Zahlen equal sind.
     * @param o Das zu vergleichende Objekt.
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return num1 == pair.num1 &&
                num2 == pair.num2 &&
                difference == pair.difference;
    }

    /**
     * berschreibt die hashcode Methode damit zwei Pairs mit gleichen Zahlen equal sind.
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(num1, num2, difference);
    }

    /**
     * Überschreibt toString Methode damit Pairs im Format (x, y) ausgegeben werden
     * @return String
     */
    @Override
    public String toString() {
        return "("+num1+", "+num2+")";
    }

    /**
     * Überschreibt die compareTo Methode so das Pairs anhand von ihrer Differenz verglichen und sortiert werden.
     * @param o Das zu vergleichende Objekt.
     * @return int
     */
    @Override
    public int compareTo(Pair o) {
        return (int) (o.getDifference()-this.getDifference());
    }
}

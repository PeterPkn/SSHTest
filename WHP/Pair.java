package u00_whp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Pair implements Comparable<Pair>{
    private int num1, num2, difference;

    public static List<Pair> numSet = new ArrayList<Pair>();

    public Pair(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.difference = Math.abs(num1-num2);
        numSet.sort(Pair::compareTo);
    }

    public int getDifference() {
        return difference;
    }

    public static void clearList(){
        Pair.numSet.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return num1 == pair.num1 &&
                num2 == pair.num2 &&
                difference == pair.difference;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num1, num2, difference);
    }

    @Override
    public String toString() {
        return "("+num1+", "+num2+")";
    }

    @Override
    public int compareTo(Pair o) {
        return (int) (o.getDifference()-this.getDifference());
    }
}

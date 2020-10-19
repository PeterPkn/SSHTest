package ue03_csv;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CSVReader reader = new CSVReader(Paths.get("C:\\Users\\petsc\\Documents\\HTL Rennweg\\groesteDifferenz\\src\\ue03_csv\\testing.txt").toFile());

        System.out.println(reader.split("Peter; Bezak ; Katarina;Bezakova; Betka, Bezakova"));

        GewichtsMatrix(Paths.get("C:\\Users\\petsc\\Documents\\HTL Rennweg\\groesteDifferenz\\src\\ue03_csv\\testing.txt").toFile());
        //CSVReader fileReader = new CSVReader()
    }

    /**
     * Gibt Kantengewichte zwischen den Buchstaben zurück.
     * @param file Die source Datei.
     */
    public static void GewichtsMatrix(File file){
        CSVReader reader = new CSVReader(file);
        ArrayList<String> strList;
        ArrayList<ArrayList<String>> combinedList = new ArrayList<>();
        while (!(strList = reader.next()).isEmpty()){
            combinedList.add(new ArrayList<>(strList));
        }

        for (int i = 1; i < combinedList.get(0).size(); i++) {
            System.out.print("\n"+combinedList.get(0).get(i)+":");
            for (int j = 1; j < combinedList.size(); j++) {
                if(!combinedList.get(j).get(i).equals("")) {
                    System.out.print(" nach " + combinedList.get(j).get(0) + ": " + combinedList.get(j).get(i));
                }
            }
        }
        //System.out.println(combinedList);
    }
}

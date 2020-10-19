package ue03_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author Peter Bezak
 */


public class CSVReader implements AddWord{

    public CSVReader(File file){
        this.file = file;
    }
    private File file;
    private States currentState = States.inCell;
    private ArrayList<String> cells = new ArrayList<>();
    private StringBuilder buffer = new StringBuilder();
    private char delimiter = ";".charAt(0);
    private int currentLine = 0;
    public ArrayList<String> split(String input){
        cells.clear();
        buffer.delete(0, buffer.length());
        //CSVReader csvr = new CSVReader();
        for (int i = 0; i < input.length(); i++) {
            this.currentState = this.currentState.handleChar(this,input.charAt(i));
        }
        if(!buffer.toString().isEmpty() || currentState.equals(States.delimiter)) {
            this.cells.add(buffer.toString());
        }
        currentState = States.inCell;
        return this.cells;
    }

    public ArrayList<String> next(){
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)){
            for (int i = 0; i <currentLine ; i++) {
                br.readLine();
            }
            String str;
            if((str=br.readLine())!=null && str.length()!=0) {
                currentLine++;
                return split(str);
            }else{
                return new ArrayList<>();
            }
        }catch (IOException ex){
            ex.getStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public boolean isdelimiter(char ch) {
        return ch == delimiter;
    }

    @Override
    public void endCell() {
        cells.add(buffer.toString().replaceAll("^\\s+",""));
        buffer.delete(0, buffer.length());

    }

    @Override
    public void addChar(char ch) {
        buffer.append(ch);
    }
}

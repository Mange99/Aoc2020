package Input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile<T> {
    private final List<T> elements = new ArrayList<>();
    BufferedReader br;

    public List<T> seperatedByLine(File fileName){
        try{
            br = new BufferedReader(new FileReader(fileName));
            String strCurrentLine;
            while((strCurrentLine = br.readLine()) != null){
                elements.add((T) strCurrentLine);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(br != null){
                    br.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return elements;
    }
    public List<T> seperatedByComma(File fileName){
        try{
            String line = null;
            br = new BufferedReader(new FileReader(fileName));

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String str : values) {
                    elements.add((T) str);
                }
            }
            br.close();

        }catch (IOException e){
            e.printStackTrace();
        }
        return elements;
    }
}

package Problem2;

import Input.ReadFromFile;

import java.io.File;
import java.net.URL;
import java.util.List;

public class main {
    //test
    private ReadFromFile readFromFile = new ReadFromFile();
    private List<Integer> numbers;
    private URL url = getClass().getResource("input.txt");
    private File fileName = new File(url.getPath());

    public main(){
        numbers = readFromFile.seperatedByComma(fileName);
        System.out.println(numbers.get(6));
    }
    public static void main(String[] args) {
        new main();
    }
}

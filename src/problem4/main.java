package problem4;

import Input.ReadFromFile;

import java.io.File;
import java.net.URL;
import java.util.List;

public class main extends ReadFromFile{
    private List<String> structure;
    private final URL url = getClass().getResource("input.txt");
    private final File fileName = new File(url.getPath());
    private String[] ids = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
    private int valid = 0;
    public main() {
        structure = seperatedByLine(fileName);
        for(String passwords : structure){
            checkIdPassernger(passwords);
        }
        System.out.println(valid);
    }


    public void checkIdPassernger(String passenger){
        int tot = 0;
        String[] splitted = passenger.split("\\s+");
        for(String id : splitted){
            for(int i = 0; i < ids.length; i++){
                if(id.contains(ids[i])){
                    tot++;
                }
            }
        }
        if(tot == 7){
            valid++;
        }
    }

    public static void main(String[] args) {
        new main();
    }
}

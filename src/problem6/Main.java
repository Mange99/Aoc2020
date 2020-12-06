package problem6;

import Input.ReadFromFile;

import java.io.File;
import java.net.URL;
import java.util.*;

public class Main extends ReadFromFile {
    private List<String> totalAwnsers;
    private final URL url = getClass().getResource("input.txt");
    private final File fileName = new File(url.getPath());
    private List<List<String>> groups = new ArrayList<>();

    public Main(){
        int sum = 0;
        totalAwnsers = seperatedByLine(fileName);

        int spaceIndex = 0;
        int counterPersons = 0;
        for(String persons : totalAwnsers){
            if(persons.length() < 1){
                //genious solution not working
                groups.add(totalAwnsers.subList(counterPersons, spaceIndex));
                counterPersons = spaceIndex+1;
            }
            spaceIndex++;
        }
        System.out.println(groups.get(0));
        getDuplicates(groups.get(0));

    }
    public void getDuplicates(List<String> group){
        String totalen = "";
        String duplicates = "";
        for(String persons : group){
            totalen += persons;
            System.out.println(totalen);
        }
        System.out.println(totalen);
        char[] tokens = totalen.toCharArray();
        for(int i = 0; i < tokens.length; i++){
            for(int j = i; j < tokens.length; j++){
                if(tokens[i] == tokens[j]){
                    duplicates += tokens[i];
                    System.out.println(duplicates);
                    break;
                }
            }
        }
        System.out.println(duplicates);
    }





    /*
    public static String removeDups(String word) {
        Set<Character> chars = new HashSet<>();
        StringBuilder output = new StringBuilder(word.length());
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (chars.add(ch)) {
                output.append(ch);
            }
        }
        return output.toString();
    }
    */


    public static void main(String[] args) {
        new Main();
    }

}

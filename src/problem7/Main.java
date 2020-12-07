package problem7;

import Input.ReadFromFile;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main extends ReadFromFile {
    private final URL url = getClass().getResource("input.txt");
    private final File fileName = new File(url.getPath());
    private List<String> rules;

    public Main(){
        rules = seperatedByLine(fileName);
        System.out.println(rules);

        List<String> bags;
        bags = bags(rules);
        System.out.println(bags);

        List<String> contentOfBag;
        contentOfBag = getContent(rules.get(0));
        System.out.println(contentOfBag);
    }
    public List<String> bags(List<String> rules){
        List<String> bags = new ArrayList<>();

        for(int i = 0; i < rules.size(); i++){
            bags.add(rules.get(i).substring(0, rules.get(i).indexOf("bag")-1));
        }
        return bags;
    }
    public List<String> getContent(String current){
        List<String> content = new ArrayList<>();

        char[] tokens = current.toCharArray();
        for(int i = 0; i < tokens.length; i++){
            if(Character.isDigit(tokens[i])){
                try{
                    content.add(current.substring(i, current.indexOf(",")));
                }catch (StringIndexOutOfBoundsException si){
                    content.add(current.substring(i, current.indexOf(".")));
                }
            }
        }
        return content;
    }
    public static void main(String[] args) {
        new Main();
    }
}

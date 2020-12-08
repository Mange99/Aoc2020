package problem8;

import Input.ReadFromFile;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main extends ReadFromFile {
    private final URL url = getClass().getResource("input.txt");
    private final File fileName = new File(url.getPath());
    private List<String> executions;

    public Main(){
        executions = seperatedByLine(fileName);
        System.out.println(executions);
        int sum = execute(executions);
        System.out.println(sum);
    }

    public int execute(List<String> exec){
        int accimulator = 0;
        List<Integer> linesOfExecute = new ArrayList<>();
        linesOfExecute.add(Integer.MIN_VALUE);
        for(int i = 0; i < exec.size(); i++){
            System.out.println(i);
            System.out.println(linesOfExecute);
            for(int j = 0; j < linesOfExecute.size(); j++){
                if(linesOfExecute.contains(i)){
                    return accimulator;
                }
            }
            linesOfExecute.add(i);

            System.out.println(exec.get(i));
            String code = exec.get(i).substring(0,3);
            //System.out.println(code);
            String operator = exec.get(i).substring(4,5);
            //System.out.println(operator);
            int number = Integer.parseInt(exec.get(i).substring(5));
            //System.out.println(number);

            if(code.equals("nop")){
                System.out.println("doin nothing");
            }else if(code.equals("acc") && operator.equals("+")){
                accimulator += number;
            }else if(code.equals("acc") && operator.equals("-")){
                accimulator -= number;
            }else if(code.equals("jmp") && operator.equals("+")){
                i += number-1;
            }else{
                i -= number+1;
            }
        }
        return accimulator;
    }

    public static void main(String[] args) {
        new Main();
    }
}

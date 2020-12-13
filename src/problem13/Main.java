package problem13;

import Input.ReadFromFile;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends ReadFromFile {
    private final URL url = getClass().getResource("input.txt");
    private final File fileName = new File(url.getPath());
    private List<String> input;


    public Main(){
        input = seperatedByComma(fileName);
        System.out.println(input);


        //int fastestBuss = delA(input);
        delB(input);
    }
    public void delB(List<String> input){
        System.out.println(input);
        long min = (long) 100000000000000.0;

        long j = (long) Math.floor(min/Integer.parseInt(input.get(0)));

        while (true){
            long t = Long.parseLong(input.get(0)) * j;
            long count = 0;
            for(int i = 0; i < input.size(); i++){
                if(input.get(i).equals("x")){
                    count++;
                    continue;
                }
                if((t + i) % Long.parseLong(input.get(i)) == 0){
                    count++;
                }
            }
            j++;
            if(count == input.size()){
                System.out.println(t);
                break;
            }
        }

    }
    public int delA(List<String> input){
        int time = Integer.parseInt(input.remove(0));
        System.out.println(time);
        while(input.contains("x")){
            input.remove("x");
        }
        List<Integer> busses = new ArrayList<>();
        for(String inputs : input){
            busses.add(Integer.parseInt(inputs));
        }
        System.out.println(busses);
        int min = Integer.MAX_VALUE;
        int buss = 0;
        for(int i = 0; i < busses.size(); i++){
            int current = busses.get(i);
            while(current <= time){
                current += busses.get(i);
                if(current > time)
                    break;
            }
            if(current - time < min){
                min = current - time;
                buss = busses.get(i);
                System.out.println(min * busses.get(i));
            }
        }
        return buss*min;
    }


    public static void main(String[] args) {
        new Main();
    }
}

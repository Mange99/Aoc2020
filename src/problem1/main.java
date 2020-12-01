package problem1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//test
public class main {
    private Scanner sc;
    private List<Integer> numbers = new ArrayList<Integer>();

    public main() {
        try{
            sc = new Scanner(new File("C:/Users/Magnus/IdeaProjects/Aoc2020/src/problem1/input.txt"));
        }catch (FileNotFoundException e){
            System.out.println("error fil fel " + e);
        }
        while(sc.hasNextInt()){
            numbers.add(sc.nextInt());
        }
        for(int i = 0; i < numbers.size(); i++){
            for(int j = 1; j < numbers.size(); j++){
                for(int n = 2; n < numbers.size(); n++){
                    if(numbers.get(i) + numbers.get(j) + numbers.get(n) == 2020 && i != j && i != n){
                        System.out.println("i: " + numbers.get(i) + " j " + numbers.get(j) + " " + numbers.get(n));
                        System.out.println(numbers.get(i) * numbers.get(j) * numbers.get(n));
                        System.out.println(i + " " + j + " " + n);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new main();
    }
}

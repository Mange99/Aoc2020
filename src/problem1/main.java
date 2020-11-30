package problem1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        printList(numbers);
    }
    public void printList(List<Integer> list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        new main();
    }
}

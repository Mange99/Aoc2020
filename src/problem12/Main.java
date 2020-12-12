package problem12;

import Input.ReadFromFile;

import java.io.File;
import java.net.URL;
import java.util.List;

public class Main extends ReadFromFile {
    private final URL url = getClass().getResource("input.txt");
    private final File fileName = new File(url.getPath());
    private List<String> directions;
    private Direction direction;
    private int shipX = 0, shipY = 0, wheyPosX = 10, wheyPosY = 1;

    public Main(){

        directions = seperatedByLine(fileName);
        System.out.println(directions);

        direction = Direction.EAST;

        int sum = nrA();
        System.out.println(sum);

        shipX = 0;
        shipY = 0;

        int sumb = nrB();
        System.out.println(sumb);
    }
    public int nrA(){
        for (String s : directions) {
            String current = s.substring(0, 1);
            int answer = Integer.parseInt(s.substring(1));

            switch (current) {
                case "F":
                    moveA(answer);
                    break;

                case "N":
                    this.shipY += answer;
                    break;

                case "S":
                    this.shipY -= answer;
                    break;

                case "E":
                    this.shipX += answer;
                    break;

                case "W":
                    this.shipX -= answer;
                    break;

                case "L":
                    rotate(-answer);
                    break;

                case "R":
                    rotate(answer);
                    break;

                default:
                    System.out.println("KUKEN");
            }
        }
        System.out.println(this.shipX + " " + this.shipY);
        return (Math.abs(this.shipX)+Math.abs(this.shipY));
    }
    public int nrB(){
        for (String s : directions) {
            String current = s.substring(0, 1);
            int answer = Integer.parseInt(s.substring(1));

            switch (current) {
                case "F":
                    moveB(answer);
                    break;

                case "N":
                    this.wheyPosY += answer;
                    break;

                case "S":
                    this.wheyPosY -= answer;
                    break;

                case "E":
                    this.wheyPosX += answer;
                    break;

                case "W":
                    this.wheyPosX -= answer;
                    break;

                case "L":
                    counterClockWise(answer);
                    break;

                case "R":
                    clockWise(answer);
                    break;

                default:
                    System.out.println("KUKEN");
            }
        }
        System.out.println(this.shipX + " " + this.shipY);
        return (Math.abs(this.shipX)+Math.abs(this.shipY));
    }
    public void moveA(int length){
        this.shipX += direction.getX() * length;
        this.shipY += direction.getY() * length;
    }
    public void moveB(int length){
        this.shipX += wheyPosX * length;
        this.shipY += wheyPosY * length;
    }


    public void clockWise(int degrees){
        int rotations = (degrees / 90);
        int temp;
        if(rotations == 1){
            temp = wheyPosX;
            this.wheyPosX = this.wheyPosY;
            this.wheyPosY = -1* temp;
        }else if(rotations == 2){
            this.wheyPosX = this.wheyPosX * -1;
            this.wheyPosY = this.wheyPosY * -1;
        }else if(rotations == 3){
            temp = wheyPosX;
            this.wheyPosX = this.wheyPosY *-1;
            this.wheyPosY = temp;
        }
    }
    public void counterClockWise(int degrees){
        int rotations = (degrees / 90);
        int temp;
        if(rotations == 1){
            temp = wheyPosX;
            this.wheyPosX = this.wheyPosY * -1;
            this.wheyPosY = temp;
        }else if(rotations == 2){
            this.wheyPosX = this.wheyPosX * -1;
            this.wheyPosY = this.wheyPosY * -1;
        }else if(rotations == 3){
            temp = this.wheyPosX;
            this.wheyPosX = this.wheyPosY;
            this.wheyPosY = temp * -1;
        }
    }
    public void rotate(int rotate){
        int nrs = rotate/90;
        if(nrs > 0) {
            for(int i = 0; i < nrs; i++){
                direction = direction.next();
            }
        }else{
            nrs *= -1;
            for(int i = 0; i < nrs; i++) {
                direction = direction.previous();
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }

    public enum Direction {
        NORTH (0,1),
        EAST (1,0),
        SOUTH(0,-1),
        WEST(-1,0),
        ;
        private static Direction[] direction = values();
        private int x, y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Direction next(){
            if(x == -1 && y == 0){
                return Direction.NORTH;
            }
            return direction[(this.ordinal()+1) % direction.length];

        }
        public Direction previous(){
            if(x == 0 && y == 1){
                return Direction.WEST;
            }
            return direction[(this.ordinal()-1) % direction.length];
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}

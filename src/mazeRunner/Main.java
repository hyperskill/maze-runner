package mazeRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Brick brick = new Brick(sc.nextInt(), sc.nextInt());
        brick.printBrick();

    }
}

class Brick{
    int width;
    int height;
    int[][]maze;
    ArrayList<String> zones = new ArrayList<>();

    Brick(int width, int height){
        this.width = width % 2 == 0? width + 1 : width;
        this.height = height % 2 == 0? height + 1 : height;
        this.maze = new int[this.height][this.width];
        for (int[] m : this.maze)
            Arrays.fill(m, 1);
        fillZones();
        fillMaze();
    }


    private void fillMaze(){
        maze[0][1] = 0;
        maze[height - 1][width - 2] = 0;
        maze[1][1] = 0;
        zones.remove("1 1");
        int[] currCoord = new int[2];
        currCoord[0] = 1;
        currCoord[1] = 1;
        while (zones.size() > 1 && currCoord[0] != -1){
            int rand = (int)(Math.random() * 4);
            for (int i = 0; i < 4; i ++){
                if (checkStep(currCoord, (rand + i) % 4)) {
                    break;
                }

                if (i == 3){
                    while (zones.size() > 1){
                        currCoord = newStart(new int[]{Integer.parseInt(zones.get(0).split("\\s+")[0]),Integer.parseInt(zones.get(0).split("\\s+")[1])});
                        if (currCoord[0] != -1)
                            break;
                    }
                }
            }
        }
    }

    private int[] newStart(int[] point){
        if (point[1] > 2 && maze[point[0]][point[1] - 2] == 0){
            zones.remove(point[0] + " " + point[1]);
            maze[point[0]][point[1]] = 0;
            maze[point[0]][point[1] - 1] = 0;
            return new int[]{point[0], point[1]};
        }
        else if (point[0] > 2 && maze[point[0] - 2][point[1]] == 0){
            zones.remove(point[0] + " " + point[1]);
            maze[point[0]][point[1]] = 0;
            maze[point[0] - 1][point[1]] = 0;
            return new int[]{point[0], point[1]};
        }
        else if (point[1] < maze[0].length - 2 && maze[point[0]][point[1] + 2] == 0){
            maze[point[0]][point[1]] = 0;
            maze[point[0]][point[1] + 1] = 0;
            zones.remove(point[0] + " " + point[1]);
            return new int[]{point[0], point[1]};
        }
        else if (point[0] < maze.length - 2 && maze[point[0]+ 2][point[1]] == 0){
            maze[point[0]][point[1]] = 0;
            maze[point[0] + 1][point[1]] = 0;
            zones.remove(point[0] + " " + point[1]);
            return new int[]{point[0], point[1]};
        }
        else {
            zones.remove(0);
            return new int[]{-1, -1};
        }
    }


    private boolean checkStep(int[] coord, int nb){
        int[] t = new int[2];
        t[0] = coord[0];
        t[1] = coord[1];
        switch (nb){
            case 0:
                t[0] -= 2;
                if (chAr(t)){
                    zones.remove(t[0] + " " + t[1]);
                    maze[coord[0] - 2][coord[1]] = 0;
                    maze[coord[0] - 1][coord[1]] = 0;
                    coord[0] -= 2;
                    return true;
                }
                break;
            case 1:
                t[1] += 2;
                if (chAr(t)){
                    zones.remove(t[0] + " " + t[1]);
                    maze[coord[0]][coord[1] + 2] = 0;
                    maze[coord[0]][coord[1] + 1] = 0;
                    coord[1] += 2;
                    return true;
                }
                break;
            case 2:
                t[0] += 2;
                if (chAr(t)){
                    zones.remove(t[0] + " " + t[1]);
                    maze[coord[0] + 2][coord[1]] = 0;
                    maze[coord[0] + 1][coord[1]] = 0;
                    coord[0] += 2;
                    return true;
                }
                break;
            case 3:
                t[1] -= 2;
                if (chAr(t)){
                    zones.remove(t[0] + " " + t[1]);
                    maze[coord[0]][coord[1] - 2] = 0;
                    maze[coord[0]][coord[1] - 1] = 0;
                    coord[1] -= 2;
                    return true;
                }
                break;
        }
        return false;
    }

    private boolean chAr(int[] nb){
        for (String a : zones){
            if (Integer.parseInt(a.split("\\s+")[0]) == nb[0] && Integer.parseInt(a.split("\\s+")[1]) == nb[1])
                return true;
        }
        return false;
    }


    private void fillZones(){
        for (int i = 1; i < maze.length; i+=2){
            for (int k = 1; k < maze[0].length; k+=2){
                zones.add(i + " " + k);
            }
        }
    }

    public int[][] getMaze() {
        return maze;
    }

    void printBrick(){
        for (int[] i : maze){
            for (int k : i){
                outBrick(k);
            }
            System.out.println("");
        }

    }

    private void outBrick(int i){
        System.out.print(i == 0? "  " : "\u2592" + "\u2592");
    }
}
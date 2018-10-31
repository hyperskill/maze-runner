package mazeRunner;

import javafx.util.Pair;

public class Maze {
    private int[][] maze;
    private Pair<Integer,Integer> size = new Pair<>(20,20);
    public Maze(){

        maze = new int[][]{
                {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,0,0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,0,0,1,1},
                {1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,0,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1},
        };
       
    }

    public void printMaze(){
        for(int[] string:maze) {
            for (int symb : string)
                System.out.print(symb == Field.Pass.getKey() ? Field.Pass.getVal():Field.Wall.getVal());
            System.out.println();
        }

    }
    enum Field{
        Pass("\u00A0\u00A0",0),Wall("\u2592\u2592",1);
        private String val;
        private int key;
        Field(String val,int key){
            this.val = val;
            this.key = key;
        }
        String getVal(){
            return val;
        }

        public int getKey() {
            return key;
        }


    }
}

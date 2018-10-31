package mazeRunner;

import javafx.util.Pair;

public class Maze {
    private int[][] maze;
    private Pair<Integer,Integer> size = new Pair<>(20,20);
    public Maze(){

        maze = new int[size.getKey()][size.getValue()];
        for(int i = 0; i < size.getKey(); i ++)
            for(int j = 0;j < size.getValue(); j++)
                if(i == j)
                    maze[i][j] = Field.Pass.getKey();
                else
                    maze[i][j] = Field.Wall.getKey();

    }

    public void printMaze(){
        for(int[] string:maze) {
            for (int symb : string)
                System.out.print(symb == Field.Pass.getKey() ? Field.Pass.getVal():Field.Wall.getVal());
            System.out.println();
        }

    }
    enum Field{
        Pass("  ",0),Wall("\u2592",1);
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

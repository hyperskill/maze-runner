package mazeRunner;

import javafx.util.Pair;

public class Maze {
    private String[][] maze;
    private Pair<Integer,Integer> size = new Pair<>(20,20);
    public Maze(){

        maze = new String[size.getKey()][size.getValue()];
        for(int i = 0; i < size.getKey(); i ++)
            for(int j = 0;j < size.getValue(); j++)
                if(i == j)
                    maze[i][j] = Field.Pass.getVal();
                else
                    maze[i][j] = Field.Wall.getVal();

    }

    public void printMaze(){
        for(String[] string:maze) {
            for (String symb : string)
                System.out.print(symb);
            System.out.println();
        }

    }
    enum Field{
        Pass("  "),Wall("\u2592");
        private String val;
        Field(String val){
            this.val = val;
        }
        String getVal(){
            return val;
        }
    }
}

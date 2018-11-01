package mazeRunner;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Maze {
    private final int[][] maze;
    private final Pair<Integer, Integer> size;

    public Maze(Pair<Integer, Integer> size) {
        this.size = size;
        maze = new int[size.getKey()][size.getValue()];
        for (int i = 0; i < size.getKey(); i++)
            for (int j = 0; j < size.getValue(); j++)
                maze[i][j] = Field.Wall.getKey();
        generate();
    }

    private ArrayList<Pair<Integer, Integer>> getNeighbours(Pair<Integer, Integer> cell) {
        ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();
        if (cell.getKey() != 0)
            result.add(new Pair<>(cell.getKey() - 1, cell.getValue()));

        if (cell.getKey() != size.getKey() - 1)
            result.add(new Pair<>(cell.getKey() + 1, cell.getValue()));

        if (cell.getValue() != 0)
            result.add(new Pair<>(cell.getKey(), cell.getValue() - 1));

        if (cell.getValue() != size.getValue() - 1)
            result.add(new Pair<>(cell.getKey(), cell.getValue() + 1));
        return result;

    }

    private boolean checkBlock(Pair<Integer, Integer> cell) {
        return getNeighbours(cell).size() >= 4 && getNeighbours(cell).
                stream().filter(element -> maze[element.getKey()][element.getValue()] == 0).count() == 1;
    }

    private void checkWalls(ArrayList<Pair<Integer, Integer>> walls) {
        int i = ThreadLocalRandom.current().nextInt(0, walls.size());
        if (checkBlock(walls.get(i))) {
            maze[walls.get(i).getKey()][walls.get(i).getValue()] = Field.Pass.getKey();
            walls.addAll(getNeighbours(walls.get(i)));
            walls.remove(i);

        }

        walls.remove(i);


    }

    private void generate() {

        int x = ThreadLocalRandom.current().nextInt(1, size.getValue() - 2);
        maze[0][x] = Field.Pass.getKey();
        ArrayList<Pair<Integer, Integer>> walls = new ArrayList<>(getNeighbours(new Pair<>(0, x)));
        while (walls.size() > 0)
            checkWalls(walls);
        for (int i = 0; i < size.getValue(); i++)
            if (maze[size.getKey() - 2][i] == Field.Pass.getKey()) {
                maze[size.getKey() - 1][i] = Field.Pass.getKey();
                break;
            }
    }


    public void printMaze() {
        for (int[] string : maze) {
            for (int symbol : string)
                System.out.print(symbol == Field.Pass.getKey() ? Field.Pass.getVal() : Field.Wall.getVal());
            System.out.println();
        }

    }

    enum Field {
        Pass("\u00A0\u00A0", 0), Wall("\u2592\u2592", 1);
        private final String val;
        private final int key;

        Field(String val, int key) {
            this.val = val;
            this.key = key;
        }

        String getVal() {
            return val;
        }

        int getKey() {
            return key;
        }
    }
}

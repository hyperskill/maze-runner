package mazeRunner;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze(Dialog.getSize());
        maze.printMaze();
    }
}
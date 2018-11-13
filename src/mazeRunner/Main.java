package mazeRunner;

public class Main {
    public static void main(String[] args) {
        displayMaze(20, 20);
    }

    public static void displayMaze(int columnsNumber, int linesNumber) {

        int[][] maze = new int[columnsNumber][linesNumber];
        int a = columnsNumber;
        int b = linesNumber;

        char isWall = '\u2593'; // 1 = isWall
        char noWall = ' ';         // 0 = noWal

//create Maze
        for (int x = 0; x < columnsNumber; x++) {
            for (int y = 0; y < linesNumber; y++) {

                if (y == 1) {
                    maze[x][y] = 0;
                } //if y

                else {
                    maze[x][y] = 1;
                }//else

            } //for y
        } //for x

//display Maze
        for (int x = 0; x < columnsNumber; x++) {
            for (int y = 0; y < linesNumber; y++) {

                if (y == 1) {
                    System.out.print(noWall);
                    System.out.print(noWall);
                } //if y

                else {
                    System.out.print(isWall);
                    System.out.print(isWall);
                }//else

            } //for y
            System.out.println();
        } //for x

    } //display
}

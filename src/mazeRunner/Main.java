package mazeRunner;

public class Main {
    public static void main(String[] args) {

        int[][] maze = new int [20][20];
        for (int i = 0;i<20; i++){
            for (int j = 0; j<20; j++){
                if ( j == 0||j==19||i==0||i==19)
                    maze[i][j] =1;
            }
        }
        for (int i = 0;i<20; i++){
            for (int j = 0; j<20; j++){
                if (  maze[i][j] == 0) {
                    System.out.print("  ");
                } else if ( maze[i][j] == 1){
                    System.out.print("\u2592");
                }
            }
            System.out.print("\n");
        }

    }
}
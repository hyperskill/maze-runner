package mazeRunner;

import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        int N = 20, M = 20;
        int[][] array = new int[N][M];
        createAndFillArray(array, N, M);
        printMaze(array, N, M);
    }

    private static void printMaze(int[][] array, int N, int M)
    {
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < M; j++)
            {
                if(array[i][j] == 0)
                {
                    System.out.print("  ");
                }else
                {
                    System.out.print("\u2592\u2592");
                }
            }
            System.out.println();
        }
    }


    private static void createAndFillArray(int[][] array, int N, int M)
    {
        Random random = new Random();
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < M; j++)
            {
                array[i][j] = random.nextInt(2);
            }
        }
        //return array;
    }
}
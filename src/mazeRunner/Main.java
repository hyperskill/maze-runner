package mazeRunner;

import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        Random random = new Random();
        int[][] array = new int[20][20];
        for(int i = 0; i < 20; i++)
        {
            for (int j = 0; j < 20; j++)
            {
                array[i][j] = random.nextInt(2);
            }
        }
        for(int i = 0; i < 20; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                if(array[i][j] == 0)
                {
                    System.out.print("  ");
                }else
                {
                    System.out.print("\u2592\u2592");
                }
            }
            System.out.print("\n");
        }
    }
}
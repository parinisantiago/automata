package robot;

import java.util.Random;
import java.awt.Point;

/**
 * Created by santiago.parini on 10/13/2017.
 */
public class Playground
{
    private int height;
    private int width;
    private boolean[][] board;

    public Playground(int height, int width)
    {
        this.height = height;
        this.width = width;
        this.board = new boolean[height][width];
        Random generator = new Random();

        for(int y = 0; y < height; y++ )
        {
            for(int x = 0; x < width; x++)
            {
                this.board[x][y] = generator.nextBoolean();
            }
        }
    }

    public int getHeight()
    {
        return this.height;
    }

    public int getWidth()
    {
        return this.width;
    }

    public void clean(Point robotPos)
    {
        this.board[robotPos.x][robotPos.y] = true;
    }

    public boolean isDirty(Point robotPos)
    {
        return !this.board[robotPos.x][robotPos.y];
    }

    public void print(Point robotPos)
    {
        System.out.println("---------------------");

        for(int y = 0; y < height; y++ )
        {
            String line = "|";

            for(int x = 0; x < width; x++)
            {
                if((x == robotPos.x) && (y == robotPos.y)) line += "\u001B[31m R \u001B[0m|";
                else if (this.board[x][y]) line += "\u001B[32m L \u001B[0m|";
                else line += "\u001B[36m S \u001B[0m|";
            }
            System.out.println(line);
            System.out.println("---------------------");
        }
    }
}

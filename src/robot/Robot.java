package robot;

import java.awt.Point;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by santiago.parini on 10/13/2017.
 */
public class Robot
{
    private HashSet<Point> unvisitedCells;
    private Playground playground;
    private Point pos;

    public Robot(Playground playground)
    {
        this.playground = playground;
        this.unvisitedCells = new HashSet<>();

        Random generator = new Random();
        int height = playground.getHeight();
        int width = playground.getWidth();

        //this.pos = new Point(generator.nextInt(width),generator.nextInt(height));
        this.pos = new Point();

        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                unvisitedCells.add(new Point(x,y));
            }
        }
    }

    public boolean visitedAll()
    {
        return this.unvisitedCells.isEmpty();
    }

    public Point getPos()
    {
        return this.pos;
    }

    public void clean()
    {
        if (this.playground.isDirty(this.pos)) this.playground.clean(this.pos);
        this.unvisitedCells.remove(this.pos);
        this.move();
    }

    private void move()
    {
      if (this.lookUp()) this.moveUp();
      else if (this.lookDown()) this.moveDown();
      else if (this.lookRight()) this.moveRight();
      else if (this.lookLeft()) this.moveLeft();
      else this.moveUnvisitedCell();
    }

    private boolean lookUp()
    {
      return this.getPos().y + 1 >= 0 && this.playground.isDirty(new Point(this.getPos().x,this.getPos().y + 1));
    }

    private boolean lookDown()
    {
        return this.getPos().y - 1 <= this.playground.getHeight() && this.playground.isDirty(new Point(this.getPos().x,this.getPos().y - 1));
    }

    private boolean lookRight()
    {
        return this.getPos().x + 1 <= this.playground.getWidth() && this.playground.isDirty(new Point(this.getPos().x + 1,this.getPos().y));
    }

    private boolean lookLeft()
    {
        return this.getPos().x - 1 >= 0 && this.playground.isDirty(new Point(this.getPos().x - 1,this.getPos().y));
    }

    private void moveUp()
    {
        this.pos.move(this.pos.x,this.pos.y + 1);
    }

    private void moveDown()
    {
        this.pos.move(this.pos.x,this.pos.y - 1);
    }

    private void moveRight()
    {
        this.pos.move(this.pos.x,this.pos.y + 1);
    }

    private void moveLeft()
    {
        this.pos.move(this.pos.x,this.pos.y + 1);
    }

    private void moveUnvisitedCell()
    {

    }
}

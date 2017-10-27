package robot;

/**
 * Created by santiago.parini on 10/13/2017.
 */
public class Enviroment
{

    private static final int height = 5;
    private static final int widht = 5;

    public static void main(String[] args)
    {
        Playground playground = new Playground(height,widht);
        Robot robot = new Robot(playground);
        playground.print(robot.getPos());

        while(! robot.visitedAll())
        {
            robot.clean();
            playground.print(robot.getPos());
        }
    }

}

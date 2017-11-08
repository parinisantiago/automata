package robot;

import java.util.concurrent.TimeUnit;

/**
 * Created by santiago.parini on 10/13/2017.
 */
public class Enviroment
{

    private static final int height = 5;
    private static final int widht = 5;
    private static final int waitTime = 1;

    public static void main(String[] args)
    {
        Playground playground = new Playground(height,widht);
        Robot robot = new Robot(playground);
        playground.print(robot.getPos());
        try
        {
            while(playground.isDirty())
            {
            robot.clean();
            playground.print(robot.getPos());
            TimeUnit.SECONDS.sleep(waitTime);
            }
        } catch (Exception e){System.out.print("Error");}

    }

}

import model.TrianglePuzzle;
import view.MainFrame;


/**
 * Created by Hzy on 2021/9/22.
 */
public class Main
{
    public static void main(String[] args)
    {
        TrianglePuzzle puzzle = new TrianglePuzzle();
        MainFrame frame = new MainFrame(puzzle);
        frame.setVisible(true);
    }
}

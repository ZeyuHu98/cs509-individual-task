package controller;

import model.TrianglePuzzle;
import view.MainFrame;

/**
 * Created by Hzy on 2021/9/25.
 */
public class RestartController
{
    TrianglePuzzle puzzle;
    MainFrame frame;

    public RestartController(TrianglePuzzle puzzle, MainFrame frame)
    {
        this.puzzle = puzzle;        this.frame = frame;
    }

    public void restart()
    {
        puzzle.restart();
        frame.enableSwap(puzzle.canSwap());
        frame.getStatus();
        frame.repaint();
    }
}

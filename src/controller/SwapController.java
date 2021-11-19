package controller;

import model.TrianglePuzzle;
import view.MainFrame;

/**
 * Created by Hzy on 2021/9/25.
 */
public class SwapController
{
    TrianglePuzzle puzzle;
    MainFrame frame;

    public SwapController(TrianglePuzzle puzzle, MainFrame frame)
    {
        this.puzzle = puzzle;
        this.frame = frame;
    }

    public void swapEdges()
    {
        puzzle.swapEdges();
        frame.getStatus();
        frame.enableSwap(puzzle.canSwap());
        frame.repaint();
        frame.revalidate();
        if (puzzle.hasSolved())
            frame.solve();
    }
}

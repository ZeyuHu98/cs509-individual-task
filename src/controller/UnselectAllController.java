package controller;

import model.TrianglePuzzle;
import view.MainFrame;

/**
 * Created by Hzy on 2021/9/25.
 */
public class UnselectAllController
{
    TrianglePuzzle puzzle;
    MainFrame frame;

    public UnselectAllController(TrianglePuzzle puzzle, MainFrame frame)
    {
        this.puzzle = puzzle;
        this.frame = frame;
    }

    public void unselectAll()
    {
        puzzle.unselectAll();
        frame.enableSwap(puzzle.canSwap());
        frame.repaint();
        // change pnlPuzzle
    }
}

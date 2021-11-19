package controller;

import model.TrianglePuzzle;
import view.MainFrame;

/**
 * Created by Hzy on 2021/9/25.
 */

public class SelectController
{
    TrianglePuzzle puzzle;
    MainFrame frame;

    public SelectController(MainFrame frame, TrianglePuzzle puzzle)
    {
        this.frame = frame;
        this.puzzle = puzzle;
    }

    public void select(int id)
    {
        puzzle.selectNode(id);
        frame.enableSwap(puzzle.canSwap());
        frame.repaint();
    }
}

package view;

import controller.RestartController;
import controller.SelectController;
import controller.SwapController;
import controller.UnselectAllController;
import model.TrianglePuzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Hzy on 2021/9/25.
 */
public class MainFrame extends JFrame
{
    private final Container container;

    Graphics2D g;
    TrianglePuzzle puzzle;
    PuzzlePanel pnlPuzzle;
    JTextField fldScore, fldSteps;
    JButton btnUnselectAll, btnSwap, btnRestart;

    public PuzzlePanel getPuzzlePanel() {
        return pnlPuzzle;
    }
    public JTextField getScoreField()
    {
        return fldScore;
    }
    public JTextField getStepsField()
    {
        return fldSteps;
    }
    public JButton getUnselectAllButton()
    {
        return btnUnselectAll;
    }
    public JButton getSwapButton()
    {
        return btnSwap;
    }
    public JButton getRestartButton()
    {
        return btnRestart;
    }

    public MainFrame(TrianglePuzzle puzzle)
    {
        super();
        this.puzzle = puzzle;
        setTitle("Triangle Puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(null);
        setResizable(false);
        container = getContentPane();

        pnlPuzzle = new PuzzlePanel(puzzle);
        pnlPuzzle.setLayout(null);
        pnlPuzzle.setBounds(60, 20, 280, 280);
        pnlPuzzle.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new SelectController(MainFrame.this, puzzle).select(pnlPuzzle.getNodeId(e.getPoint()));
            }
        });

        fldScore = new JTextField();
        fldScore.setBounds(0,20,70,30);
        fldScore.setEditable(false);
        pnlPuzzle.add(fldScore);
        fldSteps = new JTextField();
        fldSteps.setBounds(210,20,70, 30);
        fldSteps.setEditable(false);
        pnlPuzzle.add(fldSteps);
        getStatus();

        btnSwap = new JButton("Swap Edges");
        enableSwap(puzzle.canSwap());
        btnSwap.addActionListener(actionEvent -> new SwapController(puzzle, MainFrame.this).swapEdges());
        btnSwap.setBounds(150, 350, 120, 40);

        btnUnselectAll = new JButton("Unselect All");
        btnUnselectAll.addActionListener(actionEvent -> new UnselectAllController(puzzle, MainFrame.this).unselectAll());
        btnUnselectAll.setBounds(150, 410, 120, 40);

        btnRestart = new JButton("Restart Puzzle");
        btnRestart.addActionListener(actionEvent -> new RestartController(puzzle, MainFrame.this).restart());
        btnRestart.setBounds(150, 470, 120, 40);

        container.add(pnlPuzzle);
        container.add(btnSwap);
        container.add(btnUnselectAll);
        container.add(btnRestart);
    }

    public void getStatus()
    {
        fldScore.setText("Score: "+puzzle.getScore());
        fldSteps.setText("Steps: "+puzzle.getSteps());
    }

    public void solve()
    {
        JOptionPane.showMessageDialog(this,
                "You have solved the puzzle! Your score is " + puzzle.getScore() +
                        " and you steps is " + puzzle.getSteps() + "!");
        puzzle.restart();
        getStatus();
        repaint();
    }

    public void enableSwap(boolean b)
    {
        btnSwap.setEnabled(b);
    }
}

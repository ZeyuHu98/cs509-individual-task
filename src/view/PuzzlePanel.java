package view;

import model.TrianglePuzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Created by Hzy on 2021/9/25.
 */
public class PuzzlePanel extends JPanel
{
    static final double D = 1.732;

    Rectangle2D[] points;
    Line2D[] lines;
    TrianglePuzzle puzzle;
    Graphics2D g2d;

    public PuzzlePanel(TrianglePuzzle puzzle)
    {
        this.puzzle = puzzle;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        int a = getWidth();
        int x = 20;
        int l = (a-x)/3;

        super.paintComponent(g);
        g2d = (Graphics2D) g;
        Stroke s1 = new BasicStroke(1.5f);
        Stroke s2 = new BasicStroke(4);
        g2d.setStroke(s1);
        Point2D[] point2Ds = new Point2D[10];

        // initial points
        points = new Rectangle2D[10];
        points[0] = new Rectangle2D.Double((a-x)/2.0, a-x-3*l*D/2, x, x);
        points[1] = new Rectangle2D.Double(a-x-2*l, a-x-l*D, x, x);
        points[2] = new Rectangle2D.Double(a-x-l, a-x-l*D, x, x);
        points[3] = new Rectangle2D.Double((a-x)/2.0-l, a-x-l*D/2, x, x);
        points[4] = new Rectangle2D.Double((a-x)/2.0, a-x-l*D/2, x, x);
        points[5] = new Rectangle2D.Double((a-x)/2.0+l, a-x-l*D/2, x, x);
        points[6] = new Rectangle2D.Double(0, a-x-1,x,x);
        points[7] = new Rectangle2D.Double(l, a-x-1, x, x);
        points[8] = new Rectangle2D.Double(2*l, a-x-1, x, x);
        points[9] = new Rectangle2D.Double(a-x-1,a-x-1,x,x);

        point2Ds[0] = new Point2D.Double((a-x)/2.0+10, a-x-3*l*D/2+10);
        point2Ds[1] = new Point2D.Double(a-x-2*l+10, a-x-l*D+10);
        point2Ds[2] = new Point2D.Double(a-x-l+10, a-x-l*D+10);
        point2Ds[3] = new Point2D.Double((a-x)/2.0-l+10, a-x-l*D/2+10);
        point2Ds[4] = new Point2D.Double((a-x)/2.0+10, a-x-l*D/2+10);
        point2Ds[5] = new Point2D.Double((a-x)/2.0+l+10, a-x-l*D/2+10);
        point2Ds[6] = new Point2D.Double(10, a-x-1+10);
        point2Ds[7] = new Point2D.Double(l+10, a-x-1+10);
        point2Ds[8] = new Point2D.Double(2*l+10, a-x-1+10);
        point2Ds[9] = new Point2D.Double(a-x-1+10,a-x-1+10);

        // draw points
        for (int i = 0; i < 10; i++)
        {
            if (puzzle.selectedNodes.size() != 0 && puzzle.selectedNodes.contains(i))
                g2d.fill(points[i]);
            else
                g2d.draw(points[i]);
        }

        // initial lines
        lines = new Line2D[18];
        lines[0] = new Line2D.Double(point2Ds[0], point2Ds[1]);
        lines[1] = new Line2D.Double(point2Ds[0], point2Ds[2]);
        lines[2] = new Line2D.Double(point2Ds[1], point2Ds[2]);
        lines[3] = new Line2D.Double(point2Ds[1], point2Ds[3]);
        lines[4] = new Line2D.Double(point2Ds[1], point2Ds[4]);
        lines[5] = new Line2D.Double(point2Ds[3], point2Ds[4]);
        lines[6] = new Line2D.Double(point2Ds[2], point2Ds[4]);
        lines[7] = new Line2D.Double(point2Ds[2], point2Ds[5]);
        lines[8] = new Line2D.Double(point2Ds[4], point2Ds[5]);
        lines[9] = new Line2D.Double(point2Ds[3], point2Ds[6]);
        lines[10] = new Line2D.Double(point2Ds[3], point2Ds[7]);
        lines[11] = new Line2D.Double(point2Ds[6], point2Ds[7]);
        lines[12] = new Line2D.Double(point2Ds[4], point2Ds[7]);
        lines[13] = new Line2D.Double(point2Ds[4], point2Ds[8]);
        lines[14] = new Line2D.Double(point2Ds[7], point2Ds[8]);
        lines[15] = new Line2D.Double(point2Ds[5], point2Ds[8]);
        lines[16] = new Line2D.Double(point2Ds[5], point2Ds[9]);
        lines[17] = new Line2D.Double(point2Ds[8], point2Ds[9]);

        // draw lines
        for (int i = 0; i < 18; i++)
        {
            if (puzzle.selectedEdges.contains(i))
                g2d.setStroke(s2);
            else
                g2d.setStroke(s1);
            switch (puzzle.edges[i].color)
            {
                case 1:
                    g2d.setColor(Color.RED);
                    break;
                case 2:
                    g2d.setColor(Color.GREEN);
                    break;
                case 3:
                    g2d.setColor(Color.BLUE);
                    break;
            }
            g2d.draw(lines[i]);
        }

        // initial lines
    }

    public int getNodeId(Point p)
    {
        for (int i = 0;i < points.length; i++)
            if (points[i].contains(p))
                return i;
        return -1;
    }
}

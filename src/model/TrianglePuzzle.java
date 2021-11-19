package model;

import java.util.*;

/**
 * Created by Hzy on 2021/9/22.
 * TrianglePuzzle Entity
 *
 * constructor()
 * selectNode(int id)
 * unselectAll()
 * swapEdges()
 * updateStatus()
 * hasWin()
 * restart()
 */
public class TrianglePuzzle
{
    Node[] nodes;
    public Edge[] edges;
    Triangle[] triangles;
    public LinkedList<Integer> selectedNodes;
    public LinkedList<Integer> selectedEdges;
    HashSet<Triangle> solvedTriangles;
    int score;
    int steps;

    /**
     * constructor
     */
    public TrianglePuzzle()
    {
        nodes = new Node[10];
        edges = new Edge[18];
        triangles = new Triangle[6];
        selectedNodes = new LinkedList<>();
        selectedEdges = new LinkedList<>();
        solvedTriangles = new HashSet<>();
        score = 0;
        steps = 0;

        // initialize nodes
        for (int i = 0; i < 10; i++)
            nodes[i] = new Node(i);

        // initialize edges
        Node[] temp = {nodes[0], nodes[1]};
        edges[0] = new Edge(0, temp.clone(), 1);    // edge 01
        temp[1] = nodes[2];
        edges[1] = new Edge(1, temp.clone(), 1);    // edge 02
        temp[0] = nodes[1];
        edges[2] = new Edge(2, temp.clone(), 2);    // edge 12
        temp[1] = nodes[3];
        edges[3] = new Edge(3, temp.clone(), 1);    // edge 13
        temp[1] = nodes[4];
        edges[4] = new Edge(4, temp.clone(), 3);    // edge 14
        temp[0] = nodes[3];
        edges[5] = new Edge(5, temp.clone(), 2);    // edge 34
        temp[0] = nodes[2];
        edges[6] = new Edge(6, temp.clone(), 3);    // edge 24
        temp[1] = nodes[5];
        edges[7] = new Edge(7, temp.clone(), 1);    // edge 25
        temp[0] = nodes[4];
        edges[8] = new Edge(8, temp.clone(), 2);    // edge 45
        temp[0] = nodes[3];
        temp[1] = nodes[6];
        edges[9] = new Edge(9, temp.clone(), 1);    // edge 36
        temp[1] = nodes[7];
        edges[10] = new Edge(10, temp.clone(), 3);    // edge 37
        temp[0] = nodes[6];
        edges[11] = new Edge(11, temp.clone(), 2);    // edge 67
        temp[0] = nodes[4];
        edges[12] = new Edge(12, temp.clone(), 3);    // edge 47
        temp[1] = nodes[8];
        edges[13] = new Edge(13, temp.clone(), 3);    // edge 48
        temp[0] = nodes[7];
        edges[14] = new Edge(14, temp.clone(), 2);    // edge 78
        temp[0] = nodes[5];
        edges[15] = new Edge(15, temp.clone(), 3);    // edge 58
        temp[1] = nodes[9];
        edges[16] = new Edge(16, temp.clone(), 1);    // edge 59
        temp[0] = nodes[8];
        edges[17] = new Edge(17, temp.clone(), 2);    // edge 89

        // add edges to nodes
        for (Edge e: edges)
            for (Node n: e.nodes)
                n.edges.add(e);

        // initialize triangles
        for (int i = 0; i < 6; i++)
        {
            Edge[] threeEdge = {edges[3*i], edges[3*i+1], edges[3*i+2]};
            triangles[i] = new Triangle(i, threeEdge);
        }
    }

    /**
     * select or unselect nodes[id]
     * @param id node id
     */
    public void selectNode(int id)
    {
        if (id == -1)
            return;
        boolean b = nodes[id].select();
        if (b)
        {
            for (Edge e: nodes[id].edges)
            {
                boolean allSelected = true;
                for (Node n: e.nodes)
                {
                    if (!n.selected)
                    {
                        allSelected = false;
                        break;
                    }
                }
                if (allSelected)
                {
                    e.selected = true;
                    selectedEdges.add(e.id);
                }
            }
            selectedNodes.add(id);
        }
        else
        {
            for (Edge e: nodes[id].edges)
            {
                e.selected = false;
                if (selectedEdges.contains(e.id))
                    selectedEdges.remove((Integer) e.id);
            }
            selectedNodes.remove((Integer) id);
        }
    }

    /**
     * unselect all nodes and edges
     */
    public void unselectAll()
    {
        for (Node n: nodes)
            n.selected = false;
        for (Edge e: edges)
            e.selected = false;
        selectedNodes = new LinkedList<>();
        selectedEdges = new LinkedList<>();
    }

    /**
     * swap selected edges
     */
    public void swapEdges()
    {

        if (selectedEdges.size() == 3) // selected edges forms a triangle
        {
            selectedEdges.sort(Comparator.comparingInt(e -> e));
            if (selectedEdges.get(2) - selectedEdges.get(1) == 1) // positive triangle
            {
                exchangeColor(edges[selectedEdges.get(0)],edges[selectedEdges.get(1)]);
                exchangeColor(edges[selectedEdges.get(0)],edges[selectedEdges.get(2)]);
            }
            else                                                        // negative triangle
            {
                exchangeColor(edges[selectedEdges.get(0)], edges[selectedEdges.get(2)]);
                exchangeColor(edges[selectedEdges.get(0)], edges[selectedEdges.get(1)]);
            }
            updateStatus();
            unselectAll();
        }
        else if (selectedEdges.size() == 2)
        {
            exchangeColor(edges[selectedEdges.get(0)], edges[selectedEdges.get(1)]);
            updateStatus();
            unselectAll();
        }
    }

    /**
     * update score and steps, including count the number of solved triangles
     * check if the puzzle has been solved
     */
    public void updateStatus()
    {
        for (Triangle t: triangles)
        {
            if (t.hasSolved())
                solvedTriangles.add(t);
            else
                solvedTriangles.remove(t);
        }
        steps += 1;
        score = solvedTriangles.size() * 10 - steps;
    }

    /**
     * @return whether player has win
     */
    public boolean hasSolved()
    {
        return solvedTriangles.size() == 6;
    }


    /**
     * restart triangle puzzle
     */
    public void restart()
    {
        selectedNodes = new LinkedList<>();
        selectedEdges = new LinkedList<>();
        solvedTriangles = new HashSet<>();
        score = 0;
        steps = 0;

        unselectAll();
        for (Edge e: edges)
            e.color = e.initialColor;
    }

    /**
     * exchange color of edge1 and edge2
     * @param e1 edge1
     * @param e2 edge2
     */
    public void exchangeColor(Edge e1, Edge e2)
    {
        int color = e1.color;
        e1.color = e2.color;
        e2.color = color;
    }

    public boolean canSwap()
    {
        return selectedNodes.size() == 3 && (selectedEdges.size() == 2 || selectedEdges.size() == 3);
    }

    public int getScore()
    {
        return this.score;
    }
    public int getSteps()
    {
        return this.steps;
    }
}

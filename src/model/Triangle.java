package model;

/**
 * Created by Hzy on 2021/9/22.
 * Triangle Entity
 */
public class Triangle
{
    int id;
    Edge[] edges;
    boolean solved;

    public Triangle(int id, Edge[] edges)
    {
        this.id = id;
        this.edges = edges;
        this.solved = false;
    }

    public boolean hasSolved()
    {
        solved = edges[0].color == edges[1].color && edges[1].color == edges[2].color;
        return solved;
    }
}

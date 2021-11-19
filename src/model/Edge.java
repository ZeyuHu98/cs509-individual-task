package model;

/**
 * Created by Hzy on 2021/9/22.
 * Edge Entity
 */
public class Edge
{
    int id;
    Node[] nodes;
    boolean selected;
    public int color;
    public int initialColor;

    public Edge(int id, Node[] nodes, int initialColor)
    {
        this.id = id;
        this.nodes = nodes;
        this.selected = false;
        this.initialColor = initialColor;
        this.color = initialColor;
    }

    public void changeColor(int color)
    {
        this.color = color;
    }
}

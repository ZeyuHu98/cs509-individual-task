package model;

import java.util.LinkedList;

/**
 * Created by Hzy on 2021/9/22.
 * Node entity
 */
public class Node
{
    int id;
    boolean selected;
    LinkedList<Edge> edges;

    public Node(int id)
    {
        this.id = id;
        this.selected = false;
        edges = new LinkedList<>();
    }

    public boolean select()
    {
        selected = !selected;
        return selected;
    }
}

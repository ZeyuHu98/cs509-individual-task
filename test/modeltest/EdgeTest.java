package modeltest;

import model.Edge;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Hzy on 2021/10/6.
 */
public class EdgeTest {
    Edge edge;

    @Before
    public void testEdge()
    {
        edge = new Edge(0, null, 1);
    }

    @Test
    public void testChangeColor()
    {
        edge.changeColor(2);
        Assert.assertEquals(edge.color, 2);
    }
}
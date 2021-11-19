package modeltest;

import model.Edge;
import model.Triangle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Hzy on 2021/10/6.
 */
public class TriangleTest
{
    Triangle triangle1;
    Triangle triangle2;
    @Before
    public void testTriangle()
    {
        Edge[] edges1 = new Edge[3];
        edges1[0] = new Edge(0, null, 1);
        edges1[1] = new Edge(0, null, 2);
        edges1[2] = new Edge(0, null, 3);
        triangle1 = new Triangle(0, edges1);
        
        Edge[] edges2 = new Edge[3];
        edges2[0] = new Edge(0, null, 1);
        edges2[1] = new Edge(0, null, 1);
        edges2[2] = new Edge(0, null, 1);
        triangle2 = new Triangle(1, edges2);
    }
    
    
    @Test
    public void testHasSolved()
    {
        Assert.assertTrue(!triangle1.hasSolved());
        Assert.assertTrue(triangle2.hasSolved());
    }
}
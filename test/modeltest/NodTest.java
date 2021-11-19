package modeltest;

import model.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Hzy on 2021/10/6.
 */
public class NodTest
{
    Node node;
    @Before
    public void testNode()
    {
        node = new Node(0);
    }

    @Test
    public void testSelect()
    {
        Assert.assertTrue(node.select());
    }
}
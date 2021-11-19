package modeltest;

import junit.framework.Assert;
import junit.framework.TestCase;
import model.TrianglePuzzle;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Hzy on 2021/10/6.
 */

public class TrianglePuzzleTest extends TestCase
{

    TrianglePuzzle trianglePuzzle = new TrianglePuzzle();

    @Test
    public void testSelectNode()
    {
    	trianglePuzzle.selectNode(0);
    	trianglePuzzle.selectNode(0);
    }
    
    @Test
    public void testUnselectAll()
    {
    	trianglePuzzle.unselectAll();
    }
    
    @Test
    public void testSwapEdges()
    {
    	trianglePuzzle.selectNode(0);
    	trianglePuzzle.selectNode(1);
    	trianglePuzzle.selectNode(2);
    	trianglePuzzle.swapEdges();
    	
    	trianglePuzzle.selectNode(1);
    	trianglePuzzle.selectNode(2);
    	trianglePuzzle.selectNode(3);
    	trianglePuzzle.swapEdges();
    	
    	trianglePuzzle.selectNode(3);
    	trianglePuzzle.selectNode(4);
    	trianglePuzzle.selectNode(7);
    	trianglePuzzle.swapEdges();
    }
    
    @Test
    public void testUpdateStatus()
    {
    	trianglePuzzle.updateStatus();
    }
    
    @Test
    public void testHasSolved()
    {
    	assertFalse(trianglePuzzle.hasSolved());
    }
    
    @Test
    public void testRestart()
    {
    	trianglePuzzle.restart();
    }
    
}
package controllertest;

import org.junit.Test;

import controller.SwapController;
import model.TrianglePuzzle;
import view.MainFrame;

public class SwapControllerTest 
{
	TrianglePuzzle puzzle = new TrianglePuzzle();
	MainFrame frame = new MainFrame(puzzle);
	SwapController controller = new SwapController(puzzle, frame);
	
	@Test
	public void testSwapEdges()
	{
		controller.swapEdges();
	}
}

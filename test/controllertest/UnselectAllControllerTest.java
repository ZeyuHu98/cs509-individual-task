package controllertest;

import org.junit.Test;

import controller.UnselectAllController;
import model.TrianglePuzzle;
import view.MainFrame;

public class UnselectAllControllerTest 
{
	TrianglePuzzle puzzle = new TrianglePuzzle();
	MainFrame frame = new MainFrame(puzzle);
	UnselectAllController controller = new UnselectAllController(puzzle, frame);
	
	@Test
	public void testUnselectAll()
	{
		controller.unselectAll();
	}
}

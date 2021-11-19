package controllertest;

import org.junit.Test;

import controller.RestartController;
import model.TrianglePuzzle;
import view.MainFrame;

public class RestartControllerTest 
{
	TrianglePuzzle puzzle = new TrianglePuzzle();
	MainFrame frame = new MainFrame(puzzle);
	RestartController controller = new RestartController(puzzle, frame);
	
	@Test
	public void testRestart()
	{
		controller.restart();
	}
}

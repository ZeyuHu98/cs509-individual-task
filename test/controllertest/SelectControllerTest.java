package controllertest;

import org.junit.Test;

import controller.SelectController;
import model.TrianglePuzzle;
import view.MainFrame;

public class SelectControllerTest 
{
	TrianglePuzzle puzzle = new TrianglePuzzle();
	MainFrame frame = new MainFrame(puzzle);
	SelectController controller = new SelectController(frame, puzzle);
	
	@Test
	public void selectTest()
	{
		controller.select(0);
	}
}

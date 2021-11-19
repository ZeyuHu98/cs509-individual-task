import org.junit.Test;

import model.TrianglePuzzle;
import view.MainFrame;

public class FrameTest
{
	TrianglePuzzle puzzle = new TrianglePuzzle();
	MainFrame frame = new MainFrame(puzzle);
	
	@Test
	public void testFrame()
	{
		frame.setVisible(true);
	}
}

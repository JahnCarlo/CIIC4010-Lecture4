import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyMain
{
	public static void main(String[] args) throws InterruptedException
	{
		JFrame frame = new JFrame();
		
		CarStage theComponent = new CarStage();
		
		frame.add(theComponent);
		
		frame.setSize(300, 400);
		frame.setTitle("CIIC 4010 / ICOM 4015 Developers");	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		while(!theComponent.getReachedBottom()) {
			frame.repaint();
			Thread.sleep(100);
		}
		
		JOptionPane optionPane = new JOptionPane("Car Reached Bottom",JOptionPane.WARNING_MESSAGE);
		JDialog dialog = optionPane.createDialog("Warning!");
		dialog.setAlwaysOnTop(true); // to show top of all other application
		dialog.setVisible(true); // to visible the dialog
		
	}
}

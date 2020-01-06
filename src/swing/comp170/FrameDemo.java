package swing.comp170;

import javax.swing.*;

@SuppressWarnings("serial")
public class FrameDemo extends JFrame {

	public FrameDemo() {
		
		// Using the superclass (JFrame) constructor to set the window title
		super("Simple Example");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * JPanel is a generic container for components.  In this case, a JLabel with the 
		 * text 'Hello World' is added to the JPanel. The JPanel is then added 
		 * to the JFrame (this class)
		 */
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Hello World");
		panel.add(label);
		add(panel);
		
		 /*
		  * call setVisible() after all components have been added. This is set to
		  * false by default, so if you want the frame/window to be seen, you must
		  * explicitly set this to true
		  */
		setVisible(true);
	}
	
	/*
	 * This sets the GUI's general appearance to a specific Look and Feel. In this
	 * case, its 'Nimbus'.  You may choose another Look and Feel, or delete the setLookAndFeel() 
	 * method altogether and go with the default Look and Feel.  
	 */

	private static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {

		setLookAndFeel();
		new FrameDemo();
	}

}

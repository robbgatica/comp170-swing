package swing.comp170.email;

import javax.swing.*;

@SuppressWarnings("serial")
public class EmailFrame extends JFrame {

	public EmailFrame() {
		super("Compose Message");
		setSize(600, 400);
		setLookAndFeel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EmailPanel panel = new EmailPanel();
		add(panel);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error loading Look and Feel: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		new EmailFrame();
	}

}

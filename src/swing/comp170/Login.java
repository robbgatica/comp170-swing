package swing.comp170;

import javax.swing.*;

@SuppressWarnings("serial")
public class Login extends JFrame {

	JTextField user = new JTextField(15);
	JPasswordField password = new JPasswordField(15);
	JTextArea comments = new JTextArea(4, 15);
	JScrollPane scrollPane = new JScrollPane(comments, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	JButton ok = new JButton("OK");
	JButton cancel = new JButton("Cancel");

	public Login() {

		super("Login Screen Demo");
		setSize(275, 220);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		JLabel userLabel = new JLabel("Username");
		JLabel passLabel = new JLabel("Password");
		JLabel commentsLabel = new JLabel("Comments");

		comments.setLineWrap(true);
		comments.setWrapStyleWord(true);

		// add components to panel
		panel.add(userLabel);
		panel.add(user);
		panel.add(passLabel);
		panel.add(password);
		panel.add(commentsLabel);
		panel.add(scrollPane);
		panel.add(ok);
		panel.add(cancel);

		// add panel to this class/JFrame
		add(panel);

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
		Login.setLookAndFeel();
		new Login();

	}

}

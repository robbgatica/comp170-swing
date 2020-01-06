package swing.comp170;

import javax.swing.*;

@SuppressWarnings("serial")
public class TabsDemo extends JFrame {

	public TabsDemo() {
		
		super("Tabbed Panes Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setSize(480, 218);

		JPanel index = new JPanel();
		JPanel chap1 = new JPanel();
		JPanel chap2 = new JPanel();
		JPanel chap3 = new JPanel();
		JPanel appendix = new JPanel();

		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Index", index);
		tabs.addTab("Chapter 1", chap1);
		tabs.addTab("Chapter 2", chap2);
		tabs.addTab("Chapter 3", chap3);
		tabs.addTab("Appendix", appendix);
		add(tabs);
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
		new TabsDemo();
	}

}

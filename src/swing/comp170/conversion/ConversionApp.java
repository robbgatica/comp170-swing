package swing.comp170.conversion;

import javax.swing.*;

@SuppressWarnings("serial")
public class ConversionApp extends JFrame {
	
	public ConversionApp() {
	
	super("Metric to Imperial Conversion Calculator");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLookAndFeel();
	setSize(480, 218);
	
	ConversionPanel temp = new ConversionPanel("temp");
	ConversionPanel dist = new ConversionPanel("dist");
	ConversionPanel mass = new ConversionPanel("mass");
	ConversionPanel vol = new ConversionPanel("vol");
	

	JTabbedPane tabs = new JTabbedPane();
	tabs.addTab("Temperature", temp);
	tabs.addTab("Distance", dist);
	tabs.addTab("Weight/Mass", mass);
	tabs.addTab("Volume", vol);
	add(tabs);
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
		new ConversionApp();

	}

}

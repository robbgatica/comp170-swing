package swing.comp170.conversion;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;

@SuppressWarnings("serial")
public class ConversionPanel extends JPanel implements ActionListener {

	final static double CELSIUS_CONST = 1.8, KM_CONST = 0.6213, KG_CONST = 2.2046, VOL_CONST = 0.26417;
	private String conversionType;
	private JTextField value1, result;
	private JLabel unit1, unit2, equals;
	private JButton calcButton;
	double total;
	

	public ConversionPanel(String conversionType) {
		super();
		this.conversionType = conversionType;

		// Layout
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		setLayout(layout);

		// Text Boxes
		value1 = new JTextField("0", 5);
		result = new JTextField("0", 5);

		// Labels
		equals = new JLabel("=");
		setUnits(this.conversionType);

		// Button
		calcButton = new JButton("Calculate");

		// Add Event Listener to Button
		calcButton.addActionListener(this);

		result.setEditable(false);

		// Add Components
		add(unit1);
		add(value1);
		add(equals);
		add(result);
		add(unit2);
		add(calcButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			double val1 = Double.parseDouble(value1.getText());
			DecimalFormat df = new DecimalFormat("###.00");
			if (conversionType == "temp") {
				total = val1 * CELSIUS_CONST + 32;
			} else if (conversionType == "dist") {
				total = val1 * KM_CONST;
			} else if (conversionType == "mass") {
				total = val1 * KG_CONST;
			} else if (conversionType == "vol") {
				total = val1 * VOL_CONST;
			}
			result.setText("" + df.format(total));
			
		} catch (NumberFormatException numEx) {
			value1.setText("0");
			result.setText("0");
		}

	}

	public void setUnits(String unitType) {
		switch (unitType) {
		case "temp":
			unit1 = new JLabel("Celsius");
			unit2 = new JLabel("F");
			break;
		case "dist":
			unit1 = new JLabel("km");
			unit2 = new JLabel("miles");
			break;
		case "mass":
			unit1 = new JLabel("kg");
			unit2 = new JLabel("lbs");
			break;
		case "vol":
			unit1 = new JLabel("liters");
			unit2 = new JLabel("gallons");
			break;
		default:
			unit1 = new JLabel("undefined");
			unit2 = new JLabel("undefined");
		}
	}

}

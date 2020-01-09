# Example Java Projects - Swing GUI

## Getting Started with Swing Components

---

Similar to SWT, Swing is a Java framework that allows you to create window-based GUI's and is built upon the AWT packages.  However, a huge benefit of Swing is that you don't have to do any additional configuration to add its components into your programs (unlike SWT or JavaFX). You can get going with a simple `import` statement at the beginning of your class file.  

Below you'll find a handful of examples and brief walk-throughs which will hopefully help you get a feel for working with Swing.  

---

## Example 1 - Hello World

To get started, we'll work with 3 of the most fundamental components of Swing: **JFrame** (windows/shells), **JPanel** (containers that hold components), and **JLabel** (text or graphics).  The end result will be a simple window that displays the text "Hello World!".  You can follow along with the source code [here](https://github.com/robbgatica/comp170-swing/blob/master/src/swing/comp170/FrameDemo.java).  

<p align="center">
<img src="images/frame.png" alt="frame-demo" width="250" height="250" />
  </p>

1.  To start out, create a new class in Eclipse. You can name it whatever you'd like (in this example I'm calling mine 'FrameDemo').  Then, import the required packages with `import javax.swing.*;` statement.   

2.  This class will inherit from the JFrame class using the `extends` keyword.  This is not strictly necessary, as you could instantiate a JFrame object inside the your class instead, and it would function exactly the same.  But for the sake of keeping it interesting, we'll just extend the functionality of JFrame directly to our class.

```
import javax.swing.*;

public class FrameDemo extends JFrame {

	public static void main(String[] args) {

	}

}
```

3.  Next, we'll create a constructor for our class, in which we will add a title to the window, set the size parameters (width and height in pixels) using  the `setSize()` method, and handle the exit/quit functionality with the `setDefaultCloseOperation()` method (EXIT_ON_CLOSE in this case).  All of these methods belong to the JFrame class.  Since we inhereted from JFrame, we can use them in our class as well.

```
import javax.swing.*;

public class FrameDemo extends JFrame {

	public FrameDemo() {
		
		super("Simple Example");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}

	public static void main(String[] args) {

	}

}
```

4.  Inside our class' constructor, however, we will create one instance of a `JPanel` and one instance of a `JLabel`.  The JLabel is initialized to contain the "Hello World" string. All we need to do at this point is use the `add()` method to add the label to the panel, then add the panel to the JFrame.  Finally, we need to explicitly call the `setVisible` method of JFrame and set it to `true` in order for our window to appear on screen.

```
import javax.swing.*;

public class FrameDemo extends JFrame {

	public FrameDemo() {
		
		super("Simple Example");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Hello World");
		panel.add(label);
		add(panel);
		
		setVisible(true);
	}
```

5. At this point, if we create an instance of our FrameDemo class inside the `main()` method and run the program, our "Hello World" text will display in a new JFrame window.  Before we do that, however, I've included a (completely optional) method which will set the Look and Feel of our Swing components and GUI.  These are settings you can use to change the overall appearance, and there are a number of templates you can use if you choose to do so.  Read more about it here: [https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html](https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html)

```
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

```

6.  Whether or not you opted to add the `setLookAndFeel()` method, we'll complete this demo by instantiating our class in `main()`.

```
public static void main(String[] args) {

		setLookAndFeel();
		new FrameDemo();
	}
```

## Example 2 - Metric Conversion Calculator

Now that you've seen a very basic example of Swing, we can take a look at a slightly more interesting example.  Below is a small app that converts metric units to imperial units (km to miles, Celsius to F, etc).  You'll see how to incorporate input/output and event listeners with `JTextField, JButton, and JTabbedPane` components.  You can view the source code for this project [here](https://github.com/robbgatica/comp170-swing/tree/master/src/swing/comp170/conversion).


<p align="center">
<img src="images/calc1.png" alt="frame-demo" width="600" height="300" />
  </p>
  
1.  I've created two separate classes for this project, one that contains the `JPanel` and one that contains the `JFrame`: ConversionPanel and ConversionApp, respectively.  We'll start off by walking through the ConversionPanel class.

2. Much of the core functionality in the ConversionPanel class is pretty standard fare (as you'll see in the [source code](https://github.com/robbgatica/comp170-swing/tree/master/src/swing/comp170/conversion)), but there are some Swing-based features that I'll touch upon.  First, create a new class and name it ConversionPanel (or whatever you'd like).  Our class will `extend` JPanel, which allows us to inherit and build upon the properties of that class.  We'll also `implement` the ActionListener interface, which we'll need in order to respond to button click events.  If Eclipse shows any errors, be sure to check and see if you've imported the necessary packages.  

```
import javax.swing.*;
import java.awt.event.*;

public class ConversionPanel extends JPanel implements ActionListener {

}

```

3.  This program only uses a few Swing components, namely `JTextField`, `JLabel`, and `JButton`.  We'll initialize those and create a constructor for our class.  Also, we'll use `FlowLayout` as our layout type, since we only have one row of components in this app.  All we need to do for that is create a `FlowLayout` object and pass it as an argument to the `setLayout()` method.  The TextFields are initialized with "0" as their starting value and a span/width of 10 columns.  Finally, the Labels and Button are initialized with their specified text.  
Speaking of the Labels, you may have noticed that we only have labels for "Celsius", "F" and "=".  We will need labels for the other units (depending on which units are being converted), but I'll address this a little further down in this tutorial.  For now, we'll leave the labels as they are.  

```
import javax.swing.*;
import java.awt.event.*;

public class ConversionPanel extends JPanel implements ActionListener {

	JTextField input, result;
	JLabel unit1, unit2, equals;
	JButton calcButton;
	
	public ConversionPanel() {
	super();
	
	// FlowLayout takes an 'alignment argument' - in this example it is centered (FlowLayout.CENTER)
	FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
	setLayout(layout);

	// Text Boxes
	input = new JTextField("0", 10);
	result = new JTextField("0", 10);

	// Labels
	equals = new JLabel("=");
	unit1 = new JLabel("Celsius");
	unit2 = new JLabel("F");

	// Button
	calcButton = new JButton("Calculate");
	
	}
}
```

4. Now that we've initialized the components, we want to give them some actual functionality.  I set this up in such a way that the user enters a value into the 'input' TextField, clicks the JButton, and receives the metric-to-imperial conversion value in the 'result' TextField.  Thus, the button click triggers the computation.   Our class itself happens to be an ActionListener (by virtue of the `implements` statement from earlier), so when we can call the `addActionListener()` method on the JButton, we can pass the `this` keyword as the argument.  We'll define the actions in the next step.   Finally, we will add all of the components to our panel.  Now the code looks something like this:

```
public class ConversionPanel extends JPanel implements ActionListener {

	JTextField input, result;
	JLabel unit1, unit2, equals;
	JButton calcButton;
	
	public ConversionPanel() {
	super();
	
	// FlowLayout takes an 'alignment argument' - in this example it is centered (FlowLayout.CENTER)
	FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
	setLayout(layout);

	// Text Boxes
	input = new JTextField("0", 10);
	result = new JTextField("0", 10);

	// Labels
	equals = new JLabel("=");
	unit1 = new JLabel("Celsius");
	unit2 = new JLabel("F");

	// Button
	calcButton = new JButton("Calculate");
	
	// Add Event Listener to Button
	calcButton.addActionListener(this);


	// Add Components
	add(unit1);
	add(input);
	add(equals);
	add(result);
	add(unit2);
	add(calcButton);
	
	}
}
```

5.  Because we implemented the `ActionListener` interface, we are required to include its `actionPerformed()` method somewhere in our class.  In other words, the `ActionListener` interface provides the method outline, but it's up to us to define what the method actually does.  This is the nature of interfaces in Java. That said, we will override the `actionPerformed()` method and place it anywhere outside of our constructor.  

At the heart of this program, we are simply performing basic calculations based on conversion formulas and that is exactly what we're programming this block of code to do.  As such, the bulk of this method shouldn't look too unfamiliar, syntax-wise.  Essentially, this method is triggered whenever the button is clicked (the `ActionEvent`). To get started, we will assign whatever value the user entered into the `input` TextField to a local variable called `val1`.  Since the text inside the TextField is of type `String`, we need to get the actual numeric (type `double`) from that string using the `parseDouble()` method.  Additionally, we're using the `DecimalFormat` class to truncate the decimal places of the result which creates a more user-friendly output (this is not necessary, but a nice touch, I believe).  

(More to come...)

```
@Override
	public void actionPerformed(ActionEvent e) {
		try {
			double val1 = Double.parseDouble(input.getText());
			DecimalFormat df = new DecimalFormat("###.00");
			if (conversionType == "temp") {
				total = val1 * CELSIUS_CONST + 32;
			} else if (conversionType == "dist") {
				total = val1 / KM_CONST;
			} else if (conversionType == "mass") {
				total = val1 * KG_CONST;
			} else if (conversionType == "vol") {
				total = val1 * VOL_CONST;
			}
			result.setText("" + df.format(total));
			 
		} catch (NumberFormatException numEx) {
			input.setText("0");
			result.setText("0");
		}

	}

```

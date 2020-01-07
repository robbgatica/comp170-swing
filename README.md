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

2.  This class will inherit from the JFrame class using the `extends` keyword.  This is not strictly necessary, as you could instantiate a JFrame object inside the your class instead, and it would function exactly the same.  But for the sake of simplicity, we'll just extend the functionality of JFrame directly to our class.  So far, your class should look something like this:

`
import javax.swing.*;
public class FrameDemo extends JFrame {
public static void main(String[] args) {
}
}
`


package swing.comp170.email;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class EmailPanel extends JPanel {

	GridBagLayout layout = new GridBagLayout();

	public EmailPanel() {
		// Initial setup of panel
		super();
		setLayout(layout);

		// Labels
		JLabel toLabel = new JLabel("To: ");
		JLabel ccLabel = new JLabel("CC: ");
		JLabel subjectLabel = new JLabel("Subject: ");
		JLabel messageLabel = new JLabel("Message: ");

		// Text Boxes
		JTextField to = new JTextField();
		JTextField cc = new JTextField();
		JTextField subject = new JTextField();
		JTextArea message = new JTextArea(5, 10);
		message.setLineWrap(true);
		message.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(message, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Buttons
		JButton send = new JButton("Send");
		JButton cancel = new JButton("Cancel");

		// Add components to panel and set their constraints
		addComponent(toLabel, 0, 0, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(to, 1, 0, 9, 1, 90, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
		addComponent(ccLabel, 0, 1, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(cc, 1, 1, 9, 1, 90, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
		addComponent(subjectLabel, 0, 2, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(subject, 1, 2, 9, 1, 90, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
		addComponent(messageLabel, 0, 3, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(scrollPane, 1, 3, 9, 1, 50, 30, GridBagConstraints.BOTH, GridBagConstraints.WEST);
		addComponent(send, 1, 4, 1, 1, 1, 10, GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(cancel, 3, 4, 1, 1, 1, 10, GridBagConstraints.NONE, GridBagConstraints.WEST);

	}

	private void addComponent(Component component, int gridx, int gridy, int gridwidth, int gridheight, int weightx,
			int weighty, int fill, int anchor) {

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		constraints.fill = fill;
		constraints.anchor = anchor;

		layout.setConstraints(component, constraints);
		add(component);

	}
}

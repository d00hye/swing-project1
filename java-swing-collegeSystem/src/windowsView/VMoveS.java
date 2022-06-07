package windowsView;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import constants.Constants.EFont;

public class VMoveS extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton moveDeleteButton;
	
	public VMoveS(ActionListener actionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.moveDeleteButton = new JButton("  ªË¡¶  ");
		
		Vector<JButton> buttons = new Vector<JButton>();
		buttons.add(this.moveDeleteButton);
		
		for(JButton b: buttons) {
//			b.setBorderPainted(false);
			b.setForeground(Color.DARK_GRAY);
//			b.setContentAreaFilled(false);
			b.setFocusPainted(false);
			b.setBackground(Color.white);
			b.addActionListener(actionHandler);
			b.setFont(EFont.eGodick.getFont());
			this.add(b);
		}
		
	}

	public void initialize() {
		
	}

	public Object getDeleteButton() {
		return this.moveDeleteButton;
	}
}

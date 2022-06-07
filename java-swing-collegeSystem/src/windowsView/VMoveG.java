package windowsView;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import constants.Constants.EFont;

public class VMoveG extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton moveSincheongButton;
	private JButton moveMiriButton;
	
	public VMoveG(ActionListener actionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.moveMiriButton = new JButton("미리담기 → ");
		this.moveSincheongButton = new JButton("수강신청 → ");
		
		Vector<JButton> buttons = new Vector<JButton>();
		buttons.add(this.moveMiriButton);
		buttons.add(this.moveSincheongButton);
		
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

	public Object getMoveMiriButton() {
		return this.moveMiriButton;
	}

	public Object getMoveSincheongButton() {
		return this.moveSincheongButton;
	}
	
}

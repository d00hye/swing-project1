package windowsView;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import constants.Constants.EFont;

public class VMoveM extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton moveSincheongButton;
	private JButton moveDeleteButton;

	public VMoveM(ActionListener actionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.moveDeleteButton = new JButton("삭제");
		this.moveSincheongButton = new JButton("수강신청");

		Vector<JButton> buttons = new Vector<JButton>();
		buttons.add(this.moveDeleteButton);
		buttons.add(this.moveSincheongButton);

		for (JButton b : buttons) {
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

	public Object getMoveSincheongButton() {
		return this.moveSincheongButton;
	}

	public Object getDeleteButton() {
		return this.moveDeleteButton;
	}
}

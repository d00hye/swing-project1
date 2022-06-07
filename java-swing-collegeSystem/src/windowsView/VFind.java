package windowsView;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants.EFind;
import constants.Constants.EFont;
import constants.Constants.ESetTitle;
import control.CLogin;
import valueObject.OLogin;

public class VFind extends JDialog {
	private static final long serialVersionUID = 1L;

	private JLabel idLabel, passwordLabel, nameLabel;
	private JTextField idField, nameField;
	private JButton idButton, passwordButton, findButton;

	private OLogin oLogin;
	private CLogin cLogin;
	boolean idSelected = false;

	VFind() {
		this.setTitle(ESetTitle.eFind.getText());
		this.setSize(EFind.width.getInt(), EFind.height.getInt());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new GridLayout(5, 1));

		JPanel buttonPanel = new JPanel();
		this.idButton = new JButton(EFind.idButtonLabel.getText());
		this.passwordButton = new JButton(EFind.passwordButtonLabel.getText());

		Vector<JButton> findButton = new Vector<JButton>();
		ActionHandler actionHandler = new ActionHandler();
		findButton.add(this.idButton);
		findButton.add(this.passwordButton);

		for (JButton button : findButton) {
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.setFocusPainted(false);
			button.setForeground(Color.DARK_GRAY);
			button.setFont(EFont.eGodick.getFont());
			button.addActionListener(actionHandler);
			button.setActionCommand(button.getText());
			buttonPanel.add(button);
		}
		this.add(buttonPanel);

		JPanel namePanel = new JPanel();
		this.nameLabel = new JLabel(EFind.nameLabel.getText());
		this.nameLabel.setFont(EFont.eGodick.getFont());
		namePanel.add(this.nameLabel);
		this.nameField = new JTextField(EFind.sizeText.getInt());
		namePanel.add(this.nameField);
		this.add(namePanel);

		JPanel idPanel = new JPanel();
		this.idLabel = new JLabel(EFind.idLabel.getText());
		this.idLabel.setFont(EFont.eGodick.getFont());
		idPanel.add(this.idLabel);
		this.idField = new JTextField(EFind.sizeText.getInt());
		idPanel.add(this.idField);
		this.add(idPanel);

		JPanel passwordPanel = new JPanel();
		this.passwordLabel = new JLabel(EFind.passwordLabel.getText());
		this.passwordLabel.setFont(EFont.eGodick.getFont());
		passwordPanel.add(this.passwordLabel);
		this.add(passwordPanel);

		JPanel informPanel = new JPanel();
		this.findButton = new JButton(EFind.findButtonLabel.getText());
		informPanel.add(this.findButton);
		this.getRootPane().setDefaultButton(this.findButton);
		this.add(informPanel);
		this.findButton.setActionCommand(this.findButton.getText());
		this.findButton.addActionListener(actionHandler);

		this.oLogin = new OLogin();
		this.cLogin = new CLogin();
	}
	
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(idButton)) {
				JOptionPane.showConfirmDialog(null, "이름을 입력해주세요", "Find Id", JOptionPane.OK_CANCEL_OPTION);
				idSelected = true;
			} else if (e.getSource().equals(passwordButton)) {
				JOptionPane.showConfirmDialog(null, "아이디를 입력해주세요", "Find Password", JOptionPane.OK_CANCEL_OPTION);
			}
			if (e.getSource().equals(findButton)) {
				if (idSelected) {
					oLogin.setName(nameField.getText());
					String id = cLogin.getId(oLogin);
					if(id!=null) {
					idField.setText(id);
					idSelected = false;
					return;
					}
					idField.setText("해당 이름 정보가 없습니다.");
				} else {
					oLogin.setId(idField.getText());
					String password = cLogin.getPassword(oLogin);
					if(password!=null) {
					passwordLabel.setText(idField.getText() + "님의 비밀번호는 " + password + "입니다.");
					return;
					}
					passwordLabel.setText("해당 아이디 정보가 없습니다.");
				}
			}
		}
	}
}
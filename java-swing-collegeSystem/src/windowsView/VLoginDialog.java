package windowsView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import constants.Constants.EFont;
import constants.Constants.ELoginDialog;
import constants.Constants.ESetTitle;
import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;
import windowsView.VMain.ActionHandler;

public class VLoginDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JLabel idLabel, passwordLabel, imgLabel;
	private JButton okButton, cancelButton, hwewonButton, findButton;
	private JTextField idField;
	private JPasswordField passwordField;

	private VHwewonDeungrok vHwewonDeungrok;
	private VFind vFind;

	private OLogin oLogin;
	private CLogin cLogin;
	
	public VLoginDialog(ActionHandler actionHandler) {
		// attributes
		this.setTitle(ESetTitle.eLogin.getText());
		this.setSize(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());

		ImageIcon img = new ImageIcon(ELoginDialog.imgLabelPath.getText());
		this.imgLabel = new JLabel(img);
		this.add(imgLabel);

		JPanel idPanel = new JPanel();
		this.idLabel = new JLabel(ELoginDialog.idLabel.getText());
		this.idLabel.setFont(EFont.eGodick.getFont());
		idPanel.add(this.idLabel);
		this.idField = new JTextField(ELoginDialog.sizeidtext.getInt());
		idPanel.add(this.idField);
		this.add(idPanel);

		JPanel passwordPanel = new JPanel();
		this.passwordLabel = new JLabel(ELoginDialog.passwordLabel.getText());
		this.passwordLabel.setFont(EFont.eGodick.getFont());
		passwordPanel.add(this.passwordLabel);
		this.passwordField = new JPasswordField(ELoginDialog.sizePasswordText.getInt());
		passwordField.setEchoChar(ELoginDialog.passwordsecurity.getChar());
		passwordPanel.add(this.passwordField);
		this.add(passwordPanel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());

		JPanel okCancelPanel = new JPanel();
		this.okButton = new JButton(ELoginDialog.okButtonLabel.getText());
		this.okButton.addActionListener(actionHandler);
		this.okButton.setActionCommand(this.okButton.getText());
		this.okButton.setFont(EFont.eDialog.getFont());
		this.getRootPane().setDefaultButton(this.okButton);
		this.cancelButton = new JButton(ELoginDialog.cancelButtonLabel.getText());
		this.cancelButton.addActionListener(actionHandler);
		this.cancelButton.setActionCommand(this.cancelButton.getText());
		this.cancelButton.setFont(EFont.eDialog.getFont());
		okCancelPanel.add(this.okButton);
		okCancelPanel.add(this.cancelButton);

		JPanel AlphaPanel = new JPanel();
		this.hwewonButton = new JButton(ELoginDialog.hwewonButtonLabel.getText());
		this.findButton = new JButton(ELoginDialog.findButtonLabel.getText());

		Vector<JButton> AlphaButton = new Vector<JButton>();
		AlphaButton.add(findButton);
		AlphaButton.add(hwewonButton);

		for (JButton button : AlphaButton) {
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.setFocusPainted(false);
			button.setForeground(Color.blue);
			button.setFont(EFont.eGodick.getFont());
			button.addActionListener(actionHandler);
			button.setActionCommand(button.getText());
			AlphaPanel.add(button);
		}

		buttonPanel.add(okCancelPanel, BorderLayout.NORTH);
		buttonPanel.add(AlphaPanel, BorderLayout.CENTER);
		this.add(buttonPanel);

		this.oLogin = new OLogin();
		this.cLogin = new CLogin();
	}
	

	public void initialize() {
	}

	private void vHwewon() {
		this.vHwewonDeungrok = new VHwewonDeungrok();
		this.vHwewonDeungrok.setVisible(true);
	}

	private void vFind() {
		this.vFind = new VFind();
		this.vFind.setVisible(true);
	}
	
	public OHwewon validateUser(String actionCommand) {
		OHwewon oHwewon = null;
		if (actionCommand.contentEquals(this.hwewonButton.getText())) {
			this.vHwewon();
			return null;
		}
		if (actionCommand.contentEquals(this.findButton.getText())) {
			this.vFind();
			return null;
		}
		if (actionCommand.contentEquals(this.okButton.getText())) {
			oLogin.setId(this.idField.getText());
			oLogin.setPassword(new String(this.passwordField.getPassword()));
			oHwewon = this.cLogin.validate(oLogin);
			if (oHwewon == null) {
				JOptionPane.showMessageDialog(null, ELoginDialog.loginFailed.getText(),
						ELoginDialog.errormessage.getText(), JOptionPane.ERROR_MESSAGE);
			}
		}
		if (actionCommand.contentEquals(this.cancelButton.getText())) {
			// id중복시 시스템 종료 안되는 문제
			System.exit(0);
			return null;
		}
		return oHwewon;

	}

}

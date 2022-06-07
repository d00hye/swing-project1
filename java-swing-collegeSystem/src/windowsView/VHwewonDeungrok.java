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

import constants.Constants.EFont;
import constants.Constants.EHwewon;
import constants.Constants.ESetTitle;
import control.CHwewonDeungrok;
import valueObject.OHwewon;

public class VHwewonDeungrok extends JDialog {
	private static final long serialVersionUID = 1L;

	private JLabel idLabel, passwordLabel, nameLabel, addressLabel, hakgwaLabel;
	private JTextField idField, passwordField, nameField, addressField, hakgwaField;
	private JButton okButton;

	private CHwewonDeungrok cHwewonDeungrok;

	public VHwewonDeungrok() {
		this.setTitle(ESetTitle.eHwewon.getText());
		this.setSize(EHwewon.width.getInt(), EHwewon.height.getInt());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new GridLayout(6, 1));

		JPanel idPanel = new JPanel();
		this.idLabel = new JLabel(EHwewon.idLabel.getText());
		idPanel.add(this.idLabel);
		this.idField = new JTextField(EHwewon.sizeText.getInt());
		idPanel.add(this.idField);
		this.add(idPanel);

		JPanel passwordPanel = new JPanel();
		this.passwordLabel = new JLabel(EHwewon.passwordLabel.getText());
		passwordPanel.add(this.passwordLabel);
		this.passwordField = new JTextField(EHwewon.sizeText.getInt());
		passwordPanel.add(this.passwordField);
		this.add(passwordPanel);

		JPanel namePanel = new JPanel();
		this.nameLabel = new JLabel(EHwewon.nameLabel.getText());
		namePanel.add(this.nameLabel);
		this.nameField = new JTextField(EHwewon.sizeText.getInt());
		namePanel.add(this.nameField);
		this.add(namePanel);

		JPanel addressPanel = new JPanel();
		this.addressLabel = new JLabel(EHwewon.addressLabel.getText());
		addressPanel.add(this.addressLabel);
		this.addressField = new JTextField(EHwewon.sizeaddressText.getInt());
		addressPanel.add(this.addressField);
		this.add(addressPanel);

		JPanel hakgwaPanel = new JPanel();
		this.hakgwaLabel = new JLabel(EHwewon.hakgwaLabel.getText());
		hakgwaPanel.add(this.hakgwaLabel);
		this.hakgwaField = new JTextField(EHwewon.sizehakgwaText.getInt());
		hakgwaPanel.add(this.hakgwaField);
		this.add(hakgwaPanel);

		JPanel buttonPanel = new JPanel();
		this.okButton = new JButton(EHwewon.okButtonLabel.getText());
		buttonPanel.add(this.okButton);
		this.getRootPane().setDefaultButton(this.okButton);
		this.add(buttonPanel);
		
		//
		Vector<JLabel> labels = new Vector<JLabel>();
		labels.add(idLabel);labels.add(nameLabel);labels.add(passwordLabel);labels.add(addressLabel);labels.add(hakgwaLabel);
		for (JLabel label : labels) {
			label.setFont(EFont.eGodick.getFont());
			label.setBackground(Color.black);
		}
		

		ActionHandler actionHandler = new ActionHandler();
		this.okButton.setActionCommand(this.okButton.getText());
		this.okButton.addActionListener(actionHandler);

		this.cHwewonDeungrok = new CHwewonDeungrok();

	}

	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			OHwewon oHwewon = new OHwewon();
			// null 값 방지
			if (idField.getText().equals("") || passwordField.getText().equals("") || nameField.getText().equals("")
					|| addressField.getText().equals("") || hakgwaField.getText().equals("")) {
				JOptionPane.showConfirmDialog(null, "모두 입력해주시길 바랍니다", "Null", JOptionPane.OK_CANCEL_OPTION);
				return;
			}
			else {
			oHwewon.setId(idField.getText());
			oHwewon.setPassword(passwordField.getText());
			oHwewon.setName(nameField.getText());
			oHwewon.setAddress(addressField.getText());
			oHwewon.setHakgwa(hakgwaField.getText());
			cHwewonDeungrok.saveHwewon(oHwewon);
			// 등록 후 바로 로그인
			dispose();
		}
			}
	}

}

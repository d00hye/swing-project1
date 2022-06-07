package windowsView;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import constants.Constants.EFont;
import dataAccessObject.DMiridamgi;
import dataAccessObject.DSincheong;
import valueObject.OHwewon;

public class VMiriSincheongPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private VMiridamgi vMiridamgi;
	private VSincheong vSincheong;
	private String fileNameM;
	private String fileNameS;
	private String user;
	private JLabel creditLabel;
	private int credit;

	DMiridamgi dm;
	DSincheong ds;
	
	public VMiriSincheongPanel() {

		this.setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));
		JLabel miri = new JLabel("<< 책가방 >>");
		miri.setForeground(Color.blue);
		miri.setFont(EFont.eGodickbold.getFont());

		this.add(miri);
		JScrollPane scrollpane;
		this.vMiridamgi = new VMiridamgi();
		scrollpane = new JScrollPane(this.vMiridamgi);
		this.add(scrollpane);

		this.vSincheong = new VSincheong();
		JLabel s = new JLabel("<< 수강신청 >>");
		s.setFont(EFont.eGodickbold.getFont());
		s.setForeground(Color.blue);
		creditLabel = new JLabel();
		creditLabel.setFont(EFont.eGodickbold.getFont());
		creditLabel.setForeground(Color.blue);
		
		this.add(s);
		scrollpane = new JScrollPane(this.vSincheong);
		this.add(scrollpane);
		this.add(creditLabel);
		
	}

	public void initialize(OHwewon oHwewon) {
		this.vMiridamgi.initialize(oHwewon);
		this.vSincheong.initialize(oHwewon);
		fileNameM = oHwewon.getId() + 'M';
		fileNameS = oHwewon.getId() + 'S';
		this.user= oHwewon.getId();
		this.credit(oHwewon.getId());

	}
	
	private void credit(String user) {
		DSincheong ds = new DSincheong();
		this.credit =ds.credit(user);
		creditLabel.setText("신청학점: "+this.credit);
		creditLabel.setFont(EFont.eGodick.getFont());
	}

	public void update() {
		this.vMiridamgi.showList(fileNameM);
		this.vSincheong.showList(fileNameS);
		this.credit(user);
	}

	public void deleteM() {
		int row = this.vMiridamgi.getSelectedRow();
		dm = new DMiridamgi();
		String num = dm.find(user, row);
		dm.delete(user, num);
	}

	public void sincheong() {
		int row = this.vMiridamgi.getSelectedRow();
		ds = new DSincheong();
		dm = new DMiridamgi();
		String key = dm.find(user, row);
		ds.add(user, key);

	}

	public void deletS() {
		int row = this.vSincheong.getSelectedRow();
		ds = new DSincheong();
		String key = ds.find(user, row);
		ds.delete(user, key);
	}


}

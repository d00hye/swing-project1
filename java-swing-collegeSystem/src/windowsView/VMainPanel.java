package windowsView;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.Constants.EFont;
import valueObject.OHwewon;

public class VMainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	// 자식을 담기 위해 적합한 JPanel
	// attributes, components, associations
	
	// 클래스명 약자 쓰지 말것
	private VSugangSincheongPanel vSugangsincheong;
	private JPanel namePanel;
	private JLabel infoLabel;
	
	public VMainPanel() {
		super();
		this.setLayout(new BorderLayout());
		
		this.namePanel = new JPanel();
		this.infoLabel = new JLabel();

		this.namePanel.add(infoLabel);
		this.add(this.namePanel, BorderLayout.NORTH);

		this.vSugangsincheong = new VSugangSincheongPanel();
		this.add(this.vSugangsincheong, BorderLayout.CENTER);
	}

	public void initialize(OHwewon oHwewon) {
		this.setLabelText(oHwewon);
		this.vSugangsincheong.initialize(oHwewon);
	}

	private void setLabelText(OHwewon oHwewon) {
		this.infoLabel.setText(oHwewon.getName() + "님 "+oHwewon.getId() + "학번 "+oHwewon.getHakgwa() + "학부(과) " );
		infoLabel.setFont(EFont.eGodick.getFont());
	}



}

package windowsView;

import javax.swing.JFrame;

import constants.Constants.ESetTitle;
import valueObject.OHwewon;

public class VMainFrame extends JFrame {
	// �տ��� ���� �ڿ��� ���� ����
	private static final long serialVersionUID = 1L;
	
	// ���� ���� ������ ����� ���, ��⼺ ����
	private VMainPanel vMainPanel;

	public VMainFrame() {
		// JFrame�� ���� ����ϰ� �߰��ϰڴٴ� ���� ����, ��ü(override)�� �ƴ�
		super();
		
		this.setTitle(ESetTitle.eSugang.getText());
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.vMainPanel = new VMainPanel();
		this.add(this.vMainPanel);
	}

	public void initialize(OHwewon oHwewon) {
		this.vMainPanel.initialize(oHwewon);
		
	}

}

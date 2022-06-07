package windowsView;

import javax.swing.JFrame;

import constants.Constants.ESetTitle;
import valueObject.OHwewon;

public class VMainFrame extends JFrame {
	// 앞에껀 구조 뒤에껀 버그 관련
	private static final long serialVersionUID = 1L;
	
	// 집합 포함 계층을 만드는 방법, 모듈성 유지
	private VMainPanel vMainPanel;

	public VMainFrame() {
		// JFrame의 것을 사용하고 추가하겠다는 뜻을 밝힘, 대체(override)가 아닌
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

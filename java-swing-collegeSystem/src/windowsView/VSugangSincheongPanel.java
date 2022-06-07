package windowsView;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import valueObject.OHwewon;

public class VSugangSincheongPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private VGangjwaSelectionPanel vGangjwaSelectionPanel;
	private VMiriSincheongPanel vMiriSincheongPanel;
	private VMoveG vMoveG;
	private VMoveM vMoveM;
	private VMoveS vMoveS;

	private ActionHandler ActionHandler;

	public VSugangSincheongPanel() {
		super();

		this.setLayout((new BoxLayout(this, BoxLayout.X_AXIS)));

		this.vGangjwaSelectionPanel = new VGangjwaSelectionPanel();
		this.add(this.vGangjwaSelectionPanel);

		ActionHandler = new ActionHandler();
		this.vMoveG = new VMoveG(this.ActionHandler);
		this.add(this.vMoveG);

		this.vMiriSincheongPanel = new VMiriSincheongPanel();
		this.add(this.vMiriSincheongPanel);
				
		JPanel buttonPanel = new JPanel(new BorderLayout());
		this.vMoveM = new VMoveM(this.ActionHandler);
		this.vMoveS = new VMoveS(this.ActionHandler);

		buttonPanel.add(this.vMoveM, BorderLayout.NORTH);
		buttonPanel.add(this.vMoveS, BorderLayout.SOUTH);
		
		this.add(buttonPanel);
	}

	public void initialize(OHwewon oHwewon) {
		this.vGangjwaSelectionPanel.initialize(oHwewon);
		this.vMiriSincheongPanel.initialize(oHwewon);
	}


	private void moveLectures(Object source) {
		if (source.equals(this.vMoveG.getMoveMiriButton())) {
			this.vGangjwaSelectionPanel.miridamgi();
			this.vMiriSincheongPanel.update();
		} else if (source.equals(this.vMoveG.getMoveSincheongButton())) {
			this.vGangjwaSelectionPanel.sincheong();
			this.vMiriSincheongPanel.update();
			
		}else if (source.equals(this.vMoveM.getDeleteButton())) {
			this.vMiriSincheongPanel.deleteM();
			this.vMiriSincheongPanel.update();
		}else if (source.equals(this.vMoveM.getMoveSincheongButton())) {
			this.vMiriSincheongPanel.sincheong();
			this.vMiriSincheongPanel.update();
		}else if (source.equals(this.vMoveS.getDeleteButton())) {
			this.vMiriSincheongPanel.deletS();
			this.vMiriSincheongPanel.update();
		}
	}

	public class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			moveLectures(event.getSource());
		}
	}
}

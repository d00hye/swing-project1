package windowsView;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import valueObject.OHwewon;

public class VMain {

	private VLoginDialog vLoginDialog;
	private VMainFrame vMainFrame;
	private ActionHandler actionHandler;

	public VMain() {
		this.actionHandler = new ActionHandler();
		this.vLoginDialog = new VLoginDialog(actionHandler);
		this.vLoginDialog.setVisible(true);
	}

	private void validateUser(String actionCommand) {
		OHwewon oHwewon = vLoginDialog.validateUser(actionCommand);
		if (oHwewon != null) {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image img = toolkit.getImage("resources/icon.png");
			this.vLoginDialog.dispose();
			this.vMainFrame = new VMainFrame();
			this.vMainFrame.initialize(oHwewon);
			this.vMainFrame.setVisible(true);
			this.vMainFrame.setIconImage(img);
		}
	}

	public class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			validateUser(event.getActionCommand());
		}
	}

	public static void main(String[] args) {
		VMain vmain = new VMain();
		vmain.initialize();
	}

	private void initialize() {
		this.vLoginDialog.initialize();
	}
}

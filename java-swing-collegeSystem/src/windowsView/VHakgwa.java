package windowsView;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import constants.Constants.EDefault;
import windowsView.VGangjwaSelectionPanel.ListSelectionHandler;


public class VHakgwa extends JPanel {
	private static final long serialVersionUID = 1L;

	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vHakgwa;

	private String fileName, campus, college;
	
	public VHakgwa(ListSelectionHandler listSelectionHandler) {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JScrollPane scrollpane;
		scrollpane = new JScrollPane();
		this.vCampus = new VIndex("캠퍼스", listSelectionHandler);
		scrollpane.setViewportView(this.vCampus);
		this.add(scrollpane);

		scrollpane = new JScrollPane();
		this.vCollege = new VIndex("대학", listSelectionHandler);
		scrollpane.setViewportView(this.vCollege);
		this.add(scrollpane);

		scrollpane = new JScrollPane();
		this.vHakgwa = new VIndex("학과", listSelectionHandler);
		scrollpane.setViewportView(this.vHakgwa);
		this.add(scrollpane);
	}
	
	public void initialize() {
		this.fileName = EDefault.eRoot.getText();
		this.fileName = this.vCampus.showList(this.fileName);
		this.fileName = this.vCollege.showList(this.fileName);
		this.fileName = this.vHakgwa.showList(this.fileName);	
	}
	
	public String update(Object source) {
		if (source.equals(this.vCampus.getSelectionModel())) {
			this.fileName=EDefault.eRoot.getText();
			this.fileName = this.vCampus.getSelectedFileName(this.fileName);
			campus = fileName;
			this.fileName = this.vCollege.showList(this.fileName);
			this.fileName = this.vHakgwa.showList(this.fileName);		
		} else if (source.equals(this.vCollege.getSelectionModel())) {
			if(campus==null) {
				campus =EDefault.eCampus.getText();
			}
			this.fileName = this.vCollege.getSelectedFileName(campus);
			college =fileName;
			this.fileName = this.vHakgwa.showList(this.fileName);
		} else if (source.equals(this.vHakgwa.getSelectionModel())) {
			if(college==null) {
				college=EDefault.eCollege.getText();
			}
			this.fileName = this.vHakgwa.getSelectedFileName(college);
		}
		return this.fileName;
	}

}

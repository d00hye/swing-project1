package windowsView;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dataAccessObject.DMiridamgi;
import dataAccessObject.DSincheong;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VGangjwaSelectionPanel extends JPanel implements Cloneable {
	private static final long serialVersionUID = 1L;

	private VHakgwa vHakgwa;
	private VGangjwa vGangjwa;

	private String hakgwaName;
	private Vector<OLecture> newLectures;
	private String user;
	
	DMiridamgi dm;
	DSincheong ds;


	public VGangjwaSelectionPanel() {
		super();
//		this.setSize(300, 100);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		ListSelectionHandler listSelectionHandler = new ListSelectionHandler();
		this.vHakgwa = new VHakgwa(listSelectionHandler);
		this.add(this.vHakgwa);

		// scrollPane이 더 크기 때문에 테이블 포함함
//		ListSelectionHandler listSelectionHandlerg = new ListSelectionHandler();
		JScrollPane pane = new JScrollPane();
		this.vGangjwa = new VGangjwa();
		pane.setViewportView(this.vGangjwa);
		this.add(pane);

	}

	private void updateSelected(Object source) {
		this.hakgwaName = this.vHakgwa.update(source);
		this.vGangjwa.showList(this.hakgwaName);
		create(hakgwaName);
	}

	private void create(String hakgwaName) {
		this.hakgwaName = hakgwaName;
	}

	public class ListSelectionHandler implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent event) {
			updateSelected(event.getSource());
		}
	}

	public void initialize(OHwewon oHwewon) {
		this.vHakgwa.initialize();
		this.vGangjwa.initialize();
		user = oHwewon.getId();
	}
	
	public void miridamgi() {
		newLectures = this.vGangjwa.getSelectedGangjwas(hakgwaName);
		dm = new DMiridamgi();
		for (OLecture l : newLectures) {
			dm.add(user, l);
		}
	}
	
	public void sincheong() {
		newLectures = this.vGangjwa.getSelectedGangjwas(hakgwaName);
		ds = new DSincheong();
		for (OLecture l : newLectures) {
			ds.add(user, l);
		}
	}

}

package windowsView;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EDefault;
import constants.Constants.EGangjwa;
import control.CLecture;
import valueObject.OLecture;

public class VGangjwa extends JTable {
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private CLecture cLecture;

	// 구조만 거기에 고정적
	// initialize는 구조의 값을 넣는 것임,,
	public VGangjwa() {
		super();
		Vector<String> header = new Vector<String>();
		for (EGangjwa eGangjwa : EGangjwa.values()) {
			header.addElement(eGangjwa.getText());
		}

		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(this.tableModel);

		this.cLecture = new CLecture();
	}

	public void initialize() {
		this.showList(EDefault.eGangjwa.getText());
	}

	public void showList(String hakgwaName) {
		this.tableModel.setRowCount(0);
		Vector<OLecture> lectures = this.cLecture.getAll(hakgwaName);
		for (OLecture lecture : lectures) {
			Vector<String> row = new Vector<String>();
			row.add(lecture.getId());
			row.add(lecture.getName());
			row.add(lecture.getProfessor());
			row.add(lecture.getCredit());
			row.add(lecture.getTime());
			this.tableModel.addRow(row);
		}
		this.updateUI();

		// 첫 행이 선택 되는 메소드
		if (lectures.size() > 0) {
			this.getSelectionModel().addSelectionInterval(0, 0);
		}

	}

	public Vector<OLecture> getSelectedGangjwas(String hakgwaName) {
		Vector<OLecture> vSelectedGangjwas = new Vector<OLecture>();
		Vector<OLecture> lectures;
		// 예외처리
		if (hakgwaName == null) {
			lectures=this.cLecture.getAll(EDefault.eGangjwa.getText());
			vSelectedGangjwas.add(lectures.get(0));
			return vSelectedGangjwas;
		}
		int[] indicies = this.getSelectedRows();
		lectures= this.cLecture.getAll(hakgwaName);
		for (int index : indicies) {
			vSelectedGangjwas.add(lectures.get(index));
		}
		return vSelectedGangjwas;
	}

}

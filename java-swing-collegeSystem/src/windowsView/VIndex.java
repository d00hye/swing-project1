package windowsView;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CIndex;
import valueObject.OIndex;
import windowsView.VGangjwaSelectionPanel.ListSelectionHandler;

public class VIndex extends JTable {
	private static final long serialVersionUID = 1L;

	private DefaultTableModel tableModel;
	private ListSelectionHandler listSelectionHandler;
	private CIndex cIndex;

	public VIndex(String title, ListSelectionHandler listSelectionHandler) {
		super();
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.listSelectionHandler = listSelectionHandler;
		this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);

		Vector<String> header = new Vector<String>();
		header.addElement(title);

		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(this.tableModel);

		this.cIndex = new CIndex();
	}

	public String showList(String fileName) {
		this.getSelectionModel().removeListSelectionListener(this.listSelectionHandler);

		Vector<OIndex> indices = cIndex.getAll(fileName);
		// default
		this.tableModel.setRowCount(0);

		for (OIndex index : indices) {
			Vector<String> row = new Vector<String>();
			row.add(index.getName());
			this.tableModel.addRow(row);
		}

		String selected = null;
		if (indices.size() > 0) {
			this.getSelectionModel().addSelectionInterval(0, 0);
			selected = indices.get(0).getFileName();
		}
		this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
		return selected;
	}

	public String getSelectedFileName(String fileName) {
		int selectedIndex = this.getSelectedRow();
		Vector<OIndex> indices = cIndex.getAll(fileName);
		return indices.get(selectedIndex).getFileName();
	}

}

package windowsView;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EGangjwa;
import dataAccessObject.DSincheong;
import valueObject.OHwewon;

public class VSincheong extends JTable {
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;

	public VSincheong() {
		super();
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setBackground(new Color(204,204,255));

		Vector<String> header = new Vector<String>();
		for(EGangjwa eGangjwa : EGangjwa.values()) {
			header.addElement(eGangjwa.getText());
		}

		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(this.tableModel);
	}
	
	public void initialize(OHwewon oHwewon) {
		this.showList(oHwewon.getId()+"S");		
	}

	public void showList(String fileName) {
		this.tableModel.setRowCount(0);
		DSincheong s = new DSincheong();
		Vector<String> lines = s.sincheong(fileName);
        for (String line: lines) {
           Vector<String> row = new Vector<String>();
           String[] data=line.split(" ");
           row.add(data[0]);
           row.add(data[1]);
           row.add(data[2]);
           row.add(data[3]);
           row.add(data[4]);
           this.tableModel.addRow(row);
        }
        this.updateUI();
        
        // 첫 행이 선택 되는 메소드
        if (lines.size() > 0) {
           this.getSelectionModel().addSelectionInterval(0, 0);
        }

	}
}

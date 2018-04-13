package presentacion;

import javax.swing.table.DefaultTableModel;

public class ModeloTablas extends DefaultTableModel {

	/**
	 * Versión de serialización
	 */
	private static final long serialVersionUID = 967294407157761703L;
	
	@Override
	public void addColumn(Object columnName) {
		String nombre = (String) columnName;
		super.addColumn(nombre);
	}
	
	@Override
	public void addRow(Object[] rowData) {
		String[] datos = (String[]) rowData;
		super.addRow(datos);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		if (column == 0) {
			return false;
		}
		return true;
	}
	
	

}

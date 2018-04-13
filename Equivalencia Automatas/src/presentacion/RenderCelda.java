package presentacion;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderCelda extends DefaultTableCellRenderer {

	/**
	 * Versión de serialización.
	 */
	private static final long serialVersionUID = 1181520871595012135L;
	
	// Servicios
	// ============================================================================================

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		String cadena = (String) value;
		
		if (column == -9) {
			this.setOpaque(true);
			this.setBackground(Color.RED);
		}
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		return this;
	}
}

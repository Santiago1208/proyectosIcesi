package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelTabla extends JPanel {

	/**
	 * Versión de serialización
	 */
	private static final long serialVersionUID = -3497528837687552503L;
	
	// Atributos
	// ============================================================================================

	/**
	 * Representa la barra desplazadora de la tabla.
	 */
	private JScrollPane barraDesplazadora;
	
	/**
	 * Representación en forma de tabla del autómata.
	 */
	private JTable tabla;
	
	// Constructor
	// ============================================================================================
	
	public PanelTabla() {
		setLayout(new BorderLayout());
		
		// Inicialización de componentes
		tabla = new JTable(250, 50);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		barraDesplazadora = new JScrollPane(tabla);
		barraDesplazadora.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		barraDesplazadora.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraDesplazadora.setPreferredSize(new Dimension(500, 500));
		add(barraDesplazadora, BorderLayout.CENTER);
	}
	
}

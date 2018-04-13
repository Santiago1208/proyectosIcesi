package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelTabla extends JPanel {

	/**
	 * Versi�n de serializaci�n
	 */
	private static final long serialVersionUID = -3497528837687552503L;
	
	// Atributos
	// ============================================================================================

	/**
	 * Representa la barra desplazadora de la tabla.
	 */
	private JScrollPane barraDesplazadora;
	
	/**
	 * Representaci�n en forma de tabla del aut�mata.
	 */
	private JTable tabla;
	
	// Constructor
	// ============================================================================================
	
	public PanelTabla() {
		setLayout(new BorderLayout());
		
		// Inicializaci�n de componentes
		tabla = new JTable(250, 50);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		barraDesplazadora = new JScrollPane(tabla);
		barraDesplazadora.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		barraDesplazadora.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraDesplazadora.setPreferredSize(new Dimension(500, 500));
		add(barraDesplazadora, BorderLayout.CENTER);
	}
	
}

package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JToolBar;

/**
 * @author Santiago
 *
 */
public class BarraOpciones extends JToolBar implements ActionListener, ItemListener {

	/**
	 * Versión de serialización.
	 */
	private static final long serialVersionUID = -9179817251372121356L;

	// Constantes
	// ============================================================================================
	
	/**
	 * Representa la perspectiva de máquinas de Mealy.
	 */
	public final static String MEALY = "Mealy";
	
	/**
	 * Representa la perspectiva de máquinas de Moore
	 */
	public final static String MOORE = "Moore";
	
	/**
	 * Representa la acción de calcular equivalencia entre autómatas.
	 */
	public final static String CALCULAR_EQUIVALENCIA = "Calcular Equivalencia";
	
	// Atributos
	// ============================================================================================
	
	/**
	 * Representa la etiqueta que indica la perspectiva.
	 */
	private JLabel lblPerspectiva;
	
	/**
	 * Representa el grupo de opciones que contiene todas las perspectivas posibles.
	 */
	private JComboBox<String> cbxPerspectiva;
	
	/**
	 * Representa el botón que permite al programa establecer la equivalencia entre los autómatas.
	 */
	private JButton btnCalcularEquivalencia;
	
	/**
	 * Representa la relación con la ventana principal del programa.
	 */
	private InterfazAutomata principal;
	
	// Constructor
	// ============================================================================================
	
	public BarraOpciones(InterfazAutomata ventana) {
		principal = ventana;
		setFloatable(false);
		
		// Inicialización de componentes
		lblPerspectiva = new JLabel("Perspectiva: ");
		add(lblPerspectiva);
		
		cbxPerspectiva = new JComboBox<>(new String[] {MEALY, MOORE});
		cbxPerspectiva.setSelectedIndex(0);
		cbxPerspectiva.addItemListener(this);
		add(cbxPerspectiva);
		
		addSeparator();
		
		btnCalcularEquivalencia = new JButton(CALCULAR_EQUIVALENCIA);
		btnCalcularEquivalencia.addActionListener(this);
		btnCalcularEquivalencia.setActionCommand(CALCULAR_EQUIVALENCIA);
		add(btnCalcularEquivalencia);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		String itemSeleccionado = (String) e.getItem();
		if (itemSeleccionado.equals(MEALY)) {
			
		}else if (itemSeleccionado.equals(MOORE)) {
			
		}
		
	}
	
	

}

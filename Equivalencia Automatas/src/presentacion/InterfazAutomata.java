package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class InterfazAutomata extends JFrame {

	/**
	 * Versión de serialización
	 */
	private static final long serialVersionUID = 1L;
	
	// Atributos
	// ============================================================================================
	
//	private ModeloTablas modeloTabla;
	
	/**
	 * Representa el componente que permite dividir los dos paneles para 
	 * visualizar ambas tablas en un mismo espacio.
	 */
	private JSplitPane division;
	
	/**
	 * Representa la barra que presenta las opciones como cambio de perspectiva (Mealy a Moore)
	 * y cálculo de la equivalencia.
	 */
	private BarraOpciones barraOpciones;
//	
//	private RenderCelda renderer;
//	
//	private JTable tabla;
//	
//	private JScrollPane scroll;
	
	/**
	 * Representa el panel que contiene al primer autómata.
	 */
	private PanelTabla panelTabla1;
	
	/**
	 * Representa el panel que contiene al segundo autómata.
	 */
	private PanelTabla panelTabla2;
	
	// Constructor
	// ============================================================================================
	
	public InterfazAutomata() {
		setTitle("Equivalencia de Autómatas");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Inicialización de componentes
		panelTabla1 = new PanelTabla();
		panelTabla2 = new PanelTabla();
		
		division = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelTabla1, panelTabla2);
		barraOpciones = new BarraOpciones(this);
//		modeloTabla = new ModeloTablas();
//		tabla = new JTable(modeloTabla);
//		renderer = new RenderCelda();
//		tabla.setDefaultRenderer(String.class, renderer);
//		scroll = new JScrollPane(tabla);
//		scroll.setPreferredSize(new Dimension(800, 400));
//		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//		
//		add(scroll, BorderLayout.CENTER);
		add(division, BorderLayout.CENTER);
		add(barraOpciones, BorderLayout.NORTH);
		pack();
//		modeloTabla.addColumn("Nombre");
//		modeloTabla.addColumn("Apellido");
//		modeloTabla.addColumn("Nombre");
//		modeloTabla.addColumn("Nombre");
//		modeloTabla.addColumn("Nombre");
//		modeloTabla.addColumn("Nombre");
//		modeloTabla.addRow(new String[] {"a", "b", "c", "d", "d", "d"});
//		modeloTabla.addRow(new String[] {"a", "b", "c", "d", "d", "d"});
//		modeloTabla.addRow(new String[] {"a", "b", "c", "d", "d", "d"});
//		modeloTabla.addRow(new String[] {"a", "b", "c", "d", "d", "d"});
//		modeloTabla.addRow(new String[] {"a", "b", "c", "d", "d", "d"});
//		modeloTabla.addRow(new String[] {"a", "b", "c", "d", "d", "d"});
//		modeloTabla.addRow(new String[] {"a", "b", "c", "d", "d", "d"});
		
		
		
	}
	
	
	// Servicios
	// ============================================================================================

	/**
	 * Permite que la línea divisoria entre las dos tablas se mantenga siempre a la mitad de
	 * la ventana
	 */
	@Override
	public void paint(Graphics g) {
		Dimension d = this.getSize();
		division.setDividerLocation((int)(d.width)/2);
		super.paint(g);
	}
	
	public static void main(String[] args) {
		InterfazAutomata ventana = new InterfazAutomata();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

}

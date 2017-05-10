package gui;

import concesionarioCoches.Marca;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import concesionarioCoches.Coche;
import concesionarioCoches.Color;
import concesionarioCoches.Concesionario;
import concesionarioCoches.Modelo;
import excepciones.CocheNoValidoException;

import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * 
 * @author pablo
 *
 */
public class VentanaGenerica extends JDialog {
	protected final JPanel contentPanel = new JPanel();
	protected JTextField textField;
	protected JLabel lblMatricula;
	protected JLabel lblColor;
	protected JLabel lblMarca;
	protected JLabel lblModelo;
	protected JRadioButton rbPlateado;
	protected JRadioButton rbRojo;
	protected JRadioButton rbAzul;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JComboBox<Marca> comboBoxMarca;
	protected JComboBox<Modelo> comboBoxModelo;
	protected JButton botonGenerico;
	private JLabel lblModelo_1;
	protected JButton salir;
	protected JButton buttonPrevious;
	protected JButton buttonNext;
	protected int posicion;
	protected JButton btBuscar;

	public VentanaGenerica() {
	
		setTitle("");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 367, 260);

		lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(26, 11, 76, 30);
		buttonPrevious = new JButton("<<");
		buttonPrevious.setBounds(106, 201, 43, 23);

		buttonNext = new JButton(">>");
		buttonNext.setBounds(148, 201, 43, 23);

		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (!Coche.matriculaValida(textField.getText())) {
					textField.setForeground(java.awt.Color.red);//si no es valida, se lo indicamos en rojo
					textField.setText(textField.getText()+"   ERROR");
				}
			}
			@Override
			public void focusGained(FocusEvent arg0) {
				textField.setForeground(java.awt.Color.black);
				textField.setText("");//una vez regresa, vuelve a ponerse negro
			}
		});

		textField.setBounds(106, 16, 177, 20);
		textField.setColumns(10);

		lblColor = new JLabel("Color");
		lblColor.setBounds(26, 58, 49, 14);

		rbPlateado = new JRadioButton("Plateado");
		rbPlateado.setBounds(241, 54, 99, 23);
		buttonGroup.add(rbPlateado);

		rbRojo = new JRadioButton("Rojo");
		rbRojo.setBounds(106, 54, 65, 23);
		buttonGroup.add(rbRojo);

		rbAzul = new JRadioButton("Azul");
		rbAzul.setBounds(173, 54, 65, 23);
		buttonGroup.add(rbAzul);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(26, 99, 49, 14);

		comboBoxMarca = new JComboBox<Marca>();
		comboBoxMarca.setModel(new DefaultComboBoxModel(Marca.values()));//toma los valores del array de marcas
		comboBoxMarca.setSelectedItem(null); //Para que se inicie en blanco
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
					//inserta los valores de modelos una vez seleccionada la marca
				comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca))); 
			}
		});
		comboBoxMarca.setBounds(106, 95, 92, 22);
		comboBoxModelo = new JComboBox<Modelo>();
		comboBoxModelo.setBounds(106, 138, 92, 22);
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(26, 142, 49, 14);
		botonGenerico = new JButton("");
		lblModelo_1 = new JLabel("Modelo");
		lblModelo_1.setBounds(26, 142, 49, 14);
		botonGenerico.setBounds(106, 201, 86, 23);
		buttonPrevious = new JButton("<");		
		buttonPrevious.setBounds(106, 201, 43, 23);
		buttonNext = new JButton(">");
		buttonNext.setBounds(148, 201, 43, 23);
		
		btBuscar = new JButton ("Buscar");
		btBuscar.setBounds(260, 7, 91, 23);
		salir = new JButton("Salir");
		salir.setBounds(218, 201, 99, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		getContentPane().add(btBuscar);
		getContentPane().setLayout(null);
		getContentPane().add(lblMarca);
		getContentPane().add(lblModelo);
		getContentPane().add(lblColor);
		getContentPane().add(lblMatricula);
		getContentPane().add(rbPlateado);
		getContentPane().add(rbRojo);
		getContentPane().add(rbAzul);
		getContentPane().add(botonGenerico);
		getContentPane().add(salir);
		getContentPane().add(buttonPrevious);
		getContentPane().add(buttonNext);
		getContentPane().add(comboBoxMarca);
		getContentPane().add(comboBoxModelo);
		getContentPane().add(textField);
		getContentPane().add(buttonNext);
		getContentPane().add(buttonPrevious);
		getContentPane().add(lblModelo_1);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	/**
	 * Selecciona un Color en funcion del boton seleccionado
	 * @return Enum Color
	 */
	Color getColor() {
		if (rbPlateado.isSelected())
			return Color.PLATA;
		else if (rbRojo.isSelected())
			return Color.ROJO;
		else if (rbAzul.isSelected())
			return Color.AZUL;
		else
			return null;
	}
	
	void actualizar() {
		if (Principal.miConcesionario.size()==0) {
			return;
		}
		posicion = 0;
		mostrarCoche(Principal.miConcesionario.get(posicion));
		comprobarLimites();		
	}
	/**
	 * devuelve el conjunto de modelos en funcion de la marca seleccionada en el combobox
	 * @param comboBoxMarca
	 * @return
	 */
	private Object[] getModelo(JComboBox<Marca> comboBoxMarca) {
		Marca marca = (Marca) comboBoxMarca.getSelectedItem();
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		for (Modelo m : Modelo.values()) {
			if (m.getMarca() == marca)
				modelos.add(m);
		}
		return modelos.toArray();
	}
	
	void mensajeError() {
		JOptionPane.showMessageDialog(
				contentPanel, "\nImposible anadir el coche",
				"Error", JOptionPane.ERROR_MESSAGE);
	}
	/**
	 * bloquea el acceso a posiciones fuera de rango
	 */
	protected void comprobarLimites() {
		if (Principal.miConcesionario.get(posicion + 1) == null)
			buttonNext.setEnabled(false);
		else
			buttonNext.setEnabled(true);

		if (Principal.miConcesionario.get(posicion - 1) == null)
			buttonPrevious.setEnabled(false);
		else
			buttonPrevious.setEnabled(true);
	}
	/**
	 * vacia el contenido de la ventana
	 */
	void limpiarFormulario() {
		textField.setText("");
		buttonGroup.clearSelection();
		comboBoxMarca.setSelectedItem(null);
		comboBoxModelo.setSelectedItem(null);	
	}
	/**
	 * Muestra el coche en la ventana
	 * @param coche
	 */
	void mostrarCoche(Coche coche) {
		switch (coche.getColor()) {
		case PLATA:
			rbPlateado.setSelected(true);
			break;
		case ROJO:
			rbRojo.setSelected(true);
			break;
		case AZUL:
			rbAzul.setSelected(true);
		}
		textField.setText(coche.getMatricula());
		comboBoxMarca.addItem(coche.getModelo().getMarca());
		comboBoxMarca.setSelectedItem(coche.getModelo().getMarca());
		comboBoxModelo.addItem(coche.getModelo());
		comboBoxModelo.setSelectedItem(coche.getModelo());
	}

}

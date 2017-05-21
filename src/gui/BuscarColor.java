package gui;

import concesionarioCoches.Coche;
import concesionarioCoches.Color;
import concesionarioCoches.Marca;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import concesionarioCoches.Modelo;
import java.util.ArrayList;
import javax.swing.JSeparator;
/**
 * Muestra el conjunto de vehiculos de un color determinado
 * @author pablo
 *
 */
class BuscarColor extends VentanaGenerica {

	private JSeparator separator;
	private ArrayList<Coche> concesionarioColor;
	JComboBox comboBoxColor;

	//La ventana tiene dimensiones distintas, por eso la localizacion vuelve a introducirse
	public BuscarColor() {
		textField.setLocation(103, 52);
		lblMatricula.setLocation(26, 47);
		lblColor.setLocation(26, 88);
		rbAzul.setLocation(173, 84);
		rbPlateado.setLocation(241, 84);
		rbRojo.setLocation(107, 84);
		lblMarca.setLocation(26, 118);
		lblModelo.setLocation(26, 165);
		comboBoxMarca.setLocation(110, 114);
		comboBoxModelo.setLocation(107, 161);
		setTitle("Buscar por color");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 367, 260);
		botonGenerico.setVisible(false);
		buttonNext.setVisible(true);
		buttonPrevious.setVisible(true);
		btBuscar.setVisible(true);
		textField.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		comboBoxMarca.setEnabled(false);
		rbRojo.setEnabled(false);
		rbPlateado.setEnabled(false);
		rbAzul.setEnabled(false);

		
		//retroceder
		buttonPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retroceder();
			}
		});
		buttonPrevious.setBounds(106, 201, 43, 23);
		
		//avanzar
		buttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avanzar();
			}
		});
		
		JLabel lblSeleccionaColor = new JLabel("Selecciona Color: ");
		lblSeleccionaColor.setBounds(10, 11, 103, 14);
		getContentPane().add(lblSeleccionaColor);
		comboBoxColor = new JComboBox();
		comboBoxColor.setModel(new DefaultComboBoxModel(Color.values()));
		comboBoxColor.setSelectedItem(null);
		
		comboBoxColor.setBounds(106, 7, 132, 22);
		getContentPane().add(comboBoxColor);
		
		separator = new JSeparator();
		separator.setBounds(0, 40, 361, 2);
		getContentPane().add(separator);
		
		//recogiendo la opcion del combobox creamos un nuevo concesionario y actualizamos el listado
		btBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			concesionarioColor = Principal.miConcesionario.getCochesColor((Color)comboBoxColor.getSelectedItem());
			if (concesionarioColor.size()==0)
				JOptionPane.showMessageDialog(rootPane, "no hay coches de ese color");;
				actualizarColor();
			}

		});
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
		
	/**
	 * Avanza en el listado, si llega al extremo del arraylist, impide que se pueda volver a avanzar
	 */
	private void avanzar() {
		mostrarCoche(concesionarioColor.get(++posicion));
		textField.setText(concesionarioColor.get(posicion).getMatricula());
		comprobarLimitesColor();
	}
	/**
	 * Retrocede en el listado, si llega al extremo del arraylist, impide que se pueda volver a retroceder
	 */
	private void retroceder() {
		mostrarCoche(concesionarioColor.get(--posicion));
		textField.setText(concesionarioColor.get(posicion).getMatricula());
		comprobarLimitesColor();
	}
	/**
	 * Actualiza la posicion en el arraylist
	 */
	void actualizarColor() {
		mostrarCoche(concesionarioColor.get(0));
		comprobarLimites();		
	}
	
	/**
	 * Comprueba cuando se ha llegado al extremo superior o inferior del arraylist
	 */
	private void comprobarLimitesColor() {
		if ((posicion +1) == concesionarioColor.size())
			{buttonNext.setEnabled(false);
			buttonNext.setVisible(false);}
		else{
			buttonNext.setEnabled(true);
			buttonNext.setEnabled(true);
		if ((posicion-1) == -1)
			{buttonPrevious.setEnabled(false);
			buttonPrevious.setVisible(false);}
		else{
			buttonPrevious.setEnabled(true);
			buttonPrevious.setVisible(true);}
		}
	}
}
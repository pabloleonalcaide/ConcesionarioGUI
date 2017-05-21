package gui;

import concesionarioCoches.Coche;
import concesionarioCoches.Marca;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
import excepciones.MatriculaNoValidaException;

import java.awt.Color;

/**
 * Busca por Matricula un vehiculo del concesionario
 * 
 * @author pablo
 *
 */
class Buscar extends VentanaGenerica {

	public Buscar() {
		setTitle("Buscar por matricula");
		lblColor = new JLabel("Color");
		rbPlateado.setEnabled(false);
		rbRojo.setEnabled(false);
		rbAzul.setEnabled(false);
		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		btBuscar.setVisible(false);
		botonGenerico.setVisible(true);
		botonGenerico.setText("Buscar");
		buttonNext.setVisible(false);
		buttonPrevious.setVisible(false);
		botonGenerico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coche coche = null;
				try {
					coche = Principal.miConcesionario.get(textField.getText());
					mostrarCoche(coche);
				} catch (MatriculaNoValidaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}

			}
		});

	}
}

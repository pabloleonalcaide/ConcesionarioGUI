package gui;

import concesionarioCoches.Marca;
import java.awt.FlowLayout;
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
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
/**
 * 
 * @author pablo
 *
 */
public class VentanaBaja extends VentanaGenerica {

	public VentanaBaja() {
		setTitle("--Gestion Baja Vehiculo--");
		comboBoxModelo.setEnabled(false);
		comboBoxMarca.setEnabled(false);
		rbRojo.setEnabled(false);
		rbPlateado.setEnabled(false);
		rbAzul.setEnabled(false);
		btBuscar.setVisible(false);
		botonGenerico.setVisible(true);
		botonGenerico.setText("eliminar");
		botonGenerico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Coche coche = Principal.miConcesionario.get(textField.getText());
				if (coche != null) {
					mostrarCoche(coche);
					int opcion = JOptionPane.showOptionDialog(contentPanel,
							"Seguro?", "Eliminar?",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null);
					
					switch (opcion) {
					case JOptionPane.YES_OPTION:
						Principal.miConcesionario.eliminar(textField.getText());
						limpiarFormulario();
						Principal.miConcesionario.setModificado(true);
						JOptionPane.showMessageDialog(rootPane, "Eliminado con exito");
						break;
					}
				} else {
					JOptionPane.showMessageDialog(contentPanel,
							"No se ha podido eliminar.", "Error",
							JOptionPane.ERROR_MESSAGE);
			}}
		});

	
			}
	
	
}

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import concesionarioCoches.Modelo;
import excepciones.CocheNoValidoException;
import excepciones.ColorNoValidoException;
import excepciones.MatriculaNoValidaException;
import excepciones.ModeloNoValidoException;
/**
 * 
 * @author pablo
 *
 */
public class VentanaAlta extends VentanaGenerica {
	public VentanaAlta() {
		setTitle("Gestion Alta Vehiculo");
		botonGenerico.setVisible(true);
		botonGenerico.setText("a\u00f1adir");
		btBuscar.setVisible(false);
			
	botonGenerico.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		add();
		}

		private void add() {


				try {
					Principal.miConcesionario.annadir(textField.getText(), getColor(), (Modelo) comboBoxModelo.getSelectedItem());
					JOptionPane.showMessageDialog(contentPanel, "Coche a\u00f1adido con exito.");
					Principal.miConcesionario.setModificado(true);
				} catch (CocheNoValidoException | MatriculaNoValidaException | ColorNoValidoException
						| ModeloNoValidoException e) {
					JOptionPane.showMessageDialog (null,e.getMessage(),"Error en las altas",JOptionPane.ERROR_MESSAGE);

				}
							


		}
		
	});
}}

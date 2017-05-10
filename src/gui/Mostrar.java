package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author pablo
 *
 */
class Mostrar extends VentanaGenerica {

	public Mostrar() {
		setTitle("Mostrar:");
		botonGenerico.setVisible(false);
		textField.setEnabled(false);
		buttonNext.setVisible(true);
		buttonPrevious.setVisible(true);
		rbRojo.setEnabled(false);
		rbPlateado.setEnabled(false);
		rbAzul.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		comboBoxMarca.setEnabled(false);
		btBuscar.setVisible(false);
		buttonPrevious.addActionListener(new ActionListener() {	
		public void actionPerformed(ActionEvent e) {
			retroceder();
			}
		});

		buttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avanzar();
			}
		});

	}
	/**
	 * Avanza en el listado, si llega al extremo del arraylist, impide que se pueda volver a avanzar
	 */
	private void avanzar() {
		mostrarCoche(Principal.miConcesionario.get(++posicion));
		comprobarLimites();
	}
	/**
	 * Retrocede en el listado, si llega al extremo del arraylist, impide que se pueda volver a retroceder
	 */
	private void retroceder() {
		mostrarCoche(Principal.miConcesionario.get(--posicion));
		comprobarLimites();
	}
}
package gui;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.TextArea;
/**
 * 
 * @author pablo
 *
 */
public class Ayuda extends JDialog {

	private static Ayuda ayuda;
	private final JPanel contentPanel = new JPanel();

	private Ayuda() {
		setResizable(false);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("Ayuda Concesionario");
		setModal(false);
		setBounds(100, 100, 327, 308);

		getContentPane().setLayout(null);

		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setText(
				"---------------------Archivo-------------------------\r\nCrea un Nuevo Concesionario o Abre uno nuevo "
				+ "\r\npara empezar.\r\nGuarda los cambios en el mismo fichero o en otro \r\ndiferente.\r\n\r\n"
				+ "---------------------Coche:----------------------------\r\nA\u00F1ade, Elimina o Muestra los coches "
				+ "del concesionario, \r\nrecuerda que para ello debes tener un concesionario \r\nabierto.\r\n"
				+ "---------------------Buscar:---------------------------\r\nLocaliza un veh\u00EDculo por su "
				+ "matr\u00EDcula o identificalo\r\n por su color.\r\n\r\nAl introducir un nuevo vehiculo recuerda que la"
				+ " \r\nmatricula debe ser v\u00E1lida (1234-HJP, 1234 HJP)\r\n las letras han de ser introducidas en "
				+ "may\u00FAscula, \r\nsi te equivocas no te preocupes, el programa te \r\nadvertir\u00E1 antes de "
				+ "introducirlo en el registro.");
		textArea.setBounds(0, 0, 327, 283);
		getContentPane().add(textArea);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	/**
	 * singleton
	 * @return new Ayuda
	 */
	public static Ayuda getInstance() {
		if (ayuda == null)
			ayuda = new Ayuda();
		return ayuda;
	}
}
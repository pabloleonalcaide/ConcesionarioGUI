package gui;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;
/**
 * 
 * @author pablo
 *
 */
public class AcercaDe extends JDialog {

	
	private final JPanel contentPanel = new JPanel();

	public AcercaDe() {
		setBackground(UIManager.getColor("Button.select"));
		getContentPane().setBackground(UIManager.getColor("Button.select"));
		setTitle("Acerca del Proyecto");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 344, 119);
		
		JTextArea txtrAutorPabloLeon = new JTextArea();
		txtrAutorPabloLeon.setToolTipText("");
		txtrAutorPabloLeon.setBackground(UIManager.getColor("Button.select"));
		txtrAutorPabloLeon.setEditable(false);
		txtrAutorPabloLeon.setText("Autor: Pablo Leon Alcaide\r\n \r\nAsignatura: Programacion\r\n\r\nFecha de entrega: Ayer\r\n ");
		txtrAutorPabloLeon.setBounds(12, 0, 332, 128);
		
		getContentPane().setLayout(null);
		getContentPane().add(txtrAutorPabloLeon);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
}
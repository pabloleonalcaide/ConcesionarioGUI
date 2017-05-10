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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import concesionarioCoches.Modelo;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

class VentanaGeneral extends JDialog {

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
	protected JButton add;
	protected JButton eliminar;
	protected JButton buttonPrevious;
	protected JButton buttonNext;
	protected JButton search;
	protected JButton salir;

	public VentanaGeneral() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 367, 260);

		lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(26, 11, 76, 30);

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setBounds(106, 16, 177, 20);
		textField.setColumns(10);

		lblColor = new JLabel("Color");
		lblColor.setBounds(26, 58, 49, 14);

		rbPlateado = new JRadioButton("Plata");
		rbPlateado.setBounds(241, 54, 65, 23);
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
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

			}
		});
		comboBoxMarca.setBounds(106, 95, 92, 22);
		comboBoxModelo = new JComboBox<Modelo>();
		comboBoxModelo.setBounds(106, 138, 92, 22);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(26, 142, 49, 14);

		add = new JButton("Aniadir");
		add.setBounds(106, 201, 86, 23);

		eliminar = new JButton("Eliminar");
		eliminar.setBounds(106, 201, 86, 23);

		buttonPrevious = new JButton("<");
		buttonPrevious.setBounds(106, 201, 43, 23);

		buttonNext = new JButton(">");
		buttonNext.setBounds(148, 201, 43, 23);

		search = new JButton("Buscar");
		search.setBounds(106, 201, 86, 23);

		salir = new JButton("Salir");
		salir.setBounds(218, 201, 65, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		getContentPane().setLayout(null);
		getContentPane().add(lblMarca);
		getContentPane().add(lblModelo);
		getContentPane().add(lblColor);
		getContentPane().add(lblMatricula);
		getContentPane().add(rbPlateado);
		getContentPane().add(rbRojo);
		getContentPane().add(rbAzul);
		getContentPane().add(add);
		getContentPane().add(eliminar);
		getContentPane().add(buttonPrevious);
		getContentPane().add(buttonNext);
		getContentPane().add(search);
		getContentPane().add(salir);
		getContentPane().add(comboBoxMarca);
		getContentPane().add(comboBoxModelo);
		getContentPane().add(textField);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

}
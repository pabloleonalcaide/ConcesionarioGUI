package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import concesionarioCoches.Concesionario;
import ficheros.Fichero;  //Nuestra clase que controla el flujo de ficheros
import ficheros.Filtro;		//Nuestra clase que maneja el filtro para la extension de los ficheros
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.InputEvent;
import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.Toolkit;  // Permite mostrar un mensaje de ayuda al pasar el puntero sobre un elemento
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Font;
/**
 * 
 * @author pablo
 *
 */
public class Principal{
	JFrame frame;
	//Concesionario static para acceder desde las distintas ventanas, solo operamos simultaneamente con un concesionario.
	public static Concesionario miConcesionario = new Concesionario();
	Filtro filtro = new Filtro(".obj", "Objeto");
	private JFileChooser fileChooser= new JFileChooser();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Sin Titulo: Concesionario");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBackground(Color.LIGHT_GRAY);
		//icono que aparece al abrir la aplicacion.
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage("car.png"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setToolTipText("Menu Concesionario");
		menuBar.setBounds(0, 0, 442, 21);
		frame.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setToolTipText("abre/guarda un concesionario o cierra la aplicacion");
		mnNewMenu.setBackground(Color.LIGHT_GRAY);
		mnNewMenu.setMnemonic('A');
		menuBar.add(mnNewMenu);
		
		//NUEVO CONCESIONARIO -----> 
		JMenuItem mntmNuevoConc = new JMenuItem("Nuevo Concesionario");
		mntmNuevoConc.setToolTipText("Nuevo");
		mntmNuevoConc
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mntmNuevoConc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openNew();
				JOptionPane.showMessageDialog(frame, "Concesionario creado");
				}
		});
		mnNewMenu.add(mntmNuevoConc);

		//ABRIR CONCESIONARIO ---> 
		JMenuItem mntmAbrirConcesionario = new JMenuItem("Abrir Concesionario");
		mntmAbrirConcesionario.setToolTipText("Abre un nuevo concesionario");
		mntmAbrirConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmAbrirConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 open();
			}
		});
		mnNewMenu.add(mntmAbrirConcesionario);

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		//GUARDAR --> SOLO SI HAY MODIFICACIONES
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setToolTipText("guarda el concesionario");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmGuardar);
		
		//GUARDAR COMO  -->
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar Como");
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  saveAs();
			}});
		mnNewMenu.add(mntmGuardarComo);
		
		//SALIR  --->
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setToolTipText("cerrar aplicacion");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Preguntar si desea guardar cuando hay modificaciones
				if(miConcesionario.isModificado()){
					Object[] options = { "SI", "NO", "CANCELAR" };
					int respuesta = JOptionPane.showOptionDialog(null, "No has guardado, Desea Guardar?", "NO HAS GUARDADO",
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
					if(respuesta == 0){
						saveAs();
						System.exit(0);
					}else if(respuesta == 1){
						System.exit(0);
					}
				}else{
					System.exit(0);
				}
			}
		});
		mnNewMenu.add(mntmSalir);

		JMenu mnArchivo = new JMenu("Coche");
		mnArchivo.setMnemonic('C');
		mnArchivo.setBackground(Color.LIGHT_GRAY);
		mnArchivo.setToolTipText("Gestiona los coches");
		menuBar.add(mnArchivo);
		
		//ALTA DE VEHICULOS  --> 
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.setToolTipText("Agrega Vehiculo");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					VentanaAlta alta = new VentanaAlta();
					alta.setVisible(true);
				

			}
		});
		mntmAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmAlta);
		
		//BAJA DE VEHICULOS  --> 
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.setToolTipText("Eliminar Vehiculo");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (miConcesionario.size()>0) {
					VentanaBaja baja = new VentanaBaja();
					baja.setVisible(true);
				} else {
					try {
						throw new ConcesionarioVacioException("el concesionario esta vacio");
					} catch (ConcesionarioVacioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}				}
			}
		});
		mntmBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmBaja);
		
		//MOSTRAR CONCESIONARIO  --> 
		JMenuItem mntmMostrar = new JMenuItem("Mostrar Concesionario");
		mntmMostrar.setToolTipText("muestra los vehiculos almacenados");
		mntmMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!miConcesionario.isVacio()) {
					Mostrar mostrar = new Mostrar();
					mostrar.mostrarCoche(miConcesionario.get(0));
					mostrar.comprobarLimites();
					mostrar.setVisible(true);
				} else {
					try {
						throw new ConcesionarioVacioException("el concesionario esta vacio");
					} catch (ConcesionarioVacioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		mnArchivo.add(mntmMostrar);
		
		// BUSCAR COCHE POR MATRICULA  --> 
		JMenu mnBuscar = new JMenu("Buscar");
		mnBuscar.setMnemonic('S');
		mnBuscar.setBackground(Color.LIGHT_GRAY);
		mnBuscar.setToolTipText("Buscar Vehiculos");
		menuBar.add(mnBuscar);

		JMenuItem mntmPorMatricula = new JMenuItem("por Matricula");
		mntmPorMatricula.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mntmPorMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (miConcesionario.isVacio()) {
					try {
						throw new ConcesionarioVacioException("el concesionario esta vacio");
					} catch (ConcesionarioVacioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					Buscar buscar = new Buscar();
					buscar.setVisible(true);
				}
			}
		});
		mnBuscar.add(mntmPorMatricula);

		// BUSCAR COCHE POR COLOR  --> 
		JMenuItem mntmPorColor = new JMenuItem("por Color");
		mntmPorColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmPorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (miConcesionario.isVacio())
					try {
						throw new ConcesionarioVacioException("el concesionario esta vacio");
					} catch (ConcesionarioVacioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				else {
					BuscarColor color = new BuscarColor();
					color.setVisible(true);
				}
			}
		});
		mnBuscar.add(mntmPorColor);

		//MENU AYUDA --> 
		JMenu mnAyuda_1 = new JMenu("Ayuda");
		mnAyuda_1.setToolTipText("necesitas ayuda?");
		mnAyuda_1.setMnemonic('Y');
		mnAyuda_1.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnAyuda_1);
		
		//About -->
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe acercade = new AcercaDe();
				acercade.setVisible(true);
			}
		});
		mnAyuda_1.add(mntmAcercaDe);
		// AYUDA -->
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ayuda ayuda = Ayuda.getInstance();
				ayuda.setVisible(true);
				
			}
		});
		mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnAyuda_1.add(mntmAyuda);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { frame.getContentPane(), menuBar, mnNewMenu, mntmNuevoConc, mntmAbrirConcesionario,
						separator, mntmGuardar, mntmGuardarComo, mntmSalir, mnArchivo, mntmAlta, mntmBaja, mntmMostrar,
						mnBuscar, mntmPorMatricula, mntmPorColor, mnAyuda_1, mntmAcercaDe, mntmAyuda }));
	}

	/**
	 * Abre un nuevo fichero, si ya estabamos manejando uno, pregunta si desea guardar
	 */
	protected void openNew() {
		if (miConcesionario.isModificado()) {
			Object[] options = { "SI", "NO", "CANCELAR" };
			int respuesta = JOptionPane.showOptionDialog(null, "Desea guardar los cambios?", "Hay Cambios sin Guardar",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if (respuesta==JOptionPane.YES_OPTION) {
				saveAs();
				Fichero.setFichero("Concesionario: Sin Titulo");
				miConcesionario = new Concesionario();
				frame.setTitle(Fichero.fichero.getName());
				miConcesionario.setModificado(false);
			} else if (respuesta == 1) {
				Fichero.setFichero("Concesionario: Sin Titulo");
				miConcesionario = new Concesionario();
				frame.setTitle(Fichero.fichero.getName());
				miConcesionario.setModificado(false);
			}
		} else {
			Fichero.setFichero("Concesionario: SinTitulo");
			miConcesionario = new Concesionario();
			frame.setTitle(Fichero.fichero.getName());
			miConcesionario.setModificado(false);
		}
	}

	/**
	 * Abre un concesionario desde un fichero
	 */
	protected void open() {
		if (miConcesionario.isModificado()) {
			Object[] options = { "SI", "NO", "CANCEL" };
			int option = JOptionPane.showOptionDialog(null, "Desea guardar los cambios?", "Hay Cambios sin Guardar",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if (option == 0) {
				saveAs();
			} else if (option == 1) {
				try {
					openFileChooser();
				} catch (IOException | ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Hay problemas para abrir el fichero", "ERROR", JOptionPane.ERROR_MESSAGE);
					Fichero.newFile();
				}
			}
		} else {
			try {
				openFileChooser();
			} catch (IOException | ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(null, "Hay problemas para abrir el fichero", "ERROR", JOptionPane.ERROR_MESSAGE);
				Fichero.newFile();
			}
	
		}
	}

	/**
	 * Crea un nuevo FileChooser
	 * 
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void openFileChooser() throws FileNotFoundException, ClassNotFoundException, IOException {
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(filtro);
		if (fileChooser.showDialog(fileChooser, "Abrir Fichero") == JFileChooser.APPROVE_OPTION) {
			Fichero.fichero = fileChooser.getSelectedFile();
			miConcesionario = (Concesionario) Fichero.open(fileChooser.getSelectedFile());
			frame.setTitle(Fichero.getFichero().getName());
			miConcesionario.setModificado(false);
	
		}
	}

	/**
	 * Guarda el concesionario en un fichero
	 */
	protected void save() {
		if (Fichero.fichero.getName().equalsIgnoreCase("Concesionario: Sin Titulo")) {
			saveAs();
			miConcesionario.setModificado(false);
		} else {
			try {
				Fichero.save(miConcesionario);
				miConcesionario.setModificado(false);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Hay problemas para guardar el fichero", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Metodo que permite guardar un fichero con la accion guardar como...
	 */
	protected void saveAs() {
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(filtro);
	
		if (JFileChooser.APPROVE_OPTION == fileChooser.showDialog(fileChooser, "Guardar Archivo")) {
	
			fileChooser.setAcceptAllFileFilterUsed(false);
			Fichero.checkFile(fileChooser.getSelectedFile());
			if (Fichero.getFichero().exists()) {
				Object[] options = { "Si", "No" };
				int option = JOptionPane.showOptionDialog(null, "El archivo indicado ya existe, Desea Sobreescribirlo?",
						"Guardando", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
						options[0]);
				if (option == JFileChooser.APPROVE_OPTION) {
					try {
						Fichero.saveAs(miConcesionario, Fichero.getFichero());
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "No se ha podido guardar", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
	
			}else{
				save();
			}
	
			frame.setTitle(Fichero.getFichero().getName());
			miConcesionario.setModificado(false);
		}
	}
	
}

package concesionarioCoches;

import excepciones.CocheNoExisteException;
import excepciones.MatriculaNoValidaException;

//P: indica las etiquetas html utilizadas para la documentaci�n de la clase
//P: Indica la utilidad de la etiqueta  -noqualifier  all a la hora de generar la documentaci�n JavaDoc. Entrega un pantallazo indicando c�mo se detalla en Eclipse

import utiles.*;

/**
 * Queremos modelar un concesionario de coches en Java. Nos limitaremos a las
 * siguientes opciones:
 * <ol>
 * <li>Alta de un coche (se pedir� matricula, color y modelo),</li>
 * <li>Baja de un coche (por matr�cula)</li>
 * <li>Mostrar un coche (por matr�cula)</li>
 * <li>Mostrar concesionario (todos los coches del concesionario)</li>
 * <li>Contar el n�mero de coches en el concesionario</li>
 * <li>Mostrar coches de un color</li>
 * </ol>
 * <p>
 * L�gicamente, no podr� a�adirse un coche inv�lido o ya contenido (No pueden
 * existir dos coches con la misma matr�cula en el concesionario) Por cada p que
 * se d� de alta, han de conocerse todas sus caracter�sticas. Ninguna de las
 * caracter�sticas del coche puede ser por defecto.
 * 
 * @author Mar�aLourdes
 * 
 */
public class TestConcesionario extends Concesionario {
	/**
	 * Men� principal de la aplicaci�n
	 */
	static Menu menu = new Menu("Concesionario de coches", new String[] {
			"Alta Coche", "Baja Coche", "Mostrar Coche",
			"Mostrar concesionario", "Contar coches del concesionario",
			"Mostrar coches de un color","Ficheros", "Salir" });
	/**
	 * Men� para seleccionar los colores del coche
	 */
	private static Menu menuColores = new Menu("Colores de los coches",
			Color.AZUL.generarOpcionesMenu());

	/**
	 * Men� para seleccionar los modelos del coche
	 */
	private static Menu menuModelos = new Menu("Modelos de los coches",
			Modelo.CORDOBA.generarOpcionesMenu());
	/**
	 * Donde se gestionar� el concesionario
	 */
	private static Menu menuFichero = new Menu("Gestionar Ficheros", new String[]{"nuevo","abrir","guardar","guardar como","salir"});
	static Concesionario concesionario = new Concesionario();

	/**
	 * Arranque del programa
	 * 
	 * @param args
	 *            No se utilizan
	 */
	public static void main(String[] args) {
		do {
			switch (menu.gestionar()) {
			case 1:// "A�adir Coche
				annadirCoche();
				break;
			case 2:// Eliminar Coche
				eliminarCoche();
				break;
			case 3:// Obtener Coche
				getCoche();
				break;
			case 4:// Mostrar lista
				System.out.println(concesionario);
				break;
			case 5:// Contar coches
				System.out.println("N�mero de coches en el concesionario: "
						+ concesionario.size());
				break;
			case 6:// Mostrar coches de un color
				System.out.println(concesionario.getCochesColor(pedirColor()));
				break;
			case 7:
				gestionarFicheros()
				;break;
			default:// Salir
				System.out.println("bye!");
				return;
			}
		} while (true);
	}
	/**
	 * Menu para gestionar los ficheros
	 */
	private static void gestionarFicheros() {
		switch(menuFichero.gestionar()){
		case 1: nuevoConcesionario();break;
		case 2: abrirFichero();break;
		case 3: abrirFichero();break;
		case 4: guardarFicheroComo();break;
		default: 
			System.out.println("adiosss");
		}
		
	}

	private static void guardarFicheroComo() {
		
		
	}
	private static void abrirFichero() {
		
		
	}
	private static void nuevoConcesionario() {
		
		
	}
	/**
	 * Muestra por consola el coche solicitando su la matr�cula
	 */
	private static void getCoche() {
		try {
			System.out.println(concesionario.get(Teclado
					.leerCadena("Introduce la matr�cula")));
		} catch (MatriculaNoValidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Elimina un coche solicitando su la matr�cula
	 */
	private static void eliminarCoche() {
		try {
			if (concesionario.eliminar(Teclado
					.leerCadena("Introduce la matr�cula")))
				System.out.println("Coche eliminado");
			else
				System.out
						.println("El coche no se ha podido eliminar. No existe un coche con esa matr�cula en el concesionario");
		} catch (MatriculaNoValidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * A�ade un coche solicitando sus datos por consola
	 */
	private static void annadirCoche() {

		try {
			concesionario.annadir(Teclado.leerCadena("Introduce la matr�cula"),
					pedirColor(), pedirModelo());
			System.out.println("Coche a�adido con �xito");
		} catch (Exception e) {
			System.out.println(e.getMessage()
					+ "No se ha podido a�adir el coche en el concesionario");
		}

	}

	/**
	 * Solicita al usuario un modelo de coche Seg�n el enunciado del examen:
	 * 
	 * <pre>
	 * Para solicitar el Modelo al dar de alta al coche se implementar� un m�todo
	 * pedirModelo que mediante la gesti�n de un men�, devolver� el modelo indicado
	 * </pre>
	 * 
	 * @return modelo introducido por el usuario. null si el usuario no
	 *         introduce ninguno v�lido
	 */
	private static Modelo pedirModelo() {
		int opcion = menuModelos.gestionar();
		Modelo[] arrModelos = Modelo.CORDOBA.getValues();
		if (opcion == arrModelos.length + 1)
			return null;
		return arrModelos[opcion - 1];
	}

	/**
	 * Solicita al usuario un color de coche. Seg�n el enunciado del examen:
	 * 
	 * <pre>
	 * Para solicitar el color al dar de alta al coche se implementar� un m�todo
	 * pedirColor que mediante la gesti�n de un men�, devolver� el color indicado
	 * </pre>
	 * 
	 * @return color introducido por el usuario. null si el usuario no introduce
	 *         ninguno v�lido
	 */
	private static Color pedirColor() {
		int opcion = menuColores.gestionar();
		Color[] arrColores = Color.AZUL.getValues();
		if (opcion == arrColores.length + 1)
			return null;
		return arrColores[opcion - 1];
	}
}

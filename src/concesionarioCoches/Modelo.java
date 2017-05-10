package concesionarioCoches;

/**
 * Representa los modelos. Seg�n el enunciado del examen:
 * <pre>
 *  Se limitar�n los modelos de coches a siete: C�rdoba (marca Seat),
 *  Toledo (marca Seat),Ibiza (marca Seat), Serie 1 (marca BMW), Serie 2 (marca BMW),
 *  Serie 3 (marca BMW) y Serie 5 (marca BMW).
 * </pre>
 * @author Mar�aLourdes
 * 
 */
public enum Modelo {
	
	SERIE1(Marca.BMW),
	
	SERIE2(Marca.BMW),
	
	SERIE3(Marca.BMW),

	SERIE5(Marca.BMW),

	CORDOBA(Marca.SEAT),

	IBIZA(Marca.SEAT),

	PANDA(Marca.SEAT);

	private Marca marca;

	/**
	 * Crea un modelo con la marca indicada
	 * 
	 * @param marca
	 *            Marca del nuevo modelo
	 */
	private Modelo(Marca marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la marca del modelo
	 * 
	 * @return Marca del modelo
	 */
	public Marca getMarca() {
		return marca;
	}

	/**
	 * Devuelve una representaci�n del modelo en forma de cadena.
	 */
	public String toString() {
		return name();

	}

	// Para el men�-------------------------------------------------
	/**
	 * Almacena los modelos posibles
	 */
	private static final Modelo[] VALUES = values();

	/**
	 * Genera las opciones del men�
	 * 
	 * @return Opciones del men�, incluyendo "Salir"
	 */
	public String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (Modelo modelo : VALUES) {
			opcionesMenu[i++] = modelo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	/**
	 * Devuelve VALUES
	 * 
	 * @return VALUES
	 * @see Modelo#VALUES
	 */
	public Modelo[] getValues() {
		return VALUES;
	}
	// -------------------------------------------------

}

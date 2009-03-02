package GestorDeErrores;

//***************************************************************************//
/**
 * Clase que se encarga de gestionar los errores producidos durante el an�lisis
 * sint�ctico.
 * 
 * @author Javier Salcedo G�mez
 */
public class TErrorSintactico {

	// ATRIBUTOS
	private ErroresSintacticos _error;
	private String _mensaje;
	private int _linea;
	private int _columna;
	
//	***************************************************************************//
	/**
	 * Constructor de la clase TErrorSintactico.
	 * 
	 * @param error Tipo de error.
	 * @param mensaje Mensaje de error asociado.
	 * @param _linea Linea donde se ha producido el error.
	 * @param _columna Columna donde se ha producido el error.
	 */
	public TErrorSintactico(ErroresSintacticos error, String mensaje, int linea, int columna) {
		
		_error = error;
		_mensaje = mensaje;
		_linea = linea;
		_columna = columna;
	}

//	***************************************************************************//
	/**
	 * Devuelve el _tipo de error sint�ctico.
	 * 
	 * @return El _tipo de error sint�ctico.
	 */
	public ErroresSintacticos getError() {
		
		return _error;
	}

//	***************************************************************************//
	/**
	 * Establece el _tipo de error sint�ctico a valor error.
	 * 
	 * @param error El nuevo valor a establecer.
	 */
	public void setError(ErroresSintacticos error) {
		
		_error = error;
	}

//	***************************************************************************//
	/**
	 * Devuelve el mensaje de error asociado al error sint�ctico.
	 * 
	 * @return El mensaje de error asociado al error sint�tico.
	 */
	public String getMensaje() {
		
		return _mensaje;
	}

//	***************************************************************************//
	/**
	 * Establece el mensaje de error asociado a valor mensaje.
	 * 
	 * @param mensaje Nuevo valor a establecer.
	 */
	public void setMensaje(String mensaje) {
		
		_mensaje = mensaje;
	}
	
//	***************************************************************************//
	/**
	 * Devuelve el n�mero de la _columna donde el error se ha producido.
	 * 
	 * @return El n�mero de la _columna donde el error se ha producido.
	 */
	public int getColumna() {
	
		return _columna;
	}

//	***************************************************************************//
	/**
	 * Establece el n�mero de la _columna para el error.
	 * 
	 * @param _columna El n�mero de la _columna.
	 */
	public void setColumna(int columna) {
	
		_columna = columna;
	}
	
//	***************************************************************************//
	/**
	 * Devuelve el n�mero de l�nea donde se ha producido el error.
	 * 
	 * @return El n�mero de l�nea donde se ha producido el error.
	 */
	public int getFila() {
		
		return _linea;
	}
	
//	***************************************************************************//
	/**
	 * Establece el n�mero de la l�nea para el error.
	 * 
	 * @param _linea L�nea en la que se ha producido el error.
	 */
	public void setFila(int linea) {
		
		_linea = linea;
	}
	
//	***************************************************************************//
	/**
	 * Transforma la clase TErrorSintactico en un String para presentarlo por 
	 * pantalla.
	 * 
	 * @return String correspondiente a la clase TErrorSintactico.
	 */
	public String toString(){
		
		String error = new String();
		error += "L�nea: " + _linea;
		error += ", Columna: " + _columna + ":\n";
		error += _error.toString().replace("_", " ");
		error += " : ";
		error += _mensaje;
		error += " ";
		return error;
	}
}

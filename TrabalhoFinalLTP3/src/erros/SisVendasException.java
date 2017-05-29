/**
 * Classe para implementa��o da Tratativa de Erros
 */
package erros;

/**
 * @author MFAD
 * @version 1.0.0.0
 * @category Acad�mico
 */
@SuppressWarnings("serial")
public class SisVendasException extends Exception {

	public SisVendasException() {
		super();
	}

	/**
	 * @param message
	 */
	public SisVendasException(String message) {
		super(message);
	}
}

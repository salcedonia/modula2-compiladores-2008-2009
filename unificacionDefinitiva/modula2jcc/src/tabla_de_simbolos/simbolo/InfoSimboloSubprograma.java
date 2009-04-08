package tabla_de_simbolos.simbolo;

import java.util.ArrayList;

/**
 * Clase que gestiona la informacion relativa a un identificador de la TS que
 * representa un tipo SUBPROGRAMA.
 * 
 * @author Javier Salcedo Gómez
 */
public class InfoSimboloSubprograma extends InfoSimbolo{

    /**
     * Numero de argumentos para funciones y procedimientos
     */
    private int _numArgs;
    /**
     * Tipo semantico de los argumentos funciones y procedimientos
     */
    private ArrayList<ArrayList<String>> _tipoArgumentos;
    /**
     * Modo de paso de los argumentos en funciones y procedimientos.
     * POR REFERENCIA, POR VALOR.
     */
    private ArrayList<String> _pasoArgumentos;
    /**
     * Tipo de retorno del Subprograma. Si es VOID es PROCEDURE.
     */
    private ArrayList<String> _valorRetorno;
    
    /**
     * Constructor por defecto de la clase InfoSimboloSubprograma.
     */
    public InfoSimboloSubprograma() {

        _tipoArgumentos = new ArrayList<ArrayList<String>>(); 
        _pasoArgumentos = new ArrayList<String>();
        _valorRetorno = new ArrayList<String>();
        _numArgs = 0;
    }
        
    /**
     * Devuelve el tipo de valor de retorno del subprograma.
     * 
     * @return El tipo de valor de retorno del subprograma.
     */
    public ArrayList<String> getValorRetorno() {

        return _valorRetorno;
    }

    /**
     * Establece el valor de retorno del subprograma a valor <b>valorRetorno</b>.
     * 
     * @param valorRetorno Nuevo valor a establecer.
     */
    public void setValorRetorno(ArrayList<String> valorRetorno) {
       
        _valorRetorno = valorRetorno;
    }

    /**
     * Devuelve el numero de argumentos.
     * 
     * @return El numero de argumentos.
     */
    public int getNumArgs() {

        return _numArgs;
    }

    /**
     * Devuelve el paso de argumentos.
     * 
     * @return El paso de argumentos.
     */
    public ArrayList getPasoArgumentos() {

        return _pasoArgumentos;
    }

    /**
     * Devuelve los tipos de los argumentos.
     * 
     * @return Los tipos de los argumentos.
     */
    public ArrayList getTipoArgumentos() {

        return _tipoArgumentos;
    }

    /**
     * Establece el numero de argumentos a valor <b>numArgs</b>.
     * 
     * @param numArgs Nuevo valor a establecer.
     */
    public void setNumArgs(int numArgs) {

        _numArgs = numArgs;
    }

    /**
     * Establece el paso de argumentos a valor <b>pasoArgumentos</b>.
     * 
     * @param pasoArgumentos Nuevo valor a establecer.
     */
    public void setPasoArgumentos(ArrayList pasoArgumentos) {

        _pasoArgumentos = pasoArgumentos;
    }

    /**
     * Establece el tipo de los argumentos a valor <b>tipoArgumentos</b>.
     * 
     * @param tipoArgumentos Nuevo valor a establecer.
     */
    public void setTipoArgumentos(ArrayList tipoArgumentos) {

        _tipoArgumentos = tipoArgumentos;
    }
    
    /**
     * @see Object.toString().
     */
    @Override
    public String toString() {
        
        String cadena = super.toString();
        
        return cadena;
    }
}

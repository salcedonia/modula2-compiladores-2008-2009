package parser;

import semantico.PilaNodos;
import gestor_de_errores.GestorErrores;
import gestor_de_errores.TErrorSemantico;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import scanner.TipoToken;
import semantico.Nodo;
import semantico.TipoSemantico;
import tabla_de_simbolos.TablaDeSimbolos;
import tabla_de_simbolos.simbolo.*;
import generador.*;
/**
 * Clase que implementa las acciones semanticas.
 *
 * @author Macrogrupo 1
 */
public class SlkAction {

    /**
     * Gestor de errores del compilador.
     */
    private GestorErrores _gestorDeErrores;
    /**
     * Pila de Nodos para el tratamiento de las acciones semanticas.
     */
    private PilaNodos _pilaNodos;
    /**
     * Tabla activa en cada momento.
     */
    private TablaDeSimbolos _tablaActual;
    /**
     * Variable que sirve para identifcar la primera vez que se entre en la
     * regla de definicion de un modulo. Cuando valga true significará
     * que el modulo global ha sido renombrado.
     */
    private boolean _tablaGlobalNombrada = false;
    /** Objeto logger para mostrar trazas */
    private static final Logger logger = Logger.getLogger(SlkAction.class);
    /**
     * ultima accion semantica ejecutada
     */
    private String _ultimaAccion;

    private generador _generador;

    /**
     * Constructor de la clase SlkAction.
     *
     * @param tabla Tabla de simbolos del compilador.
     */
    public SlkAction(TablaDeSimbolos tablaActual, GestorErrores gestorDeErrores, PilaNodos pilaNodos) {

        _gestorDeErrores = gestorDeErrores;
        _pilaNodos = pilaNodos;
        _tablaActual = tablaActual;
        _generador = new generador(tablaActual);
    }

    /**
     * Metodo invocado por Slk consistente en la bifurcacion hacia el procedimiento
     * que trata la accion semantica correspondiente.
     *
     * @param number La accion semantica correspondiente.
     */
    public void execute(int number) {
        _ultimaAccion = SlkString.GetSymbolName((short) -number);

    switch ( number ) {
    case 1:  FinDeModulo();  break;
    case 2:  ComienzoDeModulo();  break;
    case 3:  ListaImportados();  break;
    case 4:  ListaExportados();  break;
    case 5:  finDeAmbito();  break;
    case 6:  DefinicionDeTipo();  break;
    case 7:  AsociacionConstante();  break;
    case 8:  EsquemaDeTipo_TipoFormacion();  break;
    case 9:  TipoSimple_TipoEnumerado();  break;
    case 10:  TipoEnumerado();  break;
    case 11:  TipoConjunto();  break;
    case 12:  TipoFormacion();  break;
    case 13:  TipoPuntero();  break;
    case 14:  ponerMarcaListaVariables();  break;
    case 15:  quitarMarcaListaVariables();  break;
    case 16:  DeclaracionVariables();  break;
    case 17:  InicioDeclaracionProcedure();  break;
    case 18:  CabeceraDeProcedure();  break;
    case 19:  retornoFunc();  break;
    case 20:  por_referencia();  break;
    case 21:  ParteEjecutiva();  break;
    case 22:  SecuenciaDeSentencias_Marca();  break;
    case 23:  SecuenciaDeSentencias2();  break;
    case 24:  SecuenciaDeSentencias();  break;
    case 25:  epsilonSentencia();  break;
    case 26:  SentenciaAsignacion();  break;
    case 27:  RestoSentenciaAsignacion();  break;
    case 28:  RestoSentenciaRestoAsignacion_1();  break;
    case 29:  RestoSentenciaRestoAsignacion_2();  break;
    case 30:  ParteIzquierda_1();  break;
    case 31:  ParteIzquierda_2();  break;
    case 32:  ParteIzquierda_3();  break;
    case 33:  IdentificadorOProcPredef_Ident();  break;
    case 34:  IdentificadorOProcPredef_ProcPredef();  break;
    case 35:  ExpresionIF();  break;
    case 36:  SentenciaIF();  break;
    case 37:  ExpresionELSIF();  break;
    case 38:  RestoSentenciaELSIF();  break;
    case 39:  RestoSentenciaELSE();  break;
    case 40:  RestoSentenciaIF();  break;
    case 41:  Caso();  break;
    case 42:  SentenciaCaseELSE();  break;
    case 43:  SentenciaCase();  break;
    case 44:  SentenciaCaso();  break;
    case 45:  ExpresionWHILE();  break;
    case 46:  SentenciaWHILE();  break;
    case 47:  ExpresionREPEAT();  break;
    case 48:  SentenciaREPEAT();  break;
    case 49:  SentenciaLOOP();  break;
    case 50:  IdentificadorFOR();  break;
    case 51:  ExpresionTO();  break;
    case 52:  ExpresionConstanteFOR();  break;
    case 53:  SentenciaFOR();  break;
    case 54:  SecuenciaWITH();  break;
    case 55:  ExpresionRETURN();  break;
    case 56:  Cadena();  break;
    case 57:  Caracter();  break;
    case 58:  expresionSinParentesisDeSuma();  break;
    case 59:  operadorUnario();  break;
    case 60:  expresionSinParentesisDeMultiplicacion();  break;
    case 61:  OperadorBooleano();  break;
    case 62:  TipoFormal();  break;
    case 63:  NumeroEntero();  break;
    case 64:  NumeroReal();  break;
    case 65:  TipoPredefinidoPorUsuario();  break;
    case 66:  BITSET();  break;
    case 67:  BOOLEAN();  break;
    case 68:  CARDINAL();  break;
    case 69:  CHAR();  break;
    case 70:  INTEGER();  break;
    case 71:  LONGINT();  break;
    case 72:  LONGREAL();  break;
    case 73:  PROC();  break;
    case 74:  REAL();  break;
    case 75:  TRUE();  break;
    case 76:  FALSE();  break;
    case 77:  NIL();  break;
  }
    }

    private void Caso() {
        //SentenciaCASE:
        //CASE Expresion OF Caso { | Caso _action_Caso } [ ELSE SecuenciaDeSentencias _action_SentenciaCaseELSE ] END _action_SentenciaCase

        Nodo nodo1 = _pilaNodos.pop(); // Caso
        Nodo nodo2 = _pilaNodos.pop(); // Caso

        if (nodo1.getTipoBasico() != TipoSemantico.ERROR && nodo2.getTipoBasico() != TipoSemantico.ERROR && nodo1.getTipoBasico() == nodo2.getTipoBasico()) {
            Nodo n = new Nodo();
            n.addTipo(nodo1.getTipoBasico());
            _pilaNodos.push(n);
        } else {
            Nodo n = new Nodo();
            n.addTipo(TipoSemantico.ERROR);
            _pilaNodos.push(n);
            _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia Caso mal tipada",
                    nodo1.getLinea(),
                    nodo1.getColumna()));
        }

    }

    /**
     * Abre un nuevo ambito y actualiza el nombre de la nueva tabla
     * correspondiente a dicho ambito. Se Comprueba que el nombre del
     * módulo no esta declarado en la tabla de símbolos.
     */
    private void ComienzoDeModulo() {

        Nodo id = _pilaNodos.pop();

        // Si la tabla GLOBAL ha sido nombrada
        if (_tablaGlobalNombrada) {

            boolean error = false;

            // Si el modulo no está declarado
            if (!_tablaActual.estaModuloDeclarado(id.getLexema())) {

                // Insertamos el identificador del modulo en la tabla de simbolos actuales
                if (_tablaActual.declaraSimbolo(id.getLexema())) {

                    // Completamos el tipo semantico del identificador
                    if (_tablaActual.completaModulo(id.getLexema())) {

                        // Se abre un ambito
                        _tablaActual = _tablaActual.abrirAmbito();
                        _tablaActual.setNombre(id.getLexema());
                    } else {
                        error = true;
                    }
                } else {
                    error = true;
                }
            } else {
                error = true;
            }
            if (error) {
                _gestorDeErrores.insertaErrorSemantico(
                        new TErrorSemantico("El simbolo \"" + id.getLexema() + "\" ya esta definido.",
                        id.getLinea(),
                        id.getColumna()));

            } else { // NO SE INSERTA EL IDENTIFICADOR EN LA TS GLOBAL!!

                // Completamos el nombre de la tabla GLOBAL
                _tablaActual.setNombre(id.getLexema());

                // Marcamos que ya esta nombrada por lo que ya siempre entrará
                // por el IF de arriba y creará los ambitos de los módulos
                // correspondientes.
                _tablaGlobalNombrada = true;
            }
        }
        _tablaActual.setNombre(id.getLexema());
        _tablaGlobalNombrada = true;


        //nombrePrograma = ((Atributos) (n).getToken().getAtributo()).obtener("LEXEMA").toString();
		_generador.emite("begin:");
		_generador.emite("CALL /" + "hola");
		_generador.emite("HALT");
		_generador.escribeSeccion();
    }

    private void ExpresionRETURN() {
        //SentenciaRETURN:
        //RETURN [ Expresion _action_ExpresionRETURN ] _action_SentenciaRETURN

        //NO dejo la expresion que se devuelve en la pila para comprobar
        //tipos con lo que devuelve una funcion.
        Nodo nodo1 = _pilaNodos.pop(); //Expresion
        Nodo nuevo = new Nodo();
        boolean errIdent = false;

        if (nodo1.getTipoToken() == TipoToken.IDENTIFICADOR) {
            // buscamos el tipo del identificador en la tabla
            if (_tablaActual.busca(nodo1.getLexema()) != null) {
                ArrayList<TipoSemantico> tipo = _tablaActual.busca(nodo1.getLexema()).getTipoSemantico();
                nodo1.setTipo(tipo);
            } else {
                errIdent = true;
                //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo1.getLexema() + "' no estÃ¡ en la TS",
                        nodo1.getLinea(),
                        nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }

        if (!errIdent) {
            if (nodo1.getTipoBasico() != TipoSemantico.ERROR) {
                // Todo ha ido bien
                // NO se mete ningun nodo en la pila para comprobar
                // que la expresion es igual al tipo devuelto por la funcion
                //_pilaNodos.push(nodo1);
                //se necesita un nodo VOID para la confirmacion de que está bien en SecuenciaDeSentencias
                Nodo n = new Nodo();
                n.addTipo(TipoSemantico.VOID);
                _pilaNodos.push(n);
            } else {
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia SentenciaRETURN mal tipada",
                        nodo1.getLinea(),
                        nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }

    }

    private void ListaExportados() {
        System.out.println("ListaExportados");
        Nodo nodoNuevo = new Nodo();
        //Cuando hay un module debo comprobar si hay un ambito superior
        //Si hay un ambito superior significa que es un modulo dentro de otro y debo copiar
        //al ambito superior las entradas de la TS (InfoSimbolo) de los identificadores que tengan
        //el modificador EXPORT
        if (_tablaActual.getContinente() == null) {
            //Estoy en el ambito mas superior( Si las import se consideran de ambitos inferiores )
            System.out.println("Nombre de la TS <" + _tablaActual.getNombre() + ">");
        //Luego esta es la que exporta la funcion y por tanto ya la tiene en la TS, es decir,
        //ya puede usar la funcion exportada
        } else {
            //Estoy en un ambito inferior, es decir, tiene superior
            System.out.println("Nombre de la TS inf <" + _tablaActual.getNombre() + ">");
            while (_pilaNodos.empty() == false) {
                Nodo nodoExportado = _pilaNodos.pop();
                InfoSimbolo infoNodoExportado = _tablaActual.busca(nodoExportado.getLexema());
                if (infoNodoExportado != null) { //Si lo encuentra
                    TablaDeSimbolos tablaSuperior = _tablaActual.getContinente();
                    System.out.println("Tabla sup <" + tablaSuperior.getNombre() + "> de la TS inf <" + _tablaActual.getNombre() + ">");
                    tablaSuperior.getTS().put(nodoExportado.getLexema(), infoNodoExportado); //no me mola asi
                    nodoNuevo.addTipo(TipoSemantico.VOID);
                } else {
                    //Sino lo encuentra habr� que informar del error de que no existe lo que se exporta, no?
                    nodoNuevo.addTipo(TipoSemantico.ERROR);

                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("No existe el identificador exportado",
                            nodoExportado.getLinea(),
                            nodoExportado.getColumna()));
                }
            }
            _pilaNodos.add(nodoNuevo);
        }
    }

    private void ListaImportados() {
        System.out.println("ListaImportados");
        //Se supone que tengo que abrir un fichero .MOD

        //Cuento los elementos en la pila (size()) y saco los size()-1 dejando
        //El ultimo nodo en la pila es el nombre del .MOD que debo abrir

        //Debo procesar el fichero MOD... esto es mu gordo, un nuevo compila-Archivo dentro de otro

        //Le abro y copio de la TS el InfoSimbolo de cada uno de los ids, menos del del nombre del modulo

        //Primera aproximacion que crea en la TS los identificadores que hay en el IMPORT, pero sin informaci�n referente a ellos
        //Por lo que puede que se importen cosas que no existen y que lo que se importe no se sepa que es
        Nodo nodoDesapilado;
        InfoSimbolo infoNodoImportado;
        int cantidadDesapilar = _pilaNodos.size();
        for (int i = 0; i < cantidadDesapilar - 1; i++) {
            nodoDesapilado = _pilaNodos.pop();
            infoNodoImportado = new InfoSimboloVar(new ArrayList<TipoSemantico>()); //Como no se de que tipo es el simbolo importado, simplemente le paso un nulo de info, no se si dara problem
            _tablaActual.getTS().put(nodoDesapilado.getLexema(), infoNodoImportado);
        }
        //Saco el id correspondiente al nombre del MOD
        nodoDesapilado = _pilaNodos.pop();

    //Sino existen en el MOD debo llamar/avisar al gestor de errores

    //Nodo nodoNuevo = new Nodo(); No hay tipo aqui, no?
    //nodoNuevo.addTipo( TipoSemantico.VOID );
    //_pilaNodos.add( nodoNuevo );

    //IDEA: importaciones predefinidas, se puede crear una TS para los MOD de funciones por defecto
    //Supongo que se podrá hacer algo parecido para el codigo ensamblador
    }

    private void EsquemaDeTipo_TipoFormacion() {
        System.out.println("EsquemaDeTipo_TipoFormacion");
    }

    private void SecuenciaDeSentencias_Marca() {
        //SecuenciaDeSentencias:
        //Sentencia _action_SecuenciaDeSentencias_Marca { ; Sentencia _action_SecuenciaDeSentencias2 } _action_SecuenciaDeSentencias

        //añade una marca para saber dnd esta la primera sentencia
        Nodo nodoMarca = new Nodo();
        nodoMarca.crearMarca();
        _pilaNodos.push(nodoMarca);
    }

    private void SecuenciaWITH() {
        //SentenciaWITH:
        //WITH Identificador ParteIzquierda DO SecuenciaDeSentencias END  _action_SecuenciaWITH

        Nodo nodo1 = _pilaNodos.pop(); // SecuenciaDeSentencias
        Nodo nodo2 = _pilaNodos.pop(); // ParteIzquierda
        Nodo nodo3 = _pilaNodos.pop(); // Identificador
        try {
            //Miramos si el identificador esta en la tabla o no
            TipoSemantico tipo = _tablaActual.busca(nodo3.getLexema()).getTipoBasico();

            if (nodo1.getTipoBasico() == TipoSemantico.VOID && nodo2.getTipoBasico() == TipoSemantico.VOID) {
                Nodo n = new Nodo();
                n.addTipo(TipoSemantico.VOID);
                _pilaNodos.add(n);
            } else {
                Nodo n = new Nodo();
                n.addTipo(TipoSemantico.ERROR);
                _pilaNodos.add(n);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia SentenciaWITH mal tipada",
                        nodo1.getLinea(),
                        nodo1.getColumna()));
            }
        } catch (Exception e) {
            Nodo n = new Nodo();
            n.addTipo(TipoSemantico.ERROR);
            _pilaNodos.add(n);
            _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Identificador SentenciaWITH mal",
                    nodo1.getLinea(),
                    nodo1.getColumna()));
        }

    }

    private void SentenciaCase() {
        //SentenciaCASE:
        //CASE Expresion OF Caso { | Caso _action_Caso } [ ELSE SecuenciaDeSentencias _action_SentenciaCaseELSE ] END _action_SentenciaCase

        Nodo nodo1 = _pilaNodos.pop(); //Marca o SecuenciaDeSentencias o Caso
        Nodo nodo2 = new Nodo();
        Nodo nodo3 = new Nodo();
        if (nodo1.esMarca()) {
            nodo1 = _pilaNodos.pop(); // SecuenciaDeSentencias
            nodo2 = _pilaNodos.pop(); // Caso
            nodo3 = _pilaNodos.pop(); // Expresion
            boolean errIdent = false;
            Nodo nuevo = new Nodo();

            if (nodo3.getTipoToken() == TipoToken.IDENTIFICADOR) {
                // buscamos el tipo del identificador en la tabla
                if (_tablaActual.busca(nodo3.getLexema()) != null) {
                    ArrayList<TipoSemantico> tipo = _tablaActual.busca(nodo3.getLexema()).getTipoSemantico();
                    nodo3.setTipo(tipo);
                } else {
                    errIdent = true;
                    //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                    nuevo.addTipo(TipoSemantico.ERROR);
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo3.getLexema() + "' no estÃ¡ en la TS",
                            nodo3.getLinea(),
                            nodo3.getColumna()));
                    nuevo.setColumna(nodo3.getColumna());
                    nuevo.setLinea(nodo3.getLinea());
                    _pilaNodos.push(nuevo);
                }
            }

            if (!errIdent) {
                if (nodo1.getTipoBasico() == TipoSemantico.VOID && nodo2.getTipoBasico() == nodo3.getTipoBasico()) {
                    Nodo n = new Nodo();
                    n.addTipo(TipoSemantico.VOID);
                    _pilaNodos.push(n);
                } else {
                    nuevo.addTipo(TipoSemantico.ERROR);
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia SentenciaCase mal tipada",
                            nodo1.getLinea(),
                            nodo1.getColumna()));
                    nuevo.setColumna(nodo1.getColumna());
                    nuevo.setLinea(nodo1.getLinea());
                    _pilaNodos.push(nuevo);
                }
            }
        } else {//No hay ELSE SecuenciaDeSentencias
            nodo3 = _pilaNodos.pop(); // Expresion
            boolean errIdent = false;
            Nodo nuevo = new Nodo();

            if (nodo3.getTipoToken() == TipoToken.IDENTIFICADOR) {
                // buscamos el tipo del identificador en la tabla
                if (_tablaActual.busca(nodo3.getLexema()) != null) {
                    ArrayList<TipoSemantico> tipo = _tablaActual.busca(nodo3.getLexema()).getTipoSemantico();
                    nodo3.setTipo(tipo);
                } else {
                    errIdent = true;
                    //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                    nuevo.addTipo(TipoSemantico.ERROR);
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo3.getLexema() + "' no estÃ¡ en la TS",
                            nodo3.getLinea(),
                            nodo3.getColumna()));
                    nuevo.setColumna(nodo3.getColumna());
                    nuevo.setLinea(nodo3.getLinea());
                    _pilaNodos.push(nuevo);
                }
            }

            if (!errIdent) {
                if (nodo1.getTipoBasico() == nodo3.getTipoBasico()) {
                    Nodo n = new Nodo();
                    n.addTipo(TipoSemantico.VOID);
                    _pilaNodos.push(n);
                } else {
                    nuevo.addTipo(TipoSemantico.ERROR);
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia SentenciaCase mal tipada",
                            nodo1.getLinea(),
                            nodo1.getColumna()));
                    nuevo.setColumna(nodo1.getColumna());
                    nuevo.setLinea(nodo1.getLinea());
                    _pilaNodos.push(nuevo);
                }
            }

        }

    }

    private void SentenciaCaseELSE() {
        //SentenciaCASE:
        //CASE Expresion OF Caso { | Caso _action_Caso } [ ELSE SecuenciaDeSentencias _action_SentenciaCaseELSE ] END _action_SentenciaCase

        /***pruebas***/
        Nodo SecuenciaDeSentencias = new Nodo();
        SecuenciaDeSentencias.addTipo(TipoSemantico.VOID);
        _pilaNodos.pop();
        _pilaNodos.push(SecuenciaDeSentencias);
        /***pruebas***/
        Nodo nodo1 = _pilaNodos.pop(); // SecuenciaDeSentencias

        if (nodo1.getTipoBasico() == TipoSemantico.VOID) {
            Nodo n = new Nodo();
            n.addTipo(nodo1.getTipoBasico());
            _pilaNodos.push(n);
        } else {
            Nodo n = new Nodo();
            n.addTipo(TipoSemantico.ERROR);
            _pilaNodos.push(n);
            _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia SentenciaCaseELSE mal tipada",
                    nodo1.getLinea(),
                    nodo1.getColumna()));
        }

        //insertamos el nodo marca en la pila
        Nodo nodoMarca = new Nodo();
        nodoMarca.crearMarca();
        _pilaNodos.push(nodoMarca);

    }

    private void SentenciaCaso() {
        //Caso:
        //ListaDeValores : SecuenciaDeSentencias _action_SentenciaCaso

        /***pruebas***/
        Nodo SecuenciaDeSentencias = new Nodo();
        SecuenciaDeSentencias.addTipo(TipoSemantico.VOID);
        _pilaNodos.pop();
        _pilaNodos.push(SecuenciaDeSentencias);
        /***pruebas***/
        boolean errIdent = false;
        Nodo nuevo = new Nodo();


        Nodo nodo1 = _pilaNodos.pop(); // SecuenciaDeSentencias
        Nodo nodo2 = _pilaNodos.pop();// ListaDeValores

        if (nodo2.getTipoToken() == TipoToken.IDENTIFICADOR) {
            // buscamos el tipo del identificador en la tabla
            if (_tablaActual.busca(nodo2.getLexema()) != null) {
                ArrayList<TipoSemantico> tipo = _tablaActual.busca(nodo2.getLexema()).getTipoSemantico();
                nodo2.setTipo(tipo);
            } else {
                errIdent = true;
                //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo2.getLexema() + "' no estÃ¡ en la TS",
                        nodo2.getLinea(),
                        nodo2.getColumna()));
                nuevo.setColumna(nodo2.getColumna());
                nuevo.setLinea(nodo2.getLinea());
                _pilaNodos.push(nuevo);
            }
        }

        if (!errIdent) {
            if (nodo2.getTipoBasico() != TipoSemantico.ERROR && nodo1.getTipoBasico() == TipoSemantico.VOID) {
                Nodo n = new Nodo();
                n.addTipo(nodo2.getTipoBasico());
                _pilaNodos.push(n);
            } else {
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia SentenciaCaso mal tipada",
                        nodo1.getLinea(),
                        nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }

    }

    private void TipoEnumerado() {
        System.out.println("TipoEnumerado");
        Nodo nodoDesapilado;
        boolean error = false;
        while (_pilaNodos.size() > 2) { //Igual mejor preguntar por la marca (2=marca+id)
            nodoDesapilado = _pilaNodos.pop();
            InfoSimbolo infoNodoDesapilado = _tablaActual.busca(nodoDesapilado.getLexema());
            if (infoNodoDesapilado != null)//Si ya esta es un error, ya que ha sido utilizado el id antes
            {
                error = true;
            } else {
                //lo meto en la ts como nuevo simbolo de tipo enumerado
                ArrayList<TipoSemantico> tipoSemanticoNodoDesapilado = new ArrayList<TipoSemantico>();
                tipoSemanticoNodoDesapilado.add(TipoSemantico.ENUMERADO);
                infoNodoDesapilado = new InfoSimboloVar(tipoSemanticoNodoDesapilado);
                //infoNodoDesapilado.getTipoSemantico().add( TipoSemantico.ENUMERADO );
                //Lo que no se es como se distinguen estos elementos del identifacor del enumerado
                _tablaActual.getTS().put(nodoDesapilado.getLexema(), infoNodoDesapilado);
            }
        }
        Nodo nuevoNodo = new Nodo();
        if (error == false)//Solo meto si todo fue correcto, con un id mal ya error
        {
            nuevoNodo.addTipo(TipoSemantico.ENUMERADO);
        } else {
            nuevoNodo.addTipo(TipoSemantico.ERROR);
        }

        _pilaNodos.push(nuevoNodo);
    }

    public void completaSiEsIdentificador(Nodo nodo) {
        if (nodo.getTipoToken().equals(TipoToken.IDENTIFICADOR) == true) {
            InfoSimbolo infoDimInicial = _tablaActual.busca(nodo.getLexema());
            nodo.addTipo(infoDimInicial.getTipoBasico());
        }
    }

    private void TipoFormacion() {
        System.out.println("TipoFormacion");

        ArrayList<Nodo> listaNodos = new ArrayList<Nodo>();

        Nodo nodoNuevo;
        while (_pilaNodos.size() > 3) { //Para cuando hay listas de arrays... marca+id+tipo , no mola
            //Desapilo el tipo del array
            Nodo nodoTipoArray = _pilaNodos.pop();

            if (_pilaNodos.peek().getTipoBasico().equals(TipoSemantico.ENUMERADO) != true) {
                //Desapilo la dimension final del rango
                Nodo nodoDimensionFinal = _pilaNodos.pop();
                completaSiEsIdentificador(nodoDimensionFinal);

                //Desapilo la dimension inicial del rango
                Nodo nodoDimensionInicial = _pilaNodos.pop();
                //Si es un id, saco de la TS su tipoSem
                completaSiEsIdentificador(nodoDimensionInicial);

                //Desapilo la marca
                //Nodo nodoMarca = _pilaNodos.pop();

                //Supuestamente las comprobaciones de si hay espacio en el rango se hacen en codigo intermedio

                //getTipoSemanticoInicial getTipoSemanticoFinal -comprobarCompatibilidad, comparaTipos, ...
                //Sino son compatibles, debo generar un nodo error y meterlo en pila
                //Cuando meto el nodo error, despues de meter el que? o antes de que?
                if (nodoDimensionInicial.getTipoBasico().equals(nodoDimensionFinal.getTipoBasico()) == true) {
                    nodoNuevo = new Nodo();
                    nodoNuevo.addTipo(TipoSemantico.ARRAY);
                    //nodoNuevo.addTipo( nodoTipoArray.getTipoBasico() ); //indica el tipo de datos del array
                    for (int i = 0; i < nodoTipoArray.getTipoSemantico().size(); i++) { //Mejor un add sobrecargado, no?
                        nodoNuevo.addTipo(nodoTipoArray.getTipoSemantico().get(i));
                    }
                //_pilaNodos.push(nodoNuevo);
                } else {
                    nodoNuevo = new Nodo();
                    nodoNuevo.addTipo(TipoSemantico.ERROR);
                    //_pilaNodos.push( nodoNuevo );
                    //Mismamente pillo los valores del nodoInicial, aunque el de verdad icompatible podr�a ser el otro(columna)
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Valores de las dimensiones incompatibles",
                            nodoDimensionInicial.getLinea(),
                            nodoDimensionInicial.getColumna()));
                }
                _pilaNodos.push(nodoNuevo);
            } else {
                Nodo nodoEnumerado = _pilaNodos.pop();
                nodoNuevo = new Nodo();
                nodoNuevo.addTipo(TipoSemantico.ARRAY);
                for (int i = 0; i < nodoTipoArray.getTipoSemantico().size(); i++) { //Mejor un add sobrecargado, no?
                    nodoNuevo.addTipo(nodoTipoArray.getTipoSemantico().get(i));
                }
                _pilaNodos.push(nodoNuevo);
            }
        //Apilo los el nodos generados
        }

    }

    private void TipoFormal() {
        System.out.println("TipoFormal");
    }

    private void TipoSimple_TipoEnumerado() {
        System.out.println("TipoSimple_TipoEnumerado");
    }

    private void ExpresionConstanteFOR() {
        //SentenciaFOR:
        //FOR Identificador := Expresion _action_IdentificadorFOR TO Expresion _action_ExpresionTO [ BY ExpresionConstante _action_ExpresionConstanteFOR ] DO SecuenciaDeSentencias END _action_SentenciaFOR

        Nodo nodo1 = _pilaNodos.pop(); //ExpresionConstante

        //no comprobamos que ExpresionConstante está  bien porque ya se hace en SentenciaFOR
        //solo añadimos un nodo Marca a la pila

        _pilaNodos.push(nodo1);

        Nodo nodoMarca = new Nodo();
        nodoMarca.crearMarca();
        _pilaNodos.push(nodoMarca);
    }

    private void ExpresionELSIF() {
        //RestoSentenciaIF:
        //{ ELSIF Expresion _action_ExpresionELSIF THEN SecuenciaDeSentencias _action_RestoSentenciaELSIF } [ ELSE SecuenciaDeSentencias _action_RestoSentenciaELSE ]

        /*para hacer pruebas*
        System.out.println("ExpresionELSIF");
        Nodo expresion = new Nodo();
        expresion.addTipo(TipoSemantico.BOOLEANO);
        _pilaNodos.push(expresion);
        /*para hacer pruebas*/

        Nodo nodo1 = _pilaNodos.pop(); //Expresion
        Nodo nuevo = new Nodo();
        boolean errIdent = false;

        if (nodo1.getTipoToken()==TipoToken.IDENTIFICADOR){
            // buscamos el tipo del identificador en la tabla
            if (_tablaActual.busca(nodo1.getLexema())!= null){
                ArrayList<TipoSemantico> tipo = _tablaActual.busca(nodo1.getLexema()).getTipoSemantico();
                nodo1.setTipo(tipo);
            } else {
                errIdent = true;
                //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo1.getLexema() + "' no está declarado",
                    nodo1.getLinea(),
                    nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }
            
        if (!errIdent){
            if (nodo1.getTipoBasico().equals(TipoSemantico.BOOLEANO)) {
                nuevo.addTipo(TipoSemantico.VOID);
                _pilaNodos.push(nuevo);
            } else {
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipo no booleano en la expresion ELSIF",
                        nodo1.getLinea(),
                        nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }

    }

    private void ExpresionIF() {
        //SentenciaIF:
        //IF Expresion _action_ExpresionIF THEN SecuenciaDeSentencias RestoSentenciaIF END _action_SentenciaIF

        /*para hacer pruebas*
        System.out.println("ExpresionIF");
        Nodo expresion = new Nodo();
        expresion.addTipo(TipoSemantico.BOOLEANO);
        _pilaNodos.push(expresion);
        /*para hacer pruebas*/

        Nodo nodo1 = _pilaNodos.pop();
        Nodo nuevo = new Nodo();
        boolean errIdent = false;

        if (nodo1.getTipoToken()==TipoToken.IDENTIFICADOR){
            // buscamos el tipo del identificador en la tabla
            if (_tablaActual.busca(nodo1.getLexema())!= null){
                ArrayList<TipoSemantico> tipo = _tablaActual.busca(nodo1.getLexema()).getTipoSemantico();
                nodo1.setTipo(tipo);
            } else {
                errIdent = true;
                //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo1.getLexema() + "' no está declarado",
                    nodo1.getLinea(),
                    nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }

        if (!errIdent){
            if (nodo1.getTipoBasico().equals(TipoSemantico.BOOLEANO)) {
                nuevo.addTipo(TipoSemantico.VOID);
                _pilaNodos.push(nuevo);
            } else {
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipo no booleano en la expresion if",
                    nodo1.getLinea(),
                    nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }

    }

    private void ExpresionREPEAT() {
        //SentenciaREPEAT:
        //REPEAT SecuenciaDeSentencias UNTIL Expresion _action_ExpresionREPEAT _action_SentenciaREPEAT

        /*para hacer pruebas*
        Nodo SecuenciaDeSentencias = new Nodo();
        SecuenciaDeSentencias.addTipo(TipoSemantico.VOID);
        System.out.println("ExpresionREPEAT");
        Nodo expresion = new Nodo();
        expresion.addTipo(TipoSemantico.BOOLEANO);
        _pilaNodos.push(SecuenciaDeSentencias);
        _pilaNodos.push(expresion);
        /*para hacer pruebas*/

        Nodo nodo1 = _pilaNodos.pop(); //Expresion
        Nodo nuevo = new Nodo();
        boolean errIdent = false;

        if (nodo1.getTipoToken()==TipoToken.IDENTIFICADOR){
            // buscamos el tipo del identificador en la tabla
            if (_tablaActual.busca(nodo1.getLexema())!= null){
                ArrayList<TipoSemantico> tipo = _tablaActual.busca(nodo1.getLexema()).getTipoSemantico();
                nodo1.setTipo(tipo);
            } else {
                errIdent = true;
                //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo1.getLexema() + "' no está declarado",
                    nodo1.getLinea(),
                    nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }

        if (!errIdent){

            if (nodo1.getTipoBasico().equals(TipoSemantico.BOOLEANO)) {
                nuevo.addTipo(TipoSemantico.VOID);
                _pilaNodos.push(nuevo);
            } else {
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipo no booleano en la expresion REPEAT",
                        nodo1.getLinea(),
                        nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }

    }

    private void ExpresionTO() {
        //SentenciaFOR:
        //FOR Identificador := Expresion _action_IdentificadorFOR TO Expresion _action_ExpresionTO [ BY ExpresionConstante _action_ExpresionConstanteFOR ] DO SecuenciaDeSentencias END _action_SentenciaFOR

        Nodo nodo1 = _pilaNodos.pop(); //sacamos expresion
        Nodo nodo3 = _pilaNodos.pop(); // sacamos la expresion de la asignacion para comprobar tipos
        // y ver que nodo1 sea mayor que nodo3???
        Nodo nuevo = new Nodo();
        boolean errIdent = false;

        //si Expresion es un identificador hay que guardar su tipo semántico
        if (nodo1.getTipoToken()==TipoToken.IDENTIFICADOR){
            // buscamos el tipo del identificador en la tabla
            if (_tablaActual.busca(nodo1.getLexema())!= null){
                ArrayList<TipoSemantico> tipo = _tablaActual.busca(nodo1.getLexema()).getTipoSemantico();
                nodo1.setTipo(tipo);
            } else {
                errIdent = true;
                //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo1.getLexema() + "' no está declarado",
                    nodo1.getLinea(),
                    nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }

        if (!errIdent){

            if ((nodo1.getTipoBasico().equals(nodo3.getTipoBasico())) /*&& (nodo1.getLexema().compareTo(nodo3.getLexema()) > 0)*/) {
                _pilaNodos.push(nodo1);
            } else {
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia ExpresionTO mal tipada",
                        nodo1.getLinea(),
                        nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }
    }

    private void ExpresionWHILE() {
        //SentenciaWHILE:
        //WHILE Expresion _action_ExpresionWHILE DO SecuenciaDeSentencias END _action_SentenciaWHILE

        /*para hacer pruebas*
        System.out.println("ExpresionWHILE");
        Nodo expresion = new Nodo();
        expresion.addTipo(TipoSemantico.BOOLEANO);
        _pilaNodos.push(expresion);
        /*para hacer pruebas*/

        Nodo nodo1 = _pilaNodos.pop(); //Expresion
        Nodo nuevo = new Nodo();

                boolean errIdent = false;

        if (nodo1.getTipoToken()==TipoToken.IDENTIFICADOR){
            // buscamos el tipo del identificador en la tabla
            if (_tablaActual.busca(nodo1.getLexema())!= null){
                ArrayList<TipoSemantico> tipo = _tablaActual.busca(nodo1.getLexema()).getTipoSemantico();
                nodo1.setTipo(tipo);
            } else {
                errIdent = true;
                //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo1.getLexema() + "' no está declarado",
                    nodo1.getLinea(),
                    nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }

        if (!errIdent){

            if (nodo1.getTipoBasico().equals(TipoSemantico.BOOLEANO)) {
                nuevo.addTipo(TipoSemantico.VOID);
                _pilaNodos.push(nuevo);
            } else {
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipo no booleano en la expresion WHILE",
                        nodo1.getLinea(),
                        nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }
    }

    /**
     * Comprueba que el nombre de la tabla y el del identificador despues del
     * END sean el mismo. Ademas cierra el ambito actual.
     */
    private void FinDeModulo() {
        //esto ya lo ha hecho finDeAmbito; no preguntes por que
//
//        Nodo id = _pilaNodos.pop();
//
//        if (_tablaActual.getNombre().equals(id.getLexema())) {
//            _tablaActual = _tablaActual.cerrarAmbito();
//        } else {
//
//            _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Simbolo \"" + id.getLexema() + "\" incorrecto, se esperaba \"" + _tablaActual.getNombre() + "\"",
//                    id.getLinea(),
//                    id.getColumna()));
//        }
    
        
        _generador.generaCodigoSubprograma("hola", false);
    }

    private void IdentificadorFOR() {
        //SentenciaFOR:
        //FOR Identificador := Expresion _action_IdentificadorFOR TO Expresion _action_ExpresionTO [ BY ExpresionConstante _action_ExpresionConstanteFOR ] DO SecuenciaDeSentencias END _action_SentenciaFOR

        Nodo nodo1 = _pilaNodos.pop();//saca expresion
        _pilaNodos.pop(); //saca :=
        Nodo nodo2 = _pilaNodos.pop(); // saca identificador
        Nodo nuevo = new Nodo();

        //hay que buscar si el identificador está o no en la TS
        if (_tablaActual.busca(nodo2.getLexema())!= null){
            // buscamos el tipo del identificador en la tabla
            ArrayList <TipoSemantico> tipo = _tablaActual.busca(nodo2.getLexema()).getTipoSemantico();

            // miramos si la expresion es del mismo tipo del identificador para asignarselo
            if (tipo.equals(nodo1.getTipoSemantico())) {
                _pilaNodos.push(nodo1);
            } else {
                nuevo.addTipo(TipoSemantico.ERROR);
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.add(nuevo);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia IdentificadorFOR mal tipada",
                        nodo1.getLinea(),
                        nodo1.getColumna()));
            }

        } else {
            //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
            nuevo.addTipo(TipoSemantico.ERROR);
            _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo2.getLexema() + "' no está declarado",
                    nodo2.getLinea(),
                    nodo2.getColumna()));
                nuevo.setColumna(nodo2.getColumna());
                nuevo.setLinea(nodo2.getLinea());
                _pilaNodos.push(nuevo);
        }

    }

    private void IdentificadorOProcPredef_Ident() {
        //IdentificadorOProcPredef:
        //Identificador _action_IdentificadorOProcPredef_Ident

        Nodo nodo2 = _pilaNodos.peek();
        Nodo nodo1 = _pilaNodos.pop(); //Identificador
        if (nodo2.getTipoToken() == TipoToken.OPERADOR_ASIGNACION) {
            nodo1 = _pilaNodos.pop(); //Identificador
        }
        Nodo nuevo = new Nodo();

        if (nodo1.getTipoToken()!=null) {
            if (nodo1.getTipoToken() == TipoToken.IDENTIFICADOR) {
                //comprobamos ahora que el identificador esta en la tabla de simbolos
                if (_tablaActual.busca(nodo1.getLexema())!= null){
                    nuevo.addTipo(TipoSemantico.VOID);
                    _pilaNodos.push(nuevo);
                }else {
                    //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                    nuevo.addTipo(TipoSemantico.ERROR);
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo1.getLexema() + "' no está declarado",
                        nodo1.getLinea(),
                        nodo1.getColumna()));
                    nuevo.setColumna(nodo1.getColumna());
                    nuevo.setLinea(nodo1.getLinea());
                    _pilaNodos.push(nuevo);
                }
            } else {
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Identificador NO Válido",
                        nodo1.getLinea(),
                        nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
            //se vuelve a meter en operador de asignacion que se habia quitado antes
            if (nodo2.getTipoToken() == TipoToken.OPERADOR_ASIGNACION) {
                _pilaNodos.push(nodo2);
            }
        } else {
            nuevo.addTipo(TipoSemantico.ERROR);
            _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Identificador NO Válido",
                    nodo1.getLinea(),
                    nodo1.getColumna()));
            nuevo.setColumna(nodo1.getColumna());
            nuevo.setLinea(nodo1.getLinea());
            _pilaNodos.push(nuevo);
        }
    }

    private void IdentificadorOProcPredef_ProcPredef() {
        //IdentificadorOProcPredef:
        //LlamadaProcedimientoPredefinido _action_IdentificadorOProcPredef_ProcPredef

        Nodo nodo1 = _pilaNodos.pop(); //LlamadaProcedimientoPredefinido
        Nodo nuevo = new Nodo();

        if (nodo1.getTipoBasico().equals(TipoSemantico.VOID)) {
            nuevo.addTipo(TipoSemantico.VOID);
            _pilaNodos.push(nuevo);
        } else {
            nuevo.addTipo(TipoSemantico.ERROR);
            /*_gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Llamada a Procedimiento Predefinido NO Válida",
            nodo1.getLinea(),
            nodo1.getColumna()));*/
            nuevo.setColumna(nodo1.getColumna());
            nuevo.setLinea(nodo1.getLinea());
            _pilaNodos.push(nuevo);
        }

    }

    private void OperadorBooleano() {
        if (logger.isDebugEnabled()) {
            logger.debug("Entrando en el metodo operadorBooleano");
        }
        Nodo op1 = _pilaNodos.pop();
        Nodo operador = _pilaNodos.pop();
        Nodo op2 = _pilaNodos.pop();
        if (!op1.esError() && !operador.esError() && !op2.esError()) {
            if (sonOperablesLogicamente(op1, op2)) {
                Nodo salida = new Nodo();
                ArrayList<TipoSemantico> tipo = new ArrayList();
                tipo.add(TipoSemantico.BOOLEANO);
                salida.setTipo(tipo);
                _pilaNodos.push(salida);
                if (logger.isDebugEnabled()) {
                    logger.debug("Salida con exito del metodo OperadorBooleano");
                }
            } else {
                                                         
                Nodo error = new Nodo();
                error.addTipo(TipoSemantico.ERROR);

                if (logger.isDebugEnabled()) {
                    logger.debug("Salida con error del metodo OperadorBooleano");
                }

            }
        }


    }

    private void ParteEjecutiva() {
        //ParteEjecutiva:
        //[ BEGIN SecuenciaDeSentencias _action_ParteEjecutiva ]

        System.out.println("ParteEjecutiva");

        Nodo nodo1 = _pilaNodos.pop(); //SecuenciaDeSentencias

        if (nodo1.getTipoBasico().equals(TipoSemantico.ERROR)) {
            Nodo nuevo = new Nodo();
            nuevo.addTipo(TipoSemantico.ERROR);
            nuevo.setColumna(nodo1.getColumna());
            nuevo.setLinea(nodo1.getLinea());
        /*_gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Llamada a Parte Ejecutiva NO Válida",
        nodo1.getLinea(),
        nodo1.getColumna()));*/
        //_pilaNodos.push(nuevo); //????????? no se mete en la pila??
        }

    }

    private void ParteIzquierda_1() {
        //ParteIzquierda:
        //_epsilon_
        //\[ ListaDeExpresiones \] ParteIzquierda _action_ParteIzquierda_1
        //. IdentificadorOProcPredef ParteIzquierda _action_ParteIzquierda_2
        //^ ParteIzquierda _action_ParteIzquierda_3

        //supongo que los [ y los ] no se meten en la pila
        //ListaExpresiones: espero en la pila que haya un único nodo con el tipo de todas las expresiones
        //que debería ser el mismo, para poder comprobarlo con identificador
        throw new UnsupportedOperationException("Not yet implemented: ParteIzquierda_1");
    }

    private void ParteIzquierda_2() {
        //ParteIzquierda:
        //_epsilon_
        //\[ ListaDeExpresiones \] ParteIzquierda _action_ParteIzquierda_1
        //. IdentificadorOProcPredef ParteIzquierda _action_ParteIzquierda_2
        //^ ParteIzquierda _action_ParteIzquierda_3
        throw new UnsupportedOperationException("Not yet implemented: ParteIzquierda_2");
    }

    private void ParteIzquierda_3() {
        //ParteIzquierda:
        //_epsilon_
        //\[ ListaDeExpresiones \] ParteIzquierda _action_ParteIzquierda_1
        //. IdentificadorOProcPredef ParteIzquierda _action_ParteIzquierda_2
        //^ ParteIzquierda _action_ParteIzquierda_3
        throw new UnsupportedOperationException("Not yet implemented: ParteIzquierda_3");
    }

    private void RestoSentenciaAsignacion() {
        //RestoSentenciaAsignacion:
        //ParteIzquierda RestoSentenciaRestoAsignacion _action_RestoSentenciaAsignacion

        //RestoSentenciaRestoAsignacion y ParteIzquierda pueden ser epsilon
        System.out.println("RestoSentenciaAsignacion");

        Nodo nodo1 = _pilaNodos.pop(); //Hay que comprobar si es RestoSentenciaAsignacion, ParteIzquierda o IDENTIFICADOR
        Nodo nuevo = new Nodo();

        if (nodo1.getTipoToken() != null) {
            if (nodo1.getTipoToken().equals(TipoToken.IDENTIFICADOR)) {
                //en este caso tanto ParteIzquierda como RestoSentenciaRestoAsignacion son _epsilon
                //volvemos a meter el IDENTIFICADOR en la pila
                _pilaNodos.push(nodo1);
                //añadimos un nodo VOID para comprobaciones de que esta todo bien en RestoSentenciaAsignacion
                nuevo.addTipo(TipoSemantico.VOID);
                _pilaNodos.push(nuevo);
            }
        } else {
            //hay que ver si hay otro nodo mas y si ya es directamente identificador
            Nodo nodo2 = _pilaNodos.pop();
            if (nodo2.getTipoToken() != null) {
                if (nodo2.getTipoToken().equals(TipoToken.IDENTIFICADOR)) {
                    //en este caso solo hay o ParteIzquierda o RestoSentenciaRestoAsignacion
                    //comprobamos que no es error nodo1 y volvemos a meter el identificador (nodo2) en la pila
                    _pilaNodos.push(nodo2);
                    if (nodo1.getTipoBasico().equals(TipoSemantico.VOID)) {
                        nuevo.addTipo(TipoSemantico.VOID);
                        _pilaNodos.push(nuevo);
                    } else {
                        nuevo.addTipo(TipoSemantico.ERROR);
                        /*_gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Resto Sentencia de Asignación NO Válida",
                        nodo1.getLinea(),
                        nodo1.getColumna()));*/
                        nuevo.setColumna(nodo1.getColumna());
                        nuevo.setLinea(nodo1.getLinea());
                        _pilaNodos.push(nuevo);
                    }
                }
            } else {
                //tanto ParteIzquierda como RestoSentenciaRestoAsignacion tienen algo y hay q ver si los dos son VOID
                if (nodo1.getTipoBasico().equals(TipoSemantico.VOID) && nodo2.getTipoBasico().equals(TipoSemantico.VOID)) {
                    nuevo.addTipo(TipoSemantico.VOID);
                    _pilaNodos.push(nuevo);
                } else {
                    nuevo.addTipo(TipoSemantico.ERROR);
                    /*_gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia de Asignación NO Válida",
                    nodo1.getLinea(),
                    nodo1.getColumna()));*/
                    nuevo.setColumna(nodo1.getColumna());
                    nuevo.setLinea(nodo1.getLinea());
                    _pilaNodos.push(nuevo);
                }
            }
        }

    }

    private void RestoSentenciaIF() {
        //RestoSentenciaIF:
        //{ ELSIF Expresion _action_ExpresionELSIF THEN SecuenciaDeSentencias _action_RestoSentenciaELSIF } [ ELSE SecuenciaDeSentencias _action_RestoSentenciaELSE ] _action_RestoSentenciaIF

        //sacamos el primerNodo de la pila, si es una marca entonces es que no es vacio y comprobamos lo que hay
        //si no es una marca es el nodo de SecuenciaDeSentencias, le volvemos a poner y colocamos otro nuevo tipo VOID
        //para indicar que RestoSentenciaIF aunque es vacio es correcto

        /***pruebas***
        System.out.println("Entrando en RestoSentenciaIF");
        /***fin pruebas***
        Nodo nodo1 = _pilaNodos.pop(); //puede ser MARCA o SencuenciaDeSentencias

        if (nodo1.esMarca()) { //puede haber ELSIF y ELSE, solo ELSIF o solo ELSE
            Nodo nodo2 = _pilaNodos.pop(); //nodo VOID o ERROR de ELSIF o ELSE
            Nodo nodo3 = _pilaNodos.pop(); //puede ser o MARCA de ELSIF o SecuenciaDeSentencias
            if (nodo3.esMarca()) {
                //sacamos y nodo (void o error) y comprobamos nodo2 (ELSIF) y nodo4 (ELSE)
                Nodo nodo4 = _pilaNodos.pop(); //nodo VOID o ERROR de ELSE
                if (nodo2.getTipoBasico().equals(TipoSemantico.VOID) && nodo4.getTipoBasico().equals(TipoSemantico.VOID) ) {
                    Nodo n = new Nodo();
                    n.addTipo(TipoSemantico.VOID);
                    _pilaNodos.push(n);
                } else {
                    Nodo nuevo = new Nodo();
                    nuevo.addTipo(TipoSemantico.ERROR);
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia RestoSentenciaIF mal tipada",
                            nodo1.getLinea(),
                            nodo1.getColumna()));
                    nuevo.setColumna(nodo1.getColumna());
                    nuevo.setLinea(nodo1.getLinea());
                    _pilaNodos.push(nuevo);
                }

            } else { //es SecuenciaDeSentencias
                _pilaNodos.push(nodo1); //se vuelve a meter sin tocarlo
                //comprobamos que nodo2 es VOID
                if (nodo2.getTipoBasico().equals(TipoSemantico.VOID)) {
                    Nodo n = new Nodo();
                    n.addTipo(TipoSemantico.VOID);
                    _pilaNodos.push(n);
                } else {
                    Nodo nuevo = new Nodo();
                    nuevo.addTipo(TipoSemantico.ERROR);
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia RestoSentenciaIF mal tipada",
                            nodo1.getLinea(),
                            nodo1.getColumna()));
                    nuevo.setColumna(nodo1.getColumna());
                    nuevo.setLinea(nodo1.getLinea());
                    _pilaNodos.push(nuevo);
                }
            }

        } else {//es SecuenciaDeSentencias
            _pilaNodos.push(nodo1); //se vuelve a meter sin tocarlo
            //se añade un nodo void nuevo
            Nodo n = new Nodo();
            n.addTipo(TipoSemantico.VOID);
            _pilaNodos.push(n);
        }*/

    }

    private void RestoSentenciaRestoAsignacion_1() {
        //RestoSentenciaRestoAsignacion:
        //_epsilon_
        //:= Expresion _action_RestoSentenciaRestoAsignacion_1
        //ParametrosDeLlamada _action_RestoSentenciaRestoAsignacion_2

        System.out.println("RestoSentenciaRestoAsignacion_1 (Id:=Exp)");

        Nodo nodo1 = _pilaNodos.pop(); //Expresion
        _pilaNodos.pop(); //:=
        Nodo nodo2 = _pilaNodos.pop(); //puede ser o VOID de ParteIzquierda o Identificador si ParteIzquierda es _epsilon
        Nodo nuevo = new Nodo();

        //añadimos el tipoSemantico a la Expresion en el caso de ser un IDENTIIFICADOR
                boolean errIdent = false;

        if (nodo1.getTipoToken()==TipoToken.IDENTIFICADOR){
            // buscamos el tipo del identificador en la tabla
            if (_tablaActual.busca(nodo1.getLexema())!= null){
                ArrayList<TipoSemantico> tipo = _tablaActual.busca(nodo1.getLexema()).getTipoSemantico();
                nodo1.setTipo(tipo);
            } else {
                errIdent = true;
                //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                //meto el nodo2 en la pila pq luego se hacen comparaciones con el
                _pilaNodos.push(nodo2);
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo1.getLexema() + "' no está declarado",
                    nodo1.getLinea(),
                    nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }

        if (!errIdent){

            if (nodo2.getTipoToken() != null) { //es Identificador pq los VOID lo tienen a null
                if (nodo2.getTipoToken().equals(TipoToken.IDENTIFICADOR)) {
                    _pilaNodos.push(nodo2); //le vuelvo a meter en la pila
                    //Comprobamos que ninguno sea error y que sean del mismo tipo
                    ArrayList<TipoSemantico> tipo;
                    if (_tablaActual.busca(nodo2.getLexema()) != null) {
                        tipo = _tablaActual.busca(nodo2.getLexema()).getTipoSemantico();
                        if (!nodo1.getTipoBasico().equals(TipoSemantico.ERROR) &&
                                /*!nodo2.getTipoBasico().equals(TipoSemantico.ERROR) &&*/
                                nodo1.getTipoSemantico().equals(tipo)) { //??
                            nuevo.addTipo(TipoSemantico.VOID);
                            _pilaNodos.push(nuevo);
                        } else {
                            nuevo.addTipo(TipoSemantico.ERROR);
                            _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia de Asignación Id:=Exp mal tipada",
                                    nodo2.getLinea(),
                                    nodo2.getColumna()));
                            nuevo.setColumna(nodo2.getColumna());
                            nuevo.setLinea(nodo2.getLinea());
                            _pilaNodos.push(nuevo);
                        }
                    } else {
                        //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                        nuevo.addTipo(TipoSemantico.ERROR);
                        _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo2.getLexema() + "' no está declarado",
                                nodo2.getLinea(),
                                nodo2.getColumna()));
                        nuevo.setColumna(nodo2.getColumna());
                        nuevo.setLinea(nodo2.getLinea());
                        _pilaNodos.push(nuevo);
                    }

                }
            } else {
                //hay un VOID de ParteIzquierda
                Nodo nodo3 = _pilaNodos.peek(); //Identificador (OJO, no se saca de la pila solo se consulta)
                _pilaNodos.push(nodo2);
                //Comprobamos que ninguno sea error y que sean del mismo tipo
                ArrayList<TipoSemantico> tipo;
                if (_tablaActual.busca(nodo3.getLexema()) != null) {
                    tipo = _tablaActual.busca(nodo3.getLexema()).getTipoSemantico();
                    if (!nodo1.getTipoBasico().equals(TipoSemantico.ERROR) &&
                            /*!nodo3.getTipoBasico().equals(TipoSemantico.ERROR) && */
                            nodo1.getTipoSemantico().equals(tipo)) { //esto da error pq no se guarda bien el tipo semantico
                        nuevo.addTipo(TipoSemantico.VOID);
                        _pilaNodos.push(nuevo);
                    } else {
                        nuevo.addTipo(TipoSemantico.ERROR);
                        _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia de Asignación Id:=Exp mal tipada",
                                nodo3.getLinea(),
                                nodo3.getColumna()));
                        nuevo.setColumna(nodo3.getColumna());
                        nuevo.setLinea(nodo3.getLinea());
                        _pilaNodos.push(nuevo);
                    }
                } else {
                    //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                    nuevo.addTipo(TipoSemantico.ERROR);
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo3.getLexema() + "' no está declarado",
                            nodo3.getLinea(),
                            nodo3.getColumna()));
                    nuevo.setColumna(nodo3.getColumna());
                    nuevo.setLinea(nodo3.getLinea());
                    _pilaNodos.push(nuevo);
                }
            }
        }
    }

    private void RestoSentenciaRestoAsignacion_2() {
        //RestoSentenciaRestoAsignacion:
        //_epsilon_
        //:= Expresion _action_RestoSentenciaRestoAsignacion_1
        //ParametrosDeLlamada _action_RestoSentenciaRestoAsignacion_2

        System.out.println("RestoSentenciaRestoAsignacion_2 (Id ParametrosDeLlamada)");

        /*ParametrosDeLlamada es o una ListaExpresiones o nada
        - si es una ListaExpresiones, espero en la pila que haya un único nodo con el tipo de todas las expresiones
        que debería ser el mismo, para poder comprobarlo con identificador
        - si es nada, espero que haya un nodo VOID en la pila
        - si es error, espero un nodo ERROR en la pila
         */

        Nodo nodo1 = _pilaNodos.pop(); //ParametrosDeLlamada
        Nodo nodo2 = _pilaNodos.pop(); //puede ser o VOID de ParteIzquierda o Identificador si ParteIzquierda es _epsilon
        Nodo nuevo = new Nodo();

        if (nodo2.getTipoToken() != null) {
            if (nodo2.getTipoToken().equals(TipoToken.IDENTIFICADOR)) {
                _pilaNodos.push(nodo2); //le vuelvo a meter en la pila

                if (nodo1.getTipoBasico() == TipoSemantico.ERROR) {
                    //ParametrosDeLlamada tiene un error
                    nuevo.addTipo(TipoSemantico.ERROR);
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia de Asignación (Id ParamLlamada) mal tipada",
                            nodo1.getLinea(),
                            nodo1.getColumna()));
                    nuevo.setColumna(nodo1.getColumna());
                    nuevo.setLinea(nodo1.getLinea());
                    _pilaNodos.push(nuevo);
                } else if (nodo1.getTipoBasico() == TipoSemantico.VOID) {
                    //ParametrosDeLlamada es vacio asi que se añade un nodo void para indicar q esta bien construido esto
                    nuevo.addTipo(TipoSemantico.VOID);
                    _pilaNodos.push(nuevo);
                } else {
                    //aquí comprobamos que identificador y ListaExpresiones tengan el mismo tipo
                    ArrayList<TipoSemantico> tipo;
                    if (_tablaActual.busca(nodo2.getLexema()) != null) {
                        tipo = _tablaActual.busca(nodo2.getLexema()).getTipoSemantico();
                        if (nodo1.getTipoSemantico().equals(tipo)) {
                            //está bien y devuelvo un nodo VOID
                            nuevo.addTipo(TipoSemantico.VOID);
                            _pilaNodos.push(nuevo);
                        } else {
                            //hay un error de incompatibilidad de tipos
                            nuevo.addTipo(TipoSemantico.ERROR);
                            _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia de Asignación (Id ParamLlamada) mal tipada",
                                    nodo2.getLinea(),
                                    nodo2.getColumna()));
                            nuevo.setColumna(nodo2.getColumna());
                            nuevo.setLinea(nodo2.getLinea());
                            _pilaNodos.push(nuevo);
                        }
                    } else {
                        //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                        nuevo.addTipo(TipoSemantico.ERROR);
                        _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo2.getLexema() + "' no está declarado",
                                nodo2.getLinea(),
                                nodo2.getColumna()));
                        nuevo.setColumna(nodo2.getColumna());
                        nuevo.setLinea(nodo2.getLinea());
                        _pilaNodos.push(nuevo);
                    }
                }
            }
        } else {
            //hay un VOID de ParteIzquierda (nodo2)
            Nodo nodo3 = _pilaNodos.peek(); //Identificador (OJO, no se saca de la pila solo se consulta)
            _pilaNodos.push(nodo2); //con este nodo no se hace nada
            if (nodo1.getTipoBasico() == TipoSemantico.ERROR) {
                //ParametrosDeLlamada tiene un error
                nuevo.addTipo(TipoSemantico.ERROR);
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia de Asignación (Id ParamLlamada) mal tipada",
                        nodo1.getLinea(),
                        nodo1.getColumna()));
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            } else if (nodo1.getTipoBasico() == TipoSemantico.VOID) {
                //ParametrosDeLlamada es vacio asi que se añade un nodo void para indicar q esta bien construido esto
                nuevo.addTipo(TipoSemantico.VOID);
                _pilaNodos.push(nuevo);
            } else {
                //aquí comprobamos que identificador y ListaExpresiones tengan el mismo tipo
                ArrayList<TipoSemantico> tipo;
                if (_tablaActual.busca(nodo3.getLexema()) != null) {
                    tipo = _tablaActual.busca(nodo3.getLexema()).getTipoSemantico();
                    if (nodo1.getTipoSemantico().equals(tipo)) {
                        //está bien y devuelvo un nodo VOID
                        nuevo.addTipo(TipoSemantico.VOID);
                        _pilaNodos.push(nuevo);
                    } else {
                        //hay un error de incompatibilidad de tipos
                        nuevo.addTipo(TipoSemantico.ERROR);
                        _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia de Asignación (Id ParamLlamada) mal tipada",
                                nodo3.getLinea(),
                                nodo3.getColumna()));
                        nuevo.setColumna(nodo3.getColumna());
                        nuevo.setLinea(nodo3.getLinea());
                        _pilaNodos.push(nuevo);
                    }
                } else {
                    //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                    nuevo.addTipo(TipoSemantico.ERROR);
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo3.getLexema() + "' no está declarado",
                            nodo3.getLinea(),
                            nodo3.getColumna()));
                    nuevo.setColumna(nodo3.getColumna());
                    nuevo.setLinea(nodo3.getLinea());
                    _pilaNodos.push(nuevo);
                }
            }

        }
    }

    private void SecuenciaDeSentencias() {
        //SecuenciaDeSentencias:
        //Sentencia _action_SecuenciaDeSentencias_Marca { ; Sentencia _action_SecuenciaDeSentencias2 } _action_SecuenciaDeSentencias

        System.out.println("SecuenciaDeSentencias");

        boolean SSError = false;
        int SSLinea = 0;
        int SSColumna = 0;

        Nodo nodo1 = _pilaNodos.pop(); //Sentencia o Marca
        Nodo nuevo = new Nodo();

        while (!nodo1.esMarca()){
            //comprobamos que está bien tipada
            if (nodo1.getTipoBasico().equals(TipoSemantico.ERROR)) {
                SSError = true;
                SSLinea = nodo1.getLinea();
                SSColumna = nodo1.getColumna();
            }
            nodo1 = _pilaNodos.pop(); //sacamos el siguiente para ver si esta la marca
        }

        //al salir de while, en nodo1 esta la primera sentencia
        //comprobamos si es VOID y si no ha producido ningún error la secuencia anterior
        nodo1 = _pilaNodos.pop(); //Sentencia (la primera)
        if (nodo1.getTipoBasico().equals(TipoSemantico.VOID) && (!SSError)) {
            nuevo.addTipo(TipoSemantico.VOID);
            _pilaNodos.push(nuevo);
        } else if (nodo1.getTipoBasico().equals(TipoSemantico.ERROR)) {
            nuevo.addTipo(TipoSemantico.ERROR);
            /*_gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Secuencia de Sentencias NO Válida",
                        nodo1.getLinea(),
                        nodo1.getColumna()));*/
            nuevo.setColumna(nodo1.getColumna());
            nuevo.setLinea(nodo1.getLinea());
            _pilaNodos.push(nuevo);
        } else {
            nuevo.addTipo(TipoSemantico.ERROR);
            /*_gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Secuencia de Sentencias NO Válida",
                        SSLinea,
                        SSColumna));*/
            nuevo.setColumna(SSColumna);
            nuevo.setLinea(SSLinea);
            _pilaNodos.push(nuevo);
        }

    }

    private void SecuenciaDeSentencias2() {
        //SecuenciaDeSentencias:
        //Sentencia _action_SecuenciaDeSentencias_Marca { ; Sentencia _action_SecuenciaDeSentencias2 } _action_SecuenciaDeSentencias

        Nodo nodo1 = _pilaNodos.pop(); //Sentencia
        Nodo nuevo = new Nodo();

        if (nodo1.getTipoBasico().equals(TipoSemantico.VOID)) {
            nuevo.addTipo(TipoSemantico.VOID);
            _pilaNodos.push(nuevo);
        } else {
            nuevo.addTipo(TipoSemantico.ERROR);
            /*_gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia NO Válida",
                    nodo1.getLinea(),
                    nodo1.getColumna()));*/
            nuevo.setColumna(nodo1.getColumna());
            nuevo.setLinea(nodo1.getLinea());
            _pilaNodos.push(nuevo);
        }

    }

    private void SentenciaAsignacion() {
        //SentenciaAsignacion:
        //Identificador RestoSentenciaAsignacion _action_SentenciaAsignacion

        System.out.println("SentenciaAsignacion");

        Nodo nodo1 = _pilaNodos.pop(); //RestoSentenciaAsignacion o Identificador si es _epsilon lo otro

        if (!_pilaNodos.isEmpty()) { //entonces hay otro nodo mas en la pila
            Nodo nodo2 = _pilaNodos.pop(); //Identificador

            Nodo nuevo = new Nodo();
            if (nodo1.getTipoBasico().equals(TipoSemantico.VOID) &&
                    (nodo2.getTipoToken().equals(TipoToken.IDENTIFICADOR))) {
                nuevo.addTipo(TipoSemantico.VOID);
                _pilaNodos.push(nuevo);
            } else {
                nuevo.addTipo(TipoSemantico.ERROR);
                /*_gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia de Asignación mal tipada",
                nodo2.getLinea(),
                nodo2.getColumna()));*/
                nuevo.setColumna(nodo2.getColumna());
                nuevo.setLinea(nodo2.getLinea());
                _pilaNodos.push(nuevo);
            }
        } else { //solo esta el nodo de identificador en la pila
            Nodo nuevo = new Nodo();
            if (nodo1.getTipoToken().equals(TipoToken.IDENTIFICADOR)) {
                nuevo.addTipo(TipoSemantico.VOID);
                _pilaNodos.push(nuevo);
            } else {
                nuevo.addTipo(TipoSemantico.ERROR);
                /*_gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia de Asignación mal tipada",
                nodo1.getLinea(),
                nodo1.getColumna()));*/
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }
    }

    private void SentenciaFOR() {
        //SentenciaFOR:
        //FOR Identificador := Expresion _action_IdentificadorFOR TO Expresion _action_ExpresionTO [ BY ExpresionConstante _action_ExpresionConstanteFOR ] DO SecuenciaDeSentencias END _action_SentenciaFOR

        /***pruebas***
        Nodo SecuenciaDeSentencias = new Nodo();
        SecuenciaDeSentencias.addTipo(TipoSemantico.VOID);
        _pilaNodos.push(nodo);
        /***fin pruebas***/
        Nodo nodo1 = _pilaNodos.pop();// sacamos secuencia de sentencias
        Nodo nodo4 = _pilaNodos.pop(); //hay que ver si es una marca (hay BY) o no y es Expresion
        Nodo nodo2 = new Nodo();
        Nodo nodo3 = new Nodo();

        if (nodo4.esMarca()) {
            nodo2 = _pilaNodos.pop(); // sacamos expresionConstante
            nodo3 = _pilaNodos.pop(); // sacamos Expresion
        }

        //Nodo nodo3 = _pilaNodos.pop(); // sacamos Expresion

        if (nodo4.esMarca()) { //hay BY
            boolean errIdent=false;
            Nodo nodo = new Nodo();
            //miramos si ExpresiónConstante (nodo3) es un identificador
            if (nodo2.getTipoToken()==TipoToken.IDENTIFICADOR){
                // buscamos el tipo del identificador en la tabla
                if (_tablaActual.busca(nodo2.getLexema())!= null){
                    ArrayList<TipoSemantico> tipo = _tablaActual.busca(nodo2.getLexema()).getTipoSemantico();
                    nodo2.setTipo(tipo);
                } else {
                    errIdent = true;
                    //ERROR, el IDENTIFICADOR no esta en la tabla de simbolos
                    nodo.addTipo(TipoSemantico.ERROR);
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador '" + nodo2.getLexema() + "' no está declarado",
                        nodo2.getLinea(),
                        nodo2.getColumna()));
                    nodo.setColumna(nodo2.getColumna());
                    nodo.setLinea(nodo2.getLinea());
                    _pilaNodos.push(nodo);
                }
            }
            if (!errIdent){
                // miramos si las expresiones son del mismo tipo y que secuencia de sentencias sea de tipo void
                if (nodo2.getTipoBasico().equals(nodo3.getTipoBasico()) && nodo1.getTipoBasico().equals(TipoSemantico.VOID)) {
                    Nodo n = new Nodo();
                    n.addTipo(TipoSemantico.VOID);
                    _pilaNodos.push(n);
                } else {
                    Nodo nuevo = new Nodo();
                    nuevo.addTipo(TipoSemantico.ERROR);
                    /*_gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia SentenciaFOR mal tipada",
                            nodo1.getLinea(),
                            nodo1.getColumna()));*/
                    nuevo.setColumna(nodo1.getColumna());
                    nuevo.setLinea(nodo1.getLinea());
                    _pilaNodos.push(nuevo);
                }
            }

        } else {// miramos que la expresion no sea de tipo error y que secuencia de sentencias sea de tipo void
            if (nodo1.getTipoBasico().equals(TipoSemantico.VOID) && !nodo4.getTipoBasico().equals(TipoSemantico.ERROR)) {
                Nodo n = new Nodo();
                n.addTipo(TipoSemantico.VOID);
                _pilaNodos.push(n);
            } else {
                Nodo nuevo = new Nodo();
                nuevo.addTipo(TipoSemantico.ERROR);
                /*_gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia SentenciaFOR mal tipada",
                        nodo1.getLinea(),
                        nodo1.getColumna()));*/
                nuevo.setColumna(nodo1.getColumna());
                nuevo.setLinea(nodo1.getLinea());
                _pilaNodos.push(nuevo);
            }
        }

    }

    private void epsilonSentencia() {
        //solo se mete un nodo VOID para comprobaciones
        Nodo n = new Nodo();
        n.addTipo(TipoSemantico.VOID);
        _pilaNodos.push(n);
    }

    private void expresionSinParentesisDeMultiplicacion() {
        if (logger.isDebugEnabled()) {
            logger.debug("Entrando en el metodo expresionSinParentesisDeMultiplicacion");
        }
        if (!_pilaNodos.peek().esError()) {
            Nodo num1 = _pilaNodos.pop();
            Nodo op = _pilaNodos.pop();
            Nodo num2 = _pilaNodos.pop();
            if (!num1.esError() && !op.esError() && !num2.esError()) {
                if (sonOperablesAritmeticamente(num1, num2)) {
                    //hago esto para generacion de codigo intermedio para ver si lo que nos viene
                    //en la pila era un numero en el codigo o el resultado de una expresion
                    num2.setLexema("");

                    ArrayList<TipoSemantico> tipoSem = new ArrayList();
                    if(esReal(num2))
                    {
                        tipoSem.add(TipoSemantico.REAL);
                    }
                    if(esEntero(num2)){
                        tipoSem.add(TipoSemantico.ENTERO);
                    }
                    num2.setTipo(tipoSem);

                    _pilaNodos.push(num2);
                    if (logger.isDebugEnabled()) {
                        logger.debug("Salida con exito de expresionSinParentesisDeMultiplicacion");
                    }
                } else {
                    Nodo error = new Nodo();
                    error.addTipo(TipoSemantico.ERROR);
                    _pilaNodos.push(error);
                    if (logger.isDebugEnabled()) {
                        logger.debug("Salida con FALLO de expresionSinParentesisDeMultiplicacion");
                    }
                }
            } else {
                Nodo error = new Nodo();
                error.addTipo(TipoSemantico.ERROR);
                _pilaNodos.push(error);
                if (logger.isDebugEnabled()) {
                    logger.debug("Salida con FALLO de expresionSinParentesisDeMultiplicacion");
                }
            }
        } else {
            Nodo error = new Nodo();
            error.addTipo(TipoSemantico.ERROR);
            _pilaNodos.push(error);
            if (logger.isDebugEnabled()) {
                logger.debug("Salida con FALLO de expresionSinParentesisDeMultiplicacion");
            }
        }


    }

    private void expresionSinParentesisDeSuma() {
        if (logger.isDebugEnabled()) {
            logger.debug("Entrando en el metodo expresionSinParentesisDeSuma");
        }
        Nodo num1 = _pilaNodos.pop();
        Nodo oper = _pilaNodos.pop();
        Nodo num2 = _pilaNodos.pop();
        if (!num1.esError() && !oper.esError() && !num2.esError()) {
            if (sonOperablesAritmeticamente(num1, num2)) {
                
                num1.setLexema("");

                ArrayList<TipoSemantico> tipoSem = new ArrayList();
                if(esReal(num1))
                {
                    tipoSem.add(TipoSemantico.REAL);
                }
                if(esEntero(num1)){
                    tipoSem.add(TipoSemantico.ENTERO);
                }
                num1.setTipo(tipoSem);

                _pilaNodos.push(num1);

                if (logger.isDebugEnabled()) {
                    logger.debug("Salida con exito de operadorSinParentesisDeSuma");
                }
            } else {
                Nodo error = new Nodo();
                error.addTipo(TipoSemantico.ERROR);
                _pilaNodos.push(error);
                if (logger.isDebugEnabled()) {
                    logger.debug("Salida con FALLO de expresionSinParentesisDeSuma");
                }
            }
        }




    }

    /**
     * el fin de un ambito, cierra este como es debido
     *
     */
    private void finDeAmbito() {
        //TODO: aki hay un problema con el cierre de los modulos, colisionan aki
        // esta ñapa lo protege por ah
        if (!_pilaNodos.isEmpty()) {
            Nodo id = _pilaNodos.pop();
            if (_tablaActual.getNombre().equals(id.getLexema())) {
                _tablaActual = _tablaActual.cerrarAmbito();
            } else {

                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Simbolo \"" + id.getLexema() + "\" incorrecto, se esperaba \"" + _tablaActual.getNombre() + "\"",
                        id.getLinea(),
                        id.getColumna()));
            }
        }

    }

    /**
     * Se completa el tipo del simbolo identificado por el lexema del identificador
     * a valor Tipo CONSTANTE y el valor de la constante.
     */
    private void AsociacionConstante() {
        boolean error = false;
        try {

            Nodo valor = _pilaNodos.pop();
            _pilaNodos.pop();
            Nodo id = _pilaNodos.pop();

            if (!valor.esError()) {
                // Insertamos el identificador de la constante en la tabla de simbolos actuales
                if (_tablaActual.declaraSimbolo(id.getLexema())) {
                    // Completamos el tipo semantico y el valor
                    if (!_tablaActual.completaConstate(id.getLexema(), valor.getTipoSemantico(), valor.getLexema())) {
                        error = true;
                    }
                } else {
                    error = true;
                }
            } else {
                error = true;
            }
            if (error) {
                _gestorDeErrores.insertaErrorSemantico(
                        new TErrorSemantico("El simbolo \"" + id.getLexema() + "\" ya esta definido.",
                        id.getLinea(),
                        id.getColumna()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Se completa el tipo semantico de los identificadores y completando el
     * simbolo con el tipo VARIABLE.
     */
    private void DeclaracionVariables() {
        //REGLA: DeclaracionVariables: ListaIdentificadores : EsquemaDeTipo
        try {

            Nodo tipo = _pilaNodos.pop();

            if (!tipo.esError()) {

                Nodo id = null;

                do {
                    id = _pilaNodos.pop();

                    if (!id.esMarcaListaIdentificadores()) {

                        if (_tablaActual.declaraSimbolo(id.getLexema())) {

                            if (!_tablaActual.completaVariable(id.getLexema(), tipo.getTipoSemantico())) {
                                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El simbolo \"" + id.getLexema() + "\" ya esta definido.",
                                        id.getLinea(),
                                        id.getColumna()));
                            }
                        } else {

                            _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El simbolo \"" + id.getLexema() + "\" ya esta definido.",
                                    id.getLinea(),
                                    id.getColumna()));
                        }
                    }
                } while (!id.esMarcaListaIdentificadores());

                _pilaNodos.push(id); // Apilamos de nuevo la marca
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Se completa el tipo semantico del identificador y completando el
     * simbolo con el tipo TIPO.
     * Comprobación de errores:
     * Si se da un marca llamamos al gestor de errores y no apilamos el marca.
     * Si la parte valor es un identificador debemos comprobar que sea
     * una definicion de valor.
     */
    private void DefinicionDeTipo() {
        //REGLA: DefinicionDeTipo: Identificador = EsquemaDeTipo

        boolean error = false;

        try {

            Nodo tipo = _pilaNodos.pop();
            _pilaNodos.pop(); // operador
            Nodo id = _pilaNodos.pop();

            if (_tablaActual.declaraSimbolo(id.getLexema())) {
                if (!_tablaActual.completaTipo(id.getLexema(), tipo.getTipoSemantico())) {
                    error = true;
                }
            } else {
                error = true;
            }

            if (error) {
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El simbolo \"" + id.getLexema() + "\" ya esta definido.",
                        id.getLinea(),
                        id.getColumna()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * se comineza con un procedimineto
     */
    private void InicioDeclaracionProcedure() {
        // CabeceraSubprograma:
        // PROCEDURE Identificador _action_InicioDeclaraciónProcedure [ ParametrosFormales ]

        // sacamos el identificador para el procedimiento
        Nodo nodo = _pilaNodos.peek();

        // comprobamos unicidad
        if (!_tablaActual.declaraSimbolo(nodo.getLexema())) {
            _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador \"" + nodo.getLexema() + "\" esta siendo redefinido.",
                    nodo.getLinea(),
                    nodo.getColumna()));
        }

        // abrimos ambito.
        _tablaActual = _tablaActual.abrirAmbito();
        _tablaActual.setNombre(nodo.getLexema());
    }

    /**
     *
     * completa la definicion de un modulo
     */
    private void CabeceraDeProcedure() {
        // extrae elementos hasta que extraigo el nombre de la tabla de simbolos.
        // en ese momento puedo parar y definir el procedure.
        Nodo nodo = _pilaNodos.pop();
        String lexema = _tablaActual.getNombre();

        // inicializo los parametros
        int numArgs = 0;
        ArrayList<TipoPasoParametro> pasoArgumentos = new ArrayList<TipoPasoParametro>();
        ArrayList<ArrayList<TipoSemantico>> tipoArgumentos = new ArrayList<ArrayList<TipoSemantico>>();

        ArrayList<TipoSemantico> retorno = new ArrayList<TipoSemantico>();

        // un array para los nombres de los paramtros
        ArrayList<String> nombres = new ArrayList<String>();
        TipoPasoParametro modo;
        InfoSimbolo info;

        // comprobamos si es una función o un procediento
        if (nodo.esMarca()){
            nodo = _pilaNodos.pop();
            if (nodo.getTipoToken() == TipoToken.TIPO_SIMPLE){
                retorno = nodo.getTipoSemantico();
            }
            else{
                InfoSimbolo inf = _tablaActual.busca(nodo.getLexema());
                if ((inf != null) && (inf.getTipoSimbolo() == TipoSimbolo.TIPO)){
                    retorno = inf.getTipoSemantico();
                }
                else
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("el indetificador " +
                                                           nodo.getLexema() + " no es una declaracion de tipo",
                                                           nodo.getLinea(), nodo.getColumna()));
            }
            nodo = _pilaNodos.pop();
        }

        // mientras que no sea el nombre de la tabla
        while (!nodo.getLexema().equals(lexema)) {

            // primero, si el tipo semantico es uno definido por el usuario:
            if (nodo.getTipoToken() != TipoToken.TIPO_SIMPLE) {
                info = _tablaActual.busca(nodo.getLexema());
                if (info.getTipoSimbolo() != TipoSimbolo.TIPO) {
                    // no es una definición de tipo, crea un error
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("el identificador <" +
                            nodo.getLexema() +
                            "> no es una definicion de tipo",
                            nodo.getLinea(),
                            nodo.getColumna()));
                } else {
                    tipoArgumentos.add(((InfoSimboloTipo) info).getTipoSemantico());
                }
            } else {
                tipoArgumentos.add(nodo.getTipoSemantico());
            }

            // despues el identificador, si encotramos la marca antes, es por referencia:
            nodo = _pilaNodos.pop();

            //si encontramos una marca es por referencia:
            if (nodo.esMarca()) {
                modo = TipoPasoParametro.REFERENCIA;
                nodo = _pilaNodos.pop();
            } else {
                modo = TipoPasoParametro.VALOR;
            }

            pasoArgumentos.add(modo);

            // comprueba la unicidad a nivel de cabecera
            if (nombres.contains(nodo.getLexema())) {
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("el parametro \"" + nodo.getLexema() + "\"ya esta definido" +
                        nodo.getLexema(),
                        nodo.getLinea(),
                        nodo.getColumna()));
                return;
            }
            nombres.add(nodo.getLexema());

            // declara la variable.
            _tablaActual.declaraSimbolo(nodo.getLexema());
            _tablaActual.completaVariable(nodo.getLexema(), tipoArgumentos.get(tipoArgumentos.size() - 1));

            nodo = _pilaNodos.pop();
            numArgs++;
        }

        // cierra el ambito
        TablaDeSimbolos ambitoProc = _tablaActual;
        _tablaActual = _tablaActual.cerrarAmbito();

        // completa el simbolo
        if (!_tablaActual.completaSubprograma(lexema, numArgs, pasoArgumentos, tipoArgumentos, ambitoProc, retorno)) {
            _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El identificador \"" + lexema + "\" esta siendo redefinido.",
                    nodo.getLinea(),
                    nodo.getColumna()));
        }

        // devolvemos el ambito al del procedimineto hasta que este acabe
        _tablaActual = ambitoProc;
    }

    private void RestoSentenciaELSE() {
        //RestoSentenciaIF:
        //{ ELSIF Expresion _action_ExpresionELSIF THEN SecuenciaDeSentencias _action_RestoSentenciaELSIF } [ ELSE SecuenciaDeSentencias _action_RestoSentenciaELSE ] _action_RestoSentenciaIF

        Nodo nodo1 = _pilaNodos.pop(); //SecuenciaDeSentencias

        Nodo nuevo = new Nodo();
        if (nodo1.getTipoBasico().equals(TipoSemantico.VOID)) {
            nuevo.addTipo(TipoSemantico.VOID);
            _pilaNodos.push(nuevo);
        } else {
            nuevo.addTipo(TipoSemantico.ERROR);
            nuevo.setColumna(nodo1.getColumna());
            nuevo.setLinea(nodo1.getLinea());
            _pilaNodos.push(nuevo);
            /*_gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia ELSE mal tipada",
                    nodo1.getLinea(),
                    nodo1.getColumna()));*/
        }

        //insertamos el nodo marca en la pila para saber que hay un ELSE
        Nodo nodoMarca = new Nodo();
        nodoMarca.crearMarca();
        _pilaNodos.push(nodoMarca);

    }

    private void RestoSentenciaELSIF() {
        //RestoSentenciaIF:
        //{ ELSIF Expresion _action_ExpresionELSIF THEN SecuenciaDeSentencias _action_RestoSentenciaELSIF } [ ELSE SecuenciaDeSentencias _action_RestoSentenciaELSE ] _action_RestoSentenciaIF
        /*pruebas
        System.out.println("RestoSentenciaELSIF");
        /*Nodo SecuenciaDeSentencias = new Nodo();
        SecuenciaDeSentencias.addTipo(TipoSemantico.VOID);
        //Metemos esto para probarlo
        _pilaNodos.push(SecuenciaDeSentencias);
        /*FIN pruebas*/

        Nodo nodo1 = _pilaNodos.pop(); //SecuenciaDeSentencias
        Nodo nodo2 = _pilaNodos.pop(); //Expresion

        Nodo nuevo = new Nodo();
        if (nodo1.getTipoBasico().equals(TipoSemantico.VOID) &&
                nodo2.getTipoBasico().equals(TipoSemantico.VOID)) {
            nuevo.addTipo(TipoSemantico.VOID);
            _pilaNodos.push(nuevo);
        } else {
            nuevo.addTipo(TipoSemantico.ERROR);
            nuevo.setColumna(nodo1.getColumna());
            nuevo.setLinea(nodo1.getLinea());
            _pilaNodos.push(nuevo);
            /*_gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia ELSIF mal tipada",
                    nuevo.getLinea(),
                    nuevo.getColumna()));*/
        }

        //insertamos el nodo marca en la pila para saber que hay un ELSIF
        Nodo nodoMarca = new Nodo();
        nodoMarca.crearMarca();
        _pilaNodos.push(nodoMarca);

    }

    private void SentenciaIF() {
        //SentenciaIF:
        //IF Expresion _action_ExpresionIF THEN SecuenciaDeSentencias RestoSentenciaIF END _action_SentenciaIF

        /*pruebas*
        System.out.println("SentenciaIF");
        Nodo RestoSentenciaIF = new Nodo();
        RestoSentenciaIF.addTipo(TipoSemantico.VOID);
        Nodo SecuenciaDeSentencias = new Nodo();
        SecuenciaDeSentencias.addTipo(TipoSemantico.VOID);
        //Metemos esto para probarlo
        _pilaNodos.push(RestoSentenciaIF);
        _pilaNodos.push(SecuenciaDeSentencias);
        /*FIN pruebas*/

        /*codigo correspondiente a RestoSentenciaIF pq hay veces q no entra*/
        Nodo nodo1 = _pilaNodos.pop(); //puede ser MARCA o SencuenciaDeSentencias

        if (nodo1.esMarca()) { //puede haber ELSIF y ELSE, solo ELSIF o solo ELSE
            Nodo nodo2 = _pilaNodos.pop(); //nodo VOID o ERROR de ELSIF o ELSE
            Nodo nodo3 = _pilaNodos.pop(); //puede ser o MARCA de ELSIF o SecuenciaDeSentencias
            if (nodo3.esMarca()) {
                //sacamos y nodo (void o error) y comprobamos nodo2 (ELSIF) y nodo4 (ELSE)
                Nodo nodo4 = _pilaNodos.pop(); //nodo VOID o ERROR de ELSE
                if (nodo2.getTipoBasico().equals(TipoSemantico.VOID) && nodo4.getTipoBasico().equals(TipoSemantico.VOID) ) {
                    Nodo n = new Nodo();
                    n.addTipo(TipoSemantico.VOID);
                    _pilaNodos.push(n);
                } else {
                    Nodo nuevo = new Nodo();
                    nuevo.addTipo(TipoSemantico.ERROR);
                    /*_gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia RestoSentenciaIF mal tipada",
                            nodo1.getLinea(),
                            nodo1.getColumna()));*/
                    nuevo.setColumna(nodo1.getColumna());
                    nuevo.setLinea(nodo1.getLinea());
                    _pilaNodos.push(nuevo);
                }

            } else { //es SecuenciaDeSentencias
                _pilaNodos.push(nodo3); //se vuelve a meter sin tocarlo
                //comprobamos que nodo2 es VOID
                if (nodo2.getTipoBasico().equals(TipoSemantico.VOID)) {
                    Nodo n = new Nodo();
                    n.addTipo(TipoSemantico.VOID);
                    _pilaNodos.push(n);
                } else {
                    Nodo nuevo = new Nodo();
                    nuevo.addTipo(TipoSemantico.ERROR);
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia RestoSentenciaIF mal tipada",
                            nodo1.getLinea(),
                            nodo1.getColumna()));
                    nuevo.setColumna(nodo1.getColumna());
                    nuevo.setLinea(nodo1.getLinea());
                    _pilaNodos.push(nuevo);
                }
            }

        } else {//es SecuenciaDeSentencias
            _pilaNodos.push(nodo1); //se vuelve a meter sin tocarlo
            //se añade un nodo void nuevo
            Nodo n = new Nodo();
            n.addTipo(TipoSemantico.VOID);
            _pilaNodos.push(n);
        }
        /* fin de codigo de RestoSentenciaIF*/


        nodo1 = _pilaNodos.pop(); //RestoSentenciaIF
        Nodo nodo2 = _pilaNodos.pop(); //SecuenciaDeSentencias
        Nodo nodo3 = _pilaNodos.pop(); //Expresion

        Nodo nuevo = new Nodo();
        if (nodo1.getTipoBasico().equals(TipoSemantico.VOID) &&
                nodo2.getTipoBasico().equals(TipoSemantico.VOID) &&
                nodo3.getTipoBasico().equals(TipoSemantico.VOID)) {
            nuevo.addTipo(TipoSemantico.VOID);
            _pilaNodos.push(nuevo);
        } else {
            nuevo.addTipo(TipoSemantico.ERROR);
            _pilaNodos.push(nuevo);
        /*_gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia IF mal tipada",
        nodo1.getLinea(),
        nodo1.getColumna()));*/
        }

    }

    private void SentenciaLOOP() {
        //SentenciaLOOP:
        //LOOP SecuenciaDeSentencias END _action_SentenciaLOOP

        /*pruebas
        System.out.println("SentenciaLOOP");
        Nodo SecuenciaDeSentencias = new Nodo();
        SecuenciaDeSentencias.addTipo(TipoSemantico.VOID);
        //Metemos esto para probarlo
        _pilaNodos.push(SecuenciaDeSentencias);
        /*FIN pruebas*/

        Nodo nodo1 = _pilaNodos.pop(); //SecuenciaDeSentencias

        Nodo nuevo = new Nodo();
        if (nodo1.getTipoBasico().equals(TipoSemantico.VOID)) {
            nuevo.addTipo(TipoSemantico.VOID);
            _pilaNodos.push(nuevo);
        } else {
            nuevo.addTipo(TipoSemantico.ERROR);
            _pilaNodos.push(nuevo);
            _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia LOOP mal tipada",
                    nuevo.getLinea(),
                    nuevo.getColumna()));
        }

    }

    private void SentenciaREPEAT() {
        //SentenciaREPEAT:
        //REPEAT SecuenciaDeSentencias UNTIL Expresion _action_ExpresionREPEAT _action_SentenciaREPEAT

        /*pruebas*
        System.out.println("SentenciaREPEAT");
        /*FIN pruebas*/

        Nodo nodo1 = _pilaNodos.pop(); //Expresion
        Nodo nodo2 = _pilaNodos.pop(); //SecuenciaDeSentencias

        Nodo nuevo = new Nodo();
        if (nodo1.getTipoBasico().equals(TipoSemantico.VOID) &&
                nodo2.getTipoBasico().equals(TipoSemantico.VOID)) {
            nuevo.addTipo(TipoSemantico.VOID);
            _pilaNodos.push(nuevo);
        } else {
            nuevo.addTipo(TipoSemantico.ERROR);
            _pilaNodos.push(nuevo);
            _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia REPEAT mal tipada",
                    nuevo.getLinea(),
                    nuevo.getColumna()));
        }

    }

    private void SentenciaWHILE() {
        //SentenciaWHILE:
        //WHILE Expresion _action_ExpresionWHILE DO SecuenciaDeSentencias END _action_SentenciaWHILE

        /*pruebas
        System.out.println("SentenciaWHILE");
        Nodo SecuenciaDeSentencias = new Nodo();
        SecuenciaDeSentencias.addTipo(TipoSemantico.VOID);
        //Nodo nodoDO = new Nodo();
        Nodo nodoEND = new Nodo();
        //Metemos esto para probarlo
        //_pilaNodos.push(nodoDO);
        _pilaNodos.push(SecuenciaDeSentencias);
        _pilaNodos.push(nodoEND);
        /*FIN pruebas*/

        Nodo nodo1 = _pilaNodos.pop(); //SecuenciaDeSentencias
        Nodo nodo2 = _pilaNodos.pop(); //Expresion

        Nodo nuevo = new Nodo();
        if (nodo1.getTipoBasico().equals(TipoSemantico.VOID) &&
                nodo2.getTipoBasico().equals(TipoSemantico.VOID)) {
            nuevo.addTipo(TipoSemantico.VOID);
            _pilaNodos.push(nuevo);
        } else {
            nuevo.addTipo(TipoSemantico.ERROR);
            _pilaNodos.push(nuevo);
            _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Sentencia WHILE mal tipada",
                    nuevo.getLinea(),
                    nuevo.getColumna()));
        }

    }

    /**
     * Se completa el tipo semantico del id con tipo CONJUNTO.
     * Si viene un marca lo propagamos volviendolo a apilar.
     */
    private void TipoConjunto() {
        //REGLA TipoConjunto: SET OF TipoSimple

        try {

            Nodo tipo = _pilaNodos.pop();

            // si no es marca completamos diciendole que es de valor conjunto
            if (!tipo.esError()) {
                tipo.addTipo(TipoSemantico.CONJUNTO);
            }
            // Si hay un marca lo propagamos
            _pilaNodos.push(tipo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Comprobamos que el identificador que representa el valor
     * predefinido haya sido como marcado en la tabla de simbolos
     * como valor. Si no ha sido marcado como valor significa que no
     * se ha declarado en la parte del TYPE y por lo tanto es un
     * valor incorrecto.
     */
    private void TipoPredefinidoPorUsuario() {

        try {

            Nodo tipoPredefinido = _pilaNodos.pop(); // TIPO PREDEFINIDO

            InfoSimbolo info = (InfoSimbolo) _tablaActual.busca(tipoPredefinido.getLexema());

            if (info.getTipoSimbolo() == TipoSimbolo.TIPO) {

                // Obtenemos el valor semantico del identificador predefinido
                tipoPredefinido.setTipo(info.getTipoSemantico());

                // Lo apilamos
                _pilaNodos.push(tipoPredefinido);

            } else {

                crearNodoError(tipoPredefinido);

                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("El tipo \"" + tipoPredefinido.getLexema() + "\" no está definido.",
                        tipoPredefinido.getLinea(),
                        tipoPredefinido.getColumna()));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    /**
     * Se completa el tipo semantico del id con tipo PUNTERO.
     * Si viene un marca lo propagamos volviendolo a apilar.
     */
    private void TipoPuntero() {
        //REGLA: TipoPuntero:POINTER TO EsquemaDeTipo
        try {

            Nodo tipo = _pilaNodos.pop();

            // si no es marca completamos diciendole que es de valor puntero
            if (!tipo.esError()) {
                tipo.addTipo(TipoSemantico.PUNTERO);
            }
            // Si hay un marca lo propagamos
            _pilaNodos.push(tipo);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void TRUE() {
        if (logger.isDebugEnabled()) {
            logger.debug("Entrando en el metodo TRUE()");
        }

        _pilaNodos.peek().addTipo(TipoSemantico.BOOLEANO);
    }

    private void FALSE() {

        _pilaNodos.peek().addTipo(TipoSemantico.BOOLEANO);
    }

    private void NIL() {

        _pilaNodos.peek().addTipo(TipoSemantico.PUNTERO);
    }

    private void BITSET() {

        _pilaNodos.peek().addTipo(TipoSemantico.BITSET);
    }

    private void BOOLEAN() {

        _pilaNodos.peek().addTipo(TipoSemantico.BOOLEANO);
    }

    private void CARDINAL() {

        _pilaNodos.peek().addTipo(TipoSemantico.CARDINAL);
    }

    private void CHAR() {

        _pilaNodos.peek().addTipo(TipoSemantico.CARACTER);
    }

    private void INTEGER() {

        _pilaNodos.peek().addTipo(TipoSemantico.ENTERO);
    }

    private void LONGINT() {

        _pilaNodos.peek().addTipo(TipoSemantico.ENTERO_LARGO);
    }

    private void LONGREAL() {

        _pilaNodos.peek().addTipo(TipoSemantico.REAL_LARGO);
    }

    private void PROC() {

        _pilaNodos.peek().addTipo(TipoSemantico.PROCEDIMIENTO);
    }

    private void REAL() {

        _pilaNodos.peek().addTipo(TipoSemantico.REAL);
    }

    private void Cadena() {

        _pilaNodos.peek().addTipo(TipoSemantico.CADENA);
    }

    private void Caracter() {

        _pilaNodos.peek().addTipo(TipoSemantico.CARACTER);
    }

    private void NumeroEntero() {

        _pilaNodos.peek().addTipo(TipoSemantico.ENTERO);
    }

    private void NumeroReal() {

        _pilaNodos.peek().addTipo(TipoSemantico.REAL);
    }

    /**
     * Crea un id marca y lo apila en la pila.
     */
    private void crearNodoError(Nodo tipoPredefinido) {

        Nodo error = new Nodo(tipoPredefinido.getLexema(),
                tipoPredefinido.getLinea(),
                tipoPredefinido.getColumna(),
                tipoPredefinido.getTipoToken());

        error.addTipo(TipoSemantico.ERROR);
        _pilaNodos.add(error);
    }

    /**
     * Metodo que comprueba los tipos para los operadores unarios como la suma y la resta
     */
    private void operadorUnario() {

        if (logger.isDebugEnabled()) {
            logger.debug("Entrando en el metodo OperadorUnario");
        }
        if (!_pilaNodos.peek().esError()) {
            Nodo numero = _pilaNodos.pop();
            Nodo signo = _pilaNodos.pop();
            if (numero != null && signo != null) {
                if (signo.getTipoToken() == TipoToken.OPERADOR_SUMADOR) {
                    if (esEntero(numero) || esReal(numero)) {
                        _pilaNodos.push(numero);

                        ArrayList<TipoSemantico> tipoSem = new ArrayList();
                        if(esReal(numero))
                        {
                            tipoSem.add(TipoSemantico.REAL);
                        }
                        if(esEntero(numero)){
                            tipoSem.add(TipoSemantico.ENTERO);
                        }
                        numero.setTipo(tipoSem);

                        if (logger.isDebugEnabled()) {
                            logger.debug("Salida con EXITO de operadorUnario");
                        }
                    } else {
                        _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Operador unario no aplicable.", numero.getLinea(), numero.getColumna()));
                        Nodo nodoError = new Nodo();
                        ArrayList<TipoSemantico> tipos = new ArrayList();
                        tipos.add(TipoSemantico.ERROR);
                        _pilaNodos.push(nodoError);
                        if (logger.isDebugEnabled()) {
                            logger.debug("Salida con ERROR de operadorUnario. El presunto numero no es valido para los metodos de suma y resta");
                        }
                    }
                } else if (signo.getTipoToken() == TipoToken.PALABRA_RESERVADA && ((!signo.getLexema().equals("TRUE")) && (!signo.getLexema().equals("FALSE")))) {
                    if (esBooleano(numero)) {

                        ArrayList<TipoSemantico> array = new ArrayList();
                        array.add(TipoSemantico.BOOLEANO);
                        numero.setTipo(array);

                        _pilaNodos.push(numero);
                        if (logger.isDebugEnabled()) {
                            logger.debug("Salida con EXITO de operadorUnario");
                        }
                    } else {
                        _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Operador unario no aplicable.", numero.getLinea(), numero.getColumna()));
                        Nodo nodoError = new Nodo();
                        ArrayList<TipoSemantico> tipos = new ArrayList();
                        tipos.add(TipoSemantico.ERROR);
                        _pilaNodos.push(nodoError);
                        if (logger.isDebugEnabled()) {
                            logger.debug("Salida con ERROR de operadorUnario. El presunto numero no es valido para los metodos booleanos");
                        }
                    }
                } else {
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Operador unario no existente.", numero.getLinea(), numero.getColumna()));
                    Nodo nodoError = new Nodo();
                    ArrayList<TipoSemantico> tipos = new ArrayList();
                    tipos.add(TipoSemantico.ERROR);
                    _pilaNodos.push(nodoError);
                    if (logger.isDebugEnabled()) {
                        logger.debug("Salida con ERROR de operadorUnario. El operador unario introducido no existe");
                    }
                }
            }
        }


    }

    /**
     * Añade una marca en la pila para poder desapilar la lista hasta este
     * elemento.
     */
    private void ponerMarcaListaVariables() {

        // Creamos y apilamos el id de marca de inicio de la lista
        Nodo primerIdent = _pilaNodos.pop();

        Nodo marca = new Nodo();
        marca.crearMarcaListaIdentificadores();
        _pilaNodos.push(marca);

        _pilaNodos.push(primerIdent);
    }

    private void por_referencia() {
        // apila un nodo que indica referncia por delante de la variable a la
        // que se refiere

        Nodo marca = new Nodo();
        marca.crearMarca();
        _pilaNodos.push(marca);
    }

    /**
     * Quita la marca de la cima de la pila.
     */
    private void quitarMarcaListaVariables() {

        _pilaNodos.pop();
    }

    private void retornoFunc() {
       // añade una marca para indicar el retorno de funcion
        Nodo marca = new Nodo();
        marca.crearMarca();
        _pilaNodos.add(marca);
    }

    /**
     * Comprueba que los dos nodos sean de tipo booleano
     * @param nodo1 Primer nodo a comprobar
     * @param nodo2 Segundo nodo a comprobar
     * @return true si los dos nodos son de tipo booleano y false en otro caso
     */
    private boolean sonBooleanos(Nodo nodo1, Nodo nodo2) {
        if (nodo1 != null && nodo2 != null) {
            if (nodo1.getTipoBasico() == TipoSemantico.BOOLEANO && nodo2.getTipoBasico() == TipoSemantico.BOOLEANO) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Comprueba que el nodo introducido sea de tipo booleano
     * @param nodo Nodo a comprobar
     * @return true si el nodo es de tipo booleano, false en otro caso
     */
    private boolean esBooleano(Nodo nodo) {
        if(logger.isDebugEnabled()){
            logger.debug("Entrando en esEntero con nodo " + nodo);
        }
        if (nodo.getTipoToken() == TipoToken.IDENTIFICADOR) {
            InfoSimbolo simbNodo = _tablaActual.busca(nodo.getLexema());
            if (simbNodo == null)
                return false;
            else if (simbNodo.getTipoBasico() != TipoSemantico.BOOLEANO)
                return false;
        }
        else if (nodo.getTipoToken() == TipoToken.PALABRA_RESERVADA) {
                if (nodo.getLexema().equals("TRUE") || nodo.getLexema().equals("FALSE")) {
                    return true;
                }
                else {
                    return false;
                }
        }
        else return false;
        return true;
    }

    /**
     * Comprueba que los dos nodos sean de tipo entero
     * @param nodo1 Primer nodo a comprobar
     * @param nodo2 Segundo nodo a comprobar
     * @return true si los dos nodos son de tipo entero y false en otro caso
     */
    private boolean sonEnteros(Nodo nodo1, Nodo nodo2) {
        if (nodo1 != null && nodo2 != null) {
            if (nodo1.getTipoBasico() == TipoSemantico.ENTERO && nodo2.getTipoBasico() == TipoSemantico.ENTERO) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Comprueba que el nodo introducido sea de tipo entero
     * @param nodo Nodo a comprobar
     * @return true si el nodo es de tipo entero, false en otro caso
     */
    private boolean esEntero(Nodo nodo) {
        if(logger.isDebugEnabled()){
            logger.debug("Entrando en esEntero con nodo " + nodo);
        }
        if (nodo.getTipoToken() == TipoToken.IDENTIFICADOR) {
            InfoSimbolo simbNodo = _tablaActual.busca(nodo.getLexema());
            if (simbNodo == null)
                return false;
            else if (simbNodo.getTipoBasico() != TipoSemantico.ENTERO)
                return false;
        }
        else if (nodo.getTipoToken() == TipoToken.NUMERO_ENTERO) {
                return true;
        }
        else
            return false;
        return true;
    }

    private boolean sonOperablesLogicamente(Nodo op1, Nodo op2) {
        if (logger.isDebugEnabled()) {
            StringBuilder trace = new StringBuilder("Entrando en el metodo sonOperablesLogicamente con los nodos ");
            trace.append(op1);
            trace.append(" y ");
            trace.append(op2);
            logger.debug(trace.toString());
        }
        TipoSemantico sem1 = null;
        TipoSemantico sem2 = null;
        if (op1.getTipoToken() == TipoToken.IDENTIFICADOR) {
            // Si es identificador, accedemos a la tabla de símbolos
            InfoSimbolo simbNodo1 = _tablaActual.busca(op1.getLexema());
            if (simbNodo1 != null) {
                // Hemos encontrado el símbolo, miramos que su tipo semántico
                // sea integer o real
                sem1 = simbNodo1.getTipoBasico();
                if ((sem1 != TipoSemantico.ENTERO) ||
                        (sem1 != TipoSemantico.REAL) || (sem1 != TipoSemantico.BOOLEANO)) {
                    StringBuilder trace = new StringBuilder();
                    trace.append("Tipo de la variable ");
                    trace.append(op1.getLexema());
                    trace.append(" no operable aritmeticamente");

                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico(trace.toString(), op1.getLinea(), op1.getColumna()));

                    // TODO: ¿Entero largo, real largo, etc?
                    return false;
                }
            } else {
                StringBuilder trace = new StringBuilder("Variable ");
                trace.append(op1.getLexema());
                trace.append(" no definida.");
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico(trace.toString(), op1.getLinea(), op1.getColumna()));
                return false;
            }
        }
        if (op2.getTipoToken() == TipoToken.IDENTIFICADOR) {
            // Si es identificador, accedemos a la tabla de símbolos
            InfoSimbolo simbNodo2 = _tablaActual.busca(op2.getLexema());
            if (simbNodo2 != null) {
                // Hemos encontrado el símbolo, miramos que su tipo semántico
                // sea integer o real
                sem2 = simbNodo2.getTipoBasico();
                if ((sem2 != TipoSemantico.ENTERO) ||
                        (sem2 != TipoSemantico.REAL) || (sem1 != TipoSemantico.BOOLEANO)) {
                    StringBuilder trace = new StringBuilder();
                    trace.append("Tipo de la variable ");
                    trace.append(op2.getLexema());
                    trace.append(" no operable aritmeticamente");

                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico(trace.toString(), op2.getLinea(), op2.getColumna()));

                    // TODO: ¿Entero largo, real largo, etc?
                    return false;
                }
            } else {
                StringBuilder trace = new StringBuilder("Variable ");
                trace.append(op2.getLexema());
                trace.append(" no definida.");
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico(trace.toString(), op2.getLinea(), op2.getColumna()));
                return false;
            }
        }
        if (op1.getTipoToken() == TipoToken.NUMERO_ENTERO) {
            if (op2.getTipoToken() != TipoToken.NUMERO_ENTERO) {
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipos no operables aritmeticamente", op1.getLinea(), op1.getColumna()));
                return false;
            }
        }
        if (op1.getTipoToken() == TipoToken.NUMERO_REAL) {
            if (op2.getTipoToken() != TipoToken.NUMERO_REAL) {
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipos no operables aritmeticamente", op1.getLinea(), op1.getColumna()));
                return false;
            }
        }

        if (op1.getTipoToken() == TipoToken.PALABRA_RESERVADA) {
            if (op2.getTipoToken() != TipoToken.PALABRA_RESERVADA) {
                return false;
            } else {
                if (!op1.getLexema().equals("TRUE")) {
                    if (!op1.getLexema().equals("FALSE")) {
                        _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipos no operables aritmeticamente", op1.getLinea(), op1.getColumna()));
                        return false;
                    }
                }
                if (!op2.getLexema().equals("TRUE")) {
                    if (!op2.getLexema().equals("FALSE")) {
                        _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipos no operables aritmeticamente", op1.getLinea(), op1.getColumna()));
                        return false;
                    }
                }
            }
        }
        // Hay 4 casos:
        //   1. Identificadores los dos
        //   2. Identificador y no identificador
        //   3. No identificador e identificador
        //   4. No identificadores los dos (ya comprobado arriba)
        if (sem1 != null && sem2 != null) {
            // Caso 1: Dos identificadores
            if (sem1 != sem2) {
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipos no operables aritmeticamente", op1.getLinea(), op1.getColumna()));
                return false;
            }
        } else if (sem1 != null && sem2 == null) {
            // Caso 2: Identificador y no identificador
            if (sem1 == TipoSemantico.ENTERO) {
                if (op2.getTipoToken() != TipoToken.NUMERO_ENTERO) {

                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipos no operables aritmeticamente", op1.getLinea(), op1.getColumna()));
                    return false;
                }
            } else if (sem1 == TipoSemantico.REAL) {
                if (op2.getTipoToken() != TipoToken.NUMERO_REAL) {
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipos no operables aritmeticamente", op1.getLinea(), op1.getColumna()));
                    return false;
                }
            } else if (sem1 == TipoSemantico.REAL) {
                if (op2.getTipoBasico() != TipoSemantico.BOOLEANO) {
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipos no operables aritmeticamente", op1.getLinea(), op1.getColumna()));
                    return false;
                }
            }
        } else if (sem1 == null && sem2 != null) {
            // Caso 3: No identificador e identificador
            if (sem2 == TipoSemantico.ENTERO) {
                if (op1.getTipoToken() != TipoToken.NUMERO_ENTERO) {
                    return false;
                }
            } else if (sem2 == TipoSemantico.REAL) {
                if (op1.getTipoToken() != TipoToken.NUMERO_REAL) {
                    return false;
                }
            } else if (sem2 == TipoSemantico.REAL) {
                if (op1.getTipoBasico() != TipoSemantico.BOOLEANO) {
                    return false;
                }
            }
        }
        // Si hemos llegado hasta aquí, es que son operables aritméticamente
        return true;
    }

    /**
     * Comprueba que los dos nodos sean de tipo real
     * @param nodo1 Primer nodo a comprobar
     * @param nodo2 Segundo nodo a comprobar
     * @return true si los dos nodos son de tipo real y false en otro caso
     */
    private boolean sonReales(Nodo nodo1, Nodo nodo2) {
        if (nodo1 != null && nodo2 != null) {
            if (nodo1.getTipoBasico() == TipoSemantico.REAL && nodo2.getTipoBasico() == TipoSemantico.REAL) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Comprueba que el nodo introducido sea de tipo real
     * @param nodo Nodo a comprobar
     * @return true si el nodo es de tipo real, false en otro caso
     */
    private boolean esReal(Nodo nodo) {
        if(logger.isDebugEnabled()){
            logger.debug("Entrando en esReal con nodo " + nodo);
        }
        if (nodo.getTipoToken() == TipoToken.IDENTIFICADOR) {
            InfoSimbolo simbNodo = _tablaActual.busca(nodo.getLexema());
            if (simbNodo == null)
                return false;
            else if (simbNodo.getTipoBasico() != TipoSemantico.REAL)
                return false;
        }
        else if (nodo.getTipoToken() == TipoToken.NUMERO_REAL) {
                return true;
        }
        else
            return false;
        return true;
    }

    /**
     * Comprueba que los dos nodos sean de tipo char
     * @param nodo1 Primer nodo a comprobar
     * @param nodo2 Segundo nodo a comprobar
     * @return true si los dos nodos son de tipo char y false en otro caso
     */
    private boolean sonChars(Nodo nodo1, Nodo nodo2) {
        if (nodo1 != null && nodo2 != null) {
            if ((nodo1.getTipoBasico() == TipoSemantico.CARACTER) && nodo2.getTipoBasico() == TipoSemantico.CARACTER) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Comprueba que el nodo introducido sea de tipo char
     * @param nodo Nodo a comprobar
     * @return true si el nodo es de tipo chars, false en otro caso
     */
    private boolean esChar(Nodo nodo) {
        if(logger.isDebugEnabled()){
            logger.debug("Entrando en esChar con nodo " + nodo);
        }
        if (nodo.getTipoToken() == TipoToken.IDENTIFICADOR) {
            InfoSimbolo simbNodo = _tablaActual.busca(nodo.getLexema());
            if (simbNodo == null)
                return false;
            else if (simbNodo.getTipoBasico() != TipoSemantico.CARACTER)
                return false;
        }
        else if (nodo.getTipoToken() == TipoToken.CARACTER) {
                return true;
        }
        else
            return false;
        return true;
    }

    /**
     * comprueba si dos tipos son compatibles, de forma que se puede operar con
     * ellos o realizar una asignacion:
     * los tipos son compatibles de la siguente manera:
     *    Bitset,
     *    Integer, Real, LongInt, Boolean son compatibles SOLO con su mismo tipo
     *    Puntero es compatible con puentero SOLO si el segundo tipo es igual
     *                  ( puntero de enteros no lo es con puntero de reales)
     *    Conjuntos y Registos solo son compatibles si el conjunto es exactamente del mismo
     * tipo, (la cadena completa)
     *
     * @param a nodo 1 a comprobar
     * @param b nodo 2 a comprobar
     * @return si son compatibles
     */
    private boolean compatiblesTiposSemanticos(Nodo a, Nodo b) {
        // TODO: hay que completar esto, faltan tipos y comprobaciones
        // TODO: esta sin probar
        if ((a == null) || (b == null)) {
            return false;
        }

        switch (a.getTipoBasico()) {
            case BITSET:
            case BOOLEANO:
            case CARACTER:
            case CARDINAL:
            case ENTERO:
            case ENTERO_LARGO:
                return a.getTipoBasico() == b.getTipoBasico();
            case PUNTERO:
                try {
                    ArrayList<TipoSemantico> la = a.getTipoSemantico();
                    ArrayList<TipoSemantico> lb = b.getTipoSemantico();
                    return la.get(1) == lb.get(2);
                } catch (Exception e) {  // la excepcion es por si estan mal definidos.
                    return false;
                }

            default:
                return false;
        }
    }

    /**
     * Comprueba si dos nodos son operables aritmeticamente o no.
     * Solo son operables aritmeticamente los enteros y los reales.
     *
     * @param nodo1
     * @param nodo2
     * @return
     */
    private boolean sonOperablesAritmeticamente(Nodo nodo1, Nodo nodo2) {
        if (logger.isDebugEnabled()) {
            logger.debug("Entrando en sonOperablesAritmeticamente");
        }
        TipoSemantico sem1 = null;
        TipoSemantico sem2 = null;
        if (nodo1.getTipoToken() == TipoToken.IDENTIFICADOR) {
            // Si es identificador, accedemos a la tabla de símbolos
            InfoSimbolo simbNodo1 = _tablaActual.busca(nodo1.getLexema());
            if (simbNodo1 != null) {
                // Hemos encontrado el símbolo, miramos que su tipo semántico
                // sea integer o real
                sem1 = simbNodo1.getTipoBasico();
                if ((sem1 != TipoSemantico.ENTERO) ||
                        (sem1 != TipoSemantico.REAL)) {
                    StringBuilder trace = new StringBuilder();
                    trace.append("Tipo de la variable ");
                    trace.append(nodo1.getLexema());
                    trace.append(" no operable aritmeticamente");

                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico(trace.toString(), nodo1.getLinea(), nodo1.getColumna()));
                    // TODO: ¿Entero largo, real largo, etc?
                    return false;
                }
            } else {
                StringBuilder trace = new StringBuilder("Variable ");
                trace.append(nodo1.getLexema());
                trace.append(" no definida.");
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico(trace.toString(), nodo1.getLinea(), nodo1.getColumna()));
                return false;
            }
        }

        if (nodo2.getTipoToken() == TipoToken.IDENTIFICADOR) {
            // Si es identificador, accedemos a la tabla de símbolos
            InfoSimbolo simbNodo2 = _tablaActual.busca(nodo2.getLexema());
            if (simbNodo2 != null) {
                // Hemos encontrado el símbolo, miramos que su tipo semántico
                // sea integer o real
                sem2 = simbNodo2.getTipoBasico();
                if ((sem2 != TipoSemantico.ENTERO) ||
                        (sem2 != TipoSemantico.REAL)) {
                    StringBuilder trace = new StringBuilder();
                    trace.append("Tipo de la variable ");
                    trace.append(nodo2.getLexema());
                    trace.append(" no operable aritmeticamente");

                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico(trace.toString(), nodo2.getLinea(), nodo2.getColumna()));

                    // TODO: ¿Entero largo, real largo, etc?
                    return false;
                }
            } else {
                StringBuilder trace = new StringBuilder("Variable ");
                trace.append(nodo2.getLexema());
                trace.append(" no definida.");
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico(trace.toString(), nodo2.getLinea(), nodo2.getColumna()));
                return false;
            }
        }

        if (nodo1.getTipoToken() == TipoToken.NUMERO_ENTERO) {
            if (nodo2.getTipoToken() != TipoToken.NUMERO_ENTERO) {
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipos no operables aritmeticamente", nodo1.getLinea(), nodo1.getColumna()));
                return false;
            }
        }
        if (nodo1.getTipoToken() == TipoToken.NUMERO_REAL) {
            if (nodo2.getTipoToken() != TipoToken.NUMERO_REAL) {
                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipos no operables aritmeticamente", nodo1.getLinea(), nodo1.getColumna()));
                return false;
            }
        }
        // Hay 4 casos:
        //   1. Identificadores los dos
        //   2. Identificador y no identificador
        //   3. No identificador e identificador
        //   4. No identificadores los dos (ya comprobado arriba)
        if (sem1 != null && sem2 != null) {
            // Caso 1: Dos identificadores
            if (sem1 != sem2) {
                StringBuilder trace = new StringBuilder();
                trace.append("Tipos de las variables ");
                trace.append(nodo1.getLexema());
                trace.append((" y "));
                trace.append(nodo2.getLexema());
                trace.append(" no operables aritmeticamente");

                _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico(trace.toString(), nodo1.getLinea(), nodo1.getColumna()));
                return false;
            }
        } else if (sem1 != null && sem2 == null) {
            // Caso 2: Identificador y no identificador
            if (sem1 == TipoSemantico.ENTERO) {
                if (nodo2.getTipoToken() != TipoToken.NUMERO_ENTERO) {
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipos no operables aritmeticamente", nodo1.getLinea(), nodo1.getColumna()));
                    return false;
                }
            } else if (sem1 == TipoSemantico.REAL) {
                if (nodo2.getTipoToken() != TipoToken.NUMERO_REAL) {
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipos no operables aritmeticamente", nodo1.getLinea(), nodo1.getColumna()));
                    return false;
                }
            }
        } else if (sem1 == null && sem2 != null) {
            // Caso 3: No identificador e identificador
            if (sem2 == TipoSemantico.ENTERO) {
                if (nodo1.getTipoToken() != TipoToken.NUMERO_ENTERO) {
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipos no operables aritmeticamente", nodo1.getLinea(), nodo1.getColumna()));
                    return false;
                }
            } else if (sem2 == TipoSemantico.REAL) {
                if (nodo1.getTipoToken() != TipoToken.NUMERO_REAL) {
                    _gestorDeErrores.insertaErrorSemantico(new TErrorSemantico("Tipos no operables aritmeticamente", nodo1.getLinea(), nodo1.getColumna()));
                    return false;
                }
            }
        }
        // Si hemos llegado hasta aquí, es que son operables aritméticamente
        return true;
    }

    public String ultimaAccionSemantica() {
        return _ultimaAccion;
    }
}

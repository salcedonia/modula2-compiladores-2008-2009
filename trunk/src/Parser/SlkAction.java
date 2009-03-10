package Parser;

import TablaSimbolos.TablaSimbolos;
import java.util.ArrayList;

public class SlkAction {

    private TablaSimbolos _tablaDeSimbolos;
    
    public SlkAction(TablaSimbolos tabla) {
      _tablaDeSimbolos = tabla;
    }

	public void execute ( int number ){
		  switch ( number ) {
		    case 1:  unidadDeCompilacion1();  break;
		    case 2:  unidadDeCompilacion2();  break;
		    case 3:  unidadDeCompilacion3();  break;
		    case 4:  SentenciaAsignacion();  break;
		    case 5:  RestoSentenciaAsignacion();  break;
		    case 6:  RestoSentenciaRestoAsignacion();  break;
		    case 7:  Expresion();  break;
		    case 8:  SentenciaWHILE();  break;
		    case 9:  SentenciaREPEAT();  break;
		    case 10:  SentenciaLOOP();  break;
		    case 11:  SentenciaFOR();  break;
		    case 12:  SentenciaWITH();  break;
		    case 13:  SentenciaRETURN();  break;
		    case 14:  ListaDeValores();  break;
		    case 15:  vacio();  break;
		    case 16:  RestoValores();  break;
		    case 17:  RestoExpresion();  break;
		    case 18:  ExpresionSimple();  break;
		    case 19:  RestoExpresionSimple();  break;
		    case 20:  termino();  break;
		    case 21:  factor();  break;
		    case 22:  numero();  break;
		    case 23:  multiplicadorPor();  break;
		    case 24:  multiplicadorDivision();  break;
		    case 25:  multiplicadorDIV();  break;
		    case 26:  multiplicadorMOD();  break;
		    case 27:  multiplicadorAMPERSAND();  break;
		    case 28:  multiplicadorAND();  break;
		    case 29:  operdadorNOT();  break;
		    case 30:  TipFormalARRAY();  break;
		    case 31:  numEntero();  break;
		    case 32:  numReal();  break;
		    case 33:  listaElementos();  break;
		    case 34:  Elementos();  break;
		    case 35:  tipoPredefinido();  break;
		    case 36:  Identificador();  break;
		  }
		
	}

    private void Expresion() {
 	   System.out.println("---not yet implemented---");
    }

    private void ExpresionSimple() {
 	   System.out.println("---not yet implemented---");
    }

    private void ListaDeValores() {
        System.out.println("---ListaDeValores---");
    }

    private void RestoExpresion() {
 	   System.out.println("---not yet implemented---");
    }

    private void RestoExpresionSimple() {
 	   System.out.println("---not yet implemented---");
    }

    private void RestoSentenciaAsignacion() {
 	   System.out.println("---not yet implemented---");
    }

    private void RestoSentenciaRestoAsignacion() {
 	   System.out.println("---not yet implemented---");
    }

    private void RestoValores() {
        System.out.println("---RestoValores---");
    }

    private void SentenciaAsignacion() {
 	   System.out.println("---not yet implemented---");
    }

    private void SentenciaFOR() {
        System.out.println("---SentenciaFOR---");
    }

    private void SentenciaLOOP() {
        System.out.println("---SentenciaLOOP---");
    }

    private void SentenciaREPEAT() {
        System.out.println("---SentenciaREPEAT---");
    }

    private void SentenciaRETURN() {
        System.out.println("---SentenciaRETURN---");
    }

    private void SentenciaWHILE() {
        System.out.println("---SentenciaWHILE---");
        Nodo sentWHILE = new Nodo();
    }

    private void SentenciaWITH() {
        System.out.println("---SentenciaWITH---");
    }

    private void factor() {
    	   System.out.println("---not yet implemented---");
    }

    private void numEntero() {
        System.out.println("---numEntero---");
        Nodo entero = new Nodo();
        ArrayList array = entero.getArray();
        array.add("Integer");
        entero.setTipo(array);
    }

    private void numReal() {
        System.out.println("---numReal---");
        Nodo entero = new Nodo();
        ArrayList array = entero.getArray();
        array.add("Real");
        entero.setTipo(array);
    }

    private void numero() {
        System.out.println("---numero---");
        Nodo numero = new Nodo();
    }

    private void termino() {
 	   System.out.println("---not yet implemented---");
    }

    private void unidadDeCompilacion1() {
        System.out.println("---ModuloPrograma---");
    }

    private void unidadDeCompilacion2() {
        System.out.println("---ModuloDefinicion---");
    }

    private void unidadDeCompilacion3() {
        System.out.println("---ModuloImplementacion---");
    }

    private void vacio() {
        System.out.println("---Vacio---");
    }
    
    private boolean esUnico(String id){
        return _tablaDeSimbolos.esta(id);
    }

/*****************************************************************/
//REGLAS ANTONIO DE MIGUEL 
    
private void multiplicadorPor(){
    System.out.println("---regla multiplicacion POR---");
	
}
private void multiplicadorDivision(){
    System.out.println("---regla multiplicacion Division---");
	
}
private void multiplicadorDIV(){
	System.out.println("---regla multiplicacion DIV---");
}
private void multiplicadorMOD(){
	System.out.println("---regla multiplicacion MOD---");
}
private void multiplicadorAMPERSAND(){
	System.out.println("---regla multiplicacion AMPERSAND---");
}
private void multiplicadorAND(){
	System.out.println("---regla multiplicacion AND---");
}
private void operdadorNOT(){
	System.out.println("---regla NOT---");
}
private void TipFormalARRAY(){
	System.out.println("---regla tipo formal array---");
}
private void listaElementos() {
	System.out.println("---regla lista elementos---");
} 
private void Elementos() {
	System.out.println("---regla elementos---");
}
private void tipoPredefinido() {
	System.out.println("---regla tipo predefinido---");
}
private void Identificador() {
	System.out.println("---regla identificador---");
}  
//**************************************************/    
    
}
	

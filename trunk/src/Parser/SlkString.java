
package Parser;


// SlkString.java - generated by the SLK parser generator 

public class SlkString {

private static String[] Nonterminal_name ={"0"

,"UnidadDeCompilacion"
,"ModuloPrograma"
,"ModuloDefinicion"
,"ModuloImplementacion"
,"CabeceraModulo"
,"CabeceraDefinicion"
,"ListaImportados"
,"ListaExportados"
,"Prioridad"
,"Bloque"
,"DefinicionDeModulo"
,"ParteDeclarativa"
,"Declaracion"
,"DeclaracionDeConstantes"
,"AsociacionConstante"
,"DeclaracionDeTipos"
,"DefinicionDeTipo"
,"EsquemaDeTipo"
,"TipoSimple"
,"TipoEnumerado"
,"RestoDeTipo"
,"TipoConjunto"
,"TipoFormacion"
,"TipoRegistro"
,"SecuenciaDeListasDeCampos"
,"ListaDeCampos"
,"TipoPuntero"
,"TipoSubprograma"
,"ListaDeTiposFormales"
,"DeclaracionDeVariables"
,"ListaDeVariables"
,"DeclaracionSubprograma"
,"CabeceraSubprograma"
,"ParametrosFormales"
,"GrupoDeParametros"
,"DeclaracionModulo"
,"ParteEjecutiva"
,"SecuenciaDeSentencias"
,"Sentencia"
,"SentenciaAsignacion"
,"RestoSentenciaAsignacion"
,"RestoSentenciaRestoAsignacion"
,"ParteIzquierda"
,"IdentificadorOProcPredef"
,"SentenciaIF"
,"RestoSentenciaIF"
,"SentenciaCASE"
,"Caso"
,"SentenciaWHILE"
,"SentenciaREPEAT"
,"SentenciaLOOP"
,"SentenciaFOR"
,"SentenciaWITH"
,"SentenciaRETURN"
,"ListaDeValores"
,"RestoListaValores"
,"Valores"
,"RestoValores"
,"ExpresionConstante"
,"ExpresionConstanteSimple"
,"TerminoConstante"
,"FactorConstante"
,"ParametrosDeLlamada"
,"ListaDeExpresiones"
,"RestoListaDeExpresiones"
,"Expresion"
,"RestoExpresion"
,"ExpresionSimple"
,"RestoExpresionSimple"
,"Signo"
,"Termino"
,"RestoTermino"
,"Factor"
,"RestoFactor"
,"OperadorComparador"
,"OperadorSumador"
,"OperadorMultiplicador"
,"OperadorUnario"
,"TipoFormal"
,"Numero"
,"ListaDeElementos"
,"Elementos"
,"IdentificadorDeTipo"
,"TipoPredefinido"
,"ConstantePredefinida"
,"ListaDeIdentificadores"
,"RestoListaIdentificadores"
,"IdentDeProc"
,"IdentDeProcPredef"
,"LlamadaProcedimientoPredefinido"
,"LlamadaFuncionPredefinida"
,"DefinicionDeModulo_*"
,"Prioridad_opt"
,"ListaImportados_;_*"
,"ListaImportados_;_2_*"
,"ListaExportados_;_opt"
,"FROM_Identificador_opt"
,",_IdentDeProc_*"
,"QUALIFIED_opt"
,"=_EsquemaDeTipo_opt"
,"Identificador_=_EsquemaDeTipo_opt_;_*"
,"Declaracion_*"
,"AsociacionConstante_;_*"
,"DefinicionDeTipo_;_*"
,",_TipoSimple_*"
,";_ListaDeCampos_*"
,"ListaDeTiposFormales_opt"
,"VAR_opt"
,"VAR_2_opt"
,",_VAR_2_opt_TipoFormal_*"
,"VAR_opt_TipoFormal_,_VAR_2_opt_TipoFormal_*_opt"
,":_IdentificadorDeTipo_opt"
,"ListaDeVariables_;_*"
,"ParametrosFormales_opt"
,";_GrupoDeParametros_*"
,"GrupoDeParametros_;_GrupoDeParametros_*_opt"
,":_IdentificadorDeTipo_2_opt"
,"VAR_3_opt"
,"ExpresionConstante_opt"
,"ListaImportados_;_3_*"
,"ListaExportados_;_2_opt"
,"BEGIN_SecuenciaDeSentencias_opt"
,";_Sentencia_*"
,"ELSIF_Expresion_THEN_SecuenciaDeSentencias_*"
,"ELSE_SecuenciaDeSentencias_opt"
,"|_Caso_*"
,"ELSE_SecuenciaDeSentencias_2_opt"
,"BY_ExpresionConstante_opt"
,"Expresion_opt"
,"OperadorComparador_ExpresionConstanteSimple_opt"
,"OperadorSumador_TerminoConstante_*"
,"OperadorMultiplicador_FactorConstante_*"
,"ListaDeExpresiones_opt"
,"ARRAY_OF_opt"
,",_Elementos_*"
,"Elementos_,_Elementos_*_opt"
,".._ExpresionConstante_opt"
,",_Expresion_opt"
,",_Expresion_2_opt"
,",_Expresion_3_opt"
};

private static String[] Terminal_name ={"0"

,"Identificador"
,"."
,"END"
,"IMPLEMENTATION"
,"MODULE"
,";"
,"DEFINITION"
,"FROM"
,"IMPORT"
,","
,"EXPORT"
,"QUALIFIED"
,"TYPE"
,"="
,"CONST"
,"["
,".."
,"]"
,"("
,")"
,"SET"
,"OF"
,"ARRAY"
,"RECORD"
,":"
,"POINTER"
,"TO"
,"PROCEDURE"
,"VAR"
,"BEGIN"
,"EXIT"
,":="
,"^"
,"IF"
,"THEN"
,"ELSIF"
,"ELSE"
,"CASE"
,"|"
,"WHILE"
,"DO"
,"REPEAT"
,"UNTIL"
,"LOOP"
,"FOR"
,"BY"
,"WITH"
,"RETURN"
,"Cadena"
,"Caracter"
,"+"
,"-"
,"{"
,"}"
,"<>"
,"#"
,"<"
,"<="
,">"
,">="
,"IN"
,"OR"
,"*"
,"/"
,"DIV"
,"MOD"
,"&"
,"AND"
,"NOT"
,"~"
,"NumeroEntero"
,"NumeroReal"
,"BITSET"
,"BOOLEAN"
,"CARDINAL"
,"CHAR"
,"INTEGER"
,"LONGINT"
,"LONGREAL"
,"PROC"
,"REAL"
,"TRUE"
,"FALSE"
,"NIL"
,"ALLOCATE"
,"DEALLOCATE"
,"ReadInt"
,"WriteInt"
,"ReadCard"
,"WriteCard"
,"ReadChar"
,"WriteChar"
,"ReadString"
,"WriteString"
,"ReadReal"
,"WriteReal"
,"WriteLn"
,"DEC"
,"INC"
,"INCL"
,"EXCL"
,"NEW"
,"DISPOSE"
,"HALT"
,"ABS"
,"CAP"
,"ParametroChar"
,"CHR"
,"FLOAT"
,"HIGH"
,"MAX"
,"MIN"
,"ODD"
,"ORD"
,"SIZE"
,"TRUNC"
,"VAL"
,"END_OF_SLK_INPUT_"
};

private static String[] Action_name ={"0"

,"_action_unidadDeCompilacion1"
,"_action_unidadDeCompilacion2"
,"_action_unidadDeCompilacion3"
,"_action_SentenciaAsignacion"
,"_action_Identificador"
,"_action_RestoSentenciaAsignacion"
,"_action_RestoSentenciaRestoAsignacion"
,"_action_Expresion"
,"_action_SentenciaWHILE"
,"_action_SentenciaREPEAT"
,"_action_SentenciaLOOP"
,"_action_SentenciaFOR"
,"_action_SentenciaWITH"
,"_action_SentenciaRETURN"
,"_action_ListaDeValores"
,"_action_vacio"
,"_action_RestoValores"
,"_action_ExpresionSimple"
,"_action_RestoExpresion"
,"_action_Signo"
,"_action_RestoExpresionSimple"
,"_action_OperadorSumador"
,"_action_termino"
,"_action_factor"
,"_action_numero"
,"_action_numEntero"
,"_action_numReal"
};

private static String[] Production_name ={"0"

,"UnidadDeCompilacion --> ModuloPrograma _action_unidadDeCompilacion1"
,"UnidadDeCompilacion --> ModuloDefinicion _action_unidadDeCompilacion2"
,"UnidadDeCompilacion --> ModuloImplementacion _action_unidadDeCompilacion3"
,"ModuloPrograma --> CabeceraModulo Bloque Identificador ."
,"ModuloDefinicion --> CabeceraDefinicion DefinicionDeModulo_* END Identificador ."
,"ModuloImplementacion --> IMPLEMENTATION ModuloPrograma"
,"CabeceraModulo --> MODULE Identificador Prioridad_opt ; ListaImportados_;_*"
,"CabeceraDefinicion --> DEFINITION MODULE Identificador ; ListaImportados_;_2_* ListaExportados_;_opt"
,"ListaImportados --> FROM_Identificador_opt IMPORT IdentDeProc ,_IdentDeProc_*"
,"ListaExportados --> EXPORT QUALIFIED_opt ListaDeIdentificadores"
,"Prioridad --> ExpresionConstante"
,"Bloque --> ParteDeclarativa ParteEjecutiva END"
,"DefinicionDeModulo --> DeclaracionDeConstantes"
,"DefinicionDeModulo --> TYPE Identificador_=_EsquemaDeTipo_opt_;_*"
,"DefinicionDeModulo --> DeclaracionDeVariables"
,"DefinicionDeModulo --> CabeceraSubprograma ;"
,"ParteDeclarativa --> Declaracion_*"
,"Declaracion --> DeclaracionDeConstantes"
,"Declaracion --> DeclaracionDeTipos"
,"Declaracion --> DeclaracionDeVariables"
,"Declaracion --> DeclaracionSubprograma"
,"Declaracion --> DeclaracionModulo"
,"DeclaracionDeConstantes --> CONST AsociacionConstante_;_*"
,"AsociacionConstante --> Identificador = ExpresionConstante"
,"DeclaracionDeTipos --> TYPE DefinicionDeTipo_;_*"
,"DefinicionDeTipo --> Identificador = EsquemaDeTipo"
,"EsquemaDeTipo --> TipoSimple"
,"EsquemaDeTipo --> TipoConjunto"
,"EsquemaDeTipo --> TipoFormacion"
,"EsquemaDeTipo --> TipoRegistro"
,"EsquemaDeTipo --> TipoPuntero"
,"EsquemaDeTipo --> TipoSubprograma"
,"TipoSimple --> TipoEnumerado"
,"TipoSimple --> IdentificadorDeTipo RestoDeTipo"
,"TipoSimple --> [ ExpresionConstante .. ExpresionConstante ]"
,"TipoEnumerado --> ( ListaDeIdentificadores )"
,"RestoDeTipo -->"
,"RestoDeTipo --> [ ExpresionConstante .. ExpresionConstante ]"
,"TipoConjunto --> SET OF TipoSimple"
,"TipoFormacion --> ARRAY TipoSimple ,_TipoSimple_* OF EsquemaDeTipo"
,"TipoRegistro --> RECORD SecuenciaDeListasDeCampos END"
,"SecuenciaDeListasDeCampos --> ListaDeCampos ;_ListaDeCampos_*"
,"ListaDeCampos -->"
,"ListaDeCampos --> ListaDeIdentificadores : EsquemaDeTipo"
,"TipoPuntero --> POINTER TO EsquemaDeTipo"
,"TipoSubprograma --> PROCEDURE ListaDeTiposFormales_opt"
,"ListaDeTiposFormales --> ( VAR_opt_TipoFormal_,_VAR_2_opt_TipoFormal_*_opt ) :_IdentificadorDeTipo_opt"
,"DeclaracionDeVariables --> VAR ListaDeVariables_;_*"
,"ListaDeVariables --> ListaDeIdentificadores : EsquemaDeTipo"
,"DeclaracionSubprograma --> CabeceraSubprograma ; Bloque Identificador ;"
,"CabeceraSubprograma --> PROCEDURE Identificador ParametrosFormales_opt"
,"ParametrosFormales --> ( GrupoDeParametros_;_GrupoDeParametros_*_opt ) :_IdentificadorDeTipo_2_opt"
,"GrupoDeParametros --> VAR_3_opt ListaDeIdentificadores : TipoFormal"
,"DeclaracionModulo --> MODULE Identificador ExpresionConstante_opt ; ListaImportados_;_3_* ListaExportados_;_2_opt Bloque Identificador ;"
,"ParteEjecutiva --> BEGIN_SecuenciaDeSentencias_opt"
,"SecuenciaDeSentencias --> Sentencia ;_Sentencia_*"
,"Sentencia -->"
,"Sentencia --> SentenciaAsignacion _action_SentenciaAsignacion"
,"Sentencia --> SentenciaIF"
,"Sentencia --> SentenciaCASE"
,"Sentencia --> SentenciaWHILE"
,"Sentencia --> SentenciaREPEAT"
,"Sentencia --> SentenciaLOOP"
,"Sentencia --> SentenciaFOR"
,"Sentencia --> SentenciaWITH"
,"Sentencia --> LlamadaProcedimientoPredefinido"
,"Sentencia --> SentenciaRETURN"
,"Sentencia --> EXIT"
,"SentenciaAsignacion --> Identificador _action_Identificador RestoSentenciaAsignacion _action_RestoSentenciaAsignacion"
,"RestoSentenciaAsignacion --> ParteIzquierda RestoSentenciaRestoAsignacion _action_RestoSentenciaRestoAsignacion"
,"RestoSentenciaRestoAsignacion -->"
,"RestoSentenciaRestoAsignacion --> := Expresion _action_Expresion"
,"RestoSentenciaRestoAsignacion --> ParametrosDeLlamada"
,"ParteIzquierda -->"
,"ParteIzquierda --> [ ListaDeExpresiones ] ParteIzquierda"
,"ParteIzquierda --> . IdentificadorOProcPredef ParteIzquierda"
,"ParteIzquierda --> ^ ParteIzquierda"
,"IdentificadorOProcPredef --> Identificador"
,"IdentificadorOProcPredef --> LlamadaProcedimientoPredefinido"
,"SentenciaIF --> IF Expresion THEN SecuenciaDeSentencias RestoSentenciaIF END"
,"RestoSentenciaIF --> ELSIF_Expresion_THEN_SecuenciaDeSentencias_* ELSE_SecuenciaDeSentencias_opt"
,"SentenciaCASE --> CASE Expresion OF Caso |_Caso_* ELSE_SecuenciaDeSentencias_2_opt END"
,"Caso --> ListaDeValores : SecuenciaDeSentencias"
,"SentenciaWHILE --> WHILE Expresion DO SecuenciaDeSentencias END _action_SentenciaWHILE"
,"SentenciaREPEAT --> REPEAT SecuenciaDeSentencias UNTIL Expresion _action_SentenciaREPEAT"
,"SentenciaLOOP --> LOOP SecuenciaDeSentencias END _action_SentenciaLOOP"
,"SentenciaFOR --> FOR Identificador := Expresion TO Expresion BY_ExpresionConstante_opt DO SecuenciaDeSentencias END _action_SentenciaFOR"
,"SentenciaWITH --> WITH Identificador ParteIzquierda DO SecuenciaDeSentencias END _action_SentenciaWITH"
,"SentenciaRETURN --> RETURN Expresion_opt"
,"ListaDeValores --> Valores RestoListaValores _action_ListaDeValores"
,"RestoListaValores --> _action_vacio"
,"RestoListaValores --> , Valores RestoListaValores _action_RestoValores"
,"Valores --> ExpresionConstante RestoValores"
,"RestoValores -->"
,"RestoValores --> .. ExpresionConstante"
,"ExpresionConstante --> ExpresionConstanteSimple OperadorComparador_ExpresionConstanteSimple_opt"
,"ExpresionConstanteSimple --> Signo TerminoConstante OperadorSumador_TerminoConstante_*"
,"TerminoConstante --> FactorConstante OperadorMultiplicador_FactorConstante_*"
,"FactorConstante --> Identificador"
,"FactorConstante --> ConstantePredefinida"
,"FactorConstante --> Numero"
,"FactorConstante --> Cadena"
,"FactorConstante --> Caracter"
,"FactorConstante --> ( ExpresionConstante )"
,"FactorConstante --> OperadorUnario FactorConstante"
,"ParametrosDeLlamada --> ( ListaDeExpresiones_opt )"
,"ListaDeExpresiones --> Expresion RestoListaDeExpresiones"
,"RestoListaDeExpresiones -->"
,"RestoListaDeExpresiones --> , Expresion _action_Expresion RestoListaDeExpresiones"
,"Expresion --> ExpresionSimple _action_ExpresionSimple RestoExpresion _action_RestoExpresion"
,"RestoExpresion -->"
,"RestoExpresion --> OperadorComparador ExpresionSimple _action_ExpresionSimple"
,"ExpresionSimple --> Signo _action_Signo Termino RestoExpresionSimple _action_RestoExpresionSimple"
,"RestoExpresionSimple -->"
,"RestoExpresionSimple --> OperadorSumador _action_OperadorSumador Termino _action_termino RestoExpresionSimple"
,"Signo -->"
,"Signo --> +"
,"Signo --> -"
,"Termino --> Factor _action_factor RestoTermino"
,"RestoTermino -->"
,"RestoTermino --> OperadorMultiplicador Factor RestoTermino"
,"Factor --> Identificador RestoFactor"
,"Factor --> ConstantePredefinida"
,"Factor --> Numero _action_numero"
,"Factor --> TipoPredefinido { ListaDeElementos }"
,"Factor --> Cadena"
,"Factor --> Caracter"
,"Factor --> ( Expresion )"
,"Factor --> OperadorUnario Factor"
,"Factor --> LlamadaFuncionPredefinida"
,"RestoFactor --> { ListaDeElementos }"
,"RestoFactor --> ParametrosDeLlamada"
,"RestoFactor --> ParteIzquierda"
,"OperadorComparador --> ="
,"OperadorComparador --> <>"
,"OperadorComparador --> #"
,"OperadorComparador --> <"
,"OperadorComparador --> <="
,"OperadorComparador --> >"
,"OperadorComparador --> >="
,"OperadorComparador --> IN"
,"OperadorSumador --> +"
,"OperadorSumador --> -"
,"OperadorSumador --> OR"
,"OperadorMultiplicador --> *"
,"OperadorMultiplicador --> /"
,"OperadorMultiplicador --> DIV"
,"OperadorMultiplicador --> MOD"
,"OperadorMultiplicador --> &"
,"OperadorMultiplicador --> AND"
,"OperadorUnario --> NOT"
,"OperadorUnario --> ~"
,"TipoFormal --> ARRAY_OF_opt IdentificadorDeTipo"
,"Numero --> NumeroEntero _action_numEntero"
,"Numero --> NumeroReal _action_numReal"
,"ListaDeElementos --> Elementos_,_Elementos_*_opt"
,"Elementos --> ExpresionConstante .._ExpresionConstante_opt"
,"IdentificadorDeTipo --> TipoPredefinido"
,"IdentificadorDeTipo --> Identificador"
,"TipoPredefinido --> BITSET"
,"TipoPredefinido --> BOOLEAN"
,"TipoPredefinido --> CARDINAL"
,"TipoPredefinido --> CHAR"
,"TipoPredefinido --> INTEGER"
,"TipoPredefinido --> LONGINT"
,"TipoPredefinido --> LONGREAL"
,"TipoPredefinido --> PROC"
,"TipoPredefinido --> REAL"
,"ConstantePredefinida --> TRUE"
,"ConstantePredefinida --> FALSE"
,"ConstantePredefinida --> NIL"
,"ListaDeIdentificadores --> Identificador RestoListaIdentificadores"
,"RestoListaIdentificadores -->"
,"RestoListaIdentificadores --> , Identificador RestoListaIdentificadores"
,"IdentDeProc --> Identificador"
,"IdentDeProc --> IdentDeProcPredef"
,"IdentDeProcPredef --> ALLOCATE"
,"IdentDeProcPredef --> DEALLOCATE"
,"IdentDeProcPredef --> ReadInt"
,"IdentDeProcPredef --> WriteInt"
,"IdentDeProcPredef --> ReadCard"
,"IdentDeProcPredef --> WriteCard"
,"IdentDeProcPredef --> ReadChar"
,"IdentDeProcPredef --> WriteChar"
,"IdentDeProcPredef --> ReadString"
,"IdentDeProcPredef --> WriteString"
,"IdentDeProcPredef --> ReadReal"
,"IdentDeProcPredef --> WriteReal"
,"IdentDeProcPredef --> WriteLn"
,"LlamadaProcedimientoPredefinido --> DEC ( Expresion ,_Expresion_opt )"
,"LlamadaProcedimientoPredefinido --> INC ( Expresion ,_Expresion_2_opt )"
,"LlamadaProcedimientoPredefinido --> INCL ( Expresion , Expresion )"
,"LlamadaProcedimientoPredefinido --> EXCL ( Expresion , Expresion )"
,"LlamadaProcedimientoPredefinido --> NEW ( Expresion )"
,"LlamadaProcedimientoPredefinido --> DISPOSE ( Expresion )"
,"LlamadaProcedimientoPredefinido --> ReadInt ( Expresion )"
,"LlamadaProcedimientoPredefinido --> WriteInt ( Expresion , Expresion )"
,"LlamadaProcedimientoPredefinido --> ReadCard ( Expresion )"
,"LlamadaProcedimientoPredefinido --> WriteCard ( Expresion , Expresion )"
,"LlamadaProcedimientoPredefinido --> ReadChar ( Expresion )"
,"LlamadaProcedimientoPredefinido --> WriteChar ( Expresion )"
,"LlamadaProcedimientoPredefinido --> ReadString ( Expresion )"
,"LlamadaProcedimientoPredefinido --> WriteString ( Expresion )"
,"LlamadaProcedimientoPredefinido --> ReadReal ( Expresion )"
,"LlamadaProcedimientoPredefinido --> WriteReal ( Expresion , Expresion ,_Expresion_3_opt )"
,"LlamadaProcedimientoPredefinido --> WriteLn"
,"LlamadaProcedimientoPredefinido --> HALT"
,"LlamadaFuncionPredefinida --> ABS ( Expresion )"
,"LlamadaFuncionPredefinida --> CAP ( ParametroChar )"
,"LlamadaFuncionPredefinida --> CHR ( Expresion )"
,"LlamadaFuncionPredefinida --> FLOAT ( Expresion )"
,"LlamadaFuncionPredefinida --> HIGH ( Expresion )"
,"LlamadaFuncionPredefinida --> MAX ( IdentificadorDeTipo )"
,"LlamadaFuncionPredefinida --> MIN ( IdentificadorDeTipo )"
,"LlamadaFuncionPredefinida --> ODD ( Expresion )"
,"LlamadaFuncionPredefinida --> ORD ( Expresion )"
,"LlamadaFuncionPredefinida --> SIZE ( IdentificadorDeTipo )"
,"LlamadaFuncionPredefinida --> TRUNC ( Expresion )"
,"LlamadaFuncionPredefinida --> VAL ( IdentificadorDeTipo , Expresion )"
,"DefinicionDeModulo_* --> DefinicionDeModulo DefinicionDeModulo_*"
,"DefinicionDeModulo_* -->"
,"Prioridad_opt --> Prioridad"
,"Prioridad_opt -->"
,"ListaImportados_;_* --> ListaImportados ; ListaImportados_;_*"
,"ListaImportados_;_* -->"
,"ListaImportados_;_2_* --> ListaImportados ; ListaImportados_;_2_*"
,"ListaImportados_;_2_* -->"
,"ListaExportados_;_opt --> ListaExportados ;"
,"ListaExportados_;_opt -->"
,"FROM_Identificador_opt --> FROM Identificador"
,"FROM_Identificador_opt -->"
,",_IdentDeProc_* --> , IdentDeProc ,_IdentDeProc_*"
,",_IdentDeProc_* -->"
,"QUALIFIED_opt --> QUALIFIED"
,"QUALIFIED_opt -->"
,"=_EsquemaDeTipo_opt --> = EsquemaDeTipo"
,"=_EsquemaDeTipo_opt -->"
,"Identificador_=_EsquemaDeTipo_opt_;_* --> Identificador =_EsquemaDeTipo_opt ; Identificador_=_EsquemaDeTipo_opt_;_*"
,"Identificador_=_EsquemaDeTipo_opt_;_* -->"
,"Declaracion_* --> Declaracion Declaracion_*"
,"Declaracion_* -->"
,"AsociacionConstante_;_* --> AsociacionConstante ; AsociacionConstante_;_*"
,"AsociacionConstante_;_* -->"
,"DefinicionDeTipo_;_* --> DefinicionDeTipo ; DefinicionDeTipo_;_*"
,"DefinicionDeTipo_;_* -->"
,",_TipoSimple_* --> , TipoSimple ,_TipoSimple_*"
,",_TipoSimple_* -->"
,";_ListaDeCampos_* --> ; ListaDeCampos ;_ListaDeCampos_*"
,";_ListaDeCampos_* -->"
,"ListaDeTiposFormales_opt --> ListaDeTiposFormales"
,"ListaDeTiposFormales_opt -->"
,"VAR_opt --> VAR"
,"VAR_opt -->"
,"VAR_2_opt --> VAR"
,"VAR_2_opt -->"
,",_VAR_2_opt_TipoFormal_* --> , VAR_2_opt TipoFormal ,_VAR_2_opt_TipoFormal_*"
,",_VAR_2_opt_TipoFormal_* -->"
,"VAR_opt_TipoFormal_,_VAR_2_opt_TipoFormal_*_opt --> VAR_opt TipoFormal ,_VAR_2_opt_TipoFormal_*"
,"VAR_opt_TipoFormal_,_VAR_2_opt_TipoFormal_*_opt -->"
,":_IdentificadorDeTipo_opt --> : IdentificadorDeTipo"
,":_IdentificadorDeTipo_opt -->"
,"ListaDeVariables_;_* --> ListaDeVariables ; ListaDeVariables_;_*"
,"ListaDeVariables_;_* -->"
,"ParametrosFormales_opt --> ParametrosFormales"
,"ParametrosFormales_opt -->"
,";_GrupoDeParametros_* --> ; GrupoDeParametros ;_GrupoDeParametros_*"
,";_GrupoDeParametros_* -->"
,"GrupoDeParametros_;_GrupoDeParametros_*_opt --> GrupoDeParametros ;_GrupoDeParametros_*"
,"GrupoDeParametros_;_GrupoDeParametros_*_opt -->"
,":_IdentificadorDeTipo_2_opt --> : IdentificadorDeTipo"
,":_IdentificadorDeTipo_2_opt -->"
,"VAR_3_opt --> VAR"
,"VAR_3_opt -->"
,"ExpresionConstante_opt --> ExpresionConstante"
,"ExpresionConstante_opt -->"
,"ListaImportados_;_3_* --> ListaImportados ; ListaImportados_;_3_*"
,"ListaImportados_;_3_* -->"
,"ListaExportados_;_2_opt --> ListaExportados ;"
,"ListaExportados_;_2_opt -->"
,"BEGIN_SecuenciaDeSentencias_opt --> BEGIN SecuenciaDeSentencias"
,"BEGIN_SecuenciaDeSentencias_opt -->"
,";_Sentencia_* --> ; Sentencia ;_Sentencia_*"
,";_Sentencia_* -->"
,"ELSIF_Expresion_THEN_SecuenciaDeSentencias_* --> ELSIF Expresion THEN SecuenciaDeSentencias ELSIF_Expresion_THEN_SecuenciaDeSentencias_*"
,"ELSIF_Expresion_THEN_SecuenciaDeSentencias_* -->"
,"ELSE_SecuenciaDeSentencias_opt --> ELSE SecuenciaDeSentencias"
,"ELSE_SecuenciaDeSentencias_opt -->"
,"|_Caso_* --> | Caso |_Caso_*"
,"|_Caso_* -->"
,"ELSE_SecuenciaDeSentencias_2_opt --> ELSE SecuenciaDeSentencias"
,"ELSE_SecuenciaDeSentencias_2_opt -->"
,"BY_ExpresionConstante_opt --> BY ExpresionConstante"
,"BY_ExpresionConstante_opt -->"
,"Expresion_opt --> Expresion"
,"Expresion_opt --> _action_SentenciaRETURN"
,"OperadorComparador_ExpresionConstanteSimple_opt --> OperadorComparador ExpresionConstanteSimple"
,"OperadorComparador_ExpresionConstanteSimple_opt -->"
,"OperadorSumador_TerminoConstante_* --> OperadorSumador TerminoConstante OperadorSumador_TerminoConstante_*"
,"OperadorSumador_TerminoConstante_* -->"
,"OperadorMultiplicador_FactorConstante_* --> OperadorMultiplicador FactorConstante OperadorMultiplicador_FactorConstante_*"
,"OperadorMultiplicador_FactorConstante_* -->"
,"ListaDeExpresiones_opt --> ListaDeExpresiones"
,"ListaDeExpresiones_opt -->"
,"ARRAY_OF_opt --> ARRAY OF"
,"ARRAY_OF_opt -->"
,",_Elementos_* --> , Elementos ,_Elementos_*"
,",_Elementos_* -->"
,"Elementos_,_Elementos_*_opt --> Elementos ,_Elementos_*"
,"Elementos_,_Elementos_*_opt -->"
,".._ExpresionConstante_opt --> .. ExpresionConstante"
,".._ExpresionConstante_opt -->"
,",_Expresion_opt --> , Expresion"
,",_Expresion_opt -->"
,",_Expresion_2_opt --> , Expresion"
,",_Expresion_2_opt -->"
,",_Expresion_3_opt --> , Expresion"
,",_Expresion_3_opt -->"
};

private static final short   START_SYMBOL = 2049;

public static String  GetSymbolName ( short symbol )
{
  if ( symbol >= START_SYMBOL ) {
      return ( Nonterminal_name [symbol - (START_SYMBOL-1)] );
  } else if ( symbol > 0 ) {
      return ( Terminal_name [ SlkParser.GetTerminalIndex ( symbol ) ] );
  } else {
      return ( Action_name [ -symbol ] );
  }
}

public static String  GetProductionName ( short production_number )
{
  return ( Production_name [production_number] );
}


};
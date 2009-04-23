package gui;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import tabla_de_simbolos.TablaDeSimbolos;
import tabla_de_simbolos.simbolo.InfoSimbolo;

/**
 * Ventana de utilidad para ver la tabla de simbolos.
 * 
 * @author Grupo 3, Javier Salcedo Gomez
 */
public class VentanaTablaDeSimbolos extends javax.swing.JFrame {

    /**
     * Tabla de simbolos de la aplicación.
     */
    private TablaDeSimbolos _tablaDeSimbolos;
    /** Constante que contiene el mensaje inicial que se introduce en el ambito actual*/
    private static final String AMBITO_ACTUAL = "Ambito actual";

    /**
     * Constructor de la clase VentanaTablaDeSimbolos.
     * 
     * @param tabla Tabla de simbolos asociada.
     */
    public VentanaTablaDeSimbolos(TablaDeSimbolos tabla) {

        initComponents();

        _tablaDeSimbolos = tabla;

        //Compruebo que estoy en la tabla global
        if (!_tablaDeSimbolos.esTablaGlobal()) {
            //Voy a la raiz de las tablas
            while (_tablaDeSimbolos.cerrarAmbito() != null) {
            }
        }

        // Actualizamos el nombre de la tabla
        _lblNombreTabla.setText(_lblNombreTabla.getText() + _tablaDeSimbolos.getNombre());

        // Le pedimos a la tabla de simbolos que nos muestre los simbolos
        _txtAmbitoActual.setText(contenidoTabla());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _panelAmbitoActual = new javax.swing.JPanel();
        _btnAmbitoInferior = new javax.swing.JButton();
        _btnAmbitoSuperior = new javax.swing.JButton();
        _lblNombreTabla = new javax.swing.JLabel();
        _scrollPaneAmbitoActual = new javax.swing.JScrollPane();
        _txtAmbitoActual = new javax.swing.JTextArea();
        _panelAmbitoInferior = new javax.swing.JPanel();
        _scrollPaneAmbitoInferior = new javax.swing.JScrollPane();
        _txtVariablesVisibles = new javax.swing.JTextArea();
        _barraDeMenu = new javax.swing.JMenuBar();
        _menuInsertarSimbolo = new javax.swing.JMenu();
        _opcionIdentificador = new javax.swing.JMenuItem();
        _opcionModulo = new javax.swing.JMenuItem();
        _opcionSubprograma = new javax.swing.JMenuItem();
        _opcionCerrar = new javax.swing.JMenuItem();

        setTitle("Tabla Símbolos");

        _panelAmbitoActual.setBorder(javax.swing.BorderFactory.createTitledBorder("Ambito Actual"));

        _btnAmbitoInferior.setText("Ambito Inferior");
        _btnAmbitoInferior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnAmbitoInferiorActionPerformed(evt);
            }
        });

        _btnAmbitoSuperior.setText("Ambito Superior");
        _btnAmbitoSuperior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnAmbitoSuperiorActionPerformed(evt);
            }
        });

        _lblNombreTabla.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        _lblNombreTabla.setText("Nombre de tabla: ");

        _txtAmbitoActual.setColumns(20);
        _txtAmbitoActual.setEditable(false);
        _txtAmbitoActual.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        _txtAmbitoActual.setRows(5);
        _scrollPaneAmbitoActual.setViewportView(_txtAmbitoActual);

        org.jdesktop.layout.GroupLayout _panelAmbitoActualLayout = new org.jdesktop.layout.GroupLayout(_panelAmbitoActual);
        _panelAmbitoActual.setLayout(_panelAmbitoActualLayout);
        _panelAmbitoActualLayout.setHorizontalGroup(
            _panelAmbitoActualLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(_panelAmbitoActualLayout.createSequentialGroup()
                .addContainerGap()
                .add(_panelAmbitoActualLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(_scrollPaneAmbitoActual, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                    .add(_panelAmbitoActualLayout.createSequentialGroup()
                        .add(_btnAmbitoSuperior)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 371, Short.MAX_VALUE)
                        .add(_btnAmbitoInferior))
                    .add(_lblNombreTabla))
                .addContainerGap())
        );
        _panelAmbitoActualLayout.setVerticalGroup(
            _panelAmbitoActualLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, _panelAmbitoActualLayout.createSequentialGroup()
                .addContainerGap()
                .add(_lblNombreTabla)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(_scrollPaneAmbitoActual, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(_panelAmbitoActualLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(_btnAmbitoInferior)
                    .add(_btnAmbitoSuperior))
                .addContainerGap())
        );

        _panelAmbitoInferior.setBorder(javax.swing.BorderFactory.createTitledBorder("Variables Visibles en Ambitos Superiores"));

        _txtVariablesVisibles.setColumns(20);
        _txtVariablesVisibles.setEditable(false);
        _txtVariablesVisibles.setFont(new java.awt.Font("Courier New", 0, 12));
        _txtVariablesVisibles.setRows(5);
        _scrollPaneAmbitoInferior.setViewportView(_txtVariablesVisibles);

        org.jdesktop.layout.GroupLayout _panelAmbitoInferiorLayout = new org.jdesktop.layout.GroupLayout(_panelAmbitoInferior);
        _panelAmbitoInferior.setLayout(_panelAmbitoInferiorLayout);
        _panelAmbitoInferiorLayout.setHorizontalGroup(
            _panelAmbitoInferiorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 609, Short.MAX_VALUE)
            .add(_panelAmbitoInferiorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(_panelAmbitoInferiorLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(_scrollPaneAmbitoInferior, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        _panelAmbitoInferiorLayout.setVerticalGroup(
            _panelAmbitoInferiorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 179, Short.MAX_VALUE)
            .add(_panelAmbitoInferiorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(_panelAmbitoInferiorLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(_scrollPaneAmbitoInferior, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        _menuInsertarSimbolo.setText("Insertar Simbolo");

        _opcionIdentificador.setText("Identificador");
        _opcionIdentificador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _opcionIdentificadorActionPerformed(evt);
            }
        });
        _menuInsertarSimbolo.add(_opcionIdentificador);

        _opcionModulo.setText("Modulo");
        _opcionModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _opcionModuloActionPerformed(evt);
            }
        });
        _menuInsertarSimbolo.add(_opcionModulo);

        _opcionSubprograma.setText("Subprograma");
        _opcionSubprograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _opcionSubprogramaActionPerformed(evt);
            }
        });
        _menuInsertarSimbolo.add(_opcionSubprograma);

        _opcionCerrar.setText("Cerrar");
        _opcionCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _opcionCerrarActionPerformed(evt);
            }
        });
        _menuInsertarSimbolo.add(_opcionCerrar);

        _barraDeMenu.add(_menuInsertarSimbolo);

        setJMenuBar(_barraDeMenu);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(_panelAmbitoActual, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(_panelAmbitoInferior, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(_panelAmbitoActual, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(_panelAmbitoInferior, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void _btnAmbitoSuperiorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnAmbitoSuperiorActionPerformed
    /*
    TablaDeSimbolos continente = _tablaDeSimbolos.get_continente();
    ArrayList<TablaDeSimbolos> contenido = _tablaDeSimbolos.get_contenido();
    
    if (_tablaDeSimbolos.esTablaGlobal()) {
    
    JOptionPane.showMessageDialog(this, "No puedes acceder a un ambito superior", "Estas en el ambito principal", JOptionPane.INFORMATION_MESSAGE);        
    } else { 
    
    _tablaDeSimbolos = _tablaDeSimbolos.get_continente();
    //_txtContenidoTabla.setText(_tablaDeSimbolos.contenidoTabla());
    
    if (_tablaDeSimbolos.esTablaGlobal())
    _txtVariablesVisibles.setText("Estamos en la tabla raiz");
    else{
    
    if (_tablaDeSimbolos.get_continente() != null) {
    _txtVariablesVisibles.setText(_tablaDeSimbolos.get_continente().getVariablesVisibles(_tablaDeSimbolos.get_nombre()));
    } else {
    _txtVariablesVisibles.setText("No tiene variables accesibles encima");
    }
    }  
    
    JOptionPane.showMessageDialog(this, "Has entrado a la tabla del procedimiento/modulo  " + _tablaDeSimbolos.get_nombre(), "Info", JOptionPane.INFORMATION_MESSAGE);
    }*/
    if (_tablaDeSimbolos.esTablaGlobal()) {
        JOptionPane.showMessageDialog(this, "No puedes acceder a un ambito superior", "Estas en el ambito principal", JOptionPane.INFORMATION_MESSAGE);
    } else {
        _tablaDeSimbolos = _tablaDeSimbolos.cerrarAmbito();
        // Actualizamos el nombre de la tabla
        _lblNombreTabla.setText(AMBITO_ACTUAL + " " + _tablaDeSimbolos.getNombre());

        // Le pedimos a la tabla de simbolos que nos muestre los simbolos
        _txtAmbitoActual.setText(contenidoTabla());
        //obtengo las variables visibles desde el ambito al que accedemos
        _txtVariablesVisibles.setText(variablesVisibles(_tablaDeSimbolos));
    }

}//GEN-LAST:event__btnAmbitoSuperiorActionPerformed

    /**
     * Metodo que recorre el arbol de tablas de simbolos y te devuelve la tabla de simbolos
     * que corresponde con el nombre introducido
     * @param nomAmbito Nombre de la tabla de simbolos a la que se quiere acceder
     * @param actual Tabla de simbolos actual
     * @return Tabla de simbolos que corresponde al nombre introducido. Si la tabla
     * con el nombre introducido no existe se devolvera null.
     */
    private TablaDeSimbolos accederAmbitoInferior(String nomAmbito, TablaDeSimbolos actual) {
        if (nomAmbito.equals(actual.getNombre())) {
            return actual;
        } else {
            for (Iterator it = actual.getContenido().iterator(); it.hasNext();) {
                TablaDeSimbolos tablaInferior = (TablaDeSimbolos) it.next();
                if (tablaInferior.getNombre().equals(nomAmbito)) {
                    return tablaInferior;
                }
            }
        }
        return null;
    }

private void _btnAmbitoInferiorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnAmbitoInferiorActionPerformed
    String ambito = JOptionPane.showInputDialog(null,
            "Inserte el nombre del ámbito al que quiere acceder", "Nombre del ámbito", JOptionPane.QUESTION_MESSAGE);
    if (ambito != null) {
        TablaDeSimbolos tablaInferior = accederAmbitoInferior(ambito, _tablaDeSimbolos);
        if (tablaInferior != null) {
            _tablaDeSimbolos = tablaInferior;

            // Actualizamos el nombre de la tabla
            _lblNombreTabla.setText(AMBITO_ACTUAL + " " + _tablaDeSimbolos.getNombre());

            // Le pedimos a la tabla de simbolos que nos muestre los simbolos
            _txtAmbitoActual.setText(contenidoTabla());

            //obtengo las variables visibles desde el ambito al que accedemos
            _txtVariablesVisibles.setText(variablesVisibles(_tablaDeSimbolos));
        } else {
            JOptionPane.showMessageDialog(this, "No puedes acceder al ambito inferior introducido", "No puedes acceder al ambito inferior introducido", JOptionPane.ERROR_MESSAGE);
        }
    }
}//GEN-LAST:event__btnAmbitoInferiorActionPerformed

private void _opcionIdentificadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__opcionIdentificadorActionPerformed
//    if (_tablaDeSimbolos != null) {
//
//        String contenido = JOptionPane.showInputDialog(this,
//                "Inserte el nombre del identificador", "Nombre del identificador", JOptionPane.QUESTION_MESSAGE);
//        if (contenido != null) {
//            _tablaDeSimbolos.inserta(contenido);
//        }
//    } else
//        JOptionPane.showMessageDialog(this, "Modulo padre no creado", "Error", JOptionPane.ERROR_MESSAGE);
}//GEN-LAST:event__opcionIdentificadorActionPerformed

private void _opcionSubprogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__opcionSubprogramaActionPerformed
//    if (_tablaDeSimbolos != null) {
//
//        String contenido = JOptionPane.showInputDialog(this,
//                "Inserte el nombre del Subprograma", "Nombre del procedure", JOptionPane.QUESTION_MESSAGE);
//    } else
//        JOptionPane.showMessageDialog(this, "Modulo padre no creado", "Error", JOptionPane.ERROR_MESSAGE);
}//GEN-LAST:event__opcionSubprogramaActionPerformed

private void _opcionCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__opcionCerrarActionPerformed
//    if (_tablaDeSimbolos != null) {
//
//        if (_tablaDeSimbolos.getContinente() == null && _tablaDeSimbolos.getModPadre() == null) {
//            JOptionPane.showMessageDialog(this, "Estas en la raiz", "Error", JOptionPane.ERROR_MESSAGE);
//        } else if (_tablaDeSimbolos.getContinente() != null) // caso en el que estuvieramos en un procedimiento
//        {
//            _tablaDeSimbolos = _tablaDeSimbolos.getContinente();
//        } else // caso en el que estuvieramos en un modulo
//        {
//            _tablaDeSimbolos = _tablaDeSimbolos.getModPadre();
//        }
//    } else
//        JOptionPane.showMessageDialog(this, "Modulo padre no creado", "Error", JOptionPane.ERROR_MESSAGE);
}//GEN-LAST:event__opcionCerrarActionPerformed

private void _opcionModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__opcionModuloActionPerformed
//// TODO add your handling code here:
//
//    String contenido = JOptionPane.showInputDialog(this,
//            "Inserte el nombre del modulo", "Nombre del modulo", JOptionPane.QUESTION_MESSAGE);
//    int importadas = JOptionPane.showConfirmDialog(this, "Desea incluir variables importadas");
//
//    if (contenido != null) {
//
//        if (_tablaDeSimbolos == null) {
//            _tablaDeSimbolos = new TablaSimbolos(contenido, null, null);
//        }
//    }
//    if (importadas == 0) {
//
//        boolean continuar = true;
//
//        while (true) {
//
//            contenido = JOptionPane.showInputDialog(this,
//                    "Inserte el nombre de la variable a importar", "Nombre de la variable", JOptionPane.QUESTION_MESSAGE);
//            if (contenido != null) {
//
//                // Comprobamos que no sea el modulo padre
//                if (_tablaDeSimbolos.getContinente() != null || _tablaDeSimbolos.getModPadre() != null) {
//
//                    if (_tablaDeSimbolos.getModPadre().estaIdentificadorDefinido(contenido)) {
//                        _tablaDeSimbolos.inserta(contenido);
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Error", "Variable no declarada", JOptionPane.ERROR_MESSAGE);
//                    }
//                } else//es el modulo padre insertamos la variable sin mas
//                {
//                    _tablaDeSimbolos.inserta(contenido);
//                }
//            } else //salimos del bucle
//            {
//                break;
//            }
//        }
//    }
//
//    int exportadas = JOptionPane.showConfirmDialog(this, "Desea incluir variables exportadas");
//
//    if (exportadas == 0) {
//
//        while (true) {
//            contenido = JOptionPane.showInputDialog(this,
//                    "Inserte el nombre de la variable a exportar", "Nombre de la variable", JOptionPane.QUESTION_MESSAGE);
//            if (contenido != null) {
//                _tablaDeSimbolos.addExportada(contenido);
//                _tablaDeSimbolos.inserta(contenido);
//            } else {
//                break;
//            }
//        }
//    }
}//GEN-LAST:event__opcionModuloActionPerformed

    /**
     * Devuelve el contenido de una tabla.
     *
     * @param excluir El valor a excluir en la salida.
     *
     * @return El contenido de una tabla.
     */
    /*public String contenidoTabla(String excluir) {

    Set keySet = _tablaDeSimbolos.getTS().keySet();
    String salida = "";

    for (Iterator i = keySet.iterator(); i.hasNext();) {

    Object key = i.next();
    InfoSimbolo info = _tablaDeSimbolos.getTS().get(key);

    if (!key.equals(excluir)) {
    if (info != null) {
    TablaDeSimbolos tablaInt = info.getAmbito();
    if (tablaInt != null) {
    salida = salida + key + " -->  " + tablaInt.getNombre() + '\n';
    } else {
    salida = salida + key + '\n';
    }
    }
    }
    }

    return salida;
    }*/
    /**
     * Metodo que devuelve las variables visibles para un ambito
     * @param actual Tabla de simbolos actual
     * @return String con todas las variables visibles para el ambito
     */
    private String variablesVisibles(TablaDeSimbolos actual) {
        String variablesVisibles = "";
        //Creo una copia para no modificar la existente
        TablaDeSimbolos tabla = actual;
        while (!tabla.esTablaGlobal()) {
            tabla = tabla.getContinente();
            String variablesActuales = "\nVariables exportadas del modulo " + tabla.getNombre();
            Set keySet = tabla.getTS().keySet();

            for (Iterator i = keySet.iterator(); i.hasNext();) {

                Object key = i.next();
                if (!esNombreModulo(tabla, (String) key)) {
                    InfoSimbolo info = tabla.getTS().get(key);

                    if (info != null) {
                        variablesActuales = variablesActuales + "\nLexema " + key + "\n" + info.toString();
                    }
                }
            }
            variablesVisibles = variablesActuales + variablesVisibles;
        }
        return variablesVisibles;
    }

    /**
     * Metodo auxiliar utilizado para mostrar la tabla de simbolos. Este metodo comprueba
     * que el lexema introducido no sea el nombre de un modulo o procedimiento.
     * @param actual Tabla de simbolos actual
     * @param lexema Nombre del lexema a comprobar
     * @return true si es el nombre de un modulo o procedimiento, false en otro caso.
     */
    private boolean esNombreModulo(TablaDeSimbolos actual, String lexema) {
        List contenido = actual.getContenido();
        for (Iterator it = contenido.iterator(); it.hasNext();) {
            TablaDeSimbolos tabla = (TablaDeSimbolos) it.next();
            if (tabla.getNombre().equals(lexema)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devuelve el contenido de una tabla.
     *
     * @return El contenido de una tabla.
     */
    public String contenidoTabla() {

        Set keySet = _tablaDeSimbolos.getTS().keySet();
        String salida = "";

        for (Iterator i = keySet.iterator(); i.hasNext();) {

            Object key = i.next();

            InfoSimbolo info = _tablaDeSimbolos.getTS().get(key);

            if (info != null) {

//                TablaSimbolos tablaInt = info.getAmbito();
//
//                if (tablaInt != null) {
//                    salida = salida + key + " -->  " + tablaInt.getNombre() + "\n";
//
//                    if (tablaInt.getExportadas().size() > 0) {
//
//                        for (Iterator j = tablaInt.getExportadas().iterator(); j.hasNext();) {
//                            salida = salida + "     " + j.next() + "  exportada de modulo " + tablaInt.getNombre() + '\n';
//                        }
//                    }
//                } else {
//                    
//                    salida = salida + "Lexema: " + key + 
//                            ", Tipo Semantico: " + info.getTipos() +
//                            ", Tipo Simbolo: " + info.getTipoSimbolo() + 
//                            "\n";
//                }
                salida = salida + "Lexema: " + key + "\n" + info.toString();
            }
        }

        return salida;
    }
    /**
     * Devuelve las variables visibles de una tabla.
     *
     * @param excluir Valor a excluir.
     *
     * @return Las variables visibles de una tabla.
     */
    /*public String getVariablesVisibles(String excluir) {

    String salida;

    salida = contenidoTabla(excluir);

    if (_tablaDeSimbolos.getContinente() != null) {
    salida = salida + getVariablesVisibles(_tablaDeSimbolos.getContinente().getNombre());
    }
    return salida;
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar _barraDeMenu;
    private javax.swing.JButton _btnAmbitoInferior;
    private javax.swing.JButton _btnAmbitoSuperior;
    private javax.swing.JLabel _lblNombreTabla;
    private javax.swing.JMenu _menuInsertarSimbolo;
    private javax.swing.JMenuItem _opcionCerrar;
    private javax.swing.JMenuItem _opcionIdentificador;
    private javax.swing.JMenuItem _opcionModulo;
    private javax.swing.JMenuItem _opcionSubprograma;
    private javax.swing.JPanel _panelAmbitoActual;
    private javax.swing.JPanel _panelAmbitoInferior;
    private javax.swing.JScrollPane _scrollPaneAmbitoActual;
    private javax.swing.JScrollPane _scrollPaneAmbitoInferior;
    private javax.swing.JTextArea _txtAmbitoActual;
    private javax.swing.JTextArea _txtVariablesVisibles;
    // End of variables declaration//GEN-END:variables
}
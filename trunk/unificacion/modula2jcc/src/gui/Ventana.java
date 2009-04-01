package gui;

import gestor_de_errores.GestorErrores;
import parser.SlkAction;
import parser.SlkError;
import parser.SlkLog;
import parser.SlkParser;
import parser.SlkToken;
import scanner.Scanner;
import tabla_de_simbolos.TablaSimbolos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import observadores.ObservadorLexico;
import semantico.PilaNodos;

/**
 * Ventana principal del compilador.
 * 
 * @author  Javier Salcedo Gomez
 */
public class Ventana extends JFrame  implements ObservadorLexico{

    // ATRIBUTOS
    private GestorErrores _gestorDeErrores;
    private TablaSimbolos _tablaSimbolos;
    private PilaNodos _pilaNodos;
    private File _ficheroCargado;
    private String _listaDeTokens = "\n  Lista de TOKENS recibidos: \n" + " ---------------------------- \n\n";
    
    /** 
     * Constructor de la clase Ventana. 
     */
    public Ventana(GestorErrores gestorDeErrores, TablaSimbolos tablaSimbolos, PilaNodos pilaNodos){

        // Iniciamos los componentes
        initComponents();

        // Mostramos la ventana maximizada
        setExtendedState(MAXIMIZED_BOTH);

        // Asignamos la tabla de simbolos de la aplicacion
        _tablaSimbolos = tablaSimbolos;
        
        // Asignamos el gestor de errores
        _gestorDeErrores = gestorDeErrores;
        
        // Asignamos la pila para el analisis semantico de la aplicacion
        _pilaNodos = pilaNodos;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _splitPanel = new javax.swing.JSplitPane();
        _panelEditor = new javax.swing.JPanel();
        _lblFichero = new javax.swing.JLabel();
        _scrollPanelEditor = new javax.swing.JScrollPane();
        _txtEditor = new javax.swing.JTextArea();
        _panelOutput = new javax.swing.JPanel();
        _tabbedPanelOutput = new javax.swing.JTabbedPane();
        _panelLexico = new javax.swing.JPanel();
        _scrollPanelLexico = new javax.swing.JScrollPane();
        _txtLexico = new javax.swing.JTextArea();
        _panelSintactico = new javax.swing.JPanel();
        _scrollPanelSintactico = new javax.swing.JScrollPane();
        _txtSintactico = new javax.swing.JTextArea();
        _panelSemantico = new javax.swing.JPanel();
        _scrollPanelSemantico = new javax.swing.JScrollPane();
        _txtSemantico = new javax.swing.JTextArea();
        _lblTiempoEjecucion = new javax.swing.JLabel();
        _barraMenu = new javax.swing.JMenuBar();
        _menuArchivo = new javax.swing.JMenu();
        _opcionNuevo = new javax.swing.JMenuItem();
        _separador1 = new javax.swing.JSeparator();
        _opcionAbrir = new javax.swing.JMenuItem();
        _opcionGuardar = new javax.swing.JMenuItem();
        _opcionGuardarComo = new javax.swing.JMenuItem();
        _menuCompilador = new javax.swing.JMenu();
        _opcionCompilar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador Modula2 - PLg 2008/2009 - Macrogrupo1");
        setName("Ventana"); // NOI18N

        _splitPanel.setDividerLocation(375);
        _splitPanel.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        _panelEditor.setBorder(javax.swing.BorderFactory.createTitledBorder("Editor"));

        _lblFichero.setText("nuevo.mod");

        _txtEditor.setColumns(20);
        _txtEditor.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        _txtEditor.setLineWrap(true);
        _txtEditor.setRows(5);
        _scrollPanelEditor.setViewportView(_txtEditor);

        javax.swing.GroupLayout _panelEditorLayout = new javax.swing.GroupLayout(_panelEditor);
        _panelEditor.setLayout(_panelEditorLayout);
        _panelEditorLayout.setHorizontalGroup(
            _panelEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_panelEditorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_lblFichero)
                .addContainerGap(390, Short.MAX_VALUE))
            .addGroup(_panelEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(_panelEditorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(_scrollPanelEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        _panelEditorLayout.setVerticalGroup(
            _panelEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_panelEditorLayout.createSequentialGroup()
                .addComponent(_lblFichero)
                .addContainerGap(307, Short.MAX_VALUE))
            .addGroup(_panelEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(_panelEditorLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(_scrollPanelEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        _splitPanel.setLeftComponent(_panelEditor);

        _panelOutput.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));

        _txtLexico.setColumns(20);
        _txtLexico.setEditable(false);
        _txtLexico.setFont(new java.awt.Font("Courier New", 0, 14));
        _txtLexico.setLineWrap(true);
        _txtLexico.setRows(5);
        _scrollPanelLexico.setViewportView(_txtLexico);

        javax.swing.GroupLayout _panelLexicoLayout = new javax.swing.GroupLayout(_panelLexico);
        _panelLexico.setLayout(_panelLexicoLayout);
        _panelLexicoLayout.setHorizontalGroup(
            _panelLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
            .addGroup(_panelLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(_panelLexicoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(_scrollPanelLexico, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        _panelLexicoLayout.setVerticalGroup(
            _panelLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
            .addGroup(_panelLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(_panelLexicoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(_scrollPanelLexico, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        _tabbedPanelOutput.addTab("Analisis Lexico", _panelLexico);

        _txtSintactico.setColumns(20);
        _txtSintactico.setEditable(false);
        _txtSintactico.setFont(new java.awt.Font("Courier New", 0, 14));
        _txtSintactico.setLineWrap(true);
        _txtSintactico.setRows(5);
        _scrollPanelSintactico.setViewportView(_txtSintactico);

        javax.swing.GroupLayout _panelSintacticoLayout = new javax.swing.GroupLayout(_panelSintactico);
        _panelSintactico.setLayout(_panelSintacticoLayout);
        _panelSintacticoLayout.setHorizontalGroup(
            _panelSintacticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
            .addGroup(_panelSintacticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(_panelSintacticoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(_scrollPanelSintactico, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        _panelSintacticoLayout.setVerticalGroup(
            _panelSintacticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
            .addGroup(_panelSintacticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(_panelSintacticoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(_scrollPanelSintactico, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        _tabbedPanelOutput.addTab("Analisis Sintactico", _panelSintactico);

        _txtSemantico.setColumns(20);
        _txtSemantico.setEditable(false);
        _txtSemantico.setFont(new java.awt.Font("Courier New", 0, 14));
        _txtSemantico.setLineWrap(true);
        _txtSemantico.setRows(5);
        _scrollPanelSemantico.setViewportView(_txtSemantico);

        javax.swing.GroupLayout _panelSemanticoLayout = new javax.swing.GroupLayout(_panelSemantico);
        _panelSemantico.setLayout(_panelSemanticoLayout);
        _panelSemanticoLayout.setHorizontalGroup(
            _panelSemanticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
            .addGroup(_panelSemanticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(_panelSemanticoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(_scrollPanelSemantico, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        _panelSemanticoLayout.setVerticalGroup(
            _panelSemanticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
            .addGroup(_panelSemanticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(_panelSemanticoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(_scrollPanelSemantico, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        _tabbedPanelOutput.addTab("Analisis Semantico", _panelSemantico);

        _lblTiempoEjecucion.setText("Tiempo de Ejecucion:");

        javax.swing.GroupLayout _panelOutputLayout = new javax.swing.GroupLayout(_panelOutput);
        _panelOutput.setLayout(_panelOutputLayout);
        _panelOutputLayout.setHorizontalGroup(
            _panelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_panelOutputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(_panelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_tabbedPanelOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addComponent(_lblTiempoEjecucion))
                .addContainerGap())
        );
        _panelOutputLayout.setVerticalGroup(
            _panelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, _panelOutputLayout.createSequentialGroup()
                .addComponent(_lblTiempoEjecucion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_tabbedPanelOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addContainerGap())
        );

        _splitPanel.setRightComponent(_panelOutput);

        _menuArchivo.setText("Archivo");

        _opcionNuevo.setText("Nuevo...");
        _opcionNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _opcionNuevoActionPerformed(evt);
            }
        });
        _menuArchivo.add(_opcionNuevo);
        _menuArchivo.add(_separador1);

        _opcionAbrir.setText("Abrir");
        _opcionAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _opcionAbrirActionPerformed(evt);
            }
        });
        _menuArchivo.add(_opcionAbrir);

        _opcionGuardar.setText("Guardar");
        _opcionGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _opcionGuardarActionPerformed(evt);
            }
        });
        _menuArchivo.add(_opcionGuardar);

        _opcionGuardarComo.setText("GuardarComo");
        _opcionGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _opcionGuardarComoActionPerformed(evt);
            }
        });
        _menuArchivo.add(_opcionGuardarComo);

        _barraMenu.add(_menuArchivo);

        _menuCompilador.setText("Compilador");

        _opcionCompilar.setText("Compilar");
        _opcionCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _opcionCompilarActionPerformed(evt);
            }
        });
        _menuCompilador.add(_opcionCompilar);

        _barraMenu.add(_menuCompilador);

        setJMenuBar(_barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_splitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_splitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void _opcionNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__opcionNuevoActionPerformed

    // Actualizamos el fichero cargado y vaciamos el editor
    _ficheroCargado = null;
    _txtEditor.setText("");
    _lblFichero.setText("nuevo.mod");
    _lblTiempoEjecucion.setText("Tiempo de Ejecucion: ");
    borrarResultadoEjecucionAnterior();
}//GEN-LAST:event__opcionNuevoActionPerformed

private void _opcionAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__opcionAbrirActionPerformed

    JFileChooser abrir = new JFileChooser();
    abrir.setCurrentDirectory(new java.io.File(".\\"));
    abrir.setSize(400, 300);
    abrir.setMultiSelectionEnabled(false);
    int seleccion = abrir.showOpenDialog(this);

    // Llamamos al método para cargar el contenido del fichero en el editor
    if (seleccion == JFileChooser.APPROVE_OPTION) {

        File file = abrir.getSelectedFile();
        abrir(file);
    }
}//GEN-LAST:event__opcionAbrirActionPerformed

private void _opcionGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__opcionGuardarActionPerformed

    guardar();
}//GEN-LAST:event__opcionGuardarActionPerformed

private void _opcionGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__opcionGuardarComoActionPerformed

    JFileChooser guardar = new JFileChooser();
    guardar.setCurrentDirectory(new java.io.File(".\\"));
    guardar.setSize(400, 300);
    guardar.setMultiSelectionEnabled(false);
    int seleccion = guardar.showSaveDialog(this);

    // Llamamos al método para guardar el contenido del editor en el fichero seleccionado
    if (seleccion == JFileChooser.APPROVE_OPTION) {

        File file = guardar.getSelectedFile();
        guardarComo(file);
    }
}//GEN-LAST:event__opcionGuardarComoActionPerformed

private void _opcionCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__opcionCompilarActionPerformed

    
    if (!_txtEditor.getText().equals("")) {
        
        // Borramos el resultado de la ejecucion anterior de las pestañas
        borrarResultadoEjecucionAnterior();
        
        try {

            StringReader editor = new StringReader(_txtEditor.getText());
            
            // Creamos el scanner y analizamos el contenido del editor
            Scanner scanner = new Scanner(editor, _gestorDeErrores, _tablaSimbolos);

            long inicio = System.currentTimeMillis();
            
            // Creamos la clase servidora de Tokens
            SlkToken tokens = new SlkToken(scanner, _gestorDeErrores,_tablaSimbolos, _pilaNodos);
            
            // Registramos a la ventana como observadora de la clase servidora de Tokens
            tokens.addObserver(this);
            
            // Creamos el Log de Slk para visualizar las acciones de Slk
            SlkLog log = new SlkLog();
            
            // Creamos la clase que gestiona los errores en Slk
            SlkError error = new SlkError(tokens, log, _gestorDeErrores);
            
            // Generamos la clase que nos permite visualizar el arbol sintactico
//            SlkTree tree = new SlkTree(log);
            
            // Mostramos dicho arbol
//            tree.show_parse_derivation();
//            System.out.println("=====================");
//            System.out.println("show_tree");
//            System.out.println("=====================");
//            tree.show_tree();
            
            // Analiza la entrada a nivel sintactico
            SlkParser.parse(0, new SlkAction(_tablaSimbolos, _gestorDeErrores, _pilaNodos), tokens, error, log, (short) 0);
            
            // Muestra el resultado de la ejecucion en sus pestañas correspondientes
            mostrarResultadoAnalisis();
            
            // Actualiza la etiqueta del tiempo de ejecucion
            actualizarTiempoEjecucion(inicio);
        } 
        catch (Exception e) {

            if (_txtEditor.getText().length() > 0) {
                System.err.println(e.getMessage());
            } else {
                System.err.println("Error en proceso E/S con el fichero: no hay parametro");
            }
        }
    } else {

        JOptionPane.showMessageDialog(this,
                "Debes cargar un fichero o escribir el programa a compilar en el Editor.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event__opcionCompilarActionPerformed

    /**
     * Guardar el código del editor de texto en el fichero especificado.
     * 
     * @param file Fichero seleccionado donde se guarda el contenido del editor.
     */
    private void guardarComo(File file){
        
        try{
        
            FileWriter fw = new FileWriter(file);
            fw.write(_txtEditor.getText());
            fw.close();
            
            _ficheroCargado = file;
            _lblFichero.setText(file.getAbsolutePath());
        }
        catch(Exception e){
              
            JOptionPane.showMessageDialog(this,
                        "No se pudo guardar el fichero",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Guardar el código del editor de texto en el fichero cargado actualmente.
     * 
     * @param file Fichero seleccionado donde se guarda el contenido del editor.
     */
    private void guardar(){
        
        try{
        
            if(_ficheroCargado != null){
            
                FileWriter fw = new FileWriter(_ficheroCargado);
                fw.write(_txtEditor.getText());
                fw.close();
            }
            else{

                JFileChooser guardar = new JFileChooser();
                guardar.setCurrentDirectory(new java.io.File(".\\"));
                guardar.setSize(400, 300);
                guardar.setMultiSelectionEnabled(false);
                int seleccion = guardar.showSaveDialog(this);

                // Llamamos al método para guardar el contenido del editor en el fichero seleccionado
                if (seleccion == JFileChooser.APPROVE_OPTION) {

                    File file = guardar.getSelectedFile();
                    guardarComo(file);
                }
            }
        }
        catch(Exception e){
              
            JOptionPane.showMessageDialog(this,
                        "No se pudo guardar el fichero",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Carga un fichero en el campo de texto correspondiente
     * 
     * @param file Archivo a cargar.
     */
    private void abrir(File file){
        
        // Carga el contenido del fichero en el editor
        try{
            
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String salida = "";
            
            while(bf.ready())
                salida = salida + bf.readLine() + "\n";
            
            // Almacenamos el fichero cargado y lo mostrado
            _ficheroCargado = file;
            _lblFichero.setText(file.getAbsolutePath());
            _txtEditor.setText(salida);
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(this,
                        "No se pudo abrir el fichero",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Avisa que el léxico ha generado un token.
     * 
     * @param infoToken Informacion del token generado por el lexico.
     */
    public void tokenGenerado(String infoToken) {
        
        _listaDeTokens = _listaDeTokens + infoToken + "\n";
        _txtLexico.setText(_listaDeTokens);
    }

    /**
     * Muestra los errores en los paneles correspondientes.
     */
    private void mostrarResultadoAnalisis() {

        // Muestra el resultado del analisis lexico
        String resultadoLexico = _gestorDeErrores.dameErroresLexicos() + "\n" + _listaDeTokens;
        _txtLexico.setText(resultadoLexico);

        // Muestra el resultado del analisis sintactico
        _txtSintactico.setText(_gestorDeErrores.dameErroresSintacticos());

        // Muestra el resultado del analisis semantico
        _txtSemantico.setText(_gestorDeErrores.dameErroresSemanticos());
    }

    /**
     * Actualiza la etiqueta de visualizacion del tiempo de ejecucion.
     * 
     * @param inicio Instante de inicio de la toma de tiempo.
     */
    private void actualizarTiempoEjecucion(long inicio) {
        
        _lblTiempoEjecucion.setText("Tiempo de Ejecucion: " + (System.currentTimeMillis() - inicio) + " milisegundos");
    }

    /**
     * Vacia los campos de texto donde se muestra el resultado de la compilacion.
     */
    private void borrarResultadoEjecucionAnterior() {

        _listaDeTokens = "\n  Lista de TOKENS recibidos: \n" + " ---------------------------- \n\n";
        _txtLexico.setText("");
        _txtSintactico.setText("");
        _txtSemantico.setText("");
        
        _gestorDeErrores.reiniciar();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar _barraMenu;
    private javax.swing.JLabel _lblFichero;
    private javax.swing.JLabel _lblTiempoEjecucion;
    private javax.swing.JMenu _menuArchivo;
    private javax.swing.JMenu _menuCompilador;
    private javax.swing.JMenuItem _opcionAbrir;
    private javax.swing.JMenuItem _opcionCompilar;
    private javax.swing.JMenuItem _opcionGuardar;
    private javax.swing.JMenuItem _opcionGuardarComo;
    private javax.swing.JMenuItem _opcionNuevo;
    private javax.swing.JPanel _panelEditor;
    private javax.swing.JPanel _panelLexico;
    private javax.swing.JPanel _panelOutput;
    private javax.swing.JPanel _panelSemantico;
    private javax.swing.JPanel _panelSintactico;
    private javax.swing.JScrollPane _scrollPanelEditor;
    private javax.swing.JScrollPane _scrollPanelLexico;
    private javax.swing.JScrollPane _scrollPanelSemantico;
    private javax.swing.JScrollPane _scrollPanelSintactico;
    private javax.swing.JSeparator _separador1;
    private javax.swing.JSplitPane _splitPanel;
    private javax.swing.JTabbedPane _tabbedPanelOutput;
    private javax.swing.JTextArea _txtEditor;
    private javax.swing.JTextArea _txtLexico;
    private javax.swing.JTextArea _txtSemantico;
    private javax.swing.JTextArea _txtSintactico;
    // End of variables declaration//GEN-END:variables

}

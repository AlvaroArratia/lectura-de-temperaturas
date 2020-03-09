package programa;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jssc.SerialPortEvent;
import jssc.SerialPortException;
import jssc.SerialPortEventListener;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Álvaro Arratia
 */
public class Ventana extends JFrame implements ActionListener {

    private JTable tabla;
    private DefaultTableModel model;
    private JButton btnIniciar;
    private JButton btnDetener;
    private JButton btnExportar;
    private JButton btnGraficar;
    private JButton btnLimpiar;
    private JButton btnInfo;
    private JPanel panelSur;
    private int cantArduino;
    private int contador = 0;
    private boolean medicion;
    private String temperaturas[] = new String[30];
    private String puertoCom;
    private Calendar calendario = Calendar.getInstance();
    private PanamaHitek_Arduino Arduino = new PanamaHitek_Arduino();
    private SerialPortEventListener evento = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (Arduino.isMessageAvailable() == true) {
                    temperaturas[contador] = Arduino.printMessage();
                    contador++;
                    if (contador == 30) {
                        contador = 0;
                        llenarTabla();
                    }
                }
            } catch (SerialPortException | ArduinoException ex) {
                JOptionPane.showMessageDialog(null, "Error en la recepcion de datos.", "Error", ERROR_MESSAGE);
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    /**
     *
     * @param comPort
     */
    public Ventana(String comPort) {

        puertoCom = comPort;
        medicion = false;

        this.setLayout(new BorderLayout());
        this.setSize(1575, 800);
        this.setIconImage(new ImageIcon(getClass().getResource("/Iconos/la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
        this.setTitle("Temperaturas de los Sensores");
        String titulos[] = {"Hora", "S1", "S2", "S3",
            "S4", "S5", "S6", "S7", "S8",
            "S9", "S10", "S11", "S12", "S13",
            "S14", "S15", "S16", "S17", "S18",
            "S19", "S20", "S21", "S22", "S23",
            "S24", "S25", "S26", "S27", "S28",
            "S29", "S30"};
        Object[][] datos = {};
        tabla = new JTable(new DefaultTableModel(datos, titulos));
        tabla.setEnabled(false);
        model = (DefaultTableModel) tabla.getModel();
        JScrollPane scrollPane = new JScrollPane(tabla);

        this.add(scrollPane, BorderLayout.CENTER);

        panelSur = new JPanel();

        btnIniciar = new JButton("Iniciar medicion");
        btnDetener = new JButton("Detener medicion");
        btnExportar = new JButton("Exportar a Excel");
        btnGraficar = new JButton("Graficar");
        btnLimpiar = new JButton("Limpiar tabla");
        btnInfo = new JButton("Desarrollado por");

        btnDetener.setEnabled(false);

        panelSur.add(btnIniciar);
        panelSur.add(btnDetener);
        panelSur.add(btnExportar);
        panelSur.add(btnGraficar);
        panelSur.add(btnLimpiar);
        panelSur.add(btnInfo);

        this.add(panelSur, BorderLayout.SOUTH);

        btnIniciar.addActionListener(this);
        btnIniciar.setActionCommand("iniciar");
        btnDetener.addActionListener(this);
        btnDetener.setActionCommand("detener");
        btnExportar.addActionListener(this);
        btnExportar.setActionCommand("exportar");
        btnGraficar.addActionListener(this);
        btnGraficar.setActionCommand("graficar");
        btnLimpiar.addActionListener(this);
        btnLimpiar.setActionCommand("limpiar");
        btnInfo.addActionListener(this);
        btnInfo.setActionCommand("info");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrarPrograma();
            }
        });

        try {
            Arduino.arduinoRXTX("COM" + puertoCom, 9600, evento);
        } catch (ArduinoException ex) {
            JOptionPane.showMessageDialog(null, "No se detecta ningun arduino conectado "
                    + "al puerto indicado. Reinicie el programa.", "Advertencia", WARNING_MESSAGE);
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }

    /**
     *
     * @param comPort
     * @param cantArduino
     */
    public Ventana(String comPort, int cantArduino) {

        this.cantArduino = cantArduino;
        puertoCom = comPort;
        medicion = false;

        this.setLayout(new BorderLayout());
        this.setSize(1575, 800);
        this.setIconImage(new ImageIcon(getClass().getResource("/Iconos/la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
        this.setTitle("Temperaturas de los Sensores");
        String titulos[] = {"Hora", "S31", "S32", "S33",
            "S34", "S35", "S36", "S37", "S38",
            "S39", "S40", "S41", "S42", "S43",
            "S44", "S45", "S46", "S47", "S48",
            "S49", "S50", "S51", "S52", "S53",
            "S54", "S55", "S56", "S57", "S58",
            "S59", "S60"};
        Object[][] datos = {};
        tabla = new JTable(new DefaultTableModel(datos, titulos));
        tabla.setEnabled(false);
        model = (DefaultTableModel) tabla.getModel();
        JScrollPane scrollPane = new JScrollPane(tabla);

        this.add(scrollPane, BorderLayout.CENTER);

        panelSur = new JPanel();

        btnIniciar = new JButton("Iniciar medicion");
        btnDetener = new JButton("Detener medicion");
        btnExportar = new JButton("Exportar a Excel");
        btnGraficar = new JButton("Graficar");
        btnLimpiar = new JButton("Limpiar tabla");

        btnDetener.setEnabled(false);

        panelSur.add(btnIniciar);
        panelSur.add(btnDetener);
        panelSur.add(btnExportar);
        panelSur.add(btnGraficar);
        panelSur.add(btnLimpiar);

        this.add(panelSur, BorderLayout.SOUTH);

        btnIniciar.addActionListener(this);
        btnIniciar.setActionCommand("iniciar");
        btnDetener.addActionListener(this);
        btnDetener.setActionCommand("detener");
        btnExportar.addActionListener(this);
        btnExportar.setActionCommand("exportar");
        btnGraficar.addActionListener(this);
        btnGraficar.setActionCommand("graficar");
        btnLimpiar.addActionListener(this);
        btnLimpiar.setActionCommand("limpiar");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrarPrograma();
            }
        });

        try {
            Arduino.arduinoRXTX("COM" + puertoCom, 9600, evento);
        } catch (ArduinoException ex) {
            JOptionPane.showMessageDialog(null, "No se detecta ningun arduino conectado "
                    + "al puerto indicado.", "Advertencia", WARNING_MESSAGE);
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("iniciar")) {
            boolean flag1 = true;
            try {
                Arduino.sendData("1");
            } catch (ArduinoException | SerialPortException ex) {
                flag1 = false;
                JOptionPane.showMessageDialog(null, "Error al iniciar la medicion. "
                        + "Verifique que el arduino este conectado, luego reinicie el programa.", "Error", ERROR_MESSAGE);
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (flag1 == true) {
                JOptionPane.showMessageDialog(null, "Se ha iniciado la medicion.");
                medicion = true;
                btnIniciar.setEnabled(false);
                btnLimpiar.setEnabled(false);
                btnExportar.setEnabled(false);
                btnGraficar.setEnabled(false);
                btnDetener.setEnabled(true);
            }
        } else if (ae.getActionCommand().equals("detener")) {
            boolean flag2 = true;
            try {
                Arduino.sendData("0");
            } catch (ArduinoException | SerialPortException ex) {
                flag2 = false;
                JOptionPane.showMessageDialog(null, "Error al detener la medicion. "
                        + "Verifique que el arduino este conectado, luego reinicie el programa.", "Error", ERROR_MESSAGE);
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (flag2 == true) {
                JOptionPane.showMessageDialog(null, "Se ha detenido la medicion.");
                medicion = false;
                btnIniciar.setEnabled(true);
                btnLimpiar.setEnabled(true);
                btnExportar.setEnabled(true);
                btnGraficar.setEnabled(true);
                btnDetener.setEnabled(false);
            }
        } else if (ae.getActionCommand().equals("exportar")) {
            javax.swing.JFileChooser ventana = new javax.swing.JFileChooser();
            String ruta = "";
            try {
                if (ventana.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    ruta = ventana.getSelectedFile().getAbsolutePath() + ".xls";
                    ficheroExcel(ruta);
                }
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo.", "Error", ERROR_MESSAGE);
            }
        } else if (ae.getActionCommand().equals("graficar")) {
            if (cantArduino == 2) {
                MenuGraficos menuGraf = new MenuGraficos(cantArduino);
                menuGraf.setVisible(true);
            } else {
                MenuGraficos menuGraf = new MenuGraficos();
                menuGraf.setVisible(true);
            }
        } else if (ae.getActionCommand().equals("limpiar")) {
            limpiarTabla();
        } else if (ae.getActionCommand().equals("arduino")) {
            Configuracion config = new Configuracion(2);
            config.setVisible(true);
        } else if (ae.getActionCommand().equals("info")) {
            JOptionPane.showMessageDialog(null, "Este programa ha sido desarrollado por: "
                    + "Jose Campos Huiriqueo y Alvaro Arratia Ramirez.\n"
                    + "Correos: josecamposh95@gmail.com, alvaroarratia.r@gmail.com.", "Desarrollo", INFORMATION_MESSAGE);
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @param input
     */
    public void ficheroExcel(String input) {
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet();
        HSSFRow fila = hoja.createRow(0);
        HSSFCell celda = fila.createCell(0);
        celda.setCellValue("Temperaturas"); //título 
        // Se colocan los encabezados
        if (cantArduino == 2) {
            fila = hoja.createRow(1);
            celda = fila.createCell(0);
            celda.setCellValue("Hora");
            celda = fila.createCell(1);
            celda.setCellValue("Temp31");
            celda = fila.createCell(2);
            celda.setCellValue("Temp32");
            celda = fila.createCell(3);
            celda.setCellValue("Temp33");
            celda = fila.createCell(4);
            celda.setCellValue("Temp34");
            celda = fila.createCell(5);
            celda.setCellValue("Temp35");
            celda = fila.createCell(6);
            celda.setCellValue("Temp36");
            celda = fila.createCell(7);
            celda.setCellValue("Temp37");
            celda = fila.createCell(8);
            celda.setCellValue("Temp38");
            celda = fila.createCell(9);
            celda.setCellValue("Temp39");
            celda = fila.createCell(10);
            celda.setCellValue("Temp40");
            celda = fila.createCell(11);
            celda.setCellValue("Temp41");
            celda = fila.createCell(12);
            celda.setCellValue("Temp42");
            celda = fila.createCell(13);
            celda.setCellValue("Temp43");
            celda = fila.createCell(14);
            celda.setCellValue("Temp44");
            celda = fila.createCell(15);
            celda.setCellValue("Temp45");
            celda = fila.createCell(16);
            celda.setCellValue("Temp46");
            celda = fila.createCell(17);
            celda.setCellValue("Temp47");
            celda = fila.createCell(18);
            celda.setCellValue("Temp48");
            celda = fila.createCell(19);
            celda.setCellValue("Temp49");
            celda = fila.createCell(20);
            celda.setCellValue("Temp50");
            celda = fila.createCell(21);
            celda.setCellValue("Temp51");
            celda = fila.createCell(22);
            celda.setCellValue("Temp52");
            celda = fila.createCell(23);
            celda.setCellValue("Temp53");
            celda = fila.createCell(24);
            celda.setCellValue("Temp54");
            celda = fila.createCell(25);
            celda.setCellValue("Temp55");
            celda = fila.createCell(26);
            celda.setCellValue("Temp56");
            celda = fila.createCell(27);
            celda.setCellValue("Temp57");
            celda = fila.createCell(28);
            celda.setCellValue("Temp58");
            celda = fila.createCell(29);
            celda.setCellValue("Temp59");
            celda = fila.createCell(30);
            celda.setCellValue("Temp60");
        } else {
            fila = hoja.createRow(1);
            celda = fila.createCell(0);
            celda.setCellValue("Hora");
            celda = fila.createCell(1);
            celda.setCellValue("Temp1");
            celda = fila.createCell(2);
            celda.setCellValue("Temp2");
            celda = fila.createCell(3);
            celda.setCellValue("Temp3");
            celda = fila.createCell(4);
            celda.setCellValue("Temp4");
            celda = fila.createCell(5);
            celda.setCellValue("Temp5");
            celda = fila.createCell(6);
            celda.setCellValue("Temp6");
            celda = fila.createCell(7);
            celda.setCellValue("Temp7");
            celda = fila.createCell(8);
            celda.setCellValue("Temp8");
            celda = fila.createCell(9);
            celda.setCellValue("Temp9");
            celda = fila.createCell(10);
            celda.setCellValue("Temp10");
            celda = fila.createCell(11);
            celda.setCellValue("Temp11");
            celda = fila.createCell(12);
            celda.setCellValue("Temp12");
            celda = fila.createCell(13);
            celda.setCellValue("Temp13");
            celda = fila.createCell(14);
            celda.setCellValue("Temp14");
            celda = fila.createCell(15);
            celda.setCellValue("Temp15");
            celda = fila.createCell(16);
            celda.setCellValue("Temp16");
            celda = fila.createCell(17);
            celda.setCellValue("Temp17");
            celda = fila.createCell(18);
            celda.setCellValue("Temp18");
            celda = fila.createCell(19);
            celda.setCellValue("Temp19");
            celda = fila.createCell(20);
            celda.setCellValue("Temp20");
            celda = fila.createCell(21);
            celda.setCellValue("Temp21");
            celda = fila.createCell(22);
            celda.setCellValue("Temp22");
            celda = fila.createCell(23);
            celda.setCellValue("Temp23");
            celda = fila.createCell(24);
            celda.setCellValue("Temp24");
            celda = fila.createCell(25);
            celda.setCellValue("Temp25");
            celda = fila.createCell(26);
            celda.setCellValue("Temp26");
            celda = fila.createCell(27);
            celda.setCellValue("Temp27");
            celda = fila.createCell(28);
            celda.setCellValue("Temp28");
            celda = fila.createCell(29);
            celda.setCellValue("Temp29");
            celda = fila.createCell(30);
            celda.setCellValue("Temp30");
        }

        for (int i = 0; i <= model.getRowCount() - 1; i++) {
            fila = hoja.createRow(i + 2); //se crea la fila
            for (int j = 0; j <= 30; j++) {
                celda = fila.createCell(j); //se crea la celda
                celda.setCellValue(tabla.getValueAt(i, j).toString()); //se le asigna el valor
            }
        }
        try {
            FileOutputStream Fichero = new FileOutputStream(input);
            libro.write(Fichero); //Se general el fichero
            Fichero.close(); //Se cierra el archivo
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public void llenarTabla() {
        String Output = "";
        String hora = calendario.get(Calendar.HOUR_OF_DAY) + "";
        String minuto = calendario.get(Calendar.MINUTE) + "";
        String segundos = calendario.get(Calendar.SECOND) + "";
        if (Integer.parseInt(hora) < 10) {
            hora = "0" + hora;
        }
        if (Integer.parseInt(minuto) < 10) {
            minuto = "0" + minuto;
        }
        if (Integer.parseInt(segundos) < 10) {
            segundos = "0" + segundos;
        }
        Output = hora + ":" + minuto + ":" + segundos;
        calendario = Calendar.getInstance();
        model.addRow(new Object[]{Output, temperaturas[0], temperaturas[1],
            temperaturas[2], temperaturas[3], temperaturas[4], temperaturas[5],
            temperaturas[6], temperaturas[7], temperaturas[8], temperaturas[9],
            temperaturas[10], temperaturas[11], temperaturas[12], temperaturas[13],
            temperaturas[14], temperaturas[15], temperaturas[16], temperaturas[17],
            temperaturas[18], temperaturas[19], temperaturas[20], temperaturas[21],
            temperaturas[22], temperaturas[23], temperaturas[24], temperaturas[25],
            temperaturas[26], temperaturas[27], temperaturas[28], temperaturas[29]});
    }

    /**
     *
     */
    public void limpiarTabla() {
        if (tabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "La tabla no tiene datos.", "Limpiar tabla", INFORMATION_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de querer limpiar "
                    + "la tabla?", "Limpiar tabla", YES_NO_OPTION, QUESTION_MESSAGE) == 0) {
                for (int i = 0; i < tabla.getRowCount(); i++) {
                    model.removeRow(i);
                    i -= 1;
                }
            }
        }
    }

    /**
     *
     */
    public void cerrarPrograma() {
        if (medicion == false) {
            if (JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?",
                    "Confirmacion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
        if (medicion == true) {
            JOptionPane.showMessageDialog(null, "No se puede salir del programa "
                    + "mientras se esta haciendo la medicion.");
        }
    }
}

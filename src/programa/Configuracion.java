package programa;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Alvaro Arratia
 */
public class Configuracion extends JFrame implements ActionListener {

    private String comPort;
    private int cantArduino;
    private JLabel lblCom;
    private JComboBox puertoCom;
    private JButton btnCancelar;
    private JButton btnGuardar;
    private JPanel panel, panelSur;

    /**
     * Crea la ventana de configuracion para el primer arduino.
     */
    public Configuracion() {
        this.setIconImage(new ImageIcon(getClass().getResource("/Iconos/carga-"
                + "de-engranajes_318-28594.jpg")).getImage());
        lblCom = new JLabel("Seleccione puerto COM Arduino 1: ");
        puertoCom = new JComboBox();
        puertoCom.addItem("USB0");
        puertoCom.addItem("AMC1");

        panel = new JPanel(new GridLayout(10, 5, 0, 0));
        panelSur = new JPanel();

        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        panel.add(lblCom);
        panel.add(puertoCom);

        panelSur.add(btnGuardar);
        panelSur.add(btnCancelar);

        this.add(panel, BorderLayout.CENTER);
        this.add(panelSur, BorderLayout.SOUTH);

        this.setSize(200, 300);

        btnGuardar.addActionListener(this);
        btnGuardar.setActionCommand("guardar");
        btnCancelar.addActionListener(this);
        btnCancelar.setActionCommand("cancelar");

        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrarPrograma();
            }
        });
    }

    /**
     * Crea la ventana de configuracion para el segundo arduino.
     *
     * @param cantArd Cantidad de arduinos (Se envia desde la ventana de
     * seleccion y se usa como una etiqueta para saber cuantas ventanas
     * principales ejecutar).
     */
    public Configuracion(int cantArd) {
        this.cantArduino = cantArd;
        this.setIconImage(new ImageIcon(getClass().getResource("/Iconos/carga"
                + "-de-engranajes_318-28594.jpg")).getImage());
        lblCom = new JLabel("Seleccione puerto COM Arduino 2: ");
        puertoCom = new JComboBox();
        puertoCom.addItem("USB0");
        puertoCom.addItem("AMC1");

        panel = new JPanel(new GridLayout(10, 5, 0, 0));
        panelSur = new JPanel();

        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        panel.add(lblCom);
        panel.add(puertoCom);

        panelSur.add(btnGuardar);
        panelSur.add(btnCancelar);

        this.add(panel, BorderLayout.CENTER);
        this.add(panelSur, BorderLayout.SOUTH);

        this.setSize(200, 300);

        btnGuardar.addActionListener(this);
        btnGuardar.setActionCommand("guardar");
        btnCancelar.addActionListener(this);
        btnCancelar.setActionCommand("cancelar");

        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrarPrograma();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("guardar")) {
            comPort = (String) puertoCom.getSelectedItem();
            if (cantArduino == 2) {
                Ventana tabla = new Ventana(comPort, cantArduino);
                tabla.setVisible(true);
            } else {
                Ventana tabla = new Ventana(comPort);
                tabla.setVisible(true);
            }
            dispose();
        } else if (e.getActionCommand().equals("cancelar")) {
            if (cantArduino == 2) {
                dispose();
            } else {
                System.exit(0);
            }
        }
    }

    /**
     * Muestra una confirmacion al cerrar el programa desde el icono de cierre
     * (x). Si la respuesta es "Si" se cerrara el programa, en caso contrario se
     * seguira ejecutando.
     */
    public void cerrarPrograma() {
        if (JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?",
                "Confirmacion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}

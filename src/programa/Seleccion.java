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
public class Seleccion extends JFrame implements ActionListener {

    private String cantArduinos;
    private JLabel lblCom;
    private JComboBox arduinos;
    private JButton btnCancelar;
    private JButton btnGuardar;
    private JPanel panel, panelSur;

    /**
     *
     */
    public Seleccion() {
        this.setIconImage(new ImageIcon(getClass().getResource("/Iconos/carga-de-engranajes_318-28594.jpg")).getImage());
        lblCom = new JLabel("Seleccione cantidad de arduinos: ");
        arduinos = new JComboBox();
        arduinos.addItem("1");
        arduinos.addItem("2");

        panel = new JPanel(new GridLayout(10, 5, 0, 0));
        panelSur = new JPanel();

        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        panel.add(lblCom);
        panel.add(arduinos);

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
            cantArduinos = (String) arduinos.getSelectedItem();
            if (cantArduinos.equals("1")) {
                Configuracion config = new Configuracion();
                config.setVisible(true);
            } else {
                if (cantArduinos.equals("2")) {
                    Configuracion config = new Configuracion();
                    Configuracion config2 = new Configuracion(2);
                    config.setVisible(true);
                    config2.setVisible(true);
                }
            }
            dispose();
        } else if (e.getActionCommand().equals("cancelar")) {
            System.exit(0);
        }
    }

    /**
     *
     */
    public void cerrarPrograma() {
        if (JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?",
                "Confirmacion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}

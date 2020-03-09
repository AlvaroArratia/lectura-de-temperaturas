package programa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Alvaro Arratia
 */
public class MenuGraficos extends JFrame implements ActionListener {

    private JLabel lblGrafico;
    private JButton btnVolver;
    private JButton btnGraficar;
    private JButton btnGraficarSensores;
    private int arduino;
    private JPanel panel, panelSur, panelCentro;

    /**
     *
     */
    public MenuGraficos() {
        this.setIconImage(new ImageIcon(getClass().getResource("/Iconos/la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
        lblGrafico = new JLabel("Elija el tipo de grafica: ");

        panel = new JPanel();
        panelCentro = new JPanel();
        panelSur = new JPanel();

        panel.add(lblGrafico);

        btnGraficar = new JButton("Grafica completa");
        btnGraficarSensores = new JButton("Grafica cada 5 sensores");
        btnVolver = new JButton("Volver");

        panelCentro.add(btnGraficar);
        panelCentro.add(btnGraficarSensores);
        panelSur.add(btnVolver);

        this.add(panel, BorderLayout.NORTH);
        this.add(panelCentro, BorderLayout.CENTER);
        this.add(panelSur, BorderLayout.SOUTH);

        this.setSize(400, 140);

        btnGraficar.addActionListener(this);
        btnGraficar.setActionCommand("graficar");
        btnGraficarSensores.addActionListener(this);
        btnGraficarSensores.setActionCommand("graficarsensores");
        btnVolver.addActionListener(this);
        btnVolver.setActionCommand("volver");

        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     *
     * @param arduino
     */
    public MenuGraficos(int arduino) {

        this.arduino = arduino;

        this.setIconImage(new ImageIcon(getClass().getResource("/Iconos/la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
        lblGrafico = new JLabel("Elija el tipo de grafica: ");

        panel = new JPanel();
        panelCentro = new JPanel();
        panelSur = new JPanel();

        panel.add(lblGrafico);

        btnGraficar = new JButton("Grafica completa");
        btnGraficarSensores = new JButton("Grafica cada 5 sensores");
        btnVolver = new JButton("Volver");

        panelCentro.add(btnGraficar);
        panelCentro.add(btnGraficarSensores);
        panelSur.add(btnVolver);

        this.add(panel, BorderLayout.NORTH);
        this.add(panelCentro, BorderLayout.CENTER);
        this.add(panelSur, BorderLayout.SOUTH);

        this.setSize(400, 140);

        btnGraficar.addActionListener(this);
        btnGraficar.setActionCommand("graficar");
        btnGraficarSensores.addActionListener(this);
        btnGraficarSensores.setActionCommand("graficarsensores");
        btnVolver.addActionListener(this);
        btnVolver.setActionCommand("volver");

        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("graficarsensores")) {
            if (arduino == 2) {
                VentanaGraficas graf = new VentanaGraficas(arduino);
                graf.setVisible(true);
            } else {
                VentanaGraficas graf = new VentanaGraficas();
                graf.setVisible(true);
            }
            dispose();
        } else if (ae.getActionCommand().equals("graficar")) {
            //La ruta esta modo ejemplo
            File file = null;//new File("C:\\Users\\Jose\\Documents\\NetBeansProjects\\Programa\\asd.xls");
            javax.swing.JFileChooser ventana = new javax.swing.JFileChooser();
            try {
                if (ventana.showOpenDialog(null) == ventana.APPROVE_OPTION) {
                    //Aqui se obtiene la ruta total del archivo excel
                    file = ventana.getSelectedFile().getAbsoluteFile();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (file != null) {
                if (arduino == 2) {
                    Grafico demo = new Grafico("Grafico de temperaturas por sensor", file, arduino);
                    demo.pack();
                    RefineryUtilities.centerFrameOnScreen(demo);
                    demo.setVisible(true);
                    demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    demo.setIconImage(new ImageIcon(getClass().getResource("/Iconos/la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
                } else {
                    Grafico demo = new Grafico("Grafico de temperaturas por sensor", file);
                    demo.pack();
                    RefineryUtilities.centerFrameOnScreen(demo);
                    demo.setVisible(true);
                    demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    demo.setIconImage(new ImageIcon(getClass().getResource("/Iconos/la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
                }
            }
            dispose();
        } else if (ae.getActionCommand().equals("volver")) {
            dispose();
        }
    }

}

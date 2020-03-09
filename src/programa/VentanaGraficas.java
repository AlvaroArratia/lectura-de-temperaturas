package programa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Jose Campos
 */
public class VentanaGraficas extends JFrame implements ActionListener {

    private int arduino;
    private JButton btnP1;
    private JButton btnP2;
    private JButton btnP3;
    private JButton btnP4;
    private JButton btnP5;
    private JButton btnP6;
    private JPanel panel;

    /**
     *
     */
    public VentanaGraficas() {
        this.setIconImage(new ImageIcon(getClass().getResource("/Iconos/la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
        this.setLayout(new BorderLayout());
        this.setSize(600, 400);

        panel = new JPanel(new GridLayout(2, 3, 0, 0));

        btnP1 = new JButton("Graficar Sensor 1-5");
        btnP2 = new JButton("Graficar Sensor 6-10");
        btnP3 = new JButton("Graficar Sensor 11-15");
        btnP4 = new JButton("Graficar Sensor 16-20");
        btnP5 = new JButton("Graficar Sensor 21-25");
        btnP6 = new JButton("Graficar Sensor 26-30");

        panel.add(btnP1);
        panel.add(btnP2);
        panel.add(btnP3);
        panel.add(btnP4);
        panel.add(btnP5);
        panel.add(btnP6);

        this.add(panel);

        btnP1.addActionListener(this);
        btnP1.setActionCommand("p1");
        btnP2.addActionListener(this);
        btnP2.setActionCommand("p2");
        btnP3.addActionListener(this);
        btnP3.setActionCommand("p3");
        btnP4.addActionListener(this);
        btnP4.setActionCommand("p4");
        btnP5.addActionListener(this);
        btnP5.setActionCommand("p5");
        btnP6.addActionListener(this);
        btnP6.setActionCommand("p6");

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     *
     * @param arduino
     */
    public VentanaGraficas(int arduino) {

        this.arduino = arduino;

        this.setIconImage(new ImageIcon(getClass().getResource("/Iconos/la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
        this.setLayout(new BorderLayout());
        this.setSize(600, 400);

        panel = new JPanel(new GridLayout(2, 3, 0, 0));

        btnP1 = new JButton("Graficar Sensor 1-5");
        btnP2 = new JButton("Graficar Sensor 6-10");
        btnP3 = new JButton("Graficar Sensor 11-15");
        btnP4 = new JButton("Graficar Sensor 16-20");
        btnP5 = new JButton("Graficar Sensor 21-25");
        btnP6 = new JButton("Graficar Sensor 26-30");

        panel.add(btnP1);
        panel.add(btnP2);
        panel.add(btnP3);
        panel.add(btnP4);
        panel.add(btnP5);
        panel.add(btnP6);

        this.add(panel);

        btnP1.addActionListener(this);
        btnP1.setActionCommand("p1");
        btnP2.addActionListener(this);
        btnP2.setActionCommand("p2");
        btnP3.addActionListener(this);
        btnP3.setActionCommand("p3");
        btnP4.addActionListener(this);
        btnP4.setActionCommand("p4");
        btnP5.addActionListener(this);
        btnP5.setActionCommand("p5");
        btnP6.addActionListener(this);
        btnP6.setActionCommand("p6");

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("p1")) {
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
                    GraficoSensores demo = new GraficoSensores("Grafico de "
                            + "temperaturas cada 5 sensores", file, 1, arduino);
                    demo.pack();
                    RefineryUtilities.centerFrameOnScreen(demo);
                    demo.setVisible(true);
                    demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    demo.setIconImage(new ImageIcon(getClass().getResource("/Iconos/"
                            + "la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
                } else {
                    GraficoSensores demo = new GraficoSensores("Grafico de "
                            + "temperaturas cada 5 sensores", file, 1);
                    demo.pack();
                    RefineryUtilities.centerFrameOnScreen(demo);
                    demo.setVisible(true);
                    demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    demo.setIconImage(new ImageIcon(getClass().getResource("/Iconos/"
                            + "la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
                }
                dispose();
            }
        } else if (ae.getActionCommand().equals("p2")) {
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
                    GraficoSensores demo = new GraficoSensores("Grafico de "
                            + "temperaturas cada 5 sensores", file, 2, arduino);
                    demo.pack();
                    RefineryUtilities.centerFrameOnScreen(demo);
                    demo.setVisible(true);
                    demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    demo.setIconImage(new ImageIcon(getClass().getResource("/Iconos/"
                            + "la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
                } else {
                    GraficoSensores demo = new GraficoSensores("Grafico de "
                            + "temperaturas cada 5 sensores", file, 2);
                    demo.pack();
                    RefineryUtilities.centerFrameOnScreen(demo);
                    demo.setVisible(true);
                    demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    demo.setIconImage(new ImageIcon(getClass().getResource("/Iconos/"
                            + "la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
                }
                dispose();
            }
        } else if (ae.getActionCommand().equals("p3")) {
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
                    GraficoSensores demo = new GraficoSensores("Grafico de "
                            + "temperaturas cada 5 sensores", file, 3, arduino);
                    demo.pack();
                    RefineryUtilities.centerFrameOnScreen(demo);
                    demo.setVisible(true);
                    demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    demo.setIconImage(new ImageIcon(getClass().getResource("/Iconos/"
                            + "la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
                } else {
                    GraficoSensores demo = new GraficoSensores("Grafico de "
                            + "temperaturas cada 5 sensores", file, 3);
                    demo.pack();
                    RefineryUtilities.centerFrameOnScreen(demo);
                    demo.setVisible(true);
                    demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    demo.setIconImage(new ImageIcon(getClass().getResource("/Iconos/"
                            + "la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
                }
                dispose();
            }
        } else if (ae.getActionCommand().equals("p4")) {
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
                    GraficoSensores demo = new GraficoSensores("Grafico de "
                            + "temperaturas cada 5 sensores", file, 4, arduino);
                    demo.pack();
                    RefineryUtilities.centerFrameOnScreen(demo);
                    demo.setVisible(true);
                    demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    demo.setIconImage(new ImageIcon(getClass().getResource("/Iconos/"
                            + "la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
                } else {
                    GraficoSensores demo = new GraficoSensores("Grafico de "
                            + "temperaturas cada 5 sensores", file, 4);
                    demo.pack();
                    RefineryUtilities.centerFrameOnScreen(demo);
                    demo.setVisible(true);
                    demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    demo.setIconImage(new ImageIcon(getClass().getResource("/Iconos/"
                            + "la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
                }
                dispose();
            }
        } else if (ae.getActionCommand().equals("p5")) {
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
                    GraficoSensores demo = new GraficoSensores("Grafico de "
                            + "temperaturas cada 5 sensores", file, 5, arduino);
                    demo.pack();
                    RefineryUtilities.centerFrameOnScreen(demo);
                    demo.setVisible(true);
                    demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    demo.setIconImage(new ImageIcon(getClass().getResource("/Iconos/"
                            + "la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
                } else {
                    GraficoSensores demo = new GraficoSensores("Grafico de "
                            + "temperaturas cada 5 sensores", file, 5);
                    demo.pack();
                    RefineryUtilities.centerFrameOnScreen(demo);
                    demo.setVisible(true);
                    demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    demo.setIconImage(new ImageIcon(getClass().getResource("/Iconos/"
                            + "la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
                }
                dispose();
            }

        } else if (ae.getActionCommand().equals("p6")) {
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
                    GraficoSensores demo = new GraficoSensores("Grafico de "
                            + "temperaturas cada 5 sensores", file, 6, arduino);
                    demo.pack();
                    RefineryUtilities.centerFrameOnScreen(demo);
                    demo.setVisible(true);
                    demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    demo.setIconImage(new ImageIcon(getClass().getResource("/Iconos/"
                            + "la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
                } else {
                    GraficoSensores demo = new GraficoSensores("Grafico de "
                            + "temperaturas cada 5 sensores", file, 6);
                    demo.pack();
                    RefineryUtilities.centerFrameOnScreen(demo);
                    demo.setVisible(true);
                    demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    demo.setIconImage(new ImageIcon(getClass().getResource("/Iconos/"
                            + "la-llama-del-fuego-ios-7-simbolo-interfaz_318-35383.jpg")).getImage());
                }
                dispose();
            }

        }
    }

}

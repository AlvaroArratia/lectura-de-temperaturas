package programa;

import jxl.*;
import java.awt.Color;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author Alvaro Arratia
 */
public class Grafico extends JFrame {

    private String data[][];
    private int numColumnas;
    private int numFilasMatriz;
    private int arduino;
    private File file;
    private final long serialVersionUID = 1L;

    {
        // set a theme using the new shadow generator feature available in
        // 1.0.14 - for backwards compatibility it is not enabled by default
        ChartFactory.setChartTheme(new StandardChartTheme("JFree/Shadow", true));
    }

    /**
     * A demonstration application showing how to create a simple time series
     * chart. This example uses monthly data.
     *
     * @param title the frame title.
     * @param file
     */
    public Grafico(String title, File file) {
        super(title);
        this.file = file;
        ChartPanel chartPanel = (ChartPanel) createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 540));
        setContentPane(chartPanel);
    }

    public Grafico(String title, File file, int arduino) {
        super(title);
        this.arduino = arduino;
        this.file = file;
        ChartPanel chartPanel = (ChartPanel) createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 540));
        setContentPane(chartPanel);
    }

    /**
     * Creates a chart.
     *
     * @param dataset a dataset.
     *
     * @return A chart.
     */
    private static JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Temperatura por sensor", // title
                "Minutos", // x-axis label
                "Temperatura", // y-axis label
                dataset, // data
                true, // create legend?
                true, // generate tooltips?
                false // generate URLs?
        );

        chart.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
            renderer.setDrawSeriesLineAsPath(true);
        }

        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("mm:ss"));

        return chart;
    }

    /**
     * Creates a dataset, consisting of thirty series of monthly data.
     *
     * @return The dataset.
     */
    public XYDataset createDataset() {
        leerArchivoExcel();

        if (arduino == 2) {
            TimeSeries s1 = new TimeSeries("Sensor 31");
            for (int i = 0; i < numFilasMatriz; i++) {
                s1.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[1][i]));
            }

            TimeSeries s2 = new TimeSeries("Sensor 32");
            for (int i = 0; i < numFilasMatriz; i++) {
                s2.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[2][i]));
            }

            TimeSeries s3 = new TimeSeries("Sensor 33");
            for (int i = 0; i < numFilasMatriz; i++) {
                s3.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[3][i]));
            }

            TimeSeries s4 = new TimeSeries("Sensor 34");
            for (int i = 0; i < numFilasMatriz; i++) {
                s4.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[4][i]));
            }

            TimeSeries s5 = new TimeSeries("Sensor 35");
            for (int i = 0; i < numFilasMatriz; i++) {
                s5.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[5][i]));
            }

            TimeSeries s6 = new TimeSeries("Sensor 36");
            for (int i = 0; i < numFilasMatriz; i++) {
                s6.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[6][i]));
            }

            TimeSeries s7 = new TimeSeries("Sensor 37");
            for (int i = 0; i < numFilasMatriz; i++) {
                s7.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[7][i]));
            }

            TimeSeries s8 = new TimeSeries("Sensor 38");
            for (int i = 0; i < numFilasMatriz; i++) {
                s8.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[8][i]));
            }

            TimeSeries s9 = new TimeSeries("Sensor 39");
            for (int i = 0; i < numFilasMatriz; i++) {
                s9.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[9][i]));
            }

            TimeSeries s10 = new TimeSeries("Sensor 40");
            for (int i = 0; i < numFilasMatriz; i++) {
                s10.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[10][i]));
            }

            TimeSeries s11 = new TimeSeries("Sensor 41");
            for (int i = 0; i < numFilasMatriz; i++) {
                s11.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[11][i]));
            }

            TimeSeries s12 = new TimeSeries("Sensor 42");
            for (int i = 0; i < numFilasMatriz; i++) {
                s12.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[12][i]));
            }

            TimeSeries s13 = new TimeSeries("Sensor 43");
            for (int i = 0; i < numFilasMatriz; i++) {
                s13.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[13][i]));
            }

            TimeSeries s14 = new TimeSeries("Sensor 44");
            for (int i = 0; i < numFilasMatriz; i++) {
                s14.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[14][i]));
            }

            TimeSeries s15 = new TimeSeries("Sensor 45");
            for (int i = 0; i < numFilasMatriz; i++) {
                s15.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[15][i]));
            }

            TimeSeries s16 = new TimeSeries("Sensor 46");
            for (int i = 0; i < numFilasMatriz; i++) {
                s16.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[16][i]));
            }

            TimeSeries s17 = new TimeSeries("Sensor 47");
            for (int i = 0; i < numFilasMatriz; i++) {
                s17.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[17][i]));
            }

            TimeSeries s18 = new TimeSeries("Sensor 48");
            for (int i = 0; i < numFilasMatriz; i++) {
                s18.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[18][i]));
            }

            TimeSeries s19 = new TimeSeries("Sensor 49");
            for (int i = 0; i < numFilasMatriz; i++) {
                s19.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[19][i]));
            }

            TimeSeries s20 = new TimeSeries("Sensor 50");
            for (int i = 0; i < numFilasMatriz; i++) {
                s20.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[20][i]));
            }

            TimeSeries s21 = new TimeSeries("Sensor 51");
            for (int i = 0; i < numFilasMatriz; i++) {
                s21.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[21][i]));
            }

            TimeSeries s22 = new TimeSeries("Sensor 52");
            for (int i = 0; i < numFilasMatriz; i++) {
                s22.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[22][i]));
            }

            TimeSeries s23 = new TimeSeries("Sensor 53");
            for (int i = 0; i < numFilasMatriz; i++) {
                s23.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[23][i]));
            }

            TimeSeries s24 = new TimeSeries("Sensor 54");
            for (int i = 0; i < numFilasMatriz; i++) {
                s24.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[24][i]));
            }

            TimeSeries s25 = new TimeSeries("Sensor 55");
            for (int i = 0; i < numFilasMatriz; i++) {
                s25.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[25][i]));
            }

            TimeSeries s26 = new TimeSeries("Sensor 56");
            for (int i = 0; i < numFilasMatriz; i++) {
                s26.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[26][i]));
            }

            TimeSeries s27 = new TimeSeries("Sensor 57");
            for (int i = 0; i < numFilasMatriz; i++) {
                s27.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[27][i]));
            }

            TimeSeries s28 = new TimeSeries("Sensor 58");
            for (int i = 0; i < numFilasMatriz; i++) {
                s28.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[28][i]));
            }

            TimeSeries s29 = new TimeSeries("Sensor 59");
            for (int i = 0; i < numFilasMatriz; i++) {
                s29.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[29][i]));
            }

            TimeSeries s30 = new TimeSeries("Sensor 60");
            for (int i = 0; i < numFilasMatriz; i++) {
                s30.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[30][i]));
            }

            TimeSeriesCollection dataset = new TimeSeriesCollection();
            dataset.addSeries(s1);
            dataset.addSeries(s2);
            dataset.addSeries(s3);
            dataset.addSeries(s4);
            dataset.addSeries(s5);
            dataset.addSeries(s6);
            dataset.addSeries(s7);
            dataset.addSeries(s8);
            dataset.addSeries(s9);
            dataset.addSeries(s10);
            dataset.addSeries(s11);
            dataset.addSeries(s12);
            dataset.addSeries(s13);
            dataset.addSeries(s14);
            dataset.addSeries(s15);
            dataset.addSeries(s16);
            dataset.addSeries(s17);
            dataset.addSeries(s18);
            dataset.addSeries(s19);
            dataset.addSeries(s20);
            dataset.addSeries(s21);
            dataset.addSeries(s22);
            dataset.addSeries(s23);
            dataset.addSeries(s24);
            dataset.addSeries(s25);
            dataset.addSeries(s26);
            dataset.addSeries(s27);
            dataset.addSeries(s28);
            dataset.addSeries(s29);
            dataset.addSeries(s30);

            return dataset;
        } else {
            TimeSeries s1 = new TimeSeries("Sensor 1");
            for (int i = 0; i < numFilasMatriz; i++) {
                System.out.println(aTiempo(data[0][i]));
                s1.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[1][i]));
            }

            TimeSeries s2 = new TimeSeries("Sensor 2");
            for (int i = 0; i < numFilasMatriz; i++) {
                s2.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[2][i]));
            }

            TimeSeries s3 = new TimeSeries("Sensor 3");
            for (int i = 0; i < numFilasMatriz; i++) {
                s3.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[3][i]));
            }

            TimeSeries s4 = new TimeSeries("Sensor 4");
            for (int i = 0; i < numFilasMatriz; i++) {
                s4.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[4][i]));
            }

            TimeSeries s5 = new TimeSeries("Sensor 5");
            for (int i = 0; i < numFilasMatriz; i++) {
                s5.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[5][i]));
            }

            TimeSeries s6 = new TimeSeries("Sensor 6");
            for (int i = 0; i < numFilasMatriz; i++) {
                s6.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[6][i]));
            }

            TimeSeries s7 = new TimeSeries("Sensor 7");
            for (int i = 0; i < numFilasMatriz; i++) {
                s7.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[7][i]));
            }

            TimeSeries s8 = new TimeSeries("Sensor 8");
            for (int i = 0; i < numFilasMatriz; i++) {
                s8.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[8][i]));
            }

            TimeSeries s9 = new TimeSeries("Sensor 9");
            for (int i = 0; i < numFilasMatriz; i++) {
                s9.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[9][i]));
            }

            TimeSeries s10 = new TimeSeries("Sensor 10");
            for (int i = 0; i < numFilasMatriz; i++) {
                s10.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[10][i]));
            }

            TimeSeries s11 = new TimeSeries("Sensor 11");
            for (int i = 0; i < numFilasMatriz; i++) {
                s11.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[11][i]));
            }

            TimeSeries s12 = new TimeSeries("Sensor 12");
            for (int i = 0; i < numFilasMatriz; i++) {
                s12.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[12][i]));
            }

            TimeSeries s13 = new TimeSeries("Sensor 13");
            for (int i = 0; i < numFilasMatriz; i++) {
                s13.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[13][i]));
            }

            TimeSeries s14 = new TimeSeries("Sensor 14");
            for (int i = 0; i < numFilasMatriz; i++) {
                s14.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[14][i]));
            }

            TimeSeries s15 = new TimeSeries("Sensor 15");
            for (int i = 0; i < numFilasMatriz; i++) {
                s15.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[15][i]));
            }

            TimeSeries s16 = new TimeSeries("Sensor 16");
            for (int i = 0; i < numFilasMatriz; i++) {
                s16.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[16][i]));
            }

            TimeSeries s17 = new TimeSeries("Sensor 17");
            for (int i = 0; i < numFilasMatriz; i++) {
                s17.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[17][i]));
            }

            TimeSeries s18 = new TimeSeries("Sensor 18");
            for (int i = 0; i < numFilasMatriz; i++) {
                s18.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[18][i]));
            }

            TimeSeries s19 = new TimeSeries("Sensor 19");
            for (int i = 0; i < numFilasMatriz; i++) {
                s19.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[19][i]));
            }

            TimeSeries s20 = new TimeSeries("Sensor 20");
            for (int i = 0; i < numFilasMatriz; i++) {
                s20.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[20][i]));
            }

            TimeSeries s21 = new TimeSeries("Sensor 21");
            for (int i = 0; i < numFilasMatriz; i++) {
                s21.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[21][i]));
            }

            TimeSeries s22 = new TimeSeries("Sensor 22");
            for (int i = 0; i < numFilasMatriz; i++) {
                s22.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[22][i]));
            }

            TimeSeries s23 = new TimeSeries("Sensor 23");
            for (int i = 0; i < numFilasMatriz; i++) {
                s23.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[23][i]));
            }

            TimeSeries s24 = new TimeSeries("Sensor 24");
            for (int i = 0; i < numFilasMatriz; i++) {
                s24.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[24][i]));
            }

            TimeSeries s25 = new TimeSeries("Sensor 25");
            for (int i = 0; i < numFilasMatriz; i++) {
                s25.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[25][i]));
            }

            TimeSeries s26 = new TimeSeries("Sensor 26");
            for (int i = 0; i < numFilasMatriz; i++) {
                s26.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[26][i]));
            }

            TimeSeries s27 = new TimeSeries("Sensor 27");
            for (int i = 0; i < numFilasMatriz; i++) {
                s27.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[27][i]));
            }

            TimeSeries s28 = new TimeSeries("Sensor 28");
            for (int i = 0; i < numFilasMatriz; i++) {
                s28.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[28][i]));
            }

            TimeSeries s29 = new TimeSeries("Sensor 29");
            for (int i = 0; i < numFilasMatriz; i++) {
                s29.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[29][i]));
            }

            TimeSeries s30 = new TimeSeries("Sensor 30");
            for (int i = 0; i < numFilasMatriz; i++) {
                s30.add(new Second(aTiempo(data[0][i])), Double.parseDouble(data[30][i]));
            }

            TimeSeriesCollection dataset = new TimeSeriesCollection();
            dataset.addSeries(s1);
            dataset.addSeries(s2);
            dataset.addSeries(s3);
            dataset.addSeries(s4);
            dataset.addSeries(s5);
            dataset.addSeries(s6);
            dataset.addSeries(s7);
            dataset.addSeries(s8);
            dataset.addSeries(s9);
            dataset.addSeries(s10);
            dataset.addSeries(s11);
            dataset.addSeries(s12);
            dataset.addSeries(s13);
            dataset.addSeries(s14);
            dataset.addSeries(s15);
            dataset.addSeries(s16);
            dataset.addSeries(s17);
            dataset.addSeries(s18);
            dataset.addSeries(s19);
            dataset.addSeries(s20);
            dataset.addSeries(s21);
            dataset.addSeries(s22);
            dataset.addSeries(s23);
            dataset.addSeries(s24);
            dataset.addSeries(s25);
            dataset.addSeries(s26);
            dataset.addSeries(s27);
            dataset.addSeries(s28);
            dataset.addSeries(s29);
            dataset.addSeries(s30);

            return dataset;
        }
    }

    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(true);
        panel.setMouseWheelEnabled(true);
        return panel;
    }

    public void leerArchivoExcel() {
        try {
            Workbook archivoExcel = Workbook.getWorkbook(file);
            System.out.println("Número de Hojas\t" + archivoExcel.getNumberOfSheets());
            for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) // Recorre cada hoja                                                          
            {
                Sheet hoja = archivoExcel.getSheet(sheetNo);
                numColumnas = hoja.getColumns();
                System.out.println(numColumnas);
                int numFilas = hoja.getRows();
                numFilasMatriz = numFilas - 2;
                System.out.println("Numero filas: " + numFilas);
                data = new String[numColumnas][numFilasMatriz];
                System.out.println("Nombre de la Hoja\t"
                        + archivoExcel.getSheet(sheetNo).getName());
                for (int fila = 0; fila < numFilas; fila++) { // Recorre cada fila de la hoja
                    for (int columna = 0; columna < numColumnas; columna++) { // Recorre cada columna de la fila
                        if (fila > 1) {
                            data[columna][fila - 2] = hoja.getCell(columna, fila).getContents();
                            //System.out.print(data[columna][fila - 2] + " ");
                        }
                    }
                    /*if (fila > 1) {
                        System.out.println("\n");
                    }*/
                }
            }
        } catch (Exception ioe) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo. Formato no permitido.", "Error", ERROR_MESSAGE);
            ioe.printStackTrace();
        }

    }

    public static Date aTiempo(String miTiempo) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(miTiempo);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error en la conversion de tiempo.", "Error", ERROR_MESSAGE);
        }
        return date;
    }

    /*public void verificarDatos() {
        for (int i = 0; i < numFilasMatriz; i++) {
            for (int j = 1; j < numColumnas; j++) {
                if (validarCaracteres(data[i][j]) == false) {
                    
                }
            }
        }
    }

    public boolean validarCaracteres(String texto) {
        String extresion = "^[a-zA-Z ]*$";
        Pattern patron = Pattern.compile(extresion);
        Matcher r = patron.matcher(texto);
        if (r.find()) {
            return true;
        } else {
            return false;
        }
    }*/
}

package Ejercicio3;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventana extends JFrame implements ActionListener {

    // Componentes de la interfaz gráfica de usuario
    private JPanel panelDatos;
    private JLabel labelMarca, labelModelo, labelColor, labelKilometraje;
    private JTextField campoMarca, campoModelo, campoColor, campoKilometraje;
    private JButton botonIngresar, botonOrdenar;
    private JScrollPane scrollPane;
    private JTable tabla;

    // Modelo de la tabla
    private DefaultTableModel modeloTabla;

    // Constructor
    public ventana() {
        // Configuración de la ventana
        setTitle("Tabla de Autos");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicialización de los componentes
        panelDatos = new JPanel(new GridLayout(2, 4));
        labelMarca = new JLabel("Marca:");
        labelModelo = new JLabel("Modelo:");
        labelColor = new JLabel("Color:");
        labelKilometraje = new JLabel("Kilometraje:");
        campoMarca = new JTextField();
        campoModelo = new JTextField();
        campoColor = new JTextField();
        campoKilometraje = new JTextField();
        botonIngresar = new JButton("Ingresar");
        botonIngresar.addActionListener(this);
        botonOrdenar = new JButton("Ordenar");
        botonOrdenar.addActionListener(this);
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Marca");
        modeloTabla.addColumn("Modelo");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Kilometraje");
        tabla = new JTable(modeloTabla);
        scrollPane = new JScrollPane(tabla);

        // Adición de los componentes al panel de datos
        panelDatos.add(labelMarca);
        panelDatos.add(campoMarca);
        panelDatos.add(labelModelo);
        panelDatos.add(campoModelo);
        panelDatos.add(labelColor);
        panelDatos.add(campoColor);
        panelDatos.add(labelKilometraje);
        panelDatos.add(campoKilometraje);

        // Adición de los componentes a la ventana
        add(panelDatos, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(botonIngresar, BorderLayout.WEST);
        add(botonOrdenar, BorderLayout.EAST);

        // Configuración de la ventana
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Método para manejar los eventos de los botones
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonIngresar) {
            // Obtener los valores de los campos de texto
            String marca = campoMarca.getText();
            String modelo = campoModelo.getText();
            String color = campoColor.getText();
            String kilometraje = campoKilometraje.getText();
            // Agregar una nueva fila a la tabla con los valores obtenidos
            Object[] fila = {marca, modelo, color, kilometraje};
            modeloTabla.addRow(fila);
            // Borrar los valores de los campos de texto
            campoMarca.setText("");
            campoModelo.setText("");
            campoColor.setText("");
            campoKilometraje.setText("");
        } else if (e.getSource() == botonOrdenar) {
            // Ordenar la tabla alfabéticamente según la columna de "Marca"
            int n = modeloTabla.getRowCount();
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j < n-i-1; j++) {
                    // Obtener las marcas de las filas j y j+1
                    String marca1 = (String) modeloTabla.getValueAt(j, 0);
                    String marca2 = (String) modeloTabla.getValueAt(j+1, 0);
                    // Comprobar si las marcas están en orden alfabético
                    if (marca1.compareToIgnoreCase(marca2) > 0) {
                        // Intercambiar las filas j y j+1
                        Object[] fila1 = {modeloTabla.getValueAt(j, 0), modeloTabla.getValueAt(j, 1),
                                           modeloTabla.getValueAt(j, 2), modeloTabla.getValueAt(j, 3)};
                        Object[] fila2 = {modeloTabla.getValueAt(j+1, 0), modeloTabla.getValueAt(j+1, 1),
                              modeloTabla.getValueAt(j+1, 2), modeloTabla.getValueAt(j+1, 3)};
                                                modeloTabla.setValueAt(fila1[0], j+1, 0);
                        modeloTabla.setValueAt(fila1[1], j+1, 1);
                        modeloTabla.setValueAt(fila1[2], j+1, 2);
                        modeloTabla.setValueAt(fila1[3], j+1, 3);
                    }
                }
            }
        }
    }

    // Método principal para crear la instancia de la ventana
    public static void main(String[] args) {
        new ventana();
    }
}


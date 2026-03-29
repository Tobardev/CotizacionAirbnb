package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cotizacion;
import modelo.GestorCotizaciones;
import util.UtilidadesVista;

/**
 * Ventana que muestra todas las cotizaciones almacenadas en un JTable.
 */
public class VentanaListadoGeneral extends JFrame implements ActionListener {

    private JTable tablaCotizaciones;
    private DefaultTableModel modeloTabla;
    private JButton btnVolverMenu;

    public VentanaListadoGeneral() {
        initComponents();
        cargarDatosTabla();
    }

    private void initComponents() {
        UtilidadesVista.configurarVentana(this, "Listado general", 1080, 540);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Listado general de cotizaciones");
        lblTitulo.setBounds(360, 20, 360, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        add(lblTitulo);

        String[] columnas = {
            "ID", "Cliente", "Ciudad", "Tipo", "Huéspedes",
            "Noches", "Precio/Noche", "Limpieza", "Desayuno", "Total"
        };

        modeloTabla = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        tablaCotizaciones = new JTable(modeloTabla);
        tablaCotizaciones.setRowHeight(24);

        JScrollPane scrollTabla = new JScrollPane(tablaCotizaciones);
        scrollTabla.setBounds(25, 80, 1015, 340);
        add(scrollTabla);

        ImageIcon iconoVolver = UtilidadesVista.cargarIcono("/recursos/btn_volver.png", 28, 28);
        btnVolverMenu = new JButton("Volver al menú", iconoVolver);
        btnVolverMenu.setBounds(430, 445, 190, 45);
        btnVolverMenu.setFont(new Font("Arial", Font.BOLD, 14));
        btnVolverMenu.addActionListener(this);
        add(btnVolverMenu);
    }

    private void cargarDatosTabla() {
        modeloTabla.setRowCount(0);

        ArrayList<Cotizacion> lista = GestorCotizaciones.obtenerCotizaciones();

        for (int i = 0; i < lista.size(); i++) {
            Cotizacion c = lista.get(i);

            Object[] fila = {
                c.getIdCotizacion(),
                c.getNombreCliente(),
                c.getCiudadDestino(),
                c.getTipoAlojamiento(),
                c.getNumeroHuespedes(),
                c.getNumeroNoches(),
                String.format("$%,.0f", c.getPrecioPorNoche()),
                c.isIncluyeLimpieza() ? "Sí" : "No",
                c.isIncluyeDesayuno() ? "Sí" : "No",
                String.format("$%,.0f", c.getTotalPagar())
            };

            modeloTabla.addRow(fila);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVolverMenu) {
            UtilidadesVista.volverAlMenu(this);
        }
    }
}

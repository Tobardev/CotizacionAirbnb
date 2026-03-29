package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.GestorCotizaciones;
import util.UtilidadesVista;

/**
 * Ventana que muestra tres estadísticas calculadas recorriendo el ArrayList.
 */
public class VentanaEstadisticas extends JFrame implements ActionListener {

    private JLabel lblCantidad;
    private JLabel lblPromedio;
    private JLabel lblTipoMasSolicitado;
    private JLabel lblCiudadMasFrecuente;
    private JButton btnVolverMenu;

    public VentanaEstadisticas() {
        initComponents();
        cargarEstadisticas();
    }

    private void initComponents() {
        UtilidadesVista.configurarVentana(this, "Estadísticas", 720, 460);
        setLayout(null);
        getContentPane().setBackground(new Color(246, 248, 252));

        JLabel lblTitulo = new JLabel("Estadísticas de cotizaciones");
        lblTitulo.setBounds(210, 25, 320, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(lblTitulo);

        JPanel panelDatos = new JPanel(null);
        panelDatos.setBounds(80, 90, 560, 220);
        panelDatos.setBackground(Color.WHITE);

        lblCantidad = new JLabel();
        lblCantidad.setBounds(30, 30, 500, 30);
        lblCantidad.setFont(new Font("Arial", Font.PLAIN, 18));

        lblPromedio = new JLabel();
        lblPromedio.setBounds(30, 75, 500, 30);
        lblPromedio.setFont(new Font("Arial", Font.PLAIN, 18));

        lblTipoMasSolicitado = new JLabel();
        lblTipoMasSolicitado.setBounds(30, 120, 500, 30);
        lblTipoMasSolicitado.setFont(new Font("Arial", Font.PLAIN, 18));

        lblCiudadMasFrecuente = new JLabel();
        lblCiudadMasFrecuente.setBounds(30, 165, 500, 30);
        lblCiudadMasFrecuente.setFont(new Font("Arial", Font.PLAIN, 18));

        panelDatos.add(lblCantidad);
        panelDatos.add(lblPromedio);
        panelDatos.add(lblTipoMasSolicitado);
        panelDatos.add(lblCiudadMasFrecuente);

        add(panelDatos);

        ImageIcon iconoVolver = UtilidadesVista.cargarIcono("/recursos/btn_volver.png", 28, 28);
        btnVolverMenu = new JButton("Volver al menú", iconoVolver);
        btnVolverMenu.setBounds(260, 340, 190, 45);
        btnVolverMenu.setFont(new Font("Arial", Font.BOLD, 14));
        btnVolverMenu.addActionListener(this);
        add(btnVolverMenu);
    }

    private void cargarEstadisticas() {
        lblCantidad.setText("1. Cantidad total de cotizaciones: " + GestorCotizaciones.cantidadCotizaciones());
        lblPromedio.setText("2. Promedio del total a pagar: $" +
                String.format("%,.0f", GestorCotizaciones.promedioTotalPagar()));
        lblTipoMasSolicitado.setText("3. Tipo de alojamiento más solicitado: " +
                GestorCotizaciones.tipoAlojamientoMasSolicitado());
        lblCiudadMasFrecuente.setText("4. Ciudad más frecuente: " +
                GestorCotizaciones.ciudadMasFrecuente());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVolverMenu) {
            UtilidadesVista.volverAlMenu(this);
        }
    }
}

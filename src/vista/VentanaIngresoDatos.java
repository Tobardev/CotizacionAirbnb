package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import modelo.Cotizacion;
import modelo.GestorCotizaciones;
import util.Dialogo;
import util.UtilidadesVista;

/**
 * Ventana para registrar las cotizaciones.
 * Incluye todos los componentes solicitados en el laboratorio.
 */
public class VentanaIngresoDatos extends JFrame implements ActionListener {

    private JTextField txtIdCotizacion;
    private JTextField txtNombreCliente;
    private JTextField txtNumeroHuespedes;
    private JTextField txtNumeroNoches;
    private JTextField txtPrecioPorNoche;

    private JTextArea txtObservaciones;
    private JComboBox<String> cboCiudadDestino;

    private JRadioButton rbApartamento;
    private JRadioButton rbCasa;
    private ButtonGroup grupoTipoAlojamiento;

    private JToggleButton tgbServiciosAdicionales;
    private JCheckBox chkLimpieza;
    private JCheckBox chkDesayuno;

    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnVolverMenu;

    public VentanaIngresoDatos() {
        initComponents();
    }

    private void initComponents() {
        UtilidadesVista.configurarVentana(this, "Ingreso de datos", 840, 620);
        setLayout(null);
        getContentPane().setBackground(new Color(250, 250, 252));

        JLabel lblTitulo = new JLabel("Ingreso de datos de la cotización");
        lblTitulo.setBounds(250, 20, 350, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        add(lblTitulo);

        JLabel lblId = new JLabel("ID Cotización:");
        lblId.setBounds(60, 80, 120, 25);
        add(lblId);

        txtIdCotizacion = new JTextField();
        txtIdCotizacion.setBounds(190, 80, 180, 28);
        add(txtIdCotizacion);

        JLabel lblNombre = new JLabel("Nombre cliente:");
        lblNombre.setBounds(430, 80, 120, 25);
        add(lblNombre);

        txtNombreCliente = new JTextField();
        txtNombreCliente.setBounds(560, 80, 200, 28);
        add(txtNombreCliente);

        JLabel lblCiudad = new JLabel("Ciudad destino:");
        lblCiudad.setBounds(60, 130, 120, 25);
        add(lblCiudad);

        cboCiudadDestino = new JComboBox<String>();
        cboCiudadDestino.addItem("Seleccione...");
        cboCiudadDestino.addItem("Cali");
        cboCiudadDestino.addItem("Cartagena");
        cboCiudadDestino.addItem("Medellín");
        cboCiudadDestino.addItem("Bogotá");
        cboCiudadDestino.addItem("Santa Marta");
        cboCiudadDestino.addItem("San Andrés");
        cboCiudadDestino.setBounds(190, 130, 180, 28);
        add(cboCiudadDestino);

        JLabel lblTipo = new JLabel("Tipo alojamiento:");
        lblTipo.setBounds(430, 130, 120, 25);
        add(lblTipo);

        rbApartamento = new JRadioButton("Apartamento");
        rbApartamento.setBounds(560, 130, 120, 25);
        rbApartamento.setBackground(new Color(250, 250, 252));

        rbCasa = new JRadioButton("Casa");
        rbCasa.setBounds(680, 130, 80, 25);
        rbCasa.setBackground(new Color(250, 250, 252));

        grupoTipoAlojamiento = new ButtonGroup();
        grupoTipoAlojamiento.add(rbApartamento);
        grupoTipoAlojamiento.add(rbCasa);

        add(rbApartamento);
        add(rbCasa);

        JLabel lblHuespedes = new JLabel("Núm. huéspedes:");
        lblHuespedes.setBounds(60, 180, 120, 25);
        add(lblHuespedes);

        txtNumeroHuespedes = new JTextField();
        txtNumeroHuespedes.setBounds(190, 180, 180, 28);
        add(txtNumeroHuespedes);

        JLabel lblNoches = new JLabel("Núm. noches:");
        lblNoches.setBounds(430, 180, 120, 25);
        add(lblNoches);

        txtNumeroNoches = new JTextField();
        txtNumeroNoches.setBounds(560, 180, 200, 28);
        add(txtNumeroNoches);

        JLabel lblPrecio = new JLabel("Precio por noche:");
        lblPrecio.setBounds(60, 230, 120, 25);
        add(lblPrecio);

        txtPrecioPorNoche = new JTextField();
        txtPrecioPorNoche.setBounds(190, 230, 180, 28);
        add(txtPrecioPorNoche);

        JLabel lblToggle = new JLabel("Servicios adicionales:");
        lblToggle.setBounds(430, 230, 130, 25);
        add(lblToggle);

        tgbServiciosAdicionales = new JToggleButton("OFF");
        tgbServiciosAdicionales.setBounds(560, 230, 70, 28);
        tgbServiciosAdicionales.addActionListener(this);
        add(tgbServiciosAdicionales);

        chkLimpieza = new JCheckBox("Incluye limpieza");
        chkLimpieza.setBounds(560, 270, 150, 25);
        chkLimpieza.setBackground(new Color(250, 250, 252));
        chkLimpieza.setEnabled(false);
        add(chkLimpieza);

        chkDesayuno = new JCheckBox("Incluye desayuno");
        chkDesayuno.setBounds(560, 300, 150, 25);
        chkDesayuno.setBackground(new Color(250, 250, 252));
        chkDesayuno.setEnabled(false);
        add(chkDesayuno);

        JLabel lblObservaciones = new JLabel("Observaciones:");
        lblObservaciones.setBounds(60, 280, 120, 25);
        add(lblObservaciones);

        txtObservaciones = new JTextArea();
        txtObservaciones.setLineWrap(true);
        txtObservaciones.setWrapStyleWord(true);

        JScrollPane scrollObservaciones = new JScrollPane(txtObservaciones);
        scrollObservaciones.setBounds(190, 280, 250, 120);
        scrollObservaciones.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(scrollObservaciones);

        btnGuardar = crearBoton("Guardar", "/recursos/btn_guardar.png");
        btnGuardar.setBounds(140, 470, 150, 60);

        btnLimpiar = crearBoton("Limpiar", "/recursos/btn_limpiar.png");
        btnLimpiar.setBounds(330, 470, 150, 60);

        btnVolverMenu = crearBoton("Volver al menú", "/recursos/btn_volver.png");
        btnVolverMenu.setBounds(520, 470, 180, 60);

        add(btnGuardar);
        add(btnLimpiar);
        add(btnVolverMenu);
    }

    private JButton crearBoton(String texto, String rutaIcono) {
        ImageIcon icono = UtilidadesVista.cargarIcono(rutaIcono, 28, 28);
        JButton boton = new JButton(texto, icono);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setFocusable(false);
        boton.addActionListener(this);
        return boton;
    }

    private boolean validarDatos() {
        if (txtIdCotizacion.getText().trim().isEmpty()) {
            Dialogo.mostrarAdvertencia(this, "Debe ingresar el ID de la cotización.");
            txtIdCotizacion.requestFocus();
            return false;
        }

        if (GestorCotizaciones.existeId(txtIdCotizacion.getText().trim())) {
            Dialogo.mostrarError(this, "El ID ingresado ya existe. Debe ser único.");
            txtIdCotizacion.requestFocus();
            return false;
        }

        if (txtNombreCliente.getText().trim().isEmpty()) {
            Dialogo.mostrarAdvertencia(this, "Debe ingresar el nombre del cliente.");
            txtNombreCliente.requestFocus();
            return false;
        }

        if (cboCiudadDestino.getSelectedIndex() == 0) {
            Dialogo.mostrarAdvertencia(this, "Debe seleccionar la ciudad destino.");
            cboCiudadDestino.requestFocus();
            return false;
        }

        if (!rbApartamento.isSelected() && !rbCasa.isSelected()) {
            Dialogo.mostrarAdvertencia(this, "Debe seleccionar el tipo de alojamiento.");
            return false;
        }

        try {
            int huespedes = Integer.parseInt(txtNumeroHuespedes.getText().trim());
            int noches = Integer.parseInt(txtNumeroNoches.getText().trim());
            double precio = Double.parseDouble(txtPrecioPorNoche.getText().trim());

            if (huespedes <= 0 || noches <= 0 || precio <= 0) {
                Dialogo.mostrarError(this, "Huéspedes, noches y precio deben ser mayores que cero.");
                return false;
            }
        } catch (NumberFormatException ex) {
            Dialogo.mostrarError(this, "Huéspedes, noches y precio deben ser valores numéricos válidos.");
            return false;
        }

        return true;
    }

    private String obtenerTipoAlojamiento() {
        if (rbApartamento.isSelected()) {
            return "Apartamento";
        } else if (rbCasa.isSelected()) {
            return "Casa";
        }
        return "";
    }

    private void guardarCotizacion() {
        if (!validarDatos()) {
            return;
        }

        String idCotizacion = txtIdCotizacion.getText().trim();
        String nombreCliente = txtNombreCliente.getText().trim();
        String ciudadDestino = cboCiudadDestino.getSelectedItem().toString();
        String tipoAlojamiento = obtenerTipoAlojamiento();
        int numeroHuespedes = Integer.parseInt(txtNumeroHuespedes.getText().trim());
        int numeroNoches = Integer.parseInt(txtNumeroNoches.getText().trim());
        double precioPorNoche = Double.parseDouble(txtPrecioPorNoche.getText().trim());
        boolean incluyeLimpieza = chkLimpieza.isSelected();
        boolean incluyeDesayuno = chkDesayuno.isSelected();
        String observaciones = txtObservaciones.getText().trim();

        Cotizacion cotizacion = new Cotizacion(
                idCotizacion,
                nombreCliente,
                ciudadDestino,
                tipoAlojamiento,
                numeroHuespedes,
                numeroNoches,
                precioPorNoche,
                incluyeLimpieza,
                incluyeDesayuno,
                observaciones
        );

        GestorCotizaciones.agregarCotizacion(cotizacion);

        Dialogo.mostrarInformacion(this,
                "Cotización guardada correctamente.<br>Total a pagar: $" + String.format("%,.0f", cotizacion.getTotalPagar()));

        int respuesta = Dialogo.confirmar(this, "¿Desea ingresar otro registro?");
        if (respuesta == Dialogo.SI) {
            limpiarFormulario();
        } else {
            UtilidadesVista.volverAlMenu(this);
        }
    }

    private void limpiarFormulario() {
        txtIdCotizacion.setText("");
        txtNombreCliente.setText("");
        txtNumeroHuespedes.setText("");
        txtNumeroNoches.setText("");
        txtPrecioPorNoche.setText("");
        txtObservaciones.setText("");

        cboCiudadDestino.setSelectedIndex(0);
        grupoTipoAlojamiento.clearSelection();

        tgbServiciosAdicionales.setSelected(false);
        tgbServiciosAdicionales.setText("OFF");

        chkLimpieza.setSelected(false);
        chkDesayuno.setSelected(false);
        chkLimpieza.setEnabled(false);
        chkDesayuno.setEnabled(false);

        txtIdCotizacion.requestFocus();
    }

    private void controlarServiciosAdicionales() {
        if (tgbServiciosAdicionales.isSelected()) {
            tgbServiciosAdicionales.setText("ON");
            chkLimpieza.setEnabled(true);
            chkDesayuno.setEnabled(true);
        } else {
            tgbServiciosAdicionales.setText("OFF");
            chkLimpieza.setSelected(false);
            chkDesayuno.setSelected(false);
            chkLimpieza.setEnabled(false);
            chkDesayuno.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
            guardarCotizacion();
        } else if (e.getSource() == btnLimpiar) {
            limpiarFormulario();
        } else if (e.getSource() == btnVolverMenu) {
            UtilidadesVista.volverAlMenu(this);
        } else if (e.getSource() == tgbServiciosAdicionales) {
            controlarServiciosAdicionales();
        }
    }
}

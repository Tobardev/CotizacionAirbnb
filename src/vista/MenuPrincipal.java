package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.UtilidadesVista;

/**
 * Ventana principal del sistema.
 * Muestra cuatro botones con imagen para abrir las demás ventanas.
 */
public class MenuPrincipal extends JFrame implements ActionListener {

    private JButton btnIngresoDatos;
    private JButton btnListadoGeneral;
    private JButton btnEstadisticas;
    private JButton btnProgramadores;

    public MenuPrincipal() {
        initComponents();
    }

    private void initComponents() {
        UtilidadesVista.configurarVentana(this, "Menú principal - Cotización Airbnb", 760, 500);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Sistema de Cotización de Alojamientos tipo Airbnb");
        lblTitulo.setBounds(110, 30, 560, 35);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(lblTitulo);

        JLabel lblSubtitulo = new JLabel("Fundamentos de Programación Orientada a Eventos");
        lblSubtitulo.setBounds(180, 68, 430, 25);
        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
        add(lblSubtitulo);

        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 20, 20));
        panelBotones.setBounds(120, 130, 500, 260);
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelBotones.setBackground(Color.WHITE);

        btnIngresoDatos = crearBoton("Ingreso de datos", "/recursos/menu_ingreso.png");
        btnListadoGeneral = crearBoton("Listado general", "/recursos/menu_listado.png");
        btnEstadisticas = crearBoton("Estadísticas", "/recursos/menu_estadisticas.png");
        btnProgramadores = crearBoton("Programadores", "/recursos/menu_programadores.png");

        panelBotones.add(btnIngresoDatos);
        panelBotones.add(btnListadoGeneral);
        panelBotones.add(btnEstadisticas);
        panelBotones.add(btnProgramadores);

        add(panelBotones);
        getContentPane().setBackground(new Color(245, 247, 250));
    }

    private JButton crearBoton(String texto, String rutaIcono) {
        ImageIcon icono = UtilidadesVista.cargarIcono(rutaIcono, 64, 64);
        JButton boton = new JButton(texto, icono);
        boton.setFont(new Font("Arial", Font.BOLD, 15));
        boton.setHorizontalTextPosition(JButton.CENTER);
        boton.setVerticalTextPosition(JButton.BOTTOM);
        boton.setFocusable(false);
        boton.addActionListener(this);
        return boton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIngresoDatos) {
            VentanaIngresoDatos ingreso = new VentanaIngresoDatos();
            ingreso.setVisible(true);
            dispose();
        } else if (e.getSource() == btnListadoGeneral) {
            VentanaListadoGeneral listado = new VentanaListadoGeneral();
            listado.setVisible(true);
            dispose();
        } else if (e.getSource() == btnEstadisticas) {
            VentanaEstadisticas estadisticas = new VentanaEstadisticas();
            estadisticas.setVisible(true);
            dispose();
        } else if (e.getSource() == btnProgramadores) {
            VentanaProgramadores programadores = new VentanaProgramadores();
            programadores.setVisible(true);
            dispose();
        }
    }
}

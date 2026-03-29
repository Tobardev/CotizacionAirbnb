package vista;

import java.awt.Color;
import java.awt.Font;
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
 * Ventana para mostrar la información de los programadores del proyecto.
 * Según el laboratorio, el equipo está conformado por 3 estudiantes. :contentReference[oaicite:0]{index=0}
 */
public class VentanaProgramadores extends JFrame implements ActionListener {

    private JButton btnVolverMenu;

    public VentanaProgramadores() {
        initComponents();
    }

    private void initComponents() {
        UtilidadesVista.configurarVentana(this, "Programadores", 850, 650);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 247, 250));

        JLabel lblTitulo = new JLabel("Programadores del proyecto");
        lblTitulo.setBounds(220, 20, 400, 35);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(lblTitulo);

        // Programador 1
        agregarProgramador(
                40,
                80,
                "/recursos/tobar.jpeg",
                " Luis Tobar",
                "2551282",
                "tobar.luis@correounivalle.edu.co"
        );

        // Programador 2
        agregarProgramador(
                40,
                240,
                "/recursos/allison.jpeg",
                " Allison Cano ",
                "2463191",
                "allison.cano@correounivalle.edu.co"
        );

        // Programador 3
        agregarProgramador(
                40,
                400,
                "/recursos/adrian.jpeg",
                "adrian lopez",
                "2463006",
                "@adrian.amayacorreounivalle.edu.co"
        );

        ImageIcon iconoVolver = UtilidadesVista.cargarIcono("/recursos/btn_volver.png", 28, 28);
        btnVolverMenu = new JButton("Volver al menú", iconoVolver);
        btnVolverMenu.setBounds(320, 560, 200, 45);
        btnVolverMenu.setFont(new Font("Arial", Font.BOLD, 14));
        btnVolverMenu.setFocusPainted(false);
        btnVolverMenu.addActionListener(this);
        add(btnVolverMenu);
    }

    /**
     * Método para agregar visualmente un programador en la ventana.
     */
    private void agregarProgramador(int x, int y, String rutaImagen, String nombre, String codigo, String correo) {
        JPanel panelProgramador = new JPanel();
        panelProgramador.setLayout(null);
        panelProgramador.setBounds(x, y, 750, 130);
        panelProgramador.setBackground(Color.WHITE);
        panelProgramador.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1));
        add(panelProgramador);

        ImageIcon avatar = UtilidadesVista.cargarIcono(rutaImagen, 100, 100);
        JLabel lblAvatar = new JLabel(avatar);
        lblAvatar.setBounds(20, 15, 100, 100);
        panelProgramador.add(lblAvatar);

        JLabel lblNombre = new JLabel(nombre);
        lblNombre.setBounds(150, 15, 400, 28);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 20));
        panelProgramador.add(lblNombre);

        JLabel lblCodigo = new JLabel("Código estudiantil: " + codigo);
        lblCodigo.setBounds(150, 50, 300, 25);
        lblCodigo.setFont(new Font("Arial", Font.PLAIN, 16));
        panelProgramador.add(lblCodigo);

        JLabel lblCorreo = new JLabel("Correo institucional: " + correo);
        lblCorreo.setBounds(150, 80, 520, 25);
        lblCorreo.setFont(new Font("Arial", Font.PLAIN, 16));
        panelProgramador.add(lblCorreo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVolverMenu) {
            UtilidadesVista.volverAlMenu(this);
        }
    }
}
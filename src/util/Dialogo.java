package util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Simulación académica de la clase Dialogo del proyecto DialogCustom.
 * No usa JOptionPane. Todos los mensajes se muestran con JDialog personalizado.
 */
public class Dialogo extends JDialog {

    public static final int SI = 0;
    public static final int NO = 1;

    private int respuesta = NO;

    public Dialogo(Window owner, String titulo, String mensaje, boolean confirmacion, Color colorTitulo) {
        super(owner, titulo, Dialog.ModalityType.APPLICATION_MODAL);
        construirDialogo(mensaje, confirmacion, colorTitulo);
    }

    private void construirDialogo(String mensaje, boolean confirmacion, Color colorTitulo) {
        setSize(420, 190);
        setLocationRelativeTo(getOwner());
        setLayout(new BorderLayout(10, 10));
        setResizable(false);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblTitulo = new JLabel(getTitle(), SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(colorTitulo);

        JLabel lblMensaje = new JLabel("<html><div style='text-align:center;'>" + mensaje + "</div></html>", SwingConstants.CENTER);
        lblMensaje.setFont(new Font("Arial", Font.PLAIN, 14));

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));

        if (confirmacion) {
            JButton btnSi = new JButton("Sí");
            JButton btnNo = new JButton("No");

            btnSi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    respuesta = SI;
                    dispose();
                }
            });

            btnNo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    respuesta = NO;
                    dispose();
                }
            });

            panelBotones.add(btnSi);
            panelBotones.add(btnNo);
        } else {
            JButton btnAceptar = new JButton("Aceptar");
            btnAceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            panelBotones.add(btnAceptar);
        }

        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);
        panelPrincipal.add(lblMensaje, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal, BorderLayout.CENTER);
    }

    public static void mostrarInformacion(Window owner, String mensaje) {
        Dialogo dialogo = new Dialogo(owner, "Información", mensaje, false, new Color(0, 102, 204));
        dialogo.setVisible(true);
    }

    public static void mostrarAdvertencia(Window owner, String mensaje) {
        Dialogo dialogo = new Dialogo(owner, "Advertencia", mensaje, false, new Color(204, 153, 0));
        dialogo.setVisible(true);
    }

    public static void mostrarError(Window owner, String mensaje) {
        Dialogo dialogo = new Dialogo(owner, "Error", mensaje, false, new Color(204, 0, 0));
        dialogo.setVisible(true);
    }

    public static int confirmar(Window owner, String mensaje) {
        Dialogo dialogo = new Dialogo(owner, "Confirmación", mensaje, true, new Color(0, 128, 64));
        dialogo.setVisible(true);
        return dialogo.respuesta;
    }
}

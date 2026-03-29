package util;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import vista.MenuPrincipal;

/**
 * Métodos auxiliares para carga de iconos y navegación entre ventanas.
 */
public class UtilidadesVista {

    public static ImageIcon cargarIcono(String ruta, int ancho, int alto) {
        URL url = UtilidadesVista.class.getResource(ruta);
        if (url == null) {
            return null;
        }

        ImageIcon iconoOriginal = new ImageIcon(url);
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }

    public static void volverAlMenu(JFrame ventanaActual) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        ventanaActual.dispose();
    }

    public static void configurarVentana(JFrame ventana, String titulo, int ancho, int alto) {
        ventana.setTitle(titulo);
        ventana.setSize(ancho, alto);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
    }
}

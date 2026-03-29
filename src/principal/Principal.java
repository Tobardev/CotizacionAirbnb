package principal;

import javax.swing.UIManager;
import vista.MenuPrincipal;

/**
 * Clase principal del proyecto.
 * Configura el LookAndFeel JTattoo y abre el menú principal.
 */
public class Principal {

    public static void main(String[] args) {
        try {
            // LookAndFeel JTattoo exigido para la apariencia del proyecto.
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (Exception e) {
            System.out.println("No fue posible configurar JTattoo. Se usará el LookAndFeel del sistema.");
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                System.out.println("Tampoco fue posible configurar el LookAndFeel del sistema.");
            }
        }

        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
    }
}

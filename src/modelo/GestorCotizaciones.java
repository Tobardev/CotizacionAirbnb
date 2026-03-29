package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase utilitaria para almacenar y gestionar las cotizaciones.
 * Usa un ArrayList compartido por todas las ventanas del sistema.
 */
public class GestorCotizaciones {

    private static ArrayList<Cotizacion> listaCotizaciones = new ArrayList<Cotizacion>();

    public static void agregarCotizacion(Cotizacion cotizacion) {
        listaCotizaciones.add(cotizacion);
    }

    public static ArrayList<Cotizacion> obtenerCotizaciones() {
        return listaCotizaciones;
    }

    public static boolean existeId(String idCotizacion) {
        for (int i = 0; i < listaCotizaciones.size(); i++) {
            if (listaCotizaciones.get(i).getIdCotizacion().equalsIgnoreCase(idCotizacion)) {
                return true;
            }
        }
        return false;
    }

    public static int cantidadCotizaciones() {
        return listaCotizaciones.size();
    }

    public static double promedioTotalPagar() {
        if (listaCotizaciones.isEmpty()) {
            return 0.0;
        }

        double suma = 0.0;
        for (int i = 0; i < listaCotizaciones.size(); i++) {
            suma += listaCotizaciones.get(i).getTotalPagar();
        }

        return suma / listaCotizaciones.size();
    }

    public static String tipoAlojamientoMasSolicitado() {
        if (listaCotizaciones.isEmpty()) {
            return "Sin datos";
        }

        Map<String, Integer> conteo = new HashMap<String, Integer>();

        for (int i = 0; i < listaCotizaciones.size(); i++) {
            String tipo = listaCotizaciones.get(i).getTipoAlojamiento();
            if (conteo.containsKey(tipo)) {
                conteo.put(tipo, conteo.get(tipo) + 1);
            } else {
                conteo.put(tipo, 1);
            }
        }

        String tipoMayor = "Sin datos";
        int mayor = 0;

        for (String tipo : conteo.keySet()) {
            if (conteo.get(tipo) > mayor) {
                mayor = conteo.get(tipo);
                tipoMayor = tipo;
            }
        }

        return tipoMayor + " (" + mayor + ")";
    }

    public static String ciudadMasFrecuente() {
        if (listaCotizaciones.isEmpty()) {
            return "Sin datos";
        }

        Map<String, Integer> conteo = new HashMap<String, Integer>();

        for (int i = 0; i < listaCotizaciones.size(); i++) {
            String ciudad = listaCotizaciones.get(i).getCiudadDestino();
            if (conteo.containsKey(ciudad)) {
                conteo.put(ciudad, conteo.get(ciudad) + 1);
            } else {
                conteo.put(ciudad, 1);
            }
        }

        String ciudadMayor = "Sin datos";
        int mayor = 0;

        for (String ciudad : conteo.keySet()) {
            if (conteo.get(ciudad) > mayor) {
                mayor = conteo.get(ciudad);
                ciudadMayor = ciudad;
            }
        }

        return ciudadMayor + " (" + mayor + ")";
    }
}

package modelo;

/**
 * Clase que representa una cotización de alojamiento tipo Airbnb.
 * Contiene los datos básicos del cliente, del alojamiento y el total calculado.
 */
public class Cotizacion {

    private String idCotizacion;          // PK
    private String nombreCliente;
    private String ciudadDestino;
    private String tipoAlojamiento;
    private int numeroHuespedes;
    private int numeroNoches;
    private double precioPorNoche;
    private boolean incluyeLimpieza;
    private boolean incluyeDesayuno;
    private String observaciones;         // Se usa para cumplir el JTextArea solicitado
    private double totalPagar;            // Atributo calculado

    // Constantes del cálculo
    private static final double COSTO_LIMPIEZA = 45000.0;
    private static final double COSTO_DESAYUNO_POR_PERSONA_NOCHE = 12000.0;

    public Cotizacion(String idCotizacion, String nombreCliente, String ciudadDestino,
                      String tipoAlojamiento, int numeroHuespedes, int numeroNoches,
                      double precioPorNoche, boolean incluyeLimpieza,
                      boolean incluyeDesayuno, String observaciones) {
        this.idCotizacion = idCotizacion;
        this.nombreCliente = nombreCliente;
        this.ciudadDestino = ciudadDestino;
        this.tipoAlojamiento = tipoAlojamiento;
        this.numeroHuespedes = numeroHuespedes;
        this.numeroNoches = numeroNoches;
        this.precioPorNoche = precioPorNoche;
        this.incluyeLimpieza = incluyeLimpieza;
        this.incluyeDesayuno = incluyeDesayuno;
        this.observaciones = observaciones;
        this.totalPagar = calcularTotalPagar();
    }

    /**
     * Calcula el total a pagar:
     * total = (precioPorNoche * numeroNoches) + recargos adicionales
     */
    private double calcularTotalPagar() {
        double subtotal = precioPorNoche * numeroNoches;
        double recargoLimpieza = incluyeLimpieza ? COSTO_LIMPIEZA : 0.0;
        double recargoDesayuno = incluyeDesayuno
                ? (COSTO_DESAYUNO_POR_PERSONA_NOCHE * numeroHuespedes * numeroNoches)
                : 0.0;

        return subtotal + recargoLimpieza + recargoDesayuno;
    }

    public String getIdCotizacion() {
        return idCotizacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public String getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public int getNumeroHuespedes() {
        return numeroHuespedes;
    }

    public int getNumeroNoches() {
        return numeroNoches;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public boolean isIncluyeLimpieza() {
        return incluyeLimpieza;
    }

    public boolean isIncluyeDesayuno() {
        return incluyeDesayuno;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public double getTotalPagar() {
        return totalPagar;
    }
}

package util;

/**
 * ruta completa de donde se encuentra alojado el proyecto
 * para el caso de windows seria c://
 * @author gerardobarcia
 * @author ricardocasanova
 */
public abstract class Util {
    public static final String RUTA_COMPUTADORA = "C:/";
    
    /**
     * numero de puerto del servidor
     */
    public static final int NUMERO_PUERTO_ENVIO = 7689;
    /**
     * nombre del servidor. En este caso es localhost para fines de pruebas locales
     */
    public static final String SERVIDOR = "127.0.0.1";
    
    
    
    public static final String NUMERO_PUERTO_ESCUCHA = "7687";
    /**
     * se puede observar que efectivamente para este ejemplo en el paquete logica
     * existe una clase GestionUsuario que implementa la interfaz de Jsocket ServerLogic
     * para realizar las operaciones de logica del servidor
     */
    public static final String CLASE_LOGICA = "logic.RequestManagement";
}

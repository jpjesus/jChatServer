package server;

import jsockets.server.logic.Server;
import util.Util;

/**
 * Clase de arranque del servidor. Se especifica el numero de puerto a escuhar
 * las peticiones y la clase que manejara la logica de la aplicacion que debe
 * implementar la interfaz ServerLogic de Jsockets
 * @author Ricardo Casanova
 * @author Gerardo Barcia
 */
public class Serverapp {

    public static void main(String[] args) {
        String[] parametros = {Util.NUMERO_PUERTO_ESCUCHA, Util.CLASE_LOGICA};
        Server.main(parametros);
    }
}

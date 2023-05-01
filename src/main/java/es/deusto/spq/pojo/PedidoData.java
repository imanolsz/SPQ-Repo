package es.deusto.spq.pojo;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.spq.server.jdo.Reserva;

public class PedidoData {
        private static Map<String, Integer> mapaComidaCantidad;
    
        public PedidoData(Map<String, Integer> mapaComidaCantida) {
            this.mapaComidaCantidad = mapaComidaCantida;
        }

        public Map getMapaComidaCantidad() {
            return mapaComidaCantidad;
        }
        
        public void setMapaComidaCantidad(Map<String, Integer> mapaComidaCantidad) {
            this.mapaComidaCantidad = mapaComidaCantidad;
        }

        
}

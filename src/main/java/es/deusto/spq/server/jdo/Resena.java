package es.deusto.spq.server.jdo;

import java.util.*;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
public class Resena {

    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT) /*Se indica que el valor de la clave primaria se generará de forma automática incrementando el valor de la clave primaria de la última entidad creada*/
    private long id;

    @Persistent
    private String resena;

    public Resena( String resena){
        this.resena = resena;
    }
    

    public String getResena() {
        return resena;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }
    

}

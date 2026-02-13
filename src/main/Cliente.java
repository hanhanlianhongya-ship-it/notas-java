package pio.daw;

import java.util.HashMap;
import java.util.Map;

public class Cliente {
    private String nombre;
    private String apellidos;
    private String dni;
    private String matricula;

    public Cliente(String nombre, String apellidos, String dni, String matricula){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.matricula = matricula;
}

    public Cliente(Map<String,String> mapa) throws  Exception{
        this.nombre = mapa.get("nombre");
        this.apellido = mapa.get("apellido");
        this.dni = mapa.get("dni");
        this.matricula = mapa.get("matricula");
    
        if(this.nombre == null){
        throw new Exception("Cliente sin nombre");
    }
    else if (this.apellidos == null) {
        throw new Exception("Cliente sin apellido");
    }
    else if (this.dni == null) {
        throw new Exception("Cliente sin dni");
    }
    else if (this.matricula == null) {
        throw new Exception("Cliente sin matricula");
    }
}
    

public Cliente(String formattedString) throws Exception {
    String[] fragmentos = formattedString.split(",");

    if (fragmentos.length != 4) {
        throw new Exception("No se puede formar Cliente a partir de String");
    }


    this.nombre = parseFragment(fragmentos[0], "Cliente(nombre:", "Error al parsear nombre");
    this.apellidos = parseFragment(fragmentos[1], " apellidos:", "Error al parsear apellidos");
    this.dni = parseFragment(fragmentos[2], " dni:", "Error al parsear dni");
    this.matricula = parseFragment(fragmentos[3], " matricula:", "Error al parsear matricula");
}

private String parseFragment(String fragmento, String comparison, String errMsg) throws Exception {
    String[] minorFragmentos = fragmento.split(":");

    if (minorFragmentos.length != 2 || !minorFragmentos[0].equals(comparison)) {
        throw new Exception(errMsg);
    }

    return minorFragmentos[1].strip(); 
}




@Override
public String toString(){
        return String.format("Cliente(nombre: %s, apellidos: %s, dni: %s, matricula: %s)",
                                    this.nombre, this.apellidos, this.dni, this.matricula);
}

/**
 *Guarda los atributos del objeto en un hashmap.
 * @return
 */
public Map<String,String> toMap(){
    Map<String,String> mapa = new HashMap<>();
    mapa.put("nombre", this.nombre);
    mapa.put("apellidos", this.apellidos);
    mapa.put("dni", this.dni);
    mapa.put("matricula", this.matricula);
    return mapa;

}

}
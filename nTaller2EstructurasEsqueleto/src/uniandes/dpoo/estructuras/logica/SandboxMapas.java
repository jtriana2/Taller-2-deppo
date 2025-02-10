package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    public List<String> getValoresComoLista( )
    {
        List<String> valores = new java.util.ArrayList<>(mapaCadenas.values());
        java.util.Collections.sort(valores);
        return valores;
    }

    public List<String> getLlavesComoListaInvertida( )
    {
        List<String> llaves = new java.util.ArrayList<>(mapaCadenas.keySet());
        java.util.Collections.sort(llaves, java.util.Collections.reverseOrder());
        return llaves;
    }

    public String getPrimera( )
    {
        if (mapaCadenas.isEmpty()) {
            return null;
        }
        List<String> llaves = new java.util.ArrayList<>(mapaCadenas.keySet());
        java.util.Collections.sort(llaves);
        return llaves.get(0);
    }

    public String getUltima( )
    {
        if (mapaCadenas.isEmpty()) {
            return null;
        }
        List<String> valores = new java.util.ArrayList<>(mapaCadenas.values());
        java.util.Collections.sort(valores);
        return valores.get(valores.size() - 1);
    }

    public Collection<String> getLlaves( )
    {
        Collection<String> llavesMayusculas = new java.util.ArrayList<>();
        for (String llave : mapaCadenas.keySet()) {
            llavesMayusculas.add(llave.toUpperCase());
        }
        return llavesMayusculas;
    }

    public int getCantidadCadenasDiferentes( )
    {
        return new java.util.HashSet<>(mapaCadenas.values()).size();
    }

    public void agregarCadena( String cadena )
    {
        String llave = new StringBuilder(cadena).reverse().toString();
        mapaCadenas.put(llave, cadena);
    }

    public void eliminarCadenaConLLave( String llave )
    {
        mapaCadenas.remove(llave);
    }

    public void eliminarCadenaConValor( String valor )
    {
        mapaCadenas.values().removeIf(v -> v.equals(valor));
    }

    public void reiniciarMapaCadenas( List<Object> objetos )
    {
        mapaCadenas.clear();
        for (Object objeto : objetos) {
            String cadena = objeto.toString();
            String llave = new StringBuilder(cadena).reverse().toString();
            mapaCadenas.put(llave, cadena);
        }
    }

    public void volverMayusculas( )
    {
        Map<String, String> nuevoMapa = new HashMap<>();
        for (Map.Entry<String, String> entrada : mapaCadenas.entrySet()) {
            String nuevaLlave = entrada.getKey().toUpperCase();
            nuevoMapa.put(nuevaLlave, entrada.getValue());
        }
        mapaCadenas = nuevoMapa;
    }

    public boolean compararValores( String[] otroArreglo )
    {
        Collection<String> valores = mapaCadenas.values();
        for (String cadena : otroArreglo) {
            if (!valores.contains(cadena)) {
                return false;
            }
        }
        return true;
    }
    }
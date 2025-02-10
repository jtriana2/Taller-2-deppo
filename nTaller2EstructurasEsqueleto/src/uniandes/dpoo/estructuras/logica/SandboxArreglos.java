package uniandes.dpoo.estructuras.logica;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class SandboxArreglos {
    private int[] arregloEnteros;
    private String[] arregloCadenas;

    public SandboxArreglos() {
        arregloEnteros = new int[0];
        arregloCadenas = new String[0];
    }

    public int[] getCopiaEnteros() {
        return Arrays.copyOf(arregloEnteros, arregloEnteros.length);
    }

    public String[] getCopiaCadenas() {
        return Arrays.copyOf(arregloCadenas, arregloCadenas.length);
    }

    public int getCantidadEnteros() {
        return arregloEnteros.length;
    }

    public int getCantidadCadenas() {
        return arregloCadenas.length;
    }

    public void agregarEntero(int entero) {
        arregloEnteros = Arrays.copyOf(arregloEnteros, arregloEnteros.length + 1);
        arregloEnteros[arregloEnteros.length - 1] = entero;
    }

    public void agregarCadena(String cadena) {
        arregloCadenas = Arrays.copyOf(arregloCadenas, arregloCadenas.length + 1);
        arregloCadenas[arregloCadenas.length - 1] = cadena;
    }

    public void eliminarEntero(int valor) {
        int count = 0;
        for (int num : arregloEnteros) {
            if (num != valor) count++;
        }
        int[] nuevo = new int[count];
        int index = 0;
        for (int num : arregloEnteros) {
            if (num != valor) nuevo[index++] = num;
        }
        arregloEnteros = nuevo;
    }

    public void eliminarCadena(String cadena) {
        int count = 0;
        for (String str : arregloCadenas) {
            if (!str.equals(cadena)) count++;
        }
        String[] nuevo = new String[count];
        int index = 0;
        for (String str : arregloCadenas) {
            if (!str.equals(cadena)) nuevo[index++] = str;
        }
        arregloCadenas = nuevo;
    }

    public void insertarEntero(int entero, int posicion) {
        int nuevoTamano = arregloEnteros.length + 1;
        int[] nuevo = new int[nuevoTamano];
        posicion = Math.max(0, Math.min(posicion, arregloEnteros.length));
        System.arraycopy(arregloEnteros, 0, nuevo, 0, posicion);
        nuevo[posicion] = entero;
        System.arraycopy(arregloEnteros, posicion, nuevo, posicion + 1, arregloEnteros.length - posicion);
        arregloEnteros = nuevo;
    }

    public void eliminarEnteroPorPosicion(int posicion) {
        if (posicion < 0 || posicion >= arregloEnteros.length) return;
        int[] nuevo = new int[arregloEnteros.length - 1];
        System.arraycopy(arregloEnteros, 0, nuevo, 0, posicion);
        System.arraycopy(arregloEnteros, posicion + 1, nuevo, posicion, arregloEnteros.length - posicion - 1);
        arregloEnteros = nuevo;
    }

    public void reiniciarArregloEnteros(double[] valores) {
        arregloEnteros = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            arregloEnteros[i] = (int) valores[i];
        }
    }

    public void reiniciarArregloCadenas(Object[] objetos) {
        arregloCadenas = new String[objetos.length];
        for (int i = 0; i < objetos.length; i++) {
            arregloCadenas[i] = objetos[i].toString();
        }
    }

    public void volverPositivos() {
        for (int i = 0; i < arregloEnteros.length; i++) {
            arregloEnteros[i] = Math.abs(arregloEnteros[i]);
        }
    }

    public void organizarEnteros() {
        Arrays.sort(arregloEnteros);
    }

    public void organizarCadenas() {
        Arrays.sort(arregloCadenas);
    }

    public int contarApariciones(int valor) {
        int count = 0;
        for (int num : arregloEnteros) {
            if (num == valor) count++;
        }
        return count;
    }

    public int contarApariciones(String cadena) {
        int count = 0;
        for (String str : arregloCadenas) {
            if (str.equalsIgnoreCase(cadena)) count++;
        }
        return count;
    }

    public int[] buscarEntero(int valor) {
        int count = contarApariciones(valor);
        int[] posiciones = new int[count];
        int index = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) posiciones[index++] = i;
        }
        return posiciones;
    }

    public int[] calcularRangoEnteros() {
        if (arregloEnteros.length == 0) return new int[0];
        int min = Arrays.stream(arregloEnteros).min().orElse(0);
        int max = Arrays.stream(arregloEnteros).max().orElse(0);
        return new int[]{min, max};
    }

    public HashMap<Integer, Integer> calcularHistograma() {
        HashMap<Integer, Integer> histograma = new HashMap<>();
        for (int num : arregloEnteros) {
            histograma.put(num, histograma.getOrDefault(num, 0) + 1);
        }
        return histograma;
    }

    public int contarEnterosRepetidos() {
        return (int) calcularHistograma().values().stream().filter(v -> v > 1).count();
    }

    public boolean compararArregloEnteros(int[] otroArreglo) {
        return Arrays.equals(arregloEnteros, otroArreglo);
    }

    public boolean mismosEnteros(int[] otroArreglo) {
        int[] copia1 = Arrays.copyOf(arregloEnteros, arregloEnteros.length);
        int[] copia2 = Arrays.copyOf(otroArreglo, otroArreglo.length);
        Arrays.sort(copia1);
        Arrays.sort(copia2);
        return Arrays.equals(copia1, copia2);
    }

    public void generarEnteros(int cantidad, int minimo, int maximo) {
        Random rand = new Random();
        arregloEnteros = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            arregloEnteros[i] = rand.nextInt(maximo - minimo + 1) + minimo;
        }
    }
}

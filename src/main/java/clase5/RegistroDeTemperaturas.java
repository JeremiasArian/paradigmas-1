package clase5;

/*
Registrar temperaturas diarias de una semana usando lista enlazada simple.
1. Ingresar 7 temperaturas (float, entre -50.0 y 60.0). Validar el rango.
2. Mostrar todas las temperaturas en orden de ingreso.
3. Calcular y mostrar el promedio, la máxima y la mínima.
4. Mostrar cuántos días tuvieron temperatura por encima del promedio.
5. Eliminar la temperatura más alta de la lista y mostrar la lista resultante.
H BONUS: mostrar la lista ordenada de menor a mayor SIN modificar la original.
*/

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;

public class RegistroDeTemperaturas {
    private static final LinkedList<Float> listaEnlazada = new LinkedList<Float>();
    private static float promedio = 0;

    private static void imprimirMenu(){
        System.out.println("~~Registro de temperaturas~~");
        System.out.println("Ingresá 7 temperaturas las cuales");
        System.out.println("no sean menores a los -50.0 C y");
        System.out.println("no sean mayores a los 60.0 C");
    }

    private static void manejarInput(){
        Scanner lector = new Scanner(System.in);

        while (listaEnlazada.size() != 7) {
            float temperatura;
            try{
                temperatura = Float.parseFloat(lector.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Entrada inválida. Reintentálo.");
                continue;
            }

            if (temperatura < -50.0){
                System.out.println("La temperatura ingresada no puede ser menor a los -50.0 C");
                continue;
            } else if ( temperatura > 60.0){
                System.out.println("La temperatura ingresada no puede ser mayor a los 60.0 C");
                continue;
            }

            listaEnlazada.add(temperatura);
        }
    }

    private static void mostrarTemperaturasEnOrden() {
        System.out.println("Mostrando temperaturas ingresadas en orden...");
        System.out.println(listaEnlazada.toString());
    }

    private static void CalcularYMostrarElPromedioLaMaximaYLaMinima(){
        float sumaTotal = 0;
        for (float t : listaEnlazada){
            sumaTotal += t;
        }
        promedio = sumaTotal / listaEnlazada.size();
        System.out.println("Temperatura Promedio: "+promedio+" C");
        System.out.println("Temperatura máxima: "+Collections.max(listaEnlazada)+" C");
        System.out.println("Temperatura mínima: "+Collections.min(listaEnlazada)+" C");
    }

    private static void cantidadDeDiasPorEncimaDelPromedio() {
        int cantidad = 0;
        for (float t : listaEnlazada) {
            if (t > promedio) {
                cantidad++;
            }
        }
        System.out.println("Cantidad de días con temperaturas por encima del promedio ("
                +promedio+" C): "+cantidad+" días");
    }

    private static void eliminarLaMasAltaYMostrarLista(){
        float maxima = Collections.max(listaEnlazada);
        listaEnlazada.remove(maxima);
        System.out.println("Se eliminó la mayor temp. registrada y la lista quedó así: "+listaEnlazada);
    }

    private static void mostrarEnOrdenSinModificarOriginal() {
        LinkedList<Float> nuevaYOrdenada = new LinkedList<>();
        nuevaYOrdenada.addAll(listaEnlazada);
        Collections.sort(nuevaYOrdenada);
        System.out.println("Lista ordenada: "+ nuevaYOrdenada.toString());
    }

    public static void main(String[] args){
        imprimirMenu();
        manejarInput();
        mostrarTemperaturasEnOrden();
        CalcularYMostrarElPromedioLaMaximaYLaMinima();
        cantidadDeDiasPorEncimaDelPromedio();
        mostrarEnOrdenSinModificarOriginal();
        eliminarLaMasAltaYMostrarLista();
    }
}

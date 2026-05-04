package clase6;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class GrafoNoDirigido {
    private static Map<String, List<String>> crearGrafo(){
        Map<String, List<String>> listaDeAdyacencia = new HashMap<>();
        return listaDeAdyacencia;
    }

    private static void agregarNodo(Map<String, List<String>> lista, String nodo) {
        lista.putIfAbsent(nodo, new ArrayList<>());
    }

    private static void agregarArista(Map<String, List<String>> lista,
                                      String nodo1, String nodo2){
        lista.get(nodo1).add(nodo2);
        lista.get(nodo2).add(nodo1);
    }

    private static void eliminarNodo(Map<String, List<String>> lista,
                                     String nodo) {
        if(lista.containsKey(nodo)){
            lista.values().forEach(elemento -> elemento.remove(nodo));
            lista.remove(nodo);
            System.out.println("Se eliminó "+nodo+" del grafo");
            mostrarGrafo(lista);
        } else{
            System.out.println("El grafo no tiene el nodo que queres eliminar!");
        }

    }

    private static void mostrarGrafo(Map<String, List<String>> lista){
        System.out.println("Mostrando grafo...");
        for (var nodo: lista.entrySet()){
            System.out.println(nodo.toString());
        }
    }

    private static void vecinos(Map<String, List<String>> lista,String nodo) {
        for (var nodos: lista.entrySet()){
            if(nodos.getKey().equals(nodo)){
                System.out.println("Vecinos de "+nodo+": "+nodos.getValue());
            }
        }
    }

    public static void main(String[] args){
        var lista = crearGrafo();
        agregarNodo(lista, "Buenos Aires");
        agregarNodo(lista, "Cordoba");
        agregarNodo(lista, "Rosario");
        agregarNodo(lista, "Mendoza");
        agregarNodo(lista, "Tucuman");
        agregarNodo(lista, "Salta");
        agregarNodo(lista, "Neuquen");
        agregarArista(lista, "Buenos Aires", "Cordoba");
        agregarArista(lista, "Buenos Aires", "Rosario");
        agregarArista(lista, "Cordoba", "Rosario");
        agregarArista(lista, "Cordoba", "Mendoza");
        agregarArista(lista, "Cordoba", "Tucuman");
        agregarArista(lista, "Tucuman", "Salta");
        agregarArista(lista, "Mendoza", "Neuquen");
        agregarArista(lista, "Cordoba", "Salta");
        mostrarGrafo(lista);
        vecinos(lista, "Cordoba");
        eliminarNodo(lista, "Neuquen");
    }
}

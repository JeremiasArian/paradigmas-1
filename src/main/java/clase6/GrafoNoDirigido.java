package clase6;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

/*
Implementá la lista de adyacencia con la estructura de datos que provea tu lenguaje.
Cada vértice debe tener asociada la lista de sus vecinos directos.
Construí el siguiente grafo con las funciones anteriores y mostrá el resultado:
Vértices: Buenos Aires, Córdoba, Rosario, Mendoza, Tucumán, Salta, Neuquén
Aristas: Buenos Aires—Córdoba, Buenos Aires—Rosario, Córdoba—Rosario,
Córdoba—Mendoza, Córdoba—Tucumán, Tucumán—Salta,
Mendoza—Neuquén, Córdoba—Salta
Luego de construir el grafo:
• Mostrá los vecinos de Córdoba.
• Eliminá la arista Córdoba—Rosario y mostrá el grafo actualizado.
• Mostrá la cantidad de vértices y aristas del grafo final.
 */

public class GrafoNoDirigido {
    private static Map<String, List<String>> crearGrafo(){
        Map<String, List<String>> listaDeAdyacencia = new HashMap<>();
        return listaDeAdyacencia;
    }

    private static void agregarNodo(Map<String, List<String>> grafo, String nodo) {
        grafo.putIfAbsent(nodo, new ArrayList<>());
    }

    private static void agregarArista(Map<String, List<String>> grafo,
                                      String nodo1, String nodo2){
        grafo.get(nodo1).add(nodo2);
        grafo.get(nodo2).add(nodo1);
    }

    private static void eliminarNodo(Map<String, List<String>> grafo,
                                     String nodo) {
        if(grafo.containsKey(nodo)){
            grafo.values().forEach(elemento -> elemento.remove(nodo));
            grafo.remove(nodo);
            System.out.println("Se eliminó "+nodo+" del grafo");
            mostrarGrafo(grafo);
        } else{
            System.out.println("El grafo no tiene el nodo que queres eliminar!");
        }

    }

    private static void eliminarArista(Map<String, List<String>> grafo,
                                       String nodo1, String nodo2){
        System.out.println();
        if (!(grafo.containsKey(nodo1) && grafo.containsKey(nodo2))){
            System.out.println("Uno de los nodos no se encontro (no se puede eliminar arista)!");
            return;
        }
        System.out.println("Eliminando arista entre "+nodo1+" y "+nodo2);
        System.out.println();
        List<String> a = grafo.get(nodo1);
        List<String> b = grafo.get(nodo2);
        if(a != null) a.remove(nodo2);
        if(b != null) b.remove(nodo1);
        mostrarGrafo(grafo);
    }

    private static void mostrarGrafo(Map<String, List<String>> grafo){
        System.out.println("Mostrando grafo...");
        for (var nodo: grafo.entrySet()){
            System.out.println(nodo.toString());
        }
    }

    private static void vecinos(Map<String, List<String>> grafo,String nodo) {
        for (var nodos: grafo.entrySet()){
            if(nodos.getKey().equals(nodo)){
                System.out.println("Vecinos de "+nodo+": "+nodos.getValue());
            }
        }
    }

    private static void cantidadVertices(Map<String, List<String>> grafo){
        System.out.println();
        System.out.println("Cantidad de nodos en el grafo: " + grafo.size());
        System.out.println();
    }

    private static void cantidadAristas(Map<String, List<String>> grafo){
        System.out.println();
        int cantidad=0;
        for(var nodo : grafo.entrySet()) {
            cantidad = cantidad + nodo.getValue().size();
        }
        System.out.println("Cantidad de aristas en el grafo: "+cantidad);
        System.out.println();
    }

    public static void main(String[] args){
        var grafo = crearGrafo();
        agregarNodo(grafo, "Buenos Aires");
        agregarNodo(grafo, "Cordoba");
        agregarNodo(grafo, "Rosario");
        agregarNodo(grafo, "Mendoza");
        agregarNodo(grafo, "Tucuman");
        agregarNodo(grafo, "Salta");
        agregarNodo(grafo, "Neuquen");
        agregarArista(grafo, "Buenos Aires", "Cordoba");
        agregarArista(grafo, "Buenos Aires", "Rosario");
        agregarArista(grafo, "Cordoba", "Rosario");
        agregarArista(grafo, "Cordoba", "Mendoza");
        agregarArista(grafo, "Cordoba", "Tucuman");
        agregarArista(grafo, "Tucuman", "Salta");
        agregarArista(grafo, "Mendoza", "Neuquen");
        agregarArista(grafo, "Cordoba", "Salta");
        vecinos(grafo, "Cordoba");
        eliminarArista(grafo, "Cordoba", "Rosario");
        cantidadAristas(grafo);
        cantidadVertices(grafo);
    }
}

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

    public static void main(String[] args){
        var lista = crearGrafo();
    }
}

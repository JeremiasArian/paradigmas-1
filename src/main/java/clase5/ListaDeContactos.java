package clase5;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/*
Implementar una agenda de contactos usando lista simplemente enlazada.
Cada nodo almacena: nombre, teléfono y email de un contacto.
1. Cargar 5 contactos ingresados por el usuario. Validar que el nombre no esté vacío.
2. Mostrar todos los contactos en el orden en que fueron ingresados.
3. Buscar un contacto por nombre y mostrar su teléfono y email.
4. Eliminar un contacto por nombre. Confirmar si se encontró o no.
5. Mostrar cuántos contactos quedan en la lista (función contar).
H BONUS: verificar si el nombre ya existe antes de agregar (sin duplicados)
*/

public class ListaDeContactos {
    private static LinkedList<List<String>> listaEnlazada = new LinkedList<List<String>>();

    private static void imprimirMenu(){
        System.out.println("~~Lista de Contactos~~");
        System.out.println("1) Agregar");
        System.out.println("2) Buscar");
        System.out.println("3) Eliminar");
        System.out.println("4) Ver todos");
        System.out.println("5) Contar");
        System.out.println("6) Salir");
    }

    private static void manejarInput(){
        Scanner lector = new Scanner(System.in);

        boolean continuar = true;
        while(continuar){
            int opcion;
            try{
                opcion = Integer.parseInt(lector.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Entrada inválida. Reintentálo.");
                continue;
            }

            switch (opcion){
                case 1:
                    String nombre = "";
                    String telefono = "";
                    String email = "";
                    boolean contactoPresente = false;

                    System.out.println("Ingresá el nombre del contacto");
                    while(true){
                        nombre = lector.nextLine();
                        if(nombre.isBlank()) {
                            System.out.println("Nombre inválido. Reintentálo");
                        } else {
                            for(List<String> contacto : listaEnlazada){
                                if(contacto.get(0).equals(nombre)){
                                    contactoPresente = true;
                                }
                            }
                            if (!contactoPresente) break;
                            else {
                                System.out.println("Este contacto ya esta agendado");
                                break;
                            }
                        }
                    }
                    if(contactoPresente) {
                        imprimirMenu();
                        break;
                    }

                    System.out.println("Ingresá el teléfono");
                    while(true) {
                        telefono=lector.nextLine();
                        if(telefono.isBlank()) System.out.println("Teléfono inválido. Reintentálo");
                        else break;
                    }

                    System.out.println("Ingresá el email");
                    while(true){
                        email =lector.nextLine();
                        if(email.isBlank()) System.out.println("Email inválido. Reintentálo");
                        else break;
                    }

                    listaEnlazada.add(crearNodo(nombre, telefono, email));
                    System.out.println("Contacto agregado con éxito");
                    imprimirMenu();
                    break;
                case 2:
                    mostrarContactos();
                    imprimirMenu();
                    break;
                case 3:
                    System.out.println("Ingresá el nombre del contacto a buscar:");
                    while(true){
                        String nombreABuscar = lector.nextLine();
                        if(nombreABuscar.isBlank()){
                            System.out.println("Entrada inválida.");
                        } else {
                            buscarContacto(nombreABuscar);
                            imprimirMenu();
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ingresá el nombre dle contacto a eliminar");
                    while(true){
                        String contactoAEliminar = lector.nextLine();
                        if(contactoAEliminar.isBlank()){
                            System.out.println("Entrada inválida");
                        } else {
                            eliminarContacto(contactoAEliminar);
                            imprimirMenu();
                            break;
                        }
                    }
                    break;
                case 5:
                    if(listaEnlazada.isEmpty()){
                        System.out.println("No hay contactos");
                        imprimirMenu();
                        break;
                    }
                    int cantidad = listaEnlazada.size();
                    if(cantidad < 2){
                        System.out.println("Hay 1 contacto");
                        imprimirMenu();
                        break;
                    } else {
                        System.out.println("Hay "+cantidad+" contactos");
                        imprimirMenu();
                        break;
                    }
                case 6:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no reconocida");
                    break;
            }
        }
    }

    private static List<String> crearNodo(String nombre, String telefono, String email){
        List<String> contacto = new ArrayList<>();
        contacto.add(nombre);
        contacto.add(telefono);
        contacto.add(email);
        return contacto;
    }

    private static void mostrarContactos(){
        if (listaEnlazada.isEmpty()) {
            System.out.println("No hay contactos");
            return;
        }
        System.out.println("Lista de Contactos:");
        for (List<String> contacto : listaEnlazada){
            System.out.println(contacto.toString());
        }
    }

    private static void buscarContacto(String nombre){
        String nombreEncontrado = "";
        for (List<String> contacto : listaEnlazada){
            if(contacto.get(0).equals(nombre)){
                nombreEncontrado=nombre;
                System.out.println("///Datos de "+nombreEncontrado+"///");
                System.out.println("Teléfono: "+contacto.get(1));
                System.out.println("Email: "+ contacto.get(2));
            }
        }
        if(nombreEncontrado.equals("")){
            System.out.println("No se encontró el contacto");
        }
    }

    private static void eliminarContacto(String nombreDelContacto){
        boolean presente = false;
        for(List<String> contacto : listaEnlazada){
            if(contacto.get(0).equals(nombreDelContacto)){
                listaEnlazada.remove(contacto);
                System.out.println("Se eliminó a "+nombreDelContacto);
                presente = true;
            }
        }
        if(!presente) System.out.println("No se encontró el contacto");
    }

    public static void main(String[] args){
        imprimirMenu();
        manejarInput();
    }
}

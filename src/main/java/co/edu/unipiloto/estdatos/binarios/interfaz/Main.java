package co.edu.unipiloto.estdatos.binarios.interfaz;

import java.util.Scanner;

public class Main{
    
    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menú Principal");
            System.out.println("1. Cargar archivo .properties");
            System.out.println("2. Reconstruir árbol");
            System.out.println("3. Mostrar árbol en formato JSON");
            System.out.println("4. Guardar árbol en archivo JSON");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del archivo .properties: ");
                    String filename = scanner.nextLine();
                    try {
                        reconstructor.cargarArchivo(filename);
                        System.out.println("Archivo cargado exitosamente.");
                    } catch (IOException e) {
                        System.out.println("Error al cargar el archivo: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        reconstructor.reconstruir();
                        System.out.println("Árbol reconstruido exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error al reconstruir el árbol: " + e.getMessage());
                    }
                    break;
                case 3:
                    String json = reconstructor.toJson(reconstructor.tree.root);
                    System.out.println("Árbol en formato JSON:");
                    System.out.println(json);
                    break;
                case 4:
                    String treeJson = reconstructor.arbol.toJson(reconstructor.arbol.root);
                    try {
                        reconstructor.crearArchivo(treeJson);
                        System.out.println("Árbol guardado en archivo JSON exitosamente.");
                    } catch (IOException e) {
                        System.out.println("Error al crear el archivo JSON: " + e.getMessage());
                    }
                    break;
                case 5:
                    exit = true;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new ArbolCLI().mainMenu();
    }
}



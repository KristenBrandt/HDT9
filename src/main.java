import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static String menuinicial = "\n Lectura de archivo de ciudades : \n" +
            "\t Ingresar la direccion del archivo de pacientes que quiere:\n" +
            "\t La direccion del archivo tiene que ser en formato C:\\\\Users\\\\try\\\\Desktop\\\\intento.txt\n" +
            "\t Si la direccion no es aceptada al primer intento ponga la direccion de nuevo, es por un problema de cache ";


    public static void main(String[] args) {
        boolean deleviaje = true;
        Scanner input = new Scanner(System.in);
        int contador = 0;
        int numeros = -1;
        int uno = 1;
        int dos = 1;
        int tres = 1;
        int[] orden = new int[3];
        int [][] grafo = new int[11][3];


        do {
            System.out.print(menuinicial);
            System.out.println("\n");
            String archivo = input.nextLine();
            if (!archivo.equals("2")) {
                File archivoUsuarios = new File(archivo);
                //El codigo de buffered reader es tomado de la siguiente pagina.
                //https://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
                //path para mi compu:
                ///Users/kristenbrandt/Documents/Universidad/Estructuras/HDT9/guategrafo.txt
                try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
                    String line;
                    System.out.print("Se esta guardando la lista de ciudades y kilometros... \n");
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(", ");
                        String part1 = parts[0];
                        String part2 = parts[1];
                        String part3 = parts[2];
                        tres = Integer.parseInt(part3);
                        switch (part1){
                            case "Guatemala":
                                uno = 1;
                                break;
                            case "Coban":
                                uno = 2;
                                break;
                            case "Quetzaltenango":
                                uno = 3;
                                break;
                            case "Escuintla":
                                uno = 4;
                                break;
                            case "Izabal":
                                uno = 5;
                                break;
                        }
                        switch (part2){
                            case "Guatemala":
                                dos = 1;
                                break;
                            case "Coban":
                                dos = 2;
                                break;
                            case "Quetzaltenango":
                                dos = 3;
                                break;
                            case "Escuintla":
                                dos = 4;
                                break;
                            case "Izabal":
                                dos = 5;
                                break;
                        }
                        contador = contador + 1;
                        numeros = numeros + 1;
                        orden[0]= uno;
                        orden[1]= dos;
                        orden[2]= tres;
                        grafo[numeros] = orden;

                    }
                } catch (Exception e) {
                    System.out.println("Intente ingresando la direccion del archivo de nuevo porque no se encontro");
                }
                deleviaje = false;
            }
        } while (deleviaje);
        System.out.print("Cuantas ciudades diferentes hay en guategrafo.txt? \n");
        String vertices = input.nextLine();
        int ver = Integer.parseInt(vertices);
        int[][] weights = grafo; //{{1, 3, -2}, {2, 1, 4}, {2, 3, 3}, {3, 4, 2}, {4, 2, -1}};
        int numVertices = ver;

        FloydWarshall.floydWarshall(weights, numVertices);
    }
}

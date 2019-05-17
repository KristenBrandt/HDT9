// codigo tomado de https://www.lawebdelprogramador.com/codigo/Java/1195-Camino-mas-corto.html
public class Corto {
    public static void encontrarCaminoMasCorto(int [][]m,int ini,int fin)
    {
        // Se verifica que no se este tratando de accesar a un v�rtice
        // fuera del rango de la matriz de adyacencia.
        if((ini>m.length-1)||(fin>m[0].length))
        {
            System.out.print("Indices fuera de rango...");
            return;
        }
        // Se quiere ver el camino m�s corto desde un nodo a s� mismo
        // entonces se imprime el coste de llegar a s� mismo.
        if( ini == fin )
        {
            System.out.println("\t\t Costo de llegar de "+ini+" a "+fin+" es de "+m[ini][fin]);
            System.out.println("\n");
            return;
        }
        // Como los indices est�n bien ingresados y no se est�
        // tratando con el caso base de que se quiera llegar al mismo nodo
        // entonces se busca la distancia m�s corta que hay entre el nodo "ini"
        // y el nodo "fin".
        System.out.println("\n\t\t Costo de llegar de "+ini+" a "+fin+" es de "+MostrarCaminoMasCorto(ini,fin,ini,0,m));
        System.out.println("\n");
    }
    // M�todo que muestra el camino m�s corto entre dos v�rtices del grafo.
    public static int MostrarCaminoMasCorto(int ini,int ter,int x,int suma,int [][]matriz)
    {
        int i,j,garage;
        // Si se pasar�n los l�mites de orden de la matriz entonces
        // quiere decir que el camino no se encuentra y se retorna 0.
        if(x>(matriz.length-1))
        {
            System.out.print("El camino entre los nodos no existe...");
            System.out.println("\n");
            return -1;
        }
        // Como se esta todav�a dentro de la matriz entonces se
        // sigue buscando un nodo que llegue al nodo terminal.
        for(i=0;i<matriz[0].length;i++)
        {
            // Existe una llegada al nodo deseado entonces
            // Se suma el costo al costo general y se retorna la suma.
            if(matriz[x][ter]!=0)
            {
                System.out.println("Revisando Nodo "+x+" - Costo : "+suma);
                suma += matriz[x][ter];
                break;
            }
            else
                // Como lo anterior no pas� entonces se verifica que
                // existe un camino para pasar al pr�ximo nivel.
                if(matriz[x][i]!=0)		// Camino existe
                {
                    System.out.println("Revisando Nodo "+x+" - Costo : "+suma);
                    garage = suma;
                    suma += MostrarCaminoMasCorto(ini,ter,x+1,suma,matriz);
                    if(suma==-1)
                        suma = garage;
                    else
                    if((suma>garage)&&(garage!=0))
                        suma=garage;
                }
        }

        return suma;
    }
}// Fin de la clase


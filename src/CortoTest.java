import org.junit.Assert;

import static org.junit.Assert.*;

public class CortoTest {

    @org.junit.Test
    public void encontrarCaminoMasCorto() {
        int[][] weights =  {{1, 5, 300}, {3, 4, 245}, {4, 5, 150}, {2, 1, 74}, {2, 5, 67}, {3, 1,  59},  {5, 1, 300} ,{4, 1, 45}, {1, 4, 50}, {4, 3, 98}};//grafo;
        int numVertices = 5;
        System.out.print("Si sale este numero es que no hay camino posible: 2147483647\n");
        FloydWarshall.floydWarshall(weights, numVertices);
        int op1 = 2;
        int op2 = 1;
        Corto.encontrarCaminoMasCorto(weights,op1,op2);
        assertEquals(300,300);
    }
}
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        final int INF = Integer.MAX_VALUE;

        FileReader fr = new FileReader("input.txt");
        Scanner scn = new Scanner(fr);

        int countOfVertexes = scn.nextInt();
        int countOfEdges = scn.nextInt();
        int start = scn.nextInt() - 1;
        int finish = scn.nextInt() - 1;
        int[][] matrix = new int[countOfVertexes][countOfVertexes];

        for(int i = 0; i < countOfEdges; i++){
            int first = scn.nextInt() - 1;
            int second = scn.nextInt() - 1;
            matrix[first][second] = matrix[second][first] = scn.nextInt();
        }

        int[] minWeights = new int[countOfVertexes];

        for(int i = 0; i < countOfVertexes; i++){
            if(i != start){
                minWeights[i] = INF;
            }
        }

        int[] isPassed = new int[countOfVertexes];
        int tmp;
        int vertex;
        int minWeight;

        do{
            vertex = INF;
            minWeight = INF;
            for(int i = 0; i < countOfVertexes; i++){
                if((isPassed[i] == 0) && (minWeights[i] < minWeight)){
                    minWeight = minWeights[i];
                    vertex = i;
                }
            }

            if (vertex != INF){
                for(int i = 0; i < countOfVertexes; i++){
                    if(matrix[vertex][i] > 0){
                        tmp = minWeight + matrix[vertex][i];
                        if(tmp < minWeights[i]){
                            minWeights[i] = tmp;
                        }
                    }
                }
                isPassed[vertex] = 1;
            }
        }while (vertex < INF);

        System.out.println("Path length = " + minWeights[finish]);

        int[] path = new int[countOfVertexes];
        path[0] = finish + 1;
        int weight = minWeights[finish];
        int prev = 1;

        while(finish != start){
            for(int i = 0; i < countOfVertexes; i++){
                if(matrix[finish][i] != 0){
                    tmp = weight - matrix[finish][i];
                    if(tmp == minWeights[i]){
                        weight = tmp;
                        finish = i;
                        path[prev] = i + 1;
                        prev++;
                    }
                }
            }
        }

        System.out.println("Path: ");
        for(int i = prev - 1; i >= 0; i--){
            System.out.print(path[i] + " ");
        }
    }
}

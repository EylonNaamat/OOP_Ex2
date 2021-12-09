package api;

import java.util.Random;

public class GenerateGraph {
    private int nodesNum;
    private int edgesNum;


    public GenerateGraph(int nodesNum, int edgesNum){
        this.nodesNum = nodesNum;
        this.edgesNum = edgesNum;
    }

    public DirectedWeightedGraphAlgorithms generate(){
        DirectedWeightedGraphAlgorithms ans = new MyDirectedWeightedGraphAlgorithms();
        Random r = new Random();
        for (int i = 0; i < this.nodesNum; i++) {
            double randX = 35 + r.nextDouble();
            double randy = 32 + r.nextDouble();
            MyGeoLocation loc = new MyGeoLocation(randX, randy, 0.0);
            MyNodeData node = new MyNodeData(i, loc);
            ans.getGraph().addNode(node);
        }

        for (int i = 0; i < this.nodesNum; i++) {
            for (int j = 0; j < this.edgesNum; j++) {
                int randDest = r.nextInt(this.nodesNum);
                double randWeight = 1 + r.nextDouble();
                ans.getGraph().connect(i, randDest, randWeight);
            }
        }
        return ans;
    }

}

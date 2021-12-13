import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.MyDirectedWeightedGraphAlgorithms;
import guiapi.Gui_Menu;
import guiapi.Gui_MyGraphDrow;

/**
 * This class is the Main class for Ex2 - your implementation will be tested using this class.
 */
public class Ex2 {
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraph getGrapg(String json_file) {
        DirectedWeightedGraph ans = null;
        DirectedWeightedGraphAlgorithms graph = new MyDirectedWeightedGraphAlgorithms();
        graph.load(json_file);
        ans = graph.getGraph();
        return ans;
    }
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraphAlgorithms getGrapgAlgo(String json_file) {
        DirectedWeightedGraphAlgorithms ans = null;
        ans = new MyDirectedWeightedGraphAlgorithms();
        ans.load(json_file);
        return ans;
    }
    /**
     * This static function will run your GUI using the json fime.
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     *
     */
    public static void runGUI(String json_file) {
        DirectedWeightedGraphAlgorithms alg = getGrapgAlgo(json_file);
        new Gui_Menu(alg);
    }

    public static void main(String[] args) {
        if(args.length > 0){
            runGUI(args[0]);
        }
    }
}
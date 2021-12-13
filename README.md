# OOP_Ex2
## The Main Classes
The classes we chose to create are: </br>
1. MyGeoLocation
2. MyNodeData
3. MyEdgeData
4. MyDirectedWeightedGraph
5. MyDirectedWeightedGraphAlgorithms
6. MyGsonEdje
7. MyGsonGraph
8. MyGsonNode
</br>

### MyNodeData
MyNodeData is a class that has the id, location, weight, info and tag of a node. we created 2 constructors: a constructor that gets an id and location of a node, and a constructor that gets a NodeData and creates new NodeData. this class implements NodeData interface and its functions. 
</br>

### MyEdgeData
MyEdgeData is a class that has a source, weight, dest, info and tag of an Edge. we created 2 constructors: a constructor that gets src, dest, weight, and a constructor that gets an EdgeData and creates a new EdgeData. this class implements EdgeData interface and its functions.
</br>

### MyDirectedWeightedGraph
MyDirectedWeightedGraph is a class that has a hashmap that holds all the edges in the graph (the key is the src of the edge, and the value is another hashmap that its key is the dest of the edge, and its value is EdgeData), another hashmap that holds all the nodes of the graph (the key is the node's id, and the value is NodeData), a field that says how many edges are in the graph, a field that says how many nodes are in the graph, and a fields that says how many changes were made in the graph.
</br>
the class has a constructor that builds a graph from scratch, and the class implements DirectedWeightedGraph interface and its functions.
</br>
</br>
this class implements the addNode function by creating a deep copy of the NodeData, and then adding the NodeData key to the hashmap of nodes, adding a key in the edges hashmap.
</br>
</br>
this class implements the connect function by checking if the graph has the src of the edge, if the graph already this edge we will replace it with the new one, else, we create a new edge and add it to the edges hashmap.
</br>
</br>
this class implements the nodeIter function by using the nodes hashmap iterator.
</br>
</br>
this class implements the edgeIter function by making a list of all the edges and using the list iterator.
</br>
</br>
this class implements the edgeIter function by using the edges hashmap iterator.
</br>
</br>
this class implements the removeNode function by first checking if the graph has the node, if so, we remove all the edges consisting this node and then remove the node itself.
</br>
</br>
this class implements the removeEdge function by first checking if the graph has the src of the edge, if so, we remove the edge from the edges hashmap.
</br>
</br>
this class implements the nodeSize function by returning the field nodeSize.
</br>
</br>
this class implements the edgeSize function by returning the field edgeSize.
</br>
</br>
this class implements the getMC function by returning mc.
</br>
</br>
this class also has a dfs function. this function is an iterative dfs. we get a node and adds him to a stack, then run while the stack is not empty, we check if we didnt touch the first node in the stack, if we didnt touch him we change his tag, and then run through all his edges and add the nodes that we didnt touch to the stack.
</br>
</br>
this class also has a setTags function. this function set all the nodes' tags to 0.
</br>
</br>
this class also has a getTranspose function. this function returns a transpose graph. we create a new graph, and add all the nodes of the original graph to this graph. then, go through all the edges of the original graph, for every edge we create a new edge by switch the src and dest, and adding it to the transpose graph.

### MyDirectedWeightedGraphAlgorithms
this class implements the DirectedWeightedGraphAlgorithms interface and its functions. this class has a MyDirectedWeightedGraph graph called myGraph, and a constructor that creates a new MyDirectedWeightedGraph.
</br>
</br>
this class has an init function. this function gets a DirectedWeightedGraph and sets myGraph to it.
</br>
</br>
this class has a getGraph function that return myGraph.
</br>
</br>
this class has a copy function. this function copies myGraph and return the copied graph. we define a new MyDirectedWeightedGraph graph, and for every node of myGraph we copy this node to the copied graph, and by going through all the edges of this node we copy all the edges to the copied graph.
this function return a deep copy of myGraph.
</br>
</br>
this class has a isConnected function. this function check if myGraph is strongly connected components. in this function we make a copy of myGraph, so we dont mess the original graph. we set all the tags of the nodes in this graph to 0, then we do dfs on the first node of the graph, and then we go through all the nodes in the graph. if there is a node that its tag is 0 it means that the graph is not connected. if not, we creates a transpose graph, sets all the nodes' tag to 0, and do dfs on the first node. then, we go through all the nodes in the transpose graph, if there is a node with tag 0, it means the graph is not connected. if not, it means the graph is SCC.
</br>
</br>
this class has a shortestPathDist function. this function gets source and destination and computes the shortest path distance from src to dest. in this function we used the dijkstra algorithm. we created a helper function that called dijkstraAlgo, the function set the info of every node to "w" (it means that this node wasnt visited), the starting shortest path dist is 0 (no path), and the tag will show us the key of the previous node in the path. the algorithm starts to run from the source node and tags him as visited, and update the distance to the neighbour nodes. after that, we take other node that wasnt visited and have the shortest path (not 0) and checks the distance to the neighbour, and if the distance + this node shortest path smaller than the neighbour, we update the neighbour path, and the tag. we will run on all the nodes that we could go to them from the source. and this function returns a new graph that every node in this graph holds the shortest path from the source node. and every node contain the previous node on the path.
</br>
with the new graph we can go to the dest node, if the tag is -1 there is no path. else, we return the shortest path that was saved in the dijkstra algorithm.
</br>
</br>
this class has a shortestPath function, this function gets source and destination and returns the shortest path from the source to destination. this function also uses dijkstraAlgo function that returns a graph like we describe in the previous function. after that, we know that every node holds the previous node in the path, so we create a LinkedList and adds the dest node, and every time we add the previous node. until we add the source node.
</br>
</br>
this class has center function, this function checks if the graph is connected, if not returns null, else, we run through all the nodes and for every node we use maxDist function that returns the largest path from other node, by using dijkstraAlgo. if the longest path we will get is shorter than all the previous minimum longest path we update the minimum and save the node. in the end we take the node with shortest longest path and return it as the center.
</br>
</br>
this class has a tsp function, this function gets a list and return another list. we use the greedy algorithm of the traveling salesman problem. we start from the first node in the list given and by using dijkstraAlgo we get a graph that helps us find the node that has the shortest path from this node. we get the path from this node to its closet by using the shortestPath function, and we add it to the answer list, and we remove from the given list the nodes we visited. then we do the same with node that was the closet one to the previous node, until we will visit all the nodes in the given list.
</br>
</br>
for doing save and load from json we created objects that are similar to the objects the json describes. we have created the following classes: MyGsonGraph, MyGsonNode, MyGsonEdje. MyGsonGraph has two fields: a list of GsonEdje and a list of GsonNode, and 2 constructors. the first one is a regular constructor that creates new lists of nodes and edges. the second constructor get MyDirectedWeightedGraph and creates a new MyGsonGraph from it, by casting every node and edge to MyGsonNode and MyGsonEdje. the class has a load function that gets a json file and creates MyGsonGraph from it. it also has a save function that gets a json file and writes the graph to it.
</br>
MyGsonNode has 2 fields, string pos and int id. it has a constructor that gets NodeData and converts the GeoLocation to string, and sets the key as the id. it also has a getLocation and setLocation functions. this class implements NodeData, so we can convert MyGsonNode to MyNodeData 
</br>
MyGsonEdje has 3 fields - src weight and dest. it has a constructor that get EdgeData and creates MyGsonEdje. this class implements EdgeData, so we can convert MyGsonEdje to MyEdgeData.</br>
back to MyDirectedWeightedGraph, save function. this function gets a json file name, creates MyGsonGraph and uses its save function. we are using MyGsonGraph in order to match the json files we have.
</br>
back to MyDirectedWeightedGraph, load function. the function gets a json file. creates a MyGsonGraph and tries to use its load function. if the load function succeed, we create a MyDirectedWeightedGraph and go through every node and edge in MyGsonGraph and copy it to the new MyDirectedWeightedGraph. 
</br>
</br>
### Algorithms Performance Analysis
For testing the algorithms performance we have created a graph generating class called GenerateGraph. the constructor of this class gets a node number and a number of edges. it has a function called generate, this function generates a graph with the number of nodes given, and every node has a random edges, the degree of every node is the number of edges given.
</br>
we have created a 1,000, 10,000 , 100,000 node graphs (we couldn't create a 1,000,000 nodes graph because we got a heapspace error), that each node has a degree of 20. then, we tested the next algorithms:
</br>
1. isConnected
2. shortestPathDist
3. center
4. tsp
5. save
6. load
</br>

The results were: </br>
isConnected with 1,000 nodes - 86 ms. </br>
isConnected with 10,000 nodes - 706 ms. </br>
isConnected with 100,000 nodes - 6 sec 169 ms. </br>

shortestPathDist with 1,000 nodes - 46 ms. </br>
shortestPathDist with 10,000 nodes - 210 ms. </br>
shortestPathDist with 100,000 nodes - 4 sec 197 ms. </br>

center with 1,000 nodes - 2 sec 576 ms. </br>
center with 10,000 nodes - didnt finish. </br>
center with 100,000 nodes - didnt finish. </br>

tsp with 1,000 nodes - 74 ms. </br>
tsp with 10,000 nodes - 653 ms. </br>
tsp with 100,000 nodes - 27 sec 774 ms. </br>

save with 1,000 nodes - 235 ms. </br>
save with 10,000 nodes - 645 ms. </br>
save with 100,000 nodes - 4 sec 262 ms. </br>

load with 1,000 nodes - 265 ms, </br>
load with 10,000 nodes - 582 ms. </br>
load with 100,000 nodes - 3 sec 191 ms. </br>

### GUI Interface
we have created a GUI interface. the main class is Gui_Menu. this class implements ActionListener. GUI_Menu has two options: create a new empty graph, and load a graph from an exiting file. after we chose an option and it was successful we will go to Gui_algo that has all the algorithms of DirectedWeightedGraphAlgorithms and an option to make changes in the graph. if we press on isConnected it will tell us if the graph is connected. if we press on shortestPathDist it will ask us to insert a src and dest and then it will compute the shortestPathDist and will also display it on the screen. if we press on shortestPath it will ask us to insert the src and dest and then it will compute the shortestPath and display it on the screen. if we press on center it will compute the center of the graph and will display it on the screen. if we press on tsp it will ask us to insert the key of the cities one by one and then it will compute and display the path on the screen. if we press on save it will ask us to insert the name of json file we want to save this graph by. if we press on load new graph, it will ask us to insert the json file name we want to load. if we press on change graph it will go to Gui_Gfunc. in that class if we press on getNode it will display all the info of the node on the screen. if we press on getEdge it will display all the info of the edge on the screen. if we press on addNode it will ask us to insert the id and location of the node, and will add it to the graph. if we press on connect it will aks us to insert the src weight and dest of the new edge, and will add it to the graph. if we press on removeNode it will ask us to insert the key of the node we want to remove, and then it will display that node on the screen. if we press on removeEdge it will ask us to insert the src and dest of the edge and then it will display the edge info on the screen. if we press on nodeSize it will display the node size on the screen. if we press on edgeSize it will display the number of edges on the screen. if we press on edgeIter it will go through all the edges in the graph and will display the info of the edge on the screen. if we press in nodeIter it will go through all the nodes in the graph and will display their info on the screen. if we press on getMC it will display the MC on the screen. if we press on go to Algo Func it will go to Gui_algo. if we press on Drow graph it go to Gui_MyGraphDrow that implements JFrame, and Gui_MyGraphDrow uses Gui_GraphPamelhelper that implements JPanel. it will display the graph on the screen.


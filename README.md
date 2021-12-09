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
this class also have a dfs function. this function 

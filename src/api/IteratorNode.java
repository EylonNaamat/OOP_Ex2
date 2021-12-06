package api;

import java.util.Iterator;

public class IteratorNode<NodeData> implements Iterator<NodeData> {

    private Iterator<MyNodeData> iterNode;

    public IteratorNode(Iterator<MyNodeData> iterNewNode){
        this.iterNode = iterNewNode;

    }


    @Override
    public boolean hasNext() {
        return this.iterNode.hasNext();
    }

    @Override
    public NodeData next() {
        return (NodeData)(this.iterNode.next());
    }
}

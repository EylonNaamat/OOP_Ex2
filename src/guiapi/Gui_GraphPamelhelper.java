package guiapi;

import api.EdgeData;
import api.MyDirectedWeightedGraph;
import api.MyDirectedWeightedGraphAlgorithms;
import api.NodeData;
import org.w3c.dom.Node;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class Gui_GraphPamelhelper extends JPanel {
    private int high=700;
    private int width=600;
    private MyDirectedWeightedGraph myGraph;
    private MyDirectedWeightedGraphAlgorithms myalgo;
    private List<NodeData> myList;
    public JButton edit= new JButton("edit");


    public Gui_GraphPamelhelper(MyDirectedWeightedGraphAlgorithms gr , List<NodeData> myList)
    {
        this.myalgo=gr;
        this.myGraph = (MyDirectedWeightedGraph) myalgo.getGraph();
        this.setPreferredSize(new Dimension(width,high));
        this.myList=myList;
    }
    public void paint(Graphics getdrow)
    {
        double xmin = Integer.MAX_VALUE;
        double xmax = 0;
        double ymin = Integer.MAX_VALUE;
        double ymax = 0;
        for(NodeData nod : this.myGraph.getMyNodes().values())
        {
            if(nod.getLocation().x()<xmin)
            {
                xmin = nod.getLocation().x();
            }
            if(nod.getLocation().x()>xmax)
            {
                xmax = nod.getLocation().x();
            }
            if(nod.getLocation().y()<ymin)
            {
                ymin = nod.getLocation().y();
            }
            if(nod.getLocation().y()>ymax)
            {
                ymax = nod.getLocation().y();
            }
        }
        double deltax = xmax-xmin;
        deltax=(this.width-80)/deltax;
        double deltay =ymax-ymin;
        deltay = (this.high-180)/deltay;
        Graphics2D drower = (Graphics2D) getdrow;
        double tempx=0;
        double tempy=0;
        double tempx2=0;
        double tempy2=0;
        int c1=0;
        int c2=0;
        int c3=0;
        Color tempcolor =new Color(0,0,0);
        drower.setStroke(new BasicStroke(2));
        for(NodeData nod : this.myGraph.getMyNodes().values())
        {
            drower.setFont(new Font(null,Font.BOLD,20));
            c1 = (int)(Math.random()*250);
            c2 = (int)(Math.random()*250);
            c3 = (int)(Math.random()*250);
            if(this.myList.contains(nod)) {
                drower.setPaint(new Color(255, 0, 0));
                drower.setFont(new Font(null,Font.BOLD,20));
                drower.setStroke(new BasicStroke(5));
            }
            else
            {
                drower.setPaint(tempcolor);

            }
            tempx= nod.getLocation().x()-xmin;
            tempx = (tempx*deltax)+20;
            tempy = nod.getLocation().y()-ymin;
            tempy =(tempy*deltay)+120;
            drower.drawOval((int)tempx,(int) tempy,40,40);
            drower.drawString(Integer.toString(nod.getKey()),(int)tempx+10,(int)tempy+20);
            drower.setFont(new Font(null,Font.BOLD,10));
            drower.setStroke(new BasicStroke(2));
            tempcolor = new Color(c1,c2,c3);
            drower.setPaint(tempcolor);
            for(EdgeData edg : this.myGraph.getMyEdges().get(nod.getKey()).values())
            {
                drower.setPaint(tempcolor);
                NodeData nod2 = this.myGraph.getMyNodes().get(edg.getDest());
                tempx2= nod2.getLocation().x()-xmin;
                tempx2 = (tempx2*deltax)+20;
                tempy2 = nod2.getLocation().y()-ymin;
                tempy2= (tempy2*deltay)+120;
                drower.drawLine((int)tempx+20,(int)tempy+30,(int)tempx2+20,(int)tempy2+10);
                drower.drawOval((int)((((tempx+tempx2+40)/2)+tempx+20)/2),(int)((((tempy+tempy2+40)/2)+tempy+20)/2),5,5);
                drower.drawString(Double.toString(edg.getWeight()),(int)((((tempx+tempx2+40)/2)+tempx+20)/2),(int)((((tempy+tempy2+40)/2)+tempy+20)/2));
            }
        }
        drower.setPaint(new Color(255, 0, 0));
        drower.setFont(new Font(null,Font.BOLD,20));
        drower.setStroke(new BasicStroke(5));
        String st = "";
        while (this.myList.size()>1)
        {
            NodeData src = this.myList.remove(0);
            st=st + src.getKey() +" --> " ;
            tempx= src.getLocation().x()-xmin;
            tempx = (tempx*deltax)+20;
            tempy = src.getLocation().y()-ymin;
            tempy =(tempy*deltay)+120;
            NodeData nod2 = this.myList.get(0);
            tempx2= nod2.getLocation().x()-xmin;
            tempx2 = (tempx2*deltax)+20;
            tempy2 = nod2.getLocation().y()-ymin;
            tempy2= (tempy2*deltay)+120;
            drower.drawLine((int)tempx+20,(int)tempy+30,(int)tempx2+20,(int)tempy2+10);
            drower.drawOval((int)((((tempx+tempx2+40)/2)+tempx+20)/2),(int)((((tempy+tempy2+40)/2)+tempy+20)/2),5,5);
        }
        if(this.myList.size()==1) {
            NodeData src = this.myList.remove(0);
            st=st + src.getKey() ;
        }
        this.edit.setBackground(Color.red);
        this.edit.setBounds( 0,0 ,80,50);
        this.add(edit);
        drower.drawString(st,100,25);
    }
}

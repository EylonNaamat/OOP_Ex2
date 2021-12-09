package guiapi;

import api.EdgeData;
import api.MyDirectedWeightedGraph;
import api.NodeData;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Gui_GraphPamelhelper extends JPanel {
    private int high=600;
    private int width=600;
    private MyDirectedWeightedGraph myGraph;

    public Gui_GraphPamelhelper(MyDirectedWeightedGraph gr)
    {
        this.myGraph=gr;
        this.setPreferredSize(new Dimension(width,high));
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
        deltay = (this.high-80)/deltay;
        Graphics2D drower = (Graphics2D) getdrow;
        double tempx=0;
        double tempy=0;
        double tempx2=0;
        double tempy2=0;
        int c1=0;
        int c2=0;
        int c3=0;
        Color tempcolor =new Color(0,0,0);
        drower.setStroke(new BasicStroke(3));
        drower.setFont(new Font(null,Font.BOLD,20));
        for(NodeData nod : this.myGraph.getMyNodes().values())
        {
            c1 = (int)(Math.random()*250);
            c2 = (int)(Math.random()*250);
            c3 = (int)(Math.random()*250);
            tempcolor = new Color(c1,c2,c3);
            drower.setPaint(tempcolor);
            tempx= nod.getLocation().x()-xmin;
            tempx = (tempx*deltax)+20;
            tempy = nod.getLocation().y()-ymin;
            tempy =(tempy*deltay)+20;
            drower.drawOval((int)tempx,(int) tempy,40,40);
            for(EdgeData edg : this.myGraph.getMyEdges().get(nod.getKey()).values())
            {
                drower.setPaint(tempcolor);
                NodeData nod2 = this.myGraph.getMyNodes().get(edg.getDest());
                tempx2= nod2.getLocation().x()-xmin;
                tempx2 = (tempx2*deltax)+20;
                tempy2 = nod2.getLocation().y()-ymin;
                tempy2= (tempy2*deltay)+20;
                drower.drawLine((int)tempx+20,(int)tempy+40,(int)tempx2+20,(int)tempy2);
            }
            drower.setPaint(Color.black);
            drower.drawString(Integer.toString(nod.getKey()),(int)tempx+10,(int)tempy+20);
        }
    }
}

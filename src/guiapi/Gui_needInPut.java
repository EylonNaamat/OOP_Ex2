package guiapi;

import api.*;
import org.w3c.dom.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Gui_needInPut implements ActionListener {

    private int width = 500;
    private int high = 500;
    private String active;
    private String[] needname;
    private MyDirectedWeightedGraphAlgorithms myalgo;
    private JFrame actionframe = new JFrame();
    private JLabel action = new JLabel();
    private JButton startdoing = new JButton();
    private JTextArea[] name;
    private JTextField[] input;



    public Gui_needInPut(MyDirectedWeightedGraphAlgorithms gr, String st , String[] arr)
    {
        this.active=st;
        this.myalgo = gr;
        this.needname = arr;
        this.name = new JTextArea[arr.length];
        this.input = new JTextField[arr.length];

        this.action.setBounds(100,10,350,40);
        this.action.setFont(new Font(null,Font.BOLD,30));
        this.action.setText(st);
        this.actionframe.add(this.action);

        int temphigh=0;
        for(int i=0; i<this.needname.length;i++)
        {
            this.name[i] = new JTextArea(this.needname[i]+":");
            temphigh =20+((i+1)*50);
            this.name[i].setBounds(20,temphigh,50,40);
            this.name[i].setFont(new Font(null,Font.BOLD,15));
            this.name[i].setBackground(Color.gray);
            this.actionframe.add(this.name[i]);

            this.input[i] = new JTextField();
            this.input[i].setBounds(100,temphigh,150,40);
            this.actionframe.add(this.input[i]);
        }
        this.startdoing.setBounds(150,temphigh+60,100,50);
        this.startdoing.addActionListener(this);
        this.startdoing.setBackground(Color.ORANGE);
        this.startdoing.setText(st);
        this.actionframe.add(this.startdoing);

        this.actionframe.setLayout(null);
        this.actionframe.setSize(width,high);
        this.actionframe.getContentPane().setBackground(Color.gray);
        this.actionframe.setVisible(true);
        this.actionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if(event.getSource() == this.startdoing)
        {
            if((this.active == "getNode")||(this.active == "removeNode"))
            {
                this.actionframe.dispose();
                int input = Integer.parseInt(this.input[0].getText());
                NodeData n = this.myalgo.getGraph().getNode(input);
                if(this.active == "removeNode")
                {
                    n=this.myalgo.getGraph().removeNode(input);
                }
                if(n==null)
                {
                    new Gui_TextShow(this.myalgo,"fail "+this.active+" node\n no node key "+input);
                }
                else {
                    String st = "the node :";
                    st = st + "\n id=" + n.getKey();
                    st = st + "\n x=" + n.getLocation().x();
                    st = st + "\n y=" + n.getLocation().y();
                    st = st + "\n z=" + n.getLocation().z();
                    st = st + "\n Weight=" + n.getWeight();
                    st = st + "\n Info=" + n.getInfo();
                    st = st + "\n Tag=" + n.getTag();
                    new Gui_TextShow(this.myalgo, st);
                }
            }
            if(this.active == "getEdge"||this.active == "removeEdge")
            {
                this.actionframe.dispose();
                int inputsrc = Integer.parseInt(this.input[0].getText());
                int inputdest = Integer.parseInt(this.input[1].getText());
                EdgeData tempEdje = this.myalgo.getGraph().getEdge(inputsrc, inputdest);
                if(this.active == "removeEdge") {
                   tempEdje = this.myalgo.getGraph().removeEdge(inputsrc, inputdest);
                }
                if(tempEdje==null)
                {
                    new Gui_TextShow(this.myalgo,"fail "+this.active+" Edge\n no edge");
                }
                else {
                    String st = "the Edje :";
                    st = st + "\n src=" + tempEdje.getSrc();
                    st = st + "\n dest=" + tempEdje.getDest();
                    st = st + "\n Weight=" + tempEdje.getWeight();
                    st = st + "\n Info=" + tempEdje.getInfo();
                    st = st + "\n Tag=" + tempEdje.getTag();
                    new Gui_TextShow(this.myalgo, st);
                }
            }
            if(this.active == "addNode")
            {
                this.actionframe.dispose();
                int inputkey = Integer.parseInt(this.input[0].getText());
                double inputx = Double.parseDouble(this.input[1].getText());
                double inputy = Double.parseDouble(this.input[2].getText());
                double inputz = Double.parseDouble(this.input[3].getText());
                MyGeoLocation temploc = new MyGeoLocation(inputx,inputy,inputz);
                NodeData n = new MyNodeData(inputkey,temploc);
                this.myalgo.getGraph().addNode(n);
                Gui_TextShow tempGUIgetnode = new Gui_TextShow(this.myalgo,"add successful");


            }
            if(this.active == "connect")
            {
                this.actionframe.dispose();
                int inputsrc = Integer.parseInt(this.input[0].getText());
                double inputw = Double.parseDouble(this.input[1].getText());
                int inputdest = Integer.parseInt(this.input[2].getText());
                this.myalgo.getGraph().connect(inputsrc,inputdest,inputw);
                Gui_TextShow tempGUIgetnode = new Gui_TextShow(this.myalgo,"add successful");

            }
            if(this.active == "shortestPathDist")
            {
                int inputsrc = Integer.parseInt(this.input[0].getText());
                int inputdest = Integer.parseInt(this.input[1].getText());
                String st ="the shortest dist from "+inputsrc+" to "+inputdest+": \n";
                st = st + (this.myalgo.shortestPathDist(inputsrc,inputdest));
                this.actionframe.dispose();
                Gui_TextShow tempText =new Gui_TextShow(this.myalgo,st);
            }
            if(this.active == "shortestPath")
            {
                int inputsrc = Integer.parseInt(this.input[0].getText());
                int inputdest = Integer.parseInt(this.input[1].getText());
                List<NodeData> ndlist = this.myalgo.shortestPath(inputsrc,inputdest);
                this.actionframe.dispose();
                new Gui_MyGraphDrow(this.myalgo,ndlist);
            }
        }
    }
}

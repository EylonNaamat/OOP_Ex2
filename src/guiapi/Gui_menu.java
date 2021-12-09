package guiapi;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_menu extends JFrame implements ActionListener {

    private JLabel head = new JLabel("menu");
    private JButton newGraph = new JButton("creat new empty graph");
    private JButton loadgraph = new JButton("load graph from file");

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args)
    {
        Gui_menu graphMenu = new Gui_menu();
        graphMenu.setSize(400,500);
        graphMenu.setVisible(true);
        graphMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

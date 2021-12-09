package guiapi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_LoadFail implements ActionListener {
    private int width = 500;
    private int high = 500;
    private JFrame failframe = new JFrame("successful");
    private JLabel messege = new JLabel("the load was fail:");
    private JButton goback = new JButton("try again");

    public Gui_LoadFail()
    {
        this.messege.setBounds(100,80,350,50);
        this.messege.setFont(new Font(null,Font.BOLD,30));
        this.failframe.add(this.messege);


        this.goback.setBounds(150,160,100,50);
        this.goback.addActionListener(this);
        this.goback.setBackground(Color.ORANGE);
        this.failframe.add(this.goback);

        this.failframe.setLayout(null);
        this.failframe.setSize(width,high);
        this.failframe.getContentPane().setBackground(Color.gray);
        this.failframe.setVisible(true);
        this.failframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public JFrame getframe()
    {
        return this.failframe;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.goback) {

        }
    }
}

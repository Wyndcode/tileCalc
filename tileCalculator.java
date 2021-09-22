/*
 Program that utilizes a GUI tool to calculate the cost of materials by shape
*/



import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class tileCalculator {
    //Initialization and a test to see if my class worked
    private int type;
    private int filler;
    public tileCalculator(int x){
        filler = x;
    }
    //Creates GUI
    public void doGUI(){
        JFrame f = new JFrame("Material by Dimension Calculator");
        f.setSize(500, 500);
        f.setLocation(300, 100);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel placemat = new JPanel();
        placemat.setOpaque(true);
        placemat.setBackground(Color.cyan);
        placemat.setLayout(null);
        f.add(placemat);

        JTextArea instructions = new JTextArea("Pick a floor shape");
        JButton circle = new JButton("Circular");
        JButton triangle = new JButton("Triangular");
        JButton rectangle = new JButton("Rectangular");
        JButton enter = new JButton("Enter");
        JTextArea moniLabel = new JTextArea("$/unit VVV");
        JTextArea input1Label = new JTextArea("Dimension VVV");
        JTextArea input2Label = new JTextArea("Dimension 2 VVV");
        instructions.setEditable(false);
        f.setVisible(true);
        placemat.setVisible(true);

        instructions.setSize(479, 40);
        instructions.setLocation(10, 10);
        instructions.setLineWrap(true);

        JTextArea inputtext = new JTextArea();
        JTextArea inputtext2 = new JTextArea();
        JTextArea output = new JTextArea();
        JTextArea moni = new JTextArea();

        inputtext.setSize(60, 20);
        inputtext.setLocation(10, 150);

        inputtext2.setSize(60, 20);
        inputtext2.setLocation(10, 220);

        moni.setSize(60, 20);
        moni.setLocation(10, 80);

        output.setSize(200,20);
        output.setLocation(10,320);
        output.setEditable(false);
        output.setLineWrap(true);
        output.setVisible(true);

        moniLabel.setSize(80, 20);
        moniLabel.setLocation(10, 55);
        moniLabel.setEditable(false);
        moniLabel.setLineWrap(true);

        input1Label.setSize(80, 20);
        input1Label.setLocation(10, 115);
        input1Label.setEditable(false);
        input1Label.setLineWrap(true);

        input2Label.setSize(80,20);
        input2Label.setLocation(10, 185);
        input2Label.setEditable(false);
        input2Label.setLineWrap(true);

        circle.setSize(150, 20);
        circle.setBounds(10, 50, 150, 20);
        circle.setBackground(Color.blue);
        circle.setLocation(10, 50);

        triangle.setSize(150, 20);
        triangle.setBounds(170, 50, 150, 20);
        triangle.setBackground(Color.red);
        triangle.setLocation(170, 50);

        rectangle.setSize(150, 20);
        rectangle.setBounds(330, 50, 150, 20);
        rectangle.setBackground(Color.green);
        rectangle.setLocation(330, 50);

        enter.setBackground(Color.yellow);
        enter.setSize(150, 20);
        enter.setBounds(10, 290, 150, 20);
        enter.setLocation(10, 290);

        placemat.add(instructions);
        placemat.add(circle);
        placemat.add(triangle);
        placemat.add(rectangle);
        placemat.add(inputtext);
        placemat.add(inputtext2);
        placemat.add(output);
        placemat.add(input1Label);
        placemat.add(input2Label);

        placemat.add(moni);
        placemat.add(enter);
        placemat.add(moniLabel);
        moniLabel.setVisible(false);
        moni.setVisible(false);
        output.setVisible(false);
        output.setEditable(false);
        enter.setVisible(false);
        inputtext.setVisible(false);
        inputtext2.setVisible(false);
        input1Label.setVisible(false);
        input2Label.setVisible(false);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double radius;
                double length;
                double width;
                double moneyperunit;
                if (type == 0) {
                    radius = Double.parseDouble(inputtext.getText());
                    moneyperunit = Double.parseDouble(moni.getText());
                    output.setText("Your total cost is $" + radius * radius * 3.14 * moneyperunit);
                } else if (type == 1) {
                    length = Double.parseDouble(inputtext.getText());
                    width = Double.parseDouble(inputtext2.getText());
                    moneyperunit = Double.parseDouble(moni.getText());
                    output.setText("Your total cost is $" + length * width * moneyperunit);
                } else {
                    length = Double.parseDouble(inputtext.getText());
                    width = Double.parseDouble(inputtext2.getText());
                    moneyperunit = Double.parseDouble(moni.getText());
                    output.setText("Your total cost is $" + length * width * moneyperunit * 0.5);
                }
                inputtext.setText("");
                inputtext2.setText("");
                moni.setText("");
                enter.setVisible(false);
                inputtext.setVisible(false);
                inputtext2.setVisible(false);
                moni.setVisible(false);
                moniLabel.setVisible(false);
                input1Label.setVisible(false);
                input2Label.setVisible(false);

                circle.setVisible(true);
                rectangle.setVisible(true);
                triangle.setVisible(true);
                instructions.setText("Pick a floor shape");
            }
        }
        );

        circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                circle.setVisible(false);
                triangle.setVisible(false);
                rectangle.setVisible(false);

                enter.setVisible(true);
                inputtext.setVisible(true);
                moni.setVisible(true);
                moniLabel.setVisible(true);
                input1Label.setVisible(true);
                output.setVisible(true);
                instructions.setText("Enter the radius of the floor, and the money per square unit, then click enter");
                output.setText("");
            }
        });

        triangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = 2;
                circle.setVisible(false);
                triangle.setVisible(false);
                rectangle.setVisible(false);

                enter.setVisible(true);
                inputtext.setVisible(true);
                inputtext2.setVisible(true);
                moni.setVisible(true);
                moniLabel.setVisible(true);
                input1Label.setVisible(true);
                input2Label.setVisible(true);
                output.setVisible(true);
                instructions.setText("Enter base and height of the triangle, and the money per square unit, then click enter");
                output.setText("");
            }
        });

        rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = 1;
                circle.setVisible(false);
                triangle.setVisible(false);
                rectangle.setVisible(false);

                enter.setVisible(true);
                inputtext.setVisible(true);
                inputtext2.setVisible(true);
                moni.setVisible(true);
                moniLabel.setVisible(true);
                input1Label.setVisible(true);
                input2Label.setVisible(true);
                output.setVisible(true);
                instructions.setText("Enter length and width of the rectangle, and the money per square unit, then click enter");
                output.setText("");
            }
        });
    }

    public static void main(String[] args) {
        tileCalculator bruh = new tileCalculator(1);
        bruh.doGUI();
    }
}
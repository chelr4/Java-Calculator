package src;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

class Calculator implements ActionListener{
    //setting up variables
    JFrame frame = new JFrame("Calculator");
    JTextField txt = new JTextField();
    JButton[] numbers = new JButton[10];
    JButton dec,equal,add,minus,multi,divide,clear;
    double num1, num2;
    String operator;

    public Calculator(){
        //creating different operand and operator buttons
        for(int i = 0; i < 10; i++){
            numbers[i] = new JButton(String.valueOf(i));
        }
        dec = new JButton(".");
        equal = new JButton("=");
        add = new JButton("+");
        minus = new JButton("-");
        multi = new JButton("*");
        divide = new JButton("/");
        clear = new JButton("C");

        //size of each button
        txt.setBounds(50, 25, 250, 60);
        txt.setBackground(Color.GRAY);
        txt.setEditable(false);
        numbers[0].setBounds(175, 325, 50, 40);
        dec.setBounds(100, 325, 50, 40);
        clear.setBounds(25, 325, 50 , 40);
        equal.setBounds(250,325,50,40);
        numbers[1].setBounds(25, 250, 50, 40);
        numbers[2].setBounds(100, 250, 50, 40);
        numbers[3].setBounds(175, 250, 50, 40);
        add.setBounds(250,250,50,40);
        numbers[4].setBounds(25, 175, 50, 40);
        numbers[5].setBounds(100, 175, 50, 40);
        numbers[6].setBounds(175, 175, 50, 40);
        minus.setBounds(250,175,50,40);
        numbers[7].setBounds(25, 100, 50, 40);
        numbers[8].setBounds(100, 100, 50, 40);
        numbers[9].setBounds(175, 100, 50, 40);
        multi.setBounds(250,100,50,20);
        divide.setBounds(250,120,50,20);
        frame.add(txt);
        for(int i = 0; i<10; i++){
            frame.add(numbers[i]);
            numbers[i].addActionListener(this);
        }
        frame.add(clear);
        frame.add(equal);
        frame.add(add);
        frame.add(minus);
        frame.add(multi);
        frame.add(dec);
        frame.add(divide);
        add.addActionListener(this);
        clear.addActionListener(this);
        equal.addActionListener(this);
        minus.addActionListener(this);
        multi.addActionListener(this);
        dec.addActionListener(this);
        divide.addActionListener(this);
        frame.setLayout(null);
        
        frame.setSize(345, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void input(String s){
        txt.setText(txt.getText() + s);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i< 10; i++){
            if(e.getSource() == numbers[i]){
                input(String.valueOf(i));
            }
        }
        if(e.getSource() == add){
            operator = "+";
            num1 = Double.parseDouble(txt.getText());
            txt.setText("");
        }
        else if(e.getSource() == minus){
            operator = "-";
            num1 = Double.parseDouble(txt.getText());
            txt.setText("");
        }
        else if(e.getSource() == multi){
            operator = "*";
            num1 = Double.parseDouble(txt.getText());
            txt.setText("");
        }
        else if(e.getSource() == divide){
            operator = "/";
            num1 = Double.parseDouble(txt.getText());
            txt.setText("");
        }
        else if(e.getSource() == equal){
            num2 = Double.parseDouble(txt.getText());
            switch(operator){
                case "+":
                    num1 += num2;
                    txt.setText(String.valueOf(num1));
                    break;
                case "-":
                    num1 -= num2;
                    txt.setText(String.valueOf(num1));
                    break;
                case "*":
                    num1 *= num2;
                    txt.setText(String.valueOf(num1));
                    break;
                case "/":
                    num1 /= num2;
                    txt.setText(String.valueOf(num1));
                    break;
            }
        }
        else if(e.getSource() == clear){
            txt.setText("");
        }
        else if(e.getSource() == dec){
            input(".");
        }
        
        
    }

    public static void main(String[] args) {
        new Calculator();
    }
    
}
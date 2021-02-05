package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {
    JFrame a = new JFrame("Cezar");
    JButton Button = new JButton("Encrypt");
    JTextField message = new JTextField("Write Message");
    JTextField SecondKey = new JTextField("Write SecondKey");
    JLabel EncryptedMessage = new JLabel("Message");
    ButtonGroup group = new ButtonGroup();
    String keys[] = { "key","1","2","3","4","5","6","7","8","9","10","11","12","13","14",
            "15","16","17","18","19","20","21","22","23","24","25","26","27"};
    JComboBox Box = new JComboBox(keys);
    JRadioButton smallButton = new JRadioButton("Encrypt", true);
    JRadioButton mediumButton = new JRadioButton("Decrypt", false);
    Message tempMes;

    public Frame(Message message) {
         tempMes=message;
    }



    public void CreateFrame(){
        group.add(smallButton);
        group.add(mediumButton);
        Box.setBounds(45,24,200,20);
        message.setBounds(45,70,200,20);
        message.setHorizontalAlignment(JTextField.CENTER);
        Button.setBounds(100,160,85,20);
        EncryptedMessage.setBounds(1,125,300,20);
        EncryptedMessage.setHorizontalAlignment(JTextField.CENTER);
        smallButton.setBounds(45,100,100,20);
        mediumButton.setBounds(175,100,100,20);
        SecondKey.setBounds(45,48,200,20);
        SecondKey.setHorizontalAlignment(JTextField.CENTER);
        a.add(SecondKey);
        a.add(Button);
        a.add(message);
        a.add(EncryptedMessage);
        a.add(Box);
        a.add(smallButton);
        a.add(mediumButton);
        a.setSize(300,230);
        a.setLayout(null);
        a.setVisible(true);
    }

    public void Button(){
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempMes.setData(message.getText(),SecondKey.getText(),Box.getSelectedIndex(),smallButton.isSelected());
                tempMes.processingMessage();
                EncryptedMessage.setText(tempMes.getMessage());

            }
        });
    }
}

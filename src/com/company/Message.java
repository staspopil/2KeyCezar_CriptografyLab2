package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Message {
    private String message = new String();
    private String secondKey = new String();
    private int key = 0;
    private boolean toEncrypt = true;
    ArrayList<Character> Alphabet = new ArrayList<Character>();
        public Message(){
          initAlphabet();
          System.out.println(Alphabet);
        }

        public void initAlphabet(){
            Alphabet.clear();
            for (int i = 97; i<123; i++){
            Alphabet.add((char)i);
            }
        }

        public void modifyAlphabet(){
          String temp = secondKey;
          Character t;
            for(int i = secondKey.length()-1; i>-1; i--){
              t=secondKey.charAt(i);
              if(!Alphabet.contains(t)){
                  JOptionPane.showMessageDialog(null,"The 2nd Key has unacceptable Symbols");
                    break;
              }
              Alphabet.remove(t);
              Alphabet.add(0,t);
              temp=temp.replaceAll(""+t,"");
            }
            System.out.println(Alphabet);
        }

        public void setData(String mes, String key, int k, boolean toEncrypt){
            this.message=mes.toLowerCase(Locale.ENGLISH);
            this.message=mes.replaceAll(" ", "");
            this.secondKey = key;
                if(secondKey.length()<7){
                    JOptionPane.showMessageDialog(null,"The 2nd Key must be more than 6");
                }
            this.key=k;
            this.toEncrypt=toEncrypt;
            initAlphabet();
            modifyAlphabet();
            if (this.key < 1 || this.key > 26) {
                JOptionPane.showMessageDialog(null,"The Key is not within permissible range");
            }
        }

        public String getMessage(){
            return this.message;
        }


        public void processingMessage(){
            char[] encryptedmes = message.toCharArray();
            char tempchar;
            int tempint;
            if (toEncrypt){
                for (int i = 0; i< message.length(); i++ ){

                    tempchar = message.charAt(i);
                    tempint = Alphabet.indexOf(tempchar);
                    tempint +=key;

                    if (!Alphabet.contains(tempchar)){
                        JOptionPane.showMessageDialog(null,"Unacceptable symbols in message");
                    break;
                    }

                    if (tempint<26) {
                        encryptedmes[i] = Alphabet.get(tempint);
                    }
                    else {
                        encryptedmes[i] = Alphabet.get(tempint-26);
                    }
                }
            }
            else {
                for (int i = 0; i< message.length(); i++ ){
                    tempchar = message.charAt(i);
                    tempint = Alphabet.indexOf(tempchar);
                    tempint -=key;

                    if (!Alphabet.contains(tempchar)){
                        JOptionPane.showMessageDialog(null,"Unacceptable symbols");
                        break;
                    }

                    if (tempint>0) {
                        encryptedmes[i] = Alphabet.get(tempint);
                    }
                    else {
                        encryptedmes[i] = Alphabet.get(26+tempint);
                    }
                }
            }
            message=String.valueOf(encryptedmes);
            message=message.toUpperCase(Locale.ROOT);
        }
}

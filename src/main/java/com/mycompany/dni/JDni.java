package com.mycompany.dni;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JDni extends JPanel implements Serializable{
    private String dni;
    private JTextField campoTexto;
    private JLabel label;
    private static final String letras[] = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
    
    public JDni() {
        campoTexto = new JTextField();
        label = new JLabel("Mete el DNI");
        this.setLayout(new GridLayout(1,2));
        this.add(label);
        this.add(campoTexto);
        this.setSize(300,50);
        this.setVisible(true);
        campoTexto.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                    campoTexto.setBackground(Color.white);
            }
            public void focusLost(FocusEvent e) {
                if(!validarDni()) {
                    campoTexto.setBackground(Color.red);
                } else {
                    campoTexto.setBackground(Color.green);
                }
            }
        });;
    }
    

    public String getDni() {
        return dni;
    }

    public JTextField getCampoTexto() {
        return campoTexto;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCampoTexto(JTextField campoTexto) {
        this.campoTexto = campoTexto;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
    
    private boolean validarDni() {
        boolean valido = false;
        dni = campoTexto.getText();
        try {
            int num = Integer.parseInt(dni.substring(0,8)) % 23;
            valido=validarLetra(num);
        } catch (Exception e) {
        }

        return valido;
    }
    
    private boolean validarLetra(int num) {
        boolean validar = false;
        int cont = 0;
        try {
            String letra = letras[num];
            if(letra.equals(dni.substring(dni.length()-1).toUpperCase())) {
                validar = true;
            }
            
        } catch (Exception e) {
        }
        
        return validar;
    }



    
}

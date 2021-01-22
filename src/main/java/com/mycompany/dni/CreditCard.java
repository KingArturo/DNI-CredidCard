package com.mycompany.dni;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Date;
import org.apache.commons.validator.routines.CreditCardValidator;


public class CreditCard extends javax.swing.JPanel {
    private String numero;
    private int mesCaducidad;
    private int anoCaducidad;
    private int codigo;

    
    @SuppressWarnings("empty-statement")
    public CreditCard() {
        initComponents();
        numTarjeta.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                numTarjeta.setForeground(Color.WHITE);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(!validarCreditCard()) {
                    numTarjeta.setForeground(Color.red);
                }
            }
        });;
        ano.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                ano.setForeground(Color.WHITE);
                mes.setForeground(Color.WHITE);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(!validarCaducidad()) {
                    ano.setForeground(Color.red);
                    mes.setForeground(Color.red);
                }
            }
        });
        ccv.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                ccv.setForeground(Color.WHITE);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(!validarCcv()) {
                    ccv.setForeground(Color.red);
                }
            }
        });
    }
    
    private boolean validarCreditCard() {
        boolean valido = false;
        numero = numTarjeta.getText();    
        CreditCardValidator c = new CreditCardValidator();
        if(c.isValid(numero)) {
            valido = true;
        }
        return valido;
    }
    
    public boolean validarCaducidad() {
        boolean valido = false;
        Date date = new Date();
        anoCaducidad = Integer.parseInt(ano.getText());
        mesCaducidad = Integer.parseInt(mes.getText());
        if(anoCaducidad > (date.getYear()+1900)) {
            valido = true;
            
        } else if(anoCaducidad == (date.getYear()+1900)) {
            if(mesCaducidad >= date.getMonth()) {
                valido = true;
            }
        }
        return valido;
    }
    
    public boolean validarCcv() {
        boolean valido = false;
        if(ccv.getText().length()== 3 || ccv.getText().length()== 4) {
            valido = true;
        }
        return valido;
    }

    public String getNumero() {
        return numero;
    }

    public int getMesCaducidad() {
        return mesCaducidad;
    }

    public int getAnoCaducidad() {
        return anoCaducidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setMesCaducidad(int mesCaducidad) {
        this.mesCaducidad = mesCaducidad;
    }

    public void setAnoCaducidad(int anoCaducidad) {
        this.anoCaducidad = anoCaducidad;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        numTarjeta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mes = new javax.swing.JTextField();
        ano = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ccv = new javax.swing.JTextField();

        setBackground(new java.awt.Color(35, 35, 35));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Numero");

        numTarjeta.setBackground(new java.awt.Color(0, 47, 58));
        numTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        numTarjeta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 47, 58)));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Caducidad");

        mes.setBackground(new java.awt.Color(0, 47, 58));
        mes.setForeground(new java.awt.Color(255, 255, 255));
        mes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 47, 58)));

        ano.setBackground(new java.awt.Color(0, 47, 58));
        ano.setForeground(new java.awt.Color(255, 255, 255));
        ano.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 47, 58)));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("/");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("cvv");

        ccv.setBackground(new java.awt.Color(0, 47, 58));
        ccv.setColumns(3);
        ccv.setForeground(new java.awt.Color(255, 255, 255));
        ccv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 47, 58)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ano, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ccv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(numTarjeta))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(numTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(ccv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ano;
    private javax.swing.JTextField ccv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField mes;
    private javax.swing.JTextField numTarjeta;
    // End of variables declaration//GEN-END:variables
}
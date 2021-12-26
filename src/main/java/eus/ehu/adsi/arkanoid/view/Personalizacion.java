package eus.ehu.adsi.arkanoid.view;

import eus.ehu.adsi.arkanoid.Arkanoid;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Personalizacion extends JFrame {
    public Personalizacion(){
        initComponents();
    }

    //variables
    JButton aceptar;
    JComboBox desplegableFondo;
    JComboBox desplegablePelota;
    JComboBox desplegableLadrillo;
    JComboBox desplegablePaddle;
    JComboBox desplegableMusica;

    //crear la vista de personalizacion
    private void initComponents(){
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();
        JPanel panel11 = new JPanel();
        JPanel panel12 = new JPanel();

        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label6 = new JLabel();

        desplegableFondo = new JComboBox();
        desplegablePelota = new JComboBox();
        desplegableLadrillo = new JComboBox();
        desplegablePaddle = new JComboBox();
        desplegableMusica = new JComboBox();

        aceptar = new JButton();

        getContentPane().setLayout(new GridLayout(10, 1, 0, 0));
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2));
        setResizable(false);

        getContentPane().add(panel1);
        label1.setText("PERSONALIZACION");
        label1.setVisible(true);
        label1.setFont(new Font("Segoe IU",Font.PLAIN,Toolkit.getDefaultToolkit().getScreenSize().width/90));
        panel1.add(label1);

        getContentPane().add(panel2);
        Label l = new Label(" ");
        l.setVisible(true);
        l.setFont(new Font("Segoe IU",Font.PLAIN,Toolkit.getDefaultToolkit().getScreenSize().width/90));
        panel2.add(l);

        getContentPane().add(panel3);
        label2.setText("Elige el color del fondo");
        label2.setVisible(true);
        label2.setFont(new Font("Segoe IU",Font.PLAIN,Toolkit.getDefaultToolkit().getScreenSize().width/90));
        panel3.add(label2);

        getContentPane().add(panel4);
        desplegableFondo.addItem("Rojo");
        desplegableFondo.addItem("Naranja");
        desplegableFondo.addItem("Azul");
        desplegableFondo.addItem("Amarillo");
        desplegableFondo.addItem("Verde");
        desplegableFondo.addItem("Rosa");
        desplegableFondo.addItem("Negro");
        desplegableFondo.addItem("Blanco");
        desplegableFondo.setFont(new Font("Segoe IU",Font.PLAIN,Toolkit.getDefaultToolkit().getScreenSize().width/50));
        panel4.add(desplegableFondo);

        getContentPane().add(panel5);
        label3.setText("Elige el color de la pelota");
        label3.setVisible(true);
        label3.setFont(new Font("Segoe IU",Font.PLAIN,Toolkit.getDefaultToolkit().getScreenSize().width/90));
        panel5.add(label3);

        getContentPane().add(panel6);
        desplegablePelota.addItem("Rojo");
        desplegablePelota.addItem("Naranja");
        desplegablePelota.addItem("Azul");
        desplegablePelota.addItem("Amarillo");
        desplegablePelota.addItem("Verde");
        desplegablePelota.addItem("Rosa");
        desplegablePelota.addItem("Blanco");
        desplegablePelota.setFont(new Font("Segoe IU",Font.PLAIN,Toolkit.getDefaultToolkit().getScreenSize().width/50));
        panel6.add(desplegablePelota);

        getContentPane().add(panel7);
        label4.setText("Elige el color de los ladrillos");
        label4.setVisible(true);
        label4.setFont(new Font("Segoe IU",Font.PLAIN,Toolkit.getDefaultToolkit().getScreenSize().width/90));
        panel7.add(label4);

        getContentPane().add(panel8);
        desplegableLadrillo.addItem("Rojo");
        desplegableLadrillo.addItem("Naranja");
        desplegableLadrillo.addItem("Azul");
        desplegableLadrillo.addItem("Amarillo");
        desplegableLadrillo.addItem("Verde");
        desplegableLadrillo.addItem("Rosa");
        desplegableLadrillo.addItem("Blanco");
        desplegableLadrillo.setFont(new Font("Segoe IU",Font.PLAIN,Toolkit.getDefaultToolkit().getScreenSize().width/50));
        panel8.add(desplegableLadrillo);

        getContentPane().add(panel9);
        label5.setText("Elige el color del paddle");
        label5.setVisible(true);
        label5.setFont(new Font("Segoe IU",Font.PLAIN,Toolkit.getDefaultToolkit().getScreenSize().width/90));
        panel9.add(label5);

        getContentPane().add(panel10);
        desplegablePaddle.addItem("Rojo");
        desplegablePaddle.addItem("Naranja");
        desplegablePaddle.addItem("Azul");
        desplegablePaddle.addItem("Amarillo");
        desplegablePaddle.addItem("Verde");
        desplegablePaddle.addItem("Rosa");
        desplegablePaddle.addItem("Blanco");
        desplegablePaddle.setFont(new Font("Segoe IU",Font.PLAIN,Toolkit.getDefaultToolkit().getScreenSize().width/50));
        panel10.add(desplegablePaddle);

        getContentPane().add(panel11);
        label6.setText("Elige los sonidos");
        label6.setVisible(true);
        label6.setFont(new Font("Segoe IU",Font.PLAIN,Toolkit.getDefaultToolkit().getScreenSize().width/90));
        panel11.add(label6);

        getContentPane().add(panel12);
        desplegableMusica.addItem("Ninguno");
        desplegableMusica.addItem("Con sonido");
        desplegableMusica.setFont(new Font("Segoe IU",Font.PLAIN,Toolkit.getDefaultToolkit().getScreenSize().width/50));
        panel12.add(desplegableMusica);

        getContentPane().add(aceptar);
        aceptar.setText("Aceptar");
        aceptar.setFont(new Font("Segoe IU",Font.PLAIN,Toolkit.getDefaultToolkit().getScreenSize().width/50));
        aceptar.addActionListener(new BtnAceptar());
    }
    
    //accion para cuando pulsa el boton
    public class BtnAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            String colorFondo = (String) desplegableFondo.getSelectedItem();
            String colorPelota = (String) desplegablePelota.getSelectedItem();
            String colorLadrillos = (String) desplegableLadrillo.getSelectedItem();
            String colorPaddle = (String) desplegablePaddle.getSelectedItem();
            String sonido = (String) desplegableMusica.getSelectedItem();
            Arkanoid.recibirPersonalizacion(colorFondo, colorPelota, colorLadrillos, colorPaddle, sonido);
        }
    }
}
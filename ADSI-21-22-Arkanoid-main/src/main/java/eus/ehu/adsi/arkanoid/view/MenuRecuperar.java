package eus.ehu.adsi.arkanoid.view;

import eus.ehu.adsi.arkanoid.Arkanoid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuRecuperar extends JFrame {
    public MenuRecuperar(){
        initComponents();
    }

    //variables
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;

    JTextField tf1;
    JPasswordField tf2;

    JButton btn;

    public void initComponents() {
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        tf1 = new JTextField();
        tf2 = new JPasswordField();

        btn = new JButton();

        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();

        getContentPane().setLayout(new GridLayout(4, 1, 0, 0));
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2));
        setResizable(false);

        JPanel vacio = new JPanel();
        getContentPane().add(vacio);

        getContentPane().add(panel1);
        label1.setText("OLVIDÉ MI CONTRASEÑA");
        label1.setFont(new Font("Segoe IU", Font.PLAIN, Toolkit.getDefaultToolkit().getScreenSize().width / 50));
        panel1.add(label1);

        getContentPane().add(panel2);
        panel2.setLayout(new GridLayout(1, 2, 0, 0));
        label2.setText("USUARIO : ");
        label2.setFont(new Font("Segoe IU", Font.PLAIN, Toolkit.getDefaultToolkit().getScreenSize().width / 90));
        tf1.setFont(new Font("Segoe IU", Font.PLAIN, Toolkit.getDefaultToolkit().getScreenSize().width / 90));
        panel2.add(label2);
        panel2.add(tf1);

        getContentPane().add(panel3);
        panel3.setLayout(new GridLayout(1, 2, 0, 0));
        label3.setText("NUEVA CONTRASEÑA: ");
        label3.setFont(new Font("Segoe IU", Font.PLAIN, Toolkit.getDefaultToolkit().getScreenSize().width / 90));
        tf2.setFont(new Font("Segoe IU", Font.PLAIN, Toolkit.getDefaultToolkit().getScreenSize().width / 90));
        panel3.add(label3);
        panel3.add(tf2);

        getContentPane().add(panel4);
        btn.setText("ACEPTAR");
        btn.setFont(new Font("Segoe IU",Font.PLAIN,Toolkit.getDefaultToolkit().getScreenSize().width/50));
        btn.addActionListener(new BtnAceptar());
        panel4.add(vacio);
        panel4.add(btn);
        panel4.add(vacio);
    }

    public class BtnAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton bt = (JButton) e.getSource();
            String usuario = (String) tf1.getText();
            String contra = (String) tf2.getText();
            if(!Arkanoid.cambioContra(usuario, contra)){ //Si no existe el usuario
                JOptionPane.showMessageDialog(null, "Usuario no correcto");
            }
        }
    }
}

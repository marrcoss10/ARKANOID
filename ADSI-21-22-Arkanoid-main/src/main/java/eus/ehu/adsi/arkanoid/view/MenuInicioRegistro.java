package eus.ehu.adsi.arkanoid.view;

import eus.ehu.adsi.arkanoid.Arkanoid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInicioRegistro  extends JFrame {
    public MenuInicioRegistro(){
        initComponents();
    }

    //variables
    JButton bt1;
    JButton bt2;
    JButton bt3;
    JTextField tf1;
    JPasswordField tf2;

    //creamos la vista
    public void initComponents() {
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();


        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();

        tf1 = new JTextField();
        tf2 = new JPasswordField();

        bt1 = new JButton();
        bt2 = new JButton();
        bt3 = new JButton();


        getContentPane().setLayout(new GridLayout(4, 1, 0, 0));
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2));
        setResizable(false);

        getContentPane().add(panel1);
        label1.setText("MENÚ INICIO SESIÓN Y REGISTRO");
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
        label3.setText("CONTRASEÑA: ");
        label3.setFont(new Font("Segoe IU", Font.PLAIN, Toolkit.getDefaultToolkit().getScreenSize().width / 90));
        tf2.setFont(new Font("Segoe IU", Font.PLAIN, Toolkit.getDefaultToolkit().getScreenSize().width / 90));
        panel3.add(label3);
        panel3.add(tf2);

        getContentPane().add(panel4);
        panel4.setLayout(new GridLayout(1, 3, 0, 0));
        bt1.setText("Registrarse");
        bt2.setText("Iniciar sesión");
        bt3.setText("Olvidé contraseña");
        bt1.setFont(new Font("Segoe IU", Font.PLAIN, Toolkit.getDefaultToolkit().getScreenSize().width / 50));
        bt2.setFont(new Font("Segoe IU", Font.PLAIN, Toolkit.getDefaultToolkit().getScreenSize().width / 50));
        bt3.setFont(new Font("Segoe IU", Font.PLAIN, Toolkit.getDefaultToolkit().getScreenSize().width / 50));
        bt1.addActionListener(new BtnRegistro());
        bt2.addActionListener(new BtnInicioSesion());
        bt3.addActionListener(new BtnOlvidarContra());
        panel4.add(bt1);
        panel4.add(bt2);
        panel4.add(bt3);
    }

        //accion para cuando pulsa el boton registro
        public class BtnRegistro implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                String usuario = (String) tf1.getText();
                String contra = (String) tf2.getText();
                Arkanoid.registro(usuario, contra);
            }
        }

        //accion para cuando pulsa el boton registro
        public class BtnInicioSesion implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                String usuario = (String) tf1.getText();
                String contra = (String) tf2.getText();
                if(!Arkanoid.inicioSesion(usuario, contra)){ //si no es correcto
                    JOptionPane.showMessageDialog(null, "Usuario no correcto");
                }
            }
        }

        //accion para cuando pulsa el boton registro
        public class BtnOlvidarContra implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                Arkanoid.olvidarContra();
            }
        }
}
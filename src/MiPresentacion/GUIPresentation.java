package MiPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;


public class GUIPresentation extends JFrame {
    //attributes
    private JButton miFoto, miHobby, misExpectativas;
    private Title title;
    private JPanel contenedordeBotones, contenedordeImagenes;
    private Listener listener;
    private JLabel imageLabel;
    private JTextArea expectativesText;


    //todos
    public GUIPresentation() {
        initGUI();
        this.setTitle("MyPresentation");
        this.setSize(600, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        title = new Title("Una presentacion sobre esta persona maravillosa", Color.MAGENTA);
        this.add(title, BorderLayout.NORTH);
        contenedordeBotones = new JPanel();
        contenedordeImagenes = new JPanel();
        miFoto = new JButton("Esta soy yo");
        miHobby = new JButton("Mis hobbies son");
        misExpectativas = new JButton("Mis expectativas:");
        listener = new Listener();
        imageLabel = new JLabel();
        expectativesText = new JTextArea( 10,12);

        contenedordeImagenes.setBorder(BorderFactory.createTitledBorder(null,"About me", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.MONOSPACED,Font.PLAIN, 16), Color.BLACK));
        contenedordeImagenes.add(imageLabel);
        contenedordeBotones.add(miFoto);
        contenedordeBotones.add(miHobby);
        contenedordeBotones.add(misExpectativas);

        miFoto.addActionListener(listener);
        miFoto.addMouseListener(listener);
        miFoto.addKeyListener(listener);
        miHobby.addActionListener(listener);
        miHobby.addKeyListener(listener);
        miHobby.addMouseListener(listener);
        misExpectativas.addActionListener(listener);
        misExpectativas.addKeyListener(listener);
        misExpectativas.addMouseListener(listener);




        this.add(contenedordeBotones, BorderLayout.SOUTH);
        this.add(contenedordeImagenes, BorderLayout.NORTH);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIPresentation myGUI = new GUIPresentation();
            }
        });
    }

    private class Listener implements ActionListener, KeyListener, MouseListener {
        private ImageIcon image;
        @Override
        public void actionPerformed(ActionEvent e) {
            imageLabel.setIcon(null);
            contenedordeImagenes.remove(expectativesText);
            if(e.getSource() == miFoto){
                this.image = new ImageIcon(getClass().getResource("/Recursos/imagenPresentacion.jpg"));
                imageLabel.setIcon(image);
            }
            revalidate();
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            imageLabel.setIcon(null);

            if(e.getKeyCode()==KeyEvent.VK_M){

                expectativesText.setText("Yo espero tener buena plata vos sabes mi papá \n" + "Me puedes contactar a través de sarahy.caicedo@correounivalle.edu.co");
                expectativesText.setBackground(null);
                expectativesText.setForeground(Color.BLACK);
                contenedordeImagenes.add(expectativesText);
            }
            revalidate();
            repaint();

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {

                if(e.getClickCount() == 2 && e.getSource() == miHobby){
                    imageLabel.setIcon(null);
                    contenedordeImagenes.remove(expectativesText);
                    this.image = new ImageIcon(getClass().getResource("/Recursos/ver-anime-online-1.jpg"));
                    GUIPresentation.this.imageLabel.setIcon(this.image);
            }
            revalidate();
            repaint();

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
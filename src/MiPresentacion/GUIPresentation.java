package MiPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUIPresentation extends JFrame {

    private JButton myPhoto, myHobby, myExpectations;
    private Title title;
    private JPanel containerButtons, containerImage;
    private Listener listener;
    private JLabel imageLabel;
    private JTextArea expectatives;

    public GUIPresentation()
    {
        initGUI();
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        this.setTitle("My presentation");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initGUI() {
        title = new Title("Una presentacion sobre mi", Color.PINK);
        this.add(title, BorderLayout.NORTH);
        myPhoto = new JButton("Esta soy yo");
        myHobby = new JButton("Mis hobbys");
        myExpectations = new JButton("Mis expectativas");
        containerButtons = new JPanel();
        containerImage = new JPanel();
        listener = new Listener();
        imageLabel = new JLabel();
        expectatives = new JTextArea(10,12);

        containerImage.setBorder(BorderFactory.createTitledBorder(null, "About Me",
                TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION,
                new Font (Font.MONOSPACED, Font.PLAIN, 20), Color.BLACK));

        containerImage.add(imageLabel);

        containerButtons.add(myPhoto);
        containerButtons.add(myHobby);
        containerButtons.add(myExpectations);

        myPhoto.addActionListener(listener);
        myPhoto.addMouseListener(listener);
        myPhoto.addKeyListener(listener);
        myHobby.addActionListener(listener);
        myHobby.addMouseListener(listener);
        myHobby.addKeyListener(listener);
        myExpectations.addActionListener(listener);
        myExpectations.addMouseListener(listener);
        myExpectations.addKeyListener(listener);

        this.add(containerButtons, BorderLayout.SOUTH);
        this.add(containerImage, BorderLayout.CENTER);

    }

    public static void main (String[] arg){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {


                GUIPresentation myPresen = new GUIPresentation();
            }

        });


    }

    private class Listener implements ActionListener, KeyListener, MouseListener {

        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {


            containerImage.remove(expectatives);


            if(e.getSource() == myPhoto){
                imageLabel.setIcon(null);
                //JOptionPane.showMessageDialog(null, "Press button");
                this.image = new ImageIcon(getClass().getResource("/Recursos/imagenPresentacion.jpg"));
                imageLabel.setIcon(image);

            }

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            imageLabel.setIcon(null);


            if(e.getKeyCode()==KeyEvent.VK_M) {

                expectatives.setText("Quiero tener mucha plata vos sabes, malo emitir vocablo\n" + "My contact is sarahy.caicedo@correounivalle.edu.co");
                expectatives.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));
                expectatives.setBackground(null);
                expectatives.setForeground(Color.BLACK);
                containerImage.add(expectatives);
            }

            revalidate();
            repaint();

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {

            if(e.getClickCount()==2 && e.getSource() == myHobby){
                imageLabel.setIcon(null);
                containerImage.remove(expectatives);
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
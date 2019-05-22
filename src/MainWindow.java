import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;


public class MainWindow extends JFrame implements ActionListener, Runnable {

    private JLabel createLabel(String text,int x_pos, int y_pos) {

        JLabel jl = new JLabel(text);
        Dimension size = jl.getPreferredSize();
        jl.setBounds(x_pos, y_pos, size.width, size.height);
        return jl;

    }

    private JButton createButton(String text, int x_pos, int y_pos) {

        JButton jb = new JButton(text);
        Dimension size = jb.getPreferredSize();
        jb.setBounds(x_pos, y_pos, size.width, size.height);
        return jb;
    }


    public MainWindow(String title) throws HeadlessException {
        super(title);
    }

    public static int screenWidth(){

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension size = toolkit.getScreenSize();
        return size.width;

    }

    public static int screenHeight(){

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension size = toolkit.getScreenSize();
        return size.height;

    }

    public MainWindow() throws FileNotFoundException, IOException  {

        FileReader file = new FileReader("hello.vec");

        String line = null;

        ArrayList imageData = new ArrayList();

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader =
                new BufferedReader(file);

        while((line = bufferedReader.readLine()) != null) {
            //System.out.println(line);
            imageData.add(line);
        }

        System.out.println(imageData.get(0));



        // Always close files.
        bufferedReader.close();

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.white);
        //JPanel imagePanel = new JPanel();
        //imagePanel.setBackground(Color.white);
        //imagePanel.setLayout(null);


        panel1.setLayout(null);

        JLabel testText = createLabel("Luke's Paint", 0, 0  );

        JButton testButton = createButton("There", 5, 15);


        //adds the objects to the panel
        panel1.add(testText);
        panel1.add(testButton);




        //Add the panel to the main window
        getContentPane().add(panel1);
        // Set up stuff

        setLayout(new BorderLayout());
        add(panel1, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Display the window.
        setPreferredSize(new Dimension(300, 300));
        setLocation(new Point(100,100));
        pack();
        setVisible(true);
    }

    @Override
    public void run() {
        //new MainWindow();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MainWindow();
                } catch (FileNotFoundException ex) {
                    System.out.println(
                            "Unable to open file");
                } catch (IOException ex) {
                    System.out.println(
                            "Error reading file");
                    // Or we could just do this:
                    // ex.printStackTrace();
                }
            }
        });
    }

}

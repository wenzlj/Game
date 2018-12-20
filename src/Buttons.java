import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import java.lang.*;



public class Buttons<Button> extends JFrame {


    private final int VERTICAL_BUTTONS = 4;
    private final int HORIZONTAL_BUTTONS = 4;
    private JButton[][] buttons = new JButton[VERTICAL_BUTTONS][HORIZONTAL_BUTTONS];
    static int seconds = 0;
    private int waittime;
    ;
    private int buttonnumber;
    ;
    public int buttoncheck;
    public long start;
    public long end;
    public long time;
    public JPanel Time;

    public Buttons() {
        super("ButtonPanel");
        this.setSize(800, 800);
        this.setLayout(new GridLayout(VERTICAL_BUTTONS, HORIZONTAL_BUTTONS));
        for (int i = 0; i < VERTICAL_BUTTONS; i++) {
            for (int g = 0; g < HORIZONTAL_BUTTONS; g++) {
                JButton a = new JButton();
                buttons[i][g] = a;
                buttons[i][g].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        a.setBackground(Color.GRAY);
                        a.setEnabled(false);
                        buttoncheck=buttoncheck-1;

                        if(buttoncheck==0)  {
                            end = System.currentTimeMillis();
                            time = end-start;
                            System.out.println("Zeit[ms]:" + time);

                            new Thread() {

                                public void run() {
                                    waittime = new Random().nextInt(3000) + 3000;
                                    buttonnumber = new Random().nextInt(4) + 1;
                                    try {
                                        Thread.sleep(waittime);
                                    } catch (Exception ex) {

                                    }
                                    for (int i = 0; i < buttonnumber; i++) {
                                        int a = new Random().nextInt(4);
                                        int b = new Random().nextInt(4);
                                        buttons[a][b].setBackground(Color.GREEN);
                                        buttons[a][b].setEnabled(true);
                                        buttoncheck = buttoncheck + 1;
                                    }
                                    start = System.currentTimeMillis();

                                }


                            }.start();

                        }
                    }
                });
                add(a);
                a.setBackground(Color.GRAY);
                a.setEnabled(false);
            }
        }
        this.setVisible(true);

            new Thread() {

                public void run() {
                    buttoncheck = 0;
                    waittime = new Random().nextInt(3000) + 3000;
                    buttonnumber = new Random().nextInt(4) + 1;
                    try {
                        Thread.sleep(waittime);
                    } catch (Exception ex) {

                    }
                    for (int i = 0; i < buttonnumber; i++) {
                        int a = new Random().nextInt(4);
                        int b = new Random().nextInt(4);
                        if(buttons[a][b].isEnabled()){

                        }
                        else{
                            buttons[a][b].setBackground(Color.GREEN);
                            buttons[a][b].setEnabled(true);
                            buttoncheck = buttoncheck + 1;
                        }

                    }
                    start = System.currentTimeMillis();
                }


            }.start();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}



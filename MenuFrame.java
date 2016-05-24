package Bombbbbb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class MenuFrame extends JFrame {
    private JRadioButtonMenuItem[] LevelItems;
    private JCheckBoxMenuItem[] styleItems;
    private ButtonGroup fontButtonGroup;
    private ButtonGroup levelButtonGroup;
    private int style;

    public MenuFrame() {
        super("扫雷Game");

        JMenu fileMenu = new JMenu("Start");
        fileMenu.setMnemonic('S');

        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);

        String[] level = { "Low", "Normal", "High" };

        JMenu LevelMenu = new JMenu("Leval");
        LevelMenu.setMnemonic('L');

        LevelItems = new JRadioButtonMenuItem[level.length];
        levelButtonGroup = new ButtonGroup();
        ItemHandler itemHandler = new ItemHandler();

        for (int count = 0; count < level.length; count++) {
            LevelItems[count] = new JRadioButtonMenuItem(level[count]);
            LevelMenu.add(LevelItems[count]);
            levelButtonGroup.add(LevelItems[count]);
            LevelItems[count].addActionListener(itemHandler);
        }

        LevelItems[0].setSelected(true);
        fileMenu.add(LevelMenu);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('x');
        fileMenu.add(exitItem);
        exitItem.addActionListener(

                new ActionListener() {

                    public void actionPerformed(ActionEvent event) {
                        System.exit(0);
                    }
                });

        bar.add(fileMenu);

        JMenu formatMenu = new JMenu("Why");
        formatMenu.setMnemonic('W');

        JMenuItem aboutItem = new JMenuItem("About...");
        aboutItem.setMnemonic('A');
        formatMenu.add(aboutItem);
        aboutItem.addActionListener(

                new ActionListener() {

                    public void actionPerformed(ActionEvent event) {
                        JOptionPane.showMessageDialog(MenuFrame.this, "扫雷 V1.0", "About", JOptionPane.PLAIN_MESSAGE);
                    }
                });

        bar.add(formatMenu);

       

    }

    private class ItemHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub

        }

    }

}

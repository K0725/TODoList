package classes;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Footer extends JPanel{

    JButton addTask;
    JButton clear;


    Border emptyBorder = BorderFactory.createEmptyBorder();

    Footer()
    {
        this.setPreferredSize(new Dimension(400,60));

        addTask = new JButton("add task");
        addTask.setBorder(emptyBorder);
        addTask.setFont(new Font("Sans-serif",Font.PLAIN, 20));
        addTask.setVerticalAlignment(JButton.BOTTOM);
        //addTask.setBackground(Color.white);
        this.add(addTask);


        this.add(Box.createHorizontalStrut(20));//Space between buttons
        clear = new JButton("Clear finished tasks");
        clear.setFont(new Font("Sans-serif",Font.PLAIN, 20));
        clear.setBorder(emptyBorder);
        //clear.setBackground();
        this.add(clear);


    }

    public JButton getNewTask(){
        return addTask;
    }

    public JButton getClear() {
        return clear;
    }

    public static class List extends JPanel{

        List()
        {

            GridLayout layout = new GridLayout(10,1);
            layout.setVgap(5);

            this.setLayout(layout);
            this.setPreferredSize(new Dimension(400,560));

        }

        public void updateNumbers()
        {
            Component[] listItems = this.getComponents();

            for(int i = 0;i<listItems.length;i++)
            {
                if(listItems[i] instanceof Task)
                {
                    ((Task)listItems[i]).changeIndex(i+1);
                }
            }

        }

        public void removeCompletedTasks()
        {

            for(Component c : getComponents())
            {
                if(c instanceof Task)
                {
                    if(((Task)c).getState())
                    {
                        remove(c);
                        updateNumbers();
                    }
                }
            }

        }
    }
}


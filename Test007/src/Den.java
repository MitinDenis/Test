import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Den extends JFrame {
    JTextField login_field;
    JTextField pass_field;
    JRadioButton adv_yes, adv_no;
    JCheckBox check;
    public Den(){
        super("App");
        super.setBounds(350,350, 400, 200);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5,2,2,10));

        JLabel login = new JLabel("Логин: ");
        login_field = new JTextField("",1);
        JLabel pass = new JLabel("Пароль: ");
        pass_field = new JTextField("",1);

        container.add(login);
        container.add(login_field);
        container.add(pass);
        container.add(pass_field);

        adv_yes = new JRadioButton("Принять рекламу");
        adv_no = new JRadioButton("Не принимать рекламу");

        check = new JCheckBox("Согласен", false);

        JButton send_button = new JButton("Далее");

        adv_yes.setSelected(true);

        container.add(adv_yes);
        container.add(adv_no);

        ButtonGroup group =new ButtonGroup();
        group.add(adv_yes);
        group.add(adv_no);

        container.add(check);
        container.add(send_button);


        send_button.addActionListener(new ButtonEventMeneger());

    }
    class ButtonEventMeneger implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = login_field.getText();
            String pass = pass_field.getText();

            String isadv = "Вы приняли рекламу";
            if (!adv_yes.isSelected())
                isadv = "Вы не приняли рекламу";
            boolean checkBox = check.isSelected();

            if(pass.equals("1234"))
                JOptionPane.showMessageDialog(null,  isadv +
                    "\n Вы согласны " + checkBox,"Привет " + name, JOptionPane.PLAIN_MESSAGE);
            else
                JOptionPane.showMessageDialog(null,
                        " Вы ввели не верный пароль. Попробуйте 1234) ","", JOptionPane.PLAIN_MESSAGE);
        }
    }


}
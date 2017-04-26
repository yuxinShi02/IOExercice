package EXO4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tearsyu on 21/04/17.
 */
public class CarnetView extends JFrame implements ActionListener{
    private JButton bsave, brestore;
    private JLabel fn, ln, tel, email, addr;
    private JTextField tfn, tln, ttel ,temail, taddr;

    public CarnetView(){
        super("Carnet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(null);

        bsave = new JButton("Save");
        bsave.setBounds(30, 380, 100, 30);
        bsave.addActionListener(this);
        brestore = new JButton("Restore");
        brestore.setBounds(330, 380, 100, 30);
        brestore.addActionListener(this);

        fn = new JLabel("Firstname *");
        fn.setBounds(30, 20, 180, 30);
        ln = new JLabel("Lastname");
        ln.setBounds(250, 20, 180, 30);
        tel = new JLabel("Tel");
        tel.setBounds(30, 100, 180, 30);
        email = new JLabel("Emial");
        email.setBounds(250, 100, 180, 30);
        addr = new JLabel("Address");
        addr.setBounds(30, 180, 180, 30);

        tfn = new JTextField(20);
        tfn.setBounds(30, 50, 180, 30);
        tln = new JTextField(20);
        tln.setBounds(250, 50, 180, 30);
        ttel = new JTextField(30);
        ttel.setBounds(30, 130, 180, 30);
        temail = new JTextField(30);
        temail.setBounds(250, 130, 180, 30);
        taddr = new JTextField(60);
        taddr.setBounds(30, 210, 180, 30);

        getContentPane().add(fn);
        getContentPane().add(tfn);
        getContentPane().add(ln);
        getContentPane().add(tln);
        getContentPane().add(tel);
        getContentPane().add(ttel);
        getContentPane().add(email);
        getContentPane().add(temail);
        getContentPane().add(addr);
        getContentPane().add(taddr);
        getContentPane().add(bsave);
        getContentPane().add(brestore);

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        File fd = new File("src/carnet.ser");
        List<Contacts> carnet = Serialization.readObjectForList(fd);
        /**
         * Here pay attention to carnet, it's a list but not modifiable!! It's size is fixed.
         * If I don't create a arraylist to add the new Contacts, there will
         * @throw UnsupportedOperationException
         */
        carnet = new ArrayList<>(carnet);

        if(e.getSource() == bsave){
            Contacts addCont = new Contacts(tfn.getText());
            addCont.setAddr(taddr.getText());
            addCont.setEmail(temail.getText());
            addCont.setLname(tln.getText());
            addCont.setTel(ttel.getText());
            System.out.println(addCont.toString());

            carnet.add(addCont);
            if (Serialization.writeObject(carnet, fd)){
                JOptionPane.showMessageDialog(null, "Saved!");
            } else
                JOptionPane.showInputDialog(null, "Save failed. Please retry.");
            taddr.setText("");
            tfn.setText("");
            temail.setText("");
            tln.setText("");
            ttel.setText("");
        }
        if (e.getSource() == brestore){
            this.dispose();
            CarnetSupView supView = new CarnetSupView(carnet , 0);
            supView.setVisible(true);
        }
    }

    public static void main(String[] args){
        CarnetView c = new CarnetView();
        c.setVisible(true);
    }
}

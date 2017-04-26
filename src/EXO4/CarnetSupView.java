package EXO4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.*;

/**
 * Created by tearsyu on 22/04/17.
 * @error button delete doesn't work as I want nor ItemSelect(null pointer)
 */
public class CarnetSupView extends JFrame implements ActionListener, ItemListener {
    private JLabel fn, ln, tel, email, addr;
    private static JTextField tfn, tln, ttel ,temail, taddr;
    private JComboBox carnetList;
    private JButton bmdf, bdel;
    private List list;

    public CarnetSupView(List<Contacts> list, int index){
        super("Carnet View");
        this.list = list;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500, 500);

        carnetList = new JComboBox();
        carnetList.setBounds(30, 270, 450, 30);
        carnetList.addItemListener(this);
        for(Contacts each : list) {
            carnetList.addItem(each);
        }
        Contacts first = list.get(0);
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

        tfn = new JTextField(first.getFname());
        tfn.setBounds(30, 50, 180, 30);
        tln = new JTextField(first.getLname());
        tln.setBounds(250, 50, 180, 30);
        ttel = new JTextField(first.getTel());
        ttel.setBounds(30, 130, 180, 30);
        temail = new JTextField(first.getEmail());
        temail.setBounds(250, 130, 180, 30);
        taddr = new JTextField(first.getAddr());
        taddr.setBounds(30, 210, 180, 30);

        bmdf = new JButton("Modify");
        bmdf.addActionListener(this);
        bmdf.setBounds(30, 320, 180, 30);
        bdel = new JButton("Delete");
        bdel.setBounds(250, 320, 180, 30);


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
        getContentPane().add(carnetList);
        getContentPane().add(bdel);
        getContentPane().add(bmdf);

    }

    public static void main(String[] args){
        File fd = new File("carnet.ser");
        List<Contacts> list = Serialization.<Contacts>readObjectForList(fd);
        CarnetSupView c = new CarnetSupView(list, 0);
        c.setVisible(true);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        File fd = new File("src/carnet.ser");
        if(e.getSource() == bmdf){
            //List carnet = Serialization.readObjectForList(fd);
            Contacts addCont = new Contacts(tfn.getText());
            addCont.setAddr(taddr.getText());
            addCont.setEmail(temail.getText());
            addCont.setLname(tln.getText());
            addCont.setTel(ttel.getText());
            list.add(addCont);
            if (Serialization.writeObject(list, fd)){
                JOptionPane.showMessageDialog(null, "Saved!");
            } else
                JOptionPane.showInputDialog(null, "Save failed. Please retry.");
        } else if (e.getSource() == bdel){
            System.out.println("delete item " + carnetList.getSelectedItem().toString());
            list.remove(carnetList.getSelectedItem());
            System.out.println("delete item " + carnetList.getSelectedItem().toString());
            carnetList.remove(carnetList.getSelectedIndex());
            if (Serialization.writeObject(list, fd)){
                JOptionPane.showMessageDialog(null, "Saved!");
            } else
                JOptionPane.showInputDialog(null, "Save failed. Please retry.");

        }

    }

    /**
     * Invoked when an item has been selected or deselected by the user.
     * The code written for this method performs the operations
     * that need to occur when an item is selected (or deselected).
     *
     * @param e
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println(e.getStateChange());
        if(e.getStateChange() == ItemEvent.SELECTED){
            System.out.println(e.getItem().toString());
            Contacts contactSelected = (Contacts) e.getItem();
            System.out.println(contactSelected.getAddr());

//            taddr.setText("test");

//            if (contactSelected.getTel().equals(null))
//                ttel.setText("null");
//            else
//                ttel.setText(contactSelected.getTel());
//
//            if (contactSelected.getEmail().equals(null))
//                ttel.setText("null");
//            else
//                temail.setText(contactSelected.getEmail());
//
//            tfn.setText(contactSelected.getFname());
//
//            if(contactSelected.getLname().equals(null))
//                tln.setText(null);
//            else
//                tln.setText(contactSelected.getLname());
        }
    }
}

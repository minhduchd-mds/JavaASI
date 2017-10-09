/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaASI.Frame;

//import JavaASI.Model.ConnectionUtils;
import JavaASI.Frame.Model.DAO;
import JavaASI.Frame.Model.StudentModel;
import JavaASI.entity.Student;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Duc
 */
public class AddStudent extends JFrame{
    private JLabel lblid, lblname, lblemail,lblbirthday,lblphone,lblroll_Number,lblclass_Name;
    static JTextField txtid,txtname,txtemail,txtbirthday,txtphone,txtroll_Number,txtclass_Name;
    private JButton Submit,Reset;
    private JLabel lblTotalMessage, lblIdMessage, lblNameMessage, lblEmailMessage, lblRollnumberMessage,lblClassNameMessage, lblPhoneMessage, lblBirthDayMessage;
    
    public  AddStudent(){
       this.setSize(700,600);
       this.setLayout(null);
       this.setTitle("Add Student");
       
       this.lblid = new JLabel("ID");
       this.lblname = new JLabel("Name");
       this.lblemail = new JLabel("Email");
       this.lblphone = new JLabel("Phone");
       this.lblbirthday = new JLabel("BirthDay");
       this.lblroll_Number = new JLabel("RollNumber");
       this.lblclass_Name = new JLabel("ClassName");
       
       this.txtid = new  JTextField();
       this.txtname = new  JTextField();
       this.txtemail = new  JTextField();
       this.txtphone = new  JTextField();
       this.txtbirthday = new  JTextField();
       this.txtroll_Number = new  JTextField();
       this.txtclass_Name = new  JTextField();
       this.lblIdMessage = new JLabel();
       this.lblNameMessage = new JLabel();
       this.lblEmailMessage = new JLabel();
       this.lblRollnumberMessage = new JLabel();
       this.lblPhoneMessage = new JLabel();
       this.lblBirthDayMessage = new JLabel();
       this.lblClassNameMessage = new JLabel();
       
       this.lblTotalMessage = new JLabel();
//       this.txtid.setEditable(false);
//       this.txtid.setText(String.valueOf(System.currentTimeMillis()));
        
       this.Submit = new  JButton("Submit");
       this.Reset  = new JButton("Reset");
       
       this.lblid.setBounds(100, 100, 100, 40);
       this.lblname.setBounds(100, 135, 100, 30);
       this.lblemail.setBounds(100, 170, 100, 30);
       this.lblphone.setBounds(100, 275, 100, 30);
       this.lblbirthday.setBounds(100, 305, 100, 30);
       this.lblroll_Number.setBounds(100, 205, 100, 30);
       this.lblclass_Name.setBounds(100, 240, 100, 30);
       
       this.txtid.setBounds(255, 100, 120, 30);
       this.txtname.setBounds(255, 135, 120, 30);
       this.txtemail.setBounds(255, 170, 120, 30);
       this.txtphone.setBounds(255, 205, 120, 30);
       this.txtbirthday.setBounds(255, 240, 120, 30);
       this.txtroll_Number.setBounds(255, 275, 120, 30);
       this.txtclass_Name.setBounds(255, 310, 120, 30);
       
       
        this.lblTotalMessage.setBounds(100, 50, 150, 30);
        this.lblIdMessage.setBounds(480, 100, 100, 30);
        this.lblNameMessage.setBounds(480, 135, 100, 30);
        this.lblEmailMessage.setBounds(480, 170, 100, 30);
        this.lblRollnumberMessage.setBounds(480, 205, 100, 30);
        this.lblClassNameMessage.setBounds(480, 240, 100, 30);
        this.lblPhoneMessage.setBounds(480, 275, 100, 30);
        this.lblBirthDayMessage.setBounds(480, 310, 100, 30);
        
       
       this.Submit.setBounds(150, 360, 100, 25);
       this.Reset.setBounds(272, 360, 100, 25);
       
        // Xử lý sự kiện.
        this.Submit.addActionListener(new LoginHandle());
        this.Reset.addActionListener(new ResetHandle());
       
        
         // Thêm component vào container.   
         this.add(this.lblid);
         this.add(this.lblname);
         this.add(this.lblemail);
         this.add(this.lblphone);
         this.add(this.lblbirthday);
         this.add(this.lblroll_Number);
         this.add(this.lblclass_Name);
         
         this.add(this.txtid);
         this.add(this.txtname);
         this.add(this.txtemail);
         this.add(this.txtphone);
         this.add(this.txtbirthday);
         this.add(this.txtroll_Number);
         this.add(this.txtclass_Name);
         
         this.add(this.lblIdMessage);
         this.add(this.lblNameMessage);
         this.add(this.lblEmailMessage);
         this.add(this.lblRollnumberMessage);
         this.add(this.lblPhoneMessage);
         this.add(this.lblTotalMessage);
         this.add(this.lblBirthDayMessage);
         this.add(this.lblTotalMessage);
         this.add(this.lblClassNameMessage);
         
         
         this.add(this.Submit);
         this.add(this.Reset);
     
       
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       this.setLocationRelativeTo(null);
       
    }

     // Xử lý login người dùng.
     class LoginHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
          
            Student student = new Student();
            student.setName(txtname.getText());
            student.setEmail(txtemail.getText());
            student.setRoll_Number(txtroll_Number.getText());
            student.setClass_Name(txtclass_Name.getText());
            student.setPhone(txtphone.getText());
            student.setBirthday(txtbirthday.getText());
            
            HashMap<String, String> errors = new FormHandle().validateLogin(student);
            
            if (errors.isEmpty()) {
                StringBuilder alert = new StringBuilder();
                alert.append("Are you want to add this student ?\n");
                alert.append("Student Id: ");
                alert.append(txtid.getText());
                alert.append("\nName: ");
                alert.append(txtname.getText());
                alert.append("\nBirthday: ");
                alert.append(txtbirthday.getText());
                alert.append("\nEmail: ");
                alert.append(txtemail.getText());
                alert.append("\nPhone: ");
                alert.append(txtphone.getText());
                alert.append("\nRoll_Number: ");
                alert.append(txtroll_Number.getText());
                alert.append("\nClass_Name: ");
                alert.append(txtclass_Name.getText());

                int result = JOptionPane.showConfirmDialog(null, alert.toString());
                if (result == 0) {
                    // Thực hiện insert student khi chọn yes.
                    StudentModel studentModel = new StudentModel();
                    try {
                        studentModel.insert(student);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "insert success!");
                    
                } else if (result == 1) {
                    // Thực hiện reset các field khi chọn no.
                    resetField();
                }

            } else {
                showError(errors);

            }

        }

        
    }

    class ResetHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            resetField();
            resetMessage();
           
        }
    }
     private void resetField() {
        txtid.setText("");
        txtname.setText("");
        txtbirthday.setText("");
        txtemail.setText("");
        txtphone.setText("");
        txtroll_Number.setText("");
        txtclass_Name.setText("");
    }
     private void resetMessage() {
        lblIdMessage.setText("");
        lblNameMessage.setText("");
        lblEmailMessage.setText("");
        lblRollnumberMessage.setText("");
        lblPhoneMessage.setText("");
        lblTotalMessage.setText("");
        lblBirthDayMessage.setText("");
        lblClassNameMessage.setText("");
    }
    private void showError(HashMap<String, String> errors) {
        lblTotalMessage.setBackground(Color.red);
        lblTotalMessage.setText("Hãy Nhập lại");
        if (errors.containsKey("txtId")) {
            lblIdMessage.setForeground(Color.red);
            lblIdMessage.setText(errors.get("txtId"));
        } else {
            lblIdMessage.setForeground(Color.GREEN);
//            lblIdMessage.setText("ok.");
        }
        if (errors.containsKey("txtName")) {
            lblNameMessage.setForeground(Color.red);
            lblNameMessage.setText(errors.get("txtName"));
        } else {
            lblNameMessage.setForeground(Color.GREEN);
            lblNameMessage.setText("ok.");
        }
        if (errors.containsKey("txtEmail")) {
            lblEmailMessage.setForeground(Color.red);
            lblEmailMessage.setText(errors.get("txtEmail"));
        } else {
            lblEmailMessage.setForeground(Color.GREEN);
            lblEmailMessage.setText("ok.");
        }
        if (errors.containsKey("txtClassName")) {
            lblClassNameMessage.setForeground(Color.red);
            lblClassNameMessage.setText(errors.get("txtClassName"));
        } else {
            lblClassNameMessage.setForeground(Color.GREEN);
            lblClassNameMessage.setText("ok.");
        }
        if (errors.containsKey("txtRollNumber")) {
            lblRollnumberMessage.setForeground(Color.red);
            lblRollnumberMessage.setText(errors.get("txtRollNumber"));
        } else {
            lblRollnumberMessage.setForeground(Color.GREEN);
            lblRollnumberMessage.setText("ok.");
        }
        if (errors.containsKey("txtPhone")) {
            lblPhoneMessage.setForeground(Color.red);
            lblPhoneMessage.setText(errors.get("txtPhone"));
        } else {
            lblPhoneMessage.setForeground(Color.GREEN);
            lblPhoneMessage.setText("ok.");
        }
        if (errors.containsKey("txtBirthday")) {
            lblBirthDayMessage.setForeground(Color.red);
            lblBirthDayMessage.setText(errors.get("txtBirthday"));
        } else {
            lblBirthDayMessage.setForeground(Color.GREEN);
            lblBirthDayMessage.setText("ok.");
        }
    }
   
}

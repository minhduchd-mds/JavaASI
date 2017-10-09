/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaASI.Frame.Model;

import JavaASI.entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Duc
 */
public class StudentModel {

     public void insert(Student student) throws ClassNotFoundException {

        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt=cnn.prepareStatement("INSERT INTO student VALUE (?,?,?,?,?,?,?);");  
//          
            preStt.setInt(1, (int) student.getId());
            preStt.setString(2, student.getName());
            preStt.setString(3, student.getBirthday());
            preStt.setString(4, student.getEmail());
            preStt.setString(5, student.getPhone());
            preStt.setString(6, student.getRoll_Number());
            preStt.setString(7, student.getClass_Name());
            preStt.execute();

            System.out.println("-- Add student success --");
            JOptionPane.showMessageDialog(null, "Insert student infomation success !! ");
        } catch (SQLException ex) {
            System.err.println("Add student erorr !!!\n" + ex.getMessage());
        }
    }
    public void delete(Integer id) {
		try {
			Connection conn=DAO.getConnection();
			PreparedStatement preStt=conn.prepareStatement("DELETE FROM student where id=?");
            preStt.setInt(1, id);
            if (preStt.executeUpdate()>0) {
				System.out.println("Deleted");
			}else{
				System.out.println("No data!!!");
			}
		} catch (SQLException e) {
			System.err.println("ERROR" + e.getMessage());
		}
	}  
//    public  static void update(Student student)
//    {
//        try {
//            Connection cnn = DAO.getConnection();
//            PreparedStatement preStt = cnn.prepareStatement("UPDATE student SET name = ?, email = ?, roll_number = ?, class_name = ?,status = ? WHERE id = ?");
//            preStt.setString(2, student.getName());
//            preStt.setString(3, student.getBirthday());
//            preStt.setString(4, student.getEmail());
//            preStt.setString(5, student.getPhone());
//            preStt.setString(6, student.getRoll_Number());
//            preStt.setString(7, student.getClass_Name());
//            preStt.execute();
//        } catch (SQLException e) {
//            System.err.println("Loi lenh databe" + e.getMessage());
//        }
//    }

   public ArrayList<Student> getListStudent(){
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preparedStmt = cnn.prepareStatement("Select * from student");
            ResultSet rss = preparedStmt.executeQuery();
            while(rss.next()){
                Student student = new Student();
                student.setId(rss.getInt("id"));
                student.setName(rss.getString("name"));
                student.setEmail(rss.getString("email"));
                student.setPhone(rss.getString("phone"));
                student.setBirthday(rss.getString("birthday"));
                student.setRoll_Number(rss.getString("roll_number"));
                student.setClass_Name(rss.getString("class_name"));
                listStudent.add(student);
            }
        } catch (SQLException e) {
             System.err.println("Lỗi trong quá trinh lấy danh sách." + e.getMessage());
        }
        
        return listStudent;
    }
}

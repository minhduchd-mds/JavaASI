/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaASI.Frame;

import JavaASI.entity.Student;
import java.util.HashMap;

/**
 *
 * @author Duc
 */
public class FormHandle {
    public HashMap<String, String> validateLogin(Student student) {
        HashMap<String, String> errors = new HashMap<>();
       

        if (student.getName().isEmpty()) {
            errors.put("txtName", "vui lòng nhập lại tên");

        }

        if (student.getEmail().isEmpty()) {
            errors.put("txtEmail", "vui lòng nhập lại email");

        }

        if (student.getRoll_Number().isEmpty()) {
            errors.put("txtRollNumber", "vui lòng nhập lại");

        }

        if (student.getClass_Name().isEmpty()) {
            errors.put("txtClassName", "vui lòng nhập lại");

        }
        if (student.getPhone().isEmpty()) {
            errors.put("txtPhone", "vui lòng nhập lại điện thoại");
        } 
         if (student.getBirthday().isEmpty()) {
            errors.put("txtBirthday", "vui lòng nhập lại ngày sinh");

        }

        return errors;
    }
}

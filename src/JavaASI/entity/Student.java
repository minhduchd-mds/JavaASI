/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaASI.entity;

/**
 *
 * @author Duc
 */
public class Student {
    private int id;
    private String name;
    private String email;
    private String birthday;
    private String phone;
    private String roll_Number;
    private String class_Name;

    public Student() {
        
    }
    public Student(int id, String name, String birthday, String phone, String email, String class_Name, String roll_Number) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.roll_Number = roll_Number;
        this.class_Name = class_Name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoll_Number() {
        return roll_Number;
    }

    public void setRoll_Number(String roll_Number) {
        this.roll_Number = roll_Number;
    }

    public String getClass_Name() {
        return class_Name;
    }

    public void setClass_Name(String class_Name) {
        this.class_Name = class_Name;
    }
    
    
}

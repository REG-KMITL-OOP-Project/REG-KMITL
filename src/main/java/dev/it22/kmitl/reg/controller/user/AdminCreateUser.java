package dev.it22.kmitl.reg.controller.user;

import dev.it22.kmitl.reg.controller.auth.Register;
import dev.it22.kmitl.reg.utils.Database;
import dev.it22.kmitl.reg.constant.UserPrefix;
import dev.it22.kmitl.reg.constant.UserRole;
import dev.it22.kmitl.reg.controller.auth.Register;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.utils.Database;
import dev.it22.kmitl.reg.utils.ErrorModal;

import javax.management.relation.Role;

public class AdminCreateUser {
    private int role;
    private  String email;
    private String username ;
    private String password;
    private int prefix;
    private String fname;
    private String lname;
    private String phone;
    private String address;
    private String std_id;
    private String prof_id;
    private String faculty;
    private String major;

    public void createStudent(String email,String username,String password,int prefix,String fname,String lname,String phone,String address,String std_id,String faculty,String major) throws Exception {
        this.role = 2;
        this.email = email;
        this.username = username;
        this.password = password;
        this.prefix = prefix;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.address = address;
        this.std_id = std_id;
        this.faculty = faculty;
        this.major = major;
        try{
            new Register(this.username,this.password).registerWithUsernameAndPassword();
        }
        catch (Exception e) {
            throw new Exception("เกิดข้อผิดพลาดขณะสร้างบัญชี");
        }
        // Update Student data
        try{
            Database db = new Database();
            int status = db.postQuery("UPDATE user SET role = "+this.role+", email = '"+this.email+"', prefix = "+this.prefix+", fname = '"+this.fname+"', lname = '"+this.lname+"', phone = '"+this.phone+"', address = '"+this.address+"', std_id = '"+this.std_id+"', faculty = '"+this.faculty+"', major = '"+this.major+"' WHERE username = '"+this.username+"';");
            if(status == 0){
                throw new Exception("เกิดข้อผิดพลาดขณะอัพเดทข้อมูล");
            }
            System.out.println("Create Student success");
        }
        catch (Exception e) {
            System.out.println("Create Student success");
        }
    }
    public  void createProf(String email,String username,String password,int prefix,String fname,String lname,String phone,String address,String prof_id,String faculty) throws Exception {
        this.role = 3;
        this.email = email;
        this.username = username;
        this.password = password;
        this.prefix = prefix;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.address = address;
        this.prof_id = prof_id;
        this.faculty = faculty;
        try{
            new Register(this.username,this.password).registerWithUsernameAndPassword();
        }
        catch (Exception e) {
            throw new Exception("เกิดข้อผิดพลาดขณะสร้างบัญชี");
        }
        // Update Prof data
        try{
            Database db = new Database();
            int status = db.postQuery("UPDATE user SET role = "+this.role+", email = '"+this.email+"', prefix = "+this.prefix+", fname = '"+this.fname+"', lname = '"+this.lname+"', phone = '"+this.phone+"', address = '"+this.address+"', prof_id = '"+this.prof_id+"', faculty = '"+this.faculty+"' WHERE username = '"+this.username+"';");
            if(status == 0){
                throw new Exception("เกิดข้อผิดพลาดขณะอัพเดทข้อมูล");
            }
            System.out.println("Create Prof success");
        }
        catch (Exception e) {
            System.out.println("Create Prof success");
        }
    }

    public void createAdmin(String email,String username,String password,int prefix,String fname,String lname) throws Exception {
        this.role = 1;
        this.email = email;
        this.username = username;
        this.password = password;
        this.prefix = prefix;
        this.fname = fname;
        this.lname = lname;
        try{
            new Register(this.username,this.password).registerWithUsernameAndPassword();
        }
        catch (Exception e) {
            throw new Exception("เกิดข้อผิดพลาดขณะสร้างบัญชี");
        }
        // Update Admin data
        try{
            Database db = new Database();
            int status = db.postQuery("UPDATE user SET role = "+this.role+", email = '"+this.email+"', prefix = "+this.prefix+", fname = '"+this.fname+"', lname = '"+this.lname+"' WHERE username = '"+this.username+"';");
            if(status == 0){
                throw new Exception("เกิดข้อผิดพลาดขณะอัพเดทข้อมูล");
            }
            System.out.println("Create Admin success");
        }
        catch (Exception e) {
            System.out.println("Create Admin success");
        }

    }
}

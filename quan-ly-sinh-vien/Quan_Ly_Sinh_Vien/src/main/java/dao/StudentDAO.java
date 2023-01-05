package dao;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
   static Connection connection = ConnectionMySql.getConnection();

    public static List<Student> getAll() {
        List<Student> studentsList = new ArrayList<>();
        Student student;
        String sql = "Select * from quanlysinhvien.student";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("studentId");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");

                student = new Student(id,name,dateOfBirth,address,phoneNumber,email);
                studentsList.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return studentsList;
    }


    public static boolean save(Student student) {
        String sql = "insert into quanlysinhvien.student (studentId,Name,DateOfBirth, Address, PhoneNumber, Email) values (?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3,student.getDateOfBirth());
            preparedStatement.setString(4,student.getAddress());
            preparedStatement.setString(5,student.getPhoneNumber());
            preparedStatement.setString(6,student.getEmail());

            return preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean edit(Student student) {
        String sql = "update quanlysinhvien.student set name=?, dateOfBirth=?, address=?, phoneNumber=?, email=?  where studentId=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2,student.getDateOfBirth());
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.setString(4,student.getPhoneNumber());
            preparedStatement.setString(5,student.getEmail());
            preparedStatement.setInt(6,student.getId());
            return preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Student findById(int id){
        String sql = "select * from quanlysinhvien.student where studentId=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();

            String name = resultSet.getString("name");
            String dateOfBirth = resultSet.getString("dateOfBirth");
            String address = resultSet.getString("address");
            String phoneNumber = resultSet.getString("phoneNumber");
            String email = resultSet.getString("email");

            return new Student(id,name,dateOfBirth,address,phoneNumber,email);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void delete(int id){
        String sql ="delete FROM quanlysinhvien.student where studentId = "+id;
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Student> search(String search) {
        List<Student> ketQuaTimKiem = new ArrayList<>();
        Student student;
        String sql = "SELECT * FROM quanlysinhvien.student WHERE Name LIKE '%"+ search + "%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("studentId");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");

                student = new Student(id,name,dateOfBirth,address,phoneNumber,email);
                ketQuaTimKiem.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return ketQuaTimKiem;

    }
}

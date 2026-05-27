package dao;

import model.Student;
import util.DBConnection;
import java.sql.*;

public class StudentDAO
{
    public void addStudent(Student s)
    {
        try
        {
            Connection con=DBConnection.getConnection();
            String query="INSERT INTO students VALUES (?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,s.getId());
            ps.setString(2,s.getName());
            ps.setInt(3,s.getMarks());
            ps.executeUpdate();
            System.out.println("Student added successfully");
        }
        catch (Exception e)
        {
            System.out.println("Error adding student");
        }
    }
    public void viewStudents()
    {
        try
        {
            Connection con=DBConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM students");

            while (rs.next())
            {
                
            }
        }
    }
}
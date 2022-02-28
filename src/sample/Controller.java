package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    public TextField emailBox;
    public TextField nameBox;
    public TextArea feedBackArea;
    String email,name,feedBack;


    public void addData(ActionEvent actionEvent) {
        email = emailBox.getText();
        name = nameBox.getText();
        feedBack = feedBackArea.getText();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","password");
            Statement smt = con.createStatement();
            smt.executeUpdate("insert into feedback values(" + "'" + email + "'," + "'" + name + "'," + "'" + feedBack + "')");
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void update(ActionEvent actionEvent) {
        email = emailBox.getText();
        name = nameBox.getText();
        feedBack = feedBackArea.getText();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","password");
            Statement smt = con.createStatement();
            smt.executeUpdate("update feedback set name = '"+ name + "', feedback = '"+feedBack+"' where email = '"+email+"';");
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(ActionEvent actionEvent) {
        email = emailBox.getText();
        name = nameBox.getText();
        feedBack = feedBackArea.getText();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","password");
            Statement smt = con.createStatement();
            smt.executeUpdate("delete from feedback where email = '"+email+"';");
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
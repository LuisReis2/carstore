package br.com.carstore.dao;

import br.com.carstore.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarDAO {
    public  void createCar(Car car) {
        String SQL = "INSERT INTO CAR (NAME) VALUES (?)";

        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            PreparedStatement preparedStatement = ((Connection) connection).prepareStatement(SQL);

            preparedStatement.setString(1, car.getName());

            preparedStatement.execute();

            System.out.println("success in database connection");

        }catch (Exception e){
            System.out.println("fail in database connection");
        }

    }
}

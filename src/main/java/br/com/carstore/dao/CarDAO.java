package br.com.carstore.dao;

import br.com.carstore.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public List<Car> findAllCars() {

        String SQL = "SELECT * FROM CAR";

        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            PreparedStatement preparedStatement = ((Connection) connection).prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Car> cars = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                Car car = new Car(name);

                cars.add(car);

            }
            System.out.println("Consultar lista com sucesso!");
            return cars;
        }catch (Exception a){
            System.out.println("Falha ao acessar carros");
            return Collections.emptyList();
        }
    }
}

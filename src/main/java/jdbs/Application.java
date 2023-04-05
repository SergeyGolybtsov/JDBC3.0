package jdbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static final String url = "jdbc:postgresql://localhost:5432/skypro";
    public static final String user = "postgres";
    public static final String password = "1234";

    private static final EmployeeDAO EMPLOYEE_DAO = new EmployeeDAOImpl();
    private static final CityDAO CITY_DAO = new CityDAOImpl();

    public static void main(String[] args) {
        /*City kirsanov = new City("Kirsanov");
        CITY_DAO.create(kirsanov);
        Employee kirsanovCitizen = new Employee(11,"Юлий", "Цезарь", "Муж", 25, kirsanov);
        EMPLOYEE_DAO.create(kirsanovCitizen);*/
        EMPLOYEE_DAO.readAll().forEach(employee -> System.out.printf("%s %s City: %s\n",employee.getFirstName(),
                employee.getLastName(), employee.getCity().getName()));
        /*CITY_DAO.readAll().forEach(city -> {
            System.out.println();
            city.getEmployees().forEach(System.out::println);
        });*/
        CITY_DAO.readAll().forEach(city -> {
            System.out.println(city);
        });
    }
    private static Connection getConnection() {

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

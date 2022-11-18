package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      Car carUser1 = new Car("BMW", 11); // создали автомобиль
      User user1 = new User("User1", "Lastname1", "user1@mail.ru"); // создали юзера
      user1.setUserCar(carUser1); // закрепили автомобиль за юзером
      userService.add(user1); // сохраняем наши изменения через сервис в таблицы
      Car carUser2 = new Car("Audi", 22);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user2.setUserCar(carUser2);
      userService.add(user2);
      Car carUser3 = new Car("VW", 33);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      user3.setUserCar(carUser3);
      userService.add(user3);
      Car carUser4 = new Car("LADA", 44);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      user4.setUserCar(carUser4);
      userService.add(user4);
      List<User> users = userService.listUsers(); // вывожу на экран юзера с его автомобилем, toString переопределён у обоих

      for (User user : users) {
         System.out.println(user);
      }

      System.out.println(userService.getUserByCar("LADA", 44)); // проверил метод
      context.close(); // обязательно закрыть соединение, помнить о try catch
   }
}

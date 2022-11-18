package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      Car carUser1 = new Car("BMW", 11);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setUserCar(carUser1);
      userService.add(user1);
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

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      context.close();
   }
}

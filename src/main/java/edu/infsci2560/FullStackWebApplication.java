package edu.infsci2560;

import edu.infsci2560.models.Rating;
import edu.infsci2560.models.RatingPk;
import edu.infsci2560.models.Recipe;
import edu.infsci2560.models.Recipe.RecipeType;
import edu.infsci2560.models.User;
import edu.infsci2560.repositories.RatingRepository;
import edu.infsci2560.repositories.RecipeRepository;

import edu.infsci2560.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class FullStackWebApplication {

    private static final Logger log = LoggerFactory.getLogger(FullStackWebApplication.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(FullStackWebApplication.class, args);

        RecipeRepository repository = ctx.getBean(RecipeRepository.class);
        UserRepository  userRepository = ctx.getBean(UserRepository.class);
        RatingRepository ratingRepository =ctx.getBean(RatingRepository.class);
        userRepository.save(new User("magician","123","magician@gmail.com","Pittsburgh"));
        userRepository.save(new User("megan","123","megan@gmail.com","New York"));
        userRepository.save(new User("jackSmith","123","smith_j@hotmail.com","Chicago"));
        Recipe recipe1 = new Recipe(1L, "Creamy Mushroom Pasta", RecipeType.Pasta,"380 kcal",
                Arrays.asList(new String[] {
                        "100g pasta",
                        "1/2 sliced onion",
                        "150g sliced mushroom",
                        "ham"
                }),
                Arrays.asList(new String[]{
                        "Put the pasta on to boil",
                        "Meanwhile fry sliced onions, mushroom and chopped ham a little",
                        "Drain the pasta and add the vegie sauce",
                }),"15 min");
        recipe1.setAuthor(1L);
        repository.save(recipe1);

        Recipe recipe2 = new Recipe(2L, "Tuna Salad", RecipeType.Salad,"400 kcal",
                Arrays.asList(new String[] {
                        "One can of tuna",
                        "lettuce/spinach",
                        "cheese",
                        "vinegar and salt"
                }),
                Arrays.asList(new String[]{
                        "Rinse the lettuce and cut or rip into small pieces",
                        "Add the tuna with the oil to the salad",
                        "Add vinegar and salt to your liking",
                        "Mix around with you hands",
                        "Add a bit of cheese you like"
                }),"8 min");

        recipe2.setAuthor(2L);
        repository.save(recipe2);
        //repository.save(new Recipe(3L, "Spicy Tomato Soup", RecipeType.Soup, "250 kcal", "20 min"));
        //repository.save(new Recipe(4L, "BBQ Style Burger", RecipeType.Meat, "600 kcal", "20 min"));

        ratingRepository.save(new Rating(new RatingPk(1L,3L),5));
        ratingRepository.save(new Rating(new RatingPk(1L,2L),3));
        ratingRepository.save(new Rating(new RatingPk(2L,1L),4));
        //ratingRepository.save(new Rating(new RatingPk(2L,3L),3));

    }


//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }
//    @Bean
//    public CommandLineRunner databaseDemo(CustomerRepository repository) {
//        return (args) -> {
//            // save a couple of customers
//            repository.save(new Customer("Jack", "Bauer"));
//            repository.save(new Customer("Chloe", "O'Brian"));
//            repository.save(new Customer("Kim", "Bauer"));
//            repository.save(new Customer("David", "Palmer"));
//            repository.save(new Customer("Michelle", "Dessler"));
//            repository.save(new Customer("Billy", "Bean"));
//
//            // fetch all customers
//            log.info("[Database Demo] Customers found with findAll():");
//            log.info("[Database Demo] -------------------------------");
//            for (Customer customer : repository.findAll()) {
//                log.info("[Database Demo] " + customer.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            Customer customer = repository.findOne(1L);
//            log.info("[Database Demo] Customer found with findOne(1L):");
//            log.info("[Database Demo] --------------------------------");
//            log.info("[Database Demo] " + customer.toString());
//
//            // fetch customers by last name
//            log.info("[Database Demo] Customer found with findByLastName('Bauer'):");
//            log.info("[Database Demo] --------------------------------------------");
//            for (Customer bauer : repository.findByLastName("Bauer")) {
//                log.info("[Database Demo] " + bauer.toString());
//            }
//        };
//    }
}

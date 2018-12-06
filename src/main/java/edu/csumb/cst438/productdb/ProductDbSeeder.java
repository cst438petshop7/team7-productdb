package edu.csumb.cst438.productdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.csumb.cst438.productdb.products.Product;
import edu.csumb.cst438.productdb.products.Description;
import edu.csumb.cst438.productdb.products.Image;
import edu.csumb.cst438.productdb.products.Price;
import edu.csumb.cst438.productdb.products.ProductName;
import edu.csumb.cst438.productdb.products.Stock;


@Component
public class ProductDbSeeder implements CommandLineRunner {
    @Autowired
    IProductRepository shopRepo;

    @Override
    public void run(String... args) throws Exception {
        
        Product Catnip = new Product(new ProductName("Catnip"), new Description("Catnip for cats"), new Image("https://images-na.ssl-images-amazon.com/images/I/51lKw%2B2aeEL.jpg"), new Price(12.99), new Stock(10000));
        Product Collar = new Product(new ProductName("Cat Collar"), new Description("Collar for a cat"), new Image("https://images-na.ssl-images-amazon.com/images/I/61cQr%2BquDDL._SL1500_.jpg"), new Price(4.99), new Stock(10000));
        Product Kong = new Product(new ProductName("Kong Chew Toy"), new Description("Chew Toy for dogs"), new Image("https://images-na.ssl-images-amazon.com/images/I/71l1YLOxMJL._SL1500_.jpg"), new Price(10.99), new Stock(10000));
        Product CatHouse = new Product(new ProductName("Outdoor Kitty House"), new Description("The Puuurfect house for your kitty to take shelter"), new Image("https://images-na.ssl-images-amazon.com/images/I/81yME9f4eAL._SL1500_.jpg"), new Price(66.99), new Stock(10000));
        Product DogTreat = new Product(new ProductName("Milk-Bone Flavor Snacks"), new Description("Reward your dog with this yummy treats"), new Image("https://images-na.ssl-images-amazon.com/images/I/81gKUE%2BOXfL._SL1300_.jpg"), new Price(11.99), new Stock(10000));
        Product DogHouse = new Product(new ProductName("Wooden Dog House Cabin Style"), new Description("Have your dog living the high life with this luxurious doggie cabin"), new Image("https://images-na.ssl-images-amazon.com/images/I/61466Dj9KVL._SL1200_.jpg"), new Price(185.99), new Stock(10000));
        Product PupPads = new Product(new ProductName("Puppy Pads - 50 count"), new Description("Train your pup where to pee and poo"), new Image("https://images-na.ssl-images-amazon.com/images/I/81MLR6FTdBL._SL1500_.jpg"), new Price(15.99), new Stock(150));
        Product LitterBox = new Product(new ProductName("Litter Box with Scoop and Reusable Liner"), new Description("Excellcelent place for you cat to do its' business in peace"), new Image("https://images-na.ssl-images-amazon.com/images/I/61GD%2B7GM%2BpL._SL1000_.jpg"), new Price(34.99), new Stock(10000));

        shopRepo.deleteAll();
        List<Product> products = Arrays.asList(Catnip, Collar, Kong, CatHouse, DogTreat, DogHouse, PupPads, LitterBox);
        shopRepo.saveAll(products);
    }

}

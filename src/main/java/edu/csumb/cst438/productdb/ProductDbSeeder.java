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
        
        Product Catnip = new Product(new ProductName("Catnip"), new Description("Freshly grown, guaranteeing highest quality with no preservatives or artificial ingredients. Sprinkle any amount, and watch your Kitty's favorite toy, bed or scratch post, and watch them purr, roll, meow and play for hours! Planted, grown and harvested at the highest peak of season, ensuring best plant quality for essential oil."), new Image("https://images-na.ssl-images-amazon.com/images/I/51lKw%2B2aeEL.jpg"), new Price(12.99), new Stock(10));
        Product Collar = new Product(new ProductName("Cat Collar"), new Description("This CAT COLLAR IS EMBROIDERED with your cats name & phone number.The collar features a quick-release buckle and a non-corrosive stainless steel D-ring. The embroidery is permanently stitched into the collar for strength and long-lasting durability. The highly-reflective surface of the collar is made of nylon webbing with smooth, tapered edges for a comfortable fit. This collar has everything you need: durability, safety, and customization."), new Image("https://images-na.ssl-images-amazon.com/images/I/61cQr%2BquDDL._SL1500_.jpg"), new Price(4.99), new Stock(20));
        Product Kong = new Product(new ProductName("Kong Chew Toy"), new Description("Made from the same super-durable, puncture-resistant, non-toxic rubber as classic Kong toys, this versatile, bone-shaped chew is just the thing for the home-alone dog. Dogs were made to hunt, chase, and gnaw, and denied a way to satisfy these natural urges, they can turn into barkers, diggers, shoe-chewers, or worse."), new Image("https://images-na.ssl-images-amazon.com/images/I/71l1YLOxMJL._SL1500_.jpg"), new Price(10.99), new Stock(10));
        Product CatHouse = new Product(new ProductName("Outdoor Kitty House"), new Description("Only the finest materials are used to make K&H products durable and long lasting. With K&H's industry-changing technologies, many K&H products cost less to run than the average night light. Thousands of veterinarians and pet experts use, recommend and promote the year round use of not only K&H's traditional bed line but their innovative heated pet bed line as well. K&H products are rigorously tested and are certified by MET Laboratories to exceed USA and Canadian electrical safety standards."), new Image("https://images-na.ssl-images-amazon.com/images/I/81yME9f4eAL._SL1500_.jpg"), new Price(66.99), new Stock(10));
        Product DogTreat = new Product(new ProductName("Milk-Bone Flavor Snacks"), new Description("Milk-Bone Flavor Snacks dog biscuits feature the same teeth cleaning and vitamin-enriched goodness of Milk-Bone Original biscuits in 5 delicious flavors. Prepared with care by the makers of Milk-Bone dog snacks, these tasty treats will give your dog the simple, genuine joy that your dog gives you every day."), new Image("https://images-na.ssl-images-amazon.com/images/I/81gKUE%2BOXfL._SL1300_.jpg"), new Price(11.99), new Stock(10));
        Product DogHouse = new Product(new ProductName("Wooden Dog House Cabin Style"), new Description("Bring a rustic, outdoorsy look to your patio, yard, or pet space with this large log cabin elevated dog house from PawHut. Built to hold a medium to large sized dog, this raised dog house is built from solid fir and cedar wood that has been coated with pet safe, non-toxic sealant to enhance durability and longevity."), new Image("https://images-na.ssl-images-amazon.com/images/I/61466Dj9KVL._SL1200_.jpg"), new Price(185.99), new Stock(10));
        Product PupPads = new Product(new ProductName("Puppy Pads - 50 count"), new Description("Perfect for Potty TrainingGive your puppy the best chance for success when it comes to potty training. AmazonBasics pet-training pads offer superior performance and reliable convenience so that adorable little Fido learns fast.In addition to training young pups, the pads also work well for assisting sick or aging dogs, making dogs more comfortable during transport, or offering an alternative to dogs without timely outdoor access.DimensionsEach pad measures 22 by 22 inches An Amazon Brand."), new Image("https://images-na.ssl-images-amazon.com/images/I/81MLR6FTdBL._SL1500_.jpg"), new Price(15.99), new Stock(150));
        Product LitterBox = new Product(new ProductName("Litter Box with Scoop and Reusable Liner"), new Description("Our proprietary design & non-stick coating are designed to make your cat's and your life easier. Vet recommended features to promote wellness, eliminate behavior issues, & simply cleaning and maintenance. Premium abs material, safe non-stick coating, & 12 month warranty."), new Image("https://images-na.ssl-images-amazon.com/images/I/61GD%2B7GM%2BpL._SL1000_.jpg"), new Price(34.99), new Stock(10));

        shopRepo.deleteAll();
        List<Product> products = Arrays.asList(Catnip, Collar, Kong, CatHouse, DogTreat, DogHouse, PupPads, LitterBox);
        shopRepo.saveAll(products);
    }

}

package info.keyal.demo.service;

import info.keyal.demo.service.SalesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SalesService.class})
public class SalesServiceTest {

    @Autowired
    private SalesService salesService;

    /**
     * test to calculate price for 1 apples, 2 oranges
     * 60 x 1 =60
     * 25 x 2= 50
     * <p>
     * total = 110
     */
    @Test
    public void getTotalPriceTest() {
        int expectedPrice = 110; // Price for 1 apple, 2 oranges
        List<String> fruits = Arrays.asList("apple", "orange", "orange");

        int totalPrice = salesService.getTotalPrice(fruits);
        assertThat(totalPrice, equalTo(expectedPrice));
    }

    /**
     * test to calculate price for 2 apples, 3 oranges without any sales offer
     * apple price 60 x 2 =120
     * orange price 25 x 3 = 75
     * <p>
     * total = 195
     */
    @Test
    public void getTotalPriceWithoutOfferTest() {
        int expectedPrice = 195;
        List<String> fruits = Arrays.asList("apple", "apple", "orange", "orange", "orange");

        int totalPrice = salesService.getTotalPrice(fruits);
        assertThat(totalPrice, equalTo(expectedPrice));
    }

    /**
     * test to calculate price for 2 apples, 3 oranges with simple sales offer
     * <p>
     * since 2nd apple is free, price for 2 apples 60 x 1 = 60
     * since 3rd orange if free, price for 3 orange 25 x 2 = 50
     * <p>
     * total = 110
     */
    @Test
    public void getTotalPriceWithOfferTest() {
        int expectedPrice = 110;
        List<String> fruits = Arrays.asList("apple", "apple", "orange", "orange", "orange");

        int totalPrice = salesService.getTotalPriceWithAllOffers(fruits);
        assertThat(totalPrice, equalTo(expectedPrice));
    }

    /**
     * test to calculate price for 10 apples, 17 oranges with simple sales offer
     * <p>
     * since every 2nd apple is free, price for 10 apples 60 x 5= 300
     * since every 3rd orange if free, price for 17 orange 25 x 12 = 300
     * <p>
     * total = 600
     */
    @Test
    public void getTotalPriceWithOfferForALargeDateSetTest() {
        int expectedPrice = 600;
        List<String> fruits = Arrays.asList("apple", "apple", "apple", "apple", "apple", "apple", "apple", "apple", "apple", "apple",
                "orange", "orange", "orange", "orange", "orange", "orange", "orange", "orange", "orange", "orange",
                "orange", "orange", "orange", "orange", "orange", "orange", "orange");

        int totalPrice = salesService.getTotalPriceWithAllOffers(fruits);
        assertThat(totalPrice, equalTo(expectedPrice));
    }

    /**
     * test to calculate price for 2 apples, 3 oranges with simple sales offer
     * <p>
     * since 2nd apple is free, price for 2 apples 60 x 1 = 60
     * since this is apple only offer, price for 3 orange 25 x 3 = 75
     * <p>
     * total = 135
     */
    @Test
    public void getTotalPriceWithAppleOfferTest() {
        int expectedPrice = 135;
        List<String> fruits = Arrays.asList("apple", "apple", "orange", "orange", "orange");

        int totalPrice = salesService.getTotalPriceWithAppleOffer(fruits);
        assertThat(totalPrice, equalTo(expectedPrice));
    }

    /**
     * test to calculate price for 2 apples, 3 oranges with simple sales offer
     * <p>
     * since this is orange only offer, price for 2 apples 60 x 1 = 120
     * since 3rd orange if free, price for 3 orange 25 x 2 = 50
     * <p>
     * total = 170
     */
    @Test
    public void getTotalPriceWithOrangeOfferTest() {
        int expectedPrice = 170;
        List<String> fruits = Arrays.asList("apple", "apple", "orange", "orange", "orange");

        int totalPrice = salesService.getTotalPriceWithOrangeOffer(fruits);
        assertThat(totalPrice, equalTo(expectedPrice));
    }
}

package com.paris;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class FoodresolverApplicationTests {

    @Test
    public void contextLoads() {

        System.out.println("hello world");
        IntStream.range(1, 5).forEach(i -> {
                    System.out.println(" i =========" + i);
                }
        )
        ;


    }

}

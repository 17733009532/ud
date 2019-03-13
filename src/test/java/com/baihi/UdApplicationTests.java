package com.baihi;

import com.baihi.dao.CarouselDao;
import com.baihi.entity.Carousel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UdApplicationTests {
    @Autowired
    private CarouselDao carouselDao;

    @Test
    public void contextLoads() {
        System.out.println(carouselDao.selectAll());
    }
    @Test
    public void test1() {
        carouselDao.insert(new Carousel("a","a","a","a",new Date()));
    }
}

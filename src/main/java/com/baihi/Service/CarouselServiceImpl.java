package com.baihi.Service;

import com.baihi.dao.CarouselDao;
import com.baihi.entity.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CarouselServiceImpl implements CarouselService{
    @Autowired
    private CarouselDao carouselDao;

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public void inser(Carousel carousel) {
        carouselDao.insert(carousel);
    }

    @Transactional(propagation= Propagation.SUPPORTS)
    @Override
    public List<Carousel> selectAll() {
        return carouselDao.selectAll();
    }
}

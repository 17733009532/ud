package com.baihi.Service;

import com.baihi.entity.Carousel;

import java.util.List;

public interface CarouselService {
    void inser(Carousel carousel);
    List<Carousel> selectAll();
}

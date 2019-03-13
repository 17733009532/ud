package com.baihi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carousel {
    private String id;
    private String title;
    private String imgpath;
    private String status;
    private Date cratetime;
}

package com.telusko.service;

import com.telusko.model.HateoasCourse;

import java.util.List;

public interface ICourseServices {

    String registerCourse(HateoasCourse hateoasCourse);

    String updateCourse(HateoasCourse hateoasCourse);

    String updateCourseById(Integer id, Double budget);

    String deleteCourseById(Integer id);

    HateoasCourse fetchCourseById(Integer id);

    List<HateoasCourse> findAllCourse();

}

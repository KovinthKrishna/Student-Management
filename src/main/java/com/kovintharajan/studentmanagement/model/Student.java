package com.kovintharajan.studentmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String id;

    private String title;
    private String name;
    private String address;
    private String city;

    private String courseId;
}
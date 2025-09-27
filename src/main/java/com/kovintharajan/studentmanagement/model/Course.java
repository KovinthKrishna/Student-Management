package com.kovintharajan.studentmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private String id;

    private String name;
    private double fee;
    private String lecturerId;
    private String lecturerName;
}
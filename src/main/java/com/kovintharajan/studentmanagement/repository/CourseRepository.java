package com.kovintharajan.studentmanagement.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.kovintharajan.studentmanagement.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class CourseRepository {

    private static final String COLLECTION_NAME = "courses";

    public Course createCourse(Course course) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> future = db.collection(COLLECTION_NAME).add(course);
        DocumentReference documentReference = future.get();
        course.setId(documentReference.getId());
        return course;
    }

    public Course getCourseById(String id) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference documentReference = db.collection(COLLECTION_NAME).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        if (document.exists()) {
            Course course = document.toObject(Course.class);
            if (course != null) {
                course.setId(document.getId());
            }
            return course;
        }
        return null;
    }

    public List<Course> getAllCourses() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        List<Course> courseList = new ArrayList<>();
        CollectionReference courses = db.collection(COLLECTION_NAME);
        ApiFuture<QuerySnapshot> querySnapshot = courses.get();

        for (QueryDocumentSnapshot document : querySnapshot.get().getDocuments()) {
            Course course = document.toObject(Course.class);
            course.setId(document.getId());
            courseList.add(course);
        }
        return courseList;
    }

    public Course updateCourse(Course course) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection(COLLECTION_NAME).document(course.getId());
        docRef.set(course).get();
        return course;
    }

    public String deleteCourseById(String id) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection(COLLECTION_NAME).document(id);
        docRef.delete().get();
        return "Successfully deleted course with ID: " + id;
    }
}
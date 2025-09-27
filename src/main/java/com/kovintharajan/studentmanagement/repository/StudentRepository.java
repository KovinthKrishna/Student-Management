package com.kovintharajan.studentmanagement.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.kovintharajan.studentmanagement.model.Student;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ExecutionException;

@Repository
public class StudentRepository {

    private static final String COLLECTION_NAME = "students";

    public Student createStudent(Student student) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> future = db.collection(COLLECTION_NAME).add(student);
        DocumentReference documentReference = future.get();
        student.setId(documentReference.getId());
        return student;
    }

    public Student getStudentById(String id) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference documentReference = db.collection(COLLECTION_NAME).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        if (document.exists()) {
            Student student = document.toObject(Student.class);
            if (student != null) {
                student.setId(document.getId());
            }
            return student;
        }
        return null;
    }
}
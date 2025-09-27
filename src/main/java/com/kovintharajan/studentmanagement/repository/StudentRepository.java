package com.kovintharajan.studentmanagement.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.kovintharajan.studentmanagement.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
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

    public List<Student> getAllStudents() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        List<Student> studentList = new ArrayList<>();
        CollectionReference students = db.collection(COLLECTION_NAME);
        ApiFuture<QuerySnapshot> querySnapshot = students.get();

        for (QueryDocumentSnapshot document : querySnapshot.get().getDocuments()) {
            Student student = document.toObject(Student.class);
            student.setId(document.getId());
            studentList.add(student);
        }
        return studentList;
    }

    public Student updateStudent(Student student) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection(COLLECTION_NAME).document(student.getId());
        docRef.set(student).get();
        return student;
    }

    public String deleteStudentById(String id) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection(COLLECTION_NAME).document(id);
        docRef.delete().get();
        return "Successfully deleted student with ID: " + id;
    }
}
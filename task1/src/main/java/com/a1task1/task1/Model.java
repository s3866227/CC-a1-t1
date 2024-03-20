package com.a1task1.task1;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;


import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;


// class for all backend functionality, methods to be called by various servlets
public class Model {
    Firestore db;
    public Model(boolean initialised) throws IOException{
        // initialising instance of firestore
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        FirebaseOptions.Builder builder = FirebaseOptions.builder();
        FirebaseOptions options =builder.setCredentials(credentials)
            .setProjectId("assignment1task1-417104")
            .build();
        if(!initialised) {
            FirebaseApp.initializeApp(options);
        }
        db = FirestoreClient.getFirestore();
    }


    public boolean validateLogin(String id, String password) throws InterruptedException, ExecutionException {
        boolean valid = false;
        //String dbId, dbPassword;

        CollectionReference collection = db.collection("task1-users");
        //asynchronously retrieve all users
        // Get documetns according to specified id and password
        ApiFuture<QuerySnapshot> future = collection.whereEqualTo("id", id).whereEqualTo("password", password).get();
        QuerySnapshot querySnapshot = future.get();

        if(!querySnapshot.isEmpty()) {
            valid = true;
        }
       return valid;
    }
}



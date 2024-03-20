package com.a1task1.task1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;


// class for all backend functionality, methods to be called by various servlets
public class Model {
    static boolean isInitialised;
    Firestore db;
    public Model() throws IOException{
        // initialising instance of firestore
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        FirebaseOptions.Builder builder = FirebaseOptions.builder();
        FirebaseOptions options =builder.setCredentials(credentials)
            .setProjectId("assignment1task1-417104")
            .build();
        if(!isInitialised) {
            FirebaseApp.initializeApp(options);
            isInitialised = true;
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

    public boolean hasId(String id) throws InterruptedException, ExecutionException{
        boolean hasId = true;

        CollectionReference collection = db.collection("task1-users");
        //asynchronously retrieve all users
        // Get documetns according to specified id and password
        ApiFuture<QuerySnapshot> future = collection.whereEqualTo("id", id).get();
        QuerySnapshot querySnapshot = future.get();

        if(querySnapshot.isEmpty()) {
            hasId = false;
        }

        return hasId;
    }

    public boolean hasUsername(String username) throws InterruptedException, ExecutionException{
        boolean hasUsername = true;

        CollectionReference collection = db.collection("task1-users");
        //asynchronously retrieve all users
        // Get documetns according to specified id and password
        ApiFuture<QuerySnapshot> future = collection.whereEqualTo("user_name", username).get();
        QuerySnapshot querySnapshot = future.get();

        if(querySnapshot.isEmpty()) {
            hasUsername = false;
        }

        return hasUsername;
    }

    // add image parameter as well
    // method to add new user to database
    public void addUser(String id, String username, String password) {
        // variable to refer to new doc
        DocumentReference docRef = db.collection("task1-users").document();

        // store user entered data in hashmap for data entry
        Map<String, Object> newUser = new HashMap<>();
        newUser.put("id", id);
        newUser.put("user_name", username);
        newUser.put("password", password);

        docRef.set(newUser);
    }
}



package com.a1task1.task1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;


import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;


// class for all backend functionality, methods to be called by various servlets
public class Model {
    Firestore db;
    public Model() throws IOException{
        // initialising instance of firestore
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        FirebaseOptions.Builder builder = FirebaseOptions.builder();
        FirebaseOptions options =builder.setCredentials(credentials)
            .setProjectId("assignment1task1-417104")
            .build();
        FirebaseApp.initializeApp(options);
        
        db = FirestoreClient.getFirestore();
    }

    //method to add firestore id types to arraylist to test firestore access
    public ArrayList<String> Test(String id) throws InterruptedException, ExecutionException {
        ArrayList<String> users = new ArrayList<>();
        
        // Reference to your Firestore collection
        CollectionReference collection = db.collection("task1-users");
        //asynchronously retrieve all users
        // Get all documents in the collection
        ApiFuture<QuerySnapshot> future = collection.get();
        QuerySnapshot querySnapshot = future.get();

        for (QueryDocumentSnapshot document : querySnapshot.getDocuments()) {
            // Get the document ID
            String uId = document.getString("id");

            // Print or process the document ID
            users.add(uId);
    }
    return users;
     
}
}

package com.example.hospitaldeliveryinterface;

import com.example.hospitaldeliveryinterface.controllers.HomepageController;
import com.example.hospitaldeliveryinterface.firebase.FirestoreContext;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.FirebaseAuth;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.suuft.libretranslate.Translator;


import java.io.IOException;

public class PharmaTracApp extends Application {

    public static Firestore fstore;
    public static FirebaseAuth fauth;
    private final FirestoreContext contxtFirebase = new FirestoreContext();
    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage theStage) throws IOException {

        fstore = contxtFirebase.firebase();
        fauth = FirebaseAuth.getInstance();

        stage = theStage;
        FXMLLoader fxmlloader = new FXMLLoader(PharmaTracApp.class.getResource("Homepage.fxml"));

        scene = new Scene(fxmlloader.load(),929,706);
        stage.setTitle("PharmaTrac");
        stage.setScene(scene);
        scene.getStylesheets().add(PharmaTracApp.class.getResource("lightMode.css").toExternalForm());
        stage.show();
    }

    public static Scene getScene(){
        return scene;
    }

    public static Stage getStage(){
        return stage;
    }

    public static void main(String[] args) {
        System.out.println("PharmaTrac is loading up.");
        String textTranslate = Translator.translate("en","es", "PharmaTrac is loading up.");
        System.out.println("Spanish: " + textTranslate);
        launch();

    }
}
package com.example.javafxproject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class myMain extends Application {
    public static void main(String[] args) {
        System.out.println("main");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        System.out.println("start");
        FXMLLoader fxmlLoader = new FXMLLoader(myMain.class.getResource("app_layout.fxml"));
        VBox rootNode = fxmlLoader.load();
        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0, menuBar);
        Scene scene = new Scene(rootNode);

        primaryStage.setTitle("Hello! javafx");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private MenuBar createMenu(){
        Menu filemenu= new Menu("file");
        MenuItem newMenu= new MenuItem("new");
        newMenu.setOnAction(actionEvent ->
            System.out.println("new menu item clicked"));

        SeparatorMenuItem separatorMenuItem= new SeparatorMenuItem();

        MenuItem quitMenu= new MenuItem("quit");
        quitMenu.setOnAction(actionEvent -> {
            System.out.println("quit item clicked ");
            Platform.exit();
            System.exit(0);
        });
        filemenu.getItems().addAll(newMenu,separatorMenuItem,quitMenu);

        Menu helpmenu= new Menu("help");
        MenuItem aboutApp=new MenuItem("about");
        aboutApp.setOnAction(actionEvent -> aboutApp());
        helpmenu.getItems().addAll(aboutApp);

        MenuBar menuBar = new MenuBar();

        menuBar.getMenus().addAll(filemenu,helpmenu);
        return menuBar;

    }

    private void aboutApp() {
        Alert alertDialogue = new Alert(Alert.AlertType.INFORMATION);
        alertDialogue.setTitle("MY FIRST DESKTOP APP");
        alertDialogue.setHeaderText("Learning JavaFX !");
        alertDialogue.setContentText("I am just a beginner learning to code and will soon be coding connect four game.");
        ButtonType yesBtn=new ButtonType("Yes");
        ButtonType noBtn=new ButtonType("No");
        alertDialogue.getButtonTypes().setAll(yesBtn,noBtn);
//        alertDialogue.show();
        Optional<ButtonType> clickedBtn = alertDialogue.showAndWait();
        if (clickedBtn.isPresent() && clickedBtn.get()== yesBtn){
            System.out.println("yes button is pressed");

        }else {
            System.out.println("no button is pressed.");
        }

    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}
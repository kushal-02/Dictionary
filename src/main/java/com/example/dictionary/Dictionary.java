package com.example.dictionary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Dictionary extends Application {
int yLine = 20;

TextField wordTextField;

Button searchButton;

Label meaningLable;

    ListView<String> suggestedWordList;
    DictionaryUsingHashMap dictionaryUsingHashMap;

    Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(500,500);


        TextField wordTextField = new TextField();
        wordTextField.setPromptText("Please enter a word");
        wordTextField.setTranslateY(yLine);
        wordTextField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                meaningLable.setText(wordTextField.getText());
            }
        });


        Label meaningLabel = new Label("I am the meaning");
        meaningLabel.setTextFill(Color.GREEN.brighter());
        meaningLabel.setTranslateY(yLine+40);


         dictionaryUsingHashMap = new DictionaryUsingHashMap();


         searchButton = new Button("Search");
        searchButton.setTranslateY(yLine);
        searchButton.setTranslateX(250);
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String word = wordTextField.getText();
                if(word.isBlank()){
                    meaningLabel.setText("Please enter a word!");
                    meaningLabel.setTextFill(Color.RED);
                }
                else{
                    meaningLabel.setText(dictionaryUsingHashMap.findMeaning(word));
                    meaningLabel.setTextFill(Color.BLACK);
                }
            }
        });


        suggestedWordList = new ListView<>();
        suggestedWordList.setTranslateY(yLine+70);

        String[] suggestedList = {"Amit","Anish","Bhargav","Mayur"};
        suggestedWordList.getItems().addAll(suggestedList);





        root.getChildren().addAll(wordTextField,searchButton,meaningLabel,suggestedWordList);
        return root;

    }
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
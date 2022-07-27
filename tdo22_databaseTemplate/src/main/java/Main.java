/*
 * Author: Tri Quan Do _ Khang Van Ho
 * University of Illinois at Chicago, Summer 2022
 * CS 480: Database formation on Constructions Degradation
 * August, 01st 2022
 */
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		 try {
	            // Read file fxml and draw interface.
	            Parent root = FXMLLoader.load(getClass()
	                    .getResource("/FXML/welcomeScene.fxml"));

				primaryStage.setTitle("My Application");
				Scene s1 = new Scene(root, 660,520);
				s1.getStylesheets().add("/styles/welcomeScene.css");
	            primaryStage.setScene(s1);
	            primaryStage.show();

	        } catch(Exception e) {
	            e.printStackTrace();
	            System.exit(1);
	        }
	}
	
	public static void main(String[] args) { launch(args); }
}




import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MyController implements Initializable {

    @FXML
    private AnchorPane welcomeMainScene;

    @FXML
    private AnchorPane databaseQueries_MainInstruction;

    @FXML
    private AnchorPane infoScene;

    @FXML
    private TextField textField_IP;

    @FXML
    private TextField textField_Port;

    @FXML
    private TextField textField_Name;

    @FXML
    private TextField moneyInput;

    @FXML
    private Button playerBtnChoice;

    @FXML
    private Button drawBtnChoice;

    @FXML
    private Button bankerBtnChoice;

    @FXML
    private Button Container_BtnFunctions_BtnInsert;

    @FXML
    private Button Container_BtnFunctions_BtnDelete;

    @FXML
    private Button Container_BtnFunctions_BtnUpdate;

    @FXML
    private Button Container_BtnFunctions_BtnTableList;

    @FXML
    private Button Container_BtnFunctions_BtnTableFind;

    @FXML
    private ListView<String> listItems2;

    private static Integer PORT;
    private static String  IP_Address;
    private static String  betChoices;

    //static so each instance of controller can access to update 
    private static String textEntered = "";

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

    /*
        *
        *---------------- CONTROLLER FOR WELCOME SCENE ----------------- *
        *
    */
    public void startBtn_Method(ActionEvent e) throws Exception {
        // get instance of the loader class
        // get user accessed history information for tracing purpose

        if (!this.textField_IP.getText().isEmpty() && !this.textField_Port.getText().isEmpty() && !this.textField_Name.getText().isEmpty()) {

            System.out.println("Check text non-empty");

            Integer portVal = Integer.parseInt(this.textField_Port.getText());
            String ipAdress = this.textField_IP.getText();
            String Port = this.textField_Port.getText();

            /* Re-initialize textField for other input  */
            this.textField_Port.clear();
            this.textField_Port.clear();

            this.textField_IP.setPromptText("Please input port matches with server");
            this.textField_Port.setPromptText("Please input IP matches and start Let's Connect");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_MainInstruction.fxml"));
            Parent root2 = loader.load();  // load view into parent

            MyController databaseScene = loader.getController();  //get controller created by FXMLLoader
            root2.getStylesheets().add("/styles/databaseQueries_MainInstruction.css");   //set style

            welcomeMainScene.getScene().setRoot(root2); //update scene graph
        }

        else {
            System.out.println("Check text empty");
        }

    }




    /*
     *
     *---------------- CONTROLLER FOR DATABASE QUERIES SCENE ----------------- *
     *
     */

    public void BtnInsert(ActionEvent actionEvent) throws Exception {
        /* TODO: Update Insert page to switch - Allow to:
            1. Choose the table that insert
            2. After choosing, depend on what table to have different type of insert
            3. Analyzing duplicate: If duplicate - reject to add in, otherwise, represent successful messages
         */

        // Loading to insert main page
        FXMLLoader InsertLoader = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_Insert.fxml"));
        Parent rootInsert = InsertLoader.load();  // load view into parent

        MyController databaseScene = InsertLoader.getController();  //get controller created by FXMLLoader
        rootInsert.getStylesheets().add("/styles/databaseQueries_MainInstruction.css");   //set style

        this.databaseQueries_MainInstruction.getScene().setRoot(rootInsert); //update scene graph
    }

    public void BtnDelete(ActionEvent actionEvent) {
    }

    public void BtnUpdate(ActionEvent actionEvent) {
    }

    public void BtnTableList(ActionEvent actionEvent) {
    }

    public void BtnTableFind(ActionEvent actionEvent) {
    }

}

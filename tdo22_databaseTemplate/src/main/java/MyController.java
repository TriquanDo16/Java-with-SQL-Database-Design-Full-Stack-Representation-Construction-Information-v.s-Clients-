

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
import javafx.scene.text.Text;

public class MyController implements Initializable {

    @FXML
    private AnchorPane welcomeMainScene;

    @FXML
    private AnchorPane databaseQueries_MainInstruction;

    @FXML
    private AnchorPane databaseQueries_InsertPage;

    @FXML
    private AnchorPane databaseQueries_DeletePage;

    @FXML
    private AnchorPane databaseQueries_FindPage;

    @FXML
    private AnchorPane databaseQueries_UpdatePage;

    @FXML
    private AnchorPane databaseQueries_ListPage;

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
    private Text Delete_inputTextPort;

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


    /***************************************************************************************
     ***************
     *-------------- CONTROLLER FOR DATABASE QUERIES MAIN_INSTRUCTION SCENE --------------- *
     ***************
     ***************************************************************************************/

    public void BtnInsert(ActionEvent actionEvent) throws Exception {
        /* TODO: Update Insert page to switch - Allow to:
            1. Choose the table that insert
            2. After choosing, depend on what table to have different type of insert
            3. Analyzing duplicate: If duplicate - reject to add in, otherwise, represent successful messages
         */

        // Loading to insert main page
        FXMLLoader InsertLoader = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_Insert.fxml"));
        Parent rootInsert = InsertLoader.load();  // load view into parent

        MyController insertScene = InsertLoader.getController();  //get controller created by FXMLLoader
        rootInsert.getStylesheets().add("/styles/databaseQueries_MainInstruction.css");   //set style

        this.databaseQueries_MainInstruction.getScene().setRoot(rootInsert); //update scene graph
    }

    public void BtnDelete(ActionEvent actionEvent) throws Exception {
        // Loading to Delete main page
        FXMLLoader DeleteLoader = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_Delete.fxml"));
        Parent rootDelete = DeleteLoader.load();  // load view into parent

        MyController deleteScene = DeleteLoader.getController();  //get controller created by FXMLLoader
        rootDelete.getStylesheets().add("/styles/databaseQueries_Delete.css");   //set style

        this.databaseQueries_MainInstruction.getScene().setRoot(rootDelete); //update scene graph
    }

    public void BtnUpdate(ActionEvent actionEvent) throws Exception {
        // Loading to Update main page
        FXMLLoader UpdateLoader = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_Update.fxml"));
        Parent rootUpdate = UpdateLoader.load();  // load view into parent

        MyController updateScene = UpdateLoader.getController();  //get controller created by FXMLLoader
        rootUpdate.getStylesheets().add("/styles/databaseQueries_Update.fxml.css");   //set style

        this.databaseQueries_MainInstruction.getScene().setRoot(rootUpdate); //update scene graph
    }

    public void BtnTableList(ActionEvent actionEvent) throws Exception {
        // Loading to List main page
        FXMLLoader ListLoader = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_ListAll.fxml"));
        Parent rootListAll = ListLoader.load();  // load view into parent

        MyController listAllScene = ListLoader.getController();  //get controller created by FXMLLoader
        rootListAll.getStylesheets().add("/styles/databaseQueries_ListAll.css");   //set style

        this.databaseQueries_MainInstruction.getScene().setRoot(rootListAll); //update scene graph
    }

    public void BtnTableFind(ActionEvent actionEvent) throws Exception {
        // Loading to Find main page
        FXMLLoader FindLoader = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_Find.fxml"));
        Parent rootFindPage = FindLoader.load();  // load view into parent

        MyController findItemScene = FindLoader.getController();  //get controller created by FXMLLoader
        rootFindPage.getStylesheets().add("/styles/databaseQueries_Find.css");   //set style

        this.databaseQueries_MainInstruction.getScene().setRoot(rootFindPage); //update scene graph
    }


    /***************************************************************************************
     *****************
     *---------------- CONTROLLER FOR DATABASE QUERIES INSERT PAGE SCENE ----------------- *
     *****************
     ***************************************************************************************/
    
    public void Insert_ImageButton(ActionEvent actionEvent) {
        this.Insert_ImageButton(actionEvent);
    }


    public void Insert_UserButton(ActionEvent actionEvent) {
    }

    public void Insert_EmployeeButton(ActionEvent actionEvent) {
    }

    public void Insert_DepartmentButton(ActionEvent actionEvent) {
    }

    public void Insert_OfficeButton(ActionEvent actionEvent) {
    }

    public void Insert_BackButton(ActionEvent actionEvent) {
    }

    public void Insert_SubmitButton(ActionEvent actionEvent) {
    }

    public void Insert_ResetButton(ActionEvent actionEvent) {
    }




    /***************************************************************************************
     *****************
     *---------------- CONTROLLER FOR DATABASE QUERIES DELETE PAGE SCENE ----------------- *
     *****************
     ***************************************************************************************/
    public void Delete_ImageButton(ActionEvent actionEvent) {
    }

    public void Delete_UserButton(ActionEvent actionEvent) {
        this.Delete_inputTextPort.setText("Hello Khang Ho");
    }

    public void Delete_EmployeeButton(ActionEvent actionEvent){
    }

    public void Delete_DepartmentButton(ActionEvent actionEvent){
    }

    public void Delete_OfficeButton(ActionEvent actionEvent){
    }

    public void Delete_BackButton(ActionEvent actionEvent){
    }
    public void Delete_SubmitButton(ActionEvent actionEvent){
    }
    public void Delete_ResetButton(ActionEvent actionEvent){
    }




    /***************************************************************************************
     *****************
     *---------------- CONTROLLER FOR DATABASE QUERIES FIND PAGE SCENE ----------------- *
     *****************
     ***************************************************************************************/

    public void Find_ImageButton(ActionEvent actionEvent) {
    }

    public void Find_UserButton(ActionEvent actionEvent) {
    }

    public void Find_EmployeeButton(ActionEvent actionEvent){
    }

    public void Find_DepartmentButton(ActionEvent actionEvent){
    }

    public void Find_OfficeButton(ActionEvent actionEvent){
    }

    public void Find_BackButton(ActionEvent actionEvent){
    }
    public void Find_SubmitButton(ActionEvent actionEvent){
    }
    public void Find_ResetButton(ActionEvent actionEvent){
    }



    /***************************************************************************************
     *****************
     *---------------- CONTROLLER FOR DATABASE QUERIES UPDATE PAGE SCENE ----------------- *
     *****************
     ***************************************************************************************/

    public void Update_ImageButton(ActionEvent actionEvent) {
    }

    public void Update_UserButton(ActionEvent actionEvent) {
    }

    public void Update_EmployeeButton(ActionEvent actionEvent){
    }

    public void Update_DepartmentButton(ActionEvent actionEvent){
    }

    public void Update_OfficeButton(ActionEvent actionEvent){
    }

    public void Update_BackButton(ActionEvent actionEvent){
    }
    public void Update_SubmitButton(ActionEvent actionEvent){
    }
    public void Update_ResetButton(ActionEvent actionEvent){
    }



    /***************************************************************************************
     *****************
     *---------------- CONTROLLER FOR DATABASE QUERIES LIST PAGE SCENE ----------------- *
     *****************
     ***************************************************************************************/

}

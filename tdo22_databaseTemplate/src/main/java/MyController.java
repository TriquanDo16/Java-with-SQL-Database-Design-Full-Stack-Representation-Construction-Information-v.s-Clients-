

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

/** Import SQl Modules */
import java.sql.*;

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
    private VBox Insert_Prompt_Text;
    @FXML
    private VBox Insert_ImageDataInput_Container;
    @FXML
    private VBox Insert_UserDataInput_Container;
    @FXML
    private VBox Insert_EmployeeDataInput_Container;
    @FXML
    private VBox Insert_DepartmentDataInput_Container;
    @FXML
    private VBox Insert_OfficeDataInput_Container;
    @FXML
    private VBox Delete_input_Container;
    @FXML
    private VBox Find_input_Container;
    @FXML
    private VBox Update_input_Container;

    @FXML
    private Text Delete_inputTextPort;
    @FXML
    private Text Find_inputText;
    @FXML
    private Text Update_inputTextPort;

    @FXML
    private VBox Update_ImageDataInput_Container;

    @FXML
    private VBox Update_UserDataInput_Container;
    @FXML
    private VBox Update_EmployeeDataInput_Container;
    @FXML
    private VBox Update_DepartmentDataInput_Container;
    @FXML
    private VBox Update_OfficeDataInput_Container;

    @FXML
    private TextField textField_IP;
    @FXML
    private TextField textField_Port;
    @FXML
    private TextField textField_Name;

    /**
     * Text Fields for Insert Image Entities
     */
    @FXML
    private TextField Insert_TextField_Image_ID;
    @FXML
    private TextField Insert_textField_Address;
    @FXML
    private TextField Insert_TextField_Description;
    @FXML
    private TextField Insert_TextField_Type;
    @FXML
    private TextField Insert_TextField_Status;
    @FXML
    private TextField Insert_TextField_Department;
    @FXML
    private TextField Insert_TextField_Owner;
    @FXML
    private TextField Insert_TextField_Time_Posted;
    @FXML
    private TextField Insert_TextField_OfficeID;
    @FXML
    private TextField Insert_TextField_SSN;

    /**
     * Text Fields for Insert User Entities
     */


    /**
     * Text Fields for Insert Employee Entities
     */


    /**
     * Text Fields for Insert Department Entities
     */


    /**
     * Text Fields for Insert Office Entities
     */


    /**
     * Text Fields for DELETE Entities
     */
    @FXML
    private TextField Delete_textField_Port;

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

    /** Database Connector */
    private static Connection connection;

    /** Data Structure to store main Primary key */
    private static ArrayList<String> imageIDList;
    private static ArrayList<String> userUploadSSNList;
    private static ArrayList<String> officeIDList;
    private static ArrayList<String> departmentIDList;
    private static ArrayList<String> employeeSSNList;

    /** Other private data memeber */
    // Insert Boolean Value to check what Entity user had been chosen
    private boolean insertImage;
    private boolean insertUser;
    private boolean insertEmployee;
    private boolean insertDepartment;
    private boolean insertOffice;

    // Update Boolean Value to check what Entity user had been chosen
    private boolean updateImage;
    private boolean updateUser;
    private boolean updateEmployee;
    private boolean updateDepartment;
    private boolean updateOffice;

    // Delete Boolean Value to check what Entity user had been chosen
    private boolean deleteImage;
    private boolean deleteUser;
    private boolean deleteEmployee;
    private boolean deleteDepartment;
    private boolean deleteOffice;

    // ListAll Boolean Value to check what Entity user had been chosen
    private boolean listAllImage;
    private boolean listAllUser;
    private boolean listAllEmployee;
    private boolean listAllDepartment;
    private boolean listAllOffice;

    // Find Boolean Value to check what Entity user had been chosen
    private boolean findImage;
    private boolean findUser;
    private boolean findEmployee;
    private boolean findDepartment;
    private boolean findOffice;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
    }

    /**
     * PRIVATE DATA METHOD TO SUPPORT PROGRAM
     */
    private ArrayList<String> IDPrimaryKey(Connection con, String tableName, String column) throws SQLException {
        ArrayList<String> listPrimaryKey = new ArrayList<>();

        //Creating a Statement object
        System.out.println("Before create Statement line 187");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select " + column + " from " + tableName);
        System.out.println("After create Statement line 190");

        while(rs.next()) {
            listPrimaryKey.add(rs.getString(column));
        }

        return listPrimaryKey;
    }

    private void outputArrayList(ArrayList<String> arr) {
        System.out.println("Contents of the table");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    /**
     * Function  : dataInitialization
     * @Parameter: none
     * @Purpose  : Initialize all data member to default value
     * @Return   : none, data members will be updated automatically
     */
    private void dataInitialization() {
        // Data member for insertPage
        this.insertImage = false;
        this.insertUser = false;
        this.insertEmployee = false;
        this.insertDepartment = false;
        this.insertOffice = false;

        // Update Boolean Value to check what Entity user had been chosen
        this.updateImage = false;
        this.updateUser = false;
        this.updateEmployee = false;
        this.updateDepartment = false;
        this.updateOffice = false;

        // Delete Boolean Value to check what Entity user had been chosen
        this.deleteImage = false;
        this.deleteUser = false;
        this.deleteEmployee = false;
        this.deleteDepartment = false;
        this.deleteOffice = false;

        // ListAll Boolean Value to check what Entity user had been chosen
        this.listAllImage = false;
        this.listAllUser = false;
        this.listAllEmployee = false;
        this.listAllDepartment = false;
        this.listAllOffice = false;

        // Find Boolean Value to check what Entity user had been chosen
        this.findImage = false;
        this.findUser = false;
        this.findEmployee = false;
        this.findDepartment = false;
        this.findOffice = false;
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
            String username = this.textField_Name.getText();

            /* Re-initialize textField for other input  */
            this.textField_Port.clear();
            this.textField_IP.clear();
            this.textField_Name.clear();

            this.textField_IP.setPromptText("Please input port matches with server");
            this.textField_Port.setPromptText("Please input IP matches and start Let's Connect");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_MainInstruction.fxml"));
            Parent root2 = loader.load();  // load view into parent

            MyController databaseScene = loader.getController();  //get controller created by FXMLLoader
            root2.getStylesheets().add("/styles/databaseQueries_MainInstruction.css");   //set style

            /** Database Initialization */
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                this.connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/jdbcdemo","root","Triquan1602.2001");

                System.out.println("Connected successfully to database");

//                Statement stmt = this.connection.createStatement();
//                ResultSet rs = stmt.executeQuery("select * from test");
//                while(rs.next())
//                            System.out.println(rs.getString(1)+"  "+rs.getString(2));

                /**
                 * Retrieving the meta data object
                 * Loading all primary key to check duplicate
                 * Primary key for each stable will be store in a dynamic arrayList
                 */

                this.imageIDList = IDPrimaryKey(this.connection, "image", "image_ID");
                this.userUploadSSNList = IDPrimaryKey(this.connection, "jdbcdemo.user_upload", "SSN");
                this.officeIDList = IDPrimaryKey(this.connection, "app_controller_office", "office_ID");
                this.departmentIDList = IDPrimaryKey(this.connection, "department", "department_ID");
                this.employeeSSNList = IDPrimaryKey(this.connection, "employee", "SSN");

                outputArrayList(this.imageIDList);
//                this.connection.close(); // End Database Connector - Exit
            } catch(Exception sqlError) {
                System.out.println("Failing connect to database");
                System.out.println(sqlError);
            }

            welcomeMainScene.getScene().setRoot(root2); // Update Scene UI
        } else {
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
        rootInsert.getStylesheets().add("/styles/databaseQueries_Insert.css");   //set style

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
        rootUpdate.getStylesheets().add("/styles/databaseQueries_Update.css");   //set style

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

    public void BtnTableStatistic(ActionEvent actionEvent) throws Exception {
        // Loading to Find main page
        FXMLLoader statisticLoader = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_Statistic.fxml"));
        Parent rootStatPage = statisticLoader.load();  // load view into parent

        MyController statScene = statisticLoader.getController();  //get controller created by FXMLLoader
        rootStatPage.getStylesheets().add("/styles/databaseQueries_Statistic.css");   //set style

        this.databaseQueries_MainInstruction.getScene().setRoot(rootStatPage); //update scene graph

    }



    /***************************************************************************************
     *****************
     *---------------- CONTROLLER FOR DATABASE QUERIES INSERT PAGE SCENE ----------------- *
     *****************
     ***************************************************************************************/

    public void Insert_ImageButton(ActionEvent actionEvent) {
        this.insertImage = true;
        this.insertUser = false;
        this.insertEmployee = false;
        this.insertDepartment = false;
        this.insertOffice = false;

        this.Insert_ImageDataInput_Container.setVisible(true);
        this.Insert_UserDataInput_Container.setVisible(false);
        this.Insert_EmployeeDataInput_Container.setVisible(false);
        this.Insert_DepartmentDataInput_Container.setVisible(false);
        this.Insert_OfficeDataInput_Container.setVisible(false);
    }

    public void Insert_UserButton(ActionEvent actionEvent) {
        this.insertImage = false;
        this.insertUser = true;
        this.insertEmployee = false;
        this.insertDepartment = false;
        this.insertOffice = false;

        this.Insert_ImageDataInput_Container.setVisible(false);
        this.Insert_UserDataInput_Container.setVisible(true);
        this.Insert_EmployeeDataInput_Container.setVisible(false);
        this.Insert_DepartmentDataInput_Container.setVisible(false);
        this.Insert_OfficeDataInput_Container.setVisible(false);
    }

    public void Insert_EmployeeButton(ActionEvent actionEvent) {
        this.insertImage = false;
        this.insertUser = false;
        this.insertEmployee = true;
        this.insertDepartment = false;
        this.insertOffice = false;

        this.Insert_ImageDataInput_Container.setVisible(false);
        this.Insert_UserDataInput_Container.setVisible(false);
        this.Insert_EmployeeDataInput_Container.setVisible(true);
        this.Insert_DepartmentDataInput_Container.setVisible(false);
        this.Insert_OfficeDataInput_Container.setVisible(false);
    }

    public void Insert_DepartmentButton(ActionEvent actionEvent) {
        this.insertImage = false;
        this.insertUser = false;
        this.insertEmployee = false;
        this.insertDepartment = true;
        this.insertOffice = false;

        this.Insert_ImageDataInput_Container.setVisible(false);
        this.Insert_UserDataInput_Container.setVisible(false);
        this.Insert_EmployeeDataInput_Container.setVisible(false);
        this.Insert_DepartmentDataInput_Container.setVisible(true);
        this.Insert_OfficeDataInput_Container.setVisible(false);
    }

    public void Insert_OfficeButton(ActionEvent actionEvent) {
        this.insertImage = false;
        this.insertUser = false;
        this.insertEmployee = false;
        this.insertDepartment = false;
        this.insertOffice = true;

        this.Insert_ImageDataInput_Container.setVisible(false);
        this.Insert_UserDataInput_Container.setVisible(false);
        this.Insert_EmployeeDataInput_Container.setVisible(false);
        this.Insert_DepartmentDataInput_Container.setVisible(false);
        this.Insert_OfficeDataInput_Container.setVisible(true);
    }

    public void Insert_BackButton(ActionEvent actionEvent) throws Exception {
        /* Re-initialize all recognizable members to default */
        this.insertImage = false;
        this.insertUser = false;
        this.insertEmployee = false;
        this.insertDepartment = false;
        this.insertOffice = false;

        /** Return to the main option page */
        // Loading to main page
        FXMLLoader backPage = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_MainInstruction.fxml"));
        Parent rootBackPage = backPage.load();  // load view into parent

        MyController deleteScene = backPage.getController();  //get controller created by FXMLLoader
        rootBackPage.getStylesheets().add("/styles/databaseQueries_MainInstruction.css");   //set style

        this.databaseQueries_InsertPage.getScene().setRoot(rootBackPage); //update scene graph
    }

    public void Insert_SubmitButton(ActionEvent actionEvent) throws SQLException {
        if (this.insertImage) {
            String ID = this.Insert_TextField_Image_ID.getText();
            String address = this.Insert_textField_Address.getText();
            String description = Insert_TextField_Description.getText();
            String type = Insert_TextField_Type.getText();
            Integer status = Integer.valueOf(Insert_TextField_Status.getText());
            String department = Insert_TextField_Department.getText();
            String ownerText  = Insert_TextField_Owner.getText();
            Integer timePosted = Integer.valueOf(Insert_TextField_Time_Posted.getText());
            String officeID = Insert_TextField_OfficeID.getText();
            String ownerSSN = Insert_TextField_SSN.getText();

            for (int i = 0; i < this.imageIDList.size(); i++) {
                System.out.println(this.imageIDList.get(i));
            }

            if(this.imageIDList.contains(ID)) {
                System.out.println(" --> Duplicate, please click on reset and try again!!");
            } else {
                System.out.println(" Before Adding process!!");
                this.imageIDList.add(ID); // Update to avoid duplicate
                String SQL_INSERT = "INSERT INTO image (image_ID, address, description, type, status, department, owner, year_posted, office_ID, SSN)" +
                        " VALUES (?,?,?,?,?,?,?,?,?,?)";

                System.out.println(" In Adding process!!");

                PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);

                preparedStatement.setString(1, ID);
                preparedStatement.setString(2, address);
                preparedStatement.setString(3, description);
                preparedStatement.setString(4, type);
                preparedStatement.setInt(5, status);
                preparedStatement.setString(6, department);
                preparedStatement.setString(7, ownerText);
                preparedStatement.setInt(8, timePosted);
                preparedStatement.setString(9, officeID);
                preparedStatement.setString(10, ownerSSN);

                int row = preparedStatement.executeUpdate();    // Update back to SQL database
                System.out.println(" Successfully Adding process!!");
                // System.out.println(row); // rows affected = 1
            }
        }

        else if (this.insertUser) {

        }

        else if (this.insertEmployee) {

        }

        else if (this.insertDepartment) {

        }

        else if (this.insertOffice) {

        }

        else {
            System.out.println("  --> System Error, Please check the Back-End Operation. Line 415");
        }
    }

    public void Insert_ResetButton(ActionEvent actionEvent) throws Exception {
        /* Re-initialize all recognizable members to default */
        this.insertImage = false;
        this.insertUser = false;
        this.insertEmployee = false;
        this.insertDepartment = false;
        this.insertOffice = false;

        /** Reset Clear Page to insert another entities */
        // Loading to Delete main page
        FXMLLoader resetInsertPage = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_Insert.fxml"));
        Parent rootResetInsertPage = resetInsertPage.load();  // load view into parent

        MyController deleteScene = resetInsertPage.getController();  //get controller created by FXMLLoader
        rootResetInsertPage.getStylesheets().add("/styles/databaseQueries_Insert.css");   //set style

        this.databaseQueries_InsertPage.getScene().setRoot(rootResetInsertPage); //update scene graph
    }



    /***************************************************************************************
     *****************
     *---------------- CONTROLLER FOR DATABASE QUERIES DELETE PAGE SCENE ----------------- *
     *****************
     ***************************************************************************************/
    public void Delete_ImageButton(ActionEvent actionEvent) {
        //this.Delete_inputTextPort.setText("Image ID");
        this.Delete_input_Container.setVisible(true);

        this.deleteImage = true;
        this.deleteUser = false;
        this.deleteEmployee = false;
        this.deleteDepartment = false;
        this.deleteOffice = false;
    }

    public void Delete_UserButton(ActionEvent actionEvent) {
        //this.Delete_inputText.setText("SSN:");
        this.Delete_input_Container.setVisible(true);

        this.deleteImage = false;
        this.deleteUser = true;
        this.deleteEmployee = false;
        this.deleteDepartment = false;
        this.deleteOffice = false;
    }

    public void Delete_EmployeeButton(ActionEvent actionEvent){
        //this.Delete_inputText.setText("SSN:");
        this.Delete_input_Container.setVisible(true);

        this.deleteImage = false;
        this.deleteUser = false;
        this.deleteEmployee = true;
        this.deleteDepartment = false;
        this.deleteOffice = false;
    }

    public void Delete_DepartmentButton(ActionEvent actionEvent){
        // this.Delete_inputText.setText("Deparment ID:");
        this.Delete_input_Container.setVisible(true);

        this.deleteImage = false;
        this.deleteUser = false;
        this.deleteEmployee = false;
        this.deleteDepartment = true;
        this.deleteOffice = false;
    }

    public void Delete_OfficeButton(ActionEvent actionEvent){
        // this.Delete_inputText.setText("Office ID:");
        this.Delete_input_Container.setVisible(true);

        this.deleteImage = false;
        this.deleteUser = false;
        this.deleteEmployee = false;
        this.deleteDepartment = false;
        this.deleteOffice = true;
    }

    public void Delete_SubmitButton(ActionEvent actionEvent) throws SQLException {
        String primaryKey = this.Delete_textField_Port.getText();
        System.out.println("Local testing on Delete: "+ primaryKey);
        String SQL_DELETE = "";

        if (this.deleteImage)
            SQL_DELETE = "DELETE FROM image WHERE image_ID=?";
        else if (this.deleteUser)
            SQL_DELETE = "DELETE FROM user_upload WHERE SSN=?";
        else if (this.deleteEmployee)
            SQL_DELETE = "DELETE FROM employee WHERE SSN=?";
        else if (this.deleteDepartment)
            SQL_DELETE = "DELETE FROM department WHERE department_ID=?";
        else if (this.deleteOffice)
            SQL_DELETE = "DELETE FROM app_controller_office WHERE office_ID=?";

        PreparedStatement preparedStatement = this.connection.prepareStatement(SQL_DELETE);
        preparedStatement.setString(1, primaryKey);

        System.out.println("--> Done! Delete Succefully");

        int row = preparedStatement.executeUpdate();    // Update to the SQL System
    }

    public void Delete_BackButton(ActionEvent actionEvent) throws Exception {
        /* Re-initialize all recognizable members to default */
        this.deleteImage = false;
        this.deleteUser = false;
        this.deleteEmployee = false;
        this.deleteDepartment = false;
        this.deleteOffice = false;

        /** Return to the main option page */
        // Loading to main page
        FXMLLoader backPage = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_MainInstruction.fxml"));
        Parent rootBackPage = backPage.load();  // load view into parent

        MyController deleteScene = backPage.getController();  //get controller created by FXMLLoader
        rootBackPage.getStylesheets().add("/styles/databaseQueries_MainInstruction.css");   //set style

        this.databaseQueries_DeletePage.getScene().setRoot(rootBackPage); //update scene graph
    }

    public void Delete_ResetButton(ActionEvent actionEvent) throws Exception {
        /* Re-initialize all recognizable members to default */
        this.deleteImage = false;
        this.deleteUser = false;
        this.deleteEmployee = false;
        this.deleteDepartment = false;
        this.deleteOffice = false;

        /** Reset Clear Page to insert another entities */
        // Loading to Delete main page
        FXMLLoader resetPage = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_Delete.fxml"));
        Parent rootResetDeletePage = resetPage.load();  // load view into parent

        MyController deleteScene = resetPage.getController();  //get controller created by FXMLLoader
        rootResetDeletePage.getStylesheets().add("/styles/databaseQueries_Delete.css");   //set style

        this.databaseQueries_DeletePage.getScene().setRoot(rootResetDeletePage); //update scene graph
    }



    /***************************************************************************************
     *****************
     *---------------- CONTROLLER FOR DATABASE QUERIES FIND PAGE SCENE ----------------- *
     *****************
     ***************************************************************************************/

    public void Find_ImageButton(ActionEvent actionEvent) {
        // this.Find_inputTextPort.setText("Image ID");
        this.Find_input_Container.setVisible(true);
    }

    public void Find_UserButton(ActionEvent actionEvent) {
        //  this.Find_inputTextPort.setText("SSN");
        this.Find_input_Container.setVisible(true);
    }

    public void Find_EmployeeButton(ActionEvent actionEvent){
        //this.Find_inputTextPort.setText("SSN");
        this.Find_input_Container.setVisible(true);
    }

    public void Find_DepartmentButton(ActionEvent actionEvent){
        // this.Find_inputTextPort.setText("Department ID");
        this.Find_input_Container.setVisible(true);
    }

    public void Find_OfficeButton(ActionEvent actionEvent){
        // this.Find_inputTextPort.setText("Office ID");
        this.Find_input_Container.setVisible(true);
    }

    public void Find_SubmitButton(ActionEvent actionEvent){

    }



    public void Find_BackButton(ActionEvent actionEvent){

    }

    public void Find_ResetButton(ActionEvent actionEvent){
    }



    /***************************************************************************************
     *****************
     *---------------- CONTROLLER FOR DATABASE QUERIES UPDATE PAGE SCENE ----------------- *
     *****************
     ***************************************************************************************/

    public void Update_ImageButton(ActionEvent actionEvent) {
        this.Update_ImageDataInput_Container.setVisible(true);
        this.Update_UserDataInput_Container.setVisible(false);
        this.Update_EmployeeDataInput_Container.setVisible(false);
        this.Update_DepartmentDataInput_Container.setVisible(false);
        this.Update_OfficeDataInput_Container.setVisible(false);

        this.updateImage = true;
        this.updateUser = false;
        this.updateEmployee = false;
        this.updateDepartment = false;
        this.updateOffice = false;
    }

    public void Update_UserButton(ActionEvent actionEvent) {
        this.Update_ImageDataInput_Container.setVisible(false);
        this.Update_UserDataInput_Container.setVisible(true);
        this.Update_EmployeeDataInput_Container.setVisible(false);
        this.Update_DepartmentDataInput_Container.setVisible(false);
        this.Update_OfficeDataInput_Container.setVisible(false);

        this.updateImage = false;
        this.updateUser = true;
        this.updateEmployee = false;
        this.updateDepartment = false;
        this.updateOffice = false;
    }

    public void Update_EmployeeButton(ActionEvent actionEvent){
        this.Update_ImageDataInput_Container.setVisible(false);
        this.Update_UserDataInput_Container.setVisible(false);
        this.Update_EmployeeDataInput_Container.setVisible(true);
        this.Update_DepartmentDataInput_Container.setVisible(false);
        this.Update_OfficeDataInput_Container.setVisible(false);
        this.Update_inputTextPort.setText("Image ID:");
        this.Update_input_Container.setVisible(true);

        this.updateImage = false;
        this.updateUser = false;
        this.updateEmployee = true;
        this.updateDepartment = false;
        this.updateOffice = false;
    }

    public void Update_DepartmentButton(ActionEvent actionEvent){
        this.Update_ImageDataInput_Container.setVisible(false);
        this.Update_UserDataInput_Container.setVisible(false);
        this.Update_EmployeeDataInput_Container.setVisible(false);
        this.Update_DepartmentDataInput_Container.setVisible(true);
        this.Update_OfficeDataInput_Container.setVisible(false);

        this.updateImage = false;
        this.updateUser = false;
        this.updateEmployee = false;
        this.updateDepartment = true;
        this.updateOffice = false;
    }

    public void Update_OfficeButton(ActionEvent actionEvent){
        this.Update_ImageDataInput_Container.setVisible(false);
        this.Update_UserDataInput_Container.setVisible(false);
        this.Update_EmployeeDataInput_Container.setVisible(false);
        this.Update_DepartmentDataInput_Container.setVisible(false);
        this.Update_OfficeDataInput_Container.setVisible(true);
        this.Update_inputTextPort.setText("Office ID:");
        this.Update_input_Container.setVisible(true);

        this.updateImage = false;
        this.updateUser = false;
        this.updateEmployee = false;
        this.updateDepartment = false;
        this.updateOffice = true;
    }


    public void Update_BackButton(ActionEvent actionEvent) throws Exception {
        // Update Boolean Value to check what Entity user had been chosen
        this.updateImage = false;
        this.updateUser = false;
        this.updateEmployee = false;
        this.updateDepartment = false;
        this.updateOffice = false;

        /** Back Page to insert another entities */
        // Loading to Delete main page
        FXMLLoader resetPage = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_MainInstruction.fxml"));
        Parent rootResetPage = resetPage.load();  // load view into parent

        MyController updateScene = resetPage.getController();  //get controller created by FXMLLoader
        rootResetPage.getStylesheets().add("/styles/databaseQueries_MainInstruction.css");   //set style

        this.databaseQueries_UpdatePage.getScene().setRoot(rootResetPage); //update scene graph
    }


    public void Update_ResetButton(ActionEvent actionEvent) throws Exception {
        // Update Boolean Value to check what Entity user had been chosen
        this.updateImage = false;
        this.updateUser = false;
        this.updateEmployee = false;
        this.updateDepartment = false;
        this.updateOffice = false;

        /** Reset Clear Page to insert another entities */
        // Loading to Delete main page
        FXMLLoader resetPage = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_Update.fxml"));
        Parent rootResetPage = resetPage.load();  // load view into parent

        MyController updateScene = resetPage.getController();  //get controller created by FXMLLoader
        rootResetPage.getStylesheets().add("/styles/databaseQueries_Update.css");   //set style

        this.databaseQueries_UpdatePage.getScene().setRoot(rootResetPage); //update scene graph

    }

    public void Update_SubmitButton(ActionEvent actionEvent) {


    }






    /***************************************************************************************
     *****************
     *---------------- CONTROLLER FOR DATABASE QUERIES LIST PAGE SCENE ----------------- *
     *****************
     ***************************************************************************************/

}

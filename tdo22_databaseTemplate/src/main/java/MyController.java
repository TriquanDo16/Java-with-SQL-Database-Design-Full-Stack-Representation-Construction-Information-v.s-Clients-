

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/** Import SQl Modules */
import java.sql.*;

public class MyController implements Initializable {
    @FXML
    public TableView<String> listAll_tableViewImage;
    @FXML
    public List<String> listUser;

    @FXML
    private TextArea listAll_ResultField_TextAreaResult;
    @FXML
    private TextArea Stat_QueryResult;

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
    private AnchorPane databaseQueries_StatisticPage;

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
    private Text Stat_Query;

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
     * Text Fields for Insert User Uploaded Entities
     */
    @FXML
    private TextField Insert_User_TextField_SSN;
    @FXML
    private TextField Insert_textField_UserName;
    @FXML
    private TextField Insert_textField_PersonalContact;
    @FXML
    private TextField Insert_TextField_User_Address;
    @FXML
    private TextField Insert_TextField_User_Credibility;
    @FXML
    private TextField Insert_TextField_User_DataUploaded;

    /**
     * Text Fields for Insert Employee Entities
     */
    @FXML
    private TextField Insert_TextField_Empl_SSN;
    @FXML
    private TextField Insert_textField_Empl_Name;
    @FXML
    private TextField Insert_TextField_Empl_Address;
    @FXML
    private TextField Insert_TextField_Empl_Contact;
    @FXML
    private TextField Insert_TextField_Empl_Position;
    @FXML
    private TextField Insert_TextField_Empl_RoomAssigned;

    /**
     * Text Fields for Insert Employee Entities
     */
    @FXML
    private TextField Insert_TextField_DepartmentID;
    @FXML
    private TextField Insert_textField_DepartmentAddress;
    @FXML
    private TextField Insert_textField_Contact;
    @FXML
    private TextField Insert_TextField_Department_HoursIn;
    @FXML
    private TextField Insert_TextField_Department_HoursEnd;
    @FXML
    private TextField Insert_TextField_Department_OfficeHours_OfficeID;

    /**
     * Text Fields for Insert Employee Entities
     */
    @FXML
    private TextField Insert_TextField_Office_OfficeID;
    @FXML
    private TextField Insert_textField_OfficeAddress;
    @FXML
    private TextField Insert_TextField_Office_HoursIn;
    @FXML
    private TextField Insert_TextField_Office_HoursEnd;
    @FXML
    private TextField Insert_TextField_Office_ManagerSSN;


    /*********************************************************************************/
    /*********************************************************************************/
    /*********************************************************************************/

    /**
     * Text Fields for UPDATE Image Entities
     */
    @FXML
    private TextField Update_TextField_Image_ID;
    @FXML
    private TextField Update_textField_Address;
    @FXML
    private TextField Update_TextField_Description;
    @FXML
    private TextField Update_TextField_Type;
    @FXML
    private TextField Update_TextField_Status;
    @FXML
    private TextField Update_TextField_Department;
    @FXML
    private TextField Update_TextField_Owner;
    @FXML
    private TextField Update_TextField_Time_Posted;
    @FXML
    private TextField Update_TextField_OfficeID;
    @FXML
    private TextField Update_TextField_SSN;

    /**
     * Text Fields for UPDATE User Upload Entities
     */
    @FXML
    private TextField Update_User_TextField_SSN;
    @FXML
    private TextField Update_textField_UserName;
    @FXML
    private TextField Update_textField_PersonalContact;
    @FXML
    private TextField Update_TextField_User_Address;
    @FXML
    private TextField Update_TextField_User_Credibility;
    @FXML
    private TextField Update_TextField_User_DataUploaded;

    /**
     * Text Fields for UPDATE Employee Entities
     */
    @FXML
    private TextField Update_TextField_Empl_SSN;
    @FXML
    private TextField Update_textField_Empl_Name;
    @FXML
    private TextField Update_TextField_Empl_Address;
    @FXML
    private TextField Update_TextField_Empl_Contact;
    @FXML
    private TextField Update_TextField_Empl_Position;
    @FXML
    private TextField Update_TextField_Empl_RoomAssigned;

    /**
     * Text Fields for UPDATE Department Entities
     */
    @FXML
    private TextField Update_TextField_DepartmentID;
    @FXML
    private TextField Update_textField_DepartmentAddress;
    @FXML
    private TextField Update_textField_Contact;
    @FXML
    private TextField Update_TextField_Department_HoursIn;
    @FXML
    private TextField Update_TextField_Department_HoursEnd;
    @FXML
    private TextField Update_TextField_Department_OfficeHours_OfficeID;

    /**
     * Text Fields for UPDATE Office Entities
     */
    @FXML
    private TextField Update_TextField_Office_OfficeID;
    @FXML
    private TextField Update_textField_OfficeAddress;
    @FXML
    private TextField Update_TextField_Office_HoursIn;
    @FXML
    private TextField Update_TextField_Office_HoursEnd;
    @FXML
    private TextField Update_TextField_Office_ManagerSSN;


    ///*********************************************************************************/
    ///*********************************************************************************/
    ///*********************************************************************************/

    /**
     * Text Fields for DELETE Entities
     */
    @FXML
    private TextField Delete_textField_Port;

    ///*********************************************************************************/
    ///*********************************************************************************/
    ///*********************************************************************************/
    /**
     * FXML Loading for FIND Entities
     */
    @FXML
    private TextField Find_textField_Port;
    @FXML
    private Text Find_TexOutput_Container_Content;


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
            String SSN = Insert_User_TextField_SSN.getText();
            String username = Insert_textField_UserName.getText();
            Integer contact = Integer.valueOf(Insert_textField_PersonalContact.getText());
            String address =  Insert_TextField_User_Address.getText();
            Integer credit  = Integer.valueOf(Insert_TextField_User_Credibility.getText());
            Integer dateUp  = Integer.valueOf(Insert_TextField_User_DataUploaded.getText());

            if(this.userUploadSSNList.contains(SSN)) {
                System.out.println(" --> Duplicate, please click on reset and try again!!");
            } else {
                System.out.println(" Before Adding process!!");
                this.userUploadSSNList.add(SSN); // Update to avoid duplicate
                String SQL_INSERT = "INSERT INTO user_upload (SSN, username, contact, address, credibility, date_uploaded)" +
                        " VALUES (?,?,?,?,?,?)";

                System.out.println(" In Adding process!!");

                PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);

                preparedStatement.setString(1, SSN);
                preparedStatement.setString(2, username);
                preparedStatement.setInt(3, contact);
                preparedStatement.setString(4, address);
                preparedStatement.setInt(5, credit);
                preparedStatement.setInt(6, dateUp);

                int row = preparedStatement.executeUpdate();    // Update back to SQL database
                System.out.println(" Successfully Adding process!!");
                // System.out.println(row); // rows affected = 1
            }
        }

        else if (this.insertEmployee) {
            String SSN = Insert_TextField_Empl_SSN.getText();
            String name = Insert_textField_Empl_Name.getText();
            String address = Insert_TextField_Empl_Address.getText();
            Integer contact = Integer.valueOf(Insert_TextField_Empl_Contact.getText());
            String position = Insert_TextField_Empl_Position.getText();
            String roomAssigned = Insert_TextField_Empl_RoomAssigned.getText();

            if(this.employeeSSNList.contains(SSN)) {
                System.out.println(" --> Duplicate, please click on reset and try again!!");
            } else {
                System.out.println(" Before Adding process!!");
                this.employeeSSNList.add(SSN); // Update to avoid duplicate
                String SQL_INSERT = "INSERT INTO employee (SSN, name, address, contact, position, room_assigned)" +
                        " VALUES (?,?,?,?,?,?)";

                System.out.println(" In Adding process!!");

                PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);

                preparedStatement.setString(1, SSN);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, address);
                preparedStatement.setInt(4, contact);
                preparedStatement.setString(5, position);
                preparedStatement.setString(6, roomAssigned);

                int row = preparedStatement.executeUpdate();    // Update back to SQL database
                System.out.println(" Successfully Adding process!!");
                // System.out.println(row); // rows affected = 1
            }
        }

        else if (this.insertDepartment) {
            String departmentIDText = Insert_TextField_DepartmentID.getText();
            String addressText = Insert_textField_DepartmentAddress.getText();
            Integer contactText = Integer.valueOf(Insert_textField_Contact.getText());
            String hoursInText = Insert_TextField_Department_HoursIn.getText();
            String hoursEndText = Insert_TextField_Department_HoursEnd.getText();
            String officeIDText = Insert_TextField_Department_OfficeHours_OfficeID.getText();

            if(this.departmentIDList.contains(departmentIDText)) {
                System.out.println(" --> Duplicate, please click on reset and try again!!");
            } else {
                System.out.println(" Before Adding process!!");
                this.departmentIDList.add(departmentIDText); // Update to avoid duplicate
                String SQL_INSERT = "INSERT INTO employee (department_ID, contact, address, office_hour_in, office_hour_end, office_ID)" +
                                    " VALUES (?,?,?,?,?,?)";

                System.out.println(" In Adding process!!");

                PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);

                preparedStatement.setString(1, departmentIDText);
                preparedStatement.setInt(2, contactText);
                preparedStatement.setString(3, addressText);
                preparedStatement.setString(4, hoursInText);
                preparedStatement.setString(5, hoursEndText);
                preparedStatement.setString(6, officeIDText);

                int row = preparedStatement.executeUpdate();    // Update back to SQL database
                System.out.println(" Successfully Adding process!!");
                // System.out.println(row); // rows affected = 1
            }

        }

        else if (this.insertOffice) {
            String officeIDText = Insert_TextField_Office_OfficeID.getText();
            String addressText = Insert_textField_OfficeAddress.getText();
            String hoursInText = Insert_TextField_Office_HoursIn.getText();
            String hoursEndText = Insert_TextField_Office_HoursEnd.getText();
            String managerSSNText = Insert_TextField_Office_ManagerSSN.getText();

            if(this.officeIDList.contains(officeIDText)) {
                System.out.println(" --> Duplicate, please click on reset and try again!!");
            } else {
                System.out.println(" Before Adding process!!");
                this.officeIDList.add(officeIDText); // Update to avoid duplicate
                String SQL_INSERT = "INSERT INTO employee (office_ID, address, office_hour_in, office_hour_end, manager_SSN)" +
                                    " VALUES (?,?,?,?,?)";

                System.out.println(" In Adding process!!");

                PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);

                preparedStatement.setString(1, officeIDText);
                preparedStatement.setString(2, addressText);
                preparedStatement.setString(3, hoursInText);
                preparedStatement.setString(4, hoursEndText);
                preparedStatement.setString(5, managerSSNText);

                int row = preparedStatement.executeUpdate();    // Update back to SQL database
                System.out.println(" Successfully Adding process!!");
                // System.out.println(row); // rows affected = 1
            }
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

        // Find Boolean Value to check what Entity user had been chosen
        this.findImage = true;
        this.findUser = false;
        this.findEmployee = false;
        this.findDepartment = false;
        this.findOffice = false;
    }

    public void Find_UserButton(ActionEvent actionEvent) {
        //  this.Find_inputTextPort.setText("SSN");
        this.Find_input_Container.setVisible(true);

        // Find Boolean Value to check what Entity user had been chosen
        this.findImage = false;
        this.findUser = true;
        this.findEmployee = false;
        this.findDepartment = false;
        this.findOffice = false;
    }

    public void Find_EmployeeButton(ActionEvent actionEvent){
        //this.Find_inputTextPort.setText("SSN");
        this.Find_input_Container.setVisible(true);

        // Find Boolean Value to check what Entity user had been chosen
        this.findImage = false;
        this.findUser = false;
        this.findEmployee = true;
        this.findDepartment = false;
        this.findOffice = false;
    }

    public void Find_DepartmentButton(ActionEvent actionEvent){
        // this.Find_inputTextPort.setText("Department ID");
        this.Find_input_Container.setVisible(true);

        // Find Boolean Value to check what Entity user had been chosen
        this.findImage = false;
        this.findUser = false;
        this.findEmployee = false;
        this.findDepartment = true;
        this.findOffice = false;
    }

    public void Find_OfficeButton(ActionEvent actionEvent){
        // this.Find_inputTextPort.setText("Office ID");
        this.Find_input_Container.setVisible(true);

        // Find Boolean Value to check what Entity user had been chosen
        this.findImage = false;
        this.findUser = false;
        this.findEmployee = false;
        this.findDepartment = false;
        this.findOffice = true;
    }

    public void Find_SubmitButton(ActionEvent actionEvent) throws SQLException {
        String primaryKey = this.Find_textField_Port.getText();
        System.out.println("Local testing on Find: "+ primaryKey);
        String SQL_FIND = "";

        if (this.findImage) {
            SQL_FIND = "SELECT * FROM image WHERE image_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND);
            preparedStatement.setString(1, primaryKey);
            ResultSet rst = preparedStatement.executeQuery();

            String result = "";

            while(rst.next()) {
                result += (rst.getString(1))
                        + ("\t"+rst.getString(2))
                        + ("\t"+rst.getString(3))
                        + ("\t"+rst.getString(4))
                        + ("\t"+rst.getInt(5))
                        + ("\t"+rst.getString(6))
                        + ("\t"+rst.getString(7))
                        + ("\t"+rst.getInt(8))
                        + ("\t"+rst.getString(9))
                        + ("\t"+rst.getString(10));
            }

            Find_TexOutput_Container_Content.setText(result);
        }

        else if (this.findUser) {
            SQL_FIND = "SELECT * FROM user_upload WHERE SSN=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND);
            preparedStatement.setString(1, primaryKey);
            ResultSet rst = preparedStatement.executeQuery();

            String result = "";

            while(rst.next()) {
                result += (rst.getString(1))
                        + ("\t"+rst.getString(2))
                        + ("\t"+rst.getInt(3))
                        + ("\t"+rst.getString(4))
                        + ("\t"+rst.getInt(5))
                        + ("\t"+rst.getInt(6));
            }

            Find_TexOutput_Container_Content.setText(result);
        }

        else if (this.findEmployee) {
            SQL_FIND = "SELECT * FROM employee WHERE SSN=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND);
            preparedStatement.setString(1, primaryKey);
            ResultSet rst = preparedStatement.executeQuery();

            String result = "";
            while(rst.next()) {
                result += (rst.getString(1))
                        + ("\t"+rst.getString(2))
                        + ("\t"+rst.getString(3))
                        + ("\t"+rst.getInt(4))
                        + ("\t"+rst.getString(5))
                        + ("\t"+rst.getString(6));
            }

            Find_TexOutput_Container_Content.setText(result);
        }

        else if (this.findDepartment) {
            SQL_FIND = "SELECT * FROM department WHERE department_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND);
            preparedStatement.setString(1, primaryKey);
            ResultSet rst = preparedStatement.executeQuery();

            String result = "";
            while(rst.next()) {
                result += (rst.getString(1))
                        + ("\t"+rst.getInt(2))
                        + ("\t"+rst.getString(3))
                        + ("\t"+rst.getString(4))
                        + ("\t"+rst.getString(5))
                        + ("\t"+rst.getString(6));
            }

            Find_TexOutput_Container_Content.setText(result);

        }

        else if (this.findOffice) {
            SQL_FIND = "SELECT * FROM app_controller_office WHERE office_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND);
            preparedStatement.setString(1, primaryKey);
            ResultSet rst = preparedStatement.executeQuery();

            String result = "";
            while(rst.next()) {
                result += (rst.getString(1))
                        + ("\t"+rst.getString(2))
                        + ("\t"+rst.getString(3))
                        + ("\t"+rst.getString(4))
                        + ("\t"+rst.getString(5));
            }

            Find_TexOutput_Container_Content.setText(result);
        }

        System.out.println("--> Done! Find Succefully");
    }


    public void Find_BackButton(ActionEvent actionEvent) throws Exception {
        // Find Boolean Value to check what Entity user had been chosen
        this.findImage = false;
        this.findUser = false;
        this.findEmployee = false;
        this.findDepartment = false;
        this.findOffice = false;

        Find_TexOutput_Container_Content.setText("");

        /** Reset Back Page to insert another entities */
        // Loading to Delete main page
        FXMLLoader backPage = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_MainInstruction.fxml"));
        Parent rootBackPage = backPage.load();  // load view into parent

        MyController findScene = backPage.getController();  //get controller created by FXMLLoader
        rootBackPage.getStylesheets().add("/styles/databaseQueries_MainInstruction.css");   //set style

        this.databaseQueries_FindPage.getScene().setRoot(rootBackPage); //update scene graph
    }

    public void Find_ResetButton(ActionEvent actionEvent) throws Exception {
        // Find Boolean Value to check what Entity user had been chosen
        this.findImage = false;
        this.findUser = false;
        this.findEmployee = false;
        this.findDepartment = false;
        this.findOffice = false;

        Find_TexOutput_Container_Content.setText("");

        /** Reset Clear Page to insert another entities */
        // Loading to Delete main page
        FXMLLoader resetPage = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_Find.fxml"));
        Parent rootResetFindPage = resetPage.load();  // load view into parent

        MyController findScene = resetPage.getController();  //get controller created by FXMLLoader
        rootResetFindPage.getStylesheets().add("/styles/databaseQueries_Find.css");   //set style

        this.databaseQueries_FindPage.getScene().setRoot(rootResetFindPage); //update scene graph
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
//        this.Update_inputTextPort.setText("Image ID:");
//        this.Update_input_Container.setVisible(true);

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
//        this.Update_inputTextPort.setText("Office ID:");
//        this.Update_input_Container.setVisible(true);

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

    public void Update_SubmitButton(ActionEvent actionEvent) throws SQLException {

        if (this.updateImage) {
            String PrimaryKey = this.Update_TextField_Image_ID.getText();
            String address = this.Update_textField_Address.getText();
            String description = Update_TextField_Description.getText();
            String type = Update_TextField_Type.getText();
            Integer status = Integer.valueOf(Update_TextField_Status.getText());
            String department = Update_TextField_Department.getText();
            String ownerText  = Update_TextField_Owner.getText();
            Integer timePosted = Integer.valueOf(Update_TextField_Time_Posted.getText());
            String officeID = Update_TextField_OfficeID.getText();
            String ownerSSN = Update_TextField_SSN.getText();

            String SQL_UPDATE = "UPDATE image SET address=?, description=?, type=?, status=?, department=?, owner=?, year_posted=?, office_ID=?, SSN=? " +
                                "WHERE image_ID=?";

            PreparedStatement prep = this.connection.prepareStatement(SQL_UPDATE);

            prep.setString(10, PrimaryKey); // Condition to match the primary key
            prep.setString(1, address);
            prep.setString(2, description);
            prep.setString(3, type);
            prep.setInt(4, status);
            prep.setString(5, department);
            prep.setString(6, ownerText);
            prep.setInt(7, timePosted);
            prep.setString(8, officeID);
            prep.setString(9, ownerSSN);

            int row = prep.executeUpdate();
            System.out.println("--> Done! Update Succefully");
        }

        else if (this.updateUser) {
            String SSN_PrimaryKey = Update_User_TextField_SSN.getText();
            String username = Update_textField_UserName.getText();
            Integer contact = Integer.valueOf(Update_textField_PersonalContact.getText());
            String address =  Update_TextField_User_Address.getText();
            Integer credit  = Integer.valueOf(Update_TextField_User_Credibility.getText());
            Integer dateUp  = Integer.valueOf(Update_TextField_User_DataUploaded.getText());

            String SQL_UPDATE = "UPDATE user_upload SET username=?, contact=?, address=?, credibility=?, date_uploaded=?" +
                                "WHERE SSN=?";

            PreparedStatement prep = this.connection.prepareStatement(SQL_UPDATE);

            prep.setString(6, SSN_PrimaryKey); // Condition to match the primary key
            prep.setString(1, username);
            prep.setInt(2, contact);
            prep.setString(3, address);
            prep.setInt(4, credit);
            prep.setInt(5, dateUp);

            int row = prep.executeUpdate();
            System.out.println("--> Done! Update Succefully");
        }

        else if (this.updateEmployee) {
            String SSN_PrimaryKey = Update_TextField_Empl_SSN.getText();
            String name = Update_textField_Empl_Name.getText();
            String address = Update_TextField_Empl_Address.getText();
            Integer contact = Integer.valueOf(Update_TextField_Empl_Contact.getText());
            String position = Update_TextField_Empl_Position.getText();
            String roomAssigned = Update_TextField_Empl_RoomAssigned.getText();

            String SQL_UPDATE = "UPDATE employee SET name=?, address=?, contact=?, position=?, room_assigned=?" +
                                "WHERE SSN=?";

            PreparedStatement prep = this.connection.prepareStatement(SQL_UPDATE);

            prep.setString(6, SSN_PrimaryKey); // Condition to match the primary key
            prep.setString(1, name);
            prep.setString(2, address);
            prep.setInt(3, contact);
            prep.setString(4, position);
            prep.setString(5, roomAssigned);

            int row = prep.executeUpdate();
            System.out.println("--> Done! Update Succefully");
        }

        else if (this.updateDepartment) {
            String departmentIDText_PrimaryKey = Update_TextField_DepartmentID.getText();
            String addressText = Update_textField_DepartmentAddress.getText();
            Integer contactText = Integer.valueOf(Update_textField_Contact.getText());
            String hoursInText = Update_TextField_Department_HoursIn.getText();
            String hoursEndText = Update_TextField_Department_HoursEnd.getText();
            String officeIDText = Update_TextField_Department_OfficeHours_OfficeID.getText();

            String SQL_UPDATE = "UPDATE department SET contact=?, address=?, office_hour_in=?, office_hour_end=?, office_ID=?" +
                                "WHERE department_ID=?";

            PreparedStatement prep = this.connection.prepareStatement(SQL_UPDATE);

            prep.setString(6, departmentIDText_PrimaryKey); // Condition to match the primary key
            prep.setString(1, addressText);
            prep.setInt(2, contactText);
            prep.setString(3, hoursInText);
            prep.setString(4, hoursEndText);
            prep.setString(5, officeIDText);

            int row = prep.executeUpdate();
            System.out.println("--> Done! Update Succefully");
        }

        else if (this.updateOffice) {
            String officeIDText = Update_TextField_Office_OfficeID.getText();
            String addressText = Update_textField_OfficeAddress.getText();
            String hoursInText = Update_TextField_Office_HoursIn.getText();
            String hoursEndText = Update_TextField_Office_HoursEnd.getText();
            String managerSSNText = Update_TextField_Office_ManagerSSN.getText();


            String SQL_UPDATE = "UPDATE app_controller_office SET address=?, office_hour_in=?, office_hour_end=?, manager_SSN=?" +
                                "WHERE office_ID=?";

            PreparedStatement prep = this.connection.prepareStatement(SQL_UPDATE);

            prep.setString(5, officeIDText);
            prep.setString(1, addressText);
            prep.setString(2, hoursInText);
            prep.setString(3, hoursEndText);
            prep.setString(4, managerSSNText);

            int row = prep.executeUpdate();    // Update back to SQL database
            System.out.println(" Successfully Adding process!!");
        }
    }

    /***************************************************************************************
     *****************
     *---------------- CONTROLLER FOR DATABASE QUERIES LIST PAGE SCENE ----------------- *
     *****************
     ***************************************************************************************/


    public void ListAll_ButtonImageBtn(ActionEvent actionEvent) throws SQLException {
        System.out.println("Clicked on ListAll Images");
        String SQL_QUERY = "SELECT * FROM image";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
        ResultSet rst = preparedStatement.executeQuery();

        String result = "";
        listAll_ResultField_TextAreaResult.clear();
        listAll_ResultField_TextAreaResult.appendText("\n\n");

        while(rst.next()) {
            result += (rst.getString(1))
                    + (";\t"+rst.getString(2))
                    + (";\t"+rst.getString(3))
                    + (";\t"+rst.getString(4))
                    + (";\t"+rst.getInt(5))
                    + (";\t"+rst.getString(6))
                    + (";\t"+rst.getString(7))
                    + (";\t"+rst.getInt(8))
                    + (";\t"+rst.getString(9))
                    + (";\t"+rst.getString(10));

            listAll_ResultField_TextAreaResult.appendText(result + "\n");
            result = "";
        }



//
//        listAll_tableViewImage.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        listAll_tableViewImage.getColumns().get(0).prefWidthProperty().bind(listAll_tableViewImage.widthProperty().multiply(0.33));    // 33% for id column size
//        listAll_tableViewImage.getColumns().get(1).prefWidthProperty().bind(listAll_tableViewImage.widthProperty().multiply(0.33));   // 33% for dt column size
//        listAll_tableViewImage.getColumns().get(2).prefWidthProperty().bind(listAll_tableViewImage.widthProperty().multiply(0.33));    // 33% for cv column size
//        listAll_tableViewImage.getItems().setAll(this.listUser);

//        TableView tableView = new TableView();
//        TableColumn<Person, String> column1 = new TableColumn<>("First Name");
//        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//
//        TableColumn<Person, String> column2 = new TableColumn<>("Last Name");
//        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
//
//        tableView.getColumns().add(column1);
//        tableView.getColumns().add(column2);
//
//        tableView.getItems().add(new Person("John", "Doe"));
//        tableView.getItems().add(new Person("Jane", "Deer"));
//
//        VBox vboxTest = new VBox(tableView);
//        this.databaseQueries_ListPage.setTopAnchor(vboxTest, 50.0);

//        Find_TexOutput_Container_Content.setText(result);
    }

    public void ListAll_ButtonUserBtn(ActionEvent actionEvent) throws SQLException {
        String SQL_QUERY = "SELECT * FROM user_upload";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
        ResultSet rst = preparedStatement.executeQuery();

        String result = "";
        listAll_ResultField_TextAreaResult.clear();
        listAll_ResultField_TextAreaResult.appendText("\n\n");

        while(rst.next()) {
            result += (rst.getString(1))
                    + (";\t"+rst.getString(2))
                    + (";\t"+rst.getInt(3))
                    + (";\t"+rst.getString(4))
                    + (";\t"+rst.getInt(5))
                    + (";\t"+rst.getInt(6));

            listAll_ResultField_TextAreaResult.appendText(result + "\n");
            result = "";
        }
    }

    public void ListAll_ButtonEmployeeBtn(ActionEvent actionEvent) throws SQLException {
        String SQL_QUERY = "SELECT * FROM employee";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
        ResultSet rst = preparedStatement.executeQuery();

        String result = "";
        listAll_ResultField_TextAreaResult.clear();
        listAll_ResultField_TextAreaResult.appendText("\n\n");

        while(rst.next()) {
            result += (rst.getString(1))
                    + (";\t"+rst.getString(2))
                    + (";\t"+rst.getString(3))
                    + (";\t"+rst.getInt(4))
                    + (";\t"+rst.getString(5))
                    + (";\t"+rst.getString(6));

            listAll_ResultField_TextAreaResult.appendText(result + "\n");
            result = "";
        }
    }

    public void ListAll_ButtonDepartmentBtn(ActionEvent actionEvent) throws SQLException {
        String SQL_QUERY = "SELECT * FROM department";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
        ResultSet rst = preparedStatement.executeQuery();

        String result = "";
        listAll_ResultField_TextAreaResult.clear();
        listAll_ResultField_TextAreaResult.appendText("\n\n");

        while(rst.next()) {
            result += (rst.getString(1))
                    + (";\t"+rst.getInt(2))
                    + (";\t"+rst.getString(3))
                    + (";\t"+rst.getString(4))
                    + (";\t"+rst.getString(5))
                    + (";\t"+rst.getString(6));

            listAll_ResultField_TextAreaResult.appendText(result + "\n");
            result = "";
        }
    }

    public void ListAll_ButtonOfficeBtn(ActionEvent actionEvent) throws SQLException {
        String SQL_QUERY = "SELECT * FROM app_controller_office";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
        ResultSet rst = preparedStatement.executeQuery();

        String result = "";
        listAll_ResultField_TextAreaResult.clear();
        listAll_ResultField_TextAreaResult.appendText("\n\n");

        while(rst.next()) {
            result += (rst.getString(1))
                    + (";\t"+rst.getString(2))
                    + (";\t"+rst.getString(3))
                    + (";\t"+rst.getString(4))
                    + (";\t"+rst.getString(5));

            listAll_ResultField_TextAreaResult.appendText(result + "\n");
            result = "";
        }
    }







    /***************************************************************************************
     *****************
     *---------------- CONTROLLER FOR DATABASE QUERIES STAT PAGE SCENE ----------------- *
     *****************
     ***************************************************************************************/

    public void Stat_Button1(ActionEvent actionEvent) throws SQLException {
        this.Stat_Query.setVisible(true);
        this.Stat_Query.setText("Find the user_SSN who posted latest year image into database");

        String SQL_QUERY =
                "SELECT user_upload.SSN, user_upload.username \n" +
                "FROM user_upload JOIN\n" +
                "(\n" +
                "\tSELECT user_upload.SSN, max(image.year_posted) AS latest_year\n" +
                "\tfrom user_upload JOIN image ON user_upload.SSN = image.SSN \n" +
                ") T\n" +
                "WHERE T.SSN = user_upload.SSN";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
        ResultSet rst = preparedStatement.executeQuery();

        Stat_QueryResult.clear();
        Stat_QueryResult.appendText("\n\n");
        String result = "";

        while(rst.next()) {
            result += (rst.getString(1))
                    + (";\t" + rst.getString(2));

            Stat_QueryResult.appendText(result + "\n");
            result = "";
        }
    }

    public void Stat_Button2(ActionEvent actionEvent) throws SQLException {
        this.Stat_Query.setVisible(true);
        this.Stat_Query.setText("Find the user_SSN who posted oldest year image into database");

        String SQL_QUERY =
                "SELECT user_upload.SSN, user_upload.username \n" +
                "FROM user_upload JOIN\n" +
                "(\n" +
                "\tSELECT user_upload.SSN, min(image.year_posted) AS latest_year\n" +
                "\tfrom user_upload JOIN image ON user_upload.SSN = image.SSN \n" +
                ") T\n" +
                "WHERE T.SSN = user_upload.SSN";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
        ResultSet rst = preparedStatement.executeQuery();

        Stat_QueryResult.clear();
        Stat_QueryResult.appendText("\n\n");
        String result = "";

        while(rst.next()) {
            result += (rst.getString(1))
                    + (";\t" + rst.getString(2));

            Stat_QueryResult.appendText(result + "\n");
            result = "";
        }
    }

    public void Stat_Button3(ActionEvent actionEvent) throws SQLException {
        this.Stat_Query.setVisible(true);
        this.Stat_Query.setText("Funny Fact: Find the employee who has the longest job title");

        String SQL_QUERY =
                "SELECT name, position \n" +
                "FROM employee \n" +
                "WHERE length(employee.position) = (\n" +
                    "\tSELECT max(length(position)) FROM employee\n" +
                ")\t";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
        ResultSet rst = preparedStatement.executeQuery();

        Stat_QueryResult.clear();
        Stat_QueryResult.appendText("\n\n");
        String result = "";

        while(rst.next()) {
            result += ("Employname: " + rst.getString(1))
                    + (";\tSSN: " + rst.getString(2));

            Stat_QueryResult.appendText(result + "\n");
            result = "";
        }
    }

    public void Stat_Button4(ActionEvent actionEvent) throws SQLException {
        this.Stat_Query.setVisible(true);
        this.Stat_Query.setText("Retrieves all images that uploaded by the person (people) got highest credit score");

        /* Query on Workbench
            SELECT image_ID, address, description FROM (
                SELECT user_upload.username, user_upload.SSN
                FROM user_upload
                WHERE user_upload.credibility = (
                    SELECT max(credibility)
                    AS Most_Credibility
                    FROM user_upload
                )
            ) T JOIN image WHERE image.SSN = T.SSN
         */

        String SQL_QUERY =
                "SELECT image_ID, address, description FROM (\n" +
                "\tSELECT user_upload.username, user_upload.SSN\n" +
                "\tFROM user_upload \n" +
                "\tWHERE user_upload.credibility = (\n" +
                    "\t\tSELECT max(credibility) \n" +
                    "\t\tAS Most_Credibility\n" +
                "\t\tFROM user_upload\n" +
                "\t)\n" +
                ") T JOIN image WHERE image.SSN = T.SSN";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
        ResultSet rst = preparedStatement.executeQuery();

        Stat_QueryResult.clear();
        Stat_QueryResult.appendText("\n\n");
        String result = "";

        while(rst.next()) {
            result += ("Image ID: " + rst.getString(1))
                    + (";\t\tTaken at: " + rst.getString(2))
                    + (";\t\tDescription: " + rst.getString(3));

            Stat_QueryResult.appendText(result + "\n");
            result = "";
        }
    }

    public void Stat_BackButton(ActionEvent actionEvent) throws Exception {
        /** Back Page to insert another entities */
        // Loading to Delete main page
        FXMLLoader resetPage = new FXMLLoader(getClass().getResource("/FXML/databaseQueries_MainInstruction.fxml"));
        Parent rootResetPage = resetPage.load();  // load view into parent

        MyController updateScene = resetPage.getController();  //get controller created by FXMLLoader
        rootResetPage.getStylesheets().add("/styles/databaseQueries_MainInstruction.css");   //set style

        this.databaseQueries_StatisticPage.getScene().setRoot(rootResetPage); //update scene graph
    }
}



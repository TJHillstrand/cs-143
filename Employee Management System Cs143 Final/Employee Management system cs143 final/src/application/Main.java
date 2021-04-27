package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


//1. add employee
//2. edit/modify employee
//3. Remove employee
//4. Display All employees
//5. Display individual employee 
//6. Display Organization list of employees
//7. Exit
public class Main extends Application {

private ArrayList <Employee> employees = new ArrayList<>();
private ArrayList <Employee> orgEmps = new ArrayList<>(); //ArrayList for Employees of a special org
private Scene scene1; //Home Page
private Scene scene2; //Add the Employee
private Scene scene3; //Edit/Modify a specfiic employee
private Scene sceneEdit; //Scene to edit the information from Above
private Scene scene4; //Remove an Employee (By Name, first / Last)
private Scene sceneRemove2; //Scene where we say if employee has been removed or not
private Scene scene5; //Display ALL Employees
private Scene sceneView2; //Scene where we say if employee has been removed or not
private Scene scene6; //Display an Individual Employee
private Scene scene7; //Display all Employees Under an Organization
private Scene scene72; //Scene where the employees are displayed, allows user to scroll through them all


private int empCount = 0;
private Text firstNameDisplay = new Text("");
private Text lastNameDisplay = new Text("");
private Text genderDisplay = new Text("");
private Text jobTitleDisplay = new Text("");
private Text birthdayDisplay = new Text("");
private Text organizationDisplay = new Text("");
private Text empIDDisplay = new Text("");
private Label saysNoEmps = new Label("");
private Employee searched = null;
private int editStored = 0;
private GridPane editgrid;
private TextField editName = new TextField();
private TextField editlastName = new TextField();
private TextField editgender = new TextField();
private TextField editjobTitle = new TextField();
private TextField editbirthday = new TextField();
private TextField editorganization = new TextField();
private Label error = new Label("");
private GridPane removegrid;
private boolean removed = false;
private int removeNum;
private Text empRemoved = new Text("");
private Text firstNameView = new Text("");
private Text lastNameView = new Text("");
private Text genderView = new Text("");
private Text jobTitleView = new Text("");
private Text birthdayView = new Text("");
private Text organizationView = new Text("");
private Text empIDView = new Text("");
private Text empViewError = new Text("");
private GridPane viewgrid;
private int orgEmpCount = 0;
private Text firstNameDisplay72 = new Text("");
private Text lastNameDisplay72 = new Text("");
private Text genderDisplay72 = new Text("");
private Text jobTitleDisplay72 = new Text("");
private Text birthdayDisplay72 = new Text("");
private Text organizationDisplay72 = new Text("");
private Text empIDDisplay72 = new Text("");
private Label saysNoEmps72 = new Label("");

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Employee Manager");
            
			
			// Set up Scene 1 (main menu) 
			Text caption1 = new Text("Employee Management System");
			    caption1.setFill(Color.PURPLE);
			    caption1.setStyle("-fx-font: 30 arial;");
			caption1.setTranslateX(200);
			Text caption2 = new Text("---Main Menu---");
		    caption2.setFill(Color.PURPLE);
		    caption2.setStyle("-fx-font: 30 arial;");
		    caption2.setTranslateX(300);
//		    Text caption3 = new Text("1:) Add Employee\n2:) Edit/Modify Employee\n3:) Remove Employee\n"
//		    		+ "4:) View All Employees In System\n5:) View Individual Employee\n"
//		    		+ "6:) Display Organization Specific Employees\n7:) EXIT ");
//		    caption3.setFill(Color.PURPLE);
//		    caption3.setStyle("-fx-font: 20 arial;");
//		    caption3.setTranslateX(160);
		    
            Button button1 = new Button("1:) Add Employee");
            button1.setTranslateX(50);
            button1.setTranslateY(50);
            button1.setOnAction(e -> primaryStage.setScene(scene2));
            
            Button button2 = new Button("2:) Edit/Modify Employee");
            button2.setTranslateX(50);
            button2.setTranslateY(50);
            button2.setOnAction(e -> primaryStage.setScene(scene3));
            
            Button button3 = new Button("3:) Remove Employee");
            button3.setTranslateX(50);
            button3.setTranslateY(50);
            button3.setOnAction(e -> primaryStage.setScene(scene4));
            
            Button button4 = new Button("4:) View All Employees In System");
            button4.setTranslateX(50);
            button4.setTranslateY(50);
            button4.setOnAction(new EventHandler<ActionEvent>() {
        		@Override
        	    public void handle(ActionEvent e) {
        		//Display all the names when the action is called
        		//Define Text
        			
                   if(employees.size() != 0) {
                    	firstNameDisplay.setText("First Name: " + employees.get(empCount).getEmpFirstName());
                        lastNameDisplay.setText("Last Name: " + employees.get(empCount).getEmpLastName());
                        genderDisplay.setText("Gender: " + employees.get(empCount).getEmpGender());
                        jobTitleDisplay.setText("Job Title: " + employees.get(empCount).getEmpTitle());
                        birthdayDisplay.setText("Birthday: " + employees.get(empCount).getEmpBirthday());
                        organizationDisplay.setText("Organization: " + employees.get(empCount).getEmpOrg());
                        empIDDisplay.setText("Employee ID: " + employees.get(empCount).getEmpID());
                        saysNoEmps.setText("");
                    }
                   else {
                	   saysNoEmps.setText("There are No Employees Added");
                	   saysNoEmps.setTranslateX(300);
                	   saysNoEmps.setTranslateY(-200);
                	   firstNameDisplay.setText("");
                       lastNameDisplay.setText("");
                       genderDisplay.setText("");
                       jobTitleDisplay.setText("");
                       birthdayDisplay.setText("");
                       organizationDisplay.setText("");
                       empIDDisplay.setText("");
                   }
                   primaryStage.setScene(scene5);
        	    }
        	});
            
            Button button5 = new Button("5:) View Individual Employee");
            button5.setTranslateX(50);
            button5.setTranslateY(50);
            button5.setOnAction(e -> primaryStage.setScene(scene6));
            
            Button button6 = new Button("6:) Display Organization Specific Employees");
            button6.setTranslateX(50);
            button6.setTranslateY(50);
            button6.setOnAction(e -> primaryStage.setScene(scene7));
            
            Button button7 = new Button("7:) EXIT"); //BUTTON FOR CLOSING THE PROGRAM
            button7.setTranslateX(50);
            button7.setTranslateY(50);
            button7.setOnAction(e -> Platform.exit());
           
            VBox layout1 = new VBox(20);
            HBox hb = new HBox();
            hb.setSpacing(10);
            layout1.getChildren().addAll(caption1, caption2, button1, button2, button3, button4, button5, button6, button7);
            scene1 = new Scene(layout1, 800, 600);
            scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene1);
            primaryStage.show();
            
            
            
            // Set up Scene 2 (Add Employee)    
            //Creating a GridPane container
            String first;
            String last; 
            String empGender;
            String empJobTitle;
            String empBirthday;
            String empOrg;
            
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(10, 10, 10, 10));
            grid.setVgap(5);
            grid.setHgap(5);
            //Defining the Name text field
            final TextField name = new TextField();
            name.setPromptText("Enter first name.");
            name.setPrefColumnCount(10);
            name.getText();
            GridPane.setConstraints(name, 0, 0);
            grid.getChildren().add(name);
            //Defining the Last Name text field
            final TextField lastName = new TextField();
            lastName.setPromptText("Enter last name.");
            GridPane.setConstraints(lastName, 0, 1);
            grid.getChildren().add(lastName);
            //Defining the Gender text field
            final TextField gender = new TextField();
            gender.setPrefColumnCount(15);
            gender.setPromptText("Enter gender.");
            GridPane.setConstraints(gender, 0, 2);
            grid.getChildren().add(gender);
            //Defining the Job Title text field
            final TextField jobTitle = new TextField();
            jobTitle.setPrefColumnCount(20);
            jobTitle.setPromptText("Enter job title.");
            GridPane.setConstraints(jobTitle, 0, 3);
            grid.getChildren().add(jobTitle);
            //Defining the Birthday text field
            final TextField birthday = new TextField();
            birthday.setPrefColumnCount(20);
            birthday.setPromptText("Enter birthday. Use 00/00/00 format!!");
            GridPane.setConstraints(birthday, 0, 4);
            grid.getChildren().add(birthday);
            //Defining the Organization text field
            final TextField organization = new TextField();
            organization.setPrefColumnCount(20);
            organization.setPromptText("Enter the Organization");
            GridPane.setConstraints(organization, 0, 5);
            grid.getChildren().add(organization);
            //Defining the Submit button
            Button submit = new Button("Submit");
            GridPane.setConstraints(submit, 1, 0);
            grid.getChildren().add(submit);
            //Defining the Clear button
            Button clear = new Button("Clear");
            GridPane.setConstraints(clear, 1, 1);
            grid.getChildren().add(clear);
            //Defining the Clear Button
            clear.setOnAction(new EventHandler<ActionEvent>() {
            	@Override
            	    public void handle(ActionEvent e) {
            	        name.clear();
            	        lastName.clear();
            	        gender.clear();
            	        jobTitle.clear();
            	        birthday.clear();
            	        organization.clear();
            	    }
            	});
            //Adding a Label
            Label label = new Label();
            label.setTranslateX(20);
            label.setTranslateY(90);
            GridPane.setConstraints(label, 0, 3);
            GridPane.setColumnSpan(label, 2);
            grid.getChildren().add(label);
            //Setting an action for the Submit button
            submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
                public void handle(ActionEvent e) {
                    if ((name.getText() != null && !name.getText().isEmpty()) && 
                    	(lastName.getText() != null && !lastName.getText().isEmpty()) && 
                    	(gender.getText() != null && !gender.getText().isEmpty()) && 
                    	(jobTitle.getText() != null && !jobTitle.getText().isEmpty()) && 
                    	(birthday.getText() != null && !birthday.getText().isEmpty()) && 
                    	(organization.getText() != null && !organization.getText().isEmpty())) {
                        
                        String first = name.getText();
                        String last = lastName.getText();
                        String empGender = gender.getText();
                        String empJobTitle = jobTitle.getText();
                        String empBirthday = birthday.getText();
                        String empOrganization = organization.getText();
                        employees.add(new Employee(first, last, empGender, empJobTitle, empBirthday, empOrganization));
                        //Clear the fields for the next time
                        name.clear();
            	        lastName.clear();
            	        gender.clear();
            	        jobTitle.clear();
            	        birthday.clear();
            	        organization.clear();
                        primaryStage.setScene(scene1);
                    } 
                    
                    else {
                        label.setText("Please fill in all the fields");
                    }
                 }
             });
            Text caption3 = new Text("Please Input New Employee data!");
		    caption3.setFill(Color.PURPLE);
		    caption3.setStyle("-fx-font: 30 arial;");
		    caption3.setTranslateX(150);
            Button buttonMain= new Button("Main Menu");
            // move button 50 right 
            buttonMain.setTranslateX(500);
            // move button 50 down
            buttonMain.setTranslateY(320);
            buttonMain.setOnAction(e -> primaryStage.setScene(scene1));
            VBox layout2 = new VBox(20);
            layout2.setStyle("-fx-background: #DFFDFF;");
            layout2.getChildren().addAll(caption3, buttonMain, grid);
            scene2 = new Scene(layout2, 800, 600);
            scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene1);
            primaryStage.show();
            
            
            
            
            
            
            // Set up Scene 3 (Edit / Modify a specific employee)
            GridPane editGrid = new GridPane();
            editGrid.setPadding(new Insets(10, 10, 10, 10));
            editGrid.setVgap(5);
            editGrid.setHgap(5);
            editGrid.setTranslateX(275);
            editGrid.setTranslateY(100);
            Text label3 = new Text("Employee Management System");
            label3.setTranslateX(200);
            label3.setFill(Color.PURPLE);
		    label3.setStyle("-fx-font: 30 arial;");
		    
		    //Adding a Label for when an error is made
            Label labelCheckForInfo = new Label();
            labelCheckForInfo.setTranslateX(20);
            GridPane.setConstraints(labelCheckForInfo, 0, 3);
            GridPane.setColumnSpan(labelCheckForInfo, 2);
            editGrid.getChildren().add(labelCheckForInfo);
            
            //Need to redo main menu button for each class
            Button buttonMain3 = new Button("Main Menu");
            // move button 50 right 
            buttonMain3.setTranslateX(350);
            // move button 50 down
            buttonMain3.setTranslateY(400);
            //Defining the Name text field
            TextField editFirstName = new TextField();
            editFirstName.setPromptText("Enter first name.");
            editFirstName.setPrefColumnCount(10);
            editFirstName.getText();
            GridPane.setConstraints(editFirstName, 0, 0);
            editGrid.getChildren().add(editFirstName);
            //Defining the Last Name text field
            TextField editLastName = new TextField();
            editLastName.setPromptText("Enter last name.");
            GridPane.setConstraints(editLastName, 0, 1);
            editGrid.getChildren().add(editLastName);
            //Defining the Submit button
            Button editSubmit = new Button("Submit");
            buttonMain3.setOnAction(new EventHandler<ActionEvent>() {
            	@Override
        	    public void handle(ActionEvent e) {
        	        primaryStage.setScene(scene1);
        	        editFirstName.clear();
                    editLastName.clear();
        	    }
        	});
            GridPane.setConstraints(editSubmit, 1, 0);
            editGrid.getChildren().add(editSubmit);
            
            //Defining the Clear Button for the edit
            editSubmit.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                    public void handle(ActionEvent e) {
                	searched = null;
                        if ((editFirstName.getText() != null && !editFirstName.getText().isEmpty()) && 
                        	(editLastName.getText() != null && !editLastName.getText().isEmpty())) {
                            
                            String first = editFirstName.getText();
                            String last = editLastName.getText();
                            for(int i = 0; i < employees.size(); i++) {
                            	//Checks for first and last name in Employees. Also Ignores case
                            	if(employees.get(i).getEmpFirstName().equalsIgnoreCase(first) && employees.get(i).getEmpLastName().equalsIgnoreCase(last)) {
                            		editStored = i;
                            		searched = employees.get(i);
                            		break;
                            	}
                            }
                            editgrid.getChildren().clear();
                            //If search doesn't find anything
                            if(searched == null) {
                            	error = new Label("We could not find the Employee you searched for");
                            	editgrid.getChildren().add(error);
                            }
                            else {
                                //Defining the Name text field
                                editName.setPromptText("Enter new first name.");
                                editName.setPrefColumnCount(10);
                                editName.setText(searched.getEmpFirstName());
                                GridPane.setConstraints(editName, 0, 0);
                                editgrid.getChildren().add(editName);
                                //Defining the Last Name text field
                                editlastName.setPromptText("Enter new last name.");
                                editlastName.setText(searched.getEmpLastName());
                                GridPane.setConstraints(editlastName, 0, 1);
                                editgrid.getChildren().add(editlastName);
                                //Defining the Gender text field
                                editgender.setPrefColumnCount(15);
                                editgender.setPromptText("Enter gender.");
                                editgender.setText(searched.getEmpGender());
                                GridPane.setConstraints(editgender, 0, 2);
                                editgrid.getChildren().add(editgender);
                                //Defining the Job Title text field
                                editjobTitle.setPrefColumnCount(20);
                                editjobTitle.setPromptText("Enter job title.");
                                editjobTitle.setText(searched.getEmpTitle());
                                GridPane.setConstraints(editjobTitle, 0, 3);
                                editgrid.getChildren().add(editjobTitle);
                                //Defining the Birthday text field
                                editbirthday.setPrefColumnCount(20);
                                editbirthday.setPromptText("Enter birthday. Use 00/00/00 format!!");
                                editbirthday.setText(searched.getEmpBirthday());
                                GridPane.setConstraints(editbirthday, 0, 4);
                                editgrid.getChildren().add(editbirthday);
                                //Defining the Organization text field
                                editorganization.setPrefColumnCount(20);
                                editorganization.setPromptText("Enter the Organization");
                                editorganization.setText(searched.getEmpOrg());
                                GridPane.setConstraints(editorganization, 0, 5);
                                editgrid.getChildren().add(editorganization);
                                //Defining the Submit button
                                Button editsubmit = new Button("Submit");
                                GridPane.setConstraints(editsubmit, 1, 0);
                                editgrid.getChildren().add(editsubmit);
                                //Defining the Submit button for edit
                                editsubmit.setOnAction(new EventHandler<ActionEvent>() {
                                	@Override
                                	    public void handle(ActionEvent e) {
                                	        employees.get(editStored).setEmpFirstName(editName.getText());
                                	        employees.get(editStored).setEmpLastName(editlastName.getText());
                                	        employees.get(editStored).setEmpGender(editgender.getText());
                                	        employees.get(editStored).setEmpBirthday(editbirthday.getText());
                                	        employees.get(editStored).setEmpOrg(editorganization.getText());
                                	        primaryStage.setScene(scene1);
                                	    }
                                	});
                                
                                
                                //Defining the Clear button
                                Button editedclear = new Button("Clear");
                                GridPane.setConstraints(editedclear, 1, 1);
                                editgrid.getChildren().add(editedclear);
                                //Defining the Clear Button for the edit
                                editedclear.setOnAction(new EventHandler<ActionEvent>() {
                                	@Override
                                	    public void handle(ActionEvent e) {
                                	        editName.clear();
                                	        editlastName.clear();
                                	        editgender.clear();
                                	        editjobTitle.clear();
                                	        editbirthday.clear();
                                	        editorganization.clear();
                                	    }
                                	});
                            }
                            
                            //Take us to a new Scene where we can properly either showcase the employee's edits or
                            //State there was an error
                            primaryStage.setScene(sceneEdit);
                            editFirstName.clear();
                            editLastName.clear();
                            
                        }
                        
                        else {
                        	labelCheckForInfo.setText("Please fill in all the fields");
                        }
                     }
                 });
            //Defining the Clear button
            Button editClear = new Button("Clear");
            GridPane.setConstraints(editClear, 1, 1);
            editGrid.getChildren().add(editClear);
            //Defining the Clear Button for the edit
            editClear.setOnAction(new EventHandler<ActionEvent>() {
            	@Override
            	    public void handle(ActionEvent e) {
            	        editFirstName.clear();
            	        editLastName.clear();
            	    }
            	});
            VBox layout3 = new VBox(20);
            layout3.getChildren().addAll(label3, buttonMain3, editGrid);
            scene3 = new Scene(layout3, 800, 600);
            scene3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            
            
            
            
            //Scene edit, AKA Scene 3 sends you here which is where you update it            
            Text labelEdit = new Text("Employee Management System");
            labelEdit.setTranslateX(200);
            labelEdit.setFill(Color.PURPLE);
		    labelEdit.setStyle("-fx-font: 30 arial;");
            labelEdit.setTranslateX(200);
            //Need to redo main menu button for each class
            Button buttonMainError = new Button("Main Menu");
            // move button 50 right 
            buttonMainError.setTranslateX(350);
            // move button 50 down
            buttonMainError.setTranslateY(400);
            buttonMainError.setOnAction(e -> primaryStage.setScene(scene1));
            editgrid = new GridPane();
            editgrid.setPadding(new Insets(10, 10, 10, 10));
            editgrid.setVgap(5);
            editgrid.setHgap(5);
            editgrid.setTranslateX(200);
            editgrid = new GridPane();
            editgrid.setPadding(new Insets(10, 10, 10, 10));
            editgrid.setVgap(5);
            editgrid.setHgap(5);
            editgrid.setTranslateX(200);
            VBox layoutEdit = new VBox(20);
            layoutEdit.getChildren().addAll(labelEdit, buttonMainError, editgrid);
            sceneEdit = new Scene(layoutEdit, 800, 600);  
            sceneEdit.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            
            
            
            
            
         
            // Set up Scene 4 (Remove an Employee)
            GridPane grid4 = new GridPane();
            grid4.setPadding(new Insets(10, 10, 10, 10));
            grid4.setVgap(5);
            grid4.setHgap(5);
            grid4.setTranslateX(275);
            grid4.setTranslateY(100);
            Text label4 = new Text("Employee Management System");
            label4.setTranslateX(200);
            label4.setFill(Color.PURPLE);
		    label4.setStyle("-fx-font: 30 arial;");
		    //Adding a Label for when an error is made
            Label labelCheckForInfo4 = new Label();
            labelCheckForInfo4.setTranslateX(20);
            GridPane.setConstraints(labelCheckForInfo4, 0, 3);
            GridPane.setColumnSpan(labelCheckForInfo4, 2);
            grid4.getChildren().add(labelCheckForInfo4);
            //Need to redo main menu button for each class
            Button buttonMain4 = new Button("Main Menu");
            // move button 50 right 
            buttonMain4.setTranslateX(350);
            // move button 50 down
            buttonMain4.setTranslateY(400);
            //Defining the Name text field
            TextField enterFirst = new TextField();
            enterFirst.setPromptText("Enter first name.");
            enterFirst.setPrefColumnCount(10);
            enterFirst.getText();
            GridPane.setConstraints(enterFirst, 0, 0);
            grid4.getChildren().add(enterFirst);
            //Defining the Last Name text field
            TextField enterLast = new TextField();
            enterLast.setPromptText("Enter last name.");
            GridPane.setConstraints(enterLast, 0, 1);
            grid4.getChildren().add(enterLast);
            //Defining the Submit button
            Button submitRemove = new Button("Remove");
            buttonMain4.setOnAction(new EventHandler<ActionEvent>() {
            	@Override
        	    public void handle(ActionEvent e) {
        	        primaryStage.setScene(scene1);
        	        enterFirst.clear();
                    enterLast.clear();
        	    }
        	});
            GridPane.setConstraints(submitRemove, 1, 0);
            grid4.getChildren().add(submitRemove);
          //Defining the Clear button
            Button clearRemove = new Button("Clear");
            GridPane.setConstraints(clearRemove, 1, 1);
            grid4.getChildren().add(clearRemove);
            //Defining the Clear Button for the edit
            clearRemove.setOnAction(new EventHandler<ActionEvent>() {
            	@Override
            	    public void handle(ActionEvent e) {
            	        enterFirst.clear();
            	        enterLast.clear();
            	    }
            	});
            //Defining the Remove Button for the edit
            submitRemove.setOnAction(new EventHandler<ActionEvent>() {
            	@Override
            	    public void handle(ActionEvent e) {
            		removed = false;
            	       if ((enterFirst.getText() != null && !enterFirst.getText().isEmpty()) && 
                           	(enterLast.getText() != null && !enterLast.getText().isEmpty())) {
                               
                               String first = enterFirst.getText();
                               String last = enterLast.getText();
                               for(int i = 0; i < employees.size(); i++) {
                               	//Checks for first and last name in Employees. Also Ignores case
                               	if(employees.get(i).getEmpFirstName().equalsIgnoreCase(first) && employees.get(i).getEmpLastName().equalsIgnoreCase(last)) {
                               		removed = true;
                               		employees.remove(i);
                               		break;
                               	}
                           }
                               if(removed) {
                            	   empRemoved.setText("Employee Sucessfully Removed");
                               }
                               else {
                            	   empRemoved.setText("We could not find the Employee you wanted to remove");
                               }
                               primaryStage.setScene(sceneRemove2);
                               
            	    }
            	       else {
                           label.setText("Please fill in all the fields");
                       }
            	}});
            VBox layout4 = new VBox(20);
            layout4.getChildren().addAll(label4, buttonMain4, grid4);
            scene4 = new Scene(layout4, 800, 600);
            scene4.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            
            
            //Scene 4 part 2. Says if Employee was removed or not         
            Text labelRemove2 = new Text("Employee Management System");
            labelRemove2.setTranslateX(200);
            labelRemove2.setFill(Color.PURPLE);
		    labelRemove2.setStyle("-fx-font: 30 arial;");
            labelRemove2.setTranslateX(200);
            //Need to redo main menu button for each class
            Button buttonMainRemove2 = new Button("Main Menu");
            // move button 50 right 
            buttonMainRemove2.setTranslateX(350);
            // move button 50 down
            buttonMainRemove2.setTranslateY(400);
            buttonMainRemove2.setOnAction(e -> primaryStage.setScene(scene1));
            removegrid = new GridPane();
            removegrid.setPadding(new Insets(10, 10, 10, 10));
            removegrid.setVgap(5);
            removegrid.setHgap(5);
            removegrid.setTranslateX(200);
            removegrid = new GridPane();
            removegrid.setPadding(new Insets(10, 10, 10, 10));
            removegrid.setVgap(5);
            removegrid.setHgap(5);
            removegrid.setTranslateX(200);
            removegrid.getChildren().add(empRemoved);
            VBox layoutRemove2 = new VBox(20);
            layoutRemove2.getChildren().addAll(labelRemove2, buttonMainRemove2, removegrid);
            sceneRemove2 = new Scene(layoutRemove2, 800, 600);  
            sceneRemove2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            
            
            
            
            
            
            // Set up Scene 5 (View all Employees)
            Label label5 = new Label("Employee Management System");
            label5.setTranslateX(300);
            Label totalEmps = new Label("Number of Employees: " + empCount);
            totalEmps.setTranslateX(300);
            totalEmps.setTranslateY(-200);
            //Need to redo main menu button for each class
            Button buttonMain5 = new Button("Main Menu");
            // move button 50 right 
            buttonMain5.setTranslateX(350);
            // move button 50 down
            buttonMain5.setTranslateY(400);
            buttonMain5.setOnAction(e -> primaryStage.setScene(scene1));
            Button nextEmployee = new Button("Next Employee");
            Button prevEmployee = new Button("Previous Employee");
            nextEmployee.setTranslateX(600);
            nextEmployee.setTranslateY(320);
            prevEmployee.setTranslateX(100);
            prevEmployee.setTranslateY(275);
            
            firstNameDisplay.setTranslateX(250);
            firstNameDisplay.setTranslateY(-100);
            lastNameDisplay.setTranslateX(250);
            lastNameDisplay.setTranslateY(-100);
            genderDisplay.setTranslateX(250);
            genderDisplay.setTranslateY(-100);
            jobTitleDisplay.setTranslateX(250);
            jobTitleDisplay.setTranslateY(-100);
            birthdayDisplay.setTranslateX(250);
            birthdayDisplay.setTranslateY(-100);
            organizationDisplay.setTranslateX(250);
            organizationDisplay.setTranslateY(-100);
            empIDDisplay.setTranslateX(250);
            empIDDisplay.setTranslateY(-100);
            
            
            prevEmployee.setOnAction(new EventHandler<ActionEvent>() {
            		@Override
            	    public void handle(ActionEvent e) {
            		//Don't go past 0 because of out of bounds error exception
            	        if(empCount > 0) {
            	        	empCount --;
            	        	firstNameDisplay.setText("First Name: " + employees.get(empCount).getEmpFirstName());
            	        	lastNameDisplay.setText("Last Name: " + employees.get(empCount).getEmpLastName());
            	        	genderDisplay.setText("Gender: " + employees.get(empCount).getEmpGender());
                            jobTitleDisplay.setText("Job Title: " + employees.get(empCount).getEmpTitle());
                            birthdayDisplay.setText("Birthday: " + employees.get(empCount).getEmpBirthday());
                            organizationDisplay.setText("Organization: " + employees.get(empCount).getEmpOrg());
                            empIDDisplay.setText("Employee ID: " + employees.get(empCount).getEmpID());
            	        }
            	    }
            	});
            
            nextEmployee.setOnAction(new EventHandler<ActionEvent>() {
            		@Override
            	    public void handle(ActionEvent e) {
            		//Don't go past Max because of out of bounds error exception
            	        if(empCount < employees.size() -1 ) {
            	        	empCount ++;
            	        	firstNameDisplay.setText("First Name: " + employees.get(empCount).getEmpFirstName());
            	        	lastNameDisplay.setText("Last Name: " + employees.get(empCount).getEmpLastName());
            	        	genderDisplay.setText("Gender: " + employees.get(empCount).getEmpGender());
                            jobTitleDisplay.setText("Job Title: " + employees.get(empCount).getEmpTitle());
                            birthdayDisplay.setText("Birthday: " + employees.get(empCount).getEmpBirthday());
                            organizationDisplay.setText("Organization: " + employees.get(empCount).getEmpOrg());
                            empIDDisplay.setText("Employee ID: " + employees.get(empCount).getEmpID());
            	        }
            	    }
            	});

            VBox layout5 = new VBox(20);
            layout5.getChildren().addAll(label5, buttonMain5, nextEmployee, prevEmployee, firstNameDisplay, lastNameDisplay, 
            genderDisplay, jobTitleDisplay, birthdayDisplay, organizationDisplay, empIDDisplay, saysNoEmps);
            scene5 = new Scene(layout5, 800, 600);
            scene5.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            
            
            
            
            
         // Set up Scene 6 (Display an Individual Employee)
            GridPane grid6 = new GridPane();
            grid6.setPadding(new Insets(10, 10, 10, 10));
            grid6.setVgap(5);
            grid6.setHgap(5);
            grid6.setTranslateX(275);
            grid6.setTranslateY(100);
            Text label6 = new Text("Employee Management System");
            label6.setTranslateX(200);
            label6.setFill(Color.PURPLE);
		    label6.setStyle("-fx-font: 30 arial;");
		    //Adding a Label for when an error is made
            Label labelCheckForInfo6 = new Label();
            labelCheckForInfo6.setTranslateX(20);
            GridPane.setConstraints(labelCheckForInfo6, 0, 3);
            GridPane.setColumnSpan(labelCheckForInfo6, 2);
            grid4.getChildren().add(labelCheckForInfo6);
            //Need to redo main menu button for each class
            Button buttonMain6 = new Button("Main Menu");
            // move button 50 right 
            buttonMain6.setTranslateX(350);
            // move button 50 down
            buttonMain6.setTranslateY(400);
            //Defining the Name text field
            TextField enterFirst6 = new TextField();
            enterFirst6.setPromptText("Enter first name.");
            enterFirst6.setPrefColumnCount(10);
            enterFirst6.getText();
            GridPane.setConstraints(enterFirst6, 0, 0);
            grid6.getChildren().add(enterFirst6);
            //Defining the Last Name text field
            TextField enterLast6 = new TextField();
            enterLast6.setPromptText("Enter last name.");
            GridPane.setConstraints(enterLast6, 0, 1);
            grid6.getChildren().add(enterLast6);
            //Defining the Submit button
            Button submitView = new Button("View");
            buttonMain6.setOnAction(new EventHandler<ActionEvent>() {
            	@Override
        	    public void handle(ActionEvent e) {
        	        primaryStage.setScene(scene1);
        	        enterFirst6.clear();
                    enterLast6.clear();
        	    }
        	});
            GridPane.setConstraints(submitView, 1, 0);
            grid6.getChildren().add(submitView);
          //Defining the Clear button
            Button clearView = new Button("Clear");
            GridPane.setConstraints(clearView, 1, 1);
            grid6.getChildren().add(clearView);
            //Defining the Clear Button for the edit
            clearView.setOnAction(new EventHandler<ActionEvent>() {
            	@Override
            	    public void handle(ActionEvent e) {
            	        enterFirst6.clear();
            	        enterLast6.clear();
            	    }
            	});
            //Defining the Remove Button for the edit
            submitView.setOnAction(new EventHandler<ActionEvent>() {
            	@Override
            	    public void handle(ActionEvent e) {
            	       if ((enterFirst6.getText() != null && !enterFirst6.getText().isEmpty()) && 
                           	(enterLast6.getText() != null && !enterLast6.getText().isEmpty())) {
                               Employee temp = null;
                               String first = enterFirst6.getText();
                               String last = enterLast6.getText();
                               for(int i = 0; i < employees.size(); i++) {
                               	//Checks for first and last name in Employees. Also Ignores case
                               	if(employees.get(i).getEmpFirstName().equalsIgnoreCase(first) && employees.get(i).getEmpLastName().equalsIgnoreCase(last)) {
                               		temp = employees.get(i);
                               		break;
                               	}
                           }
                               if(temp != null) {
                            	   firstNameView.setText("First Name: " + temp.getEmpFirstName());
                            	   lastNameView.setText("Last Name: " + temp.getEmpLastName());
                            	   genderView.setText("Gender: " + temp.getEmpGender());
                                   jobTitleView.setText("Job Title: " + temp.getEmpTitle());
                                   birthdayView.setText("Birthday: " + temp.getEmpBirthday());
                                   organizationView.setText("Organization: " + temp.getEmpOrg());
                                   empIDView.setText("Employee ID: " + temp.getEmpID());
                                   empViewError.setText("");
                               }
                               else {
                            	   empViewError.setText("We could not find employee you searched for");
                            	   firstNameView.setText("");
                            	   lastNameView.setText("");
                            	   genderView.setText("");
                                   jobTitleView.setText("");
                                   birthdayView.setText("");
                                   organizationView.setText("");
                                   empIDView.setText("");
                               }
                               primaryStage.setScene(sceneView2);
            	    }
            	       else {
                           label.setText("Please fill in all the fields");
                       }
            	}});
            VBox layout6 = new VBox(20);
            layout6.getChildren().addAll(label6, buttonMain6, grid6);
            scene6 = new Scene(layout6, 800, 600);
            scene6.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            //Scene 6 part 2. Allows us to View Employee         
            Text labelView2 = new Text("Employee Management System");
            labelView2.setTranslateX(200);
            labelView2.setFill(Color.PURPLE);
		    labelView2.setStyle("-fx-font: 30 arial;");
            labelView2.setTranslateX(200);
            //Need to redo main menu button for each class
            Button buttonMainView2 = new Button("Main Menu");
            // move button 50 right 
            buttonMainView2.setTranslateX(350);
            // move button 50 down
            buttonMainView2.setTranslateY(400);
            buttonMainView2.setOnAction(e -> primaryStage.setScene(scene1));
            firstNameView.setTranslateX(250);
            //firstNameView.setTranslateY(100);
            lastNameView.setTranslateX(250);
            //lastNameView.setTranslateY(100);
            genderView.setTranslateX(250);
            //genderView.setTranslateY(100);
            jobTitleView.setTranslateX(250);
            //jobTitleView.setTranslateY(100);
            birthdayView.setTranslateX(250);
            //birthdayView.setTranslateY(100);
            organizationView.setTranslateX(250);
            //organizationView.setTranslateY(100);
            empIDView.setTranslateX(250);
            //empIDView.setTranslateY(100);
            empViewError.setTranslateX(250);
            empViewError.setTranslateY(-100);
            VBox layoutView2 = new VBox(20);
            layoutView2.getChildren().addAll(labelView2, buttonMainView2, firstNameView, lastNameView, 
            		genderView, jobTitleView, birthdayView, organizationView, empIDView, empViewError);
            sceneView2 = new Scene(layoutView2, 800, 600);  
            sceneView2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            
            
            
            
            // Set up Scene 7 (Display all Employees in an Organization)
            GridPane grid7 = new GridPane();
            grid7.setPadding(new Insets(10, 10, 10, 10));
            grid7.setVgap(5);
            grid7.setHgap(5);
            grid7.setTranslateX(275);
            grid7.setTranslateY(100);
            Text label7 = new Text("Employee Management System");
            label7.setTranslateX(200);
            label7.setFill(Color.PURPLE);
		    label7.setStyle("-fx-font: 30 arial;");
		    //Adding a Label for when an error is made
            Label labelCheckForInfo7 = new Label();
            labelCheckForInfo7.setTranslateX(20);
            GridPane.setConstraints(labelCheckForInfo7, 0, 3);
            GridPane.setColumnSpan(labelCheckForInfo7, 2);
            grid4.getChildren().add(labelCheckForInfo7);
            //Need to redo main menu button for each class
            Button buttonMainDisplay = new Button("Main Menu");
            // move button 50 right 
            buttonMainDisplay.setTranslateX(350);
            // move button 50 down
            buttonMainDisplay.setTranslateY(400);
            //Defining the Name text field
            TextField enterOrg = new TextField();
            enterOrg.setPromptText("Enter Organization");
            enterOrg.setPrefColumnCount(10);
            enterOrg.getText();
            GridPane.setConstraints(enterOrg, 0, 0);
            grid7.getChildren().add(enterOrg);
            //Defining the Submit button
            Button submitOrg = new Button("Submit");
            buttonMainDisplay.setOnAction(new EventHandler<ActionEvent>() {
            	@Override
        	    public void handle(ActionEvent e) {
        	        primaryStage.setScene(scene1);
        	        enterOrg.clear();
        	    }
        	});
            
            GridPane.setConstraints(submitOrg, 1, 0);
            grid7.getChildren().add(submitOrg);
            //Defining the Clear button
            Button clearOrg = new Button("Clear");
            GridPane.setConstraints(clearOrg, 1, 1);
            grid7.getChildren().add(clearOrg);
            //Defining the Clear Button for the edit
            clearOrg.setOnAction(new EventHandler<ActionEvent>() {
            	@Override
            	    public void handle(ActionEvent e) {
            	        enterOrg.clear();
            	    }
            	});
            //Defining the Remove Button for the edit
            submitOrg.setOnAction(new EventHandler<ActionEvent>() {
            	@Override
            	    public void handle(ActionEvent e) {
            		orgEmps.clear();
            	       if ((enterOrg.getText() != null && !enterOrg.getText().isEmpty())) {
                               
                               String Org = enterOrg.getText();
                               for(Employee emps : employees) {
                            	   if(emps.getEmpOrg().equalsIgnoreCase(enterOrg.getText())) {
                            		   orgEmps.add(emps);
                            	   }
                               }
                               empCount = 0;
                               if(orgEmps.size() != 0) {
                            	   firstNameDisplay72.setText("First Name: " + orgEmps.get(0).getEmpFirstName());
                                   lastNameDisplay72.setText("Last Name: " + orgEmps.get(0).getEmpLastName());
                                   genderDisplay72.setText("Gender: " + orgEmps.get(0).getEmpGender());
                                   jobTitleDisplay72.setText("Job Title: " + orgEmps.get(0).getEmpTitle());
                                   birthdayDisplay72.setText("Birthday: " + orgEmps.get(0).getEmpBirthday());
                                   organizationDisplay72.setText("Organization: " + orgEmps.get(0).getEmpOrg());
                                   empIDDisplay72.setText("Employee ID: " + orgEmps.get(0).getEmpID());
                                   saysNoEmps72.setText("");
                               }
                              else {
                           	   	saysNoEmps72.setText("There are No Employees Added");
                           	   	saysNoEmps72.setTranslateX(300);
                           	   	saysNoEmps72.setTranslateY(-200);
                           	   	firstNameDisplay72.setText("");
                           	   	lastNameDisplay72.setText("");
                           	   	genderDisplay72.setText("");
                           	   	jobTitleDisplay72.setText("");
                           	   	birthdayDisplay72.setText("");
                           	   	organizationDisplay72.setText("");
                           	   	empIDDisplay72.setText("");
                              }
                               primaryStage.setScene(scene72);
            	    }
            	       else {
                           label.setText("Please fill in all the fields");
                       }
            	}});
            VBox layout7 = new VBox(20);
            layout7.getChildren().addAll(label7, buttonMainDisplay, grid7);
            scene7 = new Scene(layout7, 800, 600);
            scene7.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            
            
            
            
            
                  
            //Scene 7 part 2. View all Employees in an Organization
            Label label72 = new Label("Employee Management System");
            label72.setTranslateX(300);
            //Need to redo main menu button for each class
            Button buttonMain72 = new Button("Main Menu");
            // move button 50 right 
            buttonMain72.setTranslateX(350);
            // move button 50 down
            buttonMain72.setTranslateY(400);
            buttonMain72.setOnAction(e -> primaryStage.setScene(scene1));
            Button nextEmployee72 = new Button("Next Employee");
            Button prevEmployee72 = new Button("Previous Employee");
            nextEmployee72.setTranslateX(600);
            nextEmployee72.setTranslateY(320);
            prevEmployee72.setTranslateX(100);
            prevEmployee72.setTranslateY(275);
            
            firstNameDisplay72.setTranslateX(250);
            firstNameDisplay72.setTranslateY(-100);
            lastNameDisplay72.setTranslateX(250);
            lastNameDisplay72.setTranslateY(-100);
            genderDisplay72.setTranslateX(250);
            genderDisplay72.setTranslateY(-100);
            jobTitleDisplay72.setTranslateX(250);
            jobTitleDisplay72.setTranslateY(-100);
            birthdayDisplay72.setTranslateX(250);
            birthdayDisplay72.setTranslateY(-100);
            organizationDisplay72.setTranslateX(250);
            organizationDisplay72.setTranslateY(-100);
            empIDDisplay72.setTranslateX(250);
            empIDDisplay72.setTranslateY(-100);
            
            
            prevEmployee72.setOnAction(new EventHandler<ActionEvent>() {
            		@Override
            	    public void handle(ActionEvent e) {
            		//Don't go past 0 because of out of bounds error exception
            	        if(orgEmpCount > 0) {
            	        	orgEmpCount --;
            	        	firstNameDisplay72.setText("First Name: " + orgEmps.get(orgEmpCount).getEmpFirstName());
            	        	lastNameDisplay72.setText("Last Name: " + orgEmps.get(orgEmpCount).getEmpLastName());
            	        	genderDisplay72.setText("Gender: " + orgEmps.get(orgEmpCount).getEmpGender());
                            jobTitleDisplay72.setText("Job Title: " + orgEmps.get(orgEmpCount).getEmpTitle());
                            birthdayDisplay72.setText("Birthday: " + orgEmps.get(orgEmpCount).getEmpBirthday());
                            organizationDisplay72.setText("Organization: " + orgEmps.get(orgEmpCount).getEmpOrg());
                            empIDDisplay72.setText("Employee ID: " + orgEmps.get(orgEmpCount).getEmpID());
            	        }
            	    }
            	});
            
            nextEmployee72.setOnAction(new EventHandler<ActionEvent>() {
            		@Override
            	    public void handle(ActionEvent e) {
            		//Don't go past Max because of out of bounds error exception
            	        if(orgEmpCount < orgEmps.size() -1 ) {
            	        	orgEmpCount ++;
            	        	firstNameDisplay72.setText("First Name: " + orgEmps.get(orgEmpCount).getEmpFirstName());
            	        	lastNameDisplay72.setText("Last Name: " + orgEmps.get(orgEmpCount).getEmpLastName());
            	        	genderDisplay72.setText("Gender: " + orgEmps.get(orgEmpCount).getEmpGender());
                            jobTitleDisplay72.setText("Job Title: " + orgEmps.get(orgEmpCount).getEmpTitle());
                            birthdayDisplay72.setText("Birthday: " + orgEmps.get(orgEmpCount).getEmpBirthday());
                            organizationDisplay72.setText("Organization: " + orgEmps.get(orgEmpCount).getEmpOrg());
                            empIDDisplay72.setText("Employee ID: " + orgEmps.get(orgEmpCount).getEmpID());
            	        }
            	    }
            	});

            VBox layout72 = new VBox(20);
            layout72.getChildren().addAll(label72, buttonMain72, nextEmployee72, prevEmployee72, firstNameDisplay72, lastNameDisplay72, 
            genderDisplay72, jobTitleDisplay72, birthdayDisplay72, organizationDisplay72, empIDDisplay72, saysNoEmps72);
            scene72 = new Scene(layout72, 800, 600);
            scene72.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            
            
            
            
            
            
            
          
        } catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

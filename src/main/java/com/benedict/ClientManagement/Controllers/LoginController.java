package com.benedict.ClientManagement.Controllers;

import com.benedict.ClientManagement.Models.Model;
import com.benedict.ClientManagement.Utilities.AlertUtility;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public Label password_lbl;
    public TextField payee_address_fld;
    public PasswordField password_fld;
    public Button login_btn;
    public Label error_lbl;
    public Hyperlink register_link;

    public void initialize( URL url, ResourceBundle resourceBundle ){
        login_btn.setOnAction(actionEvent -> onLogin());
        register_link.setOnAction(actionEvent -> onRegister());
    }
    //login code
    public void onLogin() {
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance().checkCredentials(payee_address_fld.getText(), password_fld.getText());
            if (Model.getInstance().getAdminSuccessFlag()) {
                Model.getInstance().getViewFactory().showAdminWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            }else{
                payee_address_fld.setText("");
                password_fld.setText("");
                AlertUtility.displayError("Neteisingi prisijungimo duomenys.");
                //error_lbl.setText("Neteisingi prisijungimo duomenys");
            }
        }

        public void onRegister(){
            Stage stage = (Stage) error_lbl.getScene().getWindow();
            Model.getInstance().getViewFactory().showRegisterWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
        }

}

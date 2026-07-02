package com.elsilencio.software_hotel.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.elsilencio.software_hotel.servicios.TrabService;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class LoginController {
    
    // Variables del FXML
    @FXML
    private Button btnIngresar;
    
    @FXML
    private Button btnSalir;
    
    @FXML
    private TextField txtUser;
    
    @FXML
    private PasswordField txtPassword;
    
    private TrabService apiTrabajador;
    
    @FXML
    private AnchorPane rootPane;
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    public LoginController() {
        this.apiTrabajador = new TrabService();
    }
    
    public void initialize() {
        rootPane.setOnMousePressed(this::iniciarArrastre);
        rootPane.setOnMouseDragged(this::hacerArrastre);
    }
        
    private void iniciarArrastre(MouseEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        xOffset = stage.getX() - event.getScreenX();
        yOffset = stage.getY() - event.getScreenY();
    }
    
    private void hacerArrastre(MouseEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.setX(event.getScreenX() + xOffset);
        stage.setY(event.getScreenY() + yOffset);
    }
    
    
    @FXML
    private void IngresarDashboard(MouseEvent event) {
        handleIngresar();
    }

    @FXML
    private void IngresarEnter(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER){
            handleIngresar();
        }
    }

    @FXML
    private void salirAplicacion(MouseEvent event) {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }
    
    private void handleIngresar() {
        String usuario = txtUser.getText().trim();
        String password = txtPassword.getText();
        
        if (usuario.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Error", "Complete todos los campos", Alert.AlertType.ERROR);
            return;
        }
        
        // Deshabilitar botón mientras se procesa
        btnIngresar.setDisable(true);
        btnIngresar.setText("Conectando...");
        
        // Hacer la petición en hilo separado
        new Thread(() -> {
            try {
                // Llamar a tu API (ajusta el método según tu backend)
                boolean exito = apiTrabajador.autenticarTrabajador(usuario, password);
                
                javafx.application.Platform.runLater(() -> {
                    btnIngresar.setDisable(false);
                    btnIngresar.setText("Ingresar");
                    
                    if (exito) {
                        abrirDashboard();
                    } else {
                        mostrarAlerta("Error", "Usuario o contraseña incorrectos", Alert.AlertType.ERROR);
                        txtPassword.clear();
                        txtPassword.requestFocus();
                    }
                });
                
            } catch (Exception e) {
                e.printStackTrace();
                javafx.application.Platform.runLater(() -> {
                    btnIngresar.setDisable(false);
                    btnIngresar.setText("Ingresar");
                    mostrarAlerta("Error", "Error de conexión con el servidor", Alert.AlertType.ERROR);
                });
            }
        }).start();
    }
    
    private void abrirDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/elsilencio/software_hotel/fxml/dashboard.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) btnIngresar.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Hotel - Dashboard");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
            
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo cargar el dashboard", Alert.AlertType.ERROR);
        }
    }
    
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

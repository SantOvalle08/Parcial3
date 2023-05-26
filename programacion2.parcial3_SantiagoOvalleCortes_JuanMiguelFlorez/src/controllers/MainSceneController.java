package controllers;

import controllers.ModelFactoryController;
import javafx.stage.Stage;
import model.Estudiante;
import model.TipoGenero;
import application.Aplicacion;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.naming.spi.InitialContextFactory;

import Exceptions.EstudianteException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainSceneController implements Initializable {
	
	//Llamamos a la clase Singleton
	ModelFactoryController mfm = ModelFactoryController.getInstance();
	
    //Creamos una variable aplicacion para comunicarme con la aplicacion y me pase datos de la empresa
	private Aplicacion aplicacion;

	private Stage stage;


	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TableColumn<Estudiante, Float> columnNota1;

	    @FXML
	    private TableColumn <Estudiante, Float> columnNota2;

	    @FXML
	    private TableColumn<Estudiante, String> columnId;

	    @FXML
	    private TableColumn <Estudiante, Float> ColumnNota4;

	    @FXML
	    private Button btnPromedioEstudiante;

	    @FXML
	    private TableColumn <Estudiante, String> columnNombre;

	    @FXML
	    private TextField txtIdentificacion;

	    @FXML
	    private TextField txtNota3;

	    @FXML
	    private TextField txtNota2;

	    @FXML
	    private TextField txtNombre;

	    @FXML
	    private TextField txtNota4;

	    @FXML
	    private TableView<?> tableViewEstudiantes;

	    @FXML
	    private TextArea txtAreaPromedioCurso;

	    @FXML
	    private ComboBox <TipoGenero> comboBoxGenero;

	    @FXML
	    private TextField txtNota1;

	    @FXML
	    private TextArea txtAreaNombreMejor;

	    @FXML
	    private TableColumn <Estudiante, Float>  ColumnNota3;

	    @FXML
	    private TextField txtIdentPromedio;

	    @FXML
	    private TextArea txtAreaPromedio;

	    @FXML
	    private Button btnPromedioCurso;

	    @FXML
	    private Button btnEstudianteMayorNota;

	    @FXML
	    private Button btnAñadir;
	    
	    ObservableList<Estudiante> listaEstudiantes= FXCollections.observableArrayList();
	    
	    

	    @FXML
	    private TableColumn<Estudiante, TipoGenero> columnGenero;

	    @FXML
	    void añadirEstudiante(ActionEvent event) {
	    	añadirEstudiante();
	    }


		@FXML
	    void promediarEstudiante(ActionEvent event) {
	    	promediarEstudiante();
	    }

	    @FXML
	    void calcularPromedioCurso(ActionEvent event) {
	    	calcularPromedioCurso();
	    }


		@FXML
	    void buscarEstudiante(ActionEvent event) {
	    	buscarEstudiante();
	    }
		
//---------------------------- METODOS BUTTONS --------------------------------------	    
	    
		private void añadirEstudiante() {
		try {
				String nombre = txtNombre.getText();
				String identificacion = txtIdentificacion.getText();
				TipoGenero genero = comboBoxGenero.getSelectionModel().getSelectedItem();
				String nota1s = txtNota1.getText();
				String nota2s = txtNota2.getText();
				String nota3s = txtNota3.getText();
				String nota4s =  txtNota4.getText();
				
				//PASAR NOTAS A FLOAT
				List<Float> listaNotas= new ArrayList<>();
				float nota1 = Float.parseFloat(nota1s);
				float nota2 = Float.parseFloat(nota2s);
				float nota3 = Float.parseFloat(nota3s);
				float nota4 = Float.parseFloat(nota4s);
				
				listaNotas.add(nota1);
				listaNotas.add(nota2);
				listaNotas.add(nota3);
				listaNotas.add(nota4);
				
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
		
		private void crearEstudiante(String nombre, String identificacion, TipoGenero genero, List<Float> listaNotas) throws EstudianteException {
			if (mfm.crearEstudiante(nombre, identificacion, genero, listaNotas)) {
				mostrarMensaje("Notificacion estudiante","Estudiante registrado","No se ha registrado el estudiante.",AlertType.INFORMATION);
			}else {
				mostrarMensaje("ERROR","Error de creacion","Verifique campos para crear Estudiante.",AlertType.WARNING);
			}
		}
		
		
	    
		private void promediarEstudiante() {
		try {
			
				
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
	    
		
	    private void calcularPromedioCurso() {
	    try {
				
			} catch (Exception e) {				
			    e.printStackTrace();

			}
	    }
	    
		private void buscarEstudiante() {
			try {
				
			} catch (Exception e) {
			    e.printStackTrace();

			}
		}

	//---------------------------------- GETTERS AND SETTERS --------------------------------


		public ModelFactoryController getMfm() {
			return mfm;
		}
		
		public void setMfm(ModelFactoryController mfm) {
			this.mfm = mfm;
		}

		public void setAplicacion(Aplicacion aplicacion) {
			this.aplicacion= aplicacion;
		}
		public void setStage(Stage primaryStage) {
			stage = primaryStage;
		}

		public void show() {
			stage.show();
		}	


	
	    @FXML
	    void initialize() {
	    }


		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			comboBoxGenero.getItems().addAll(TipoGenero.MASCULINO,TipoGenero.FEMENINO);
			
		this.columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnId.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
		this.columnGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
			
			
			
		}
		
		public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertype) {
			Alert alert = new Alert(alertype);
			alert.setTitle(titulo);
			alert.setHeaderText(header);
			alert.setContentText(contenido);
			alert.setAlertType(alertype);
		}
		
	}



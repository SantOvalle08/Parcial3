module programacion2.parcial3_SantiagoOvalleCortes_JuanMiguelFlorez {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.naming;
	
	opens application to javafx.graphics, javafx.fxml;
}

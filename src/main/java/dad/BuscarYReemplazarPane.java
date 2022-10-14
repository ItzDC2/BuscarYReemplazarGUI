package dad;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscarYReemplazarPane extends Application {

	// View
	private Label buscarLabel;
	private Label reemplazarLabel;
	private Label resaltarResultadosLabel;
	
	private TextField buscarText;
	private TextField reemplazarText;
	
	private Button buscarButton;
	private Button reemplazarButton;
	private Button reemplazarTButton;
	private Button cerrarButton;
	private Button ayudaButton;
	
	private CheckBox mayusMinCheck;
	private CheckBox buscarAtrasCheck;
	private CheckBox resaltarResultadoCheck;
	private CheckBox expresionRegularCheck;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		
		// Inicializar elementos
		buscarLabel = new Label("Buscar");
		reemplazarLabel = new Label("Reemplazar con:");
		
		buscarText = new TextField();
		reemplazarText = new TextField();
		
		buscarButton = new Button("Buscar");
		reemplazarButton = new Button("Reemplazar");
		reemplazarTButton = new Button("Reemplazar todo");
		cerrarButton = new Button("Cerrar");
		ayudaButton = new Button("Ayuda");
		
		mayusMinCheck = new CheckBox();
		buscarAtrasCheck = new CheckBox();
		resaltarResultadoCheck = new CheckBox();
		expresionRegularCheck = new CheckBox();
		
		resaltarResultadoCheck.setAlignment(Pos.CENTER_RIGHT);
		
		resaltarResultadosLabel = new Label("Resaltar resultados");
		resaltarResultadosLabel.setAlignment(Pos.CENTER_RIGHT);
				
		GridPane gp = new GridPane();
		
		buscarButton.setMinWidth(100);
		reemplazarButton.setMinWidth(100);
		reemplazarTButton.setMinWidth(100);
		cerrarButton.setMinWidth(100);
		ayudaButton.setMinWidth(100);
		
		buscarButton.setPadding(new Insets(5));
		reemplazarButton.setPadding(new Insets(5));
		reemplazarTButton.setPadding(new Insets(5));
		cerrarButton.setPadding(new Insets(5));
		ayudaButton.setPadding(new Insets(5));
		
		VBox lado = new VBox(5, buscarButton, reemplazarButton, reemplazarTButton,
				cerrarButton, ayudaButton);
		
		lado.setAlignment(Pos.TOP_RIGHT);

		HBox checkUP1 = new HBox(5, mayusMinCheck, new Label("Mayúsculas y minúsculas"));
		HBox checkUP2 = new HBox(5,  buscarAtrasCheck, new Label("Buscar hacia atrás"));
		
		HBox checkDown1 = new HBox(5, expresionRegularCheck, new Label("Expresión regular"), resaltarResultadoCheck, resaltarResultadosLabel);
		HBox checkDown2 = new HBox(5, resaltarResultadoCheck, resaltarResultadosLabel);
		
		gp.setPadding(new Insets(5));
		gp.setHgap(5);
		gp.setVgap(5);
		
		gp.addRow(0, buscarLabel);
		gp.add(buscarText, 1, 0, 2, 1); //Node, colIndex, rowIndex, colsP
		gp.addRow(1, reemplazarLabel);
		gp.add(reemplazarText, 1, 1, 2, 1);
		
		gp.add(checkUP1, 1, 2);
		gp.add(checkDown1, 1, 3);
		
		gp.add(checkUP2, 2, 2);
		gp.add(checkDown2, 2, 3);
		
		ColumnConstraints cols[] = {
				new ColumnConstraints(),
				new ColumnConstraints(),
				new ColumnConstraints(),
		};
		
		gp.getColumnConstraints().setAll(cols);
		
		cols[0].setMinWidth(35);
		cols[0].setHgrow(Priority.ALWAYS);
		
		cols[1].setHgrow(Priority.ALWAYS);
		cols[1].setPercentWidth(45);
		cols[1].setMinWidth(Control.USE_PREF_SIZE);
		
		cols[2].setHgrow(Priority.ALWAYS);
		cols[2].setPercentWidth(30);
		cols[2].setMinWidth(Control.USE_PREF_SIZE);
		
		lado.setMinWidth(Control.USE_PREF_SIZE);
		
		BorderPane all = new BorderPane();
		
		all.setCenter(gp);
		all.setRight(lado);
		
		gp.setStyle("-fx-background-color: red");
		lado.setStyle("-fx-background-color: blue");
		all.setStyle("-fx-background-color: green");
		
		all.setPadding(new Insets(10));
		
		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(new Scene(all, 550, 200));
		
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

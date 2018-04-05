import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Test extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage)  {
		final int SIZE_OF_MAP = 20 ; // public static final ? should I supposed to write it here?
		GridPane gridPane = new GridPane();
		for(int row = 0 ; row < SIZE_OF_MAP ; row++) {
			for(int col = 0 ; col < SIZE_OF_MAP ;col++) {
				Label l = new Label();
				l.setMinHeight(20);
				l.setMinWidth(20);
				if(row < 3 || row > 16)
					l.setId("label-sea");
				else if(row < 8 || row > 11)
					l.setId("label-sand");
				else
					l.setId("label-forest");
				l.setText("("+row+","+col+")");
				gridPane.setConstraints(l, col, row);
				gridPane.getChildren().add(l);
			}
		}

		Scene scene = new Scene(gridPane);
		scene.getStylesheets().add(Test.class
				.getResource("warMap.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Example extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();
        Label title = new Label("Ein Maerchen");
        BorderPane.setAlignment(title, Pos.CENTER);
        borderPane.setTop(title);
        FlowPane chapters = new FlowPane();
        for(int i = 1; i <= 20; i++)
        {
            chapters.getChildren().add(new Button(String.valueOf(i)));
        }
        borderPane.setBottom(chapters);
        Button left = new Button("<");
        Button right = new Button(">");
        borderPane.setLeft(left);
        borderPane.setRight(right);
        Label center = new Label("Some text");
        borderPane.setCenter(center);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}

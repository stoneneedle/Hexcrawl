import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

public class UIMain extends Application {
    public void start(Stage primaryStage) {
        int width = 1920, height = 1080;
        
        AnchorPane hextileMap = new AnchorPane();
        Scene content = new Scene(hextileMap, width, height);
        primaryStage.setScene(content);
        
        double size = 17,v=Math.sqrt(3)/2.0;
        
        for(double y=0;y<height;y+=size*Math.sqrt(3))
        {
            for(double x=-25,dy=y;x<width;x+=(3.0/2.0)*size)
            {
                Polygon hextile = new Polygon();
                hextile.getPoints().addAll(new Double[]{
                    x,dy,
                    x+size,dy,
                    x+size*(3.0/2.0),dy+size*v,
                    x+size,dy+size*Math.sqrt(3),
                    x,dy+size*Math.sqrt(3),
                    x-(size/2.0),dy+size*v
                });
                hextile.setFill(Paint.valueOf("#ffffff"));
                hextile.setStrokeWidth(2);
                hextile.setStroke(Paint.valueOf("#000000") );
                hextileMap.getChildren().add(hextile);
                dy = dy==y ? dy+size*v : y;
            }
        }
        
        primaryStage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
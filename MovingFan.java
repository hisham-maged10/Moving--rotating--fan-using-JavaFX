/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
public class MovingFan extends Application{
	@Override 
	public void start(Stage primaryStage)
	{
		BorderPane bp=new BorderPane();
		StackPane sp=new StackPane();
		Circle circ=new Circle();
		circ.setRadius(150);
		circ.setFill(Color.RED);
		Ellipse ellipse1=new Ellipse();
		ellipse1.setRadiusY(30);
		ellipse1.setRadiusX(150);
		ellipse1.setFill(Color.WHITE);
		ellipse1.setRotate(45);
		Ellipse ellipse2=new Ellipse();
		ellipse2.setRadiusY(30);
		ellipse2.setRadiusX(150);
		ellipse2.setFill(Color.WHITE);
		ellipse2.setRotate(135);
		EventHandler<ActionEvent> ellipse1Animation=e->{
			ellipse1.setRotate(ellipse1.getRotate()+10.0);
			ellipse2.setRotate(ellipse2.getRotate()+10.0);
		};
		Timeline t1=new Timeline(new KeyFrame(Duration.millis(100),ellipse1Animation));
		t1.setCycleCount(Timeline.INDEFINITE);
		t1.setRate(1.0);
		Button inc=new Button("inc");
		inc.setOnAction(e->{
			t1.setRate(t1.getRate()+0.5);
			if(t1.getStatus()==Animation.Status.PAUSED)
				t1.play();
		});
		Button dec=new Button("dec");
		dec.setOnAction(e->{
			if(t1.getRate()>0.0)
			t1.setRate(t1.getRate()-0.5);
			else
			{
				t1.setRate(0.0);
				t1.pause();
			}
		});
		Button rev=new Button("rev");
		rev.setOnAction(e->{
			t1.setRate(t1.getRate()*-1);
		});
		Button play=new Button("play/pause");
		play.setOnAction(e->{
			if(t1.getStatus()==Animation.Status.RUNNING)
				t1.pause();
			else
				t1.play();
		});
		sp.getChildren().addAll(circ,ellipse1,ellipse2);
		bp.setCenter(sp);
		HBox hb=new HBox(10);
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(play,inc,dec,rev);
		hb.setPadding(new Insets(10));
		bp.setBottom(hb);
		Scene scene=new Scene(bp);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch();
	}
}

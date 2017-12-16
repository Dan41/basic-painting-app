package javaFX;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MouseMovement extends Application {
	
	private Square[][] paint = new Square[70][70];
	Rectangle rect;
	private boolean blackSel = false;
	private boolean redSel = false;
	private boolean blueSel = false;
	private boolean greenSel = false;
	private boolean purpleSel = false;
	private boolean brownSel = false;
	private boolean eraseSel = false;
	
	private void allFalse() {
		blackSel = false;
		redSel = false;
		blueSel = false;
		greenSel = false;
		purpleSel = false;
		brownSel = false;
		eraseSel = false;
	}
	
	public Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(700, 700);
		
		for (int i = 0; i < 70; i++) {
			for (int j = 0; j < 70; j++) {
				Square square = new Square();
				square.setLayoutX(j * 10);
				square.setLayoutY(i * 10);
				paint[i][j] = square;
				
				root.getChildren().add(square);
			}
		}
		
		Button black = new Button("Black");
		black.setLayoutX((700 / 8) - (black.getWidth() / 2));
		black.setLayoutY(650);
		black.setFocusTraversable(false);
		
		Button red = new Button("Red");
		red.setLayoutX(2 * (700 / 8) - (red.getWidth() / 2));
		red.setLayoutY(650);
		red.setFocusTraversable(false);
		
		Button blue = new Button("Blue");
		blue.setLayoutX((3 * (700 / 8)) - (blue.getWidth() / 2));
		blue.setLayoutY(650);
		blue.setFocusTraversable(false);
		
		Button green = new Button("Green");
		green.setLayoutX((4 * (700 / 8)) - (green.getWidth() / 2));
		green.setLayoutY(650);
		green.setFocusTraversable(false);
		
		Button purple = new Button("Purple");
		purple.setLayoutX((5 * (700 / 8)) - (purple.getWidth() / 2));
		purple.setLayoutY(650);
		purple.setFocusTraversable(false);
		
		Button brown = new Button("Brown");
		brown.setLayoutX((6 * (700 / 8)) - (brown.getWidth() / 2));
		brown.setLayoutY(650);
		brown.setFocusTraversable(false);

		Button erase = new Button("Eraser");
		erase.setLayoutX((7 * (700 / 8)) - (erase.getWidth() / 2));
		erase.setLayoutY(650);
		erase.setFocusTraversable(false);
		
		root.getChildren().addAll(black, red, blue, green, purple, brown, erase);
		
		black.setOnAction(e -> {
			allFalse();
			blackSel = true;
		});
		red.setOnAction(e -> {
			allFalse();
			redSel = true;
		});
		blue.setOnAction(e -> {
			allFalse();
			blueSel = true;
		});
		green.setOnAction(e -> {
			allFalse();
			greenSel = true;
		});
		purple.setOnAction(e -> {
			allFalse();
			purpleSel = true;
		});
		brown.setOnAction(e -> {
			allFalse();
			brownSel = true;
		});
		erase.setOnAction(e -> {
			allFalse();
			eraseSel = true;
		});
		
		root.setOnMouseDragged(event -> {
			for (int i = 0; i < 70; i++) {
				for (int j = 0; j < 70; j++) {
					if ((paint[i][j].getLayoutX() - 20 < event.getSceneX()
						&& event.getSceneX() < paint[i][j].getLayoutX() + 20)
						&& (paint[i][j].getLayoutY() - 20 < event.getSceneY()
						&& event.getSceneY() < paint[i][j].getLayoutY() + 20)) {
						rect = new Rectangle(10, 10);
						if (blackSel == true) {
							rect.setFill(Color.BLACK);
						}
						else if (redSel == true) {
							rect.setFill(Color.RED);
						}
						else if (blueSel == true) {
							rect.setFill(Color.BLUE);
						}
						else if (greenSel == true) {
							rect.setFill(Color.GREEN);
						}
						else if (purpleSel == true) {
							rect.setFill(Color.PURPLE);
						}
						else if (brownSel == true) {
							rect.setFill(Color.SADDLEBROWN);
						}
						else if (eraseSel == true) {
							rect.setFill(Color.WHITE);
						}
						paint[i][j].getChildren().add(rect);
					}
				}
			}
		});
		Text reset = new Text("Press space to reset");
		reset.setFont(Font.font(16));
		reset.setStroke(Color.WHITE);
		reset.setStrokeWidth(0.3);
		reset.setLayoutX(270);
		reset.setLayoutY(18);
		root.getChildren().add(reset);
		
		return root;
	}
	
	private class Square extends StackPane {
		public Square() {
			Rectangle start = new Rectangle(10, 10);
			start.setFill(Color.WHITE);
			
			getChildren().add(start);
		}
	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Mouse movement");
		Scene scene = new Scene(createContent());
		
		scene.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.SPACE) {
				for (int i = 0; i < 70; i++) {
					for (int j = 0; j < 70; j++) {
						paint[i][j].getChildren().clear();
						
						Rectangle start = new Rectangle(10, 10);
						start.setFill(Color.WHITE);
						
						paint[i][j].getChildren().add(start);
					}
				}
			}
		});
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

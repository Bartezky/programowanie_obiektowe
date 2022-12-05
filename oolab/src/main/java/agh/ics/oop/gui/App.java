package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {

    private Vector2d[] borders;
    private IWorldMap map;

    public void init() {
        try {
            List<String> args = getParameters().getRaw();
            MoveDirection[] directions = new OptionsParser().parse(args);
            map = new GrassField(11);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(9, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            borders = map.getBorders();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init();
        GridPane gridPane = new GridPane();
        int minX = borders[0].x();
        int maxX = borders[1].x();
        int minY = borders[0].y();
        int maxY = borders[1].y();

        //podpisanie osi
        gridPane.add(new Label("y/x"), 1, 1);
        for (int i = 0; i <= maxX - minX; i++) {
            Label label = new Label(Integer.toString(minX + i));
            gridPane.add(label, i + 2, 1);
            GridPane.setHalignment(label, HPos.CENTER);
        }
        for (int i = 0; i <= maxY - minY; i++) {
            Label label = new Label(Integer.toString(maxY - i));
            gridPane.add(label, 1, i + 2);
            GridPane.setHalignment(label, HPos.CENTER);
        }

        //wprowadzenie elementów na mapę
        for (int i = 1; i <= maxX - minX + 1; i++)
            for (int j = 1; j <= maxY - minY + 1; j++) {
                Object o = map.objectAt(new Vector2d(minX + i - 1, maxY - j + 1));
                Label label;
                if (o == null)
                    label = new Label("     ");
                else
                    label = new Label(o.toString());
                gridPane.add(label, i + 1, j + 1);
                GridPane.setHalignment(label, HPos.CENTER);
            }

        gridPane.getColumnConstraints().add(new ColumnConstraints(maxX - minX));
        gridPane.getRowConstraints().add(new RowConstraints(maxY - minY));

        gridPane.setGridLinesVisible(true);
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

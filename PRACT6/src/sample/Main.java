package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
       // Scene scene = new Scene(root, 300, 275);


        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> bc =new BarChart<>(xAxis,yAxis);
        bc.setTitle("patata");
        xAxis.setLabel("Xbotifarra");
        yAxis.setLabel("Ybotifarra");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("llongaisa1");
        series1.getData().add(new XYChart.Data("pechuga", 23));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("llongaisa4");
        series2.getData().add(new XYChart.Data("pechuga", 25));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("llongaisa3");
        series3.getData().add(new XYChart.Data("pechuga", 26));

        bc.getData().addAll(series1,series2, series3);

        Scene scene = new Scene(bc);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

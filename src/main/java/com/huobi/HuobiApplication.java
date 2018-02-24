package com.huobi;

import com.huobi.enums.WarningTypeEnum;
import com.huobi.javafx.controller.ConfigController;
import com.huobi.javafx.controller.RootController;
import com.huobi.schedule.HuoBITask;
import com.huobi.service.HuoBiService;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com")
public class HuobiApplication extends Application {

    private HuobiApplication huobiApplication;

    private Stage primaryStage;

    private Stage dialogStage;

    private RootController rootController;

    public static ConfigurableApplicationContext applicationContext;

    private double xOffset = 0;
    private double yOffset = 0;

    private double clickXOffset = 0;
    private double clickYOffset = 0;

    private double systemX = 0;
    private double systemY = 0;

    public static void main(String[] args) {
//        SpringApplication.run(HuobiApplication.class, args);
        launch(args);
    }

    @Override
    public void init() throws Exception {
        CompletableFuture.supplyAsync(() -> {
            ConfigurableApplicationContext ctx = SpringApplication.run(this.getClass());
            HuoBITask huoBITask = (HuoBITask) ctx.getBean("huoBITask");
            huoBITask.setRootController(rootController);
            return ctx;
        }).thenAccept(this::launchApplicationView);

        systemX = Toolkit.getDefaultToolkit().getScreenSize().width;
        systemY = Toolkit.getDefaultToolkit().getScreenSize().height;
    }

    private void launchApplicationView(ConfigurableApplicationContext ctx) {
        HuobiApplication.applicationContext = ctx;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        huobiApplication = this;

        this.primaryStage = primaryStage;

        //去除标题栏
        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setAlwaysOnTop(true);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("main.fxml"));

        Pane pane = loader.load();

        //添加鼠标事件
        pane.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        pane.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

        pane.setOnMouseClicked(event -> {
            //判断右键点击事件
            if (event.getButton().equals(MouseButton.SECONDARY)) {
//                Platform.runLater(()->huobiApplication.showConfig());
                clickXOffset = primaryStage.getX();
                clickYOffset = primaryStage.getY();
                showConfig();
            }
        });

        primaryStage.setScene(new Scene(pane));

        primaryStage.setOnCloseRequest(arg0 -> primaryStage.hide());

        RootController rootController = loader.getController();
        rootController.setHuobiApplication(this);
        this.rootController = rootController;

        primaryStage.setOnCloseRequest(event -> System.exit(0));

        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.exit(0);
    }

    public void showConfig() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("config.fxml"));
            AnchorPane anchorPane = loader.load();
            // Create the dialog Stage.
            Stage dialogStage = new Stage();

            this.dialogStage = dialogStage;

            dialogStage.setTitle("Edit config");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(anchorPane);
            dialogStage.setScene(scene);

            ConfigController configController = loader.getController();

            configController.setStage(dialogStage);

            if (primaryStage.getX() + anchorPane.getPrefWidth()>systemX){
                clickXOffset = systemX - anchorPane.getPrefWidth()*1.5;
            }
            if (primaryStage.getY() + anchorPane.getPrefHeight() > systemY){
                clickYOffset = systemY-anchorPane.getPrefHeight()*1.5;
            }

            dialogStage.setX(clickXOffset);
            dialogStage.setY(clickYOffset);

            configController.getSymbol().setText(HuoBiService.symbol.get("default"));
            configController.getFluctuation().setText(HuoBiService.percentage.get(WarningTypeEnum.FLUCTUATION.name()).toString());
            configController.getHeightest().setText(HuoBiService.percentage.get(WarningTypeEnum.CUR_HEIGHT.name()).toString());
            configController.getNormal().setText(HuoBiService.percentage.get(WarningTypeEnum.DEFAULT.name()).toString());

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

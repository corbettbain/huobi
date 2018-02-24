package com.huobi.javafx.controller;

import com.huobi.enums.WarningTypeEnum;
import com.huobi.service.HuoBiService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Created by hasee on 2018/2/10.
 */
public class ConfigController {
    @FXML
    private TextField symbol;
    @FXML
    private TextField heightest;
    @FXML
    private TextField normal;
    @FXML
    private TextField fluctuation;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public TextField getSymbol() {
        return symbol;
    }

    public void setSymbol(TextField symbol) {
        this.symbol = symbol;
    }

    public TextField getHeightest() {
        return heightest;
    }

    public void setHeightest(TextField heightest) {
        this.heightest = heightest;
    }

    public TextField getNormal() {
        return normal;
    }

    public void setNormal(TextField normal) {
        this.normal = normal;
    }

    public TextField getFluctuation() {
        return fluctuation;
    }

    public void setFluctuation(TextField fluctuation) {
        this.fluctuation = fluctuation;
    }

    @FXML
    private void commit(){
        HuoBiService.symbol.put("default",symbol.getText());
        HuoBiService.percentage.put(WarningTypeEnum.FLUCTUATION.name(),Double.valueOf(fluctuation.getText()));
        HuoBiService.percentage.put(WarningTypeEnum.CUR_HEIGHT.name(),Double.valueOf(heightest.getText()));
        HuoBiService.percentage.put(WarningTypeEnum.DEFAULT.name(),Double.valueOf(normal.getText()));

        stage.close();
    }
}

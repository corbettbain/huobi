package com.huobi.javafx.controller;

import com.huobi.HuobiApplication;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * @author Created by hasee on 2018/2/8.
 */
public class RootController {
    @FXML
    private Label symbol;
    @FXML
    private Label close;
    @FXML
    private Label preg;

    @FXML
    private Label time;

    public Label getSymbol() {
        return symbol;
    }

    public Label getClose() {
        return close;
    }

    public Label getPreg() {
        return preg;
    }

    public Label getTime() {
        return time;
    }

    private HuobiApplication huobiApplication;

    public void setHuobiApplication(HuobiApplication huobiApplication) {
        this.huobiApplication = huobiApplication;
    }
}

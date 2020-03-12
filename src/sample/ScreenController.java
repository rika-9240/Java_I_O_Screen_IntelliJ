package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.nio.charset.Charset;


public class ScreenController {
    @FXML private Button outputButton;
    @FXML private Label outputLabel;
    @FXML private TextField inputText;
    TextField tf = new TextField("");

    @FXML
    protected void onButtonClick(ActionEvent evt){
        if(inputText != null && outputButton.getText().equals("表示する")){

           if(checkZenkaku(inputText.getText())) {
               outputLabel.setText(inputText.getText());
               outputButton.setText("clear");
           }else{
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setContentText("文字は全角で入力してください。");
               alert.setHeaderText(null);
               alert.showAndWait();

           }

        }else{
            outputLabel.setText("");
            outputButton.setText("表示する");
        }
    }
    public static boolean checkZenkaku(String str){//バイト数で全角チェック
        int byteCnt = str.getBytes(Charset.forName("Shift_JIS")).length;
        int len = str.length();
        return byteCnt != len;
    }


}

package com.example.igra2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

@SuppressWarnings("SingleStatementInBlock")
public class HelloController {
    int n = 8;
    int[] boardImg = new int[]{2, 1, 4, 3, 4, 1, 3, 2};
    int[] board = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    int countImg = 0;
    int ball = 0;
    boolean game = false;
    String butStartTxt = "GO";
    String pathImage1 = "file:/C:/javadef/igra2/src/img/b.png";
    String pathImage2 = "file:/C:/javadef/igra2/src/img/m.png";
    String pathImage3 = "file:/C:/javadef/igra2/src/img/n.png";
    String pathImage4 = "file:/C:/javadef/igra2/src/img/v.png";

    String pathImage5 = "file:/C:/javadef/igra2/src/img/zero.jpg";
     public void onbBStartClick(ActionEvent actionEvent) {
        butStart.setText(butStartTxt);
        game = true;
    }

     public void imageAction(MouseEvent mouseEvent) throws InterruptedException {
        if (game) {
            if (((ImageView) mouseEvent.getSource()) == image1) {
                calc(mouseEvent, 0, pathImage2);
            } else if (((ImageView) mouseEvent.getSource()) == image9) {
                calc(mouseEvent, 7, pathImage2);
            } else if (((ImageView) mouseEvent.getSource()) == image4) {
                calc(mouseEvent, 3, pathImage3);
            } else if (((ImageView) mouseEvent.getSource()) == image8) {
                calc(mouseEvent, 6, pathImage3);
            } else if (((ImageView) mouseEvent.getSource()) == image6) {
                calc(mouseEvent, 4, pathImage4);
            } else if (((ImageView) mouseEvent.getSource()) == image3) {
                calc(mouseEvent, 2, pathImage4);
            } else if (((ImageView) mouseEvent.getSource()) == image7) {
                calc(mouseEvent, 5, pathImage1);
            } else if (((ImageView) mouseEvent.getSource()) == image2) {
                calc(mouseEvent, 1, pathImage1);
            }
        }
    }
    @FXML
     public void calc(MouseEvent mouseEvent, int i, String pathImage) throws InterruptedException {
        Image image = new Image(pathImage);
        ((ImageView) mouseEvent.getSource()).setImage(image);
        board[i] = 1;
        countImg++;
        if (countImg == 2) {
            if (board[0] == 1 && board[7] == 1 || board[3] == 1 && board[6] == 1 || board[4] == 1 && board[2] == 1 || board[5] == 1 && board[1] == 1) {
                ball++;
                Ball.setText(String.valueOf(ball));
                countImg = 0;
                board[i] ++;
            }  else if(board[0] != 1 && board[7] != 1 || board[3] != 1 && board[6] != 1 || board[4] != 1 && board[2] != 1 || board[5] != 1 && board[1] != 1)
               {
                countImg = 0;
            }
        }
        String tt;
        LabMassiv.setText("");
        for (int t = 1; t <= 8; t++) {
            tt = LabMassiv.getText();
            LabMassiv.setText(tt + String.valueOf(board[t]));
        }
    }
    @FXML
    private Button butStart;
    @FXML
    private Label LabHead,Ball,LabMassiv;
    @FXML
    private ImageView image1,image2,image3,image4,image6,image7,image8,image9;
}

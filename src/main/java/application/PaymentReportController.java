/**
 * Sample Skeleton for 'PaymentReport.fxml' Controller Class
 */

package src.main.java.application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javax.swing.JOptionPane;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class PaymentReportController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="diag_pay"
    private BarChart<?, ?> diag_pay; // Value injected by FXMLLoader
      
    
    @FXML // fx:id="dateofcomp"
    private Label dateofcomp; // Value injected by FXMLLoader
    
    @FXML
    void BacktoAllComp(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreManager.fxml"));
		AnchorPane root = (AnchorPane) loader.load();
		StoreManager user = loader.getController();
//		Image im = new Image("images/background.jpg");to me all comp
//		user.setimage(im);
//		user.set(MyEmail);
		Scene regist = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(regist);
		app_stage.show();
	}
    
     void paymentdata(String Month1,String store1) {
    	 dateofcomp.setText(Month1);
    	 String message = "payment#" + "complaint#" + store1 + "#" + month1;
 		Connect.client.handleMessageFromClientUI(message);
 		String[] Msg = Connect.client.servermsg.split("#");
 		if ((Msg[0] == null) || (Msg[1] == null)|| (Msg[2] == null)|| (Msg[3] == null)) {
			JOptionPane.showMessageDialog(null, "Showing  Failed ! ");
		} else {
			 final CategoryAxis xAxis = new CategoryAxis();
		        final NumberAxis yAxis = new NumberAxis();
			diag_pay= new BarChart<String,String>(xAxis,yAxis);
			xAxis.setLabel("Week");       
	        yAxis.setLabel("Value");
	        XYChart.Series series1 = new XYChart.Series();
	        series1.getData().add(new XYChart.Data("first week", Msg[0]));
	        series1.getData().add(new XYChart.Data("second week", Msg[1]));
	        series1.getData().add(new XYChart.Data("Third week",Msg[2]));
	        series1.getData().add(new XYChart.Data("Fourth week", Msg[3]));
	       // Scene scene  = new Scene(bc,800,600);
	        diag_pay.getData().addAll(series1);
	       // stage.setScene(scene);
	       // stage.show();
		}
    	
     }
     
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert diag_pay != null : "fx:id=\"diag_pay\" was not injected: check your FXML file 'PaymentReport.fxml'.";

    }
}

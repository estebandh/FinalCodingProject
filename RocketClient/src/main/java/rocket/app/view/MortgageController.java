package rocket.app.view;

import java.net.URL;
import java.util.ResourceBundle;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketBase.RateBLL;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController implements Initializable{

	private MainApp mainApp;
	@FXML private Label creditScore;
	@FXML private Label income;
	@FXML private Label term;
	@FXML private Label expenses;
	@FXML private Label downPayment;
	@FXML private Label houseCost;
	@FXML private TextField txtIncome;
	@FXML private TextField txtExpenses;
	@FXML private TextField txtCreditScore;
	@FXML private TextField txtHouseCost;
	@FXML private TextField txtDownPayment;
	@FXML private ComboBox cmbTerm;
	@FXML private Button calculate;
	@FXML private Label lblMortgagePayment;
	@FXML private Label errorMessage;
	
	//	TODO - RocketClient.RocketMainController
	
	//	Create private instance variables for:
	//		TextBox  - 	txtIncome
	//		TextBox  - 	txtExpenses
	//		TextBox  - 	txtCreditScore
	//		TextBox  - 	txtHouseCost
	//		ComboBox -	loan term... 15 year or 30 year
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		lq.setExpenses(Integer.parseInt(txtExpenses.getText()));
		lq.setIncome(Integer.parseInt(txtIncome.getText()));
		lq.setiTerm(Integer.parseInt(cmbTerm.getAccessibleText()));
		lq.setdAmount(Integer.parseInt(txtHouseCost.getText())-Integer.parseInt(txtDownPayment.getText()));
		lq.setiDownPayment(Integer.parseInt(txtDownPayment.getText()));
		
		//	TODO - RocketClient.RocketMainController
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq

		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		// when returned a valid loan request the program should make the invisible lblMortgagePayment label visible
		// and set the text to be the payment rounded to two decimals. But instead the button is always visible and 
		// says "label" as the text
		lblMortgagePayment.setVisible(true);
		lblMortgagePayment.setText(Double.toString(Math.round(lRequest.getdPayment()*100)/100));
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cmbTerm.getItems().add("15");
		cmbTerm.getItems().add("30");
	}
}

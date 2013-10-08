//import java.util.*;
import javax.swing.JOptionPane;

public class jOption {
	
	public static void main(String[] args) {
		
		//String fingers = JOptionPane.showInputDialog("Input: ");
		//JOptionPane.showMessageDialog(null, "You have " + fingers +" fingers!");
		//Scanner n = new Scanner
		Double number = Double.parseDouble(JOptionPane.showInputDialog("What's number? "));
		if (number.compareTo(1.5) == 0) {
			//If number == 1.5
			JOptionPane.showMessageDialog(null, "Correct!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Incorrect!");
		}
		
	}

}

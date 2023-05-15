//import java.awt.event.*;
import javax.swing.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import javax.imageio.ImageIO;

public class AddCourseFuncs{
	
	JLabel title, category, description, price, DataVerificationMsg;
	JTextField titleTF, descriptionTF, priceTF;
	JButton addCourseBtn;
	
	String categories[] = {"Language", "Design", "Professional", "Freelancing"};
	JComboBox<String> categoryCB;

	public AddCourseFuncs(){
		
		title = new JLabel("Title: ");
		category = new JLabel("Category: ");
		description = new JLabel("Description: ");
		price = new JLabel("Price: ");
		DataVerificationMsg = new JLabel();
		
		titleTF = new JTextField();
		categoryCB = new JComboBox<>(categories);
		descriptionTF = new JTextField();
		priceTF = new JTextField();
		
		addCourseBtn = new JButton("Add Course!");
	}
	
	public boolean checkTitle(JFrame dashFrame, AddCourseFuncs addcrs){
		//storing the user entered name in a string object
        String titlename = new String(addcrs.titleTF.getText());
		//checking for empty name entry
        if(titlename.equals("")){ //empty name
            addcrs.DataVerificationMsg.setText("Please enter course title"); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(dashFrame); //refreshing mainframe
			System.out.println("notitle");
            return false;
        }
		else{
			addcrs.DataVerificationMsg.setText(""); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(dashFrame); //refreshing mainframe
			System.out.println("titled!");
			return true;
		}
	}
	
	public boolean checkDescription(JFrame dashFrame, AddCourseFuncs addcrs){
		//storing the user entered name in a string object
        String descriptiontext = new String(addcrs.descriptionTF.getText());
		//checking for empty name entry
        if(descriptiontext.equals("") || descriptiontext.length() > 499){ //empty name
            addcrs.DataVerificationMsg.setText("Please enter a description within 500 words"); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(dashFrame); //refreshing mainframe
			System.out.println("descerror");
            return false;
        }
		else{
			addcrs.DataVerificationMsg.setText(""); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(dashFrame); //refreshing mainframe
			System.out.println("descipto!");
			return true;
		}
	}
	
	public boolean checkPrice(JFrame dashFrame, AddCourseFuncs addcrs){
		//storing the user entered name in a string object
		int priceint = 0;
		try{
        priceint = Integer.parseInt(addcrs.priceTF.getText());
		}
		catch(Exception e){
			System.out.println(e);
		}
		//checking for empty name entry
        if(priceint < 50){ //empty name
            addcrs.DataVerificationMsg.setText("Minimum price must be 50 taka"); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(dashFrame); //refreshing mainframe
			System.out.println("priceerror");
            return false;
        }
		else{
			addcrs.DataVerificationMsg.setText(""); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(dashFrame); //refreshing mainframe
			System.out.println("priced!");
			return true;
		}
	}
	
}
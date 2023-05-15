import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
//import java.io.File;
import javax.imageio.ImageIO;

public class AddCourseDecor{
	public AddCourseDecor(JFrame dashFrame, AddCourseFuncs addcrs){
		addcrs.title.setBounds(500,100,100,40);
		addcrs.category.setBounds(500,200,100,40);
		addcrs.description.setBounds(500,300,100,40);
		addcrs.price.setBounds(500,400,100,40);
		addcrs.titleTF.setBounds(600,100,100,40);
		addcrs.categoryCB.setBounds(600,200,100,40);
		addcrs.descriptionTF.setBounds(600,300,100,40);
		addcrs.priceTF.setBounds(600,400,100,40);
		addcrs.addCourseBtn.setBounds(600,500,100,40);
		addcrs.DataVerificationMsg.setBounds(600,600,300,40);
		
		
		dashFrame.add(addcrs.title);
		dashFrame.add(addcrs.category);
		dashFrame.add(addcrs.description);
		dashFrame.add(addcrs.price);
		dashFrame.add(addcrs.titleTF);
		dashFrame.add(addcrs.categoryCB);
		dashFrame.add(addcrs.descriptionTF);
		dashFrame.add(addcrs.priceTF);
		dashFrame.add(addcrs.addCourseBtn);
		dashFrame.add(addcrs.DataVerificationMsg);
	
		SwingUtilities.updateComponentTreeUI(dashFrame);
	}

}
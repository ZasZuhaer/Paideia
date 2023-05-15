import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
//import java.io.File;
import javax.imageio.ImageIO;

public class StudentDashboard implements ActionListener{
	
	JFrame dashFrame;
	BufferedImage dashImage;
	JButton allCoursesBtn, languageBtn, designBtn, professionalBtn, freelancingBtn;
	JButton myCoursesBtn, supportBtn, userMenuBtn;
	
	public StudentDashboard(){
		
		//creating dashboard objects
		dashFrame = new JFrame("Student | Paideia");
			//buttons
		allCoursesBtn = new JButton("All Courses");
		languageBtn = new JButton("Language");
		designBtn = new JButton("Design");
		professionalBtn = new JButton("Professional");
		freelancingBtn = new JButton("Freelancing");
		myCoursesBtn = new JButton("My Courses");
		supportBtn = new JButton("Support");
		userMenuBtn = new JButton("UserMenuImage");
		
		//setting positions for buttons
		allCoursesBtn.setBounds(100,100,100,50);
		designBtn.setBounds(200,100,100,50);
		languageBtn.setBounds(300,100,100,50);
		professionalBtn.setBounds(400,100,100,50);
		myCoursesBtn.setBounds(100,200,100,50);
		freelancingBtn.setBounds(300,100,100,50);
		supportBtn.setBounds(100,400,100,50);
		userMenuBtn.setBounds(100,500,100,50);
		
		//adding action listener to buttons
		allCoursesBtn.addActionListener(this);
		designBtn.addActionListener(this);
		languageBtn.addActionListener(this);
		professionalBtn.addActionListener(this);
		myCoursesBtn.addActionListener(this);
		freelancingBtn.addActionListener(this);
		supportBtn.addActionListener(this);
		userMenuBtn.addActionListener(this);
		
		
		// adding background image on dashFrame
        try {
            dashImage = ImageIO.read(getClass().getResource("Images/StudentDashboard.PNG"));
            dashFrame.setContentPane(new ImagePanel(dashImage));
        } catch (Exception e) {
            System.out.println(e);
        }

		//adding components to dashFrame
		dashFrame.add(allCoursesBtn);
		dashFrame.add(designBtn);
		dashFrame.add(languageBtn);
		dashFrame.add(professionalBtn);
		dashFrame.add(freelancingBtn);
		dashFrame.add(myCoursesBtn);
		dashFrame.add(supportBtn);
		dashFrame.add(userMenuBtn);
		
		// dashFrame default configurations
        dashFrame.setSize(1366, 768);
        dashFrame.setLayout(null);
        dashFrame.setLocationRelativeTo(null);
        dashFrame.setVisible(true);
		// performing manual close operation on dashFrame
        dashFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                //accounts_tb.close(); // closing database connection
                System.exit(0); // closing dashFrame
            }
        });
		
	}
	
	public void actionPerformed(ActionEvent e) {}
	


	public static void main(String[] args){
		new StudentDashboard();
	}
}
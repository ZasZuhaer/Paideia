import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
//import java.io.File;
import javax.imageio.ImageIO;

public class TeacherDashboard implements ActionListener {

	String teacherName = "Zuhaer";

	JFrame dashFrame;
	BufferedImage dashImage;
	JButton allCoursesBtn, languageBtn, designBtn, professionalBtn, freelancingBtn;
	JButton myCoursesBtn, supportBtn, userMenuBtn, addCourseBtn;

	PaideiaDB teacher_courses = new PaideiaDB("teacher_courses");

	AddCourseFuncs addcrs = new AddCourseFuncs();

	public TeacherDashboard() {

		// creating dashboard objects
		dashFrame = new JFrame("Student | Paideia");
		// buttons
		allCoursesBtn = new JButton("All Courses");
		languageBtn = new JButton("Language");
		designBtn = new JButton("Design");
		professionalBtn = new JButton("Professional");
		freelancingBtn = new JButton("Freelancing");
		myCoursesBtn = new JButton("My Courses");
		supportBtn = new JButton("Support");
		addCourseBtn = new JButton("Add Course");
		userMenuBtn = new JButton("UserMenuImage");

		// setting positions for buttons
		allCoursesBtn.setBounds(100, 100, 100, 50);
		designBtn.setBounds(200, 100, 100, 50);
		languageBtn.setBounds(300, 100, 100, 50);
		professionalBtn.setBounds(400, 100, 100, 50);
		myCoursesBtn.setBounds(100, 200, 100, 50);
		freelancingBtn.setBounds(300, 100, 100, 50);
		supportBtn.setBounds(100, 400, 100, 50);
		addCourseBtn.setBounds(100, 600, 100, 50);
		userMenuBtn.setBounds(100, 500, 100, 50);

		// adding action listener to buttons
		allCoursesBtn.addActionListener(this);
		designBtn.addActionListener(this);
		languageBtn.addActionListener(this);
		professionalBtn.addActionListener(this);
		myCoursesBtn.addActionListener(this);
		freelancingBtn.addActionListener(this);
		supportBtn.addActionListener(this);
		userMenuBtn.addActionListener(this);
		addCourseBtn.addActionListener(this);

		// adding background image on dashFrame
		try {
			dashImage = ImageIO.read(getClass().getResource("Images/TeacherDashboard.PNG"));
			dashFrame.setContentPane(new ImagePanel(dashImage));
		} catch (Exception e) {
			System.out.println(e);
		}

		// adding components to dashFrame
		dashFrame.add(allCoursesBtn);
		dashFrame.add(designBtn);
		dashFrame.add(languageBtn);
		dashFrame.add(professionalBtn);
		dashFrame.add(freelancingBtn);
		dashFrame.add(myCoursesBtn);
		dashFrame.add(supportBtn);
		dashFrame.add(userMenuBtn);
		dashFrame.add(addCourseBtn);

		// dashFrame default configurations
		dashFrame.setSize(1366, 768);
		dashFrame.setLayout(null);
		dashFrame.setLocationRelativeTo(null);
		dashFrame.setVisible(true);
		// performing manual close operation on dashFrame
		dashFrame.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				teacher_courses.close(); // closing database connection
				System.out.println("Database closed from dashboardt");
				System.exit(0); // closing dashFrame
			}
		});

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == addCourseBtn) {
			new AddCourseDecor(dashFrame, addcrs);
			addcrs.addCourseBtn.addActionListener(this);
		}

		if (e.getSource() == addcrs.addCourseBtn) {
			if (addcrs.checkTitle(dashFrame, addcrs)) {
				if (addcrs.checkDescription(dashFrame, addcrs)) {
					if (addcrs.checkPrice(dashFrame, addcrs)) {
						String title = addcrs.titleTF.getText();
						String category = addcrs.categoryCB.getSelectedItem().toString();
						String description = addcrs.descriptionTF.getText();
						int price = Integer.parseInt(addcrs.priceTF.getText());
						String instructor = teacherName;

						teacher_courses.addCourse(title, category, description, price, instructor);
						addcrs.DataVerificationMsg.setText("Course Added!");
						addcrs.titleTF.setText("");
						addcrs.descriptionTF.setText("");
						addcrs.priceTF.setText("");
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		new TeacherDashboard();
	}
}
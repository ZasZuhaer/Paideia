import java.awt.Color;
import java.awt.Font;
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
		allCoursesBtn.setBounds(40, 210, 180, 40);
		designBtn.setBounds(40, 330, 180, 40);
		languageBtn.setBounds(40, 270, 180, 40);
		professionalBtn.setBounds(40, 390, 180, 40);
		myCoursesBtn.setBounds(850, 28, 100, 40);
		freelancingBtn.setBounds(40, 460, 180, 40);
		supportBtn.setBounds(1153, 28, 100, 40);
		addCourseBtn.setBounds(1000, 28, 110, 40);
		// userMenuBtn.setBounds(100, 100, 100, 50);

		// Setting Font and Color
		allCoursesBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		allCoursesBtn.setBackground(new Color(55, 54, 116));
		allCoursesBtn.setForeground(Color.WHITE);

		designBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		designBtn.setBackground(new Color(55, 54, 116));
		designBtn.setForeground(Color.WHITE);

		freelancingBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		freelancingBtn.setBackground(new Color(55, 54, 116));
		freelancingBtn.setForeground(Color.WHITE);

		professionalBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		professionalBtn.setBackground(new Color(55, 54, 116));
		professionalBtn.setForeground(Color.WHITE);

		languageBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		languageBtn.setBackground(new Color(55, 54, 116));
		languageBtn.setForeground(Color.WHITE);

		addCourseBtn.setFont(new Font("Poppins", Font.PLAIN, 10));
		addCourseBtn.setBackground(Color.WHITE);
		addCourseBtn.setForeground(new Color(55, 54, 116));

		supportBtn.setFont(new Font("Poppins", Font.PLAIN, 10));
		supportBtn.setBackground(Color.WHITE);
		supportBtn.setForeground(new Color(55, 54, 116));

		myCoursesBtn.setFont(new Font("Poppins", Font.PLAIN, 10));
		myCoursesBtn.setBackground(Color.WHITE);
		myCoursesBtn.setForeground(new Color(55, 54, 116));

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
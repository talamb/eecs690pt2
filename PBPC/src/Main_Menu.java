import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Main_Menu {

	private JFrame frmMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Menu window = new Main_Menu();
					window.frmMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.getContentPane().setBackground(Color.WHITE);
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(Main_Menu.class.getResource("/General_Images/GI_icon.png")));
		frmMainMenu.setBounds(100, 100, 800, 600);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New Client");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(412, 211, 187, 118);
		frmMainMenu.getContentPane().add(btnNewButton);
		
		JButton btnExsistingClient = new JButton("Exsisting Client");
		btnExsistingClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnExsistingClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExsistingClient.setBounds(163, 211, 187, 118);
		frmMainMenu.getContentPane().add(btnExsistingClient);
		
		JButton btnProductSale = new JButton("Product Sale");
		btnProductSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnProductSale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnProductSale.setBounds(54, 353, 187, 118);
		frmMainMenu.getContentPane().add(btnProductSale);
		
		JButton btnBoarderCalender = new JButton("Boarder Calender");
		btnBoarderCalender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnBoarderCalender.setText("<html><center>"+"Boarder"+"<br>"+"Calender"+"</center></html>");
		btnBoarderCalender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBoarderCalender.setBounds(525, 353, 187, 118);
		frmMainMenu.getContentPane().add(btnBoarderCalender);
		
		JButton btnAppointments = new JButton("Appointments");
		btnAppointments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnAppointments.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAppointments.setBounds(291, 353, 187, 118);
		frmMainMenu.getContentPane().add(btnAppointments);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Main_Menu.class.getResource("/General_Images/Logo.jpg")));
		lblNewLabel.setBounds(220, 26, 303, 136);
		frmMainMenu.getContentPane().add(lblNewLabel);
	}
}

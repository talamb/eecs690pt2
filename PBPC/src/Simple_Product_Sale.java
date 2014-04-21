import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Simple_Product_Sale {

	private JFrame frmSimpleSale;
	public static JList<Tickets> ticketList;
	public static DefaultListModel<Tickets> ticketListModel;
	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					Simple_Product_Sale window = new Simple_Product_Sale();
					window.frmSimpleSale.setVisible(true);
					PopulateTicket();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the application.
	 */
	public Simple_Product_Sale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSimpleSale = new JFrame();
		frmSimpleSale.setBounds(100, 100, 573, 486);
		frmSimpleSale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSimpleSale.getContentPane().setLayout(null);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Simple_Product_Sale.ClearTicket();
				}
				catch(Exception e1)
				{}
					frmSimpleSale.dispose();
			}
		});
		btnMainMenu.setBounds(10, 414, 89, 23);
		frmSimpleSale.getContentPane().add(btnMainMenu);
		
		JButton btnFelineProducts = new JButton("Feline Products");
		btnFelineProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FelineProducts.run();
				//frmSimpleSale.dispose();
			}
			
		});
		btnFelineProducts.setBounds(374, 36, 128, 56);
		frmSimpleSale.getContentPane().add(btnFelineProducts);
		
		JButton btnCanineProducts = new JButton("Canine Products");
		btnCanineProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				CanineProducts.run();
			//	frmSimpleSale.dispose();
			}
		});
		btnCanineProducts.setBounds(374, 103, 128, 56);
		frmSimpleSale.getContentPane().add(btnCanineProducts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 71, 245, 239);
		frmSimpleSale.getContentPane().add(scrollPane);
		
		ticketList = new JList<Tickets>();
		ticketList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(ticketList);
		JLabel lblCurrentTicket = new JLabel("Current Ticket:");
		lblCurrentTicket.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCurrentTicket.setBounds(54, 15, 186, 45);
		frmSimpleSale.getContentPane().add(lblCurrentTicket);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemoveFromTicket();
			}
		});
		btnRemove.setBounds(81, 321, 89, 23);
		frmSimpleSale.getContentPane().add(btnRemove);
		
		JButton btnCashout = new JButton("Cashout");
		btnCashout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cashout_Screen.run();
				frmSimpleSale.dispose();
			}
		});
		btnCashout.setBounds(296, 384, 89, 23);
		frmSimpleSale.getContentPane().add(btnCashout);
	}
	
	
	public static void InsertItem(int item_id, String item_name, double item_price)
	{
	String commandText = "INSERT INTO SingleSale (ID,Service,Price)" +
	"VALUES ('" + item_id + "', '" +
	item_name + "', '" + item_price +
	"')";
	SQL.UpdateResultSet(commandText);
	PopulateTicket();

	}
	
	public static void PopulateTicket()
	{

	ticketListModel = new DefaultListModel<Tickets>();
	String commandText = "SELECT * from SingleSale";
	ResultSet rs = SQL.ExecuteResultSet(commandText);
	double price = 0;
	String name = "";
	try {
	while ((rs!=null) && (rs.next()))
	{	
	name = rs.getString("Service");
	price = rs.getDouble("Price");
	Tickets tick = new Tickets(name,price);	
	ticketListModel.addElement(tick);

	}
	}
	catch (SQLException e)
	{
	JOptionPane.showMessageDialog(null, e.toString());
	}

	ticketList.setModel(ticketListModel);


	}
	
	public static void RemoveFromTicket()
	{
		Connection.Connect();
		Tickets tmp = ticketList.getSelectedValue();
		String name = tmp.getitem();
		//System.out.println(name);
		//String commandText = "DELETE FROM SingleSale WHERE Service = " + "'" + name + "'" + "LIMIT 1";
		String commandText = "DELETE FROM SingleSale WHERE SingleSale.Service = (SELECT Service FROM SingleSale WHERE Service = " + "'" + name + "' LIMIT 1)";
		SQL.UpdateResultSet(commandText);
		PopulateTicket();
	}
	
	
	public static void ClearTicket()
	{
		Connection.Connect();
		
		String commandText = "DELETE FROM SingleSale";
		SQL.UpdateResultSet(commandText);
		PopulateTicket();
	}
}
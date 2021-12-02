package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logical.Client;
import Logical.Shop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Sale extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField Nametxt;
	private JTextField Addresstxt;
	private JTextField IDtxt;
	private JTextField Phonetxt;
	private JTextField SalesCodetxt;
	private JTextField ProductCodetxt;
	private JTable table;
	private static DefaultTableModel model;
	private static int type;
	
	private Client client = null;
	private JTextField Totaltopaytxt;

	public Sale() {
		setTitle("Sale");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 850, 751);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Name:");
		lblNewLabel.setBounds(38, 30, 100, 25);
		contentPanel.add(lblNewLabel);
		
		Nametxt = new JTextField();
		Nametxt.setBounds(38, 60, 150, 25);
		contentPanel.add(Nametxt);
		Nametxt.setColumns(10);
		
		JLabel lblCustomerAddress = new JLabel("Customer Address:");
		lblCustomerAddress.setBounds(38, 90, 150, 25);
		contentPanel.add(lblCustomerAddress);
		
		Addresstxt = new JTextField();
		Addresstxt.setColumns(10);
		Addresstxt.setBounds(38, 120, 400, 25);
		contentPanel.add(Addresstxt);
		
		IDtxt = new JTextField();
		IDtxt.setColumns(10);
		IDtxt.setBounds(288, 60, 150, 25);
		contentPanel.add(IDtxt);
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setBounds(288, 30, 100, 25);
		contentPanel.add(lblCustomerId);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(38, 150, 150, 25);
		contentPanel.add(lblPhoneNumber);
		
		Phonetxt = new JTextField();
		Phonetxt.setColumns(10);
		Phonetxt.setBounds(38, 180, 150, 25);
		contentPanel.add(Phonetxt);
		
		SalesCodetxt = new JTextField();
		SalesCodetxt.setColumns(10);
		SalesCodetxt.setBounds(288, 180, 150, 25);
		contentPanel.add(SalesCodetxt);
		
		JLabel lblSalesCode = new JLabel("Sales Code:");
		lblSalesCode.setBounds(288, 150, 150, 25);
		contentPanel.add(lblSalesCode);
		
		JButton FindCustomerbtn = new JButton("Find");
		FindCustomerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client clientaux = Shop.getInstance().FindCustomerByID(IDtxt.getText());
				//Find customer function by ID
				if(clientaux !=null) {
					Nametxt.setText(clientaux.getName());
					Addresstxt.setText(clientaux.getAddress());
					IDtxt.setEditable(false);
					Phonetxt.setText(clientaux.getPhone());
					JOptionPane.showMessageDialog(null, "Customer Found");
					client = clientaux;
				}
				if(clientaux == null) {
					JOptionPane.showMessageDialog(null, "Customer not found, please add customer info", "Error", JOptionPane.OK_OPTION);
					Nametxt.setEditable(true);
					Addresstxt.setEditable(true);
					Phonetxt.setEditable(true);
					FindCustomerbtn.setVisible(false);
				}
			}
		});
		FindCustomerbtn.setBounds(320, 92, 85, 21);
		contentPanel.add(FindCustomerbtn);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Order", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 228, 826, 434);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblProductCode = new JLabel("Product Code:");
		lblProductCode.setBounds(28, 30, 150, 25);
		panel.add(lblProductCode);
		
		ProductCodetxt = new JTextField();
		ProductCodetxt.setColumns(10);
		ProductCodetxt.setBounds(28, 60, 150, 25);
		panel.add(ProductCodetxt);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 125, 806, 299);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel();
		String[] headers = {"Product Code","Description","Price","Quantity","Total"};
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JButton FindProductsbtn = new JButton("Product List");
		FindProductsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Products openlist = new Products();
				openlist.setVisible(true);
			}
		});
		FindProductsbtn.setBounds(188, 62, 120, 21);
		panel.add(FindProductsbtn);
		
		JButton Removecartbtn = new JButton("Remove");
		Removecartbtn.setBounds(188, 92, 120, 21);
		panel.add(Removecartbtn);
		
		JButton NewQuotebtn = new JButton("CREATE QUOTE");
		NewQuotebtn.setBounds(483, 31, 150, 83);
		contentPanel.add(NewQuotebtn);
		
		JButton PrintQuotebtn = new JButton("PRINT QUOTE");
		PrintQuotebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PrintQuotebtn.setBounds(657, 30, 150, 83);
		contentPanel.add(PrintQuotebtn);
		
		JButton btnConfirmSale = new JButton("CONFIRM SALE");
		btnConfirmSale.setBounds(483, 135, 150, 83);
		contentPanel.add(btnConfirmSale);
		
		JButton CancelOrderbtn = new JButton("CANCEL ORDER");
		CancelOrderbtn.setBounds(657, 135, 150, 83);
		contentPanel.add(CancelOrderbtn);
		
		JLabel lblAmotToPay = new JLabel("Amount to Pay Today:");
		lblAmotToPay.setBounds(288, 672, 150, 25);
		contentPanel.add(lblAmotToPay);
		
		Totaltopaytxt = new JTextField();
		Totaltopaytxt.setColumns(10);
		Totaltopaytxt.setBounds(433, 672, 96, 25);
		contentPanel.add(Totaltopaytxt);
		
		JLabel lblAmotToPay_1 = new JLabel("Payment Method:");
		lblAmotToPay_1.setBounds(539, 672, 114, 25);
		contentPanel.add(lblAmotToPay_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<<Selection>>", "CASH", "CREDIT"}));
		comboBox.setBounds(657, 672, 150, 25);
		contentPanel.add(comboBox);
		setLocationRelativeTo(null);
	}
}

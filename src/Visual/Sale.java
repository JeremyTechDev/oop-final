package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;

public class Sale extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField Nametxt;
	private JTextField Addresstxt;
	private JTextField IDtxt;
	private JTextField Phonetxt;
	private JTextField SalesCodetxt;
	private JTextField ProductCodetxt;
	private JTextField pricetxt;
	private JTextField Taxtxt;
	private JTextField Totaltopaytxt;
	private JTable table;
	private static DefaultTableModel model;

	public Sale() {
		setTitle("Sale");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 850, 627);
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
		
		JButton Findbtn = new JButton("Find");
		Findbtn.setBounds(320, 92, 85, 21);
		contentPanel.add(Findbtn);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Order", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 228, 826, 359);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblProductCode = new JLabel("Product Code:");
		lblProductCode.setBounds(28, 30, 150, 25);
		panel.add(lblProductCode);
		
		ProductCodetxt = new JTextField();
		ProductCodetxt.setColumns(10);
		ProductCodetxt.setBounds(28, 60, 150, 25);
		panel.add(ProductCodetxt);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(28, 90, 150, 25);
		panel.add(lblQuantity);
		
		JSpinner Quantitytxt = new JSpinner();
		Quantitytxt.setBounds(28, 120, 150, 25);
		panel.add(Quantitytxt);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(28, 150, 150, 25);
		panel.add(lblPrice);
		
		pricetxt = new JTextField();
		pricetxt.setColumns(10);
		pricetxt.setBounds(28, 180, 150, 25);
		panel.add(pricetxt);
		
		JLabel lblTax = new JLabel("Tax:");
		lblTax.setBounds(28, 210, 150, 25);
		panel.add(lblTax);
		
		Taxtxt = new JTextField();
		Taxtxt.setColumns(10);
		Taxtxt.setBounds(28, 240, 150, 25);
		panel.add(Taxtxt);
		
		JLabel lblAmountToPay = new JLabel("Amount to pay:");
		lblAmountToPay.setBounds(28, 270, 150, 25);
		panel.add(lblAmountToPay);
		
		Totaltopaytxt = new JTextField();
		Totaltopaytxt.setColumns(10);
		Totaltopaytxt.setBounds(28, 300, 150, 25);
		panel.add(Totaltopaytxt);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(302, 45, 514, 304);
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
		
		JButton Addcartbtn = new JButton("Add to Cart");
		Addcartbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Addcartbtn.setBounds(188, 62, 100, 21);
		panel.add(Addcartbtn);
		
		JButton Removecartbtn = new JButton("Remove");
		Removecartbtn.setBounds(188, 92, 100, 21);
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
		setLocationRelativeTo(null);
	}
}

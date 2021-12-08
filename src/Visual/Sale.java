package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logical.Client;
import Logical.Component;
import Logical.HardDisk;
import Logical.Invoice;
import Logical.Microprocessor;
import Logical.Motherboard;
import Logical.Quote;
import Logical.RamCard;
import Logical.Shop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Sale extends JDialog {

	public static ArrayList<Component> addtocart = null;
	private static Component selected = null;
	private ArrayList<Component> components;

	public static Invoice OrderCompleted = null;

	private final JPanel contentPanel = new JPanel();
	private JTextField Nametxt;
	private JTextField Addresstxt;
	private JTextField IDtxt;
	private JTextField Phonetxt;
	private JTextField SalesCodetxt;
	private JTextField ProductCodetxt;
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rowProduct;
	private static int type;

	private Client client = null;
	private static JTextField Totaltopaytxt;
	private JButton Removecartbtn;
	private JComboBox PaymentMethodcbx;

	public Sale() {

		addtocart = new ArrayList<Component>();

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
		SalesCodetxt.setHorizontalAlignment(SwingConstants.CENTER);
		SalesCodetxt.setEditable(false);
		SalesCodetxt.setColumns(10);
		SalesCodetxt.setBounds(288, 180, 150, 25);
		SalesCodetxt.setText(" JC - " + Shop.getInstance().getInvoices().size());
		contentPanel.add(SalesCodetxt);

		JLabel lblSalesCode = new JLabel("Sales Code:");
		lblSalesCode.setBounds(288, 150, 150, 25);
		contentPanel.add(lblSalesCode);

		JButton FindCustomerbtn = new JButton("Find");
		FindCustomerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client clientaux = Shop.getInstance().FindCustomerByID(IDtxt.getText());
				// Find customer function by ID
				if (clientaux != null) {
					Nametxt.setText(clientaux.getName());
					Addresstxt.setText(clientaux.getAddress());
					IDtxt.setEditable(false);
					Phonetxt.setText(clientaux.getPhone());
					JOptionPane.showMessageDialog(null, "Customer Found");
					client = clientaux;
				}
				if (clientaux == null) {
					JOptionPane.showMessageDialog(null, "Customer not found, please add customer info", "Error",
							JOptionPane.OK_OPTION);
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
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 125, 806, 299);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int select = -1;
				if (table.isEnabled()) {
					select = table.getSelectedRow();
					selected = Shop.getInstance().getComponentBySerial(table.getValueAt(select, 0).toString());
					Removecartbtn.setEnabled(true);
				}
			}
		});

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return rootPaneCheckingEnabled;
			}
		};
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);

		model = new DefaultTableModel();
		String[] headers = { "Product Code", "Description", "Price", "Quantity", "Total" };
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		JButton FindProductsbtn = new JButton("Product List");
		FindProductsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Products productlist = new Products(true, false);
				Component component = productlist.showDialog();
				if (component != null) {
					addtocart.add(component);
					LoadCart();
				}

			}
		});
		FindProductsbtn.setBounds(188, 62, 120, 21);
		panel.add(FindProductsbtn);

		Removecartbtn = new JButton("Remove");
		Removecartbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component a = null;
				if (selected != null) {
					for (Component x : addtocart) {
						if (x.getSerialNumber().equals(selected.getSerialNumber())) {
							a = x;
						}
					}
					addtocart.remove(a);
					Shop.getInstance().changeCompQuantity(a.getSerialNumber(), a.getQuantity());
					LoadCart();
				}
			}
		});
		Removecartbtn.setBounds(188, 92, 120, 21);
		panel.add(Removecartbtn);

		JButton NewQuotebtn = new JButton("");
		NewQuotebtn.setBackground(Color.WHITE);
		NewQuotebtn.setIcon(new ImageIcon(Sale.class.getResource("/Icons/Quotebtn.png")));
		NewQuotebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean quotecompleted = QuoteDone();
				if (quotecompleted) {
					Quote quot = new Quote(SalesCodetxt.getText(), Nametxt.getText(), IDtxt.getText(),
							Totaltopaytxt.getText(), PaymentMethodcbx.toString());
					Shop.getInstance().AddQuote(quot);
					JOptionPane.showMessageDialog(null, "Quotation Completed");
					clear();
				} else {
					JOptionPane.showMessageDialog(null, "Please fill all the fields", "ERROR", JOptionPane.OK_OPTION);
				}
			}

		});
		NewQuotebtn.setBounds(657, 30, 150, 83);
		contentPanel.add(NewQuotebtn);
		// Order Option
		JButton btnConfirmSale = new JButton("");
		btnConfirmSale.setIcon(new ImageIcon(Sale.class.getResource("/Icons/Sale.png")));
		btnConfirmSale.setBackground(Color.WHITE);
		btnConfirmSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean salecompleted = SaleDone();
				if (salecompleted) {
					Invoice inv = new Invoice(SalesCodetxt.getText(), Nametxt.getText(), IDtxt.getText(),
							Totaltopaytxt.getText(), PaymentMethodcbx.getSelectedItem().toString(), null);
					Client client = new Client(IDtxt.getText(), Nametxt.getText(),Addresstxt.getText(), Phonetxt.getText(),null);
					Shop.getInstance().AddInvoice(inv);
					Shop.getInstance().AddCustomer(client);
					JOptionPane.showMessageDialog(null, "Sale Completed");
					clear();
					DecreaseStock();
				} else {
					JOptionPane.showMessageDialog(null, "Please fill all the fields", "ERROR", JOptionPane.OK_OPTION);
				}
			}

		});
		btnConfirmSale.setBounds(483, 30, 150, 188);
		contentPanel.add(btnConfirmSale);

		JButton CancelOrderbtn = new JButton("");
		CancelOrderbtn.setBackground(Color.WHITE);
		CancelOrderbtn.setIcon(new ImageIcon(Sale.class.getResource("/Icons/Cancelbtn.png")));
		CancelOrderbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Would you like to cancel this order?", "Confirmation",
						JOptionPane.WARNING_MESSAGE);
				if (JOptionPane.YES_OPTION == option) {
					dispose();
				}
			}
		});
		CancelOrderbtn.setBounds(657, 135, 150, 83);
		contentPanel.add(CancelOrderbtn);

		JLabel lblAmotToPay = new JLabel("Amount to Pay Today:");
		lblAmotToPay.setBounds(288, 672, 150, 25);
		contentPanel.add(lblAmotToPay);

		Totaltopaytxt = new JTextField();
		Totaltopaytxt.setText("RD$ ");
		Totaltopaytxt.setEditable(false);
		Totaltopaytxt.setColumns(10);
		Totaltopaytxt.setBounds(433, 672, 96, 25);
		contentPanel.add(Totaltopaytxt);

		JLabel lblAmotToPay_1 = new JLabel("Payment Method:");
		lblAmotToPay_1.setBounds(539, 672, 114, 25);
		contentPanel.add(lblAmotToPay_1);

		PaymentMethodcbx = new JComboBox();
		PaymentMethodcbx.setModel(new DefaultComboBoxModel(new String[] { "<<Selection>>", "CASH", "CREDIT" }));
		PaymentMethodcbx.setBounds(657, 672, 150, 25);
		contentPanel.add(PaymentMethodcbx);
		setLocationRelativeTo(null);

	}

	// Add to cart Option // Still missing some adjustments like add the entire
	// description
	public static void LoadCart() {
		// TODO Auto-generated method stub
		rowProduct = new Object[model.getColumnCount()];
		float TotalAmount = (float) 0.00;
		model.setRowCount(0);
		if (addtocart.size() != 0) {
			for (Component i : addtocart) {
				rowProduct[0] = i.getSerialNumber();
				if (i instanceof Component) {
					rowProduct[1] = "Component";
					rowProduct[2] = i.getPrice();
					rowProduct[3] = i.getQuantity();
					rowProduct[4] = "RD$ " + i.getQuantity() * i.getPrice();
					TotalAmount += i.getQuantity() * i.getPrice();
					model.addRow(rowProduct);
				}
			}
		}
		Totaltopaytxt.setText("RD$ " + TotalAmount);
	}

	// Confirm invoice
	public boolean SaleDone() {
		boolean aux = false;
		if (!(SalesCodetxt.getText().equalsIgnoreCase("")) && !(Nametxt.getText().equalsIgnoreCase(""))
				&& !(IDtxt.getText().equalsIgnoreCase("")) && !(Totaltopaytxt.getText().equalsIgnoreCase(""))
				&& !(PaymentMethodcbx.getSelectedItem().toString().equalsIgnoreCase(""))) {
			aux = true;
		}
		return aux;
	}

	// DecreaseStock function
	private void DecreaseStock() {

	}

	// Confirm Quote
	private boolean QuoteDone() {
		boolean aux = false;
		if (!(SalesCodetxt.getText().equalsIgnoreCase("")) && !(Nametxt.getText().equalsIgnoreCase(""))
				&& !(IDtxt.getText().equalsIgnoreCase("")) && !(Totaltopaytxt.getText().equalsIgnoreCase(""))
				&& !(PaymentMethodcbx.getSelectedItem().toString().equalsIgnoreCase(""))) {
			aux = true;
		}
		return aux;
	}

	// option to clear sale page
	private void clear() {

		SalesCodetxt.setText(" JC - " + Shop.getInstance().getInvoices().size());
		Nametxt.setText(" ");
		IDtxt.setText(" ");
		Addresstxt.setText(" ");
		Phonetxt.setText(" ");
		Totaltopaytxt.setText("RD$ ");
		PaymentMethodcbx.setSelectedIndex(0);
	}
}

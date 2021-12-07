package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logical.Client;
import Logical.Invoice;
import Logical.Shop;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class SaleHistory extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable InvoiceTable;
	private static DefaultTableModel model;
	private static Object[] rowInvoice;

	public SaleHistory() {
		setTitle("Sale History");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 701, 517);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Invoice ID:");
		lblNewLabel.setBounds(25, 41, 90, 20);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(88, 39, 130, 25);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(25, 82, 647, 350);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		InvoiceTable = new JTable();
		model = new DefaultTableModel();
		scrollPane.setViewportView(InvoiceTable);
		String[] headers = { "Invoice Number", "Customer Name","Customer ID", "Amount", "Payment Method" };
		model.setColumnIdentifiers(headers);
		InvoiceTable.setModel(model);
		InvoiceTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			loadTable();
		}
	}
	//Load Invoices Table
	private void loadTable() {
			model.setRowCount(0);
			rowInvoice = new Object[(model.getColumnCount())];
			for (Invoice i: Shop.getInstance().getInvoices()) {
				rowInvoice[0] = i.getCode();
				rowInvoice[1] = i.getClient();
				rowInvoice[2] = i.getCustomerID();
				rowInvoice[3] = i.getTotalPrice();
				rowInvoice[4] = i.getPaymentType();

				model.addRow(rowInvoice);
	}
	}
	}

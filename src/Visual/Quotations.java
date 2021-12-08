package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logical.Invoice;
import Logical.Quote;
import Logical.Shop;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Quotations extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rowQuote;

	public Quotations() {
		setTitle("Quotations");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 770, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 100, 734, 400);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();
					table.setColumnSelectionAllowed(true);
					scrollPane.setViewportView(table);
					
					model = new DefaultTableModel();
					String[] headers = {"Invoice Number", "Customer Name","Customer ID", "Amount", "Payment Method"};
					model.setColumnIdentifiers(headers);
					table.setModel(model);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JButton btnCompleteSale = new JButton("MAKE ORDER");
			btnCompleteSale.setBounds(325, 11, 129, 79);
			contentPanel.add(btnCompleteSale);
		}
		{
			JButton DeleteQuotebtn = new JButton("DELETE QUOTE");
			DeleteQuotebtn.setBounds(464, 11, 129, 79);
			contentPanel.add(DeleteQuotebtn);
		}
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(615, 11, 129, 79);
		contentPanel.add(btnCancel);
		LoadTable();
	}

	private void LoadTable() {
		model.setRowCount(0);
		rowQuote = new Object[(model.getColumnCount())];
		for (Quote i: Shop.getInstance().getQuotations()) {
			rowQuote[0] = i.getCode();
			rowQuote[1] = i.getClient();
			rowQuote[2] = i.getCustomerID();
			rowQuote[3] = i.getTotalPrice();
			rowQuote[4] = i.getPaymentType();

			model.addRow(rowQuote);
}
	}
}

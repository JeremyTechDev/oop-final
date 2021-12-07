package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logical.Client;
import Logical.Provider;
import Logical.Shop;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;


public class CustomerList extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;

	public CustomerList() {
		setTitle("Customer List");
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		setBounds(100, 100, 710, 510);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 10, 676, 452);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			
			model = new DefaultTableModel();
			String[] headers = {"Customer Name","Customer ID","Address","Phone Number","Credit Limit"};
			model.setColumnIdentifiers(headers);
			table.setModel(model);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(table);
		}
		loadTable();
	}
	public static void loadTable() {
		model.setRowCount(0);
		row = new Object[(model.getColumnCount())];
		for (Client x: Shop.getInstance().getClients()) {
			row[0] = x.getId();
			row[1] = x.getName();
			row[2] = x.getAddress();
			row[3] = x.getPhone();
			row[4] = x.getCreditLimit();

			model.addRow(row);
		}
	}
}

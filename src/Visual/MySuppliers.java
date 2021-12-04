package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logical.Component;
import Logical.Provider;
import Logical.Shop;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class MySuppliers extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;

	public MySuppliers() {
		setBounds(100, 100, 710, 510);
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 10, 676, 452);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();
					table.setColumnSelectionAllowed(true);
					scrollPane.setViewportView(table);

					model = new DefaultTableModel();
					String[] headers = { "Supplier Name", "Supplier RNC", "Phone Number", "Address"};
					model.setColumnIdentifiers(headers);
					table.setModel(model);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
				}
			}
		}

		loadTable();
	}

	public static void loadTable() {
		model.setRowCount(0);
		row = new Object[(model.getColumnCount())];
		for (Provider i: Shop.getInstance().getProviders()) {
			row[0] = i.getName();
			row[1] = i.getRnc();
			row[2] = i.getPhone();
			row[3] = i.getAddress();

			model.addRow(row);
		}
	}
}

package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class Quotations extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;

	public Quotations() {
		setTitle("Quotations");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 710, 509);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 100, 676, 362);
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
					String[] headers = {"Date","Customer Code","Customer Name","Total to Pay"};
					model.setColumnIdentifiers(headers);
					table.setModel(model);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JButton PrintQuotebtn = new JButton("PRINT QUOTE");
			PrintQuotebtn.setBounds(418, 11, 129, 79);
			contentPanel.add(PrintQuotebtn);
		}
		{
			JButton btnCompleteSale = new JButton("MAKE ORDER");
			btnCompleteSale.setBounds(140, 11, 129, 79);
			contentPanel.add(btnCompleteSale);
		}
		{
			JButton DeleteQuotebtn = new JButton("DELETE QUOTE");
			DeleteQuotebtn.setBounds(557, 11, 129, 79);
			contentPanel.add(DeleteQuotebtn);
		}
		{
			JButton EditQuotebtn = new JButton("EDIT QUOTE");
			EditQuotebtn.setBounds(279, 11, 129, 79);
			contentPanel.add(EditQuotebtn);
		}
		setLocationRelativeTo(null);
	}

}

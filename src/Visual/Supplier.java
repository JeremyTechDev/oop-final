package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Supplier extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField SupliNametxt;
	private JTextField SupliRNCtxt;
	private JTextField SupliPhonetxt;
	private JTextField SupliAddresstxt;

	public Supplier() {
		setBounds(100, 100, 461, 316);
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(30, 30, 100, 21);
		contentPanel.add(lblNewLabel);
		
		SupliNametxt = new JTextField();
		SupliNametxt.setBounds(30, 60, 175, 25);
		contentPanel.add(SupliNametxt);
		SupliNametxt.setColumns(10);
		
		JLabel lblRnc = new JLabel("RNC:");
		lblRnc.setBounds(240, 30, 100, 21);
		contentPanel.add(lblRnc);
		
		SupliRNCtxt = new JTextField();
		SupliRNCtxt.setColumns(10);
		SupliRNCtxt.setBounds(240, 60, 175, 25);
		contentPanel.add(SupliRNCtxt);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(30, 90, 100, 21);
		contentPanel.add(lblPhoneNumber);
		
		SupliPhonetxt = new JTextField();
		SupliPhonetxt.setColumns(10);
		SupliPhonetxt.setBounds(30, 120, 175, 25);
		contentPanel.add(SupliPhonetxt);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(30, 150, 100, 21);
		contentPanel.add(lblAddress);
		
		SupliAddresstxt = new JTextField();
		SupliAddresstxt.setColumns(10);
		SupliAddresstxt.setBounds(30, 180, 385, 25);
		contentPanel.add(SupliAddresstxt);
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
		}
	}
}

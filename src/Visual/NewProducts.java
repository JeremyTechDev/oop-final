package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logical.Component;
import Logical.HardDisk;
import Logical.Microprocessor;
import Logical.Motherboard;
import Logical.Provider;
import Logical.RamCard;
import Logical.Shop;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class NewProducts extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton Rambtn;
	private JRadioButton StorageDiskbtn;
	private JRadioButton Microprocessorsbtn;
	private JRadioButton Motherboardbtn;
	private JPanel MotherboardPanel;
	private JPanel MicroprocessorsPanel;
	private JPanel StorageDiskPanel;
	private JPanel RamPanel;
	private JTextField rncTxt;
	private JTextField nameTxt;
	private JTextField addressTxt;
	private JTextField phoneTxt;
	private JTextField textField;
	private JComboBox methodTxt;
	private JSpinner minTxt;
	private JSpinner priceTxt;
	private JSpinner quantityTxt;

	private Provider provider = null;
	private JComboBox MBManufacturercbx;
	private JComboBox MBModelcbx;
	private JComboBox MBConectionTypecbx;
	private JComboBox MBRamTypecbx;
	private JTextField Serialtxt;

	public NewProducts() {
		setTitle("New Products");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 650, 573);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel StockProductspanel = new JPanel();
		StockProductspanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Stock",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		StockProductspanel.setBounds(30, 154, 585, 100);
		contentPanel.add(StockProductspanel);
		StockProductspanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Product Type:");
		lblNewLabel_1.setBounds(20, 22, 150, 25);
		StockProductspanel.add(lblNewLabel_1);

		Rambtn = new JRadioButton("Memory RAM");
		Rambtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RamPanel.setVisible(true);
				StorageDiskPanel.setVisible(false);
				MicroprocessorsPanel.setVisible(false);
				MotherboardPanel.setVisible(false);
				Rambtn.setSelected(true);
				StorageDiskbtn.setSelected(false);
				Microprocessorsbtn.setSelected(false);
				Motherboardbtn.setSelected(false);
			}
		});
		Rambtn.setBounds(446, 50, 133, 21);
		StockProductspanel.add(Rambtn);

		StorageDiskbtn = new JRadioButton("Storage Disk");
		StorageDiskbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RamPanel.setVisible(false);
				StorageDiskPanel.setVisible(true);
				MicroprocessorsPanel.setVisible(false);
				MotherboardPanel.setVisible(false);
				Rambtn.setSelected(false);
				StorageDiskbtn.setSelected(true);
				Microprocessorsbtn.setSelected(false);
				Motherboardbtn.setSelected(false);

			}
		});
		StorageDiskbtn.setBounds(156, 50, 138, 21);
		StockProductspanel.add(StorageDiskbtn);

		Microprocessorsbtn = new JRadioButton("Microprocessors");
		Microprocessorsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RamPanel.setVisible(false);
				StorageDiskPanel.setVisible(false);
				MicroprocessorsPanel.setVisible(true);
				MotherboardPanel.setVisible(false);
				Rambtn.setSelected(false);
				StorageDiskbtn.setSelected(false);
				Microprocessorsbtn.setSelected(true);
				Motherboardbtn.setSelected(false);
			}
		});
		Microprocessorsbtn.setBounds(298, 50, 150, 21);
		StockProductspanel.add(Microprocessorsbtn);

		Motherboardbtn = new JRadioButton("Motherboard");
		Motherboardbtn.setSelected(true);
		Motherboardbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RamPanel.setVisible(false);
				StorageDiskPanel.setVisible(false);
				MicroprocessorsPanel.setVisible(false);
				MotherboardPanel.setVisible(true);
				Rambtn.setSelected(false);
				StorageDiskbtn.setSelected(false);
				Microprocessorsbtn.setSelected(false);
				Motherboardbtn.setSelected(true);
			}
		});
		Motherboardbtn.setBounds(20, 50, 138, 21);
		StockProductspanel.add(Motherboardbtn);

		JLabel lblNewLabel_2_2 = new JLabel("Product Code:");
		lblNewLabel_2_2.setBounds(50, 378, 125, 13);
		contentPanel.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_1_2_1 = new JLabel("Order Quantity");
		lblNewLabel_2_1_2_1.setBounds(262, 378, 125, 13);
		contentPanel.add(lblNewLabel_2_1_2_1);

		MotherboardPanel = new JPanel();
		MotherboardPanel.setLayout(null);
		MotherboardPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Product Description", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		MotherboardPanel.setBounds(30, 266, 585, 100);
		contentPanel.add(MotherboardPanel);

		JLabel lblNewLabel_5 = new JLabel("Manufacturer:");
		lblNewLabel_5.setBounds(20, 29, 103, 21);
		MotherboardPanel.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("Model:");
		lblNewLabel_5_1.setBounds(147, 29, 103, 21);
		MotherboardPanel.add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_2 = new JLabel("Connection type:");
		lblNewLabel_5_2.setBounds(286, 29, 103, 21);
		MotherboardPanel.add(lblNewLabel_5_2);

		JLabel lblNewLabel_5_3 = new JLabel("Ram type:");
		lblNewLabel_5_3.setBounds(424, 29, 103, 21);
		MotherboardPanel.add(lblNewLabel_5_3);

		MBManufacturercbx = new JComboBox();
		MBManufacturercbx.setModel(new DefaultComboBoxModel(new String[] { "ASUS", "ASROCK", "GIGABYTE", "MSI" }));
		MBManufacturercbx.setBounds(20, 55, 115, 25);
		MotherboardPanel.add(MBManufacturercbx);

		MBModelcbx = new JComboBox();
		MBModelcbx.setModel(new DefaultComboBoxModel(
				new String[] { "B350", "B350H", "B450", "B450H", "B550", "B550H", "Z390", "Z490" }));
		MBModelcbx.setToolTipText("");
		MBModelcbx.setBounds(147, 55, 115, 25);
		MotherboardPanel.add(MBModelcbx);

		MBConectionTypecbx = new JComboBox();
		MBConectionTypecbx.setModel(new DefaultComboBoxModel(
				new String[] { "AM1", "AM4", "TRX", "TRX4", "LGA1150", "LGA1151", "LGA1200" }));
		MBConectionTypecbx.setBounds(286, 55, 115, 25);
		MotherboardPanel.add(MBConectionTypecbx);

		MBRamTypecbx = new JComboBox();
		MBRamTypecbx.setModel(new DefaultComboBoxModel(new String[] { "DDR", "DDR2", "DDR3", "DDR4" }));
		MBRamTypecbx.setBounds(424, 55, 124, 25);
		MotherboardPanel.add(MBRamTypecbx);

		MicroprocessorsPanel = new JPanel();
		MicroprocessorsPanel.setLayout(null);
		MicroprocessorsPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Product Description", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		MicroprocessorsPanel.setBounds(30, 266, 585, 100);
		contentPanel.add(MicroprocessorsPanel);

		JLabel lblNewLabel_6 = new JLabel("Manufacturer:");
		lblNewLabel_6.setBounds(20, 29, 103, 21);
		MicroprocessorsPanel.add(lblNewLabel_6);

		JComboBox PSMakecbx = new JComboBox();
		PSMakecbx.setModel(new DefaultComboBoxModel(new String[] { "INTEL", "AMD" }));
		PSMakecbx.setBounds(20, 55, 125, 25);
		MicroprocessorsPanel.add(PSMakecbx);

		JLabel lblNewLabel_6_1 = new JLabel("Model:");
		lblNewLabel_6_1.setBounds(170, 29, 103, 21);
		MicroprocessorsPanel.add(lblNewLabel_6_1);

		JLabel lblNewLabel_6_2 = new JLabel("Conection Type:");
		lblNewLabel_6_2.setBounds(320, 29, 103, 21);
		MicroprocessorsPanel.add(lblNewLabel_6_2);

		JLabel lblNewLabel_6_3 = new JLabel("Frequency (GHZ):");
		lblNewLabel_6_3.setBounds(470, 29, 103, 21);
		MicroprocessorsPanel.add(lblNewLabel_6_3);

		JComboBox PSModelcbx = new JComboBox();
		PSModelcbx.setModel(new DefaultComboBoxModel(new String[] { "AMD RYZEN 3", "AMD RYZEN 5 ", "AMD RYZEN 7",
				"AMD RYZEN 9", "INTEL I3", "INTEL I5 ", "INTEL I7", "INTEL I9" }));
		PSModelcbx.setBounds(166, 55, 125, 25);
		MicroprocessorsPanel.add(PSModelcbx);

		JComboBox PSConectionTypecbx = new JComboBox();
		PSConectionTypecbx.setModel(new DefaultComboBoxModel(
				new String[] { "AM1", "AM4", "TRX", "TRX4", "LGA1150", "LGA1151", "LGA1200" }));
		PSConectionTypecbx.setBounds(320, 55, 125, 25);
		MicroprocessorsPanel.add(PSConectionTypecbx);

		JComboBox PSFrequencycbx = new JComboBox();
		PSFrequencycbx.setModel(new DefaultComboBoxModel(new String[] { "2.7 GHZ", "2.9 GHZ", "3.0 GHZ", "3.6 GHZ",
				"3.7 GHZ", "3.8 GHZ", "4.0 GHZ", "4.2 GHZ", "4.3 GHZ", "4.6 GHZ", "5.0 GHZ" }));
		PSFrequencycbx.setBounds(470, 55, 99, 25);
		MicroprocessorsPanel.add(PSFrequencycbx);

		StorageDiskPanel = new JPanel();
		StorageDiskPanel.setLayout(null);
		StorageDiskPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Product Description", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		StorageDiskPanel.setBounds(30, 266, 585, 100);
		contentPanel.add(StorageDiskPanel);

		JLabel lblNewLabel_7 = new JLabel("Manufacturer:");
		lblNewLabel_7.setBounds(20, 29, 103, 21);
		StorageDiskPanel.add(lblNewLabel_7);

		JComboBox SDManufacturercbx = new JComboBox();
		SDManufacturercbx.setModel(
				new DefaultComboBoxModel(new String[] { "Corsair", "Kingston", "Lexar", "Micron", "Mushkin", "PNY",
						"Pretec", "Samsung", "SanDisk", "Silicon Power", "Sony", "TDK", "Verbatim", "Viking", "WD" }));
		SDManufacturercbx.setBounds(20, 55, 113, 25);
		StorageDiskPanel.add(SDManufacturercbx);

		JLabel lblNewLabel_7_1 = new JLabel("Model:");
		lblNewLabel_7_1.setBounds(170, 29, 103, 21);
		StorageDiskPanel.add(lblNewLabel_7_1);

		JLabel lblNewLabel_7_2 = new JLabel("Memory Size:");
		lblNewLabel_7_2.setBounds(320, 29, 103, 21);
		StorageDiskPanel.add(lblNewLabel_7_2);

		JLabel lblNewLabel_7_3 = new JLabel("Disk Type:");
		lblNewLabel_7_3.setBounds(470, 33, 103, 21);
		StorageDiskPanel.add(lblNewLabel_7_3);

		JComboBox SDModelcbx = new JComboBox();
		SDModelcbx.setModel(
				new DefaultComboBoxModel(new String[] { "970", "970 PRO", "980", "980 PRO", "BARRACUDA", "FIRECUDA" }));
		SDModelcbx.setBounds(165, 55, 108, 25);
		StorageDiskPanel.add(SDModelcbx);

		JComboBox SDMemorySizecbx = new JComboBox();
		SDMemorySizecbx.setModel(new DefaultComboBoxModel(new String[] { "120GB", "128GB", "240GB", "256GB", "400GB",
				"500GB", "512GB", "750GB", "1TB", "2TB", "4TB", "6TB", "8TB", "16TB" }));
		SDMemorySizecbx.setBounds(320, 55, 106, 25);
		StorageDiskPanel.add(SDMemorySizecbx);

		JComboBox SDTypecbx = new JComboBox();
		SDTypecbx.setModel(
				new DefaultComboBoxModel(new String[] { "SATA", "SATA HYBRID", "SSD M.2", "SSD NVME", "SSD SATA" }));
		SDTypecbx.setBounds(470, 55, 100, 25);
		StorageDiskPanel.add(SDTypecbx);

		RamPanel = new JPanel();
		RamPanel.setLayout(null);
		RamPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Product Description", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		RamPanel.setBounds(30, 266, 585, 100);
		contentPanel.add(RamPanel);

		JLabel lblNewLabel_2 = new JLabel("Manufacturer:");
		lblNewLabel_2.setBounds(20, 29, 103, 21);
		RamPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Memory Size:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(236, 29, 103, 21);
		RamPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Memory Type:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(440, 29, 103, 21);
		RamPanel.add(lblNewLabel_4);

		JComboBox RamMakecbx = new JComboBox();
		RamMakecbx.setModel(new DefaultComboBoxModel(
				new String[] { "AOpen", "Arch Memory", "Billionton Systems", "Corsair", "Crucial", "Fujitsu", "G.SKILL",
						"HYPER X", "INNO3D", "Intel", "KingMax", "Kingston", "Lenovo", "Microchip", "Micron", "PNY",
						"Pretec", "Rambus", "Samsung", "Simmtronics", "Thermaltake", "Verbatim", "Viking" }));
		RamMakecbx.setBounds(20, 55, 125, 25);
		RamPanel.add(RamMakecbx);

		JComboBox RamSizetxt = new JComboBox();
		RamSizetxt.setModel(
				new DefaultComboBoxModel(new String[] { "4 GB", "8 GB", "16 GB", "32 GB", "64 GB", "128 GB" }));
		RamSizetxt.setBounds(232, 55, 125, 25);
		RamPanel.add(RamSizetxt);

		JComboBox RamTypecbx = new JComboBox();
		RamTypecbx.setModel(new DefaultComboBoxModel(new String[] { "DDR", "DDR2", "DDR3", "DDR4" }));
		RamTypecbx.setBounds(440, 55, 125, 25);
		RamPanel.add(RamTypecbx);

		quantityTxt = new JSpinner();
		quantityTxt.setBounds(262, 401, 125, 25);
		contentPanel.add(quantityTxt);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Price:");
		lblNewLabel_2_1_1_1_1.setBounds(50, 436, 91, 13);
		contentPanel.add(lblNewLabel_2_1_1_1_1);

		JLabel lblNewLabel_2_1_2_2 = new JLabel("Min Quantity:");
		lblNewLabel_2_1_2_2.setBounds(262, 436, 91, 13);
		contentPanel.add(lblNewLabel_2_1_2_2);

		JLabel lblNewLabel_2_1_2_3 = new JLabel("Payment Method:");
		lblNewLabel_2_1_2_3.setBounds(465, 378, 125, 13);
		contentPanel.add(lblNewLabel_2_1_2_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Provider", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(27, 26, 588, 111);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("RNC:");
		lblNewLabel.setBounds(25, 27, 61, 16);
		panel_1.add(lblNewLabel);

		rncTxt = new JTextField();
		rncTxt.setBounds(25, 44, 130, 26);
		panel_1.add(rncTxt);
		rncTxt.setColumns(10);

		JButton btnNewButton = new JButton("Find");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rnc = rncTxt.getText();
				provider = Shop.getInstance().getProviderByRNC(rnc);
				if (provider == null) {
					enableEditProvider();
				} else {
					nameTxt.setText(provider.getName());
					addressTxt.setText(provider.getAddress());
					phoneTxt.setText(provider.getPhone());
				}
			}
		});
		btnNewButton.setBounds(25, 75, 130, 29);
		panel_1.add(btnNewButton);

		JLabel lblNewLabel_8 = new JLabel("Name:");
		lblNewLabel_8.setBounds(176, 10, 61, 16);
		panel_1.add(lblNewLabel_8);

		nameTxt = new JTextField();
		nameTxt.setEnabled(false);
		nameTxt.setBounds(175, 27, 184, 26);
		panel_1.add(nameTxt);
		nameTxt.setColumns(10);

		JLabel lblNewLabel_8_1 = new JLabel("Address:");
		lblNewLabel_8_1.setBounds(177, 60, 61, 16);
		panel_1.add(lblNewLabel_8_1);

		addressTxt = new JTextField();
		addressTxt.setEnabled(false);
		addressTxt.setColumns(10);
		addressTxt.setBounds(176, 77, 178, 26);
		panel_1.add(addressTxt);

		JLabel lblNewLabel_8_2 = new JLabel("Phone number:");
		lblNewLabel_8_2.setBounds(377, 11, 136, 16);
		panel_1.add(lblNewLabel_8_2);

		phoneTxt = new JTextField();
		phoneTxt.setEnabled(false);
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(376, 28, 184, 26);
		panel_1.add(phoneTxt);

		JLabel lblNewLabel_8_1_1 = new JLabel("Date:");
		lblNewLabel_8_1_1.setBounds(378, 61, 61, 16);
		panel_1.add(lblNewLabel_8_1_1);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(375, 77, 182, 26);
		panel_1.add(textField);
		textField.setColumns(10);

		methodTxt = new JComboBox();
		methodTxt.setModel(new DefaultComboBoxModel(new String[] { "Paid", "Credit" }));
		methodTxt.setBounds(465, 399, 125, 27);
		contentPanel.add(methodTxt);

		minTxt = new JSpinner();
		minTxt.setBounds(262, 456, 125, 26);
		contentPanel.add(minTxt);

		priceTxt = new JSpinner();
		priceTxt.setBounds(50, 456, 125, 26);
		contentPanel.add(priceTxt);
		
		Serialtxt = new JTextField();
		Serialtxt.setBounds(50, 401, 125, 26);
		Serialtxt.setText("PDCT - "+Shop.getInstance().getComponents().size());
		contentPanel.add(Serialtxt);
		Serialtxt.setColumns(10);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton SaveProductsbtn = new JButton("Save Product");
				SaveProductsbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						// Register provider if not found
						if (provider == null) {
							String providerName = nameTxt.getText();
							String providerRnc = rncTxt.getText();
							String providerAddress = addressTxt.getText();
							String providerPhone = phoneTxt.getText();
							provider = new Provider(providerName, providerRnc, providerPhone, providerAddress);
							// TODO: this returns false if the registration is not possible
							Shop.getInstance().registerProvider(provider);
						}

						String serial = (String) Serialtxt.getText();
						Integer quantity = Integer.parseInt(quantityTxt.getValue().toString());
						Integer minimun = Integer.parseInt(minTxt.getValue().toString());
						float price = Float.parseFloat(priceTxt.getValue().toString());
						String method = (String) methodTxt.getSelectedItem();

						if (minimun > quantity) {
							// TODO: Add an alarm here: minimun cannot be bigger than quantity
							return;
						}

						Component newComponent = null;
						if (Motherboardbtn.isSelected()) {
							String brand = MBManufacturercbx.getSelectedItem().toString();
							String model = MBModelcbx.getSelectedItem().toString();
							String connectionType = MBConectionTypecbx.getSelectedItem().toString();
							String ramType = MBRamTypecbx.getSelectedItem().toString();
							newComponent = new Motherboard(price, quantity, serial, minimun, provider, brand, model,
									connectionType, ramType);
						} else if (StorageDiskbtn.isSelected()) {
							String brand = SDManufacturercbx.getSelectedItem().toString();
							String model = SDModelcbx.getSelectedItem().toString();
							String capacity = SDMemorySizecbx.getSelectedItem().toString();
							String connectionType = SDTypecbx.getSelectedItem().toString();
							newComponent = new HardDisk(price, quantity, serial, minimun, provider, brand, model,
									capacity, connectionType);
						} else if (Microprocessorsbtn.isSelected()) {
							String brand = PSMakecbx.getSelectedItem().toString();
							String model = PSModelcbx.getSelectedItem().toString();
							String speed = SDMemorySizecbx.getSelectedItem().toString();
							String type = PSConectionTypecbx.getSelectedItem().toString();
							newComponent = new Microprocessor(price, quantity, serial, minimun, provider, brand, model,
									type, speed);
						} else if (Rambtn.isSelected()) {
							String brand = RamMakecbx.getSelectedItem().toString();
							String capacity = RamSizetxt.getSelectedItem().toString();
							String type = RamTypecbx.getSelectedItem().toString();
							newComponent = new RamCard(price, quantity, serial, minimun, provider, brand, capacity,
									type);
						}

						// TODO: this return false if the component could not be added
						Shop.getInstance().registerComponent(newComponent);
						// TODO: set alarm
						clear();
					}
				});
				SaveProductsbtn.setActionCommand("OK");
				buttonPane.add(SaveProductsbtn);
				getRootPane().setDefaultButton(SaveProductsbtn);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void enableEditProvider() {
		nameTxt.setEnabled(true);
		addressTxt.setEnabled(true);
		phoneTxt.setEnabled(true);
	}
	//Option to clear adding products page
	public void clear() {
		minTxt.setValue(0);
		priceTxt.setValue(0);
		quantityTxt.setValue(0);
		Serialtxt.setText("PDCT - "+Shop.getInstance().getComponents().size());
	}
}

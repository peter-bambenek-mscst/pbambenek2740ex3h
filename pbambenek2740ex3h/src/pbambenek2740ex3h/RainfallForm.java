package pbambenek2740ex3h;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Component;
import java.text.DecimalFormat;

public class RainfallForm extends JFrame{
	private JLabel totalLabel;
	private JLabel averageLabel;
	private JLabel minimumLabel;
	private JLabel maximumLabel;
	private JList rainfallList;
	private JTextField inputMonthTextField;
	private String [] strRainfall = {
			"1.4", "2.3", "2.8", "3.5", "3.9", "4.1",
			"3.9", "2.4", "3.7", "1.3", "3.2", "2.7"};
	private JButton updateButton;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RainfallForm frame = new RainfallForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public RainfallForm() {
		setTitle("PBambenek 2740 Ex3H Rainfall");
		setSize(new Dimension(300, 378));
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblMonthlyRainfall = new JLabel("Monthly Rainfall");
		lblMonthlyRainfall.setBounds(32, 23, 94, 14);
		getContentPane().add(lblMonthlyRainfall);
		
		JList list = new JList();
		list.setEnabled(false);
		list.setForeground(SystemColor.textInactiveText);
		list.setBackground(SystemColor.control);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"01 Jan", "02 Feb", "03 Mar", "04 Apr", "05 May", "06 Jun", "07 Jul", "08 Aug", "09 Sep", "10 Oct", "11 Nov", "12 Dec"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(32, 48, 46, 221);
		getContentPane().add(list);
		
		rainfallList = new JList(strRainfall);
		rainfallList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				do_rainfallList_valueChanged(arg0);
			}
		});
		rainfallList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		rainfallList.setBounds(88, 46, 50, 223);
		getContentPane().add(rainfallList);
		
		JLabel lblNewLabel = new JLabel("Total");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(148, 55, 59, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblAverage = new JLabel("Average");
		lblAverage.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAverage.setBounds(148, 94, 59, 14);
		getContentPane().add(lblAverage);
		
		JLabel lblMaximum = new JLabel("Maximum");
		lblMaximum.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMaximum.setBounds(148, 172, 59, 14);
		getContentPane().add(lblMaximum);
		
		JLabel lblMinimum = new JLabel("Minimum");
		lblMinimum.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMinimum.setBounds(148, 133, 59, 14);
		getContentPane().add(lblMinimum);
		
		totalLabel = new JLabel("0.0");
		lblNewLabel.setLabelFor(totalLabel);
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		totalLabel.setBounds(216, 48, 45, 28);
		getContentPane().add(totalLabel);
		
		averageLabel = new JLabel("0.0");
		lblAverage.setLabelFor(averageLabel);
		averageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		averageLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		averageLabel.setBounds(216, 87, 45, 28);
		getContentPane().add(averageLabel);
		
		minimumLabel = new JLabel("0.0");
		lblMinimum.setLabelFor(minimumLabel);
		minimumLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		minimumLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		minimumLabel.setBounds(216, 126, 45, 28);
		getContentPane().add(minimumLabel);
		
		maximumLabel = new JLabel("0.0");
		lblMaximum.setLabelFor(maximumLabel);
		maximumLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		maximumLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		maximumLabel.setBounds(216, 165, 45, 28);
		getContentPane().add(maximumLabel);
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_calculateButton_actionPerformed(e);
			}
		});
		calculateButton.setBounds(177, 204, 89, 23);
		getContentPane().add(calculateButton);
		
		inputMonthTextField = new JTextField();
		inputMonthTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		inputMonthTextField.setBounds(88, 273, 50, 20);
		getContentPane().add(inputMonthTextField);
		inputMonthTextField.setColumns(10);
		
		updateButton = new JButton("Update");
		updateButton.setEnabled(false);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_updateButton_actionPerformed(arg0);
			}
		});
		updateButton.setBounds(73, 304, 76, 23);
		getContentPane().add(updateButton);
	}
	
	protected void do_rainfallList_valueChanged(ListSelectionEvent arg0) {
		updateButton.setEnabled(true);
		inputMonthTextField.setText((String) rainfallList.getSelectedValue());
		inputMonthTextField.requestFocus();
		inputMonthTextField.selectAll();
	}
	
	protected void do_updateButton_actionPerformed(ActionEvent arg0) {
		int selectedIndex = rainfallList.getSelectedIndex();
		double r = Double.parseDouble(inputMonthTextField.getText());
		strRainfall[selectedIndex] = Double.toString(r);
		rainfallList.repaint();
		
		inputMonthTextField.setText("0.0");
		updateButton.setEnabled(false);
		totalLabel.setText("");
		averageLabel.setText("");
		minimumLabel.setText("");
		maximumLabel.setText("");
	}
	
	protected void do_calculateButton_actionPerformed(ActionEvent e) {
		Rainfall rainfallData = new Rainfall(strRainfall);
		
		DecimalFormat fmt = new DecimalFormat("0.0");
		totalLabel.setText(fmt.format(rainfallData.getTotal()));
		averageLabel.setText(fmt.format(rainfallData.getAverage()));
		minimumLabel.setText(fmt.format(rainfallData.getLowest()));
		maximumLabel.setText(fmt.format(rainfallData.getHighest()));
	}
	
}

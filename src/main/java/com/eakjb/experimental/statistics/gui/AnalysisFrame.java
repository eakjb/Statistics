package com.eakjb.experimental.statistics.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.eakjb.experimental.statistics.NDDimension;
import com.eakjb.experimental.statistics.NDObject;

public class AnalysisFrame extends JFrame {
	private static final long serialVersionUID = -5719150510689290713L;
	private JPanel contentPane;
	private RectanglePanel rect;
	private NDObject archtype;
	private List<NDDimension> dimensions;
	private Map<NDDimension,List<Double>> measurements;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NDObject a = new NDObject("Architype");
					NDDimension dx = new NDDimension("X",1);
					NDDimension dy = new NDDimension("Y",1);
					
					List<NDDimension> d = new ArrayList<NDDimension>();
					d.add(dx);
					d.add(dy);
					
					AnalysisFrame frame = new AnalysisFrame(a,d);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AnalysisFrame(NDObject architype, List<NDDimension> dimensions) {
		this.archtype=architype;
		this.dimensions=dimensions;
		this.measurements=new HashMap<NDDimension,List<Double>>();
		for (NDDimension d : dimensions) {
			this.measurements.put(d, new ArrayList<Double>());
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel mainContent = new JPanel();
		mainContent.setLayout(new FlowLayout());
		contentPane.add(mainContent, BorderLayout.CENTER);
		
		rect = new RectanglePanel();
		rect.setPreferredSize(new Dimension(300,300));
		mainContent.add(rect, BorderLayout.CENTER);
		
		JPanel leftPanel = new JPanel();
		contentPane.add(leftPanel, BorderLayout.WEST);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				add();
			}
		});
		leftPanel.add(button);
		
		JPanel rightPanel = new JPanel();
		contentPane.add(rightPanel, BorderLayout.EAST);
		
		JButton button_1 = new JButton("-");
		rightPanel.add(button_1);
	}
	
	protected void add() {
		this.measurements.get(this.dimensions.get(0)).add((double) rect.getRect().x);
		this.measurements.get(this.dimensions.get(1)).add((double) rect.getRect().y);
		
		for (NDDimension d : this.dimensions) {
			double t=0;
			for (double m : this.measurements.get(d)) {
				t+=m;
			}
			this.archtype.put(d,t/this.measurements.get(d).size());
			System.out.println(this.archtype.get(d));
		}
		
		nextImage();
	}
	
	protected void nextImage() {
		rect.randomize();
		rect.repaint();
	}

}

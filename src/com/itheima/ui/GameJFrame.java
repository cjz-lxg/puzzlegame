package com.itheima.ui;

import javax.swing.*;
import java.util.Random;

public class GameJFrame extends JFrame {
	int[][] data = new int[4][4];
	public GameJFrame() {
		initJFrame();
		
		initJMenuBar();
		
		initData();
		
		initImage();
		
		setVisible(true);
	}
	
	private void initData() {
		int[] temp = new int[16];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = i + 1;
		}
		Random r = new Random();
		for (int i = 0; i < temp.length; i++) {
			int next = r.nextInt(temp.length);
			int temp1 = temp[next];
			temp[next] = temp[i];
			temp[i] = temp1;
		}
		for (int i = 0; i < temp.length; i++) {
			data[i / 4][i % 4] = temp[i];
		}
	}
	
	private void initImage() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				JLabel jLabel = new JLabel(new ImageIcon("G:\\MyProject\\puzzlegame\\image\\image\\animal\\animal3\\" + data[i][j] + ".jpg"));
				jLabel.setBounds(105 * j, 105 * i, 105, 105);
				this.getContentPane().add(jLabel);
			}
		}
	}
	
	private void initJFrame() {
		setSize(603, 680);
		this.setTitle("拼图单机版 v1.0");
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(null);
	}
	
	private void initJMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu functionMenu = new JMenu("功能");
		JMenu aboutMenu = new JMenu("关于我们");
		
		JMenuItem replayItem = new JMenuItem("重新游戏");
		JMenuItem reLoginItem = new JMenuItem("重新登录");
		JMenuItem closeItem = new JMenuItem("关闭游戏");
		
		JMenuItem accountItem = new JMenuItem("公众号");
		
		functionMenu.add(replayItem);
		functionMenu.add(reLoginItem);
		functionMenu.add(closeItem);
		
		aboutMenu.add(accountItem);
		
		menuBar.add(functionMenu);
		menuBar.add(aboutMenu);
		
		setJMenuBar(menuBar);
	}
	
}

package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener{
	int[][] data = new int[4][4];
	
	int x , y;
	
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
		temp[15] = 16;
		Random r = new Random();
		for (int i = 0; i < temp.length; i++) {
			int next = r.nextInt(temp.length);
			int temp1 = temp[next];
			temp[next] = temp[i];
			temp[i] = temp1;
		}
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 16) {
				x = i % 4;
				y = i / 4;
			}
			data[i / 4][i % 4] = temp[i];
		}
	}
	
	private void initImage() {
		
		this.getContentPane().removeAll();
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				JLabel jLabel = new JLabel(new ImageIcon("image\\image\\animal\\animal3\\" + data[i][j] + ".jpg"));
				jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
				jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
				this.getContentPane().add(jLabel);
			}
		}
		
		JLabel background = new JLabel(new ImageIcon("image\\image\\background.png"));
		background.setBounds(40, 40, 508, 560);
		this.getContentPane().add(background);
		
		this.getContentPane().repaint();
	}
	
	private void initJFrame() {
		setSize(603, 680);
		this.setTitle("拼图单机版 v1.0");
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.addKeyListener(this);
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
	
	@Override
	public void keyTyped(KeyEvent e) {
	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == 37) {
			if (x <= 0) {
				return;
			}
			data[y][x] = data[y][x - 1];
			data[y][x - 1] = 16;
			x--;
			initImage();
			System.out.println("向左移动");
		} else if (code == 38) {
			if (y <= 0) {
				return;
			}
			data[y][x] = data[y - 1][x];
			data[y - 1][x] = 0;
			y--;
			initImage();
			System.out.println("向上移动");
		} else if (code == 39) {
			if (x >= data.length-1) {
				return;
			}
			data[y][x] = data[y][x + 1];
			data[y][x + 1] = 16;
			x++;
			initImage();
			System.out.println("向右移动");
		} else if (code == 40) {
			if (y >= data[0].length - 1) {
				return;
			}
			data[y][x] = data[y + 1][x];
			data[y + 1][x] = 0;
			y++;
			initImage();
			System.out.println("向下移动");
		}
	}
}

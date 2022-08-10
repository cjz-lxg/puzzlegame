package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
	int[][] data = new int[4][4];
	
	int x , y;
	
	int step = 0;
	
	
	String path = "image\\image\\animal\\animal3\\";
	
	JMenuItem replayItem = new JMenuItem("重新游戏");
	JMenuItem reLoginItem = new JMenuItem("重新登录");
	JMenuItem closeItem = new JMenuItem("关闭游戏");
	
	JMenuItem accountItem = new JMenuItem("公众号");
	
	
	public GameJFrame() {
		initJFrame();
		
		initJMenuBar();
		
		initData();
		
		initImage();
		
		setVisible(true);
		
	}
	
	private boolean check() {
		int[][] temp = new int[][]{
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 16},
		};
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (data[i][j] != temp[i][j]) {
					return false;
				}
			}
		}
		return true;
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
		
		JLabel label = new JLabel("步数:" + step);
		label.setBounds(50, 30, 120, 30);
		this.getContentPane().add(label);
		
		if (check()) {
			JLabel victory = new JLabel(new ImageIcon("image/image/win.png"));
			victory.setBounds(203, 283, 197, 73);
			this.getContentPane().add(victory);
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				JLabel jLabel = new JLabel(new ImageIcon(path + data[i][j] + ".jpg"));
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
		
		functionMenu.add(replayItem);
		functionMenu.add(reLoginItem);
		functionMenu.add(closeItem);
		
		aboutMenu.add(accountItem);
		
		replayItem.addActionListener(this);
		reLoginItem.addActionListener(this);
		closeItem.addActionListener(this);
		accountItem.addActionListener(this);
		
		menuBar.add(functionMenu);
		menuBar.add(aboutMenu);
		
		setJMenuBar(menuBar);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == 87) {
			this.getContentPane().removeAll();
			JLabel all = new JLabel(new ImageIcon("image/image/animal/animal3/all.jpg"));
			all.setBounds(83, 134, 420, 420);
			this.getContentPane().add(all);
			JLabel background = new JLabel(new ImageIcon("image\\image\\background.png"));
			background.setBounds(40, 40, 508, 560);
			this.getContentPane().add(background);
			this.getContentPane().repaint();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (check()) {
			return;
		}
		int code = e.getKeyCode();
		System.out.println(code);
		if (code == 37) {
			if (x <= 0) {
				return;
			}
			data[y][x] = data[y][x - 1];
			data[y][x - 1] = 16;
			x--;
			step++;
			initImage();
			System.out.println("向左移动");
		} else if (code == 38) {
			if (y <= 0) {
				return;
			}
			data[y][x] = data[y - 1][x];
			data[y - 1][x] = 0;
			y--;
			step++;
			initImage();
			System.out.println("向上移动");
		} else if (code == 39) {
			if (x >= data.length - 1) {
				return;
			}
			data[y][x] = data[y][x + 1];
			data[y][x + 1] = 16;
			x++;
			step++;
			initImage();
			System.out.println("向右移动");
		} else if (code == 40) {
			if (y >= data[0].length - 1) {
				return;
			}
			data[y][x] = data[y + 1][x];
			data[y + 1][x] = 0;
			y++;
			step++;
			initImage();
			System.out.println("向下移动");
		} else if (code == 87) {
			initImage();
		} else if (code == 65) {
			data = new int[][]{
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16},
			};
			initImage();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == reLoginItem) {
			new RegisterJFrame();
			System.out.println("重新注册");
		} else if (obj == replayItem) {
			System.out.println("重新游戏");
			step = 0;
			initData();
			initImage();
		} else if (obj == closeItem) {
			System.out.println("关闭游戏");
			System.exit(0);
		} else if (obj == accountItem) {
			JDialog jDialog = new JDialog();
			JLabel jLabel1 = new JLabel(new ImageIcon("G:\\MyProject\\puzzlegame\\image\\image\\about.png"));
			jLabel1.setBounds(0, 0, 258, 258);
			jDialog.getContentPane().add(jLabel1);
			jDialog.setSize(344, 344);
			jDialog.setAlwaysOnTop(true);
			jDialog.setLocationRelativeTo(null);
			jDialog.setModal(true);
			jDialog.setVisible(true);
			System.out.println("公众号");
		}
	}
}

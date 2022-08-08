package com.itheima.ui;

import javax.swing.*;

public class GameJFrame extends JFrame {
	public GameJFrame() {
		initJFrame();
		initJMenuBar();
		setVisible(true);
	}
	
	public void initJFrame() {
		setSize(603, 680);
		this.setTitle("拼图单机版 v1.0");
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	public void initJMenuBar() {
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

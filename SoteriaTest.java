import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jfree.ui.RefineryUtilities;

public class SoteriaTest extends JFrame implements ActionListener, WindowListener {
	private static JButton leaveHouse;
	private static JButton keypadUnlock1;
	private static JButton keypadUnlock2;
	private static JButton keypadUnlock3;
	private static JButton keypadUnlock4;
	private static JButton PanicButtonA;
	private static JButton PanicButtonB;
	private static JButton PanicButtonC;
	private static JLabel currentProcess = new JLabel();
	private static JLabel log;
	private static JTextArea readyQueue;
	private static JTextArea blockedQueue;
	private static boolean soteriaOff;
	private static boolean interrupts = true;
	private static int i = 0;
	private static volatile boolean isRunning = true;
	private static JTextArea keypads;
	private static JTextArea light;
	private static JTextArea panicButtons;
	private static JLabel cpu = new JLabel();
	private static JPanel keypadBtnsPanel;
	private static JPanel logsPnl;
	private static JPanel queuePnl;
	private static JPanel infoPnl;
	private static JPanel panicBtnsPnl;
	private static JPanel lightsPnl;
	private static JPanel btnsPnl;
	private static JPanel keypadContainer;
	private static JPanel lightContainer;
	private static JPanel panicContainer;
	private static JPanel memPnl;
	private static boolean stop = false;
	private static ImagePanel background = new ImagePanel("house1.jpg");

	public SoteriaTest() {
		populate();
		this.setResizable(false);
		this.addWindowListener(this);
		this.setBounds(500, 800, 1280, 720);
		this.setLayout(new BorderLayout());
		keypads = new JTextArea();
		keypads.setPreferredSize(new Dimension(100, 300));
		light = new JTextArea();
		light.setPreferredSize(new Dimension(100, 300));
		panicButtons = new JTextArea();
		panicButtons.setPreferredSize(new Dimension(100, 300));
		keypads.setEditable(false);
		light.setEditable(false);
		panicButtons.setEditable(false);
		keypadBtnsPanel = new JPanel();
		logsPnl = new JPanel();
		queuePnl = new JPanel();
		infoPnl = new JPanel();
		panicBtnsPnl = new JPanel();
		btnsPnl = new JPanel();
		lightsPnl = new JPanel();
		keypadContainer = new JPanel();
		lightContainer = new JPanel();
		panicContainer = new JPanel();
		memPnl = new JPanel();
		// memPnl.setLayout(new BorderLayout());
		keypadContainer.setLayout(new BorderLayout());
		lightContainer.setLayout(new BorderLayout());
		panicContainer.setLayout(new BorderLayout());
		lightsPnl.setLayout(new BorderLayout());
		infoPnl.setLayout(new BorderLayout());
		infoPnl.setOpaque(false);
		logsPnl.setLayout(new BorderLayout());
		panicBtnsPnl.setLayout(new GridLayout(3, 1));
		keypadBtnsPanel.setLayout(new GridLayout(2, 2));
		btnsPnl.setLayout(new BorderLayout());
		leaveHouse = new JButton("Leave and lock the House");
		leaveHouse.setActionCommand("H");
		leaveHouse.setContentAreaFilled(false);
		leaveHouse.setOpaque(false);
		leaveHouse.setBorder(null);
		leaveHouse.setForeground(Color.WHITE);
		leaveHouse.setFont(new Font("Arial", Font.BOLD, 14));
		keypadUnlock1 = new JButton("Unlock Keypad 1");
		keypadUnlock1.setActionCommand("K1");
		keypadUnlock1.setContentAreaFilled(false);
		keypadUnlock1.setOpaque(false);
		keypadUnlock1.setBorder(null);
		keypadUnlock1.setForeground(Color.WHITE);
		keypadUnlock1.setFont(new Font("Arial", Font.BOLD, 14));
		keypadUnlock2 = new JButton("Unlock Keypad 2");
		keypadUnlock2.setActionCommand("K2");
		keypadUnlock2.setContentAreaFilled(false);
		keypadUnlock2.setOpaque(false);
		keypadUnlock2.setBorder(null);
		keypadUnlock2.setForeground(Color.WHITE);
		keypadUnlock2.setFont(new Font("Arial", Font.BOLD, 14));
		keypadUnlock3 = new JButton("Unlock keypad 3");
		keypadUnlock3.setActionCommand("K3");
		keypadUnlock3.setContentAreaFilled(false);
		keypadUnlock3.setOpaque(false);
		keypadUnlock3.setBorder(null);
		keypadUnlock3.setForeground(Color.WHITE);
		keypadUnlock3.setFont(new Font("Arial", Font.BOLD, 14));
		keypadUnlock4 = new JButton("Unlock Keypad 4");
		keypadUnlock4.setActionCommand("K4");
		keypadUnlock4.setOpaque(false);
		keypadUnlock4.setBorder(null);
		keypadUnlock4.setContentAreaFilled(false);
		keypadUnlock4.setForeground(Color.WHITE);
		keypadUnlock4.setFont(new Font("Arial", Font.BOLD, 14));
		PanicButtonA = new JButton("Call The Police");
		PanicButtonA.setActionCommand("PA");
		PanicButtonA.setContentAreaFilled(false);
		PanicButtonA.setOpaque(false);
		PanicButtonA.setBorder(null);
		PanicButtonA.setFont(new Font("Arial", Font.BOLD, 14));
		PanicButtonA.setForeground(Color.WHITE);
		PanicButtonB = new JButton("Call The Fire Dep.");
		PanicButtonB.setContentAreaFilled(false);
		PanicButtonB.setActionCommand("PB");
		PanicButtonB.setOpaque(false);
		PanicButtonB.setBorder(null);
		PanicButtonB.setFont(new Font("Arial", Font.BOLD, 14));
		PanicButtonB.setForeground(Color.WHITE);
		PanicButtonC = new JButton("Call The Hospital");
		PanicButtonC.setContentAreaFilled(false);
		PanicButtonC.setActionCommand("PC");
		PanicButtonC.setOpaque(false);
		PanicButtonC.setBorder(null);
		PanicButtonC.setFont(new Font("Arial", Font.BOLD, 14));
		PanicButtonC.setForeground(Color.WHITE);
		log = new JLabel("Log: ");
		log.setHorizontalAlignment(JLabel.CENTER);
		log.setVerticalAlignment(JLabel.CENTER);
		cpu = new JLabel("CPU Utilization: 0% ");
		cpu.setFont(new Font("Arial", Font.BOLD, 20));
		cpu.setHorizontalAlignment(JLabel.CENTER);
		cpu.setVerticalAlignment(JLabel.CENTER);
		cpu.setForeground(Color.BLACK);
		currentProcess.setVerticalAlignment(JLabel.CENTER);
		currentProcess.setHorizontalAlignment(JLabel.CENTER);
		currentProcess.setFont(new Font("Arial", Font.BOLD, 20));
		currentProcess.setForeground(Color.BLACK);
		JLabel keypadsLabel = new JLabel("Keypads");
		keypadsLabel.setFont(new Font("Arial", Font.BOLD, 18));
		keypadsLabel.setHorizontalAlignment(JLabel.CENTER);
		keypadsLabel.setVerticalAlignment(JLabel.CENTER);
		JLabel lightsLable = new JLabel("Lights");
		lightsLable.setFont(new Font("Arial", Font.BOLD, 18));
		lightsLable.setVerticalAlignment(JLabel.CENTER);
		lightsLable.setHorizontalAlignment(JLabel.CENTER);
		JLabel panicButtonsLabel = new JLabel("Panic Buttons");
		panicButtonsLabel.setHorizontalAlignment(JLabel.CENTER);
		panicButtonsLabel.setVerticalAlignment(JLabel.CENTER);
		panicButtonsLabel.setFont(new Font("Arial", Font.BOLD, 18));
		panicButtonsLabel.setForeground(Color.RED);
		readyQueue = new JTextArea();
		readyQueue.setPreferredSize(new Dimension(100, 300));
		blockedQueue = new JTextArea();
		blockedQueue.setPreferredSize(new Dimension(100, 300));
		keypads.setEditable(false);
		light.setEditable(false);
		panicButtons.setEditable(false);
		readyQueue.setEditable(false);
		blockedQueue.setEditable(false);
		queuePnl.add(readyQueue);
		queuePnl.add(blockedQueue);
		queuePnl.setOpaque(false);
		memPnl.add(light);
		memPnl.add(keypads);
		memPnl.add(panicButtons);
		memPnl.setOpaque(false);
		// logsPnl.add(log, BorderLayout.NORTH);
		logsPnl.add(currentProcess, BorderLayout.NORTH);
		infoPnl.add(queuePnl, BorderLayout.EAST);
		infoPnl.add(logsPnl, BorderLayout.CENTER);
		infoPnl.add(memPnl, BorderLayout.WEST);
		logsPnl.setOpaque(false);
		queueUpdateAndDisplay();
		keypadUnlock1.addActionListener(this);
		keypadUnlock2.addActionListener(this);
		keypadUnlock3.addActionListener(this);
		keypadUnlock4.addActionListener(this);
		PanicButtonA.addActionListener(this);
		PanicButtonB.addActionListener(this);
		PanicButtonC.addActionListener(this);
		leaveHouse.addActionListener(this);
		JButton stahp = new JButton("Stop");
		stahp.setOpaque(false);
		stahp.setOpaque(false);
		stahp.setBorder(null);
		stahp.setForeground(Color.WHITE);
		stahp.setFont(new Font("Arial", Font.BOLD, 14));
		stahp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop = true;
			}
		});
		stahp.addActionListener(this);
		keypadBtnsPanel.add(keypadUnlock1);
		keypadBtnsPanel.add(keypadUnlock2);
		keypadBtnsPanel.add(keypadUnlock3);
		keypadBtnsPanel.add(keypadUnlock4);
		keypadBtnsPanel.setOpaque(false);
		panicBtnsPnl.add(PanicButtonA);
		panicBtnsPnl.add(PanicButtonB);
		panicBtnsPnl.add(PanicButtonC);
		panicBtnsPnl.setOpaque(false);
		lightsPnl.add(leaveHouse, BorderLayout.NORTH);
		lightsPnl.add(stahp, BorderLayout.SOUTH);
		lightsPnl.setSize(new Dimension(100, 100));
		lightsPnl.setOpaque(false);
		keypadContainer.add(keypadsLabel, BorderLayout.NORTH);
		keypadContainer.add(keypadBtnsPanel, BorderLayout.CENTER);
		keypadContainer.setOpaque(false);
		lightContainer.add(lightsPnl, BorderLayout.CENTER);
		lightContainer.add(lightsLable, BorderLayout.NORTH);
		lightContainer.setOpaque(false);
		panicContainer.add(panicButtonsLabel, BorderLayout.NORTH);
		panicContainer.add(panicBtnsPnl, BorderLayout.CENTER);
		panicContainer.setOpaque(false);
		btnsPnl.add(lightContainer, BorderLayout.WEST);
		btnsPnl.add(keypadContainer, BorderLayout.CENTER);
		btnsPnl.add(panicContainer, BorderLayout.EAST);
		btnsPnl.setOpaque(false);
		btnsPnl.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		background.add(cpu, BorderLayout.NORTH);
		cpu.setOpaque(false);
		background.add(infoPnl, BorderLayout.CENTER);
		infoPnl.setOpaque(false);
		background.add(btnsPnl, BorderLayout.SOUTH);
		this.add(background);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setJtextFieldofResources();
		this.repaint();
		this.revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton) e.getSource();
		if (src.getActionCommand().charAt(0) == 'K') {
			String keypadNum = src.getActionCommand().charAt(1) + "";
			String password = "";
			switch (keypadNum) {
			case "1":
				password = JOptionPane.showInputDialog("Please enter your password");
				if (password != null)
					Resources.keypads.get(0).openDoor(password);
				break;
			case "2":
				password = JOptionPane.showInputDialog("Please enter your password");
				if (password != null)
					Resources.keypads.get(1).openDoor(password);
				break;
			case "3":
				password = JOptionPane.showInputDialog("Please enter your password");
				if (password != null)
					Resources.keypads.get(2).openDoor(password);
				break;
			case "4":
				password = JOptionPane.showInputDialog("Please enter your password");
				if (password != null)
					Resources.keypads.get(3).openDoor(password);
				break;
			}
		} else {
			if (src.getActionCommand().charAt(0) == 'P') {
				String action = src.getActionCommand().charAt(1) + "";
				switch (action) {
				case "A":
					Resources.panicButtons.get(0).PressA();
					background.setImage("ahshit.jpg");
					this.repaint();
					break;
				case "B":
					Resources.panicButtons.get(0).PressB();
					break;
				case "C":
					Resources.panicButtons.get(0).PressC();
					break;
				}
			} else {
				if (src.getActionCommand().charAt(0) == 'H') {
					Resources.lightSwitches.get(0).cycleLights();
					stop = false;
				}
			}
		}
		queueUpdateAndDisplay();
		this.repaint();

	}

	public static void queueUpdateAndDisplay() {
		String res = getQueueString(Queues.getReadyQueue());
		if (!res.equals("")) {
			readyQueue.setText(res + "\n");
			System.out.println(readyQueue.getText());
		} else {
			readyQueue.setText("      Empty");
			System.out.println(readyQueue.getText());
		}

		res = getQueueString(Queues.getBlockedQueue());
		if (!res.equals("")) {
			blockedQueue.setText(res + "\n");
			System.out.println(blockedQueue.getText());
		} else {
			blockedQueue.setText("      Empty");
			System.out.println(blockedQueue.getText());
		}
	}

	static class ImagePanel extends JPanel {

		private Image img;

		public ImagePanel(String img) {
			this(new ImageIcon(img).getImage());
		}

		public void setImage(String img) {
			this.img = new ImageIcon(img).getImage();
			this.setOpaque(false);
		}

		public ImagePanel(Image img) {
			this.img = img;
			setLayout(new BorderLayout());
		}

		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}

	// Helper Method
	private static String getQueueString(PriorityQueue q) {
		PriorityQueue<Process> temp = new PriorityQueue<Process>(q);
		String res = "";
		while (!temp.isEmpty())
			res += temp.remove().method + "\n";
		return res;
	}

	private void setJtextFieldofResources() {
		ArrayList<Keypad> keypads = new ArrayList<Keypad>(Resources.keypads);
		ArrayList<Light> lights = new ArrayList<Light>(Resources.lightSwitches);
		String res = "";
		for (int i = 0; i < keypads.size(); i++)
			res += "Keypad " + keypads.get(i).getId() + "\n";
		this.keypads.setText(res);

		res = "";
		for (int i = 0; i < lights.size(); i++)
			res += "light " + lights.get(i).getId() + "\n";
		this.light.setText(res);

		this.panicButtons.setText("Call Police\nCall Ambulance\nCall Fire Department");

	}

	public static void dispatchProcess() {
		while (!Queues.getReadyQueue().isEmpty()) {
			cpu.setText("CPU Utilization: 100%");
			System.out.println("Ready Queue is " + Queues.getReadyQueue().toString());
			Process currProcess = Queues.getReadyQueue().poll();
			queueUpdateAndDisplay();
			currentProcess.getParent().getParent().repaint();
			run(currProcess);
		}
	}

	@SuppressWarnings("deprecation")
	public static void run(Process p) {
		System.out.println("Now executing " + p.type);
		currentProcess.setText("Now executing " + p.method);
		queueUpdateAndDisplay();
		currentProcess.getParent().repaint();
		currentProcess.getParent().getParent().repaint();
//		if (i == 1) {
//			PanicButton x = new PanicButton();
//			x.PressA();
//			i++;
//		}
//		i++;
		if (p.method.equals("cycleLights")) {
			while (true) {
				if (stop == true) {
					currentProcess.setText("Stopping cycle lights");
					currentProcess.getParent().getParent().repaint();
					System.out.println("Stopping cycle lights");
					break;
				}

				int t = 5;
				long d = t * 1000;
				System.out.println("Turning lights on for:");
				while (d != 0) {
					if (!Queues.getReadyQueue().isEmpty()) {
						if ((Queues.getReadyQueue().peek().type.equals("PanicButtonA")
								|| Queues.getReadyQueue().peek().type.equals("PanicButtonB")
								|| Queues.getReadyQueue().peek().type.equals("PanicButtonC")) && interrupts) {
							Process button = Queues.getReadyQueue().poll();
							button.state = Thread.State.RUNNABLE;
							interrupts = false;
							p.suspend();
							p.state = Thread.State.BLOCKED;
							currentProcess.setText("Stopping " + p.type);
							currentProcess.getParent().repaint();
							currentProcess.getParent().getParent().repaint();
							queueUpdateAndDisplay();
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
//							currentProcess.getParent().repaint();
//							currentProcess.getParent().getParent().repaint();
							System.out.println("Interuptting " + p.type);
							currentProcess.setText("Now Executing " + button.method);
							currentProcess.getParent().getParent().repaint();
							System.out.println("Now Executing " + button.type);
							String message = "";
							if (button.type.equals("PanicButtonA"))
								message = "Calling the police departement";
							if (button.type.equals("PanicButtonB"))
								message = "Calling the Fire Departement";
							if (button.type.equals("PanicButtonC"))
								message = "Calling the hospital";
							currentProcess.setText(message);
							currentProcess.getParent().repaint();
							currentProcess.getParent().getParent().repaint();
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							currentProcess.setText("Finished Executing " + button.method);
							currentProcess.getParent().repaint();
							currentProcess.getParent().getParent().repaint();
							background.setImage("house1.jpg");
							background.getParent().repaint();
							System.out.println("Finished Executing " + button.method);
							button.state = Thread.State.TERMINATED;
							interrupts = true;
							queueUpdateAndDisplay();
							stop = true;
							return;
						}
					} else {
						System.out.print("Turning lights on for: " + t + "s.. ");
						currentProcess.setText("Turning lights on for: " + t + "s.. ");
						currentProcess.getParent().getParent().repaint();
						try {
							Thread.sleep(1000);

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						t--;
						d -= 1000;
						if (stop == true) {
							System.out.println("Stopping cycle lights");
							currentProcess.setText("Stopping cycle lights");
							currentProcess.getParent().getParent().repaint();
							break;
						}
					}
				}
				if (stop == true) {
					System.out.println("Stopping cycle lights");
					currentProcess.setText("Stopping cycle lights");
					currentProcess.getParent().getParent().repaint();
					break;
				}
				System.out.println("\nTurning lights off for:");
				t = 5;
				d = t * 1000;
				while (d != 0) {
					if (!Queues.getReadyQueue().isEmpty()) {
						if ((Queues.getReadyQueue().peek().type.equals("PanicButtonA")
								|| Queues.getReadyQueue().peek().type.equals("PanicButtonB")
								|| Queues.getReadyQueue().peek().type.equals("PanicButtonC")) && interrupts) {
							Process button = Queues.getReadyQueue().poll();
							button.state = Thread.State.RUNNABLE;
							interrupts = false;
							p.suspend();
							p.state = Thread.State.BLOCKED;
							currentProcess.setText("Interuptting " + p.type);
							queueUpdateAndDisplay();
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							currentProcess.getParent().repaint();
							currentProcess.getParent().getParent().repaint();
							System.out.println("Interuptting " + p.type);
							currentProcess.setText("Now Executing " + button.method);
							currentProcess.getParent().getParent().repaint();
							System.out.println("Now Executing " + button.type);
							String message = "";
							if (button.type.equals("PanicButtonA"))
								message = "Calling the police departement";
							if (button.type.equals("PanicButtonB"))
								message = "Calling the Fire Departement";
							if (button.type.equals("PanicButtonC"))
								message = "Calling the hospital";
							currentProcess.setText(message);
							currentProcess.getParent().repaint();
							currentProcess.getParent().getParent().repaint();
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							currentProcess.setText("Finished Executing " + button.method);
							currentProcess.getParent().repaint();
							currentProcess.getParent().getParent().repaint();
							background.setImage("house1.jpg");
							background.getParent().repaint();
							System.out.println("Finished Executing " + button.method);
							button.state = Thread.State.TERMINATED;
							interrupts = true;
							queueUpdateAndDisplay();
							stop = true;
							return;
						}
					} else {
						System.out.print(t + "s.. ");
						currentProcess.setText("Turning lights off for: " + t + "s.. ");
						currentProcess.getParent().getParent().repaint();
						try {
							Thread.sleep(1000);

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						t--;
						d -= 1000;
						if (stop == true) {
							System.out.println("Stopping cycle lights");
							currentProcess.setText("Stopping cycle lights");
							currentProcess.getParent().getParent().repaint();
							return;
						}
					}
				}
			}
		} else {
			int time = 5;
			long delay = time * 1000;
			while (delay != 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				time--;
				delay -= 1000;
				if (!Queues.getReadyQueue().isEmpty()) {
					if ((Queues.getReadyQueue().peek().type.equals("PanicButtonA")
							|| Queues.getReadyQueue().peek().type.equals("PanicButtonB")
							|| Queues.getReadyQueue().peek().type.equals("PanicButtonC")) && interrupts) {
						Queues.addToBlockedQueue(p);
						Process button = Queues.getReadyQueue().poll();
						button.state = Thread.State.RUNNABLE;
						interrupts = false;
						p.suspend();
						p.state = Thread.State.BLOCKED;
						currentProcess.setText("Interuptting " + p.type);
						queueUpdateAndDisplay();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						currentProcess.getParent().repaint();
						currentProcess.getParent().getParent().repaint();
						System.out.println("Interuptting " + p.type);
						currentProcess.setText("Now Executing " + button.method);
						currentProcess.getParent().getParent().repaint();
						System.out.println("Now Executing " + button.type);
						String message = "";
						if (button.type.equals("PanicButtonA"))
							message = "Calling the police departement";
						if (button.type.equals("PanicButtonB"))
							message = "Calling the Fire Departement";
						if (button.type.equals("PanicButtonC"))
							message = "Calling the hospital";
						currentProcess.setText(message);
						currentProcess.getParent().repaint();
						currentProcess.getParent().getParent().repaint();
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						currentProcess.setText("Finished Executing " + button.method);
						currentProcess.getParent().repaint();
						currentProcess.getParent().getParent().repaint();
						background.setImage("house1.jpg");
						background.getParent().repaint();
						System.out.println("Finished Executing " + button.method);
						button.state = Thread.State.TERMINATED;
						interrupts = true;
						// killing the thread and then resuming it because .resume is deprecated.
						Queues.getBlockedQueue().poll();
						queueUpdateAndDisplay();
						p.resume();
						p.state = Thread.State.RUNNABLE;
//					Process previousProcess = Queues.getBlockedQueue().poll();
//					p = new Process(previousProcess.priorityKey, Thread.State.RUNNABLE, previousProcess.type,
//							previousProcess.method, previousProcess.ID);
						System.out.println("Now Resuming " + p.method);
						currentProcess.setText("Now Resuming " + p.method);
						currentProcess.getParent().repaint();
//					currentProcess.getParent().getParent().repaint();
						try {
							Thread.sleep(delay);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			background.setImage("house1.jpg");
			background.getParent().repaint();
			System.out.println("Finished Executing " + p.type);
			currentProcess.setText("Finished Executing " + p.type);
			currentProcess.getParent().repaint();
			currentProcess.getParent().getParent().repaint();
			p.state = Thread.State.TERMINATED;
			cpu.setText("CPU Utilization: 0%");
			cpu.getParent().repaint();
		}
	}

	public static boolean getInterrupts() {
		return interrupts;
	}

	public static boolean getSoteriaStatus() {
		return soteriaOff;
	}

	public static void setStatus(boolean b) {
		soteriaOff = false;
	}

	public static void populate() {
		Keypad k1 = new Keypad("bassem");
		Keypad k2 = new Keypad("manga");
		Keypad k3 = new Keypad("waly");
		Keypad k4 = new Keypad("panda");
		Resources.keypads.add(k1);
		Resources.keypads.add(k2);
		Resources.keypads.add(k3);
		Resources.keypads.add(k4);
		PanicButton panic = new PanicButton();
		Resources.panicButtons.add(panic);
		Light cycleLights = new Light("cycle");
		Light light1 = new Light("light 1");
		Light light2 = new Light("light 2");

	}

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				new SoteriaTest();
			}
		}.start();
		new Thread() {
			public void run() {
				while (isRunning) {
					dispatchProcess();
				}
			}
		}.start();
//		populate();
//		Resources.keypads.get(0).openDoor("bassem");
//		Resources.keypads.get(1).openDoor("manga");
//		dispatchProcess();
		final LineChartExample demo = new LineChartExample("CPU utillization");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Window Opened!");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public static void repaintFromCurrentProcess() {
		currentProcess.getParent().getParent().repaint();
	}

}

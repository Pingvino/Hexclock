import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.util.Date;
import javax.swing.*;
public class Hexclock extends JFrame{
	boolean isAlreadyOneClick;
	public Hexclock() {
		super("Hexclock");
		JLabel clock = new JLabel();
		setBounds(200, 200, 400, 100);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
	}
	public static void main(String[] args) {
		final Hexclock Hex = new Hexclock();
		final JLabel L = new JLabel();
		L.setFont(new Font("Consolas", Font.BOLD, 100));
		//L.setFont(new Font("Arial", Font.PLAIN, 100));
		L.setHorizontalAlignment(JLabel.CENTER);
		L.setForeground(Color.WHITE);
		Hex.setVisible(true);
		Hex.add(L);
		Timer t = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date today = new Date();
				SimpleDateFormat hr = new SimpleDateFormat("HH");
				SimpleDateFormat min = new SimpleDateFormat("mm");
				SimpleDateFormat sec = new SimpleDateFormat("ss");
				String h = hr.format(today);
				String m = min.format(today);
				String s = sec.format(today);
				String time = h + m + s;
				Hex.getContentPane().setBackground(new Color(Integer.parseInt(h, 16), Integer.parseInt(m, 16), Integer.parseInt(s, 16)));
				L.setText("#" + time);
				L.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent event) {
						Hex.setLocation(event.getXOnScreen(), event.getYOnScreen());
					}
				});
				L.addMouseListener(new MouseListener() {
					public void mouseClicked(MouseEvent event) {
						if(event.getClickCount() == 2) {
							System.exit(0);
						}
					}
					public void mousePressed(MouseEvent event) {}
					public void mouseReleased(MouseEvent event) {}
					public void mouseEntered(MouseEvent event) {}
					public void mouseExited(MouseEvent event) {}
				});
			}
		});
		t.start();
	}
}

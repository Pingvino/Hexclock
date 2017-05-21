import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.util.Date;
import javax.swing.*;
public class Hexclock extends JFrame{
	public Hexclock() {
		super("Hexclock");
		setBounds(200, 200, 400, 100);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setVisible(true);
	}
	public static void main(String[] args) {
		final Hexclock Hex = new Hexclock();
		final JLabel L = new JLabel();
		L.setFont(new Font("Consolas", Font.BOLD, 100));
		L.setHorizontalAlignment(JLabel.CENTER);
		L.setForeground(Color.WHITE);
		Hex.add(L);
		L.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent event) {
				Hex.setLocation(event.getXOnScreen(), event.getYOnScreen());
			}
		});
		L.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent event) {
				if(event.getClickCount() == 2)
					System.exit(0);
			}
			public void mousePressed(MouseEvent event) {}
			public void mouseReleased(MouseEvent event) {}
			public void mouseEntered(MouseEvent event) {}
			public void mouseExited(MouseEvent event) {}
		});
		new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String now = "#" + new SimpleDateFormat("HHmmss").format(new Date());
				Hex.getContentPane().setBackground(Color.decode(now));
				L.setText(now);
			}
		}).start();
	}
}

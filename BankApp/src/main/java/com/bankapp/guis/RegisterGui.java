package com.bankapp.guis;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.bankapp.db_objs.MyJDBC;

public class RegisterGui extends BaseFrame {

  private static final String FONT_FAMILY = "Dialog";

  public RegisterGui() {
    super("Banking System - Register");
  }

  @Override
  protected void addGuiComponents() {

    JLabel bankingAppLabel = new JLabel("Banking System");
    bankingAppLabel.setBounds(0, 20, super.getWidth(), 40);
    bankingAppLabel.setFont(new Font(FONT_FAMILY, Font.BOLD, 32));
    bankingAppLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(bankingAppLabel);

    JLabel usernameLabel = new JLabel("Username");
    usernameLabel.setBounds(20, 120, getWidth() - 30, 24);
    usernameLabel.setFont(new Font(FONT_FAMILY, Font.PLAIN, 20));
    add(usernameLabel);

    JTextField usernameField = new JTextField();
    usernameField.setBounds(20, 160, getWidth() - 50, 40);
    usernameField.setFont(new Font(FONT_FAMILY, Font.PLAIN, 20));
    add(usernameField);

    JLabel passwordLabel = new JLabel("Password");
    passwordLabel.setBounds(20, 220, getWidth() - 50, 24);
    passwordLabel.setFont(new Font(FONT_FAMILY, Font.PLAIN, 20));
    add(passwordLabel);

    JPasswordField passwordField = new JPasswordField();
    passwordField.setBounds(20, 260, getWidth() - 50, 40);
    passwordField.setFont(new Font(FONT_FAMILY, Font.PLAIN, 20));
    add(passwordField);

    JLabel rePasswordLabel = new JLabel("Re-Type Password");
    rePasswordLabel.setBounds(20, 320, getWidth() - 50, 40);
    rePasswordLabel.setFont(new Font(FONT_FAMILY, Font.PLAIN, 20));
    add(rePasswordLabel);

    JPasswordField rePasswordField = new JPasswordField();
    rePasswordField.setBounds(20, 360, getWidth() - 50, 40);
    rePasswordField.setFont(new Font(FONT_FAMILY, Font.PLAIN, 20));
    add(rePasswordField);

    JButton registerButton = new JButton("Register");
    registerButton.setBounds(20, 460, getWidth() - 50, 40);
    registerButton.setFont(new Font(FONT_FAMILY, Font.BOLD, 20));

    registerButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        String username = usernameField.getText();

        String password = String.valueOf(passwordField.getPassword());

        String rePassword = String.valueOf(rePasswordField.getPassword());

        if (validateUserInput(username, password, rePassword)) {

          if (MyJDBC.register(username, password)) {

            RegisterGui.this.dispose();

            LoginGui loginGui = new LoginGui();
            loginGui.setVisible(true);

            JOptionPane.showMessageDialog(loginGui, "Registration successful!");

          } else {

            JOptionPane.showMessageDialog(RegisterGui.this, "Error: Username already taken.");

          }

        } else {

          JOptionPane.showMessageDialog(RegisterGui.this,
              "Error: Username must be at least 6 characters\n" + "and/or Password must match");

        }

      }
    });

    add(registerButton);

    JLabel loginLabel = new JLabel("<html><a href='#'>Already have an account? Login here.</a></html>");
    loginLabel.setBounds(0, 510, getWidth() - 10, 30);
    loginLabel.setFont(new Font(FONT_FAMILY, Font.PLAIN, 20));
    loginLabel.setHorizontalAlignment(SwingConstants.CENTER);

    loginLabel.addMouseListener(new MouseAdapter() {

      @Override
      public void mouseClicked(MouseEvent e) {

        RegisterGui.this.dispose();

        new LoginGui().setVisible(true);

      }
    });

    add(loginLabel);

  }

  private boolean validateUserInput(String username, String password, String rePassword) {

    if (username.length() == 0 || password.length() == 0 || rePassword.length() == 0)
      return false;

    if (username.length() < 6)
      return false;

    if (!password.equals(rePassword))
      return false;

    return true;

  }
}

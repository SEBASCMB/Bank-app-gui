package guis;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db_objs.User;

public class BankigAppGui extends BaseFrame implements ActionListener {

  private JTextField currentBalanceField;

  public JTextField getCurrentBalancField() {
    return currentBalanceField;
  }

  private static final String FONT_FAMILY = "Dialog";

  public BankigAppGui(User user) {

    super("Banking System", user);

  }

  @Override
  protected void addGuiComponents() {

    String welcomeMessage = "<html>" + "<body style='text-align: center'>" + "<b>Hello " + user.getUsername()
        + "</b><br>" + "What would you like to do today?</body></html>";

    JLabel welcomeMessageLabel = new JLabel(welcomeMessage);
    welcomeMessageLabel.setBounds(0, 20, getWidth() - 10, 40);
    welcomeMessageLabel.setFont(new Font(FONT_FAMILY, Font.PLAIN, 16));
    welcomeMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(welcomeMessageLabel);

    JLabel currentBalanceLabel = new JLabel("Current Balance");
    currentBalanceLabel.setBounds(0, 80, getWidth() - 10, 40);
    currentBalanceLabel.setFont(new Font(FONT_FAMILY, Font.BOLD, 22));
    currentBalanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(currentBalanceLabel);

    currentBalanceField = new JTextField("$ " + user.getCurrentBalance());
    currentBalanceField.setBounds(15, 120, getWidth() - 50, 40);
    currentBalanceField.setFont(new Font(FONT_FAMILY, Font.BOLD, 28));
    currentBalanceField.setHorizontalAlignment(SwingConstants.RIGHT);
    currentBalanceField.setEditable(false);
    add(currentBalanceField);

    JButton depositButton = new JButton("Deposit");
    depositButton.setBounds(15, 180, getWidth() - 50, 50);
    depositButton.setFont(new Font(FONT_FAMILY, Font.BOLD, 22));
    depositButton.addActionListener(this);
    depositButton.setHorizontalAlignment(SwingConstants.CENTER);
    add(depositButton);

    JButton withdrawButton = new JButton("Withdraw");
    withdrawButton.setBounds(15, 250, getWidth() - 50, 50);
    withdrawButton.setFont(new Font(FONT_FAMILY, Font.BOLD, 22));
    withdrawButton.addActionListener(this);
    withdrawButton.setHorizontalAlignment(SwingConstants.CENTER);
    add(withdrawButton);

    JButton pastTransactionsButton = new JButton("Past Transactions");
    pastTransactionsButton.setBounds(15, 320, getWidth() - 50, 50);
    pastTransactionsButton.setFont(new Font(FONT_FAMILY, Font.BOLD, 22));
    pastTransactionsButton.addActionListener(this);
    pastTransactionsButton.setHorizontalAlignment(SwingConstants.CENTER);
    add(pastTransactionsButton);

    JButton transferButton = new JButton("Transfer");
    transferButton.setBounds(15, 390, getWidth() - 50, 50);
    transferButton.setFont(new Font(FONT_FAMILY, Font.BOLD, 22));
    transferButton.addActionListener(this);
    transferButton.setHorizontalAlignment(SwingConstants.CENTER);
    add(transferButton);

    JButton logoutButton = new JButton("Logout");
    logoutButton.setBounds(15, 500, getWidth() - 50, 50);
    logoutButton.setFont(new Font(FONT_FAMILY, Font.BOLD, 22));
    logoutButton.addActionListener(this);
    logoutButton.setHorizontalAlignment(SwingConstants.CENTER);
    add(logoutButton);

  }

  @Override
  public void actionPerformed(ActionEvent e){

    String buttonPressed = e.getActionCommand();

    if( buttonPressed.equalsIgnoreCase("Logout") ){

      new LoginGui().setVisible(true);

      this.dispose();

      return;

    }

    BankingAppDialog bankingAppDialog = new BankingAppDialog(this, user);

    bankingAppDialog.setTitle(buttonPressed);

    if( buttonPressed.equalsIgnoreCase("Deposit") || buttonPressed.equalsIgnoreCase("Withdraw") || buttonPressed.equalsIgnoreCase("Transfer") ){

      bankingAppDialog.addCurrentBalanceAndAmount();

      if( buttonPressed.equalsIgnoreCase("Transfer") ){
        bankingAppDialog.addUserField();
      }

      bankingAppDialog.addActionButton(buttonPressed);
      bankingAppDialog.setVisible(true);

    }

  }

}

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class atm_interface extends JFrame {

    private String Account_Number="123456";
    private String PinNO="1234";
    private double balance=10000.0;
    private JLabel AccountNumberLabel;
    private JLabel PinLabel;
    private JTextField AccountNumberField;
    private JPasswordField PinField;
    private JButton LoginButton;
    private JLabel StatusLabel;
    private JButton WithdrawButton;
    private JButton DepositButton;
    private JLabel BalanceLabel;

  public  atm_interface(){
      initializeUI();
  }
    private void initializeUI() {
      setTitle("ATM_Interface");
      setSize(400, 250);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Exit the application. after clicking close button
      setLayout(new FlowLayout());
      AccountNumberLabel = new JLabel("Account Number:");
      PinLabel = new JLabel("PIN:");
      AccountNumberField = new JTextField(15);
      PinField = new JPasswordField(15);
      LoginButton = new JButton("Login");
      StatusLabel = new JLabel();
      WithdrawButton = new JButton("Withdraw");
      DepositButton = new JButton("Deposit");
      BalanceLabel = new JLabel("Balance: Rs.0.00");

      add(AccountNumberLabel);
      add(AccountNumberField);
      add(PinLabel);
      add(PinField);
      add(LoginButton);
      add(StatusLabel);
      add(WithdrawButton);
      add(DepositButton);
      add(BalanceLabel);

      LoginButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              onLogin();
          }
      });

      WithdrawButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              onWithdraw();
          }
      });

      DepositButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              onDeposit();
          }
      });

  }
    private void onLogin() {
        String inputAccountNumber = AccountNumberField.getText();
        String inputPin = new String(PinField.getPassword());

        if ((inputAccountNumber.equals(Account_Number)) && inputPin.equals(PinNO)) {  //comparing two strings
            StatusLabel.setText("Login Successful");
            WithdrawButton.setEnabled(true);
            DepositButton.setEnabled(true);
            updateBalanceLabel();
        } else {
            StatusLabel.setText("Invalid Account Number or PIN");
        }
    }

    private void onWithdraw() {
        String amountStr = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
        try {
            double amount = Double.parseDouble(amountStr);
            if (amount > 0 && amount <= balance) {
                balance =balance-amount;
                updateBalanceLabel();
                JOptionPane.showMessageDialog(this, "Withdrawal Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid amount or insufficient balance");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid amount.");
        }
    }

    private void onDeposit() {
        String amountStr = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
        try {
            double amount = Double.parseDouble(amountStr);
            if (amount > 0) {
                balance = balance+amount;
                updateBalanceLabel();
                JOptionPane.showMessageDialog(this, "Deposit Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a positive value.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid amount.");
        }
    }

    private void updateBalanceLabel() {
        BalanceLabel.setText("Balance: Rs." + balance);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new atm_interface().setVisible(true);
            }
        });
    }
}


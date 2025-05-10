package com.bankapp;

import javax.swing.SwingUtilities;

import com.bankapp.guis.LoginGui;

public class AppLauncher {

  public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        new LoginGui().setVisible(true);
        // new RegisterGui().setVisible(true);
        // new BankigAppGui(new User(1, "Sebastian", "123456", new
        // BigDecimal(10.00))).setVisible(true);
      }

    });

  }

}

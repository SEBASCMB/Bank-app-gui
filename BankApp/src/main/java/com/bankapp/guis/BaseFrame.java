package com.bankapp.guis;

import javax.swing.JFrame;

import com.bankapp.db_objs.User;

public abstract class BaseFrame extends JFrame {

  protected User user;

  public BaseFrame(String title) {
    initialize(title);
  }

  public BaseFrame(String title, User user) {

    this.user = user;
    initialize(title);

  }

  private void initialize(String title) {

    setTitle(title);

    setSize(420, 600);

    setDefaultCloseOperation(EXIT_ON_CLOSE);

    setLayout(null);

    setResizable(false);

    setLocationRelativeTo(null);

    addGuiComponents();

  }

  protected abstract void addGuiComponents();

}

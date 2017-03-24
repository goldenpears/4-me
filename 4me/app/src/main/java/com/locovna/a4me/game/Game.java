package com.locovna.a4me.game;

import processing.core.PApplet;

public class Game extends PApplet {

  int w = 7, h = 6, bs = 165;
  int[][] board = new int[h][w];
  int player = 1;

  @Override
  public void settings() {
    size(h * bs, h * bs, P2D);
  }

  public void setup() {
    ellipseMode(CORNER);
  }

  int p(int y, int x) {// p stands for piece
    return (y < 0 || x < 0 || y >= h || x >= w) ? 0 : board[y][x];

  }

  int getWinner() { //check row
    for (int y = 0; y < h; y++)
      for (int x = 0; x < w; x++)
        if (p(y, x) != 0 && p(y, x) == p(y, x + 1)
            && p(y, x) == p(y, x + 2)
            && p(y, x) == p(y, x + 3))
          return p(y, x);

    // check colum
    for (int y = 0; y < h; y++)
      for (int x = 0; x < w; x++)
        if (p(y, x) != 0 && p(y, x) == p(y + 1, x)
            && p(y, x) == p(y + 2, x)
            && p(y, x) == p(y + 3, x))
          return p(y, x);

    // check diagonal
    for (int y = 0; y < h; y++)
      for (int x = 0; x < w; x++)
        for (int d = -1; d <= 1; d += 2)
          if (p(y, x) != 0 && p(y, x) == p(y + 1 * d, x + 1)
              && p(y, x) == p(y + 2 * d, x + 2)
              && p(y, x) == p(y + 3 * d, x + 3))
            return p(y, x);

    //check for tie
    for (int y = 0; y < h; y++)
      for (int x = 0; x < w; x++)
        if (p(y, x) == 0) return 0; //winner
    return -1; // tie
  }

  // check where to drop the piece
  int nextSpace(int x) {
    for (int y = h - 1; y >= 0; y--)
      if (board[y][x] == 0)
        return y;
    return -1;
  }

  public void mousePressed() {
    int x = mouseX / bs, y = nextSpace(x);
    if (y >= 0) {
      board[y][x] = player;
      player = player == 1 ? 2 : 1;
    }
  }

  public void draw() {
    if (getWinner() == 0) {
      for (int j = 0; j < h; j++)
        for (int i = 0; i < w; i++) {
          fill(60, 61, 62); //primary color
          rect(i * bs, j * bs, bs, bs); // grid

          if (board[j][i] > 0) {
            //color for the first player
           if (board[j][i] == 1) {
              fill(200);
            } else {
              fill(0);
            }
            //color for the second player
            if (board[j][i] == 2) {
              fill(200);
            } else {
              fill(0);
            }

            ellipse(i * bs, j * bs, bs, bs);
          }
        }
    } else // restart
    {
      background(41, 41, 43);//dark primary color
      fill(255);
      textSize(64);
      text("Winner: Player# " + getWinner()
              + "\npress back to do it again!",
          width / 6, height / 3);

      if (keyPressed) {
        player = 1;
        for (int y = 0; y < h; y++)
          for (int x = 0; x < w; x++)
            board[y][x] = 0;
      }
    }
  }
}

import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import javax.sound.sampled.*;


public class TicTacToeGame extends JPanel implements MouseListener {

    Image title;
    Image background;
    Image oneplayer;
    Image twoplayer;
    Image poWins;
    Image lungWins;
    Image craneWins;
    Image mantisWins;
    Image monkeyWins;
    Image tigressWins;
    Image viperWins;
    Image shifuWins;
    Image po1;
    Image oogway1;
    Image oogwayWins;
    Image po1Wins;
    Image po;
    Image lung;
    Image crane;
    Image mantis;
    Image monkey;
    Image tigress;
    Image viper;
    Image shifu;
    Image home;
    Image home2;
    Image tie;
    Image selectPlayer;
    Image difficulty;
    String winSound = "woow_x.wav";
    String loseSound = "boo.wav";
    String tieSound = "gasp_x.wav";
    int screen = 1;             // which screen to show
    int players;                // how many players
    int turn = 1;               // whose turn (player 1 or 2)
    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    int e1 = 0;
    int f = 0;
    int g1 = 0;
    int h = 0;
    int i = 0;
    int character1 = 0;
    int character2 = 0;
    int difficultyLevel = 0;
    boolean haveWinner;

    public TicTacToeGame() {
        addMouseListener(this);

        //load images
        try {
            title = ImageIO.read(new File("Title.jpg"));
            background = ImageIO.read(new File("Mountains.png"));
            oneplayer = ImageIO.read(new File("One.png"));
            twoplayer = ImageIO.read(new File("Two.png"));
            po = ImageIO.read(new File("Panda.png"));
            lung = ImageIO.read(new File("Lung.png"));
            mantis = ImageIO.read(new File("mantis.png"));
            viper = ImageIO.read(new File("viper.png"));
            shifu = ImageIO.read(new File("shifu.png"));
            monkey = ImageIO.read(new File("monkey.png"));
            crane = ImageIO.read(new File("crane.png"));
            tigress = ImageIO.read(new File("tigress.png"));
            poWins = ImageIO.read(new File("poWins.jpg"));
            lungWins = ImageIO.read(new File("lungWins.jpg"));
            mantisWins = ImageIO.read(new File("MantisWins.jpg"));
            viperWins = ImageIO.read(new File("ViperWins.jpg"));
            shifuWins = ImageIO.read(new File("ShifuWins.jpg"));
            monkeyWins = ImageIO.read(new File("MonkeyWins.jpg"));
            craneWins = ImageIO.read(new File("CraneWins.jpg"));
            tigressWins = ImageIO.read(new File("TigressWins.jpg"));
            home = ImageIO.read(new File("home.png"));
            home2 = ImageIO.read(new File("home2.png"));
            tie = ImageIO.read(new File("tie.jpg"));
            selectPlayer = ImageIO.read(new File("selectPlayer.jpg"));
            po1 = ImageIO.read(new File("po.png"));
            oogway1 = ImageIO.read(new File("oogway.png"));
            po1Wins = ImageIO.read(new File("Po1Wins.jpg"));
            oogwayWins = ImageIO.read(new File("OogwayWins.jpg"));
            difficulty = ImageIO.read(new File("difficulty.jpg"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void paint(Graphics g) {
        if (screen == 1) {
            startScreen(g);
        } else if (screen == 2) {
            drawBoard(g);
        } else if (screen == 3) {
            delay();
            poWin(g);
        } else if (screen == 4) {
            delay();
            lungWin(g);
        } else if (screen == 5) {
            delay();
            tieScreen(g);
        } else if (screen == 6) {
            selectPlayer(g);
        } else if (screen == 7) {
            delay();
            mantisWin(g);
        } else if (screen == 8) {
            delay();
            viperWin(g);
        } else if (screen == 9) {
            delay();
            shifuWin(g);
        } else if (screen == 10) {
            delay();
            monkeyWin(g);
        } else if (screen == 11) {
            delay();
            craneWin(g);
        } else if (screen == 12) {
            delay();
            tigressWin(g);
        } else if (screen == 13) {
            drawBoard(g);
        } else if (screen == 14) {
            delay();
            po1Win(g);
        } else if (screen == 15) {
            delay();
            oogwayWin(g);
        } else if (screen == 16) {
            difficulty(g);
        }
    }

    public void selectPlayer(Graphics g) {
        g.drawImage(selectPlayer, 0, 0, null);
        g.setColor(Color.green);
        if (character1 == 1)
            g.drawRect(100, 110, 150, 260);
        else if (character1 == 2)
            g.drawRect(260, 150, 230, 215);
        else if (character1 == 3)
            g.drawRect(490, 110, 190, 280);
        else if (character1 == 4)
            g.drawRect(700, 110, 170, 280);
        if (character2 == 1)
            g.drawRect(75, 480, 200, 260);
        else if (character2 == 2)
            g.drawRect(310, 480, 130, 260);
        else if (character2 == 3)
            g.drawRect(480, 490, 230, 250);
        else if (character2 == 4)
            g.drawRect(685, 480, 190, 270);
    }

    public void startScreen(Graphics g) {
        g.drawImage(title, 0, 0, null);

        // draw 1 player button
        g.drawImage(oneplayer, 600, 500, null);
        // draw 2 player button
        g.drawImage(twoplayer, 600, 660, null);
    }

    public void difficulty(Graphics g) {
        g.drawImage(difficulty, 0, 0, null);
    }

    public void poWin(Graphics g) {
        g.drawImage(poWins, 0, 0, null);

        // back to home screen button
        g.drawImage(home, 600, 500, null);
    }

    public void po1Win(Graphics g) {
        g.drawImage(po1Wins, 0, 0, null);

        // back to home screen button
        g.drawImage(home, 600, 500, null);
    }

    public void oogwayWin(Graphics g) {
        g.drawImage(oogwayWins, 0, 0, null);

        // back to home screen button
        g.drawImage(home, 600, 500, null);
    }

    public void mantisWin(Graphics g) {
        g.drawImage(mantisWins, 0, 0, null);

        // back to home screen button
        g.drawImage(home, 600, 500, null);
    }

    public void tigressWin(Graphics g) {
        g.drawImage(tigressWins, 0, 0, null);

        // back to home screen button
        g.drawImage(home, 600, 500, null);
    }

    public void craneWin(Graphics g) {
        g.drawImage(craneWins, 0, 0, null);

        // back to home screen button
        g.drawImage(home, 600, 500, null);
    }

    public void shifuWin(Graphics g) {
        g.drawImage(shifuWins, 0, 0, null);

        // back to home screen button
        g.drawImage(home, 600, 500, null);
    }

    public void viperWin(Graphics g) {
        g.drawImage(viperWins, 0, 0, null);

        // back to home screen button
        g.drawImage(home, 600, 500, null);
    }

    public void monkeyWin(Graphics g) {
        g.drawImage(monkeyWins, 0, 0, null);

        // back to home screen button
        g.drawImage(home, 600, 500, null);
    }

    public void tieScreen(Graphics g) {
        g.drawImage(tie, 0, 0, null);

        // back to home screen button
        g.drawImage(home2, 600, 500, null);
    }

    public void lungWin(Graphics g) {
        g.drawImage(lungWins, 0, 0, null);

        // back to home screen button
        g.drawImage(home, 600, 500, null);
    }

    public void drawBoard(Graphics g) {
        g.drawImage(background, 0, 0, null);
        g.setColor(Color.white);
        g.fillRect(296, 0, 8, 900);
        g.fillRect(596, 0, 8, 900);
        g.fillRect(0, 296, 900, 8);
        g.fillRect(0, 596, 900, 8);

        if (a == 1) {
            if (character1 == 1)
                g.drawImage(crane, 0, 0, null);
            else if (character1 == 2)
                g.drawImage(mantis, 0, 0, null);
            else if (character1 == 3)
                g.drawImage(po, 0, 0, null);
            else if (character1 == 4)
                g.drawImage(viper, 0, 0, null);
            else if (players == 1)
                g.drawImage(po1, 0, 0, null);
        } else if (a == 2) {
            if (character2 == 1)
                g.drawImage(shifu, 0, 0, null);
            else if (character2 == 2)
                g.drawImage(tigress, 0, 0, null);
            else if (character2 == 3)
                g.drawImage(monkey, 0, 0, null);
            else if (character2 == 4)
                g.drawImage(lung, 0, 0, null);
            else if (players == 1)
                g.drawImage(oogway1, 0, 0, null);
        }
        if (b == 1) {
            if (character1 == 1)
                g.drawImage(crane, 300, 0, null);
            else if (character1 == 2)
                g.drawImage(mantis, 300, 0, null);
            else if (character1 == 3)
                g.drawImage(po, 300, 0, null);
            else if (character1 == 4)
                g.drawImage(viper, 300, 0, null);
            else if (players == 1)
                g.drawImage(po1, 300, 0, null);
        } else if (b == 2) {
            if (character2 == 1)
                g.drawImage(shifu, 300, 0, null);
            else if (character2 == 2)
                g.drawImage(tigress, 300, 0, null);
            else if (character2 == 3)
                g.drawImage(monkey, 300, 0, null);
            else if (character2 == 4)
                g.drawImage(lung, 300, 0, null);
            else if (players == 1)
                g.drawImage(oogway1, 300, 0, null);
        }
        if (c == 1) {
            if (character1 == 1)
                g.drawImage(crane, 600, 0, null);
            else if (character1 == 2)
                g.drawImage(mantis, 600, 0, null);
            else if (character1 == 3)
                g.drawImage(po, 600, 0, null);
            else if (character1 == 4)
                g.drawImage(viper, 600, 0, null);
            else if (players == 1)
                g.drawImage(po1, 600, 0, null);
        } else if (c == 2) {
            if (character2 == 1)
                g.drawImage(shifu, 600, 0, null);
            else if (character2 == 2)
                g.drawImage(tigress, 600, 0, null);
            else if (character2 == 3)
                g.drawImage(monkey, 600, 0, null);
            else if (character2 == 4)
                g.drawImage(lung, 600, 0, null);
            else if (players == 1)
                g.drawImage(oogway1, 600, 0, null);
        }
        if (d == 1) {
            if (character1 == 1)
                g.drawImage(crane, 0, 300, null);
            else if (character1 == 2)
                g.drawImage(mantis, 0, 300, null);
            else if (character1 == 3)
                g.drawImage(po, 0, 300, null);
            else if (character1 == 4)
                g.drawImage(viper, 0, 300, null);
            else if (players == 1)
                g.drawImage(po1, 0, 300, null);
        } else if (d == 2) {
            if (character2 == 1)
                g.drawImage(shifu, 0, 300, null);
            else if (character2 == 2)
                g.drawImage(tigress, 0, 300, null);
            else if (character2 == 3)
                g.drawImage(monkey, 0, 300, null);
            else if (character2 == 4)
                g.drawImage(lung, 0, 300, null);
            else if (players == 1)
                g.drawImage(oogway1, 0, 300, null);
        }
        if (e1 == 1) {
            if (character1 == 1)
                g.drawImage(crane, 300, 300, null);
            else if (character1 == 2)
                g.drawImage(mantis, 300, 300, null);
            else if (character1 == 3)
                g.drawImage(po, 300, 300, null);
            else if (character1 == 4)
                g.drawImage(viper, 300, 300, null);
            else if (players == 1)
                g.drawImage(po1, 300, 300, null);
        } else if (e1 == 2) {
            if (character2 == 1)
                g.drawImage(shifu, 300, 300, null);
            else if (character2 == 2)
                g.drawImage(tigress, 300, 300, null);
            else if (character2 == 3)
                g.drawImage(monkey, 300, 300, null);
            else if (character2 == 4)
                g.drawImage(lung, 300, 300, null);
            else if (players == 1)
                g.drawImage(oogway1, 300, 300, null);
        }
        if (f == 1) {
            if (character1 == 1)
                g.drawImage(crane, 600, 300, null);
            else if (character1 == 2)
                g.drawImage(mantis, 600, 300, null);
            else if (character1 == 3)
                g.drawImage(po, 600, 300, null);
            else if (character1 == 4)
                g.drawImage(viper, 600, 300, null);
            else if (players == 1)
                g.drawImage(po1, 600, 300, null);
        } else if (f == 2) {
            if (character2 == 1)
                g.drawImage(shifu, 600, 300, null);
            else if (character2 == 2)
                g.drawImage(tigress, 600, 300, null);
            else if (character2 == 3)
                g.drawImage(monkey, 600, 300, null);
            else if (character2 == 4)
                g.drawImage(lung, 600, 300, null);
            else if (players == 1)
                g.drawImage(oogway1, 600, 300, null);
        }
        if (g1 == 1) {
            if (character1 == 1)
                g.drawImage(crane, 0, 600, null);
            else if (character1 == 2)
                g.drawImage(mantis, 0, 600, null);
            else if (character1 == 3)
                g.drawImage(po, 0, 600, null);
            else if (character1 == 4)
                g.drawImage(viper, 0, 600, null);
            else if (players == 1)
                g.drawImage(po1, 0, 600, null);
        } else if (g1 == 2) {
            if (character2 == 1)
                g.drawImage(shifu, 0, 600, null);
            else if (character2 == 2)
                g.drawImage(tigress, 0, 600, null);
            else if (character2 == 3)
                g.drawImage(monkey, 0, 600, null);
            else if (character2 == 4)
                g.drawImage(lung, 0, 600, null);
            else if (players == 1)
                g.drawImage(oogway1, 0, 600, null);
        }
        if (h == 1) {
            if (character1 == 1)
                g.drawImage(crane, 300, 600, null);
            else if (character1 == 2)
                g.drawImage(mantis, 300, 600, null);
            else if (character1 == 3)
                g.drawImage(po, 300, 600, null);
            else if (character1 == 4)
                g.drawImage(viper, 300, 600, null);
            else if (players == 1)
                g.drawImage(po1, 300, 600, null);
        } else if (h == 2) {
            if (character2 == 1)
                g.drawImage(shifu, 300, 600, null);
            else if (character2 == 2)
                g.drawImage(tigress, 300, 600, null);
            else if (character2 == 3)
                g.drawImage(monkey, 300, 600, null);
            else if (character2 == 4)
                g.drawImage(lung, 300, 600, null);
            else if (players == 1)
                g.drawImage(oogway1, 300, 600, null);
        }
        if (i == 1) {
            if (character1 == 1)
                g.drawImage(crane, 600, 600, null);
            else if (character1 == 2)
                g.drawImage(mantis, 600, 600, null);
            else if (character1 == 3)
                g.drawImage(po, 600, 600, null);
            else if (character1 == 4)
                g.drawImage(viper, 600, 600, null);
            else if (players == 1)
                g.drawImage(po1, 600, 600, null);
        } else if (i == 2) {
            if (character2 == 1)
                g.drawImage(shifu, 600, 600, null);
            else if (character2 == 2)
                g.drawImage(tigress, 600, 600, null);
            else if (character2 == 3)
                g.drawImage(monkey, 600, 600, null);
            else if (character2 == 4)
                g.drawImage(lung, 600, 600, null);
            else if (players == 1)
                g.drawImage(oogway1, 600, 600, null);
        }

        checkWinner();
    }

    public void checkWinner() {
        haveWinner = false;
        // Check if player 1 wins (5 ways)
        if (a == 1 && b == 1 && c == 1) {
            haveWinner = true;
            if (character1 == 1)
                screen = 11; // Player 1 wins
            else if (character1 == 2)
                screen = 7;
            else if (character1 == 3)
                screen = 3;
            else if (character1 == 4)
                screen = 8;
            else if (players == 1)
                screen = 14;
        } else if (d == 1 && e1 == 1 && f == 1) {
            haveWinner = true;
            if (character1 == 1)
                screen = 11; // Player 1 wins
            else if (character1 == 2)
                screen = 7;
            else if (character1 == 3)
                screen = 3;
            else if (character1 == 4)
                screen = 8;
            else if (players == 1)
                screen = 14;
        } else if (g1 == 1 && h == 1 && i == 1) {
            haveWinner = true;
            if (character1 == 1)
                screen = 11; // Player 1 wins
            else if (character1 == 2)
                screen = 7;
            else if (character1 == 3)
                screen = 3;
            else if (character1 == 4)
                screen = 8;
            else if (players == 1)
                screen = 14;
        } else if (a == 1 && d == 1 && g1 == 1) {
            haveWinner = true;
            if (character1 == 1)
                screen = 11; // Player 1 wins
            else if (character1 == 2)
                screen = 7;
            else if (character1 == 3)
                screen = 3;
            else if (character1 == 4)
                screen = 8;
            else if (players == 1)
                screen = 14;
        } else if (b == 1 && e1 == 1 && h == 1) {
            haveWinner = true;
            if (character1 == 1)
                screen = 11; // Player 1 wins
            else if (character1 == 2)
                screen = 7;
            else if (character1 == 3)
                screen = 3;
            else if (character1 == 4)
                screen = 8;
            else if (players == 1)
                screen = 14;
        } else if (c == 1 && f == 1 && i == 1) {
            haveWinner = true;
            if (character1 == 1)
                screen = 11; // Player 1 wins
            else if (character1 == 2)
                screen = 7;
            else if (character1 == 3)
                screen = 3;
            else if (character1 == 4)
                screen = 8;
            else if (players == 1)
                screen = 14;
        } else if (a == 1 && e1 == 1 && i == 1) {
            haveWinner = true;
            if (character1 == 1)
                screen = 11; // Player 1 wins
            else if (character1 == 2)
                screen = 7;
            else if (character1 == 3)
                screen = 3;
            else if (character1 == 4)
                screen = 8;
            else if (players == 1)
                screen = 14;
        } else if (c == 1 && e1 == 1 && g1 == 1) {
            haveWinner = true;
            if (character1 == 1)
                screen = 11; // Player 1 wins
            else if (character1 == 2)
                screen = 7;
            else if (character1 == 3)
                screen = 3;
            else if (character1 == 4)
                screen = 8;
            else if (players == 1)
                screen = 14;
        }

        if (!haveWinner) {
            // Check if player 2 wins, given that player 1 has not
            if (a == 2 && b == 2 && c == 2) {
                haveWinner = true;
                if (character2 == 1)
                    screen = 9; // Player 2 wins
                else if (character2 == 2)
                    screen = 12;
                else if (character2 == 3)
                    screen = 10;
                else if (character2 == 4)
                    screen = 4;
                else if (players == 1)
                    screen = 15;
            } else if (d == 2 && e1 == 2 && f == 2) {
                haveWinner = true;
                if (character2 == 1)
                    screen = 9; // Player 2 wins
                else if (character2 == 2)
                    screen = 12;
                else if (character2 == 3)
                    screen = 10;
                else if (character2 == 4)
                    screen = 4;
                else if (players == 1)
                    screen = 15;
            } else if (g1 == 2 && h == 2 && i == 2) {
                haveWinner = true;
                if (character2 == 1)
                    screen = 9; // Player 2 wins
                else if (character2 == 2)
                    screen = 12;
                else if (character2 == 3)
                    screen = 10;
                else if (character2 == 4)
                    screen = 4;
                else if (players == 1)
                    screen = 15;
            } else if (a == 2 && d == 2 && g1 == 2) {
                haveWinner = true;
                if (character2 == 1)
                    screen = 9; // Player 2 wins
                else if (character2 == 2)
                    screen = 12;
                else if (character2 == 3)
                    screen = 10;
                else if (character2 == 4)
                    screen = 4;
                else if (players == 1)
                    screen = 15;
            } else if (b == 2 && e1 == 2 && h == 2) {
                haveWinner = true;
                if (character2 == 1)
                    screen = 9; // Player 2 wins
                else if (character2 == 2)
                    screen = 12;
                else if (character2 == 3)
                    screen = 10;
                else if (character2 == 4)
                    screen = 4;
                else if (players == 1)
                    screen = 15;
            } else if (c == 2 && f == 2 && i == 2) {
                haveWinner = true;
                if (character2 == 1)
                    screen = 9; // Player 2 wins
                else if (character2 == 2)
                    screen = 12;
                else if (character2 == 3)
                    screen = 10;
                else if (character2 == 4)
                    screen = 4;
                else if (players == 1)
                    screen = 15;
            } else if (a == 2 && e1 == 2 && i == 2) {
                haveWinner = true;
                if (character2 == 1)
                    screen = 9; // Player 2 wins
                else if (character2 == 2)
                    screen = 12;
                else if (character2 == 3)
                    screen = 10;
                else if (character2 == 4)
                    screen = 4;
                else if (players == 1)
                    screen = 15;
            } else if (c == 2 && e1 == 2 && g1 == 2) {
                haveWinner = true;
                if (character2 == 1)
                    screen = 9; // Player 2 wins
                else if (character2 == 2)
                    screen = 12;
                else if (character2 == 3)
                    screen = 10;
                else if (character2 == 4)
                    screen = 4;
                else if (players == 1)
                    screen = 15;
            }
        }

        // play the sound for winning against the computer
        if ((screen == 11 || screen == 7 || screen == 3 || screen == 8 || screen == 14) && players == 1)
        {
            TicTacToeGame.playSound(winSound);
        }

        // play the sound for losing against the computer
        if ((screen == 9 || screen == 12 || screen == 10 || screen == 4 || screen == 15) && players == 1)
        {
            TicTacToeGame.playSound(loseSound);
        }

        // check for a tie and play the sound for a tie
        if (!((screen == 11 || screen == 7 || screen == 3 || screen == 8 || screen == 14) || (screen == 9 || screen == 12 || screen == 10 || screen == 4 || screen == 15))) {
            if (a != 0 && b != 0 && c != 0 && d != 0 && e1 != 0 && f != 0 && g1 != 0 && h != 0 && i != 0) {
                // all squares have a move and no winner
                screen = 5;
                TicTacToeGame.playSound(tieSound);
            }
        }

        repaint();
    }

    public void mouseClicked(MouseEvent e) {
        // Get the x and y coordinates
        int x = e.getX();
        int y = e.getY();

        if (screen == 1) // on the title screen
        {
            if (x >= 660 && x <= 840 && y >= 700 && y <= 810) {
                screen = 6;
                players = 2;
            }
            if (x >= 660 && x <= 840 && y >= 500 && y <= 610) {
                players = 1;
                screen = 16;
            }
        } else if (screen == 2 && players == 2) // playing board and 2 players
        {
            if (x < 300 && y < 300 && a == 0) // clicked on box a
            {
                if (turn == 1) {
                    a = 1;
                    turn = 2;
                } else {
                    a = 2;
                    turn = 1;
                }
            }
            if (x >= 300 && x <= 600 && y >= 0 && y <= 300 && b == 0) // clicked on box b
            {
                if (turn == 1) {
                    b = 1;
                    turn = 2;
                } else {
                    b = 2;
                    turn = 1;
                }
            }
            if (x > 600 && y >= 0 && y <= 300 && c == 0) // clicked on box c
            {
                if (turn == 1) {
                    c = 1;
                    turn = 2;
                } else {
                    c = 2;
                    turn = 1;
                }
            }
            if (x < 300 && y >= 300 && y <= 600 && d == 0) // clicked on box d
            {
                if (turn == 1) {
                    d = 1;
                    turn = 2;
                } else {
                    d = 2;
                    turn = 1;
                }
            }
            if (x >= 300 && x <= 600 && y >= 300 && y <= 600 && e1 == 0) // clicked on box e1
            {
                if (turn == 1) {
                    e1 = 1;
                    turn = 2;
                } else {
                    e1 = 2;
                    turn = 1;
                }
            }
            if (x > 600 && y >= 300 && y <= 600 && f == 0) // clicked on box f
            {
                if (turn == 1) {
                    f = 1;
                    turn = 2;
                } else {
                    f = 2;
                    turn = 1;
                }
            }
            if (x < 300 && y > 600 && g1 == 0) // clicked on box g1
            {
                if (turn == 1) {
                    g1 = 1;
                    turn = 2;
                } else {
                    g1 = 2;
                    turn = 1;
                }
            }
            if (x >= 300 && x <= 600 && y > 600 && h == 0) // clicked on box h
            {
                if (turn == 1) {
                    h = 1;
                    turn = 2;
                } else {
                    h = 2;
                    turn = 1;
                }
            }
            if (x > 600 && y > 600 && i == 0) // clicked on box i
            {
                if (turn == 1) {
                    i = 1;
                    turn = 2;
                } else {
                    i = 2;
                    turn = 1;
                }
            }
        } else if (screen == 2 && players == 1) // playing board and 1 player
        {
            if (x < 300 && y < 300 && a == 0) // clicked on box a
            {
                if (turn == 1) {
                    a = 1;
                    turn = 2;
                }
            }
            if (x >= 300 && x <= 600 && y >= 0 && y <= 300 && b == 0) // clicked on box b
            {
                if (turn == 1) {
                    b = 1;
                    turn = 2;
                }
            }
            if (x > 600 && y >= 0 && y <= 300 && c == 0) // clicked on box c
            {
                if (turn == 1) {
                    c = 1;
                    turn = 2;
                }
            }
            if (x < 300 && y >= 300 && y <= 600 && d == 0) // clicked on box d
            {
                if (turn == 1) {
                    d = 1;
                    turn = 2;
                }
            }
            if (x >= 300 && x <= 600 && y >= 300 && y <= 600 && e1 == 0) // clicked on box e1
            {
                if (turn == 1) {
                    e1 = 1;
                    turn = 2;
                }
            }
            if (x > 600 && y >= 300 && y <= 600 && f == 0) // clicked on box f
            {
                if (turn == 1) {
                    f = 1;
                    turn = 2;
                }
            }
            if (x < 300 && y > 600 && g1 == 0) // clicked on box g1
            {
                if (turn == 1) {
                    g1 = 1;
                    turn = 2;
                }
            }
            if (x >= 300 && x <= 600 && y > 600 && h == 0) // clicked on box h
            {
                if (turn == 1) {
                    h = 1;
                    turn = 2;
                }
            }
            if (x > 600 && y > 600 && i == 0) // clicked on box i
            {
                if (turn == 1) {
                    i = 1;
                    turn = 2;
                }
            }

            int[] squares = {a, b, c, d, e1, f, g1, h, i};
            int j = 0;
            boolean moveLeft = false;
            while (j < squares.length) {
                if (squares[j] == 0) {
                    moveLeft = true;
                    break;
                }
                j++;
            }
            if (turn == 2 && !haveWinner && moveLeft) {
                computerMove();
            }
        } else if (screen == 3 || screen == 4 || screen == 5 || screen == 7 || screen == 8 || screen == 9 || screen == 10 || screen == 11 || screen == 12 || screen == 14 || screen == 15) {
            if (x >= 660 && x <= 840 && y >= 530 && y <= 650) {
                screen = 1;
                a = 0;
                b = 0;
                c = 0;
                d = 0;
                e1 = 0;
                f = 0;
                g1 = 0;
                h = 0;
                i = 0;
                turn = 1;
                character1 = 0;
                character2 = 0;
            }
        } else if (screen == 6) {
            if (x >= 100 && x <= 250 && y >= 110 && y <= 365) {
                character1 = 1;
            } else if (x >= 260 && x <= 500 && y >= 150 && y <= 365) {
                character1 = 2;
            } else if (x >= 490 && x <= 690 && y >= 110 && y <= 370) {
                character1 = 3;
            } else if (x >= 700 && x <= 840 && y >= 110 && y <= 370) {
                character1 = 4;
            }
            if (x >= 75 && x <= 260 && y >= 480 && y <= 740) {
                character2 = 1;
            } else if (x >= 320 && x <= 420 && y >= 480 && y <= 740) {
                character2 = 2;
            } else if (x >= 480 && x <= 685 && y >= 490 && y <= 740) {
                character2 = 3;
            } else if (x >= 690 && x <= 880 && y >= 480 && y <= 740) {
                character2 = 4;
            }
            if (character1 != 0 && character2 != 0)
                screen = 2;
        } else if (screen == 16) {
            if (x >= 50 && x <= 300 && y >= 300 && y <= 600) {
                screen = 2;
                difficultyLevel = 1;
            } else if (x >= 350 && x <= 550 && y >= 300 && y <= 600) {
                screen = 2;
                difficultyLevel = 2;
            } else if (x >= 600 && x <= 880 && y >= 300 && y <= 600) {
                screen = 2;
                difficultyLevel = 3;
            }
        }
        repaint();
    }

    public void computerMove() {
        boolean movemade = false;
        if (difficultyLevel == 3) {
            // check winning moves first
            if (a == 2 && b == 2 && c == 0) {
                c = 2;
                movemade = true;
            } else if (a == 2 && b == 0 && c == 2) {
                b = 2;
                movemade = true;
            } else if (a == 0 && b == 2 && c == 2) {
                a = 2;
                movemade = true;
            } else if (d == 2 && e1 == 2 && f == 0) {
                f = 2;
                movemade = true;
            } else if (d == 2 && e1 == 0 && f == 2) {
                e1 = 2;
                movemade = true;
            } else if (d == 0 && e1 == 2 && f == 2) {
                h = 2;
                movemade = true;
            } else if (g1 == 0 && h == 2 && i == 2) {
                g1 = 2;
                movemade = true;
                //vertical
            } else if (g1 == 2 && h == 0 && i == 2) {
                h = 2;
                movemade = true;
            } else if (g1 == 2 && h == 2 && i == 0) {
                i = 2;
                movemade = true;
            } else if (a == 2 && d == 2 && g1 == 0) {
                g1 = 2;
                movemade = true;
            } else if (a == 2 && d == 0 && g1 == 2) {
                d = 2;
                movemade = true;
            } else if (a == 0 && d == 2 && g1 == 2) {
                a = 2;
                movemade = true;
            } else if (b == 2 && e1 == 2 && h == 0) {
                h = 2;
                movemade = true;
            } else if (b == 2 && e1 == 0 && h == 2) {
                e1 = 2;
                movemade = true;
            } else if (b == 0 && e1 == 2 && h == 2) {
                b = 2;
                movemade = true;
            } else if (c == 2 && f == 2 && i == 0) {
                i = 2;
                movemade = true;
            } else if (c == 2 && f == 0 && i == 2) {
                f = 2;
                movemade = true;
            } else if (c == 0 && f == 2 && i == 2) {
                c = 2;
                movemade = true;
            } else if (a == 2 && e1 == 2 && i == 0) {
                i = 2;
                movemade = true;
            } else if (a == 2 && e1 == 0 && i == 2) {
                e1 = 2;
                movemade = true;
            } else if (a == 0 && e1 == 2 && i == 2) {
                a = 2;
                movemade = true;
            } else if (c == 2 && e1 == 2 && g1 == 0) {
                g1 = 2;
                movemade = true;
            } else if (c == 2 && e1 == 0 && g1 == 2) {
                e1 = 2;
                movemade = true;
            } else if (c == 0 && e1 == 2 && g1 == 2) {
                c = 2;
                movemade = true;
            } // now check blocking moves
            else if (a == 1 && b == 1 && c == 0) {
                c = 2;
                movemade = true;
            } else if (a == 1 && b == 0 && c == 1) {
                b = 2;
                movemade = true;
            } else if (a == 0 && b == 1 && c == 1) {
                a = 2;
                movemade = true;
            } else if (d == 1 && e1 == 1 && f == 0) {
                f = 2;
                movemade = true;
            } else if (d == 1 && e1 == 0 && f == 1) {
                e1 = 2;
                movemade = true;
            } else if (d == 0 && e1 == 1 && f == 1) {
                d = 2;
                movemade = true;
            } else if (g1 == 1 && h == 1 && i == 0) {
                i = 2;
                movemade = true;
            } else if (g1 == 1 && h == 0 && i == 1) {
                h = 2;
                movemade = true;
            } else if (g1 == 0 && h == 1 && i == 1) {
                g1 = 2;
                movemade = true;
            } else if (a == 1 && d == 1 && g1 == 0) {
                g1 = 2;
                movemade = true;
            } else if (a == 1 && d == 0 && g1 == 1) {
                d = 2;
                movemade = true;
            } else if (a == 0 && d == 1 && g1 == 1) {
                a = 2;
                movemade = true;
            } else if (b == 1 && e1 == 1 && h == 0) {
                h = 2;
                movemade = true;
            } else if (b == 1 && e1 == 0 && h == 1) {
                e1 = 2;
                movemade = true;
            } else if (b == 0 && e1 == 1 && h == 1) {
                b = 2;
                movemade = true;
            } else if (c == 1 && f == 1 && i == 0) {
                i = 2;
                movemade = true;
            } else if (c == 1 && f == 0 && i == 1) {
                f = 2;
                movemade = true;
            } else if (c == 0 && f == 1 && i == 1) {
                c = 2;
                movemade = true;
            } else if (a == 1 && e1 == 1 && i == 0) {
                i = 2;
                movemade = true;
            } else if (a == 1 && e1 == 0 && i == 1) {
                e1 = 2;
                movemade = true;
            } else if (a == 0 && e1 == 1 && i == 1) {
                a = 2;
                movemade = true;
            } else if (c == 1 && e1 == 1 && g1 == 0) {
                g1 = 2;
                movemade = true;
            } else if (c == 1 && e1 == 0 && g1 == 1) {
                e1 = 2;
                movemade = true;
            } else if (c == 0 && e1 == 1 && g1 == 1) {
                c = 2;
                movemade = true;
            } else if (!movemade) {
                int[] squares = {a, b, c, d, e1, f, g1, h, i};

                if (e1 == 0) {
                    e1 = 2;
                    movemade = true;
                } else {
                    while (!movemade) {
                        int j = (int) (Math.random() * 9);
                        if (squares[j] == 0) {
                            setSquare(j, 2);
                            movemade = true;
                        }
                    }
                }
            }
        } else if (difficultyLevel == 1) {
            int[] squares = {a, b, c, d, e1, f, g1, h, i};
            while (!movemade) {
                int j = (int) (Math.random() * 9);
                if (squares[j] == 0) {
                    setSquare(j, 2);
                    movemade = true;
                }
            }
        } else if (difficultyLevel == 2) {
            // check blocking moves only (easier than checking winning moves first)
            if (a == 1 && b == 1 && c == 0) {
                c = 2;
                movemade = true;
            } else if (a == 1 && b == 0 && c == 1) {
                b = 2;
                movemade = true;
            } else if (a == 0 && b == 1 && c == 1) {
                a = 2;
                movemade = true;
            } else if (d == 1 && e1 == 1 && f == 0) {
                f = 2;
                movemade = true;
            } else if (d == 1 && e1 == 0 && f == 1) {
                e1 = 2;
                movemade = true;
            } else if (d == 0 && e1 == 1 && f == 1) {
                d = 2;
                movemade = true;
            } else if (g1 == 1 && h == 1 && i == 0) {
                i = 2;
                movemade = true;
            } else if (g1 == 1 && h == 0 && i == 1) {
                h = 2;
                movemade = true;
            } else if (g1 == 0 && h == 1 && i == 1) {
                g1 = 2;
                movemade = true;
            } else if (a == 1 && d == 1 && g1 == 0) {
                g1 = 2;
                movemade = true;
            } else if (a == 1 && d == 0 && g1 == 1) {
                d = 2;
                movemade = true;
            } else if (a == 0 && d == 1 && g1 == 1) {
                a = 2;
                movemade = true;
            } else if (b == 1 && e1 == 1 && h == 0) {
                h = 2;
                movemade = true;
            } else if (b == 1 && e1 == 0 && h == 1) {
                e1 = 2;
                movemade = true;
            } else if (b == 0 && e1 == 1 && h == 1) {
                b = 2;
                movemade = true;
            } else if (c == 1 && f == 1 && i == 0) {
                i = 2;
                movemade = true;
            } else if (c == 1 && f == 0 && i == 1) {
                f = 2;
                movemade = true;
            } else if (c == 0 && f == 1 && i == 1) {
                c = 2;
                movemade = true;
            } else if (a == 1 && e1 == 1 && i == 0) {
                i = 2;
                movemade = true;
            } else if (a == 1 && e1 == 0 && i == 1) {
                e1 = 2;
                movemade = true;
            } else if (a == 0 && e1 == 1 && i == 1) {
                a = 2;
                movemade = true;
            } else if (c == 1 && e1 == 1 && g1 == 0) {
                g1 = 2;
                movemade = true;
            } else if (c == 1 && e1 == 0 && g1 == 1) {
                e1 = 2;
                movemade = true;
            } else if (c == 0 && e1 == 1 && g1 == 1) {
                c = 2;
                movemade = true;
            } else if (!movemade) {
                int[] squares = {a, b, c, d, e1, f, g1, h, i};
                while (!movemade) {
                    int j = (int) (Math.random() * 9);
                    if (squares[j] == 0) {
                        setSquare(j, 2);
                        movemade = true;
                    }
                }
            }
        }
        if (movemade) {
            turn = 1;
        }
    }

    public void setSquare(int squareNumber, int playerNumber) {
        if (squareNumber == 0)
            a = playerNumber;
        else if (squareNumber == 1)
            b = playerNumber;
        else if (squareNumber == 2)
            c = playerNumber;
        else if (squareNumber == 3)
            d = playerNumber;
        else if (squareNumber == 4)
            e1 = playerNumber;
        else if (squareNumber == 5)
            f = playerNumber;
        else if (squareNumber == 6)
            g1 = playerNumber;
        else if (squareNumber == 7)
            h = playerNumber;
        else if (squareNumber == 8)
            i = playerNumber;
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void delay() {
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static synchronized void playSound(final String url) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    File f = new File(url);
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }

}
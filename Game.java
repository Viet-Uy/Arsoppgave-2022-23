import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;


class Game {

int playerHP;
String weapon;  

JFrame window;
Container con;
JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelNumber;
Font titleFont = new Font("Times New Roman", Font.PLAIN, 90); //Setter font
Font normalFont = new Font("Times New Roman", Font.PLAIN, 30); //Setter font for startknapp
Font playerPanelFont = new Font("Times New Roman", Font.PLAIN, 25);
JButton startButton, valg1, valg2, valg3, valg4 ;
JTextArea mainTextArea;

TitleScreenHandler tsHandler = new TitleScreenHandler();
    public static void main(String args[]){
        new Game();
        
    }

    public Game(){

        window = new JFrame();
        window.setSize(800, 600); //Size på screen
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Setter default closing method til exit on close, ellers slutter ikke programmet riktig
        window.getContentPane().setBackground(Color.black); //Set farge på bakgrunn
        window.setLayout(null); //Game har eget layout, vi vil lage et eget custom layout

        con = window.getContentPane(); //En base som du kan putte diverse ting i, navn på spillet, button osv.

        titleNamePanel = new JPanel();//Lager et panell for å sette navn
        titleNamePanel.setBounds(100, 100, 600, 150); //Hvilket kordinat og hvor stor panellen skal være
        titleNamePanel.setBackground(Color.black);//Setter bakgrunnfarge for å panellen der du skal putte navnet på spillet
        titleNameLabel = new JLabel("Hei"); //Lager et boks der du kan skrive navnet til spillet
        titleNameLabel.setForeground(Color.white); //Tekstfarge
        titleNameLabel.setFont(titleFont);//Gir en font til titleNameLabelen

        startButtonPanel = new JPanel();//Lager en Startknapp
        startButtonPanel.setBounds(300, 400, 200, 100); //Hvor stor startknappen er
        startButtonPanel.setBackground(Color.black);//Bakgrunnsfarge på panelen til startknappen
        
        startButton = new JButton("START"); //Lager en ny knapp ved å bruke new JButton
        startButton.setBackground(Color.black); //Farge på background
        startButton.setForeground(Color.white);//Farge på tekst
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false); //Fjerner windows autoselect white border
        startButton.addActionListener(tsHandler); //Når du klikker på knappen så kaller den TitleScreenHandler funksjonen


        titleNamePanel.add(titleNameLabel);//Setter labelen inni panellen, vi har lagd det, men ikke puttet det inn før nå
        startButtonPanel.add(startButton);//Setter startknappen inni panellen

        con.add(titleNamePanel);//Putter panellen i basen/containeren
        con.add(startButtonPanel);//Putter startknappen i basen/containeren

        window.setVisible(true);//Vi har laget screenen, men den må gjøres synlig ved bruk av denne linjen
    }

    public void createGameScreen(){

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        
        mainTextArea = new JTextArea("Hello"); //Input boks for å skrive ting i
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true); //Gjør at teksten legger seg ned istendenfor å gå ut av skjermen
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250,350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1)); //Lager rad og kolonne 
        con.add(choiceButtonPanel);

        valg1 = new JButton("valg 1"); //Lager en knapp
        valg1.setBackground(Color.black);
        valg1.setForeground(Color.white);
        valg1.setFont(normalFont);
        valg1.setFocusPainted(false);
        choiceButtonPanel.add(valg1);

        valg2 = new JButton("valg 2"); //Lager en knapp
        valg2.setBackground(Color.black);
        valg2.setForeground(Color.white);
        valg2.setFont(normalFont);
        valg2.setFocusPainted(false);
        choiceButtonPanel.add(valg2);

        valg3 = new JButton("valg 3"); //Lager en knapp
        valg3.setBackground(Color.black);
        valg3.setForeground(Color.white);
        valg3.setFont(normalFont);
        valg3.setFocusPainted(false);
        choiceButtonPanel.add(valg3);

        valg4 = new JButton("valg 4"); //Lager en knapp-
        valg4.setBackground(Color.black);
        valg4.setForeground(Color.white);
        valg4.setFont(normalFont);
        valg4.setFocusPainted(false);
        choiceButtonPanel.add(valg4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        playerPanel.setVisible(true);
        con.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(playerPanelFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(playerPanelFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(playerPanelFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponLabelNumber = new JLabel();
        weaponLabelNumber.setFont(playerPanelFont);
        weaponLabelNumber.setForeground(Color.white);
        playerPanel.add(weaponLabelNumber);
        

        playerStats();

    }


    public void playerStats(){
        playerSetup spiller = new playerSetup(15);
        weapon starterWeapon = new weapon("Stick", 5);
        playerHP = spiller.getHp();
        weapon = starterWeapon.getWeapon();
        weaponLabelNumber.setText(weapon);
        hpLabelNumber.setText("" + playerHP);
    }



    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            createGameScreen();
        }
    }

}
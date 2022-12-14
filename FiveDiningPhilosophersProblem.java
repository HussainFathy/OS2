package javafxapplication8;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author hussa
 */
public class FiveDiningPhilosophersProblem_1 extends Application {

    static volatile boolean[] chopsticks = {false, false, false, false, false};// false if the chopsticks is not in use ; true if its not free
    static volatile boolean[] isEating = {false, false, false, false, false};
    static volatile boolean[] isHungry = {false, false, false, false, false};
    Philosopher p0 = new Philosopher(0);
    Philosopher p1 = new Philosopher(1);
    Philosopher p2 = new Philosopher(2);
    Philosopher p3 = new Philosopher(3);
    Philosopher p4 = new Philosopher(4);
//    Thread t11 = new Thread(p0);

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        new Thread(p0).start();
        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();
        new Thread(p4).start();
        p0.join();
        p1.join();
        p2.join();
        p3.join();
        p4.join();

        Group root = new Group();
        Scene scene = new Scene(root, 804, 698);

        /* the table*/
        Circle circleb = new Circle();
        circleb.setCenterX(389);
        circleb.setCenterY(446);
        circleb.setRadius(130);
        circleb.setFill(Color.rgb(100, 10, 18));


        /*philosopher 0*/
        Circle circle0 = new Circle();
        circle0.setCenterX(270);
        circle0.setCenterY(582);
        circle0.setRadius(39);
        circle0.setFill(Color.BLACK);

        /*philosopher 1*/
        Circle circle1 = new Circle();
        circle1.setCenterX(506);
        circle1.setCenterY(582);
        circle1.setRadius(39);
        circle1.setFill(Color.BLACK);

        /*philosopher 2*/
        Circle circle2 = new Circle();
        circle2.setCenterX(550);
        circle2.setCenterY(370);
        circle2.setRadius(39);
        circle2.setFill(Color.BLACK);

        /*philosopher 3*/
        Circle circle3 = new Circle();
        circle3.setCenterX(388);
        circle3.setCenterY(265);
        circle3.setRadius(39);
        circle3.setFill(Color.BLACK);

        /*philosopher 4*/
        Circle circle4 = new Circle();
        circle4.setCenterX(223);
        circle4.setCenterY(378);
        circle4.setRadius(39);
        circle4.setFill(Color.BLACK);

        Circle circleHun0 = new Circle();
        circleHun0.setCenterX(270);
        circleHun0.setCenterY(582);
        circleHun0.setRadius(39);
        circleHun0.setFill(Color.rgb(227, 225, 0));
        circleHun0.setVisible(false);

        Circle circleHun1 = new Circle();
        circleHun1.setCenterX(506);
        circleHun1.setCenterY(582);
        circleHun1.setRadius(39);
        circleHun1.setFill(Color.rgb(227, 225, 0));
        circleHun1.setVisible(false);

        Circle circleHun2 = new Circle();
        circleHun2.setCenterX(550);
        circleHun2.setCenterY(370);
        circleHun2.setRadius(39);
        circleHun2.setFill(Color.rgb(227, 225, 0));
        circleHun2.setVisible(false);

        Circle circleHun3 = new Circle();
        circleHun3.setCenterX(388);
        circleHun3.setCenterY(265);
        circleHun3.setRadius(39);
        circleHun3.setFill(Color.rgb(227, 225, 0));
        circleHun3.setVisible(false);

        Circle circleHun4 = new Circle();
        circleHun4.setCenterX(223);
        circleHun4.setCenterY(378);
        circleHun4.setRadius(39);
        circleHun4.setFill(Color.rgb(227, 225, 0));
        circleHun4.setVisible(false);

        Circle circleEat0 = new Circle();
        circleEat0.setCenterX(270);
        circleEat0.setCenterY(582);
        circleEat0.setRadius(39);
        circleEat0.setFill(Color.rgb(0, 0, 160));
        circleEat0.setVisible(false);

        Circle circleEat1 = new Circle();
        circleEat1.setCenterX(506);
        circleEat1.setCenterY(582);
        circleEat1.setRadius(39);
        circleEat1.setFill(Color.rgb(0, 0, 160));
        circleEat1.setVisible(false);

        Circle circleEat2 = new Circle();
        circleEat2.setCenterX(550);
        circleEat2.setCenterY(370);
        circleEat2.setRadius(39);
        circleEat2.setFill(Color.rgb(0, 0, 160));
        circleEat2.setVisible(false);

        Circle circleEat3 = new Circle();
        circleEat3.setCenterX(388);
        circleEat3.setCenterY(265);
        circleEat3.setRadius(39);
        circleEat3.setFill(Color.rgb(0, 0, 160));
        circleEat3.setVisible(false);

        Circle circleEat4 = new Circle();
        circleEat4.setCenterX(223);
        circleEat4.setCenterY(378);
        circleEat4.setRadius(39);
        circleEat4.setFill(Color.rgb(0, 0, 160));
        circleEat4.setVisible(false);

        Circle circleEating = new Circle();
        circleEating.setCenterX(650);
        circleEating.setCenterY(72);
        circleEating.setRadius(24);
        circleEating.setFill(Color.rgb(0, 0, 160));

        Circle circleHungry = new Circle();
        circleHungry.setCenterX(434);
        circleHungry.setCenterY(72);
        circleHungry.setRadius(24);
        circleHungry.setFill(Color.rgb(227, 225, 0));

        Circle circleThinking = new Circle();
        circleThinking.setCenterX(243);
        circleThinking.setCenterY(72);
        circleThinking.setRadius(24);
        circleThinking.setFill(Color.BLACK);

        Label Hun = new Label("User is eating :");
        Hun.setLayoutX(526);
        Hun.setLayoutY(62);

        Label Eat = new Label("User is hungry :");
        Eat.setLayoutX(303);
        Eat.setLayoutY(62);

        Label Thk = new Label("User is thinking :");
        Thk.setLayoutX(106);
        Thk.setLayoutY(62);
 
        
        
        /*philosopher 0 hungry button */
        ToggleButton btn0 = new ToggleButton();
        btn0.setLayoutX(188);
        btn0.setLayoutY(626);
        btn0.setText("Philosopher 0");
        btn0.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Thread t = new Thread(new Runnable() { // a thread is created

                    @Override
                    public void run() {

                        if (btn0.isSelected()) {// if the button is clicked

                            circleHun0.setVisible(true);// Yellow hungry circle is showed

                            isHungry[0] = true;// the philosopher is marked as hungry 
                            try {
                                if (p0.grab(0)) {// the philosopher is marked as hungry 
                                    p0.sleep(1000); // wait a sec to show the Yellow outpu
                                    circleHun0.setVisible(false);// hide the hungry circle

                                    circleEat0.setVisible(true);// shows the Blue "eating" circle
                                    p0.eat(); // simulate eating by sleeping the process 
                                    p0.release(0); // after eating the chopsticks are released 

                                    isEating[0] = false;
                                    isHungry[0] = false;
                                    circleEat0.setVisible(false);
                                    btn0.setSelected(false);

                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(FiveDiningPhilosophersProblem.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {// if the button was relesed 

                            try {
                                circleHun0.setVisible(false);
                                circleEat0.setVisible(false);
                                isEating[0] = false;
                                isHungry[0] = false;
                                p0.release(0);

                            } catch (InterruptedException ex) {
                                Logger.getLogger(FiveDiningPhilosophersProblem.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }

                    }

                });

                t.start();
            }
        });


        /*philosopher 1 hungry button */
        ToggleButton btn1 = new ToggleButton();
        btn1.setLayoutX(486);
        btn1.setLayoutY(626);
        btn1.setText("Philosopher 1");
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {

                        if (btn1.isSelected()) {

                            circleHun1.setVisible(true);

                            isHungry[1] = true;
                            try {
                                if (p1.grab(1)) {
                                    p1.sleep(1000);
                                    circleHun1.setVisible(false);

                                    circleEat1.setVisible(true);
                                    p1.eat();
                                    p1.release(1);

                                    isEating[1] = false;
                                    isHungry[1] = false;
                                    circleEat1.setVisible(false);
                                    btn1.setSelected(false);

                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(FiveDiningPhilosophersProblem.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {

                            try {
                                circleHun1.setVisible(false);
                                circleEat1.setVisible(false);
                                isEating[1] = false;
                                isHungry[1] = false;
                                p1.release(1);

                            } catch (InterruptedException ex) {
                                Logger.getLogger(FiveDiningPhilosophersProblem.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }

                    }

                });

                t.start();
            }
        });

        /*philosopher 2 hungry button */
        ToggleButton btn2 = new ToggleButton();
        btn2.setLayoutX(602);
        btn2.setLayoutY(356);
        btn2.setText("Philosopher 2");
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {

                        if (btn2.isSelected()) {

                            circleHun2.setVisible(true);

                            isHungry[2] = true;
                            try {
                                if (p2.grab(2)) {
                                    p2.sleep(1000);
                                    circleHun2.setVisible(false);

                                    circleEat2.setVisible(true);
                                    p2.eat();
                                    p2.release(2);

                                    isEating[2] = false;
                                    isHungry[2] = false;
                                    circleEat2.setVisible(false);
                                    btn2.setSelected(false);

                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(FiveDiningPhilosophersProblem.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {

                            try {
                                circleHun2.setVisible(false);
                                circleEat2.setVisible(false);
                                isEating[2] = false;
                                isHungry[2] = false;
                                p2.release(2);

                            } catch (InterruptedException ex) {
                                Logger.getLogger(FiveDiningPhilosophersProblem.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }

                    }

                });

                t.start();
            }
        });


        /*philosopher 3 hungry button */
        ToggleButton btn3 = new ToggleButton();
        btn3.setLayoutX(330);
        btn3.setLayoutY(190);
        btn3.setText("Philosopher 3");
        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {

                        if (btn3.isSelected()) {

                            circleHun3.setVisible(true);

                            isHungry[3] = true;
                            try {
                                if (p3.grab(3)) {
                                    p3.sleep(1000);
                                    circleHun3.setVisible(false);

                                    circleEat3.setVisible(true);
                                    p3.eat();
                                    p3.release(3);

                                    isEating[3] = false;
                                    isHungry[3] = false;
                                    circleEat3.setVisible(false);
                                    btn3.setSelected(false);

                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(FiveDiningPhilosophersProblem.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {

                            try {
                                circleHun3.setVisible(false);
                                circleEat3.setVisible(false);
                                isEating[3] = false;
                                isHungry[3] = false;
                                p3.release(3);

                            } catch (InterruptedException ex) {
                                Logger.getLogger(FiveDiningPhilosophersProblem.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }

                    }

                });

                t.start();
            }
        });


        /*philosopher 4 hungry button */
        ToggleButton btn4 = new ToggleButton();
        btn4.setLayoutX(63);
        btn4.setLayoutY(364);
        btn4.setText("Philosopher 4");
        btn4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {

                        if (btn4.isSelected()) {

                            circleHun4.setVisible(true);

                            isHungry[4] = true;
                            try {
                                if (p4.grab(4)) {
                                    p4.sleep(1000);
                                    circleHun4.setVisible(false);

                                    circleEat4.setVisible(true);
                                    p4.eat();
                                    p4.release(4);

                                    isEating[4] = false;
                                    isHungry[4] = false;
                                    circleEat4.setVisible(false);
                                    btn4.setSelected(false);

                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(FiveDiningPhilosophersProblem.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {

                            try {
                                circleHun4.setVisible(false);
                                circleEat4.setVisible(false);
                                isEating[4] = false;
                                isHungry[4] = false;
                                p4.release(4);

                            } catch (InterruptedException ex) {
                                Logger.getLogger(FiveDiningPhilosophersProblem.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }

                    }

                });

                t.start();
            }
        });


        //shows all the elements in the GUI
        root.getChildren().add(btn0);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        root.getChildren().add(circleb);
        root.getChildren().add(circle0);
        root.getChildren().add(circle1);
        root.getChildren().add(circle2);
        root.getChildren().add(circle3);
        root.getChildren().add(circle4);
        root.getChildren().add(circleHun0);
        root.getChildren().add(circleHun1);
        root.getChildren().add(circleHun2);
        root.getChildren().add(circleHun3);
        root.getChildren().add(circleHun4);
        root.getChildren().add(circleEat0);
        root.getChildren().add(circleEat1);
        root.getChildren().add(circleEat2);
        root.getChildren().add(circleEat3);
        root.getChildren().add(circleEat4);
        root.getChildren().add(circleEating);
        root.getChildren().add(circleHungry);
        root.getChildren().add(circleThinking);
        root.getChildren().add(Hun);
        root.getChildren().add(Eat);
        root.getChildren().add(Thk);

        primaryStage.setTitle("Dining philosepher ");
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public static class Philosopher extends Thread {

        public int number;

        Philosopher(int num) {
            number = num;

        }

        @Override
        public void run() {
            System.out.println("thread is running...");
        }
        public Semaphore mutex = new Semaphore(1);
        //the method grabs the chopstick  

        synchronized boolean grab(int phnum) throws InterruptedException {
            try {

                while (!isfree(phnum)) {// while one of the right or left Philosopher is eating
                     // sleep a random time from 100 ms to 2 sec then check again
                    int min = 100;
                    int max = 2000;
                    int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
                    this.sleep(random_int);
                    

                }

                //acquires a permit from the semaphore  
                chopsticks[phnum] = true;
                chopsticks[(phnum + 4) % 5] = true;
                isEating[phnum] = true;

                this.notifyAll();
                return true;

            } catch (InterruptedException e) {
                this.wait();
                e.printStackTrace(System.out);

                chopsticks[phnum] = true;
                chopsticks[(phnum + 4) % 5] = true;
                isEating[phnum] = true;

                this.notifyAll();
                return true;

            }

        }//end of grab() method
//release the chopstick  

        synchronized void release(int phnum) throws InterruptedException {
//releases an acquire a permit and increases the number of available permits by on
            if (isEating[phnum]) {
                try {

                    chopsticks[phnum] = false;
                    chopsticks[(phnum + 4) % 5] = false;
                    isEating[phnum] = false;
                    this.notifyAll();

                } catch (Exception e) {
                    this.wait();

                    chopsticks[phnum] = false;
                    chopsticks[(phnum + 4) % 5] = false;
                    isEating[phnum] = false;
                    this.notifyAll();

                }
            }

        }//end of release() method

//checks if both chopsticks are free or not 
        synchronized boolean isfree(int phnum) {

            if (isEating[(phnum + 1) % 5] == false && isEating[(phnum + 4) % 5] == false) {

                return true;
            }
            return false;
        }//end of isfree() method 

//        public void run() {
//
//        } //end of run() method  
        void eat() {
            try {

                this.sleep(8000);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }// end of eat() method  

    } // end of philosophers class

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }

}

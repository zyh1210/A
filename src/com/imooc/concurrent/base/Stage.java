package com.imooc.concurrent.base;

/**
 * 隋唐演义大戏舞台
 */
public class Stage extends Thread{
    @Override
    public void run() {
        ArmyRunnable armyTaskOfSuiDynasty=new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt=new ArmyRunnable();

        Thread armyOfSuiDynasty=new Thread(armyTaskOfSuiDynasty,"隋军");
        Thread armyOfRevolt=new Thread(armyTaskOfRevolt,"农民起义军");

        //启动线程，让军队开始作战
        armyOfSuiDynasty.start();
        armyOfRevolt.start();


        //舞台休眠
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        armyTaskOfSuiDynasty.keepRunning=false;
        armyTaskOfRevolt.keepRunning=false;

        try {
            armyOfRevolt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        new Stage().start();
    }
}

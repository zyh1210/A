package com.imooc.concurrent.base;

//军队线程
//模拟作战双方的行为
public class ArmyRunnable implements Runnable {
    //volatitle保证了线程可以正确的读取其他线程写入的值
    volatile boolean keepRunning=true;
    @Override
    public void run() {
        while (keepRunning){
            //发动5连击
            for (int i=0;i>5;i++){
                System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]");
                //让出了处理器时间，下次该谁进攻还不一定呢！
                Thread.yield();
            }
        }
        //修改

    }
}

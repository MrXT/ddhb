import java.util.Date;



/*
同步函数的使用的锁是this；

同步函数和同步代码块的区别：
同步函数的锁是固定的this。

同步代码块的锁是任意的对象。

建议使用同步代码块。


*/
class Ticket implements Runnable
{
    private  int num = 100;
    Object obj = new Object();
    boolean flag = true;
    public void run()
    {
//      System.out.println("this:"+this);

        if(flag)
            while(true)
            {
                synchronized(this)
                {
                    if(num>0)
                    {
                        System.out.println(Thread.currentThread().getName()+".....obj...."+num--);
                        try{Thread.sleep(10);}catch (InterruptedException e){}    
                    }else{
                        break;
                    }
                }
            }
        else
            while(true){
                this.show();
                if(num == 0){
                    break;
                }
            }
    }

    public synchronized void show()
    {
        if(num>0)
        {
            System.out.println(Thread.currentThread().getName()+".....function...."+num--);
            try{Thread.sleep(10);}catch (InterruptedException e){}
        }
    }
}

class SynFunctionLockDemo 
{
    public static void main(String[] args) 
    {   
        StringBuilder sb = new StringBuilder();
        String tcp="1";
        String h1 ="cmd%0003&gw_ipv4%";
        String h2 = "&gw_ipv6%";
        String h3 = "&is_tcp%";
        String h4="&node_ipv6%";
        String h5 ="&Mib_name%LedControl&Var_name%";
        String h6 ="Level";
        String h7="&var_value%";
        sb.append(h1).append(h2).append(h3).append(tcp).append(h4).append(h5).append(h6).append(h7);
        System.out.println(sb.toString());
    }
}

package src.com.company;

import java.util.Scanner;

public class fcfs {
    static String name[];
    static int arrivaltime[];
    static int bursttime[];
    static int completiontime[];
    static int turnaroundtime[];
    static int waitingtime[];
    static int responsetime[];
    static int n;
    static float avgTAT;
    static float avgWT;
    fcfs()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number of Processes: ");
        n = sc.nextInt();
        name = new String[n];
        arrivaltime = new int[n];
        bursttime = new int[n];
        completiontime = new int[n];
        turnaroundtime = new int[n];
        waitingtime = new int[n];
        responsetime = new int[n];
    }
    void input(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Enter Process " + (i + 1) + " details");
            System.out.print("Name: ");
            name[i] = sc.next();
            System.out.print("Arrival time: ");
            arrivaltime[i] = sc.nextInt();
            System.out.print("Burst time: ");
            bursttime[i] = sc.nextInt();
        }
    }
    void calculate(){
        int ct = 0;
        int sumTAT = 0;
        int sumWT = 0;
        for(int i = 0;i < n;i++) {
            if (ct >= arrivaltime[i]) {
                ct = ct + bursttime[i];
            } else {
                ct = arrivaltime[i] + bursttime[i];
            }
            completiontime[i] = ct;
            turnaroundtime[i] = completiontime[i] - arrivaltime[i];
            waitingtime[i] = turnaroundtime[i] - bursttime[i];
            responsetime[i] = waitingtime[i];
            sumTAT+=turnaroundtime[i];
            sumWT+= waitingtime[i];
        }
        avgTAT =(float)sumTAT/n;
        avgWT = (float)sumWT/n;
    }
    void display()
    {
        System.out.println("\nProcessid Arrival time(AT) burst time(BT) completion time(CT) turnaround time(TAT) Waiting time(WT) Respose time(RT)");
        for(int i = 0 ;i < n;i++)
        {
            System.out.println("\t"+name[i] +"\t\t\t"+ arrivaltime[i]+"\t\t\t\t"+bursttime[i]+"\t\t\t\t"+completiontime[i]+"\t\t\t\t\t"+turnaroundtime[i]+"\t\t\t\t\t\t"+waitingtime[i]+"\t\t\t\t\t"+responsetime[i]);
        }
        System.out.println();
        System.out.println("Average Turn Around Time: "+avgTAT);
        System.out.println("Average Waiting Time: "+avgWT);
    }
    public static void main(String args[])
    {
        src.com.company.fcfs ob = new src.com.company.fcfs();
        ob.input();
        ob.calculate();
        ob.display();
    }
}

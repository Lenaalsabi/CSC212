import java.util.*;

public class ProcessInput {
    public static List<Process> readProcesses() {
        Scanner input = new Scanner(System.in);
        List<Process> processList = new ArrayList<>();

        System.out.print("Number of processes = ");
        int num = input.nextInt();

        for (int i = 1; i <= num; i++) {
            System.out.print("P" + i + ": \nArrival time = ");
            int arrival = input.nextInt();
            System.out.print("Burst time = ");
            int burst = input.nextInt();
            processList.add(new Process(i , arrival, burst));
        }
        return processList;
    }

    public static void main(String[] args) {
        List<Process> myProcesses = readProcesses();
        SRTFScheduler.scheduleSRTF(myProcesses);
    }
}
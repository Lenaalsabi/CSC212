import java.util.*;

public class SRTFScheduler {
    public static void scheduleSRTF(List<Process> processes) {
        int time = 0, completed = 0, n = processes.size();
        Process current = null;
        GanttChart ganttChart = new GanttChart();
        int totalWaitingTime = 0, totalTurnaroundTime = 0;
        int idleTime = 0;

        while (completed < n) {
            Process shortest = null;
            for (Process p : processes) {
                if (p.arrival <= time && p.remaining > 0) {
                    if (shortest == null || p.remaining < shortest.remaining)
                        shortest = p;
                }
            }

            if (shortest != null) {
                if (current != shortest) { 
                    ganttChart.addEntry(shortest.ID, time, time + 1);
                    time += 1;
                }
                current = shortest;
                shortest.remaining--;
                time++;

                if (shortest.remaining == 0) {
                    shortest.finish = time;
                    shortest.turnaround = shortest.finish - shortest.arrival;
                    shortest.waiting = shortest.turnaround - shortest.burst;
                    totalWaitingTime += shortest.waiting;
                    totalTurnaroundTime += shortest.turnaround;
                    completed++;
                }
            } else {
                idleTime++;
                time++;
            }
        }

        ganttChart.displayChart();

        double avgWaitingTime = (double) totalWaitingTime / n;
        double avgTurnaroundTime = (double) totalTurnaroundTime / n;
        double cpuUtilization = ((double) (time - idleTime) / time) * 100;

        System.out.println("\nPerformance Metrics:");
        System.out.printf("Average Turnaround Time: %.2f\n", avgTurnaroundTime);
        System.out.printf("Average Waiting Time: %.2f\n", avgWaitingTime);
        System.out.printf("CPU Utilization: %.2f%%\n", cpuUtilization);
    }
}

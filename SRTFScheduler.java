import java.util.*;

public class SRTFScheduler {
    public static void scheduleSRTF(List<Process> processes) {
        int time = 0, completed = 0, n = processes.size();
        Process current = null;

        while (completed < n) {
            Process shortest = null;
            for (Process p : processes) {
                if (p.arrival <= time && p.remaining > 0) {
                    if (shortest == null || p.remaining < shortest.remaining)
                        shortest = p;
                }
            }

            if (shortest != null) {
                current = shortest;
                shortest.remaining--;
                time++;
                if (shortest.remaining == 0) {
                    shortest.finish = time;
                    shortest.turnaround = shortest.finish - shortest.arrival;
                    shortest.waiting = shortest.turnaround - shortest.burst;
                    completed++;
                }
            } else {
                time++;
            }
        }
    }
}

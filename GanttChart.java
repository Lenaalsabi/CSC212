import java.util.*;

public class GanttChart {
    private List<GanttEntry> timeline;

    public GanttChart() {
        this.timeline = new ArrayList<>();
    }

    public void addEntry(int processID, int startTime, int endTime) {
        timeline.add(new GanttEntry(processID, startTime, endTime));
    }

    public void displayChart() {
        System.out.println("\nGantt Chart:");
        for (GanttEntry entry : timeline) {
            System.out.print("| P" + entry.processID + " ");
        }
        System.out.println("|");

        for (GanttEntry entry : timeline) {
            System.out.print(entry.startTime + "    ");
        }
        System.out.println(timeline.get(timeline.size() - 1).endTime);
    }
}

public class Process {
    int ID;
    int arrival;
    int burst;
    int remaining;
    int finish;
    int waiting;
    int turnaround;

    public Process(int id, int arrival, int burst) {
        this.ID = id;
        this.arrival = arrival;
        this.burst = burst;
        this.remaining = burst;
    }
}


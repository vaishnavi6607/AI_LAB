package Ai_main;
import java.util.*;

class Job{
    private String name;
    private int deadline;
    private int profit;

    public Job(String name,int deadline,int profit){
        this.name = name;
        this.deadline=deadline;
        this.profit =profit;
    }

    public String getName(){
        return name;
    }

    public int getDeadline(){
        return deadline;
    }

    public int getProfit(){
        return profit;
}
}
class JobSheduling{
        private List<Job>jobs;

        public JobSheduling(){
            jobs = new ArrayList<>();
        }

        public void addJob(Job job){
            jobs.add(job);
        }

        public List<Job>scheduleJob(){
            List<Job>scheduledJobs  = new ArrayList<Job>();
            Collections.sort(jobs,Comparator.comparingInt(Job::getProfit).reversed());
            boolean slots[]= new boolean[jobs.size()];
            for(Job job:jobs){
            for(int i =Math.min(job.getDeadline()-1,jobs.size()-1);i>=0;i--){
                if(!slots[i]){
                 slots[i]=true;
                 scheduledJobs.add(job);
                 break;
                }
            }}
            return scheduledJobs;

        }
}
public class Jproblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of jobs");
        int n = sc.nextInt();
        JobSheduling jobSheduling = new JobSheduling();
        System.out.println("enter JobId deadline profit");
        for(int i=0;i<n;i++){
            String a=sc.next();
            int b=sc.nextInt();
            int c=sc.nextInt();
            jobSheduling.addJob(new Job(a, b, c));;
        }

        System.out.println("Sheduled job");
        List<Job>schedule = jobSheduling.scheduleJob();
        for(Job job : schedule){
            System.out.println(job.getName()+" ");
        }
    }
}

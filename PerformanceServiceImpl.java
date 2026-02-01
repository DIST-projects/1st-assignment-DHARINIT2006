import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class PerformanceServiceImpl extends UnicastRemoteObject
                                    implements PerformanceService {

    private Map<String, Integer> marks;

    PerformanceServiceImpl() throws RemoteException {
        super();
        marks = new HashMap<>();
    }

    public void addStudent(String id, int m) throws RemoteException {
        marks.put(id, m);
    }

    public double getAverage() throws RemoteException {
        int sum = 0;
        for (int m : marks.values())
            sum += m;
        return (double) sum / marks.size();
    }

    public int getHighest() throws RemoteException {
        return marks.values().stream().max(Integer::compare).get();
    }

    public int getLowest() throws RemoteException {
        return marks.values().stream().min(Integer::compare).get();
    }

    public Map<String, String> getGrades() throws RemoteException {
        Map<String, String> grades = new HashMap<>();
        for (Map.Entry<String, Integer> e : marks.entrySet()) {
            int m = e.getValue();
            if (m >= 90) grades.put(e.getKey(), "A");
            else if (m >= 75) grades.put(e.getKey(), "B");
            else if (m >= 50) grades.put(e.getKey(), "C");
            else grades.put(e.getKey(), "Fail");
        }
        return grades;
    }
}

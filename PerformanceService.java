import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface PerformanceService extends Remote {
    void addStudent(String id, int marks) throws RemoteException;
    double getAverage() throws RemoteException;
    int getHighest() throws RemoteException;
    int getLowest() throws RemoteException;
    Map<String, String> getGrades() throws RemoteException;
}

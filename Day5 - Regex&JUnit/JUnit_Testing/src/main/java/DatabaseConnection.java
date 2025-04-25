public class DatabaseConnection {
    private boolean connected = false;

    public void connect(){
        connected = true;
        System.out.println("Connected to Database");
    }
    public void disConnect(){
        connected = false;
        System.out.println("DisConnected from Database");
    }

    public boolean isConnected() {
        return connected;
    }
}

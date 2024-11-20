package adapter;
import api.IPStackService;

public class IPAdapter {
    private final IPStackService ipService;
    public IPAdapter() {
        this.ipService = new IPStackService();
    }
}

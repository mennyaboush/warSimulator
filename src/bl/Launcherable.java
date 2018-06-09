package bl;

import java.util.List;

public interface Launcherable {
	public DataAfterFire fire(Location location);
	public void addMissle();
	public List<DataAfterFire> fireIfNeed(int time);
}

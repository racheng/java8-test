package demo.state.pattern;

/**
 * Created by leicheng on 17-6-13.
 */
public abstract class IPlayer {

	public abstract void request(int flag);

	public abstract void setState(PlayerState state);

	public abstract void palyVedio();

	public abstract void pause();

	public abstract void stop();

	public abstract void showAD();
}

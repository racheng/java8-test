package demo.state.pattern;

/**
 * Created by leicheng on 17-6-13.
 */
public class VideoPlayer extends IPlayer {

	private PlayerState mState = new StoppedState(this);

	@Override
	public void palyVedio() {
		System.out.println("play vedio!");
	}

	@Override
	public void pause() {
		System.out.println("pause vedio!");
	}

	@Override
	public void stop() {
		System.out.println("stop vedio!");
	}

	@Override
	public void showAD() {
		System.out.println("show AD!");
	}

	@Override
	public void setState(PlayerState state) {
		mState = state;
	}

	@Override
	public void request(int action) {
		System.out.println("before action:" + mState.toString());
		mState.handle(action);
		System.out.println("after action:" + mState.toString());
	}

}

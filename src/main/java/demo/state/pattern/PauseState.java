package demo.state.pattern;

/**
 * Created by leicheng on 17-6-13.
 */
public class PauseState extends PlayerState {
	public PauseState(IPlayer player) {
		super(player);
	}
	@Override
	public void handle(int action) {
		switch (action) {
			case PlayingState.PLAY_OR_PAUSE:
				mPlayer.palyVedio();
				mPlayer.setState(new PlayingState(mPlayer));
				break;
			case PlayerState.STOP:
				mPlayer.stop();
				mPlayer.setState(new StoppedState(mPlayer));
				break;
			default:
				throw new IllegalArgumentException("ERROE ACTION:"+action+",current state:"+this.getClass().getSimpleName());
		}
	}
}

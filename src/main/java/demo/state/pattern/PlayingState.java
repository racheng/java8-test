package demo.state.pattern;

/**
 * Created by leicheng on 17-6-13.
 */
public class PlayingState extends PlayerState {
	public PlayingState(IPlayer player) {
		super(player);
	}

	@Override
	public void handle(int action) {
		switch (action) {
			case PlayingState.PLAY_OR_PAUSE:
				mPlayer.pause();
				mPlayer.setState(new PauseState(mPlayer));
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

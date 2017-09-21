package demo.state.pattern;

import java.util.Scanner;

/**
 * Created by leicheng on 17-6-13.
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		IPlayer player=new VideoPlayer();
		int i=-1;
		while((i=sc.nextInt())!=-1){
			player.request(i);
		}
	}
}

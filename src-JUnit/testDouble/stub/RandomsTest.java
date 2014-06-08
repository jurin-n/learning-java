package testDouble.stub;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

public class RandomsTest {
	
	@Test
	public void choiceでAを返す() {	
		List<String> options = new ArrayList<String>();
		options.add("A");
		options.add("B");

		Randoms sut = new Randoms();
		//スタブ設定
		sut.generator = new RandomNumberGenerator(){
			@Override
			public int nextInt(){
				return 0;
			}
		};
		assertThat(sut.choice(options),is("A"));
	}

	@Test
	public void choiceでBを返す() {
		List<String> options = new ArrayList<String>();
		options.add("A");
		options.add("B");
		
		Randoms sut = new Randoms();
		//スタブ設定
		sut.generator = new RandomNumberGenerator(){
			@Override
			public int nextInt(){
				return 1;
			}
		};
		assertThat(sut.choice(options),is("B"));
	}
}

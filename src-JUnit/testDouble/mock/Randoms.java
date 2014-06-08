package testDouble.mock;

import java.util.List;

public class Randoms {
	RandomNumberGenerator generator = new RandomNumberGeneratorImpl();
	
	public <T> T choice(List<T> options){
		int idx = generator.nextInt() % options.size();
		return options.get(idx);
	}
}

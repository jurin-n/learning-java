package src;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Hoge2 {
	public int id;

	public String name;

	@Override
	public String toString(){
		return "Hoge [id=" + id + ",name="+ name +"]";
	}
}

package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import src.Hoge;
import src.Hoge2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class testJackson {

	@Test
	public void testHogeToJSON_String() {
		Hoge hoge = new Hoge();

		hoge.id=10;
		hoge.name="hoge";

		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			//mapper.enable(SerializationFeature.INDENT_OUTPUT);
			json = mapper
					.enable(SerializationFeature.INDENT_OUTPUT)
					.writeValueAsString(hoge);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			// TODO 自動生成された catch ブロック
			fail();
		}
	}

	@Test
	public void testJSON_StringToHoge() {
		String json = "{\"id\":10,\"name\":\"hoge\"}";

		ObjectMapper mapper = new ObjectMapper();
		Hoge hoge;
		try {
			hoge = mapper.readValue(json, Hoge.class);
			System.out.println("Hoge.id="+hoge.id +",Hoge.name="+hoge.name);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test型引数を持つクラスをデシリアライズする() {
		String json="[{\"id\":1,\"name\":\"hoge\"},{\"id\":2,\"name\":\"fuga\"}]";
		//String json = "[{\"id\":15, \"name\":\"hoge\"}, {\"id\":16, \"name\":\"fuga\"}]";
		ObjectMapper mapper = new ObjectMapper();

		try {
			List<Hoge> list = mapper.readValue(json,new TypeReference<List<Hoge>>() {});
			System.out.println(list);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testプロパティの名前を変更する(){
        Hoge2 hoge = new Hoge2();
        hoge.id = 10;
        hoge.name = "Hoge";
		try {
			ObjectMapper mapper = new ObjectMapper();
        	String json = mapper.writeValueAsString(hoge);
        	System.out.println(json);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testデシリアライズ時に存在しないプロパティがある場合のエラーを回避する(){
        String json = "{\"id\":10, \"name\":\"hoge\", \"age\":30}";
		try {
			ObjectMapper mapper = new ObjectMapper();
        	Hoge2 hoge = mapper.readValue(json,Hoge2.class);
        	System.out.println(hoge);
		} catch (Exception e) {
			fail();
		}
	}
}

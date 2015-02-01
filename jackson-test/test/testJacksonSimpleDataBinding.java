package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class testJacksonSimpleDataBinding {

	@Test
	public void testJSONtoMap() {
		System.out.println("testJSONtoMap");
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"a\":\"value1\",\"b\":\"value2\"}";
		try {
			Map<String,Object> result = mapper.readValue(json,Map.class);
			System.out.println("result.get(\"a\")=" +result.get("a"));
			System.out.println("result.get(\"b\")=" +result.get("b"));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
	@Test
	public void testJSONtoList_リストで始まるJSONを読み込む() {
		System.out.println("testJSONtoList_リストで始まるJSONを読み込む");
		ObjectMapper mapper = new ObjectMapper();
		String json = "[{\"a\":\"value1\",\"b\":\"value2\"},{\"a\":\"value1-2\",\"b\":\"value2-2\"}]";
		try {
			List<Object> result = mapper.readValue(json,List.class);
			System.out.println("result.get(\"a\")=" +result.get(0));
			System.out.println("result.get(\"b\")=" +result.get(1));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
	@Test
	public void testJSONtoList_マップにリストがネストしたJSONを読み込む() {
		System.out.println("testJSONtoList_マップにリストがネストしたJSONを読み込む");
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"a\":1,\"b\":2,\"c\":[{\"c1-1\":\"v1-1\",\"c1-2\":\"v1-2\"},{\"c2-1\":\"v2-l\",\"c2-2\":\"v2-2\"}]}";
		try {
			@SuppressWarnings("unchecked")
			Map<String,Object> result = mapper.readValue(json, Map.class);
			System.out.println("result.get(\"a\")=" +result.get("a"));
			System.out.println("result.get(\"b\")=" +result.get("b"));
			@SuppressWarnings({ "unchecked", "rawtypes" })
			Map<String,Object> row = (Map<String, Object>) ((ArrayList) (result.get("c"))).get(0);
			System.out.println("result.get(\"c1-1\")=" +row.get("c1-1"));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}

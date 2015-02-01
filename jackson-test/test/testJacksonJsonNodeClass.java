package test;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class testJacksonJsonNodeClass {

	@Test
	public void testJsonNodeクラス() {
		System.out.println("testJSONtoList_マップにリストがネストしたJSONを読み込む");
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"a\":\"1\",\"b\":\"2\",\"c\":[{\"c1-1\":\"v1-1\",\"c1-2\":\"v1-2\"},{\"c2-1\":\"v2-l\",\"c2-2\":\"v2-2\"}]}";
		try {
			JsonNode results = mapper.readValue(json, JsonNode.class);
			System.out.println("json=" + json);
			System.out.println("results.getClass()=" + results.getClass());
			System.out.println("results.get(\"a\").getClass()=" + results.get("a").getClass());
			System.out.println("results.get(\"a\").textValue()=" + results.get("a").textValue());
			System.out.println("results.get(\"b\").getClass()=" + results.get("b").getClass());
			System.out.println("results.get(\"b\").textValue()=" + results.get("b").textValue());
			System.out.println("results.get(\"c\").getClass()=" + results.get("c").getClass());
			System.out.println("results.get(\"c\")=" + results.get("c"));
			System.out.println("results.get(\"c\").get(0))=" + (results.get("c").get(0)));
			System.out.println("results.get(\"c\").get(0)).get(\"c1-1\").textValue()=" + (results.get("c").get(0)).get("c1-1").textValue());
			for(JsonNode current:results){
				System.out.println(current.getClass());
			}

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}

package org.doit.ik.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.extern.log4j.Log4j;


@Log4j
@Controller
@RequestMapping("/es/*")
public class ESController {
	
	
	
	   //목록보기
	   @GetMapping(value="/list")
	   public void list(Model model) {
	      try {
	         
	         List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	         
	         RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
	         
	         // GET<인덱스명>     searchRequest ==> 가져오고싶을때 ( GET요청 )
	         SearchRequest searchRequest = new SearchRequest("spring");
	         
	         SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().size(100);
	         
	         // 모든 도큐먼트 SELECT 하겠다.
	         searchSourceBuilder.query(QueryBuilders.matchAllQuery());
	         
	         searchRequest.source(searchSourceBuilder);
	         
	         SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
	         
	         // 응답된 결과물(response)에서 getHits()로 객체를 LIST로 가져오고
	         SearchHits searchHits = response.getHits();
	         
	         // 맵으로 1개씩 받아서 
	         for (SearchHit hit : searchHits) {
	            Map<String,Object> sourceMap = hit.getSourceAsMap();
	            sourceMap.put("id", hit.getId());
	            list.add(sourceMap);
	         }
	            
	         model.addAttribute("list", list);
	         
	         client.close();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	       
	   }

	   //추가하기(폼)
	   @GetMapping(value="/add")
	   public void add() {
	      
	   }

	   //추가하기(처리)
	   @PostMapping(value="/addok")
	   public String addok(Model model, String id, String message) {
		   try {
			   	 // client에서 localhost이름 줄때 공백은 안된다.
		         RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

		         String data = String.format("{\"message\":\"%s\"}", message);

		         IndexRequest request = new IndexRequest("spring")
		               .source(data, XContentType.JSON)
		               .setRefreshPolicy("wait_for");
		         request.id(id);
		         
		         IndexResponse response = client.index(request, RequestOptions.DEFAULT);
		         
		         client.close();
		         
		      } catch (Exception e) {
		         e.printStackTrace();
		         model.addAttribute("e", e);
		      }

		      return "redirect:/es/list";
	   }
}

package com.huobi;

import com.corbett.enums.RequestMethod;
import com.corbett.utils.http.HttpClient;
import com.huobi.pojo.HuoBiData;
import com.huobi.service.HuoBiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HuobiApplicationTests {

	@Autowired
	HuoBiService huoBiService;

	@Test
	public void contextLoads() {
		try {
			HuoBiData huoBiData = huoBiService.get("iostusdt");
			System.out.println(huoBiData);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void contedxtLoads() {
		try {
			String data = HttpClient.getUrlDataWithKeyValue("https://l10n.huobi.cn/market/overview",null, RequestMethod.GET,HttpClient.getRequestHeader());
			System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

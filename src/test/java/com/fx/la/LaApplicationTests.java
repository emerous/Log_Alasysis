package com.fx.la;

import com.fx.la.common.ReadFileThread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Test
	public void contextLoads() {
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new ReadFileThread("E:\\test","debug",rabbitTemplate));
		service.execute(new ReadFileThread("E:\\test","emergency",rabbitTemplate));
		service.shutdown();

	}

}

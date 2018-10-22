package com.lightprint.webprint;

import com.lightprint.webprint.pojo.Document;
import com.lightprint.webprint.service.DocumentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.print.Doc;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebprintApplicationTests {

	@Autowired
	DocumentService documentService;
	@Test
	public void contextLoads() {
			List<Document> lists = documentService.getDocumentSchedules();
			System.out.println(lists.size());
			for(Document doc:lists) {
				System.out.println(doc.getId()+"-"+doc.getQqNumber()+"-"+doc.getDcomment()+"-"+doc.getPaperSize()+"-"+doc.getPrintDate());
			}
	}

}

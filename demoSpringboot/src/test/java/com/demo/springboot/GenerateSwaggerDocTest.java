package com.demo.springboot;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;

/**
 * @author 作者 Your-Name:
 * @version 创建时间：2020年4月1日 上午11:25:24 类说明
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class GenerateSwaggerDocTest {

	@Test
	public void generateAsciiDocs() throws Exception {
		URL remoteSwaggerFileUrl = new URL("http://localhost:8091/v2/api-docs");
		Path outputAdocDir = Paths.get("src/docs/asciidoc/generated");
		Path outputConfDir = Paths.get("src/docs/confluence/generated");

		// 输出ascii格式
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.CONFLUENCE_MARKUP).build();
//		MarkupLanguage.CONFLUENCE_MARKUP

		Swagger2MarkupConverter.from(remoteSwaggerFileUrl).withConfig(config).build().toFolder(outputConfDir);
	}
}

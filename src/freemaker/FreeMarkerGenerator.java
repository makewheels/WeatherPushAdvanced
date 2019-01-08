package freemaker;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerGenerator {

	/**
	 * 生成要发送邮件的rootHtml
	 */
	public static String generateRootHtml(Map<String, String> map) {
		Configuration configuration = new Configuration(Configuration.getVersion());
		try {
			configuration.setDirectoryForTemplateLoading(
					new File(FreeMarkerGenerator.class.getResource("/freeMakerTemplate").getPath()));
			configuration.setDefaultEncoding("utf-8");
			Template template = configuration.getTemplate("mailContent.ftl");
			StringWriter stringWriter = new StringWriter();
			template.process(map, stringWriter);
			return stringWriter.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成图表html
	 */
	public static String generateSevenDaysLineChartHtml(Map<String, String> map) {
		Configuration configuration = new Configuration(Configuration.getVersion());
		try {
			configuration.setDirectoryForTemplateLoading(
					new File(FreeMarkerGenerator.class.getResource("/freeMakerTemplate").getPath()));
			configuration.setDefaultEncoding("utf-8");
			Template template = configuration.getTemplate("sevenDaysLineChart.ftl");
			StringWriter stringWriter = new StringWriter();
			template.process(map, stringWriter);
			return stringWriter.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return null;
	}

}

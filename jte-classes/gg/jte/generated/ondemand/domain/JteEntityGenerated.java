package gg.jte.generated.ondemand.domain;
public final class JteEntityGenerated {
	public static final String JTE_NAME = "domain/Entity.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,3,3,3,5,5,7,7,8,8,8,8,9,9,11,11,12,12,13,13,13,13,13,14,14,16,16,17,17,17,17,18,18,21,21,21,0,1,1,1,1};
	public static void render(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String basePackage, com.jarambuloa.codegeneratorjava.model.EntityDefinition entity) {
		jteOutput.writeContent("\r\npackage ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".domain.model;\r\n\r\npublic class ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(" {\r\n\r\n");
		for (var field : entity.getFields()) {
			jteOutput.writeContent("\r\n    private ");
			jteOutput.writeUserContent(field.getType());
			jteOutput.writeContent(" ");
			jteOutput.writeUserContent(field.getName());
			jteOutput.writeContent(";\r\n");
		}
		jteOutput.writeContent("\r\n\r\n    public ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("(\r\n");
		for (int i = 0; i < entity.getFields().size(); i++) {
			jteOutput.writeContent("\r\n        ");
			jteOutput.writeUserContent(entity.getFields().get(i).getType());
			jteOutput.writeContent(" ");
			jteOutput.writeUserContent(entity.getFields().get(i).getName());
			jteOutput.writeUserContent(i < entity.getFields().size() - 1 ? "," : "");
			jteOutput.writeContent("\r\n");
		}
		jteOutput.writeContent("\r\n    ) {\r\n");
		for (var field : entity.getFields()) {
			jteOutput.writeContent("\r\n        this.");
			jteOutput.writeUserContent(field.getName());
			jteOutput.writeContent(" = ");
			jteOutput.writeUserContent(field.getName());
			jteOutput.writeContent(";\r\n");
		}
		jteOutput.writeContent("\r\n    }\r\n}\r\n");
	}
	public static void renderMap(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String basePackage = (String)params.get("basePackage");
		com.jarambuloa.codegeneratorjava.model.EntityDefinition entity = (com.jarambuloa.codegeneratorjava.model.EntityDefinition)params.get("entity");
		render(jteOutput, jteHtmlInterceptor, basePackage, entity);
	}
}

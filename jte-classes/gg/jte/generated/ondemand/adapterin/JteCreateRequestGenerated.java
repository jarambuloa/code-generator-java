package gg.jte.generated.ondemand.adapterin;
public final class JteCreateRequestGenerated {
	public static final String JTE_NAME = "adapterin/CreateRequest.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,3,3,3,5,5,7,7,8,8,8,8,9,9,11,11,14,14,15,15,15,15,15,16,16,19,19,19,19,19,19,19,20,20,20,20,22,22,24,24,24,0,1,1,1,1};
	public static void render(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String basePackage, com.jarambuloa.codegeneratorjava.model.EntityDefinition entity) {
		jteOutput.writeContent("\r\npackage ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".adapters.in.rest.dto;\r\n\r\npublic class Create");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("Request {\r\n\r\n");
		for (var field : entity.getFields()) {
			jteOutput.writeContent("\r\n    private ");
			jteOutput.writeUserContent(field.getType());
			jteOutput.writeContent(" ");
			jteOutput.writeUserContent(field.getName());
			jteOutput.writeContent(";\r\n");
		}
		jteOutput.writeContent("\r\n\r\n    public Create");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("Request() {\r\n    }\r\n\r\n");
		for (var field : entity.getFields()) {
			jteOutput.writeContent("\r\n    public ");
			jteOutput.writeUserContent(field.getType());
			jteOutput.writeContent(" get");
			jteOutput.writeUserContent(field.getName().substring(0,1).toUpperCase());
			jteOutput.writeUserContent(field.getName().substring(1));
			jteOutput.writeContent("() {\r\n        return ");
			jteOutput.writeUserContent(field.getName());
			jteOutput.writeContent(";\r\n    }\r\n\r\n    public void set");
			jteOutput.writeUserContent(field.getName().substring(0,1).toUpperCase());
			jteOutput.writeUserContent(field.getName().substring(1));
			jteOutput.writeContent("(");
			jteOutput.writeUserContent(field.getType());
			jteOutput.writeContent(" ");
			jteOutput.writeUserContent(field.getName());
			jteOutput.writeContent(") {\r\n        this.");
			jteOutput.writeUserContent(field.getName());
			jteOutput.writeContent(" = ");
			jteOutput.writeUserContent(field.getName());
			jteOutput.writeContent(";\r\n    }\r\n");
		}
		jteOutput.writeContent("\r\n}\r\n");
	}
	public static void renderMap(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String basePackage = (String)params.get("basePackage");
		com.jarambuloa.codegeneratorjava.model.EntityDefinition entity = (com.jarambuloa.codegeneratorjava.model.EntityDefinition)params.get("entity");
		render(jteOutput, jteHtmlInterceptor, basePackage, entity);
	}
}

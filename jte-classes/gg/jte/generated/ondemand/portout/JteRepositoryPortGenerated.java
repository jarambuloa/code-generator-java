package gg.jte.generated.ondemand.portout;
public final class JteRepositoryPortGenerated {
	public static final String JTE_NAME = "portout/RepositoryPort.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,3,3,3,5,5,5,5,9,9,11,11,11,11,13,13,13,13,15,15,17,17,19,19,19,0,1,1,1,1};
	public static void render(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String basePackage, com.jarambuloa.codegeneratorjava.model.EntityDefinition entity) {
		jteOutput.writeContent("\r\npackage ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".application.port.out;\r\n\r\nimport ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".domain.model.");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(";\r\n\r\nimport java.util.Optional;\r\n\r\npublic interface ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("RepositoryPort {\r\n\r\n    Optional<");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("> findById(");
		jteOutput.writeUserContent(entity.getIdType());
		jteOutput.writeContent(" id);\r\n\r\n    ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(" save(");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(" entity);\r\n\r\n    boolean existsById(");
		jteOutput.writeUserContent(entity.getIdType());
		jteOutput.writeContent(" id);\r\n\r\n    void deleteById(");
		jteOutput.writeUserContent(entity.getIdType());
		jteOutput.writeContent(" id);\r\n}\r\n");
	}
	public static void renderMap(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String basePackage = (String)params.get("basePackage");
		com.jarambuloa.codegeneratorjava.model.EntityDefinition entity = (com.jarambuloa.codegeneratorjava.model.EntityDefinition)params.get("entity");
		render(jteOutput, jteHtmlInterceptor, basePackage, entity);
	}
}

package gg.jte.generated.ondemand.usecase;
public final class JteCreateUseCaseGenerated {
	public static final String JTE_NAME = "usecase/CreateUseCase.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,3,3,3,5,5,5,5,7,7,9,9,9,9,9,9,11,11,11,0,1,1,1,1};
	public static void render(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String basePackage, com.jarambuloa.codegeneratorjava.model.EntityDefinition entity) {
		jteOutput.writeContent("\r\npackage ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".application.port.in;\r\n\r\nimport ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".domain.model.");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(";\r\n\r\npublic interface Create");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("UseCase {\r\n\r\n    ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(" create(");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(" ");
		jteOutput.writeUserContent(entity.getName().toLowerCase());
		jteOutput.writeContent(");\r\n}\r\n");
	}
	public static void renderMap(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String basePackage = (String)params.get("basePackage");
		com.jarambuloa.codegeneratorjava.model.EntityDefinition entity = (com.jarambuloa.codegeneratorjava.model.EntityDefinition)params.get("entity");
		render(jteOutput, jteHtmlInterceptor, basePackage, entity);
	}
}

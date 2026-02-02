package gg.jte.generated.ondemand.usecase;
public final class JteCreateServiceGenerated {
	public static final String JTE_NAME = "usecase/CreateService.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,3,3,3,5,5,5,5,6,6,6,6,7,7,7,7,14,14,14,14,16,16,18,18,18,18,23,23,23,23,23,23,24,24,27,27,27,0,1,1,1,1};
	public static void render(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String basePackage, com.jarambuloa.codegeneratorjava.model.EntityDefinition entity) {
		jteOutput.writeContent("\r\npackage ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".application.service;\r\n\r\nimport ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".application.port.in.Create");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("UseCase;\r\nimport ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".application.port.out.");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("RepositoryPort;\r\nimport ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".domain.model.");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(";\r\n\r\nimport org.springframework.stereotype.Service;\r\nimport org.springframework.transaction.annotation.Transactional;\r\n\r\n@Service\r\n@Transactional\r\npublic class Create");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("Service implements Create");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("UseCase {\r\n\r\n    private final ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("RepositoryPort repository;\r\n\r\n    public Create");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("Service(");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("RepositoryPort repository) {\r\n        this.repository = repository;\r\n    }\r\n\r\n    @Override\r\n    public ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(" create(");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(" ");
		jteOutput.writeUserContent(entity.getName().toLowerCase());
		jteOutput.writeContent(") {\r\n        return repository.save(");
		jteOutput.writeUserContent(entity.getName().toLowerCase());
		jteOutput.writeContent(");\r\n    }\r\n}\r\n");
	}
	public static void renderMap(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String basePackage = (String)params.get("basePackage");
		com.jarambuloa.codegeneratorjava.model.EntityDefinition entity = (com.jarambuloa.codegeneratorjava.model.EntityDefinition)params.get("entity");
		render(jteOutput, jteHtmlInterceptor, basePackage, entity);
	}
}

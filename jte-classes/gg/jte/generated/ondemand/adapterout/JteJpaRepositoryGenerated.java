package gg.jte.generated.ondemand.adapterout;
public final class JteJpaRepositoryGenerated {
	public static final String JTE_NAME = "adapterout/JpaRepository.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,3,3,3,5,5,5,5,8,8,9,9,9,9,11,11,11,0,1,1,1,1};
	public static void render(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String basePackage, com.jarambuloa.codegeneratorjava.model.EntityDefinition entity) {
		jteOutput.writeContent("\r\npackage ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".adapters.out.persistence.jpa.repository;\r\n\r\nimport ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".adapters.out.persistence.jpa.entity.");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaEntity;\r\nimport org.springframework.data.jpa.repository.JpaRepository;\r\n\r\npublic interface ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaRepository\r\n        extends JpaRepository<");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaEntity, ");
		jteOutput.writeUserContent(entity.getIdType());
		jteOutput.writeContent("> {\r\n}\r\n");
	}
	public static void renderMap(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String basePackage = (String)params.get("basePackage");
		com.jarambuloa.codegeneratorjava.model.EntityDefinition entity = (com.jarambuloa.codegeneratorjava.model.EntityDefinition)params.get("entity");
		render(jteOutput, jteHtmlInterceptor, basePackage, entity);
	}
}

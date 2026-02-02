package gg.jte.generated.ondemand.adapterout;
public final class JteJpaEntityGenerated {
	public static final String JTE_NAME = "adapterout/JpaEntity.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,3,3,3,8,8,9,9,13,13,15,15,16,16,17,17,17,17,18,18,20,20,23,23,24,24,25,25,25,25,25,26,26,28,28,29,29,29,29,30,30,33,33,37,37,37,0,1,1,1,1};
	public static void render(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String basePackage, com.jarambuloa.codegeneratorjava.model.EntityDefinition entity) {
		jteOutput.writeContent("\r\npackage ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".adapters.out.persistence.jpa.entity;\r\n\r\nimport jakarta.persistence.*;\r\n\r\n@Entity\r\n@Table(name = \"");
		jteOutput.writeUserContent(entity.getTable());
		jteOutput.writeContent("\")\r\npublic class ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaEntity {\r\n\r\n    @Id\r\n    @GeneratedValue(strategy = GenerationType.IDENTITY)\r\n    private ");
		jteOutput.writeUserContent(entity.getIdType());
		jteOutput.writeContent(" id;\r\n\r\n");
		for (var field : entity.getFields()) {
			jteOutput.writeContent("\r\n    @Column(name = \"");
			jteOutput.writeUserContent(field.getName());
			jteOutput.writeContent("\")\r\n    private ");
			jteOutput.writeUserContent(field.getType());
			jteOutput.writeContent(" ");
			jteOutput.writeUserContent(field.getName());
			jteOutput.writeContent(";\r\n");
		}
		jteOutput.writeContent("\r\n\r\n    protected ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaEntity() {\r\n    }\r\n\r\n    public ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaEntity(\r\n");
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
		jteOutput.writeContent("\r\n    }\r\n\r\n    public ");
		jteOutput.writeUserContent(entity.getIdType());
		jteOutput.writeContent(" getId() {\r\n        return id;\r\n    }\r\n}\r\n");
	}
	public static void renderMap(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String basePackage = (String)params.get("basePackage");
		com.jarambuloa.codegeneratorjava.model.EntityDefinition entity = (com.jarambuloa.codegeneratorjava.model.EntityDefinition)params.get("entity");
		render(jteOutput, jteHtmlInterceptor, basePackage, entity);
	}
}

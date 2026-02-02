package gg.jte.generated.ondemand.adapterout;
public final class JteJpaAdapterGenerated {
	public static final String JTE_NAME = "adapterout/JpaAdapter.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,3,3,3,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,15,15,15,15,17,17,19,19,19,19,24,24,24,24,30,30,30,30,31,31,37,37,42,42,46,46,46,46,47,47,48,48,49,49,49,49,49,50,50,54,54,54,54,55,55,56,56,57,57,57,57,57,58,58,62,62,62,0,1,1,1,1};
	public static void render(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String basePackage, com.jarambuloa.codegeneratorjava.model.EntityDefinition entity) {
		jteOutput.writeContent("\r\npackage ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".adapters.out.persistence.jpa;\r\n\r\nimport ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".application.port.out.");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("RepositoryPort;\r\nimport ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".adapters.out.persistence.jpa.entity.");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaEntity;\r\nimport ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".adapters.out.persistence.jpa.repository.");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaRepository;\r\nimport ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".domain.model.");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(";\r\n\r\nimport org.springframework.stereotype.Repository;\r\n\r\nimport java.util.Optional;\r\n\r\n@Repository\r\npublic class ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaAdapter implements ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("RepositoryPort {\r\n\r\n    private final ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaRepository repository;\r\n\r\n    public ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaAdapter(");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaRepository repository) {\r\n        this.repository = repository;\r\n    }\r\n\r\n    @Override\r\n    public Optional<");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("> findById(");
		jteOutput.writeUserContent(entity.getIdType());
		jteOutput.writeContent(" id) {\r\n        return repository.findById(id)\r\n                .map(this::toDomain);\r\n    }\r\n\r\n    @Override\r\n    public ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(" save(");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(" entity) {\r\n        ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaEntity saved =\r\n                repository.save(toEntity(entity));\r\n        return toDomain(saved);\r\n    }\r\n\r\n    @Override\r\n    public boolean existsById(");
		jteOutput.writeUserContent(entity.getIdType());
		jteOutput.writeContent(" id) {\r\n        return repository.existsById(id);\r\n    }\r\n\r\n    @Override\r\n    public void deleteById(");
		jteOutput.writeUserContent(entity.getIdType());
		jteOutput.writeContent(" id) {\r\n        repository.deleteById(id);\r\n    }\r\n\r\n    private ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaEntity toEntity(");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(" domain) {\r\n        return new ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaEntity(\r\n");
		for (int i = 0; i < entity.getFields().size(); i++) {
			jteOutput.writeContent("\r\n            domain.get");
			jteOutput.writeUserContent(entity.getFields().get(i).getName().substring(0,1).toUpperCase());
			jteOutput.writeUserContent(entity.getFields().get(i).getName().substring(1));
			jteOutput.writeContent("()");
			jteOutput.writeUserContent(i < entity.getFields().size() - 1 ? "," : "");
			jteOutput.writeContent("\r\n");
		}
		jteOutput.writeContent("\r\n        );\r\n    }\r\n\r\n    private ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(" toDomain(");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("JpaEntity entity) {\r\n        return new ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("(\r\n");
		for (int i = 0; i < entity.getFields().size(); i++) {
			jteOutput.writeContent("\r\n            entity.get");
			jteOutput.writeUserContent(entity.getFields().get(i).getName().substring(0,1).toUpperCase());
			jteOutput.writeUserContent(entity.getFields().get(i).getName().substring(1));
			jteOutput.writeContent("()");
			jteOutput.writeUserContent(i < entity.getFields().size() - 1 ? "," : "");
			jteOutput.writeContent("\r\n");
		}
		jteOutput.writeContent("\r\n        );\r\n    }\r\n}\r\n");
	}
	public static void renderMap(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String basePackage = (String)params.get("basePackage");
		com.jarambuloa.codegeneratorjava.model.EntityDefinition entity = (com.jarambuloa.codegeneratorjava.model.EntityDefinition)params.get("entity");
		render(jteOutput, jteHtmlInterceptor, basePackage, entity);
	}
}

package gg.jte.generated.ondemand.adapterin;
public final class JteControllerGenerated {
	public static final String JTE_NAME = "adapterin/Controller.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,3,3,3,5,5,5,5,6,6,6,6,7,7,7,7,13,13,14,14,16,16,18,18,18,18,23,23,24,24,26,26,27,27,28,28,29,29,29,29,29,30,30,37,37,37,0,1,1,1,1};
	public static void render(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String basePackage, com.jarambuloa.codegeneratorjava.model.EntityDefinition entity) {
		jteOutput.writeContent("\r\npackage ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".adapters.in.rest;\r\n\r\nimport ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".application.port.in.Create");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("UseCase;\r\nimport ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".adapters.in.rest.dto.Create");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("Request;\r\nimport ");
		jteOutput.writeUserContent(basePackage);
		jteOutput.writeContent(".domain.model.");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(";\r\n\r\nimport org.springframework.http.ResponseEntity;\r\nimport org.springframework.web.bind.annotation.*;\r\n\r\n@RestController\r\n@RequestMapping(\"/");
		jteOutput.writeUserContent(entity.getName().toLowerCase());
		jteOutput.writeContent("s\")\r\npublic class ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("Controller {\r\n\r\n    private final Create");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("UseCase createUseCase;\r\n\r\n    public ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("Controller(Create");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("UseCase createUseCase) {\r\n        this.createUseCase = createUseCase;\r\n    }\r\n\r\n    @PostMapping\r\n    public ResponseEntity<");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("> create(\r\n            @RequestBody Create");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("Request request) {\r\n\r\n        ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent(" created = createUseCase.create(\r\n                new ");
		jteOutput.writeUserContent(entity.getName());
		jteOutput.writeContent("(\r\n");
		for (int i = 0; i < entity.getFields().size(); i++) {
			jteOutput.writeContent("\r\n                    request.get");
			jteOutput.writeUserContent(entity.getFields().get(i).getName().substring(0,1).toUpperCase());
			jteOutput.writeUserContent(entity.getFields().get(i).getName().substring(1));
			jteOutput.writeContent("()");
			jteOutput.writeUserContent(i < entity.getFields().size() - 1 ? "," : "");
			jteOutput.writeContent("\r\n");
		}
		jteOutput.writeContent("\r\n                )\r\n        );\r\n\r\n        return ResponseEntity.ok(created);\r\n    }\r\n}\r\n");
	}
	public static void renderMap(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String basePackage = (String)params.get("basePackage");
		com.jarambuloa.codegeneratorjava.model.EntityDefinition entity = (com.jarambuloa.codegeneratorjava.model.EntityDefinition)params.get("entity");
		render(jteOutput, jteHtmlInterceptor, basePackage, entity);
	}
}

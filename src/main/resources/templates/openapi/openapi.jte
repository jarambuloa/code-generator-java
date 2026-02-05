@param com.jarambuloa.codegeneratorjava.model.ProjectDefinition project

openapi: 3.0.3
info:
  title: ${project.getServiceName()}
  version: 1.0.0

paths:
@for (var entry : project.getEntities().entrySet())
  /${entry.getKey().toLowerCase()}s:
    post:
      summary: Create ${entry.getKey()}
      operationId: create${entry.getKey()}
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Create${entry.getKey()}Request'
      responses:
        '201':
          description: Created
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/${entry.getKey()}'
@endfor

components:
  schemas:
@for (var entry : project.getEntities().entrySet())
    ${entry.getKey()}:
      type: object
      properties:
@for (var f : entry.getValue().getFields())
        ${f.getName()}:
          type: string
@endfor
@if (!entry.getValue().getRequiredFields().isEmpty())
      required:
@for (var f : entry.getValue().getRequiredFields())
        - ${f.getName()}
@endfor
@endif

    Create${entry.getKey()}Request:
      type: object
      properties:
@for (var f : entry.getValue().getFields())
        ${f.getName()}:
          type: string
@endfor
@endfor

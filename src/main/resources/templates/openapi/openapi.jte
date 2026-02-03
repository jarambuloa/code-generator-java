openapi: 3.0.3
info:
  title: ${project.getServiceName()}
  version: 1.0.0

paths:
@for (var entry : project.getEntities().entrySet())
@{
    var entityName = entry.getKey();
    var entity = entry.getValue();
}
  /${entityName.toLowerCase()}s:
    post:
      summary: Create ${entityName}
      operationId: create${entityName}
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Create${entityName}Request'
      responses:
        '201':
          description: Created
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/${entityName}'
@endfor

components:
  schemas:
@for (var entry : project.getEntities().entrySet())
@{
    var entityName = entry.getKey();
    var entity = entry.getValue();
}
    ${entityName}:
      type: object
      properties:
@for (var f : entity.getFields())
        ${f.getName()}:
          type: string
@if (f.isRequired())
      required:
@for (var f : entity.getFields())
@if (f.isRequired())
        - ${f.getName()}
@endif
@endfor
@endfor

    Create${entityName}Request:
      type: object
      properties:
@for (var f : entity.getFields())
        ${f.getName()}:
          type: string
@endfor
@endfor

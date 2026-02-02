@param String basePackage
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.adapters.out.persistence.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "${entity.getTable()}")
public class ${entity.getName()}JpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ${entity.getIdType()} id;

@for (var field : entity.getFields())
    @Column(name = "${field.getName()}")
    private ${field.getType()} ${field.getName()};
@endfor

    protected ${entity.getName()}JpaEntity() {
    }

    public ${entity.getName()}JpaEntity(
@for (int i = 0; i < entity.getFields().size(); i++)
        ${entity.getFields().get(i).getType()} ${entity.getFields().get(i).getName()}${i < entity.getFields().size() - 1 ? "," : ""}
@endfor
    ) {
@for (var field : entity.getFields())
        this.${field.getName()} = ${field.getName()};
@endfor
    }

    public ${entity.getIdType()} getId() {
        return id;
    }
}

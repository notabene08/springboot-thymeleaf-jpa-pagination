package boot.jpa.pagination.dto;

import boot.jpa.pagination.domain.hero.Hero;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class HeroFindAllResponseDto {

    private Long id;
    private String name;
    private int age;
    private String note;
    private String createdDate;
    private String modifiedDate;

    public HeroFindAllResponseDto(Hero entity) {
        id = entity.getId();
        name = entity.getName();
        age = entity.getAge();
        note = entity.getNote();
        createdDate = toStringLocalDateTime(entity.getCreatedDate());
        modifiedDate = toStringLocalDateTime(entity.getModifiedDate());
    }

    public String toStringLocalDateTime(LocalDateTime modifiedDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(modifiedDate)
                .map(formatter::format)
                .orElse("");
    }
}

package net.karton.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "news")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id","title","description"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "")
    @Length(max = 255)
    private String title;

    private String description;
    /**файл изображеня*/
    private String filename;
}

package sda.orange.grcy.weatherApproach;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "weather")
public class Weather {
    @Id
    private int id;
    private String conditions;
    private String temperature;
    private LocalDate readDate;
}

package ru.rrenat358.api.core;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Модель Client")
public class ClientDto {

    @Schema(description = "ID клиента", required = true, example = "3")
    private Long id;

    @Schema(description = "Имя клиента", required = true, example = "Viktor")
    private String name;


}

package ru.rrenat358.api.core;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Модель Email адреса для контакта")
public class EmailDto {

    @Schema(description = "ID email", required = true, example = "5")
    private Long id;

    @Schema(description = "Email адрес клиента", required = true, example = "some3_1@gmail.com")
    private String address;

    @Schema(description = "ID клиента для данного email", example = "3")
    private Long client_id;


}

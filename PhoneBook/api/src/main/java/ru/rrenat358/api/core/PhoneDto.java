package ru.rrenat358.api.core;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Модель Phone номера для контакта")
public class PhoneDto {

    @Schema(description = "ID email", required = true, example = "5")
    private Long id;

    @Schema(description = "Phone номер клиента", required = true, example = "+79670670112")
    private String number;

    @Schema(description = "ID клиента для данного Phone", example = "3")
    private Long client_id;


}

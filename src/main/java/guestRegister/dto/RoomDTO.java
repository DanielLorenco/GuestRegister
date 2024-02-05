package guestRegister.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import guestRegister.constant.StayType;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class RoomDTO {

    @NotNull
    @JsonProperty("_id")
    private Long roomId;

    @NotBlank
    private String roomNumber;

    @Positive
    @Size(min = 18, max= 45)
    private int size;

    @Positive
    @Size(min = 1, max = 4)
    private int capacity;

    @AssertFalse
    private boolean occupied;

    @NotNull
    private boolean tidy;

    @NotNull
    private StayType stayType;

    @JsonIgnore
    private List<@Positive GuestDTO> accommodatedGuests;
}

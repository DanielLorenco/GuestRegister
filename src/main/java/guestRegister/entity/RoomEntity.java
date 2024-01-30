package guestRegister.entity;

import guestRegister.constant.StayType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "room")
@Getter
@Setter
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(nullable = false)
    private String roomNumber;

    @Column(nullable = false)
    private int size;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private boolean occupied;

    @Column(nullable = false)
    private boolean tidy;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StayType stayType;

    @OneToMany(mappedBy = "room")
    private List<GuestEntity> accommodatedGuests;

}
